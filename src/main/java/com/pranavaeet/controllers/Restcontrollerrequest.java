package com.pranavaeet.controllers;


//import java Libraries
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
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;

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
	//private static final MultipartFile[] Image = null;
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
	//getting the url with details in request
	@GetMapping(value="app/getdetails")
	@ResponseBody
	public Integer getRequest(@RequestParam("username") String username, @RequestParam("password") String password) {	
		//details are sent to the server in the form of url through api
		//the details are sending to the database from server
		Map<String,Object> value1= objectDAO.singleResultSelect("SELECT DISTINCT IF(u.phonenumber = ? ,'VALID', 'INVALID')AS 'STATUS' FROM nexus_users u WHERE u.username  = ?", new String[] {password,username});			
		//condition for the username and password validation for login page
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
	//to get the request to server in the form of url request
	@GetMapping(value="app/signupdetails")
	@ResponseBody
	public String addRequest(@RequestParam("fullname") String fullname,@RequestParam("username") String username, @RequestParam("phonenumber") String phonenumber) {
		//getting the count of users in users table of the selected user name from the database
		Map<String,Object> count = objectDAO.singleResultSelect("SELECT COUNT(*) as count FROM nexus_users where username=? ", new String[] {username});
		logger.info(username+" and number is "+phonenumber +"and id is");
		//converting from countlng to integer
		Long countlng = (Long) count.get("count");
		 Integer c = countlng.intValue();			
		logger.info(c);
		//validating the mabile number if mobile number exist in the database  a message is sent "number is existed"
		//if the mobile number is not existed the mobile number is stored in the database
		Map<String,Object> value2= objectDAO.singleResultSelect("SELECT COUNT(*) as count FROM nexus_users where phonenumber=? ", new String[] {phonenumber});
		Long counting= (Long) value2.get("count");
		 Integer d = counting.intValue();			
		logger.info(d);
		//validation of mobilenumber
		if(username=="" || fullname=="" || phonenumber=="" || username=="") {
				return "no data";
			}else if(c==0) {
				if(d!=0) {
					return "number is existed";
				}	
				//insert the values into the users table in database
			objectDAO.insertAndGetResult(SQL_QUERIES.addNexususers, "id", new String[] {username,fullname,phonenumber,username});
			return "true";
		
			}
			return "email is existed";
	   
	}
	
//This is for flat details
	@GetMapping(value = "app/flatdetails", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Integer flatdetails(@RequestParam("json") JSONObject json) {
	//getting the values in JSON format
	Map<String,Object> jsonMap = new HashMap<String,Object>();
	//Double flatdetails = (Double) jsonMap.get("id");
	//String fdet = String.valueOf(flatdetails);
	jsonMap=jsonMapper.toMap(json);
		logger.info(jsonMap);
		//JSON to String
		String flatName = jsonMap.get("name").toString();
		String mobilenumber = jsonMap.get("mobilenumber").toString();
		String flatNo = jsonMap.get("flatno").toString();
		String relationship = jsonMap.get("relationship").toString();
		String floor = jsonMap.get("floor").toString();
		//sending the Get values to database
		objectDAO.insertAndGetResult(SQL_QUERIES.addNexusapartments, null, new String[] {flatName,mobilenumber,relationship,floor,flatNo});
		
	return 1;
	}
 
 
	@GetMapping(value = "app/getflatdetails", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Nexus> appartmentlist(HttpServletRequest request, HttpSession session) {
		//sending the list of details from the url
		List<Nexus> aprtList = (List<Nexus>) objectDAO.multipleResultSelect(SQL_QUERIES.getNexusapartmentsList, null, Nexus.class);
		
		return aprtList;
	}
	
	
	
	
	//This is for userprofile details
		@GetMapping(value = "app/userprofiledetails")
		@ResponseBody
		public Integer userprofileRequest(@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("role") String role,@RequestParam("mobilenumber") String mobilenumber,@RequestParam("email") String email,@RequestParam("image") String image,@RequestParam("venturename") String venturename,@RequestParam("block") String block,@RequestParam("flatno") String flatno,@RequestParam("gender") String gender ) {
			//sending the get values from the url to the database 
			Integer id=objectDAO.insertAndGetResult(SQL_QUERIES.addNexususerprofiles, "id", new String[] {firstname,lastname,role,mobilenumber,email,image,venturename,block,flatno,gender});
			
			
		return id;
		
		}
		@GetMapping(value = "app/getuserprofiledetails", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<NexusUserProfiles> profileList(HttpServletRequest request, HttpSession session) {
			//sending the required detailes from the database to the requested url 
			List<NexusUserProfiles> profileList = (List<NexusUserProfiles>) objectDAO.multipleResultSelect(SQL_QUERIES.getNexususerprofileList, null, NexusUserProfiles.class);
			
			return profileList;
		}
		
		
	//This is for NOTICES details
			//sending the get values from the values to the database
		@GetMapping(value = "app/noticesdetails")
		@ResponseBody
		public Integer noticeRequest(@RequestParam("title") String title,@RequestParam("description") String description, @RequestParam("startdate") String startdate,@RequestParam("enddate") String enddate,@RequestParam("createdby") String createdby ) {
			//sending the values fromn the server to database with respect to id
			Integer id=objectDAO.insertAndGetResult(SQL_QUERIES.addNexusnotices, "id", new String[] {title,description,startdate,enddate,createdby});
			
			
		return id;
		
		}
		//to send the request list of details from the databbase notices to the requested url 
		@GetMapping(value = "app/getnoticesdetails", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<NexusNotices> noticeList(HttpServletRequest request, HttpSession session) {
			//to opt the notices data from database to the server in nexusnotiuces list
			List<NexusNotices> noticeList = (List<NexusNotices>) objectDAO.multipleResultSelect(SQL_QUERIES.getNexusnoticesList, null, NexusNotices.class);
			
			return noticeList;
		}
		
	//This is for visitor details
		//To capture the visitors Profile Data
				@PostMapping(value = "app/visitordetails",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
				@ResponseBody
				
				public Integer visitorRequest(HttpServletRequest request,@RequestParam("visitorDetails") JSONObject visitorDetails,@RequestParam("image") MultipartFile file) {
					Map<String,Object> visitorsDetailsMap = new HashMap<String,Object>();
					//Mapping the String Object
					visitorsDetailsMap=jsonMapper.toMap(visitorDetails);
					//Creating a Object
					NexusVisitors vp = new NexusVisitors();
					//Converting Map(Object) to String
					vp.setFullname(visitorsDetailsMap.get("fullname").toString());
					vp.setContactnumber(visitorsDetailsMap.get("contactnumber").toString());
					vp.setTypeofvisitor(visitorsDetailsMap.get("typeofvisitor").toString());
					vp.setFlatno(visitorsDetailsMap.get("flatno").toString());
					vp.setExpectedtime(visitorsDetailsMap.get("expectedtime").toString());
					vp.setOuttime(visitorsDetailsMap.get("outtime").toString());
					vp.setOutdate(visitorsDetailsMap.get("outdate").toString());
					vp.setElapsedtime(visitorsDetailsMap.get("elapsedtime").toString());
					//Setting the Image name with the visitor name with the extension .jpg
					vp.setImage("/home/smssols/Desktop/NexusPics/"+vp.getFullname()+".jpg");
					File dir = new File ("/home/smssols/Desktop/NexusPics/"+vp.getFullname()+".jpg");
					//sending the get values in to the database
					objectDAO.insertAndGetResult(SQL_QUERIES.addNexusvisitors, vp.getFullname(), new String[] {vp.getFullname(),vp.getContactnumber(),vp.getTypeofvisitor(),vp.getFlatno(),vp.getExpectedtime(),vp.getImage(),vp.getOuttime(),vp.getOutdate(),vp.getElapsedtime()});
						try {
							Files.write( file.getBytes(),dir);
							logger.info("visitor added successfully");
						} catch (IOException vpi) {
							// TODO Auto-generated catch block for Nexus visitors Page
							vpi.printStackTrace();
						}
				return 1;
				}
				//To send the visitors List from database to request api
				@GetMapping(value = "app/getvisitordetails", produces = MediaType.APPLICATION_JSON_VALUE)
				@ResponseBody
				public List<NexusVisitors> visitorsList(HttpServletRequest request, HttpSession session) {
					//to get the list of visitors from the database to server
					List<NexusVisitors> visitorsList = (List<NexusVisitors>) objectDAO.multipleResultSelect(SQL_QUERIES.getNexusvisitorsList, null, NexusVisitors.class);
					
					//returning the values to the visitorsList
					return visitorsList;
				}
		
				
		
}


		
	