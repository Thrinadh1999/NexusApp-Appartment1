package com.pranaveet.NexusApp.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
//import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;
//import com.google.common.io.Files;
import com.pranavaeet.NexusApp.common.NexusAppAppartment;
import com.pranavaeet.NexusApp.common.NexusAppBlocks;
import com.pranavaeet.NexusApp.common.NexusAppFloor;
import com.pranavaeet.NexusApp.common.NexusAppVenture;
import com.pranavaeet.NexusApp.common.NexusAppVisitors;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.utils.JsonMapper;

//import javax.servlet.http.HttpSession;



@RestController
public class LoginNexusAppController {
	final static Logger logger = LogManager.getLogger();
	@Autowired
	ObjectDAO objectDAO;
	@Autowired
	JsonMapper jsonMapper;
//Users Module
	//to generate Otp
@GetMapping(value="nexusapp/generateOtp")
	@ResponseBody
	public String getRequest(@RequestParam("phonenumber") String phonenumber) {
	Map<String,Object> v1= objectDAO.singleResultSelect("SELECT COUNT(*) as count FROM users_nexusapp where userMobile=? ", new String[] {phonenumber});//checking for the mobile number in the user table with respective to the count
	Long counting= (Long) v1.get("count");
	 Integer number = counting.intValue();	
		if(phonenumber == "") {
				return "no data";
			}else if(number == 0) {
				return "not exist";
			}else if (number == 1 ) {
				String otp= new DecimalFormat("00000").format(new Random().nextInt(99999)); //otp generate using random numbers
				Map<String,Object> notp= objectDAO.singleResultSelect("SELECT COUNT(*) as count FROM otp_nexusapp where number=? ", new String[] {phonenumber});//checking the number in the otp table
				Long cnt= (Long) notp.get("count");
				 Integer nno = cnt.intValue();	
				 if(nno == 0) {
				objectDAO.addOrUpdate(SQL_QUERIES.addOtpToMobileNo, new String[] {phonenumber,otp});//adding otp for the requested mobile number if exists in the user table and not present in the otp table
				 }
				 
				// else if(nno == 1){
				//	 objectDAO.addOrUpdate(SQL_QUERIES.updateOtp, new String[] {otp,phonenumber});
				//}
		 if (number >=1) {
			 objectDAO.addOrUpdate(SQL_QUERIES.updateOtp,new String[] {otp,phonenumber});//updating otp in otp table if mobile number exists in both the tables(users,otp)
		 }
		System.out.println(otp);
    return (otp);
			}
		return phonenumber;
}
//to validate otp from request
@GetMapping(value="nexusapp/validateOtp")
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
//get the user details with respective to the mobile number
@GetMapping(value="nexusapp/getUserDetails")
@ResponseBody
public Map<String, Object> getNexusappUserByRole(@RequestParam("phonenumber")String number) {
	Map<String,Object>userDetails=(Map<String,Object>)objectDAO.singleResultSelect(SQL_QUERIES.getUserListByNumber, new String[] {number});
	System.out.println();

	return userDetails;

}
//to send user role for the requested number
@GetMapping(value="nexusapp/getRole")
@ResponseBody
public String getRole(@RequestParam("phonenumber") String phonenumber) {
logger.info(phonenumber);
Map<String,Object> role= objectDAO.singleResultSelect("SELECT users_nexusapp.userRole FROM users_nexusapp where userMobile=?", new String[] {phonenumber});
String rolen= (String)role.get("userRole");
return rolen;
}
//Visitors Module
//add visitors Details by WM
@PostMapping(value = "nexusapp/addVisitor&VisitorDetails",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
@ResponseBody
public Integer addNexusAppVisitorsDetails (HttpServletRequest request,@RequestParam("visitorDetails") JSONObject visitorDetails,@RequestParam("imagePath") MultipartFile file) {
	logger.info(file);
	logger.info(visitorDetails);
	//logger.info(file);
Map<String,Object> visDet = new HashMap<String,Object>();
visDet=jsonMapper.toMap(visitorDetails);
logger.info(visDet);
NexusAppVisitors vd = new NexusAppVisitors();
	
	//JSON to String
	vd.setTypeOfVisitor(visDet.get("typeOfVisitor").toString());
	vd.setAppartmentName(visDet.get("apartmentName").toString());
	vd.setBlockName(visDet.get("blockName").toString());
	vd.setName(visDet.get("name").toString());
	vd.setMobile(visDet.get("mobile").toString());
	vd.setOutTime(visDet.get("outTime").toString());
	vd.setOutDate(visDet.get("outDate").toString());
	vd.setElapsedTime(visDet.get("elapsedTime").toString());
	vd.setExpectedTime(visDet.get("expectedTime").toString());
	vd.setImagePath("/home/smssols/Desktop/Nexus/NexusVisitorsPics/"+vd.getName()+"_"+vd.getTypeOfVisitor()+".jpg");
	File dir = new File ("/home/smssols/Desktop/Nexus/NexusVisitorsPics/"+vd.getName()+ "_"+vd.getTypeOfVisitor()+".jpg");
	objectDAO.addOrUpdate(SQL_QUERIES.addVisitorNexusDetails, new String[] {vd.getTypeOfVisitor(),vd.getAppartmentName(),vd.getBlockName(),vd.getName(),vd.getMobile(),vd.getOutTime(),vd.getOutDate(),vd.getElapsedTime(),vd.getExpectedTime(),vd.getImagePath()});
	try {
		Files.write( file.getBytes(),dir);
		logger.info("Visitor added successfully");
	} catch (IOException nvd) {
		// TODO Auto-generated catch block for Nexus visitors Page
		nvd.printStackTrace();
	}
return 1;

}
//to send visitors details

@GetMapping(value="nexusapp/getVisitorsDetails",produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public List<NexusAppVisitors> getNexusAppVisitorProfileList(HttpServletRequest request, HttpSession session) {
	@SuppressWarnings("unchecked")
	List<NexusAppVisitors> visitorProfileList = (List<NexusAppVisitors>) objectDAO.multipleResultSelect(SQL_QUERIES.getVisitorNexusDetails, null, NexusAppVisitors.class);
	for(NexusAppVisitors up:visitorProfileList) {
		try {
        	BufferedImage image = ImageIO.read(new File(up.getImagePath()));
	        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", byteArrayOutputStream);
			String imageString = Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
			byteArrayOutputStream.flush();
			byteArrayOutputStream.close();
			up.setImagePath(imageString);
			
		} catch (IOException ip) {
			// TODO Auto-generated catch block
			ip.printStackTrace();
		}
		
	}
	return visitorProfileList;

}
//venture module
//to get venture list
@GetMapping(value="nexusapp/getVentureDetails")
@ResponseBody
public List<NexusAppVenture>getNexusAppVentureList(HttpServletRequest request, HttpSession session){
	@SuppressWarnings("unchecked")
	List<NexusAppVenture> ventureDetails=(List<NexusAppVenture>) objectDAO.multipleResultSelect(SQL_QUERIES.getVentureDetails , null, NexusAppVenture.class);
	return ventureDetails;
}
//block module
//to get block details
@GetMapping(value="nexusapp/getBlockDetails")
@ResponseBody
public List<NexusAppBlocks>getNexusAppBlocksList(HttpServletRequest request, HttpSession session){
	@SuppressWarnings("unchecked")
	List<NexusAppBlocks> blockDetails=(List<NexusAppBlocks>) objectDAO.multipleResultSelect(SQL_QUERIES.getBlockDetails , null, NexusAppBlocks.class);
	return blockDetails;
}
//floor module
//to get floor details
@GetMapping(value="nexusapp/getFloorDetails")
@ResponseBody
public List<NexusAppFloor>getNexusAppFloorList(HttpServletRequest request, HttpSession session){
	@SuppressWarnings("unchecked")
	List<NexusAppFloor> floorDetails=(List<NexusAppFloor>) objectDAO.multipleResultSelect(SQL_QUERIES.getFloorDetails , null, NexusAppFloor.class);
	return floorDetails;
}
//appartment module
//get appartment details
@GetMapping(value="nexusapp/getApartmentDetails")
@ResponseBody
public List<NexusAppAppartment>getNexusAppAppartmentList(HttpServletRequest request, HttpSession session){
	@SuppressWarnings("unchecked")
	List<NexusAppAppartment> appartmentDetails=(List<NexusAppAppartment>) objectDAO.multipleResultSelect(SQL_QUERIES.getAppartmentDetails , null, NexusAppAppartment.class);
	return appartmentDetails;
}
//to add appartment Details
@GetMapping(value = "app/addAppartmentDetails", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public Integer getFlatDetails(@RequestParam("phoneNumber") JSONObject numbers) {
//getting the values in JSON format
Map<String,Object> apprtMap = new HashMap<String,Object>();
//Double flatdetails = (Double) jsonMap.get("id");
//String fdet = String.valueOf(flatdetails);
apprtMap=jsonMapper.toMap(numbers);
	logger.info(apprtMap);
	//JSON to String
	String appartmentName = apprtMap.get("appartmentName").toString();
	String appartmentOwner = apprtMap.get("appartmentOwner").toString();
	String number = apprtMap.get("number").toString();
	String appartmenStatus = apprtMap.get("appartmenStatus").toString();
	String description = apprtMap.get("description").toString();
	//sending the Get values to database
	objectDAO.insertAndGetResult(SQL_QUERIES.addNexusapartments, null, new String[] {appartmentName,appartmentOwner,number,appartmenStatus,description});
	
return 1;
}

}




