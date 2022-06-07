package com.pranavaeet.Nexus.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.Nexus.common.VisitorsNexus;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;

@Controller
public class VisitorsNexusController {
	@Autowired
	ObjectDAO objectDAO;

	@GetMapping(value = "/visitorsDetailsNexus")
	public ModelAndView getVisitorsDetails(HttpServletRequest request, HttpSession session) {
		List<VisitorsNexus> visitorsDetailsNexus = (List<VisitorsNexus>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getNexusvisitorsList, null, VisitorsNexus.class);
		ModelAndView page = new ModelAndView();
		

		page.setViewName("VisitorsNexus");

		page.addObject("vdn", visitorsDetailsNexus);
		return page;
	}

}
