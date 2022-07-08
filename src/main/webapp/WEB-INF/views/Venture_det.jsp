<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="Includes/IframeHeaderScripts.jsp"%>
<%@ include file="Includes/JSPTags.jsp"%>
<%@ include file="Includes/HeaderScripts.jsp"%>
<body id="iframe-body">
	<div class="iframe_content">
		<label for="venture-select">Choose a Venture:</label>
		<table id="datatable" class="table">
			<thead>
				<tr>
					<th>Venture Name</th>
					<th>Venture Address</th>
					<th>Description</th>
					<th>No Of Blocks</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${vdi}' var="venturedetails">
					<c:if test="${venturedetails.ventureName   eq 'Test Venture 2'}">
						<tr>
							<td>${venturedetails.ventureName }</td>
							<td>${venturedetails.ventureAddress}</td>
							<td>${venturedetails.description}</td>
							<td>${venturedetails.no_of_blocks}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
	<div class="col-md-12">
		<button type="button" class="btn btn-info btn-md page-action-btn"
			data-toggle="modal" data-target="#myModal1">
			<i class="fa fa-plus"></i> Add Block
		</button>
	</div>

	</div>
	<table id="datatable" class="table">
		<thead>
			<tr>
				<th>Block Id</th>
				<th>Block Name</th>
				<th>Venture Name</th>
				<th>No Of Floors</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${bd}' var="blockdetails">
				<tr>
					<td>${blockdetails.blockId }</td>
					<td>${blockdetails.blockName}</td>
					<td>${blockdetails.ventureId}</td>
					<td>${blockdetails.no_of_floors}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="iframeNexusAppAdmin">
		<iframe id="blockiframe" src="getBlockIframe" title="Block Details"></iframe>
	</div>
	<!-- Trigger the modal with a button -->
	<!-- Model -->
	<div id="myModal1" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Block</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newNexusappBlock"
						action="addnexusappblock" id="demo-form2"
						class="form-horizontal form-label-left" method="POST">
						<form:input id="blockId" maxlength="2" class="form-control"
							type="hidden" path="blockId"></form:input>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="blockName">Block Name<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" maxlength="20" size="20" id="blockName" path="blockName"
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
									<c:forEach items='${vll}' var="vl">
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
	</div>
</body>
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
		$('#myModal1').modal('hide');
	});
	$('#submit-button1').on('click', function() {
		$('#demo-form2').submit();
	});
	$('#fetchdetails-button').on('click', function(){
		$('#blockSelect').submit();
	});
</script>