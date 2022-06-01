package com.pranavaeet.controllers;



import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.tomcat.jni.Library;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import com.google.common.io.Files;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.pranavaeet.common.Nexus;
import com.pranavaeet.common.NexusNotices;
import com.pranavaeet.common.NexusUserProfiles;
import com.pranavaeet.common.NexusVisitors;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.utils.JsonMapper;

//import io.swagger.client.JSON;


@RestController
public class Restcontrollerrequest {
	final static Logger logger = LogManager.getLogger();
	@Autowired
	//define objectdao
	ObjectDAO objectDAO;
	@Autowired
	JsonMapper jsonMapper;
	//sample request example
	@GetMapping(value = "app/request")
	@ResponseBody
	public String sayRequest(@RequestParam("username") String username,@RequestParam("password") String password ) {
		
		logger.info(username+"and password is"+password);
		
	return "String.username, String.password";
	}
	
	//This is for login validatation 
	@GetMapping(value="app/getdetails")
	@ResponseBody
	public Integer getRequest(@RequestParam("username") String username, @RequestParam("password") String password) {	
		
		Map<String,Object> value1= objectDAO.singleResultSelect("SELECT DISTINCT IF(u.phonenumber = ? ,'VALID', 'INVALID')AS 'STATUS' FROM nexus_users u WHERE u.username  = ?", new String[] {password,username});			
		
		Integer status=0;
		String value= (String)value1.get("STATUS");			
		logger.info(value);
		 if(value.equals("VALID")) {
		   status=1;
		}else if(value.equals("INVALID")){
	    		status=2;
		}
		
	  logger.info(status);
	  return status;
	}
	
	
	//This is for registration process validation
	@GetMapping(value="app/signupdetails")
	@ResponseBody
	public String addRequest(@RequestParam("fullname") String fullname,@RequestParam("username") String username, @RequestParam("phonenumber") String phonenumber) {
		
		Map<String,Object> count = objectDAO.singleResultSelect("SELECT COUNT(*) as count FROM nexus_users where username=? ", new String[] {username});
		logger.info(username+" and number is "+phonenumber +"and id is");
		Long countlng = (Long) count.get("count");
		 Integer c = countlng.intValue();			
		logger.info(c);
		
		Map<String,Object> value2= objectDAO.singleResultSelect("SELECT COUNT(*) as count FROM nexus_users where phonenumber=? ", new String[] {phonenumber});
		Long counting= (Long) value2.get("count");
		 Integer d = counting.intValue();			
		logger.info(d);
		
		if(username=="" || fullname=="" || phonenumber=="" || username=="") {
				return "no data";
			}else if(c==0) {
				if(d!=0) {
					return "number is existed";
				}	
			objectDAO.insertAndGetResult(SQL_QUERIES.addNexususers, "id", new String[] {username,fullname,phonenumber,username});
			return "true";
		
			}
			return "email is existed";
	   
	}
	
