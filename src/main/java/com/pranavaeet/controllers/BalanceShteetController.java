package com.pranavaeet.controllers;


//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;

@Controller
public class BalanceShteetController {
	final static Logger logger = LogManager.getLogger();

	@Autowired
	ObjectDAO objectDAO;

//Balance Sheet Page
		
	@GetMapping(value="/BalanceSheet")
	public ModelAndView balanceSheetPage(HttpServletRequest request, HttpSession session) {
		ModelAndView page = new ModelAndView();
		List<Map<String,Object>> payments = 
				 objectDAO.multipleResultSelect(SQL_QUERIES.getTransCatgPay, null);
		List<Map<String,Object>> receipts = objectDAO.multipleResultSelect(SQL_QUERIES.getTransCatgRec, null);
		Map<String,Object> expences = objectDAO.singleResultSelect(SQL_QUERIES.sumOfTransPaym, null);
		Map<String,Object> income = objectDAO.singleResultSelect(SQL_QUERIES.sumOfTransactionsRec, null);
		Map<String,Object> openingBalance = objectDAO.singleResultSelect(SQL_QUERIES.getOpeningBalance, null);
		Double totalexpences = (Double) expences.get("totalExp");
		Double totalincome = (Double) income.get("totalRcp");
		String openingBal = (String) openingBalance.get("bal");
		String totalExpence = String.valueOf(totalexpences);
		String totalIncome = String.valueOf(totalincome);
		String balance = String.valueOf(openingBal);
        page.addObject("paymentsList",payments);
        page.addObject("ReceiptsList",receipts);
        page.addObject("expences" ,totalExpence);
        page.addObject("Receipts", totalIncome);
        page.addObject("openingBalance", balance);
		page.setViewName("BalanceSheet");
		
		
		
		return page;
		
	}
	
}	