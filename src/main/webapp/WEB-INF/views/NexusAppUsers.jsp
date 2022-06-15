<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
	<span class="users"></span>
	<div class="container row">
		<div class="col-md-9">
			<div>
				<h1>
					<large>Users</large>
				</h1>
				<hr>
			</div>

			<icon type="icon" class="icon-block" data-toggle="modal"
				data-target="#myModal">
		</div>
		<div class="col-md-12">
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i> Add Users
			</button>
		</div>

	</div>



	<table id="datatable" class="table">
		<thead>
			<tr>
				<th>User Id</th>
				<th>User Name</th>
				<th>User FullName</th>
				<th>User Role</th>
				<th>User Mobile</th>
				<th>User Email</th>
				<th>User Address</th>
				<th>City</th>
				<th>State</th>
				<th>Country</th>
				<th>Zip Code</th>
				<th>status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${ud}' var="userdetails">
				<tr>
					<td>${userdetails.userId}</td>
					<td>${userdetails.userName}</td>
					<td>${userdetails.userFullName}</td>
					<td>${userdetails.userRole}</td>
					<td>${userdetails.userMobile}</td>
					<td>${userdetails.userEmail}</td>
					<td>${userdetails.userAddress}</td>
					<td>${userdetails.city}</td>
					<td>${userdetails.state}</td>
					<td>${userdetails.country}</td>
					<td>${userdetails.zipcode}</td>
					<td>${userdetails.status}</td>

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
					<h4 class="modal-title">Add User</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newNexusappUsers"
						action="addnexusappusers" id="demo-form2"
						class="form-horizontal form-label-left" method="POST">
						<form:input id="userId" maxlength="2" class="form-control"
							type="hidden" path="userId"></form:input>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="userName">User Name <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="userName" path="userName"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="description">User FullName <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="userFullName" path="userFullName"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="userRole">userRole<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="userRole" class="form-control " path="userRole">
									<c:forEach items='${rl}' var="rl">
										<form:option value="${rl.dispName}"> ${rl.role}</form:option>
									</c:forEach>

								</form:select>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="userMobile">User Mobile</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="number" id="userMobile" path="userMobile"
									class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="userEmail">User Email<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="userEmail" path="userEmail"
									required="required" class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="userAddress">User Address<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="userAddress" path="userAddress"
									required="required" class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="city">City<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="city" path="city"
									required="required" class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="state">state<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="state" class="form-control " path="state">
									<c:forEach items='${asl}' var="asl">
										<form:option value="${asl.stateName}"> ${asl.stateName}</form:option>
									</c:forEach>

								</form:select>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="country">Country<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="country" class="form-control " path="country">
									<c:forEach items='${acl}' var="acl">
										<form:option value="${acl.countryName}"> ${acl.countryName}</form:option>
									</c:forEach>

								</form:select>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="zipcode">Zipcode<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="zipcode" path="zipcode"
									required="required" class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="status">Status<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="status" path="status"
									required="required" class="form-control"></form:input>
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




