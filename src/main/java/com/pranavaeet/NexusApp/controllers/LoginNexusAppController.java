package com.pranavaeet.NexusApp.controllers;

import java.text.DecimalFormat;
//import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.utils.JsonMapper;


@RestController
public class LoginNexusAppController {
	final static Logger logger = LogManager.getLogger();
	@Autowired
	ObjectDAO objectDAO;
	JsonMapper jsonMapper;

@GetMapping(value="nexusapp/generateOtp")
	@ResponseBody
	public String getRequest(@RequestParam("phonenumber") String phonenumber) {
	Map<String,Object> v1= objectDAO.singleResultSelect("SELECT COUNT(*) as count FROM users_nexusapp where userMobile=? ", new String[] {phonenumber});
	Long counting= (Long) v1.get("count");
	 Integer number = counting.intValue();			
		if(phonenumber == "") {
				return "no data";
			}else if(number == 0) {
				return "not exist";
			}
		String otp= new DecimalFormat("00000").format(new Random().nextInt(99999));
		System.out.println(otp);
		 objectDAO.addOrUpdate(SQL_QUERIES.addOtpToMobileNo, new String[] {phonenumber,otp});
		System.out.println(otp);
  
    return otp;
}



@GetMapping(value="nexusapp/validateOtp")
@ResponseBody
public String getOtpValidation(@RequestParam("otp") String otp, @RequestParam("phonenumber")String number) {
	logger.info(otp);
	logger.info(number);	
	//count=objectDAO.singleResultSelect(SQL_QUERIES.otpValidation, new String[] {});

return "1";
   

}
}



