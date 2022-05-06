
<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">

	<div class="container row">
		<div class="col-md-9">
			<h4>Employee</h4>
		</div>
		<div class="col-md-3">
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i> Create User
			</button>

		</div>
		<div class="col-md-3">

	</div>



	<table id="datatable" class="table">
		<thead>
			<tr>
				<th>EUID</th>
				<th>Department Name</th>
				<th>Name</th>
				<th>Address</th>
				<th>Mobile</th>
				<th>Email</th>
				<th>Join_Date</th>
				<th>DepartmentID</th>
				<th>Role</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${employeeList}' var="list">
				<tr>
					<td>UID</td>
					<td>${list.departmentName }</td>
					<td>${list.firstName }${list.lastName }</td>
					<td>${list.address }</td>
					<td>${list.mobile }</td>
					<td>${list.email }</td>
					<td>${list.joinDate }</td>
					<td>${list.departmentId }</td>
					<td>${list.role }</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<!-- Trigger the modal with a button -->


	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Employee</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<form:form modelAttribute="newEmployee" action="addEmployee/?${_csrf.parameterName}=${_csrf.token}"
							id="demo-form2" class="form-horizontal form-label-left"
							method="POST" enctype="multipart/form-data">
							<form:input id="middle-name" maxlength="2" class="form-control"
								type="hidden" path="id"></form:input>
							<form:input type="hidden" maxlength="5" id="Employee_Unique_ID"
								path="empUnique" class="form-control " value="SM"></form:input>
							<div class="col-md-7">
								<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="FirstName">Department <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">

										<form:select id="Department" class="form-control "
											path="departmentId">
											<c:forEach items='${depList}' var="list">
												<form:option value="${list.departmentId}">${list.name}</form:option>
											</c:forEach>
										</form:select>

									</div>
								</div>
								<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="FirstName">Role <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:select id="Department" class="form-control " path="role">
											<c:forEach items='${roleList}' var="list">
												<form:option value="${list.id }"> ${list.dispName }</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="firstName">First Name <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:input type="text" id="firstName" path="firstName"
											required="required" class="form-control "></form:input>
									</div>
								</div>
								<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="FirstName">LastName <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:input type="text" id="LastName" path="lastName"
											required="required" class="form-control "></form:input>
									</div>
								</div>
								<div class="item form-group">
									<label for="middle-name"
										class="col-form-label col-md-4 col-sm-4 label-align">Mobile</label>
									<div class="col-md-6 col-sm-6 ">
										<form:input id="Mobile_NO" maxlength="12" class="form-control"
											type="number" path="mobile" required="required"></form:input>
									</div>
								</div>

								<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="email">Email <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:input type="text" id="email " path="email"
											required="required" class="form-control"></form:input>
									</div>
								</div>
								<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="gender">Gender <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<c:forEach items='${genList}' var="list">
											<form:radiobutton path="gender" value="${list.gender }"
												label="${list.gender }" />
										</c:forEach>
									</div>
								</div>
								<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="last-name">Address <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:input type="text" id="Address" path="address"
											required="required" class="form-control"></form:input>
									</div>
								</div>
								<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="city">City <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:input type="text" id="City" path="city"
											required="required" class="form-control"></form:input>
									</div>
								</div>
								<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="FirstName">State <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">

										<form:select id="Statelkp" class="form-control "
											path="stateName">
											<c:forEach items='${stateList}' var="list">
												<form:option value="${list.id }"> ${list.stateName }</form:option>
											</c:forEach>
										</form:select>

									</div>
								</div>
								<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="FirstName">Country <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">

										<form:select id="Country" class="form-control "
											path="countryId">
											<c:forEach items='${countryList}' var="cntrylst">
												<form:option value="${cntrylst.id }"> ${cntrylst.countryName }</form:option>
											</c:forEach>
										</form:select>

									</div>
								</div>
								<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="city">ZipCode <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:input type="text" id="Zip" path="zipCode"
											required="required" class="form-control"></form:input>
									</div>
								</div>



								<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="FirstName">Join_Date <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:input type="text" id="Join_Date" path="joinDate"
											required="required" class="form-control "></form:input>
									</div>
								</div>
							</div>
							<div class="col-md-5">

								<label class="col-form-label col-md-12 col-sm-12"
									for="image">Upload Image</label>
								<div class="col-md-6 col-sm-6 ">
									<img id="blah" src="#" alt="your image" />
									<form:input type="file" id="image" width="400" height="200"
                                                                       
                                                                         
									 path="imageUpload" accept="image/*"></form:input>
								</div>

							</div>
							  <style type="text/css"> #image{  width: 300px;
            }
              
        </style>
					</div>

					<div class="ln_solid"></div>
					<div class="item form-group">
						<div class="col-md-6 col-sm-6 offset-md-3 text-center">
							<form:button id="submit-button" type="button"
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
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}

	$("#image").change(function() {
		readURL(this);
	});
</script>

<script>
	$('#datatable').DataTable();

	$('#Join_Date').daterangepicker({
		singleDatePicker : true,
		showDropdowns : true,
	});

	$('#cancel-button').on('click', function() {
		$('#myModal').modal('hide');
	});
	$('#submit-button').on(
			'click',
			function() {
				alert('join date is: ' + $('#Join_Date').val()
						+ " and departmentId is: " + $('#Department').val());
				$('#demo-form2').submit();
			});
</script>