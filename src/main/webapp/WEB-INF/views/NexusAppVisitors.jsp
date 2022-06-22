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
		<div class="col-md-12">
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i> Add Visitor
			</button>
		</div>

	</div>



	<table id="datatable" class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>typeOfVisitor</th>
				<th>appartmentName</th>
				<th>blockName</th>
				<th>name</th>
				<th>mobile</th>
				<th>inTime</th>
				<th>inDate</th>
				<th>outTime</th>
				<th>outDate</th>
				<th>imagePath</th>
				
				
				
				
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
					<td>${vis.imagePath}</td>

				</tr>
				</c:forEach>
		</tbody>
	</table>


	<!-- Trigger the modal with a button -->
	<!-- Model -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Visitor</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newNexusappVisitors"
						action="addnexusappvisitors" id="demo-form2"
						class="form-horizontal form-label-left" method="POST">
						<form:input id="id" maxlength="2" class="form-control"
							type="hidden" path="id"></form:input>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="typeOfVisitor">typeOfVisitor<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="typeOfVisitor" class="form-control " path="typeOfVisitor">
									<c:forEach items='${vtl}' var="vtl">
										<form:option value="${vtl.visitorType}"> ${vtl. visitorType}</form:option>
									</c:forEach>

								</form:select>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="appartmentName">Appartment Name<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="appartmentName" class="form-control " path="appartmentName">
									<c:forEach items='${al}' var="al">
										<form:option value="${al.appartmentName }"> ${al.appartmentName}</form:option>
									</c:forEach>

								</form:select>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for=blockName>blockName<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="blockName" class="form-control " path="blockName">
									<c:forEach items='${bl}' var="bl">
										<form:option value="${bl.blockName}"> ${bl.blockName}</form:option>
									</c:forEach>

								</form:select>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="name">name<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="name" path="name"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="mobile">mobile<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" maxlength="10" size="10" id="mobile" path="mobile"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="outTime">outTime<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="outTime" path="outTime"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="outDate">outDate<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="outDate" path="outDate"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="imagePath">imagePath<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="imagePath" path="imagePath"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						
						<div class="ln_solid"></div>
						<div class="item form-group">
							<div class="col-md-6 col-sm-6 offset-md-3 text-center">
								<form:button id="submit-button" type="submit"
									class="btn btn-success">Submit</form:button>

								<button id="cancel-button" type="button" class="btn btn-danger">Cancel</button>
							</div>

						</div>

					</form:form>



				</div>
			</div>

		</div>
	</div>



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




