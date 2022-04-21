package com.pranavaeet.common;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.cloud.storage.Blob;
import com.pranavaeet.config.SuccessHandler;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.constants.URL_CONSTANTS;
import com.pranavaeet.constants.VIEW_CONSTANTS;

import com.pranavaeet.utils.GoogleCloudStorage;

@Controller
public class HomeController {

	final static Logger logger = LogManager.getLogger();
	
	@Autowired
	SuccessHandler successHandler;
	@Autowired
	ObjectDAO objectDAO;
	@Autowired
	LoginHelper helper;
	@Autowired
	ControllerHelper controllerHelper;
	@Autowired
	private GoogleCloudStorage gcs;
	
	@GetMapping(value = "/")
	public ModelAndView defaultPage(HttpServletRequest request, HttpSession session){
		if(null != request.getRemoteUser()){
			return new ModelAndView("redirect:"+URL_CONSTANTS.HOME_PAGE);	
		}
		return new ModelAndView(URL_CONSTANTS.REDIRECT_SESSION_EXPIRED);
	}
	
	@GetMapping(value = URL_CONSTANTS.USER_HOME)
	public ModelAndView userHomePage(HttpServletRequest request, HttpSession session){
		if(null == request.getRemoteUser())
			return new ModelAndView(URL_CONSTANTS.REDIRECT_SESSION_EXPIRED);
		
		return new ModelAndView(VIEW_CONSTANTS.HOME_PAGE);
	}
	
	@GetMapping(value = URL_CONSTANTS.TERMS)
	public ModelAndView terms(HttpServletRequest request, HttpSession session){
		return new ModelAndView(VIEW_CONSTANTS.TERMS);
	}
	
	@GetMapping(value = URL_CONSTANTS.PRIVACY)
	public ModelAndView privacy(HttpServletRequest request, HttpSession session){
		return new ModelAndView(VIEW_CONSTANTS.PRIVACY);
	}
	
	@GetMapping(value = URL_CONSTANTS.HOME_PAGE)
	public ModelAndView homePage(HttpServletRequest request, HttpSession session){
		if(null == request.getRemoteUser())
			return new ModelAndView(URL_CONSTANTS.REDIRECT_SESSION_EXPIRED);
		
		if(null != request.getRemoteUser()) {
			controllerHelper.populateSession(request);
			String targetUrl = successHandler.determineTargetUrl(request);
			return new ModelAndView("redirect:"+targetUrl);
		}
		return new ModelAndView(URL_CONSTANTS.REDIRECT_SESSION_EXPIRED);
	}
	
	@GetMapping(value = URL_CONSTANTS.MY_PROFILE)
	public ModelAndView myProfile(HttpServletRequest request, HttpSession session) {
		if(null == request.getRemoteUser())
			return new ModelAndView(URL_CONSTANTS.REDIRECT_SESSION_EXPIRED);
		
		String username = request.getRemoteUser();
		ModelAndView model = new ModelAndView();
		controllerHelper.populateSession(request);
		UserProfile userProfile = (UserProfile) objectDAO.singleResultSelect(SQL_QUERIES.getUserProfile, new String[] {username}, UserProfile.class);
		try {
			String imageFilePath = userProfile.getImageFilePath();
			Blob downloadedFile = gcs.downloadDocumentWithMetaData(imageFilePath);
			byte[] imageContent = downloadedFile.getContent(new Blob.BlobSourceOption[] {});
			String imageString = new String(Base64.getEncoder().encodeToString(imageContent));
			model.addObject("imageString", imageString);
		}catch(Exception e) {
			logger.warn("No Image Found!");
		}		
		model.addObject("userProfile", userProfile);
		model.addObject("password", new Password());
		model.addObject("username", username);
		model.addObject("countryList", objectDAO.multipleResultSelect(SQL_QUERIES.getCountryList, null));
		model.addObject("stateList", objectDAO.multipleResultSelect(SQL_QUERIES.getStateList, null));
		model.setViewName(VIEW_CONSTANTS.MY_PROFILE);
		return model;
	}
	
	@PostMapping(value = URL_CONSTANTS.UPDATE_USER_PROFILE)
	public ModelAndView updateUserProfile(@ModelAttribute UserProfile userProfile, HttpServletRequest request, HttpSession session) {
		if(null == request.getRemoteUser())
			return new ModelAndView(URL_CONSTANTS.REDIRECT_SESSION_EXPIRED);
		
		String username = request.getRemoteUser();
		objectDAO.addOrUpdate(SQL_QUERIES.updateUserProfile, new String[] {
			userProfile.getFirstname(), userProfile.getLastname(), userProfile.getEmail(),
			userProfile.getMobile(), userProfile.getGender(), userProfile.getDateOfBirth(), username});
		return new ModelAndView("redirect:"+URL_CONSTANTS.MY_PROFILE);
	}
	
	@PostMapping(value = URL_CONSTANTS.UPDATE_USER_ADDRESS)
	public ModelAndView updateUserAddress(@ModelAttribute UserProfile userProfile, HttpServletRequest request, HttpSession session) {
		if(null == request.getRemoteUser())
			return new ModelAndView(URL_CONSTANTS.REDIRECT_SESSION_EXPIRED);
		
		String username = request.getRemoteUser();
		objectDAO.addOrUpdate(SQL_QUERIES.updateUserAddress, new String[] {
				userProfile.getAddress1(), userProfile.getAddress2(), userProfile.getCity(),
				userProfile.getState(), userProfile.getCountry(), userProfile.getZipcode(), username});
		return new ModelAndView("redirect:"+URL_CONSTANTS.MY_PROFILE);
	}
	
	@PostMapping(value = URL_CONSTANTS.UPDATE_USER_PICTURE)
	public ModelAndView updateUserPicture(@ModelAttribute UserProfile userProfile, HttpServletRequest request, HttpSession session) {
		if(null == request.getRemoteUser())
			return new ModelAndView(URL_CONSTANTS.REDIRECT_SESSION_EXPIRED);
		
		String username = request.getRemoteUser();
		String fileType = userProfile.getImageUpload().getContentType();
		if(!fileType.contains("application")) {
			try {
				byte[] imageFile = userProfile.getImageUpload().getBytes();
				String imageFilePath = username + "/profile_image";
				boolean imageFileUploaded = gcs.uploadDocumentWithMetaData(imageFilePath,
						imageFile, fileType, userProfile.getImageUpload().getOriginalFilename());
				if (imageFileUploaded) {
					objectDAO.addOrUpdate(SQL_QUERIES.updateUserPicture, new String[] { imageFilePath, fileType, username });
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		return new ModelAndView("redirect:"+URL_CONSTANTS.MY_PROFILE);
	}
	
	@PostMapping(value = URL_CONSTANTS.UPDATE_PASSWORD)
	public ModelAndView updatePassword(Password password, HttpServletRequest request, HttpSession session){
		if(null == request.getRemoteUser())
			return new ModelAndView(URL_CONSTANTS.REDIRECT_SESSION_EXPIRED);
		helper.updatePassword(password.getUsername(), password.getPassword());
		return new ModelAndView("redirect:"+URL_CONSTANTS.CHANGE_PASSWORD);
	}
}
