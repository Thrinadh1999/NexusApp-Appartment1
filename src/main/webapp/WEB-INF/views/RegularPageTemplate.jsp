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
<sec:authorize access="hasRole('ROLE_USER')">
	<body class="nav-md footer_fixed">
		<div class="container body">
			<div class="main_container">
				<%@ include file="Includes/SideMenuBar.jsp"%>
				<%@ include file="Includes/TopNavigationBar.jsp"%>

				<!-- page content -->
				<div class="right_col" role="main">
					<div class="">
						<div class="row">
							<div class="clearfix"></div>
							<h4 class="center-text">Welcome User. This is Home Page.</h4>
						</div>
					</div>
					<div style="height: 50px"></div>
				</div>
				<%@ include file="Includes/Footer.jsp"%>
			</div>
		</div>
		<!-- /page content -->
		<%@ include file="Includes/FooterScripts.jsp"%>
	</body>
</sec:authorize>
</html>