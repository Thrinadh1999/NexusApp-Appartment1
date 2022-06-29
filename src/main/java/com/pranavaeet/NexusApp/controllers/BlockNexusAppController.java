package com.pranavaeet.NexusApp.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;
import com.pranavaeet.NexusApp.common.NexusAppAppartment;
import com.pranavaeet.NexusApp.common.NexusAppBlocks;
import com.pranavaeet.NexusApp.common.NexusAppFloor;
import com.pranavaeet.NexusApp.common.NexusAppMonthlyPayments;
import com.pranavaeet.NexusApp.common.NexusAppUsers;
import com.pranavaeet.NexusApp.common.NexusAppVenture;

@Controller
public class BlockNexusAppController {
	final static Logger logger = LogManager.getLogger();
	@Autowired
	ObjectDAO objectDAO;

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/nexusblockdetails")
	public ModelAndView getBlockDetails(HttpServletRequest request, HttpSession session) {
		List<NexusAppVenture> ventureList = (List<NexusAppVenture>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getVentureDetails, null, NexusAppVenture.class);
		List<NexusAppBlocks> blockList = (List<NexusAppBlocks>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getBlockDetails, null, NexusAppBlocks.class);
		List<NexusAppFloor> floorList = (List<NexusAppFloor>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getFloorDetails, null, NexusAppFloor.class);
		List<NexusAppUsers> userList = (List<NexusAppUsers>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getUserListbyrole, null, NexusAppUsers.class);
		List<NexusAppMonthlyPayments> paymentList = (List<NexusAppMonthlyPayments>) objectDAO
				.multipleResultSelect(SQL_QUERIES.getPaymentsDetails, null, NexusAppMonthlyPayments.class);
		List<Map<String, Object>> v1 = objectDAO.multipleResultSelect(SQL_QUERIES.joinBlock_Floor, null);
		ModelAndView page =new ModelAndView();
		page.addObject("vl", ventureList);
		page.addObject("bl", blockList);
		page.addObject("fl", floorList);
		page.addObject("ul", userList);
		page.addObject("pl", paymentList);
		page.addObject("v1", v1);


		page.setViewName("NexusAppBlock");
		page.addObject("newNexusappBlocks", new NexusAppBlocks());
		page.addObject("newNexusappAppartment", new NexusAppAppartment());

		return page;
	}

	@PostMapping(value = "/addnexusappblocks")
	public ModelAndView addNexusAppBlocks(@ModelAttribute NexusAppBlocks newNexusAppBlocks, HttpServletRequest request,
			HttpSession session) {
		
		objectDAO.addOrUpdate(SQL_QUERIES.addBlockDetails,
				new String[] { newNexusAppBlocks.getBlockName(), newNexusAppBlocks.getVentureId(),newNexusAppBlocks.getNo_of_floors(),newNexusAppBlocks.getNo_of_appartments()});
		String fullblockname = newNexusAppBlocks.getBlockName();
		String blockName=fullblockname.split("")[0];
        int tfl=Integer.valueOf(newNexusAppBlocks.getNo_of_floors());
        int tapt=Integer.valueOf(newNexusAppBlocks.getNo_of_appartments());
        String aptList="";
        
            for(int floor=1; floor<=tfl; floor++){
                for(int appartment=1; appartment<=tapt; appartment++){
                    
                    String value="(";
                    String val1=blockName;
                    String val2=String.valueOf(floor);
                    String val3=String.valueOf(appartment);
                    value += "'"+val1;
                    if(appartment<=9){
                   value += val2+"0"+val3;
                    }
                    else{
                        value+= val2+val3;
                    }
                    value+="', '1', '"+fullblockname+"', "+val2+"),";
                    aptList+=value;
                }
                
            }
  
        if (aptList != null && aptList.length() > 0 && aptList.charAt(aptList.length() - 1) == ',') {
            aptList = aptList.substring(0, aptList.length() - 1);
        }
        /**
         * this type of objectDAO implementation is used when inserting multiple rows into tables using a single string
         * @author Trinadh Reddy 
         */
        objectDAO.addOrUpdate("INSERT INTO appartment_nexusapp(appartmentName,appartmenStatus,blockId,floorId ) VALUES"+aptList+"" , null);

		return new ModelAndView("redirect:/nexusblockdetails");
	}
	
	@GetMapping(value="/getAppartmentIframe")
	public ModelAndView getaprtDet(HttpServletRequest request, HttpSession session) {
	@SuppressWarnings("unchecked")
	List<NexusAppAppartment> aprtlist = (List<NexusAppAppartment>) objectDAO
	.multipleResultSelect(SQL_QUERIES.addAppartmentDetailsbyBlockId, null, NexusAppAppartment.class);
	ModelAndView page =new ModelAndView();
	page.setViewName("Appartment_det");
	page.addObject("al", aprtlist);
	return page;
	}
}
