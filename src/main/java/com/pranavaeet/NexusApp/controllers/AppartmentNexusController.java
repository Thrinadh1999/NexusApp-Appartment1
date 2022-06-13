package com.pranavaeet.NexusApp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.NexusApp.common.NexusAppAppartment;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;

@Controller
public class AppartmentNexusController {
	@Autowired
	ObjectDAO objectDAO;

	@GetMapping(value = "/nexusapartmentdetails")
	public ModelAndView getApartmentDetails(HttpServletRequest request, HttpSession session) {
		List<NexusAppAppartment> appartmentDetails = (List<NexusAppAppartment>) objectDAO
		.multipleResultSelect(SQL_QUERIES.getAppartmentDetails, null, NexusAppAppartment.class);
		ModelAndView page = new ModelAndView();
		
		page.setViewName("NexusAppAppartment");
		
		page.addObject("ad", appartmentDetails);
		
		page.addObject("naa", new NexusAppAppartment());
		
		return page;
	}

}
