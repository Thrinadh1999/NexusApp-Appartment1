package com.pranavaeet.controllers;


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
import com.pranavaeet.common.Transactions;
import com.pranavaeet.common.Employee;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.constants.URL_CONSTANTS;

import com.pranavaeet.common.Categories;



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

	
	
	
	
	//Accounts Menu
	     //Categories Page
	@GetMapping(value="/Categories")
	public ModelAndView accountsPage(HttpServletRequest request, HttpSession session) {
	
		List<Categories> categoriesList = (List<Categories>) objectDAO.multipleResultSelect(SQL_QUERIES.getCategories, null, Categories.class);
		
		ModelAndView page = new ModelAndView();
		
		//To get payment Types
				List<Map<String,Object>> typeList = new ArrayList<Map<String,Object>>();
				
				for(int i = 0;i<2;i++) {
					Map<String,Object> map = new HashMap<String,Object>();
					if(i==0) {
						map.put("type", "Payment");
					}else  {
						map.put("type", "Receipt");
					}
					typeList.add(map);
				}
		
		page.setViewName("Categories");
		page.addObject("catList", categoriesList);
		page.addObject("typeList",typeList);
		
		page.addObject("newCategory", new Categories());
		return page;
	}
	@PostMapping(value = "/addcategories")
	public ModelAndView addNewCategories(@ModelAttribute Categories newCategories, HttpServletRequest request,
			HttpSession session) {
		
		objectDAO.addOrUpdate(SQL_QUERIES.addCategories,
				new String[] {newCategories.getCategoryName(), newCategories.getDescription(), newCategories.getType()});
		return new ModelAndView("redirect:/Categories");
	}
	
	//Accounts Menu
		//Transactions Page
	
	@GetMapping(value="/Transactions")
	public ModelAndView transactionsPage(HttpServletRequest request, HttpSession session) {
	
		List<Transactions> transactionsList = (List<Transactions>) objectDAO.multipleResultSelect(SQL_QUERIES.getTransactions, null, Transactions.class);
		List<Employee> employeeList = (List<Employee>) objectDAO.multipleResultSelect(SQL_QUERIES.getEmpBYDepId, null, Employee.class);
		List<Categories> categoriesList = (List<Categories>) objectDAO.multipleResultSelect(SQL_QUERIES.getCategories, null, Categories.class);
		ModelAndView page = new ModelAndView();
		
		
		
		
		page.setViewName("Transactions");
		page.addObject("transList", transactionsList);
		page.addObject("emplist", employeeList);
		page.addObject("catList", categoriesList);
	
		
		page.addObject("newTransactions", new Transactions());
		return page;
	}
	@PostMapping(value = "/addtransactions")
	public ModelAndView addNewTransactions(@ModelAttribute Transactions newTransactions, HttpServletRequest request,HttpSession session) {
		
		objectDAO.addOrUpdate(SQL_QUERIES.addTransactions,
				new String[] {newTransactions.getTransactionBy(), newTransactions.getTransDescription(), newTransactions.getTransactionCategories().split(":")[0],newTransactions.getTransactionType(), newTransactions.getAmount()});
		return new ModelAndView("redirect:/Transactions");
	}
	
	
	
	// Tasks Page
	@GetMapping(value = "/Tasks")
	public ModelAndView tasksPage(HttpServletRequest request, HttpSession session) {
		List<Tasks> tasksList = (List<Tasks>) objectDAO.multipleResultSelect(SQL_QUERIES.getTasks,null,Tasks.class);
		List<Employee> employeeList = (List<Employee>)
				objectDAO.multipleResultSelect(SQL_QUERIES.getEmployee, null, Employee.class);
		List<Projects> projectsList = (List<Projects>) 
				objectDAO.multipleResultSelect(SQL_QUERIES.getProjects, null, Projects.class);
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
		objectDAO.addOrUpdate(SQL_QUERIES.addTasks, new String[]
				{newTask.getTaskName(),newTask.getTaskDescription(), newTask.getPoints(),  newTask.getPriority(), newTask.getEmployeeId(), newTask.getProjectId()});
		return new ModelAndView("redirect:/Tasks");
	}
	
	// request mapping method to submit edit tasks Status
		@PostMapping(path = "/updateTaskStatus")
		public ModelAndView updateEditTasks(String id, String status, HttpServletRequest request, HttpSession session) {
			
					objectDAO.addOrUpdate(SQL_QUERIES.updateTasks,new String[] {status, id});
					return new ModelAndView("redirect:/Tasks");
		   
	   }
	
	
	
	
}