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
				<th>InvoiceId</th>
				<th>Invoice Number</th>
				<th>Client Name</th>
				<th>Client Address</th>
				<th>To Name</th>
				<th>Issue Date</th>
				<th>Invoice By</th>
				<th>Created Time</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items='${invoLst}' var="list">
		
      <tr>
      
			<td><a href="invo?id=${list.invoiceId }">${list.invoiceId }</a></td>
			<td>${list.invoiceNo }</td>
			<td>${list.client }</td>
			<td>${list.clientAdress }</td>
			<td>${list.toName }</td>
			<td>${list.issueDate }</td>
			<td>${list.invoiceBy }</td>
			<td>${list.createdTime }</td>
			
	 </tr>
	 
			</c:forEach>

		</tbody>
	</table>
	
	
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
									required="required" class="form-control"></form:input>
							</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="client">Client<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="client" path="client"
									required="required" class="form-control"></form:input>
							</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="clientAdress">Client Address<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="clientAdress" path="clientAdress"
									required="required" class="form-control"></form:input>
							</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="toName">To Name<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="toName" path="toName"
									required="required" class="form-control"></form:input>
							</div>
				</div>	
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="issueDate">Issue Date<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="issueDate" path="issueDate"
									required="required" class="form-control"></form:input>
							</div>
				</div>	
				<div class="item form-group">
							<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="invoiceBy">Invoice By<span class="required">*</span>
							</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="invoiceBy" class="form-control "
									path="invoiceBy">
									<c:forEach items='${emplist}' var="list">
										<form:option value="${list.firstName } ${list.lastName }">${list.firstName } ${list.lastName }</form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="createdTime">Created Time<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="createdTime" path="createdTime"
									required="required" class="form-control"></form:input>
							</div>
				</div>	
				<div class="item form-group">
					<h6> 18% of tax is Applied on Total Amount</h6>
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
$('#createdTime').daterangepicker({
	singleDatePicker : true,
	showDropdowns : true,
});
$('#issueDate').daterangepicker({
	singleDatePicker : true,
	showDropdowns : true,
});
$('#cancel-button').on('click', function() {
	$('#myModal').modal('hide');
});
$('#submit-button').on('click', function() {
	$('#demo-form2').submit();
});

//function Compute() {
  //  var Total = document.getElementById("myTotal").value;
   // var Tax = document.getElementById("tax").value;
    //var NewTotal = document.getElementById("tax");
   // var TaxAmount = document.getElementById("taxAmount");
   // Total = parseFloat(Total);
    //Tax = parseFloat(Tax);
    //TaxAmount.value = Math.max((Total * Tax) / 100).toFixed(2) + ""
    //NewTotal.value = Math.max(Total + (Total * Tax) / 100).toFixed(2) + "";
//}
</script>
	
	
	
	
	