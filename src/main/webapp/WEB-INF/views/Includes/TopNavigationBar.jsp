
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- top navigation -->
<div class="top_nav">
	<div class="nav_menu">
		<nav>
			<div class="browserOnly">
				<div class="x_content">
					<a href="home"><img src="resources/images/logo.png" style="display:inline-block;height:55px;"/></a>
					<h4 style="font-size:18px;margin:0px 25px 0 0;font-weight:900;color:white;line-height:1em;padding-left:15px;display:inline-block;">App Name<br>
					<span class="username">${sessionScope.profile.firstname} ${sessionScope.profile.lastname}</span></h4>
					
	                <a class="btn btn-app pull-right"  href="javascript:formSubmit()"><i class="fas fa-power-off fa-2x"></i><br><span class="btn-app-text">Logout</span></a>
	                
	                <a class="btn btn-app pull-right"  href="my-profile"><i class="far fa-user-circle fa-2x"></i><br><span class="btn-app-text">My Profile</span></a>
	                
	                <c:forEach var="feature" items="${featureList}">
	                <a class="btn btn-app pull-right" href="${feature.featureUrl}"><i class="${feature.featureIcon} fa-2x"></i><br><span class="btn-app-text">${feature.featureName}</span></a>
	                </c:forEach>
	               
				</div>
			</div>
			
			<div class="mobileOnly">
				<div class="x_content" style="margin-top:15px;">
					<img src="resources/images/logo.png" style="display:inline-block;height:50px;float:right;"/>
					<a href="home"><h4 style="font-size:15px;margin:15px 25px 0 15px;font-weight:900;color:white;display:inline-block;float:left;">App Name<br>
				
					<span class="username">${sessionScope.profile.firstname} ${sessionScope.profile.lastname}</span></h4></a>
					
					<c:forEach var="feature" items="${featureList}">
	                <a class="btn btn-app pull-right" href="${feature.featureUrl}"><i class="${feature.featureIcon} fa-2x"></i><br></a>
	                </c:forEach>
	                
				</div>
				
			</div>
		</nav>
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
		</script>
		
	</div>
</div>
<!-- /top navigation -->