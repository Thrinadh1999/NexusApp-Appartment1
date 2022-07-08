<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
	<span class="VisitorDetails"></span>
	<div class="container row">
		<div class="col-md-9">
			<div>
				<h1>
					<large>Visitor Details</large>
				</h1>
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
				<th>Type Of Visitor</th>
				<th>Apartment Name</th>
				<th>Block Name</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>In Time</th>
				<th>In Date</th>
				<th>Out Time</th>
				<th>Out Date</th>
				<th>elapsedTime</th>
				<th>expectedTime</th>
				<th>Image Path</th>
				
				
				
				
			</tr>
		</thead>
		<tbody>
		<c:forEach items='${visd}' var="vis">
				<tr>
					<td>${vis.id}</td>
					<td>${vis.typeOfVisitor}</td>
					<td>${vis.appartmentName}</td>
					<td>${vis.blockName}</td>
					<td>${vis.name}</td>
					<td>${vis.mobile}</td>
					<td>${vis.inTime}</td>
					<td>${vis.inDate}</td>
					<td>${vis.outTime}</td>
					<td>${vis.outDate}</td>
					<td>${vis.elapsedTime}
					<td>${vis.expectedTime}
					<td>${vis.imagePath}</td>

				</tr>
				</c:forEach>
		</tbody>
	</table>


	<!-- Trigger the modal with a button -->
	<!-- Model -->
	


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

<script>
$('#cancel-button').on('click', function() {
	$('#myModal').modal('hide');
});
$('#submit-button').on('click', function() {
	$('#demo-form2').submit();
});
</script>




