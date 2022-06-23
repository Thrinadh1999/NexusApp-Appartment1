package com.pranavaeet.NexusApp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.NexusApp.common.NexusAppBlocks;
import com.pranavaeet.NexusApp.common.NexusAppVenture;

@Controller
public class BlockNexusAppController {
	final static Logger logger = LogManager.getLogger();
	@Autowired
	ObjectDAO objectDAO;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/nexusblodckdetails")
	public ModelAndView getBlockDetails(HttpServletRequest request, HttpSession session) {
		List<NexusAppBlocks> blockDetails = (List<NexusAppBlocks>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getBlockDetails, null, NexusAppBlocks.class);
		List<NexusAppVenture> ventureList = (List<NexusAppVenture>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getVentureDetails,null, NexusAppVenture.class);

		ModelAndView page = new ModelAndView();

		page.setViewName("NexusAppBlock");

		page.addObject("bd", blockDetails);
		page.addObject("vll", ventureList);

		page.addObject("newNexusappBlock", new NexusAppBlocks());

		return page;
	}

	@PostMapping(value = "/addnexusappblock")
	public ModelAndView addNexusAppBlocks(@ModelAttribute NexusAppBlocks newNexusAppBlocks, HttpServletRequest request,
			HttpSession session) {
		objectDAO.addOrUpdate(SQL_QUERIES.addBlockDetails,
				new String[] { newNexusAppBlocks.getBlockName(), newNexusAppBlocks.getVentureId(),newNexusAppBlocks.getNo_of_floors()});

		return new ModelAndView("redirect:/nexusblodckdetails");
	}
	
	@GetMapping(value="/getBlockIframe")
	public ModelAndView getVentureDet(@ModelAttribute String blockname, HttpServletRequest request,
			HttpSession session) {
		logger.info(blockname);
		@SuppressWarnings("unchecked")
		List<NexusAppBlocks> blockDet = (List<NexusAppBlocks>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getBlockDetailsByBlockName, new String[] {blockname}, NexusAppBlocks.class);
		logger.info(blockname, blockDet);
		ModelAndView page =new ModelAndView();
		page.setViewName("Block_det");
		page.addObject("bd",blockDet);
		//return page;
		return null;
	}
}
