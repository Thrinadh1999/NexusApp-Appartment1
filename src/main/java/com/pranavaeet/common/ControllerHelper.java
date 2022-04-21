package com.pranavaeet.common;


import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranavaeet.config.Variables;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.utils.TimeFormatter;

@Service
public class ControllerHelper {

	final static Logger logger = LogManager.getLogger(ControllerHelper.class);
	
	@Autowired
	ObjectDAO objectDAO;
	
	public void populateSession(HttpServletRequest request) {
		String username = request.getRemoteUser();
		
		try {
			UserProfile userProfile = (UserProfile) request.getSession().getAttribute("profile");
			if(null == userProfile.getFirstname()) {
				UserProfile profile = (UserProfile) objectDAO.singleResultSelect(SQL_QUERIES.getUserProfile, new String[] {username}, UserProfile.class);
				request.getSession().setAttribute("profile", profile);
				
			}
		}catch(Exception e) {
			logger.error("Profile In Session: "+e.getMessage());
			UserProfile profile = (UserProfile) objectDAO.singleResultSelect(SQL_QUERIES.getUserProfile, new String[] {username}, UserProfile.class);
			request.getSession().setAttribute("profile", profile);
			logger.info("currentUser is:"+ request.getSession().getAttribute("profile"));
		}		
		request.getSession().setAttribute("profilePicture", Variables.defaultUserString);
	}
	
	public void addActivity(String username, String activity) {
		objectDAO.addOrUpdate(SQL_QUERIES.addUserActivity,new String[] {username ,activity ,TimeFormatter.getCurrentTimeStamp()});
	}
}
