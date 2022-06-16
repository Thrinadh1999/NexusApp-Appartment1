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
import com.pranavaeet.NexusApp.common.NexusAppBlocks;
import com.pranavaeet.NexusApp.common.NexusAppFloor;

@Controller
public class FloorNexusAppController {
	@Autowired
	ObjectDAO objectDAO;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/nexusfloordetails")
	public ModelAndView getFloorDetails(HttpServletRequest request, HttpSession session) {
		List<NexusAppFloor> floorDetails = (List<NexusAppFloor>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getFloorDetails, null, NexusAppFloor.class);
		List<NexusAppBlocks>blockList = (List<NexusAppBlocks>)objectDAO.multipleResultSelect(SQL_QUERIES.getBlockDetails, null, NexusAppBlocks.class);

		ModelAndView page = new ModelAndView();

		page.setViewName("NexusAppFloor");

		page.addObject("fd", floorDetails);
		page.addObject("bl", blockList);

		page.addObject("newNexusappFloor", new NexusAppFloor());

		return page;
	}

	@PostMapping(value = "/addnexusappfloor")
	public ModelAndView newNexusappFloor(@ModelAttribute NexusAppFloor newNexusAppFloor, HttpServletRequest request,
			HttpSession session) {
		objectDAO.addOrUpdate(SQL_QUERIES.addFloorDetails,
				new String[] { newNexusAppFloor.getFloorNumber(), newNexusAppFloor.getBlockName()});
						

		return new ModelAndView("redirect:/nexusfloordetails");
	}
}
