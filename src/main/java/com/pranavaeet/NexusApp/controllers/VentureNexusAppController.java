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
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.NexusApp.common.NexusAppBlocks;
import com.pranavaeet.NexusApp.common.NexusAppVenture;

@Controller
public class VentureNexusAppController {
	final static Logger logger = LogManager.getLogger();
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
		page.addObject("newNexusappBlock", new NexusAppBlocks());
		
		return page;
	}

	@PostMapping(value = "/addnexusappventure")
	public ModelAndView newNexusappVenture(@ModelAttribute NexusAppVenture newNexusAppVenture, HttpServletRequest request,HttpSession session) {
	objectDAO.addOrUpdate(SQL_QUERIES.addVentureDetails, new String [] {newNexusAppVenture.getVentureName(),newNexusAppVenture.getVentureAddress(),newNexusAppVenture.getDescription(),newNexusAppVenture.getNo_of_blocks()});
	
	return new ModelAndView("redirect:/nexusventuredetails");
}
	//VEN_DET PAGE
	@GetMapping(value="/getBlockIframe")
	public ModelAndView getVentureDet(@ModelAttribute String blockname, HttpServletRequest request,
			HttpSession session) {
		//logger.info(blockname);
		@SuppressWarnings("unchecked")
		List<NexusAppBlocks> blockDet = (List<NexusAppBlocks>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getBlockDetails, null,  NexusAppBlocks.class);
		//logger.info(blockname, blockDet);
		ModelAndView page =new ModelAndView();
		page.setViewName("Block_det");
		page.addObject("bd",blockDet);
		return page;
		
	}

}
