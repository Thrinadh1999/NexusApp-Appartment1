package com.pranavaeet.NexusApp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.NexusApp.common.NexusAppAppartment;
import com.pranavaeet.NexusApp.common.NexusAppBlocks;
import com.pranavaeet.NexusApp.common.NexusAppVisitorType;
import com.pranavaeet.NexusApp.common.NexusAppVisitors;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;

@Controller
public class VisitorsNexusAppController {
	final static Logger logger = LogManager.getLogger();
	@Autowired
	ObjectDAO objectDAO;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/nexusvisitorsdetails")
	public ModelAndView getVisitorDetails(HttpServletRequest request, HttpSession session) {
		List<NexusAppVisitors> visitorDetails = (List<NexusAppVisitors>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getVisitorNexusDetails, null, NexusAppVisitors.class);
		List<NexusAppVisitorType> visitortyoeList = (List<NexusAppVisitorType>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getVisType, null, NexusAppVisitorType.class);
		List<NexusAppBlocks> blockList = (List<NexusAppBlocks>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getBlockDetails, null, NexusAppBlocks.class);
		List<NexusAppAppartment> appartmentList = (List<NexusAppAppartment>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getAppartmentDetails, null, NexusAppAppartment.class);

		ModelAndView page = new ModelAndView();

		page.setViewName("NexusAppVisitors");

		page.addObject("visd", visitorDetails);
		page.addObject("vtl", visitortyoeList);
		page.addObject("bl", blockList);
		page.addObject("al", appartmentList);

		page.addObject("newNexusappVisitors", new NexusAppVisitors());

		return page;
	}

	@PostMapping(value = "/addnexusappvisitors")
	public ModelAndView addVisitorsDetails(@ModelAttribute NexusAppVisitors newNexusappVisitors,
			HttpServletRequest request, HttpSession session) {
		objectDAO.addOrUpdate(SQL_QUERIES.addVisitorNexusDetails,
				new String[] { newNexusappVisitors.getTypeOfVisitor(), newNexusappVisitors.getAppartmentName(),
						newNexusappVisitors.getBlockName(), newNexusappVisitors.getName(),
						newNexusappVisitors.getMobile(), newNexusappVisitors.getOutTime(),
						newNexusappVisitors.getOutDate(), newNexusappVisitors.getImagePath()});
		logger.info(newNexusappVisitors);
		return new ModelAndView("redirect:/nexusvisitorsdetails");
	}

}
