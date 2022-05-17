<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
<span class="Transactions"></span>
	<div class="container row">
		<div class="col-md-9">
		<div>
			<h1><large>Invoice</large></h1>
			<hr>
			</div>
			<div class="flex">
			<div class ="details">
			<h4>Billed to</h4>
			<h4>client</h4>
			<h4>client Adress</h4>
			</div>
			<div class= "model">
			<h4>Invoice Number</h4>
			<h4>000000</h4>
			<br>
			<h4>Date Of Issue</h4>
			<h4>10-05-2022</h4>
			</div>
			<div class= "invoiceTotal">
			<h4>Invoice Total</h4>
			<h2><large>$$$</large></h2>
			</div>
			</div>
			<icon type="icon" class="icon-block" data-toggle="modal"
				data-target="#myModal">
		</div>
		<div class="col-md-3">
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i> Generate Invoice
			</button>

		</div>

	</div>



	<table id="datatable" class="table">
		<thead>
			<tr>
				<th>Invoice Number</th>
				<th>Client Name</th>
				<th>Client Address</th>
				<th>To Name</th>
				<th>Issue Date</th>
				<th>Invoice By</th>
				<th>GST</th>
			</tr>
		</thead>
		<tbody>
      <tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
	 </tr>
			

		</tbody>
	</table>
	<div class ="total">
	<h3>Sub Total:</h3>
	<h3>Tax(GST):</h3>
	<h3>Total:</h3>
	<br>
	<div class ="due">
	<h3>Amount Due</h3>
	<h4>$$$4</h4>
	</div>
	</div>
	<br>
	<div class="invTeam">
	<h3>Invoice Team</h3>
	<h4>content Will Appear here</h4>
	</div>
	</div>
	
	<!-- Trigger the modal with a button -->



	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Create Invoice</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newInvoice" action="addinvoice"
						id="demo-form2" class="form-horizontal form-label-left"
						method="POST">
						<form:input id="invoiceId" maxlength="2" class="form-control"
							type="hidden" path="invoiceId"></form:input>.
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="invoiceNo">Invoice No<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="invoiceNo" path="invoiceNo"
									required="invoiceNo" class="form-control"></form:input>
							</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="client">Client<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="client" path="client"
									required="client" class="form-control"></form:input>
							</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="clientAdress">Client Adress<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="clientAdress" path="clientAdress"
									required="clientAdress" class="form-control"></form:input>
							</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="toName">To Name<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="toName" path="toName"
									required="toName" class="form-control"></form:input>
							</div>
				</div>	
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="issueDate">Issue Date<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="issueDate" path="issueDate"
									required="issueDate" class="form-control"></form:input>
							</div>
				</div>	
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="invoiceBy">Invoice By<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="invoiceBy" path="invoiceBy"
									required="invoiceBy" class="form-control"></form:input>
							</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="createdTime">Created Time<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="createdTime" path="createdTime"
									required="createdTime" class="form-control"></form:input>
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
//$('#datatable').DataTable();
$('#createdTime').daterangepicker({
	singleDatePicker : true,
	showDropdowns : true,
});
$('#cancel-button').on('click', function() {
	$('#myModal').modal('hide');
});
$('#submit-button').on('click', function() {
	$('#demo-form2').submit();
});
</script>
	
	
	
	
	