	//This is for flat details
	@GetMapping(value = "app/flatdetails", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Integer flatdetails(@RequestParam("json") JSONObject json) {
	
	Map<String,Object> jsonMap = new HashMap<String,Object>();
	//Double flatdetails = (Double) jsonMap.get("id");
	//String fdet = String.valueOf(flatdetails);
	jsonMap=jsonMapper.toMap(json);
		logger.info(jsonMap);
		String flatName = jsonMap.get("name").toString();
		String mobilenumber = jsonMap.get("mobilenumber").toString();
		String flatNo = jsonMap.get("flatno").toString();
		String relationship = jsonMap.get("relationship").toString();
		String floor = jsonMap.get("floor").toString();
		
		objectDAO.insertAndGetResult(SQL_QUERIES.addNexusapartments, null, new String[] {flatName,mobilenumber,relationship,floor,flatNo});
		
	return 1;
	}
 
 
	@GetMapping(value = "app/getflatdetails", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Nexus> appartmentlist(HttpServletRequest request, HttpSession session) {
		List<Nexus> aprtList = (List<Nexus>) objectDAO.multipleResultSelect(SQL_QUERIES.getNexusapartmentsList, null, Nexus.class);
		
		return aprtList;
	}
	
	
	
	
	//This is for userprofile details
		@GetMapping(value = "app/userprofiledetails")
		@ResponseBody
		public Integer userprofileRequest(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("role") String role,@RequestParam("mobilenumber") String mobilenumber,@RequestParam("email") String email,@RequestParam("image") String image,@RequestParam("venturename") String venturename,@RequestParam("block") String block,@RequestParam("flatno") String flatno,@RequestParam("gender") String gender ) {
			Integer id=objectDAO.insertAndGetResult(SQL_QUERIES.addNexususerprofiles, "id", new String[] {firstname,lastname,role,mobilenumber,email,image,venturename,block,flatno,gender});
			
			
		return id;
		
		}
		@GetMapping(value = "app/getuserprofiledetails", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<NexusUserProfiles> profileList(HttpServletRequest request, HttpSession session) {
			List<NexusUserProfiles> profileList = (List<NexusUserProfiles>) objectDAO.multipleResultSelect(SQL_QUERIES.getNexususerprofileList, null, NexusUserProfiles.class);
			
			return profileList;
		}
		
		
		//This is for NOTICES details
		@GetMapping(value = "app/noticesdetails")
		@ResponseBody
		public Integer noticeRequest(@RequestParam("title") String title,@RequestParam("description") String description, @RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate,@RequestParam("createdby") String createdby ) {
			Integer id=objectDAO.insertAndGetResult(SQL_QUERIES.addNexusnotices, "id", new String[] {title,description,startdate,enddate,createdby});
			
			
		return id;
		
		}
		@GetMapping(value = "app/getnoticesdetails", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<NexusNotices> noticeList(HttpServletRequest request, HttpSession session) {
			List<NexusNotices> noticeList = (List<NexusNotices>) objectDAO.multipleResultSelect(SQL_QUERIES.getNexusnoticesList, null, NexusNotices.class);
			
			return noticeList;
		}
		
		//This is for visitor details
		//To capture the visitors Profile Data
				@GetMapping(value = "app/visitordetails",produces = MediaType.APPLICATION_JSON_VALUE)
				@ResponseBody
				public Integer visitorRequest(@RequestParam("visitorDetails") JSONObject visitorDetails) {
					Map<String,Object> visitorsDetailsMap = new HashMap<String,Object>();
					
					visitorsDetailsMap=jsonMapper.toMap(visitorDetails);
					logger.info(visitorsDetailsMap);
					String fullname = visitorsDetailsMap.get("fullname").toString();
					String contactnumber = visitorsDetailsMap.get("contactnumber").toString();
					String typeofvisitor = visitorsDetailsMap.get("typeofvisitor").toString();
					String flatno = visitorsDetailsMap.get("flatno").toString();
					String expectedtime = visitorsDetailsMap.get("expectedtime").toString();
					String image = visitorsDetailsMap.get("image").toString();
					String outtime = visitorsDetailsMap.get("outtime").toString();
					String outdate = visitorsDetailsMap.get("outdate").toString();
					String elapsedtime = visitorsDetailsMap.get("elapsedtime").toString();
					
					objectDAO.insertAndGetResult(SQL_QUERIES.addNexusvisitors, fullname, new String[] {fullname,contactnumber,typeofvisitor,flatno,expectedtime,image,outtime,outdate,elapsedtime});
					
				
					
					
					
					//public Integer visitorRequest(@RequestParam("fullname") String fullname,@RequestParam("contactnumber") String contactnumber,@RequestParam("typeofvisitor") String typeofvisitor,@RequestParam("flatno") String flatno,@RequestParam("expectedtime") String expectedtime,@RequestParam("image") String image,@RequestParam("outtime") String outtime,@RequestParam("outdate") String outdate,@RequestParam("elapsedtime") String elapsedtime ) {
					//Integer id=objectDAO.insertAndGetResult(SQL_QUERIES.addNexusvisitors, "id", new String[] {fullname,contactnumber,typeofvisitor,flatno,expectedtime,image,outtime,outdate,elapsedtime,});
					
					((NexusVisitors) visitorsDetailsMap).setFullname(String.valueOf(visitorsDetailsMap));
					((NexusVisitors) visitorsDetailsMap).setImage("/home/smssols/Desktop/EmployeePics/NexusPics/"+visitorsDetailsMap.get("fullname")+".jpeg");
					File dir = new File ("/home/smssols/Desktop/EmployeePics/NexusPics/"+visitorsDetailsMap.get("fullname")+".jpeg");
					
					
						try {
							Files.write( ((NexusVisitors) visitorsDetailsMap).getImageNexusUpload().getBytes(),dir);
						} catch (IOException e) {
							// TODO Auto-generated catch block for Employees Page
							e.printStackTrace();
						}

					
					///home/smssols/Desktop/EmployeePics/NexusPics
					
				return 1;
				
				}
				
				@GetMapping(value = "app/getvisitordetails", produces = MediaType.APPLICATION_JSON_VALUE)
				@ResponseBody
				public List<NexusVisitors> visitorsList(HttpServletRequest request, HttpSession session) {
					
					List<NexusVisitors> visitorsList = (List<NexusVisitors>) objectDAO.multipleResultSelect(SQL_QUERIES.getNexusvisitorsList, null, NexusVisitors.class);
					
					
					return visitorsList;
				}
		
				
		
}


		
	