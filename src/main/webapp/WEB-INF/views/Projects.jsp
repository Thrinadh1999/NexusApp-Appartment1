
<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">

	<div class="container row">
		<div class="col-md-9">
			<h4>Projects</h4>
		</div>
		<div class="col-md-3">
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i>New Project
			</button>

		</div>

	</div>



	<table id="datatable" class="table">
		<thead>
			<tr>
				<th>ProjectID</th>
				<th>ProjectName</th>
				<th>Description</th>
				<th>StartDate</th>
				<th>DueDate</th>
				<th>Client</th>
				<th>ClientDetails</th>
				<th>Action</th>

			</tr>
		</thead>
		<tbody>

			<c:forEach items='${proList}' var="list">
				<tr>
					<td>${list.projectID}</td>
					<td>${list.projectName}</td>
					<td>${list.description}</td>
					<td>${list.startDate}</td>
					<td>${list.dueDate}</td>
					<td>${list.client}</td>
					<td>${list.clientDetails}</td>
					<td><a class="editProjectModel" data-projectid="${list.projectID}"
						data-projectname="${list.projectName}"
						data-description="${list.description}"
						data-startdate="${list.startDate}" data-duedate="${list.dueDate}"
						data-client="${list.client}"
						data-clientdetails="${list.clientDetails}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- Trigger the modal with a button -->


	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Project</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newProjects" action="addprojects"
						id="demo-form2" class="form-horizontal form-label-left"
						method="POST">
						<form:input id="projectID" maxlength="2" class="form-control"
							type="hidden" path="projectID"></form:input>.
										<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="projectName">Project Name <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="projectName" path="projectName"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="description">Description <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="description" path="description"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="startDate">Start Date<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="date" id="startDate" path="startDate"
									required="required" class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="dueDate">Due Date</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="date" id="dueDate" path="dueDate"
									class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="dueDate">client<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="client" path="client"
									required="required" class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="clientDetails">Client Details<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="clientDetails" path="clientDetails"
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

<div>
	<div id="editModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Project</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newProjects" action="addprojects"
						id="editProjectForm" class="form-horizontal form-label-left"
						method="POST">
						<form:input id="projectID" maxlength="2" class="form-control"
							type="hidden" path="projectID"></form:input>.
										<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="projectName">Project Name <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="projectName" path="projectName"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="description">Description <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="description" path="description"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="startDate">Start Date<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="date" id="startDate" path="startDate"
									required="required" class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="dueDate">Due Date</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="date" id="dueDate" path="dueDate"
									class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="dueDate">client<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="client" path="client"
									required="required" class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="clientDetails">Client Details<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="clientDetails" path="clientDetails"
									required="required" class="form-control"></form:input>
							</div>
						</div>
						<div class="ln_solid"></div>
						<div class="item form-group">
							<div class="col-md-6 col-sm-6 offset-md-3 text-center">
								<form:button id="submit-button" type="submit"
									class="btn btn-success">Submit</form:button>

								<button id="cancel-button2" type="button" class="btn btn-danger">Cancel</button>
							</div>

						</div>

					</form:form>



				</div>
			</div>

		</div></div>



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
$('#datatable').DataTable();
$('#cancel-button').on("click",function(){
	$('#myModal').modal('hide');
});
$('#cancel-button2').on("click",function(){
	$('#editModal').modal('hide');
})
$('.editProjectModel').on('click',function(){
	$('#editProjectForm input[name="projectID"]').val($(this).data('projectid'));
	$('#editProjectForm input[name="projectName"]').val($(this).data('projectname'));
	$('#editProjectForm input[name="description"]').val($(this).data('description'));
	$('#editProjectForm input[name="startDate"]').val($(this).data('startdate'));
	$('#editProjectForm input[name="dueDate"]').val($(this).data('duedate'));
	$('#editProjectForm input[name="client"]').val($(this).data('client'));
	$('#editProjectForm input[name="clientDetails"]').val($(this).data('clientdetails'));
	$("#editModal").modal('toggle');
});
</script>