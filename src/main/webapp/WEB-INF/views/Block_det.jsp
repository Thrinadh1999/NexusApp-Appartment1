<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="Includes/IframeHeaderScripts.jsp"%>
<body id="iframe-body">
	<div class="iframe_content">	
	<div class="block1">
	<div class="right_col" role="main">
	<span class="BlockDetails"></span>
	<div class="container row">

	</div>
		
		
			<table id="datatable" class="table">
				<thead>
					<tr>
						<th>Block Id</th>
						<th>Block Name</th>
						<th>Venture Name</th>
						<th>No of Floors</th>
						<th>No of Appartments</th>
					</tr>
				</thead>
					<tbody>
						<c:forEach items='${bd}' var="blockdetails">
							<tr>
								<td>${blockdetails.blockId }</td>
								<td>${blockdetails.blockName}</td>
								<td>${blockdetails.ventureId}</td>
								<td>${blockdetails.no_of_floors}</td>
								<td>${blockdetails.no_of_appartments}</td>
							</tr>
							</c:forEach>
					</tbody>
					</table>
		
	


	<!-- Trigger the modal with a button -->
	<!-- Model -->
	
</div>
</div>	
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
<script>
	$('#cancel-button').on('click', function() {
		$('#myModal').modal('hide');
	});
	$('#submit-button').on('click', function() {
		$('#demo-form2').submit();
	});
</script>
