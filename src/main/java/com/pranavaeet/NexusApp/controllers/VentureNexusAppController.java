package com.pranavaeet.NexusApp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.NexusApp.common.NexusAppVenture;

@Controller
public class VentureNexusAppController {
	@Autowired
	ObjectDAO objectDAO;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/nexusventuredetails")
	public ModelAndView getVentureDetails(HttpServletRequest request, HttpSession session) {
		List<NexusAppVenture> ventureDetails = (List<NexusAppVenture>) objectDAO.multipleResultSelect(SQL_QUERIES.getVentureDetails, null, NexusAppVenture.class);
		
		
		ModelAndView page = new ModelAndView();
		
		page.setViewName("NexusAppVenture");
		
		page.addObject("vd", ventureDetails);
		
		page.addObject("newNexusappVenture", new NexusAppVenture());
		
		return page;
	}

	@PostMapping(value = "/addnexusappventure")
	public ModelAndView newNexusappVenture(@ModelAttribute NexusAppVenture newNexusAppVenture, HttpServletRequest request,HttpSession session) {
	objectDAO.addOrUpdate(SQL_QUERIES.addVentureDetails, new String [] {newNexusAppVenture.getVentureName(),newNexusAppVenture.getVentureAddress(),newNexusAppVenture.getDescription()});
	
	return new ModelAndView("redirect:/nexusventuredetails");
}

}
