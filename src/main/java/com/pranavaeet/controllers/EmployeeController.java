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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.io.Files;
import com.pranavaeet.common.Countrylkp;
import com.pranavaeet.common.Department;
import com.pranavaeet.common.Employee;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.common.Statelkp;
import com.pranavaeet.constants.SQL_QUERIES;

@Controller
public class EmployeeController {
	final static Logger logger = LogManager.getLogger();

	@Autowired
	ObjectDAO objectDAO;
	// Employees Page
		@SuppressWarnings("unchecked")
		@GetMapping(value = "/employees")
		public ModelAndView employeePage(HttpServletRequest request, HttpSession session) {
			List<Employee> empList = new ArrayList<Employee>();
			List<Department> departmentList = (List<Department>) objectDAO.multipleResultSelect(SQL_QUERIES.getDepartments, null,Department.class);
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
		
		//Check if mobile number matches
		@PostMapping(value="/checkMobile")
	    @ResponseBody
		public String checkMobileNumber(String mnumber,HttpServletRequest request,
				HttpSession session) {
			Map<String,Object> count = objectDAO.singleResultSelect("SELECT COUNT(*) as count FROM employee where mobile=? ", new String[] {mnumber});
			Long countlng = (Long) count.get("count");
			 Integer c = countlng.intValue();			
			logger.info(c);
			if(c>0)
				return "false";	
			
			return "true";
		}

}
