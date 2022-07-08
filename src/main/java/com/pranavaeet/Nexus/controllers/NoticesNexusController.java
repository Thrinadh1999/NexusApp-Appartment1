package com.pranavaeet.Nexus.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pranavaeet.Nexus.common.NoticesNexus;
import com.pranavaeet.common.ObjectDAO;
import com.pranavaeet.constants.SQL_QUERIES;

@Controller
public class NoticesNexusController {
	@Autowired
	ObjectDAO objectDAO;

	@GetMapping(value = "/noticeDetails")
	public ModelAndView getNoticeDetails(HttpServletRequest request, HttpSession session) {
		List<NoticesNexus> noticeDetails = (List<NoticesNexus>) objectDAO.multipleResultSelect(SQL_QUERIES.getNexusnoticesList, null, NoticesNexus.class);
		ModelAndView page = new ModelAndView();

		page.setViewName("Notices");

		page.addObject("nd", noticeDetails);
		page.addObject("nn", new NoticesNexus());
		return page;
	}

}
