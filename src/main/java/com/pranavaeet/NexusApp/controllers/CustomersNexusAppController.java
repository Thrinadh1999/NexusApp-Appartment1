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
import com.pranavaeet.NexusApp.common.NexusAppCustomers;
import com.pranavaeet.NexusApp.common.NexusAppUserRole;
import com.pranavaeet.NexusApp.common.NexusAppVenture;

@Controller
public class CustomersNexusAppController {
	@Autowired
	ObjectDAO objectDAO;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/nexuscustomersdetails")
	public ModelAndView getCustomerDetails(HttpServletRequest request, HttpSession session) {
		List<NexusAppCustomers> customerDetails = (List<NexusAppCustomers>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getCustomerDetails, null, NexusAppCustomers.class);
		List<NexusAppUserRole>roleList = (List<NexusAppUserRole>)objectDAO.multipleResultSelect(SQL_QUERIES.getRoleAd_SAd, null, NexusAppUserRole.class);
		List<NexusAppVenture>ventureList = (List<NexusAppVenture>)objectDAO.multipleResultSelect(SQL_QUERIES.getVentureDetails, null, NexusAppVenture.class);

		ModelAndView page = new ModelAndView();

		page.setViewName("NexusAppCustomers");

		page.addObject("cd", customerDetails);
		page.addObject("rl", roleList);
		page.addObject("vn",ventureList);

		page.addObject("newNexusappCustomer", new NexusAppCustomers());

		return page;
	}

	@PostMapping(value = "/addnexusappcustomer")
	public ModelAndView newNexusappUsers(@ModelAttribute NexusAppCustomers newNexusAppCustomers, HttpServletRequest request,
			HttpSession session) {
		objectDAO.addOrUpdate(SQL_QUERIES.addCustomerDetails,
				new String[] { newNexusAppCustomers.getCustomerName(), newNexusAppCustomers.getCustomerMobile(),
						newNexusAppCustomers.getCustomerAddress(), newNexusAppCustomers.getCustomerPincode(),
						newNexusAppCustomers.getCustomerRole(), newNexusAppCustomers.getVentureName() });

		return new ModelAndView("redirect:/nexuscustomersdetails");
	}
}
