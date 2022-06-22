/**package com.pranavaeet.NexusAppApi.controllers;

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
public class NumberRoleController {
	final static Logger logger = LogManager.getLogger();
	@Autowired
	ObjectDAO objectDAO;
	JsonMapper jsonMapper;

@GetMapping(value="nexusapp/generateOtp")
	@ResponseBody
	public String getRequest(@RequestParam("phonenumber") String phonenumber) {
	Map<String,Object> v1= objectDAO.singleResultSelect("SELECT COUNT(*),users_nexusapp.userRole as count FROM users_nexusapp where userMobile=? ", new String[] {phonenumber});
	Long counting= (Long) v1.get("count");
	 Integer number = counting.intValue();			
		if(phonenumber == "") {
				return "no data";
			}else if(number == 0) {
				return "not exist";
			}else if (number == 1 ) {
				String otp= new DecimalFormat("00000").format(new Random().nextInt(99999));
				System.out.println(otp);
				Map<String,Object> notp= objectDAO.singleResultSelect("SELECT COUNT(*) as count FROM otp_nexusapp where number=? ", new String[] {phonenumber});
				Long cnt= (Long) notp.get("count");
				 Integer nno = cnt.intValue();	
				 if(nno == 0) {
				objectDAO.addOrUpdate(SQL_QUERIES.addOtpToMobileNo, new String[] {phonenumber,otp});
				 }
				 
				 else if(nno == 1){
					 objectDAO.addOrUpdate(SQL_QUERIES.updateOtp, new String[] {phonenumber,otp});
				}
			}
			
		
		
		String otp= new DecimalFormat("00000").format(new Random().nextInt(99999));
		System.out.println(otp);
		
		 if (number >=1) {
			 objectDAO.addOrUpdate(SQL_QUERIES.updateOtp,new String[] {otp,phonenumber});
			 
		 }
		 else {
			 objectDAO.addOrUpdate(SQL_QUERIES.addOtpToMobileNo, new String[] {phonenumber,otp});
		
		}
		
		System.out.println(otp);
  
    return otp;
}



@GetMapping(value="nexusapp/validateOtp/role")
@ResponseBody
public String getOtpValidation(@RequestParam("otp") String otp, @RequestParam("phonenumber")String number) {
	logger.info(otp);
	logger.info(number);
	Map<String,Object>count=(Map<String, Object>) objectDAO.singleResultSelect(SQL_QUERIES.getCountOfNumber, new String[] {number,otp});
	Long valid= (Long) count.get("count");
	 Integer mnumber = valid.intValue();
	 if(mnumber == 1) {
		 return "valid";
	 }
	//count=objectDAO.singleResultSelect(SQL_QUERIES.otpValidation, new String[] {});

return "invalid";
   

}

}**/



