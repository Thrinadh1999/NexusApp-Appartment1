package com.pranavaeet.Nexus.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.Nexus.common.FlatDetailsNexus;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;

@Controller
public class NexusFlatDetailsController {
	@Autowired
	ObjectDAO objectDAO;

	@GetMapping(value = "/flatDetails")
	public ModelAndView getFlatDetails(HttpServletRequest request, HttpSession session) {
		List<FlatDetailsNexus> flatDetails = (List<FlatDetailsNexus>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getNexusapartmentsList, null, FlatDetailsNexus.class);
		ModelAndView page = new ModelAndView();

		page.setViewName("FlatDetails");

		page.addObject("fd", flatDetails);
		page.addObject("fdp", new FlatDetailsNexus());
		return page;
	}

}
