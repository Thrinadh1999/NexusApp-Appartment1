package com.pranavaeet.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.config.SuccessHandler;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.constants.URL_CONSTANTS;
import com.pranavaeet.constants.VIEW_CONSTANTS;

@Controller
public class LoginController {

	final static Logger logger = LogManager.getLogger();
	
	@Autowired
	SuccessHandler successHandler;
	@Autowired
	LoginHelper helper;
	@Autowired
	ObjectDAO objectDAO;
	
	@RequestMapping(value = URL_CONSTANTS.LOGIN)
	public ModelAndView login(HttpServletRequest request, HttpSession session, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, @RequestParam(value = "reset", required = false) String reset,
			@RequestParam(value = "session", required = false) String sessionMessage, @RequestParam(value = "unauthorized", required = false) String unauthorized, 
			HttpServletResponse response) {
		String message = "";
		if (null != error) {
			message = "Please check your credentials!";			
			logger.info("Invalid credentials!");
		} else if (null != unauthorized) {			
			message = "Your account is not authorized to login.";			
			logger.info("Account is not authorized to login.");
		} else if (null != logout) {			
			message = "You have been logged out successfully.";			
			logger.info("You have been logged out successfully.");
		} else if (null != sessionMessage) {			 
			message = "Your session has expired. Please sign in to continue.";			
			logger.info("Your session has expired. Please sign in to continue."); 
		} else if (null != reset) {			
			message = "Your password has been reset successfully. Please check your email for instructions.";			
			logger.info("Password has been reset successfully.");
		} else {			
			logger.info("Unknown Login Error: "+error);
		}	
		session.setAttribute("homePageErrorMessage", message);		
		return new ModelAndView(URL_CONSTANTS.REDIRECT_SIGNIN);		
	}
	
	//This method is used to hide the URL parameters used in the login message.
	@RequestMapping(value = URL_CONSTANTS.SIGNIN)
	public ModelAndView signIn(HttpServletRequest request, HttpSession session){
		
		//This will deal with users who are already logged in.
		String message = (String) session.getAttribute("homePageErrorMessage");
		logger.warn("Error Message: "+message+" for user: "+request.getRemoteUser());
		if(null == message && null != request.getRemoteUser()){
			String targetUrl = successHandler.determineTargetUrl(request);
			return new ModelAndView("redirect:"+targetUrl);	
		}		
		session.setAttribute("homePageErrorMessage", null);
		ModelAndView model = new ModelAndView();
		model.addObject("message", message);
		model.setViewName(VIEW_CONSTANTS.LOGIN_PAGE);
		return model;
	}
	
	@GetMapping(value = URL_CONSTANTS.FORGOT_PASSWORD)
	public ModelAndView forgotPassword(HttpServletRequest request, HttpSession session){
		ModelAndView model = new ModelAndView();
		model.addObject("newPassword", new Password());
		model.setViewName(VIEW_CONSTANTS.FORGOT_PASSWORD);
		return model;
	}
	
	@PostMapping(value = URL_CONSTANTS.RESET_PASSWORD)
	public ModelAndView resetPassword(@ModelAttribute Password password, HttpServletRequest request, HttpSession session){
		String username = password.getUsername();
		try {
			UserProfile profile = (UserProfile) objectDAO.singleResultSelect(SQL_QUERIES.getUserProfile, new String[] {username}, UserProfile.class);
			if(helper.resetPasswordLink(profile.getFirstname(), profile.getLastname(), username)) {
				return new ModelAndView("redirect:"+URL_CONSTANTS.LOGIN+"?reset=true");
			}
			return new ModelAndView("redirect:"+URL_CONSTANTS.LOGIN+"?unauthorized=true");
		}catch(Exception e) {
			logger.error(e.getMessage());
			return new ModelAndView("redirect:"+URL_CONSTANTS.LOGIN+"?unauthorized=true");
		}		
	}

}
