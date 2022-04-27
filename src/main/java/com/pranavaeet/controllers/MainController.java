package com.pranavaeet.controllers;

import java.util.ArrayList;
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

import com.pranavaeet.common.Department;

import com.pranavaeet.common.Projects;
import com.pranavaeet.common.Tasks;
import com.pranavaeet.common.Employee;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.constants.URL_CONSTANTS;
import com.pranavaeet.common.Statelkp;
import com.pranavaeet.common.Countrylkp;
import com.pranavaeet.common.UserProfile;

@Controller
public class MainController {
	final static Logger logger = LogManager.getLogger();

	@Autowired
	ObjectDAO objectDAO;

	
	//Departments Page
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/departments")
	public ModelAndView departmentPage(HttpServletRequest request, HttpSession session) {
		if (null != request.getRemoteUser()) {
			List<Department> departmentList = (List<Department>) objectDAO.multipleResultSelect(SQL_QUERIES.getDepartments, null,
					Department.class);
			ModelAndView page = new ModelAndView();
			page.setViewName("Departments");
			page.addObject("newDepartment", new Department());
			page.addObject("depList", departmentList);
			return page;
		}
		return new ModelAndView(URL_CONSTANTS.REDIRECT_SESSION_EXPIRED);
	}

	@PostMapping(value = "/addDepartment")
	public ModelAndView addNewDepartment(@ModelAttribute Department newDepartment, HttpServletRequest request,
			HttpSession session) {
		objectDAO.addOrUpdate(SQL_QUERIES.addDepartment,
				new String[] { newDepartment.getName(), newDepartment.getDescription(), newDepartment.getCode() });
		return new ModelAndView("redirect:/Departments");
	}

	// Projects Page
	@GetMapping(value = "/projects")
	public ModelAndView projectsPage(HttpServletRequest request, HttpSession session) {
		List<Projects> projectsList = new ArrayList<Projects>();

		ModelAndView page = new ModelAndView();
		page.setViewName("Projects");
		page.addObject("projectsList", projectsList);
		page.addObject("newProjects", new Projects());
		return page;
	}

	@PostMapping(value = "/addProjects")
	public ModelAndView addProjects(@ModelAttribute Projects newProjects, HttpServletRequest request,
			HttpSession session) {
		// objectDAO.addOrUpdate(SQL_QUERIES.addProjects, new String[]
		// {newProjects.projectID(),newProjects.DetprojectName(),newProjects.getDescription(),newProjects.getBeginDate(),newProjects.getendDate()});
		return new ModelAndView("redirect:/Products");

	}

	// Employees Page
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/employees")
	public ModelAndView employeePage(HttpServletRequest request, HttpSession session) {
		List<Employee> empList = new ArrayList<Employee>();
		List<Department> departmentList = (List<Department>) objectDAO.multipleResultSelect(SQL_QUERIES.getDepartments, null,
				Department.class);
		List<Statelkp> stateList = (List<Statelkp>) objectDAO.multipleResultSelect(SQL_QUERIES.getStateList, null, Statelkp.class);
		List<Countrylkp> countryList = (List<Countrylkp>) objectDAO.multipleResultSelect(SQL_QUERIES.getCountryList, null, Countrylkp.class);
		List<UserProfile> users = (List<UserProfile>) objectDAO.multipleResultSelect(SQL_QUERIES.getusersProfileList, null, UserProfile.class);
		
		 Map<String,Object> countMap = 
		 objectDAO.singleResultSelect(SQL_QUERIES.getEmployeeCount, null);
		 Long countlng = (Long) countMap.get("empCount");
		 Integer count = countlng.intValue();			
			 if(count!=0) { 
				 empList =
			 (List<Employee>)objectDAO.multipleResultSelect(SQL_QUERIES.getEmployeeList,
			null, Employee.class); }
			
		 
		ModelAndView page = new ModelAndView();
		page.setViewName("Employee");
		page.addObject("employeeList", empList);
		page.addObject("depList", departmentList);
		page.addObject("stateList", stateList);
		page.addObject("countryList" , countryList);
		page.addObject("users" , users);
		
		
		page.addObject("newEmployee", new Employee());
		return page;
	}

	@PostMapping(value = "/addEmployee")
	public ModelAndView addNewEmployee(@ModelAttribute Employee newEmployee, HttpServletRequest request,
			HttpSession session) {
		// objectDAO.addOrUpdate(SQL_QUERIES.addDepartment, new String[]
		// {newEmployee.getName(),newEmployee.getDescription(),newEmployee.getCode()});
		return new ModelAndView("redirect:/Departments");
	}

	// Tasks Page
	@GetMapping(value = "/Tasks")
	public ModelAndView tasksPage(HttpServletRequest request, HttpSession session) {
		List<Tasks> tasksList = new ArrayList<Tasks>();

		ModelAndView page = new ModelAndView();
		page.setViewName("Tasks");
		page.addObject("tasksList", tasksList);
		page.addObject("newTask", new Tasks());
		return page;
	}

	@PostMapping(value = "/addTask")
	public ModelAndView addTask(@ModelAttribute Tasks newTask, HttpServletRequest request, HttpSession session) {
		// objectDAO.addOrUpdate(SQL_QUERIES.addProjects, new String[]
		// {newTask.gettaskId(),newTask.gettaskDescription(),newTask.getisComplete(),newTask.getemployeeId()});
		return new ModelAndView("redirect:/Tasks");
	}
}