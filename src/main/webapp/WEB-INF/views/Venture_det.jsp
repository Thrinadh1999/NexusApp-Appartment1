<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="Includes/IframeHeaderScripts.jsp"%>
<body id="iframe-body">
	<div class="iframe_content">
	<label for="venture-select">Choose a Venture:</label> <select
		id="venture-select">
		<option value="">--Please choose an option--</option>
		<c:forEach items='${vdi}' var="ventureDetails">

			<option value="venturename">${ventureDetails.ventureName}</option>
		</c:forEach>
	</select>
	
		<table id="datatable" class="table">
							<thead>
							
								<tr>
									<th>Venture Name</th>
									<th>Venture Address</th>
									<th>Description</th>
									<th>No Of Blocks</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items='${vdi}' var="venturedetails">
								<c:if test="${venturedetails.ventureName   eq 'Test Venture 2'}">
								<tr>
									<td>${venturedetails.ventureName }</td>
									<td>${venturedetails.ventureAddress}</td>
									<td>${venturedetails.description}</td>
									<td>${venturedetails.no_of_blocks}</td>
								</tr>
								</c:if>
								</c:forEach>
							</tbody>
	</div>

	<%@ include file="Includes/IframeFooterScripts.jsp"%>
	<!-- /Datatables -->
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
</body>
