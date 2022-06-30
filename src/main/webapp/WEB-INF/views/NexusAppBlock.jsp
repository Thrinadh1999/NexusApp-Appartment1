<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
	<span class="BlockDetails"></span>
	<div class="container row">
		<div class="col-md-9">
			<div>
				<h1>
					<large>Block</large>
				</h1>
				<hr>
			</div>

			<icon type="icon" class="icon-block" data-toggle="modal"
				data-target="#myModal">
		</div>
		<div class="col-md-12">
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i> Add Apartment </button>
		</div>

	</div>
		<div id="blockSelect">
		<label for="venture-select">Choose a Block:</label> 
			<select id="venture-select">
				<option value="blockname">--Please choose a Block--</option>
					<c:forEach items='${bd}' var="blockdetails">
						<option value="blockname">${blockdetails.blockName}</option>
					</c:forEach>
			</select>
				
					<button id="fetchdetails-button" "
			NexusAppBlock			type="submit" class="btn btn-success">Fecth Deails!</button>
				</div>
	<div class="iframeNexusAppAdmin">
		<iframe id="blockiframe" src="getBlockIframe" title="Block Details"></iframe></div>
	


	<!-- Trigger the modal with a button -->
	<!-- Model -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Apartment's</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newNexusappAppartment"
						action="addnexusappappartment" id="demo-form2"
						class="form-horizontal form-label-left" method="POST">
						<form:input id="appartmentId" maxlength="2" class="form-control"
							type="hidden" path="appartmentId"></form:input>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="appartmentName">Apartment Name <span
								class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" maxlength="30" size="30" id="appartmentName"
									path="appartmentName" required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="appartmentOwner">Apartment Owner<span
								class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="appartmentOwner" class="form-control "
									path="appartmentOwner">
									<c:forEach items='${ul}' var="ul">
										<form:option data-usermobile="${ul.userMobile}"
											value="${ul.userName}"> ${ul. userFullName}</form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="number">Number<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="number" class="form-control " path="number">
									<c:forEach items='${ul}' var="ul">
										<form:option value="${ul.userMobile}">
										</form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="appartmenStatus">Apartmen Status</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" maxlength="30" size="30" id="appartmenStatus"
									path="appartmenStatus" class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="description">Description<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:textarea type="text" id="description" path="description"
									required="required" class="form-control"></form:textarea>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="blockId">Block Id<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="blockId" class="form-control " path="blockId">
									<c:forEach items='${v1}' var="v1">
										<form:option value="${v1.blockId}"> ${v1.blockName}</form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="floorId">Floor Id<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="floorId" class="form-control " path="floorId">
									<c:forEach items='${v1}' var="v1">
										<form:option value="${v1.floorId}"> ${v1.floorNumber}</form:option>
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
		$('#demo-form').submit();
	});
	$('#fetchdetails-button').on('click', function(){
		$('#blockSelect').submit();
	});
	$('#appartmentOwner').change(function() {
		var userid = $('option:selected', this).attr('data-usermobile');
		$('#number').val(userid);
	});
</script>




