<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>

<link href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="resources/css/MonthPicker.css" rel="stylesheet" type="text/css" />
<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
<span class="Users"></span>
	<div class="container row">
		<div class="col-md-9">
		<div>
			<h1><large>Users Details Nexus</large></h1>
			<hr>
			</div>
			
			<icon type="icon" class="icon-block" data-toggle="modal"
				data-target="#myModal">
		</div>

	</div>



	<table id="datatable" class="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>User Name</th>
				<th>Full Name</th>
				<th>Phone Number</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items='${udn}' var="userList">
      <tr>
      <td>${userList.id}</td>
      <td>${userList.username}</td>
      <td>${userList.fullname}</td>
      <td>${userList.phonenumber}</td>
      <td>${userList.email}</td>
			
	 </tr>
	 </c:forEach>
		</tbody>
	</table>
	
	
	<!-- Trigger the modal with a button -->



	</div>

	<!-- /page content -->

	<%@ include file="Includes/Footer.jsp"%>

	<%@ include file="Includes/FooterScripts.jsp"%>
	<!-- Datatables -->
	<script
		src="resources/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
	<script
		src="resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script
		src="resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script
		src="resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
	<script
		src="resources/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script
		src="resources/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script
		src="resources/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
	<script
		src="resources/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
	<script
		src="resources/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
	<script
		src="resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
	<script
		src="resources/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
		<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"</script>
<script src="bower_components/jquery.maskedinput/dist/jquery.maskedinput.min.js"></script>


	
	
	
	
	