package com.pranavaeet.controllers;

import java.util.List;
import java.util.Map;

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
import com.pranavaeet.common.Payslips;
import com.pranavaeet.constants.SQL_QUERIES;

@Controller
public class PayslipsController {
	final static Logger logger = LogManager.getLogger();

	@Autowired
	//define objectdao
	ObjectDAO objectDAO;

@GetMapping(value="/PaySlips")
		public ModelAndView payslipsPage(HttpServletRequest request, HttpSession session) {
			List<Payslips> payslipList = (List<Payslips>) objectDAO.multipleResultSelect(SQL_QUERIES.getPaySlip, null, Payslips.class);
			List<Map<String,Object>> employeeList = objectDAO.multipleResultSelect(SQL_QUERIES.getEmployee, null);
			
			ModelAndView page = new ModelAndView();
			
			page.setViewName("PaySlips");
			
			page.addObject("paySlip", payslipList);
			page.addObject("emplist", employeeList);
			
			page.addObject("newPay", new Payslips());
			
			return page;
		
}
		@PostMapping(value = "/addpaySlip")
		public ModelAndView addNewPay(@ModelAttribute Payslips newPay, HttpServletRequest request,HttpSession session) {
			objectDAO.addOrUpdate(SQL_QUERIES.addPayslips, new String [] {newPay.getEmployeeName(), newPay.getMonth(), newPay.getPay()});
			
			
			return new ModelAndView("redirect:/PaySlips");
			
		}
	//EmployeePayslip Page	
	//to display the payslips for the selected employee
		@GetMapping(value="/EmployeePayslips")
		public ModelAndView employeePayslipPage(String id,HttpServletRequest request, HttpSession session) {
			logger.info(id);
			
			Map<String,Object> depName= objectDAO.singleResultSelect(SQL_QUERIES.getDepNameForSelectedEmp, new String[] {id});
			logger.info(depName);
			
			List<Payslips> payList = (List<Payslips>) objectDAO.multipleResultSelect(SQL_QUERIES.getEmployeePayslipById, new String[] {id}, Payslips.class);
			ModelAndView page = new ModelAndView();
			
			page.setViewName("EmployeePayslip");
			page.addObject("depName", depName);
			page.addObject("totalPayments", payList);
			page.addObject("EmployeePayslip", new Payslips());
			return page;
			
		}
		
}
		
		