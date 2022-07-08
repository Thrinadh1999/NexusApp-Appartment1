<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
	<span class="FlatDetails"></span>
	<div class="container row">
		<div class="col-md-9">
			<div>
				<h1>
					<large>Venture Details</large>
				</h1>
				<hr>
			</div>

			<icon type="icon" class="icon-block" data-toggle="modal"
				data-target="#myModal">
		</div>
		<div class="col-md-12">
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i> Add Venture
			</button>
			<table id="datatable" class="table">
		<thead>
			<tr>
				<th>Venture Id</th>
				<th>Venture Name</th>
				<th>Venture Address</th>
				<th>Description</th>
				<th>No of Blocks</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${vd}' var="venturedet">
				<tr>
					<td>${venturedet.ventureId}</td>
					<td>${venturedet.ventureName}</td>
					<td>${venturedet.ventureAddress}</td>
					<td>${venturedet.description}</td>
					<td>${venturedet.no_of_blocks}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
			</div>
		<div class="col-md-12">	
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#blockModal">
				<i class="fa fa-plus"></i> Add Block
			</button>
		</div>
	</div>
	<hr>
	<div class="iframeNexusAppAdmin">
		<iframe id="blockiframe" src="getBlockIframe" title="Block Details"></iframe>
		
	</div>
	<!-- Trigger the modal with a button -->
	<!-- Model -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Venture</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newNexusappVenture"
						action="addnexusappventure" id="demo-form"
						class="form-horizontal form-label-left" method="POST">
						<form:input id="ventureId" maxlength="2" class="form-control"
							type="hidden" path="ventureId"></form:input>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="ventureName">Venture Name<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" maxlength="50" size="50" id="ventureName" path="ventureName"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="ventureAddress">Venture Address<span
								class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" maxlength="50" size="50" id="ventureAddress"
									path="ventureAddress" required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="description">Description<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:textarea type="text" maxlength="100" id="description" path="description"
									required="required" class="form-control "></form:textarea>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="no_of_blocks">No Of Blocks<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="number" maxlength="2" size="2" id="no_of_blocks" path="no_of_blocks"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="ln_solid"></div>
						<div class="item form-group">
							<div class="col-md-6 col-sm-6 offset-md-3 text-center">
								<form:button id="submit-button1" type="submit"
									class="btn btn-success">Submit</form:button>

								<button id="cancel-button1" type="button" class="btn btn-danger">Cancel</button>
							</div>

						</div>

					</form:form>



				</div>
			</div>

		</div>
	</div>


<!-- modal 2 -->
<div id="blockModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Block</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newNexusappBlock"
						action="addnexusappblocks" id="demo-form2"
						class="form-horizontal form-label-left" method="POST">
						<form:input id="blockId" maxlength="2" class="form-control"
							type="hidden" path="blockId"></form:input>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="blockName">Block Name<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="blockName" path="blockName"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="ventureId">Venture Id<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="ventureId" class="form-control "
									path="ventureId">
									<!--<form:option value="Test Venture 2">Test Venture 2</form:option>-->
									<c:forEach items='${vd}' var="vl">
										<form:option value="${vl.ventureName }"> ${vl.ventureName}</form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="no_of_floors">No Of Floors<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" maxlength="2" size="2" id="no_of_floors" path="no_of_floors"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="no_of_appartments">No Of Appartments<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" maxlength="2" size="2" id="no_of_appartments" path="no_of_appartments"
									required="required" class="form-control "></form:input>
							</div>
						</div>
							<div class="ln_solid"></div>
								<div class="item form-group">
									<div class="col-md-6 col-sm-6 offset-md-3 text-center">
										<form:button id="submit-button" type="submit" class="btn btn-success">Submit</form:button>
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
	$('#cancel-button1').on('click', function() {
		$('#myModal').modal('hide');
	});
	$('#submit-button1').on('click', function() {
		$('#demo-form').submit();
	});
	$('#submit-button').on('click', function() {
		$('demo-form2').submit();
	});
	$('#cancel-button').on('click', function() {
		$('#blockModal').modal('hide');
	});
</script>




