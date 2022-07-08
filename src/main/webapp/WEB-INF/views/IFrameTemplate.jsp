<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.util.List"%>


<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="Includes/HeaderScripts.jsp"%>

</head>
<body class="container body no_margin">
	<div class="main_container no_margin">
		<div class="right_col no_margin">
			<!-- page content -->
			<div class="col-md-12 col-xs-12 col-sm-12">
				<div class="x_content no_margin">
					<h4>This is Iframe Content.</h4>
					<br />
					<p>This page has no menu options and is supposed to be used
						inside an Iframe</p>
					<p>Iframes are used for displaying nested contents. They are
						especially useful for displaying AJAX content, while still
						retaining the functionality of a full page.</p>
					<p>You can use this template to create views for Iframes</p>
				</div>
			</div>
		</div>
	</div>
	<!-- /page content -->
	<%@ include file="Includes/FooterScripts.jsp"%>
</body>
</html>