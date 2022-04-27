package com.pranavaeet.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.common.Department;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.constants.URL_CONSTANTS;

 
@Controller

public class MainController {
	@Autowired
	ObjectDAO objectDAO;
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/Departments")
	public ModelAndView departmentPage(HttpServletRequest request, HttpSession session) {
		if(null != request.getRemoteUser()) {
			List<Department> departmentList = new ArrayList<Department>();
			departmentList = (List<Department>) objectDAO.multipleResultSelect(SQL_QUERIES.getDepartments, null, Department.class);
			ModelAndView page= new ModelAndView();
			page.setViewName("Departments");
			page.addObject("depList", departmentList);
			return page;
		}
		return new ModelAndView(URL_CONSTANTS.REDIRECT_SESSION_EXPIRED);
	}

}
