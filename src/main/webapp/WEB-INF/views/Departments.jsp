<%@ include file="Includes/JSPTags.jsp"%>
<%@ include file="Includes/HeaderScripts.jsp"%>
<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
	<h4>This is Department page</h4>
	<table>
		<thead>
			<tr>
				<th>Department ID</th>
				<th>Department Name</th>
				<th>Description</th>
				<th>Code</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${depList}' var='list'>
				<tr>
					<td>${list.id }</td>
					<td>${list.name }</td>
					<td>${list.description }</td>
					<td>${list.code }</td>
				</tr>
			</c:forEach>
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#exampleModal">Add Department</button>

			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Department
								Details</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<form id="demo-form2" data-parsley-validate
							class="form-horizontal form-label-left">

							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="first-name">Department ID <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="first-name" required="required"
										class="form-control ">
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="last-name">Department name <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="last-name" name="last-name"
										required="required" class="form-control">
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="last-name">Department description <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="last-name" name="last-name"
										required="required" class="form-control">
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align"
									for="last-name">Department code <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input type="text" id="last-name" name="last-name"
										required="required" class="form-control">
								</div>
							</div>
							<div class="item form-group">
								<label for="middle-name"
									class="col-form-label col-md-3 col-sm-3 label-align">Middle
									Name / Initial</label>
								<div class="col-md-6 col-sm-6 ">
									<input id="middle-name" class="form-control" type="text"
										name="middle-name">
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align">Gender</label>
								<div class="col-md-6 col-sm-6 ">
									<div id="gender" class="btn-group" data-toggle="buttons">
										<label class="btn btn-secondary"
											data-toggle-class="btn-primary"
											data-toggle-passive-class="btn-default"> <input
											type="radio" name="gender" value="male" class="join-btn">
											&nbsp; Male &nbsp;
										</label> <label class="btn btn-primary"
											data-toggle-class="btn-primary"
											data-toggle-passive-class="btn-default"> <input
											type="radio" name="gender" value="female" class="join-btn">
											Female
										</label>
									</div>
								</div>
							</div>
							<div class="item form-group">
								<label class="col-form-label col-md-3 col-sm-3 label-align">Date
									Of Birth <span class="required">*</span>
								</label>
								<div class="col-md-6 col-sm-6 ">
									<input id="birthday" class="date-picker form-control"
										placeholder="dd-mm-yyyy" type="text" required="required"
										type="text" onfocus="this.type='date'"
										onmouseover="this.type='date'" onclick="this.type='date'"
										onblur="this.type='text'" onmouseout="timeFunctionLong(this)">
									<script>
										function timeFunctionLong(input) {
											setTimeout(function() {
												input.type = 'text';
											}, 60000);
										}
									</script>
								</div>
							</div>
							<div class="ln_solid"></div>
							<div class="item form-group">
								<div class="col-md-6 col-sm-6 offset-md-3">
									<button class="btn btn-primary" type="button">Cancel</button>
									<button class="btn btn-primary" type="reset">Reset</button>
									<button type="submit" class="btn btn-success">Submit</button>
		</tbody>
	</table>
</div>
<!-- /page content -->
<%@ include file="Includes/Footer.jsp"%>
<%@ include file="Includes/FooterScripts.jsp"%>
</body>
</html>
