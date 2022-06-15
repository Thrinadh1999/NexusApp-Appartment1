package com.pranavaeet.NexusApp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.NexusApp.common.CountryList;
import com.pranavaeet.NexusApp.common.NexusAppUserRole;
import com.pranavaeet.NexusApp.common.NexusAppUsers;
import com.pranavaeet.NexusApp.common.StateList;

@Controller
public class UsersNexusAppController {
	@Autowired
	ObjectDAO objectDAO;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/nexususerdetails")
	public ModelAndView getUserDetails(HttpServletRequest request, HttpSession session) {
		List<NexusAppUsers> userDetails = (List<NexusAppUsers>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getNexusUsersDetails, null, NexusAppUsers.class);
		List<StateList> appstateList = (List<StateList>) objectDAO.multipleResultSelect(SQL_QUERIES.getStateAppList,
				null, StateList.class);
		List<CountryList> appcountryList = (List<CountryList>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getCountryAppList, null, CountryList.class);
		List<NexusAppUserRole> roleList = (List<NexusAppUserRole>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getRoleList, null, NexusAppUserRole.class);

		ModelAndView page = new ModelAndView();

		page.setViewName("NexusAppUsers");

		page.addObject("ud", userDetails);
		page.addObject("asl", appstateList);
		page.addObject("acl", appcountryList);
		page.addObject("rl", roleList);

		page.addObject("newNexusappUsers", new NexusAppUsers());

		return page;
	}

	@PostMapping(value = "/addnexusappusers")
	public ModelAndView newNexusappUsers(@ModelAttribute NexusAppUsers newNexusAppUsers, HttpServletRequest request,
			HttpSession session) {
		objectDAO.addOrUpdate(SQL_QUERIES.addNexusUsersDetails,
				new String[] { newNexusAppUsers.getUserName(), newNexusAppUsers.getUserFullName(),
						newNexusAppUsers.getUserRole(), newNexusAppUsers.getUserMobile(),
						newNexusAppUsers.getUserEmail(), newNexusAppUsers.getUserAddress(), newNexusAppUsers.getCity(),
						newNexusAppUsers.getState(), newNexusAppUsers.getCountry(), newNexusAppUsers.getZipcode(),
						newNexusAppUsers.getState() });

		return new ModelAndView("redirect:/nexususerdetails");
	}
}
