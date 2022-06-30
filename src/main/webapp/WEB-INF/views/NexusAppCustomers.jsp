<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
	<span class="CustomerDetails"></span>
	<div class="container row">
		<div class="col-md-9">
			<div>
				<h1>
					<large>Customer's</large>
				</h1>
				<hr>
			</div>

			<icon type="icon" class="icon-block" data-toggle="modal"
				data-target="#myModal">
		</div>
		<div class="col-md-12">
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i> Add Customer
			</button>
		</div>

	</div>



	<table id="datatable" class="table">
		<thead>
			<tr>
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Customer Mobile</th>
				<th>Customer Address</th>
				<th>Customer Pincode</th>
				<th>Customer Role</th>
				<th>Venture Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${cd}' var="customerdetails">
				<tr>
					<td>${customerdetails.customerId}</td>
					<td>${customerdetails.customerName}</td>
					<td>${customerdetails.customerMobile}</td>
					<td>${customerdetails.customerAddress}</td>
					<td>${customerdetails.customerPincode}</td>
					<td>${customerdetails.customerRole}</td>
					<td>${customerdetails.ventureName}</td>

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
					<h4 class="modal-title">Add Customer</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newNexusappCustomer"
						action="addnexusappcustomer" id="demo-form2"
						class="form-horizontal form-label-left" method="POST">
						<form:input id="customerId" maxlength="2" class="form-control"
							type="hidden" path="customerId"></form:input>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="customerName">Customer Name<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" maxlength="50" size="50"
									id="customerName" path="customerName" required="required"
									class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="customerMobile">Customer Mobile<span
								class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" placeholder=" Only 12+ allowed"
									maxlength="10" size="10" id="customerMobile"
									path="customerMobile" required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="customerAddress">Customer Address<span
								class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:textarea type="text" maxlength="300" size="300"
									id="customerAddress" path="customerAddress" required="required"
									class="form-control "></form:textarea>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="customerPincode">Customer Pincode</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" maxlength="6" size="6"
									id="customerPincode" path="customerPincode"
									class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="customerRole">Customer Role<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="customerRole" class="form-control "
									path="customerRole">
									<c:forEach items='${rl}' var="role">
										<form:option value="${role.dispName }"> ${role.role}</form:option>
									</c:forEach>

								</form:select>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="ventureName">Venture Name<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="ventureName" class="form-control "
									path="ventureName">
									<c:forEach items='${vn}' var="vl">
										<form:option value="${vl.ventureId }"> ${vl.ventureName}</form:option>
									</c:forEach>

								</form:select>
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




