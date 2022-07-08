package com.pranavaeet.Nexus.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.Nexus.common.UserProfilesNexus;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;

@Controller
public class UserProfilesController {
	@Autowired
	ObjectDAO objectDAO;

	@GetMapping(value = "userProfileDetails")
	public ModelAndView getUserProfilesDetails(HttpServletRequest request, HttpSession session) {
		List<UserProfilesNexus> userProfileDetails = (List<UserProfilesNexus>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getNexususerprofileList, null, UserProfilesNexus.class);
		ModelAndView page = new ModelAndView();

		page.setViewName("UserProfilesNexus");

		page.addObject("upd", userProfileDetails);
		page.addObject("upn", new UserProfilesNexus());
		return page;
	}

}
