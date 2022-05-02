
<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">

	<div class="container row">
		<div class="col-md-9">
			<h4>Edit Departments</h4>

			
		</div>
	

	</div>
	<form:form modelAttribute="editDepartment" action="addDepartment"
						id="demo-form2" class="form-horizontal form-label-left"
						method="POST">
						<form:input id="middle-name" maxlength="2" class="form-control"
							type="hidden" path="departmentId"  value="${department.departmentId}"></form:input>.
										<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="first-name">Department Name <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="first-name" path="name"
									required="required" class="form-control " value="${department.name}"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="last-name">Description <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:textarea type="text" id="desc" path="description"
									required="required" class="form-control"></form:textarea>
							</div>
						</div>
						<div class="item form-group">
							<label for="middle-name"
								class="col-form-label col-md-4 col-sm-4 label-align">Code</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input id="middle-name" maxlength="2" class="form-control"
									type="text" path="code" required="required"  value="${department.code}"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<div class="col-md-6 col-sm-6 offset-md-3 text-center">
								<form:button id="submit-button" type="submit"
									class="btn btn-success">Update</form:button>
							</div>
					</form:form>

	<!-- Modal -->
	
</div>


<!-- /page content -->

<%@ include file="Includes/Footer.jsp"%>

<%@ include file="Includes/FooterScripts.jsp"%>
<script>
$(document).ready(function(){
	$('#desc').val('${department.description}');
});

</script>


