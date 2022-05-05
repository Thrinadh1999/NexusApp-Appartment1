
<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">

<div class="container row">
<div class="col-md-9">
<h4>Tasks</h4>
</div>
<div class="col-md-3">
<button type="button" class="btn btn-info btn-md page-action-btn" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i> Create Task</button>

</div>

</div>
	

	
	<table id="datatable" class="table">
	<thead>
	<tr>
	<th>Task Id</th>
	<th>Employee Id</th>
	<th>Task Name</th>
	<th>Task Description</th>
	<th>Points</th>
	<th>Created Time</th>
	<th>Priority</th>
	<th>Project Id</th>
	<th>Status</th>
	<th>Update Status</th>
	</tr>
	</thead>
	<tbody>
	
	
	
	
		<c:forEach items='${tasksList}' var="list">
		<tr>
	<td>${list.taskId}
	<td>${list.employeeId}</td>
	<td>${list.taskName}</td>
	<td>${list.taskDescription}</td>
	<td>${list.points}</td>
	<td>${list.createdTime}</td>
	<td>${list.priority}</td>
	<td>${list.projectId}</td>
	<td>${list.status}</td>
	<td>
	<select name="status" id="status">
  <option value="Pending">Pending</option>
  <option value="Testing">Testing</option>
  <option value="Completed">Completed</option>
</select>
<a class="updateTask" data-id="${list.taskId}">Update</a>
	</td>
						
						
	
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
        <h4 class="modal-title">Add Task</h4>
      </div>
      <div class="modal-body">
        <form:form modelAttribute="newTask" action="addTask" id="tasks" class="form-horizontal form-label-left" method="POST">
										<form:input id="taskId" maxlength="2" class="form-control" type="hidden" path="taskId"></form:input>.
										<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="employee">Employee Id <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:select id="employee" class="form-control " path="employeeId">
											<c:forEach items='${employeeList}' var="list">
												<form:option value="${list.id}">${list.firstName } ${list.lastName }</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
										<div class="item form-group">
											<label class="col-form-label col-md-4 col-sm-4 label-align" for="taskName">Task Name <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input type="text" id="taskName" path="taskName" required="required" class="form-control "></form:input>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-4 col-sm-4 label-align" for="taskDescription">Task Description <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:textarea type="text" id="taskDescription" path="taskDescription" required="required" class="form-control "></form:textarea>
											</div>
										</div>
										
										<div class="item form-group">
											<label class="col-form-label col-md-4 col-sm-4 label-align" for="points">Points<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input type="number" id="points" path="points" required="required" class="form-control"></form:input>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-4 col-sm-4 label-align" for="createdTime">Created Time <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input type="text" id="createdTime" path="createdTime" required="required" class="form-control"></form:input>
											</div>
										</div>
										<div class="item form-group">
											<label class="col-form-label col-md-4 col-sm-4 label-align" for="priority">Priority <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input type="text" id="priority" path="priority" required="required" class="form-control"></form:input>
											</div>
										</div>
										<div class="item form-group">
									<label class="col-form-label col-md-4 col-sm-4 label-align"
										for="FirstName">Project Id <span class="required">*</span>
									</label>
									<div class="col-md-6 col-sm-6 ">
										<form:select id="Projects" class="form-control " path="projectId">
											<c:forEach items='${projectsList}' var="list">
												<form:option value="${list.projectID}"> ${list.projectName}</form:option>
											</c:forEach>
							
										</form:select>
									</div>
								</div>
								<div class="item form-group">
											<label class="col-form-label col-md-4 col-sm-4 label-align" for="status">Status<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 ">
												<form:input type="text" id="status" path="status" required="required" class="form-control"></form:input>
											</div>
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
    <script src="resources/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="resources/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="resources/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="resources/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="resources/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="resources/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="resources/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="resources/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="resources/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="resources/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="resources/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="resources/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
   
<script>
	$('#datatable').DataTable();

	$('#createdTime').daterangepicker({
		singleDatePicker : true,
		showDropdowns : true,
	});	
	$('#cancel-button').on('click', function() {
		$('#myModal').modal('hide');
	});
	$('#submit-button').on(
			'click',
			function() {
				alert('created date time is: ' + $('#createdTime').val());
				$('#demo-form2').submit();
			});
	
	$(".updateTask").click(function(){
			 var stat = $("#status").val();
			 var id= $(this).data('id');
		 $.ajax({
		        type: "POST",
		        url: "updateTaskStatus/?${_csrf.parameterName}=${_csrf.token}",
		        data: { id: id, status: stat },
		 		success: function(data)
		        {
		          
		        }
		    });
		    
		});
</script>


	