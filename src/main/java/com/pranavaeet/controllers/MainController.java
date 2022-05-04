package com.pranavaeet.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.google.common.io.Files;
import com.pranavaeet.common.Countrylkp;



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
		return new ModelAndView("redirect:/departments");
	}
	
	// request mapping method to get edit form for Departments Page
		@GetMapping(path = "/editDepartment")
		public ModelAndView getEditForm(HttpServletRequest request, HttpSession session,String  id) {
			Department selectedDep=(Department)objectDAO.singleResultSelect(SQL_QUERIES.editDep,new String[] {id},Department.class);
			ModelAndView model = new ModelAndView();
			model.setViewName("editDepForm");
			model.addObject("department",selectedDep);
			model.addObject("editDepartment",new Department());
			return model;
			
		}
		
		// request mapping method to submit edited details for Departments Page
		@PostMapping(path = "/editDepartmentPage")
		public ModelAndView updateEditDepartment(@ModelAttribute Department editdepartment, HttpServletRequest request,
				HttpSession session) {
			objectDAO.addOrUpdate(SQL_QUERIES.updateDep,
					new String[] { editdepartment.getName(), editdepartment.getDescription(), editdepartment.getCode(), editdepartment.getDepartmentId() });
					
			return new ModelAndView("redirect:/departments");
		}

	// Projects Page
	@GetMapping(value = "/projects")
	public ModelAndView projectsPage(HttpServletRequest request, HttpSession session) {
		List<Projects> projectsList = new ArrayList<Projects>();
		if (null != request.getRemoteUser()) {
			projectsList = (List<Projects>) objectDAO.multipleResultSelect(SQL_QUERIES.getProjects, null, Projects.class);
		}
		
		ModelAndView page = new ModelAndView();
		page.setViewName("Projects");
		page.addObject("proList", projectsList);
		page.addObject("newProjects", new Projects());
		return page;
		}
	
	@PostMapping(value = "/addprojects")
	public ModelAndView addNewProject(@ModelAttribute Projects newProjects, HttpServletRequest request,
			HttpSession session) {
		objectDAO.addOrUpdate(SQL_QUERIES.addProjects,
				new String[] {newProjects.getProjectName(), newProjects.getDescription(), newProjects.getStartDate(), newProjects.getDueDate(), newProjects.getClient(), newProjects.getClientDetails()});
		return new ModelAndView("redirect:/projects");

	}
	
	// request mapping method to get edit form for Projects Page
	@GetMapping(path = "/editProjectForm")
	public ModelAndView getEditProjects(HttpServletRequest request, HttpSession session,String  ID) {
		Projects selectedProjects=(Projects)objectDAO.singleResultSelect(SQL_QUERIES.editProjects,new String[] {ID},Projects.class);
		ModelAndView model = new ModelAndView();
		model.setViewName("editProjects");
		model.addObject("Projects",selectedProjects);
		model.addObject("editProjects",new Projects());
		return model;
	}
	// request mapping method to submit edited details for Projects Page
	@PostMapping(path = "/editProjectsPage")
	public ModelAndView updateEditProjects(@ModelAttribute Projects editProjects, HttpServletRequest request, HttpSession session) {
				objectDAO.addOrUpdate(SQL_QUERIES.updateProjects,new String[] { editProjects.getProjectName(), editProjects.getDescription(), editProjects.getStartDate(), editProjects.getDueDate(), editProjects.getClient(), editProjects.getClientDetails(),editProjects.getProjectID()});
							
					return new ModelAndView("redirect:/projects");
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
		 Map<String,Object> countMap = 
		 objectDAO.singleResultSelect(SQL_QUERIES.getEmployeeCount, null);
		 Long countlng = (Long) countMap.get("empCount");
		 Integer count = countlng.intValue();			
			 if(count!=0) { 
				 empList =
			 (List<Employee>)objectDAO.multipleResultSelect(SQL_QUERIES.getEmployeeList,
			null, Employee.class);
				 
				
				 
				 for (Employee emp:empList) {
						Department depName = (Department) objectDAO.singleResultSelect(SQL_QUERIES.getDepartmentById, new String[] {emp.getDepartmentId()} , Department.class);
						emp.setDepartmentName(depName.getName());
					}
				 }
			List<Map<String,Object>> roleList = objectDAO.multipleResultSelect(SQL_QUERIES.getUserRoles, null);
			
		 
		ModelAndView page = new ModelAndView();
		List<Map<String,Object>> genderList = new ArrayList<Map<String,Object>>();
		
		for(int i = 0;i<2;i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			if(i==0) {
				map.put("gender", "Male");
			}else  {
				map.put("gender", "Female");
			}
			genderList.add(map);
		}
		
		
		
		page.setViewName("Employee");
		page.addObject("employeeList", empList);
		page.addObject("depList", departmentList);
		page.addObject("stateList", stateList);
		page.addObject("countryList" , countryList);
		page.addObject("roleList" , roleList);
		page.addObject("genList",genderList);
		
		
		page.addObject("newEmployee", new Employee());
		return page;
	}

	@PostMapping(value = "/addEmployee")
	public ModelAndView addNewEmployee(@ModelAttribute Employee newEmployee, HttpServletRequest request,
			HttpSession session) {
		
		
		
		logger.info("join date: "+newEmployee.getJoinDate()+"  and departmentId :"+newEmployee.getDepartmentId());
		Integer eId = objectDAO.insertAndGetResult(SQL_QUERIES.addEmployee,"id", new String[]
		{newEmployee.getFirstName(),newEmployee.getLastName(),newEmployee.getAddress()+newEmployee.getCity()+newEmployee.getStateName()+newEmployee.getCountryId()+newEmployee.getZipCode(),newEmployee.getMobile(),newEmployee.getJoinDate(),newEmployee.getDepartmentId(),newEmployee.getRole()});
		newEmployee.setId(String.valueOf(eId));
		newEmployee.setImageFilePath("/home/smssols/Desktop/EmployeePics/"+newEmployee.getId()+".jpeg");
		File dir = new File ("/home/smssols/Desktop/EmployeePics/"+newEmployee.getId()+".jpeg");
		
		
			try {
				Files.write( newEmployee.getImageUpload().getBytes(),dir);
			} catch (IOException e) {
				// TODO Auto-generated catch block for Employees Page
				e.printStackTrace();
			}
		
		objectDAO.addOrUpdate(SQL_QUERIES.createUser, new String[]
				{newEmployee.getEmail(),newEmployee.getMobile()});
		objectDAO.addOrUpdate(SQL_QUERIES.createUserProfile, new String[]
				{newEmployee.getEmail(),newEmployee.getFirstName(),newEmployee.getLastName(),newEmployee.getEmail(),newEmployee.getMobile(),newEmployee.getAddress(),newEmployee.getCity(),newEmployee.getStateName(),newEmployee.getCountryId(),newEmployee.getZipCode(),newEmployee.getGender(),newEmployee.getRole(), newEmployee.getImageFilePath(), newEmployee.getImageFileType()});
		objectDAO.addOrUpdate(SQL_QUERIES.createUserRole, new String[]
				{newEmployee.getEmail(),newEmployee.getRole()});
			
		return new ModelAndView("redirect:/employees");
	}
	
	

	
	
	// Tasks Page
	@GetMapping(value = "/Tasks")
	public ModelAndView tasksPage(HttpServletRequest request, HttpSession session) {
		List<Tasks> tasksList = new ArrayList<Tasks>();
		List<Employee> employeeList = (List<Employee>)
				objectDAO.multipleResultSelect(SQL_QUERIES.getEmployee, null, Employee.class);
		List<Projects> projectsList = (List<Projects>) 
				objectDAO.multipleResultSelect(SQL_QUERIES.getProjects, null,
						Projects.class);
		ModelAndView page = new ModelAndView();
		
		page.setViewName("Tasks");
		page.addObject("projectsList", projectsList);
		page.addObject("employeeList", employeeList);
		page.addObject("tasksList", tasksList);
		
	    
	    
		page.addObject("newTask", new Tasks());
		return page;
	}
		
		
						 
					
	

	@PostMapping(value = "/addTask")
	public ModelAndView addTask(@ModelAttribute Tasks newTask, HttpServletRequest request, HttpSession session) {
		objectDAO.insertAndGetResult(SQL_QUERIES.addTasks,"id",  new String[]
				{newTask.getTaskName(), newTask.getTaskDescription(), newTask.getStatus(), newTask.getPoints(), newTask.getCreatedTime(), newTask.getPriority()});
		return new ModelAndView("redirect:/Tasks");
	}
}