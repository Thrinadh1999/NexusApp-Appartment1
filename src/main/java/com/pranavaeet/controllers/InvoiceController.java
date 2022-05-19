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
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.common.Employee;
import com.pranavaeet.common.InvoiceItems;
import com.pranavaeet.common.Invoices;

@Controller
public class InvoiceController {
	final static Logger logger = LogManager.getLogger();

	@Autowired
	ObjectDAO objectDAO;

	private String invo;
	
	//Invoice Page
	@GetMapping(value="/Invoice")
	public ModelAndView invoicePage(HttpServletRequest request, HttpSession session) {
		List<Invoices> invoiceList = (List<Invoices>) objectDAO.multipleResultSelect(SQL_QUERIES.getInvoices, null, Invoices.class);
		List<Employee> employeeList = (List<Employee>) objectDAO.multipleResultSelect(SQL_QUERIES.getEmpBYDepId, null, Employee.class);
		
		ModelAndView page = new ModelAndView();
		
		page.setViewName("Invoice");
		page.addObject("invoLst", invoiceList);
		page.addObject("emplist", employeeList);
		page.addObject("newInvoice", new Invoices());
		
	return page;
	}
	
	@PostMapping(value = "/addinvoice")
	public ModelAndView addNewInvoice(@ModelAttribute Invoices newInvoice, HttpServletRequest request,HttpSession session) {
		objectDAO.addOrUpdate(SQL_QUERIES.addInvoices, new String [] {newInvoice.getInvoiceNo(), newInvoice.getClient(), newInvoice.getClientAdress(), newInvoice.getToName(),  newInvoice.getInvoiceBy()});
		
		return new ModelAndView("redirect:/Invoice");
	}

		

 	//InvoiceItems Page
	//@GetMapping(value="/InvoiceItems")
	//public ModelAndView invoiceItemsPage(HttpServletRequest request, HttpSession session) {
		//List<InvoiceItems> invoiceItemsList = (List<InvoiceItems>) objectDAO.multipleResultSelect(SQL_QUERIES.getInvoicesItems, null, InvoiceItems.class);
		//ModelAndView page = new ModelAndView();
		//page.setViewName("InvoiceItems");
		//page.addObject("invoItemsLst", invoiceItemsList);
		
		//page.addObject("newInvoiceItems", new InvoiceItems());
		//return page;
	//}
	
	//@PostMapping(value="/addinvoiceItems")
	//public ModelAndView addNewInvoiceItems(@ModelAttribute InvoiceItems newInvoiceItems, HttpServletRequest request,HttpSession session) {
		//objectDAO.addOrUpdate(SQL_QUERIES.addInvoicesItems, new String [] {newInvoiceItems.getInvoiceID(),newInvoiceItems.getItemName(), newInvoiceItems.getDescription(), newInvoiceItems.getQuantity(), newInvoiceItems.getAmount(), newInvoiceItems.getItemPrice()});
		//return new ModelAndView("redirect:/InvoiceItems");
	//}
		
	
	
	
	
	//invo Page
	@GetMapping(value="/invo")
	public ModelAndView invoPage(String id,HttpServletRequest request, HttpSession session) {
		logger.info(id);
		Invoices invoicedet = (Invoices)objectDAO.singleResultSelect(SQL_QUERIES.getInvoiceById, new String[] {id}, Invoices.class);
		List<InvoiceItems> invoiceItemsList = (List<InvoiceItems>) objectDAO.multipleResultSelect(SQL_QUERIES.getInvoicesItems, new String[] {id}, InvoiceItems.class);
		Map<String,Object> totalItemAmount = objectDAO.singleResultSelect(SQL_QUERIES.sumItemPriceById, new String[] {id});
		Map<String, Object> totalItemSubTotal = objectDAO.singleResultSelect(SQL_QUERIES.sumInvSubTotal, new String[] {id});
		Map<String, Object> taxAmt = objectDAO.singleResultSelect(SQL_QUERIES.taxAnmt, new String[] {id});
		Double invAmt = (Double) totalItemAmount.get("invoiceAmt");
		Double invSubAmt = (Double) totalItemSubTotal.get("InvSubTotal");
		Double taxAmnt = (Double) taxAmt.get("taxAmount");
		
		String invoAmt = String.valueOf(invAmt);
		String subTotal = String.valueOf(invSubAmt);
		String taxItemAmt = String.valueOf(taxAmnt);
		
		ModelAndView page = new ModelAndView();
	
		page.addObject("invoiceDetails",invoicedet);
		page.addObject("invoItems", invoiceItemsList);
		page.addObject("subTotal",subTotal );
		page.addObject("invAmt", invoAmt);
		page.addObject("tax", taxItemAmt);
		page.setViewName("invo");
		
		page.addObject("newInvoiceItems", new InvoiceItems());
		
		return page;
	}
		@PostMapping(value= "/addinvoiceItems")
		public ModelAndView addNewInvoiceItems (@ModelAttribute InvoiceItems newInvoiceItems, HttpServletRequest request, HttpSession session) {
			String id = newInvoiceItems.getInvoiceID();
			objectDAO.addOrUpdate(SQL_QUERIES.addInvoicesItems, new String [] {newInvoiceItems.getInvoiceID(),newInvoiceItems.getItemName(), newInvoiceItems.getDescription(), newInvoiceItems.getQuantity(), newInvoiceItems.getItemPrice()});
			return new ModelAndView ("redirect:/invo?id ="+id);
		}
		
		
		
		
}
	
		
		