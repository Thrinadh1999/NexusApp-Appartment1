<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="pageWidth">
<div class="right_col" role="main">
<span class="Transactions"></span>
	<div class="container row">
		<div class="col-sm-3" id="invoinvo">
		<div class="page-title">
            <div class="titleflex">
            <div class="headingInvoice">
            <h1><small>Invoice</small></h1>
            </div>
            <div class="details">
            <h6> <small>+91-9961800932</small></h6>
            <h6><small>91-9989160036</small></h6>
            <h6><small> contact@goscholarly.com</small> </h6>
            
            </div>
            <div class="adressC">
            <h6><small>11-6-539/403,Red Hills</small></h6>
            <h6><small>Hyderabad Telangana</small></h6>
            <h6><small>500001</small></h6>
            </div>
            </div>
            
            </div>
		</div>
		
		</div>
		<hr>
		<div class="container row">
		<div class="billingDetails">
		<h5>Billed To</h5>
		<h6><small>${invoiceDetails.client }</small></h6>
		<h6><small>${invoiceDetails.toName }</small></h6>
		<h2><small>${invoiceDetails.clientAdress }</small></h6>
		</div>
		<div class="invoiceDetails">
		<h5><small>Invoice Number</small></h5>
		<h6><small>${invoiceDetails.invoiceNo }</small></h6>
		<br>
		<h5><small>Date Of Issue</small></h5>
		<h6><small>${invoiceDetails.issueDate }</small></h6>
		</div>
		<div class="invoiceTotaloAmt">
		<h5>Invoice Total </h5>
		<h3><i class="fa fa-inr" aria-hidden="true">${invAmt}</i></h3>
		</div>
		</div>
		<hr>
		<div class="col-md-12">
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i> Add InvoiceItems
			</button>
		</div>
		
		<table class="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Invoice ID</th>
				<th>Item Name</th>
				<th>Description</th>
				<th>Quantity</th>
				<th>Item Price</th>
				<th>Total Value</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items='${invoItems}' var="ivl" varStatus="loop">
      <tr> 
      		<td>${ivl.id}</td>
			<td>${ivl.invoiceID}</td>
			<td>${ivl.itemName}</td>
			<td>${ivl.description}</td>
			<td>${ivl.quantity}</td>
			<td>${ivl.itemPrice}</td>
			<td>${itemPrice[loop.index].TotalPrice }</td>
			</c:forEach>
			
			</tr>

		</tbody>
	</table>
	<div class="amountDetails">
	<h5><small>Subtotal: <i class="fa fa-inr" aria-hidden="true">&ensp;${subTotal}</i></small></h5>
	<h5><small>Tax: <i class="fa fa-inr" aria-hidden="true">&ensp;${tax}</i></small></h5>
	<h5><small>Total: <i class="fa fa-inr" aria-hidden="true">&ensp;${invAmt}</i></small></h5>
		<br>
	<h5><small>Amount Due:<i class="fa fa-inr" aria-hidden="true">&ensp;${invAmt}</i></small></h5>
	</div>
	</div>
		
	
	<!-- Trigger the modal with a button -->
	
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add Invoice Items</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newInvoiceItems" action="addinvoiceItems"
						id="demo-form2" class="form-horizontal form-label-left"
						method="POST">
						<form:input id="id" class="form-control"
							type="hidden" path="id"></form:input>.
						<form:input type="hidden" id="invoiceID" path="invoiceID"
							required="required" class="form-control" value="${invoiceDetails.invoiceId}"></form:input>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="itemName">Item Name<span class="required">*</span>
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
								for="itemPrice">Item Price(Each)<span class="required">*</span>
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
$('#cancel-button').on('click', function() {
	$('#myModal').modal('hide');
});
$('#submit-button').on('click', function() {
	$('#demo-form2').submit();
});

//function (){
//var Tax =${invAmt} + ${subTotal}
//$("#tax").html(Tax);
//}
</script>