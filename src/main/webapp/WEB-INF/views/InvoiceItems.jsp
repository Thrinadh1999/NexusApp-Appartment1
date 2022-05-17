<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
<span class="Transactions"></span>
	<div class="container row">
		<div class="col-md-9">
		<icon type="icon" class="icon-block" data-toggle="modal"
				data-target="#myModal">
		</div>
		<div class="col-md-3">
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i> Add InvoiceItems
			</button>
		</div>
		</div>
		<table id="datatable" class="table">
		<thead>
			<tr>
				<th>Item Name</th>
				<th>Description</th>
				<th>Quantity</th>
				<th>Amount</th>
				<th>Item Price</th>
			</tr>
		</thead>
		<tbody>
      <tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			</tr>
			

		</tbody>
	</table>
	
	<br>
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
					<form:form modelAttribute="newInvoiceItems" action="addinvoiceItems"
						id="demo-form2" class="form-horizontal form-label-left"
						method="POST">
						<form:input id="id" maxlength="2" class="form-control"
							type="hidden" path="id"></form:input>.
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="invoiceID">Invoice Id<span class="required">*</span>
					</label>
						<div class="col-md-6 col-sm-6 ">
							<form:input type="text" id="invoiceID" path="invoiceID"
									required="required" class="form-control"></form:input>
						</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="itemName">itemName<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="itemName" path="itemName"
									required="invoiceNo" class="form-control"></form:input>
							</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="description">Description <span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:textarea type="text" id="description" path="description"
									required="required" class="form-control"></form:textarea>
							</div>
				</div>	
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="quantity">Quantity <span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="quantity" path="quantity"
									required="quantity" class="form-control"></form:input>
							</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="gst">GST<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="gst" path="gst"
									required="gst" class="form-control"></form:input>
							</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="amount">Amount<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="amount" path="amount"
									required="amount" class="form-control"></form:input>
							</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="itemPrice">Item Price<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="itemPrice" path="itemPrice"
									required="itemPrice" class="form-control"></form:input>
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