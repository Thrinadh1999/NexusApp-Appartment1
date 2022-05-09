<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
<span class="Transactions"></span>
	<div class="container row">
		<div class="col-md-9">
			<h4>Transactions</h4>

			<icon type="icon" class="icon-block" data-toggle="modal"
				data-target="#myModal">
		</div>
		<div class="col-md-3">
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i> Add Transaction
			</button>

		</div>

	</div>



	<table id="datatable" class="table">
		<thead>
			<tr>
				<th>Transaction Id</th>
				<th>Transaction By</th>
				<th>Transaction Date & Time</th>
				<th>TransDescription</th>
				<th>Transaction Categories</th>
				<th>Transaction Type</th>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>

			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>

		</tbody>
	</table>
	<!-- Trigger the modal with a button -->


	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Transaction</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newTransactions" action="addtransactions"
						id="demo-form2" class="form-horizontal form-label-left"
						method="POST">
						<form:input id="middle-name" maxlength="2" class="form-control"
							type="hidden" path="transactionId"></form:input>.
										<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="transactionBy">Transaction By<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="transactionBy" path="transactionBy"
									required="required" class="form-control "></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="transactionDateTime">Transaction Date & Time <span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="transactionDateTime" path="transactionDateTime"
									required="required" class="form-control"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label for="transDescription"
								class="col-form-label col-md-4 col-sm-4 label-align">Transaction Description</label>
							<div class="col-md-6 col-sm-6 ">
								<form:textarea id="transDescription"  class="form-control"
									type="text" path="transDescription" required="required"></form:textarea>
							</div>
						</div>
						<div class="item form-group">
							<label for="transactionCategories"
								class="col-form-label col-md-4 col-sm-4 label-align">Transaction Categories</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input id="transactionCategories"  class="form-control"
									type="text" path="transactionCategories" required="required"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label for="transactionType"
								class="col-form-label col-md-4 col-sm-4 label-align">Transaction Type</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input id="transactionType"  class="form-control"
									type="text" path="transactionType" required="required"></form:input>
							</div>
						</div>
						<div class="item form-group">
							<label for="amount"
								class="col-form-label col-md-4 col-sm-4 label-align">Amount</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input id="amount"  class="form-control"
									type="number" path="amount" required="required"></form:input>
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
	$('#datatable').DataTable();
	$('#transactionDateTime').daterangepicker({
		singleDatePicker : true,
		showDropdowns : true,
	});
	$('#cancel-button').on('click', function() {
		$('#myModal').modal('hide');
	});
	</script>

	
	
	
	
	