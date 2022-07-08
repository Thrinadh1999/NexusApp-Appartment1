package com.pranavaeet.Nexus.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.Nexus.common.UsersNexus;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;

@Controller
public class UsersNexusController {
	@Autowired
	ObjectDAO objectDAO;

	@GetMapping(value = "/userDetailsNexus")
	public ModelAndView getUsersDetails(HttpServletRequest request, HttpSession session) {
		List<UsersNexus> userDetailsNexus = (List<UsersNexus>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getNexususersList, null, UsersNexus.class);
		ModelAndView page = new ModelAndView();

		page.setViewName("UsersNexus");

		page.addObject("udn", userDetailsNexus);
		page.addObject("un", new UsersNexus());
		return page;
	}

}
