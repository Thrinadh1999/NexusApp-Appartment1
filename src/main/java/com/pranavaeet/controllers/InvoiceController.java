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
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;


import com.pranavaeet.common.ObjectDAO;
//import com.pranavaeet.common.Payslips;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.common.Employee;
import com.pranavaeet.common.InvoiceItems;
import com.pranavaeet.common.Invoices;

@Controller
public class InvoiceController {
	final static Logger logger = LogManager.getLogger();

	@Autowired
	//define objectdao
	ObjectDAO objectDAO;

	private String invo;
	
	//Invoice Page
	@GetMapping(value="/Invoice")
	//servletrequest
	public ModelAndView invoicePage(HttpServletRequest request, HttpSession session) {
		//to get the list for invoices
		List<Invoices> invoiceList = (List<Invoices>) objectDAO.multipleResultSelect(SQL_QUERIES.getInvoices, null, Invoices.class);
		//to get the list for employee with respect to the department id (who are in accounts section)
		List<Employee> employeeList = (List<Employee>) objectDAO.multipleResultSelect(SQL_QUERIES.getEmpBYDepId, null, Employee.class);
		
		ModelAndView page = new ModelAndView();
		//to set the page view name
		page.setViewName("Invoice");
		//to add the get values to the string represented in the ""
		page.addObject("invoLst", invoiceList);
		page.addObject("emplist", employeeList);
		//to add the values to the desired action
		page.addObject("newInvoice", new Invoices());
	//to return the page	
	return page;
	}
	
	@PostMapping(value = "/addinvoice")
	public ModelAndView addNewInvoice(@ModelAttribute Invoices newInvoice, HttpServletRequest request,HttpSession session) {
		//sending get values to the database by sql_querie to the desired path 
		objectDAO.addOrUpdate(SQL_QUERIES.addInvoices, new String [] {newInvoice.getInvoiceNo(), newInvoice.getClient(), newInvoice.getClientAdress(), newInvoice.getToName(),  newInvoice.getInvoiceBy()});
		
		return new ModelAndView("redirect:/Invoice");
	}

	//invo Page
	@GetMapping(value="/invo")
	public ModelAndView invoPage(String id,HttpServletRequest request, HttpSession session) {
		logger.info(id);
		Invoices invoicedet = (Invoices)objectDAO.singleResultSelect(SQL_QUERIES.getInvoiceById, new String[] {id}, Invoices.class);
		//to get list of invoice items
		@SuppressWarnings("unchecked")
		List<InvoiceItems> invoiceItemsList = (List<InvoiceItems>) objectDAO.multipleResultSelect(SQL_QUERIES.getInvoicesItems, new String[] {id}, InvoiceItems.class);
		//to get single result for item price with respect to id
		Map<String,Object> totalItemAmount = objectDAO.singleResultSelect(SQL_QUERIES.sumItemPriceById, new String[] {id});
		//to get single result for invoice subtotal for the list of invoice items with respect to the invoice id
		Map<String, Object> totalItemSubTotal = objectDAO.singleResultSelect(SQL_QUERIES.sumInvSubTotal, new String[] {id});
		//to get the single result for total amount of tax charged for the n no.of items
		Map<String, Object> taxAmt = objectDAO.singleResultSelect(SQL_QUERIES.taxAnmt, new String[] {id});
		//to get the results list for total item price for each item with respective to quantity
		List<Map<String,Object>> totalItemCost = objectDAO.multipleResultSelect(SQL_QUERIES.totalItemPrice, new String[] {id});
		//to get the value in double
		Double invAmt = (Double) totalItemAmount.get("invoiceAmt");
		Double invSubAmt = (Double) totalItemSubTotal.get("InvSubTotal");
		Double taxAmnt = (Double) taxAmt.get("taxAmount");
		//to get the value in string
		String invoAmt = String.valueOf(invAmt);
		String subTotal = String.valueOf(invSubAmt);
		String taxItemAmt = String.valueOf(taxAmnt);
		
		ModelAndView page = new ModelAndView();
		//to add the get value to the page
		page.addObject("invoiceDetails",invoicedet);
		page.addObject("invoItems", invoiceItemsList);
		page.addObject("subTotal",subTotal );
		page.addObject("invAmt", invoAmt);
		page.addObject("tax", taxItemAmt);
		page.addObject("itemPrice", totalItemCost);
		page.setViewName("invo");
		
		page.addObject("newInvoiceItems", new InvoiceItems());
		//to return the page after submit
		return page;
	}
		@PostMapping(value= "/addinvoiceItems")
		public ModelAndView addNewInvoiceItems (@ModelAttribute InvoiceItems newInvoiceItems, HttpServletRequest request, HttpSession session) {
			String id = newInvoiceItems.getInvoiceID();
			//to add the get values to the desired path
			objectDAO.addOrUpdate(SQL_QUERIES.addInvoicesItems, new String [] {newInvoiceItems.getInvoiceID(),newInvoiceItems.getItemName(), newInvoiceItems.getDescription(), newInvoiceItems.getQuantity(), newInvoiceItems.getItemPrice()});
			//to redirect to the desired page
			return new ModelAndView ("redirect:/invo?id="+id);
		}
		
		
	
	
}	
		
		