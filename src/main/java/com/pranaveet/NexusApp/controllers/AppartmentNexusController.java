package com.pranaveet.NexusApp.controllers;

import java.util.List;
import java.util.Map;

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
import com.pranavaeet.NexusApp.common.NexusAppFloor;
import com.pranavaeet.NexusApp.common.NexusAppUsers;
import com.pranavaeet.NexusApp.common.NexusAppVenture;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;

@Controller
public class AppartmentNexusController {
	final static Logger logger = LogManager.getLogger();
	@Autowired
	ObjectDAO objectDAO;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/nexusapartmentdetails")
	public ModelAndView getApartmentDetails(HttpServletRequest request, HttpSession session) {
		List<NexusAppAppartment> appartmentDetails = (List<NexusAppAppartment>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getAppartmentDetails, null, NexusAppAppartment.class);
		List<NexusAppVenture> ventureList = (List<NexusAppVenture>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getVentureDetails, null, NexusAppVenture.class);
		List<NexusAppBlocks> blockList = (List<NexusAppBlocks>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getBlockDetails, null, NexusAppBlocks.class);
		List<NexusAppFloor> floorList = (List<NexusAppFloor>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getFloorDetails, null, NexusAppFloor.class);
		List<NexusAppUsers> userList = (List<NexusAppUsers>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getUserListbyrole, null, NexusAppUsers.class);
		//List<NexusAppMonthlyPayments> paymentList = (List<NexusAppMonthlyPayments>) objectDAO
		//		.multipleResultSelect(SQL_QUERIES.getPaymentsDetails, null, NexusAppMonthlyPayments.class);
		List<Map<String, Object>> v1 = objectDAO.multipleResultSelect(SQL_QUERIES.joinBlock_Floor, null);
		
		
		ModelAndView page = new ModelAndView();
		
		page.setViewName("NexusAppAppartment");
		
		page.addObject("ad", appartmentDetails);
		page.addObject("vl", ventureList);
		page.addObject("bl", blockList);
		page.addObject("fl", floorList);
		page.addObject("ul", userList);
		//page.addObject("pl", paymentList);
		page.addObject("v1", v1);
		
		
		
		
		
		page.addObject("newNexusappAppartment", new NexusAppAppartment());
		
		return page;
	}

	@PostMapping(value = "/addnexusappappartment")
	public ModelAndView addAppartmentDetails(@ModelAttribute NexusAppAppartment newNexusAppAppartment, HttpServletRequest request,HttpSession session) {
		logger.info(newNexusAppAppartment);
	objectDAO.addOrUpdate(SQL_QUERIES.addAppartmentDetails, new String [] {newNexusAppAppartment.getAppartmentName(),newNexusAppAppartment.getAppartmentOwner(),newNexusAppAppartment.getNumber(),newNexusAppAppartment.getAppartmenStatus(),newNexusAppAppartment.getDescription(),newNexusAppAppartment.getBlockId(),newNexusAppAppartment.getFloorId()});
	
	return new ModelAndView("redirect:/nexusapartmentdetails");
}
	@GetMapping(value="/getnexusappartment")
	public ModelAndView getVentureDet(HttpServletRequest request, HttpSession session) {
		List<NexusAppAppartment> appartmentDet = (List<NexusAppAppartment>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getAppartmentDetails, null, NexusAppAppartment.class);
		ModelAndView page =new ModelAndView();
		page.setViewName("NexusAppAppartment");
		page.addObject("adi", appartmentDet);
		return page;
	}

}

