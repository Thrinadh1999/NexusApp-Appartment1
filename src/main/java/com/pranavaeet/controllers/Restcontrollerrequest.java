package com.pranavaeet.controllers;



//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;


@RestController
public class Restcontrollerrequest {
	final static Logger logger = LogManager.getLogger();
	@Autowired
	//define objectdao
	ObjectDAO objectDAO;
	
	@GetMapping(value = "app/request")
	@ResponseBody
	public String sayRequest(@RequestParam("username") String username,@RequestParam("password") String password ) {
		
		logger.info(username+"and password is"+password);
		
	return "String.username, String.password";
	}
	
	@GetMapping(value="app/getdetails")
	@ResponseBody
	public String getRequest(@RequestParam("username") String username, @RequestParam("password") String password) {
		objectDAO.singleResultSelect(SQL_QUERIES.validateUser,new String[] {username});
		objectDAO.singleResultSelect(SQL_QUERIES.validatePassword, new String[] {password});
		logger.info(username+"and password is"+password);
		
		return "String.username, String.password";
		
	}
	
}	
	