<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="Includes/HeaderScripts.jsp"%>

</head>
<body class="nav-md footer_fixed">
	<div class="container body">
		<div class="main_container">
			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="browserOnly">
							<div class="x_content">
								<a href="home"><img src="resources/images/logo.png" style="display:inline-block;height:55px;"/></a>
								<h4 style="font-size:18px;margin:0px 25px 0 0;font-weight:900;color:white;line-height:1em;padding-left:15px;display:inline-block;">Jobs Portal <br>
								<span class="username">Privacy Policy</span></h4>
							</div>
						</div>
						<div class="mobileOnly">
							<div class="x_content" style="margin-top:15px;">
								<img src="resources/images/logo.png" style="display:inline-block;height:50px;float:right;"/>
								<a href="home"><h4 style="font-size:15px;margin:15px 25px 0 15px;font-weight:900;color:white;display:inline-block;float:left;">Jobs Portal<br>
								<span class="username">Privacy Policy</span></h4></a>
							</div>
							
						</div>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->
			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="row">
						<div class="clearfix"></div>
						<div class="x_content">
							<div class="container">
								<h3 align="center">Privacy Policy</h3>
								<br>
								<p>
									<strong>Introduction</strong>
								</p>
								<p>
									This Privacy Policy is meant to help users of "Jobs Portal" web
									application understand what information Pranava EET collects, why we
									collect it, and how users can update, manage, export, and delete their
									information.
								</p>
								<p>
									Effective July 1, 2020
								</p>
								<p>
									<strong>Changes to this policy</strong>
								</p>
								<p>
									Pranava EET can change this Privacy Policy from time to time. However, any
									change shall not reduce our users' rights under this Privacy Policy without
									our users' explicit consent. Pranava EET will always indicate the date the
									last changes were published and will offer unrestricted access to archived
									versions for our users' review. If changes are significant, Pranava EET
									will provide an email notification of Privacy Policy changes.
								</p>
								<p>
									<strong>Information Collection </strong>
								</p>
								<p>
									Jobs Portal is primarily an intra-company application. Users cannot directly
									create accounts to access the Jobs Portal application. Pranava EET will
									authorize users and create user accounts that allow access to the Jobs Portal
									application.
								</p>
								<p>
									When a user account is created, Pranava EET collects personal information
									like name, email address, mobile phone number, and optionally residential
									address. This information will be used to authenticate our users, and
									occasionally communicate updates about their job application and other services related to the Jobs Portal.
								</p>
								<p>
									Pranava EET also collects the content users create after logging in and
									access Jobs Portal application and its services. This includes responses provided by the users 
									to questions related to one or more job application(s), and any file(s) related to the job application. 
								</p>
								<p>
									<strong>Information Usage </strong>
								</p>
								<p>
									All content created by users will be used/processed by Pranava EET as deemed fit to process
									a user's job application. All content created inside the Jobs Portal application will be the 
									sole property of Pranava EET and Pranava EET may use this data to contact the users at any point of time.
								</p>
								<p>
									<strong>Sharing User Information</strong>
								</p>
								<p>
									Pranava EET will not share users' personal information with companies,
									organizations, or individuals outside of Pranava EET. Jobs Portal
									is an intra-company application, and information of users will be visible to 
									authorized users within Pranava EET. 
								</p>
								<p>
									<strong>Keeping your information secure</strong>
								</p>
								<p>
									Jobs Portal is built with smart security infrastructure that
									protects against any unwanted intrusions. All requests processed by Jobs Portal Application are encrypted. This guarantees that the information
									users enter is securely sent to the server and cannot be understood by any unwanted intruders.
								</p>
								<p>
									<strong>Exporting and Deleting your information</strong>
								</p>
								<p>
									Since Jobs Portal is an intra-company application, users cannot
									export/delete their user account. Access and privilege to delete or export content 
									created within the Jobs Portal application rests solely with Pranava EET.
								</p>
								<p>
									<strong>Compliance </strong>
								</p>
								<p>
									Pranava EET will regularly review this Privacy Policy and make sure that
									user information is processed in ways that comply with it. All application
									servers of Jobs Portal are located in India.
								</p>
								<p>
									<strong>Complaints &amp; Resolution</strong>
								</p>
								<p>
									When we receive complaints from our users, Pranava EET will respond by
									contacting the person who made the complaint. Pranava EET will work with
									the appropriate regulatory authorities, including local data protection,
									and/or law enforcement authorities, to resolve any issues regarding the
									complaint.
								</p>
				
							</div>
						</div>
					</div>
				</div>
				<div style="height: 50px"></div>
			</div>
			<%@ include file="Includes/Footer.jsp"%>
		</div>
	</div>
	<!-- /page content -->
	<!-- jQuery -->
	<script src="resources/vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="resources/build/js/custom.js"></script>
</body>
</html>