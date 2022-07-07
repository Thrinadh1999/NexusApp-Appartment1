<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>

<link
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/MonthPicker.css" rel="stylesheet"
	type="text/css" />
<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
	<span class="AppartmentDetails"></span>
	<div class="container row">
		<div class="col-md-9">
			<div>
				<h1>
					<large>Appartments List</large>
				</h1>
				<hr>
			</div>
			<icon type="icon" class="icon-block" data-toggle="modal"
				data-target="#myModal">
		</div>
		<table id="datatable" class="table">
			<thead>
				<tr>
					<th>Apartment Name</th>
					<th>Apartment Owner</th>
					<th>Number</th>
					<th>Apartment Status</th>
					<th>Description</th>
					<th>Block Name</th>
					<th>Floor No</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${ad}' var="ad">
					<tr>
						<td>${ad.appartmentName}</td>
						<td>${ad.appartmentOwner}</td>
						<td>${ad.number}</td>
						<td>${ad.appartmenStatus}</td>
						<td>${ad.description}</td>
						<td>${ad.blockId}</td>
						<td>${ad.floorId}</td>
						<td><a class="editNexusAppAppartment"
							data-appartmentName="${ad.appartmentName }"
							data-appartmentOwner="${ad.appartmentOwner }"
							data-appartmenStatus="${ad.appartmenStatus }"
							data-description="${ad.description }"
							data-blockId="${ad.blockId }" data-floorId="${ad.floorId }">Edit</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="editDepartmentModal" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Edit Apartment Details</h4>
					</div>
					<div class="modal-body">
						<form:form modelAttribute="newNexusAppAppartmentEdit"
							action="editNexusAppAppartmentPage" id="editDepartment"
							class="form-horizontal form-label-left" method="POST">
							<form:input id="middle-name" maxlength="2" class="form-control"
								type="hidden" path="departmentId"></form:input>.
										<div class="item form-group">
								<label class="col-form-label col-md-4 col-sm-4 label-align"
									for="appartmentName">Apartment Name <span
									class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<form:input type="text" id="appartmentName"
										path="appartmentNamev" required="required"
										class="form-control "></form:input>
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-4 col-sm-4 label-align"
									for="appartmentOwner">Appartment Owner <span
									class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<form:textarea type="text" id="appartmentOwner"
										path="appartmentOwner" required="required"
										class="form-control"></form:textarea>
								</div>
							</div>
							<div class="item form-group">
								<label for="number"
									class="col-form-label col-md-4 col-sm-4 label-align">Number</label>
								<div class="col-md-6 col-sm-6 ">
									<form:input id="number" maxlength="10" size="10"
										class="form-control" type="text" path="number"
										required="required"></form:input>
								</div>
							</div>
							<div class="item form-group">
								<label for="appartmenStatus"
									class="col-form-label col-md-4 col-sm-4 label-align">Appartment
									Status</label>
								<div class="col-md-6 col-sm-6 ">
									<form:input id="appartmenStatus" maxlength="5" size="5"
										class="form-control" type="text" path="appartmenStatus"
										required="required"></form:input>
								</div>
							</div>
							<div class="item form-group">
								<label for="description"
									class="col-form-label col-md-4 col-sm-4 label-align">description</label>
								<div class="col-md-6 col-sm-6 ">
									<form:input id="description" maxlength="250" size="250"
										class="form-control" type="text" path="description"
										required="required"></form:input>
								</div>
							</div>
							<div class="item form-group">
								<label for="blockId"
									class="col-form-label col-md-4 col-sm-4 label-align">blockId</label>
								<div class="col-md-6 col-sm-6 ">
									<form:input id="blockId" class="form-control" type="text"
										path="blockId" required="required"></form:input>
								</div>
							</div>
							<div class="item form-group">
								<label for="floorId"
									class="col-form-label col-md-4 col-sm-4 label-align">floorId</label>
								<div class="col-md-6 col-sm-6 ">
									<form:input id="floorId" class="form-control" type="text"
										path="floorId" required="required"></form:input>
								</div>
							</div>

							<div class="item form-group">
								<div class="col-md-6 col-sm-6 offset-md-3 text-center">
									<form:button id="submit-button" type="submit"
										class="btn btn-success">Update</form:button>
									<button id="cancel-button2" type="button"
										class="btn btn-danger">Cancel</button>
								</div>
						</form:form>



					</div>
				</div>

			</div>
		</div>
	</div>
	<label for="appartment-select">Choose a Appartment:</label> <select
		id="appartment-select">
		<option value="">--Please choose a Appartment--</option>
		<c:forEach items='${ad}' var="appartmentdetails">
			<option value="appartmentname">${appartmentdetails.appartmentName}</option>
		</c:forEach>
	</select>
	<div class="iframeNexusAppAdmin">
		<iframe id="appartmentiframe" src="getAppartmentIframe"
			title="Appartment Details"></iframe>
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
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"</script>
<script
	src="bower_components/jquery.maskedinput/dist/jquery.maskedinput.min.js"></script>
<script>
	$('#cancel-button').on('click', function() {
		$('#myModal').modal('hide');
	});
	$('#submit-button').on('click', function() {
		$('#demo-form2').submit();
	});
	$('#appartmentOwner').change(function() {
		var userid = $('option:selected', this).attr('data-usermobile');
		$('#number').val(userid);
	})
</script>




