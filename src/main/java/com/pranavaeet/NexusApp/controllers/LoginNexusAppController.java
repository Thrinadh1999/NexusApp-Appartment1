package com.pranavaeet.NexusApp.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.utils.JsonMapper;


@RestController
public class LoginNexusAppController {
	@Autowired
	ObjectDAO objectDAO;
	JsonMapper jsonMapper;

@GetMapping(value="nexusapp/getlogindetails")
	@ResponseBody
	public String getRequest(@RequestParam("phonenumber") String phonenumber) {
	Map<String,Object> v1= objectDAO.singleResultSelect("SELECT COUNT(*) as count FROM users_nexusapp where userMobile=? ", new String[] {phonenumber});	
	Long counting= (Long) v1.get("count");
	 Integer number = counting.intValue();			
		if(number==0) {
				return "number not exists";
			}	

	return "08539";
}
}