<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="pageWidth">
<div class="right_col" role="main">
<span class="EmployeePaySlips"></span>
	<div class="container row">
		<div class="col-sm-12" id="empPaylip">
		<div class="page-title">
            <div class="titleflex">
            <div class="headingEmployeePayslip">
            <h3>S&M Scholary Solutions</h3>
            <h3 id="titl" ><small>Employee PaySlip</small></h3>
            <p id="dno">11-6-539/403,Red Hills</p>
            <p id="addr">Hyderabad Telangana</p>
            <p id="pin">500001</p>
            </div>
            </div>
            
            </div>
		</div>
		
		</div>
		<hr>
		<div class="container row">
		<div class="billingDetails">
		<h5>Billed To</h5>
		<h6><small></small></h6>
		<h6><small></small></h6>
		<h2><small></small></h6>
		</div>
		<div class="invoiceDetails">
		<h5><small>Invoice Number</small></h5>
		<h6><small></small></h6>
		<br>
		<h5><small>Date Of Issue</small></h5>
		<h6><small></small></h6>
		</div>
		<div class="invoiceTotaloAmt">
		<h5>Invoice Total </h5>
		<h3><i class="fa fa-inr" aria-hidden="true"></i></h3>
		</div>
		</div>
		<hr>
		
		<table class="table">
		<thead>
			<tr>
				<th>Employee Name</th>
				<th>Month</th>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items='${totalPayments}' var="payslip">
      <tr> 
      		
			<td>${payslip.employeeName}</td>
			<td>${payslip.month }</td>
			<td>${payslip.pay }</td>
			
			
			</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="amountDetails">
	<h5><small>Subtotal: <i class="fa fa-inr" aria-hidden="true">&ensp;</i></small></h5>
	<h5><small>Tax: <i class="fa fa-inr" aria-hidden="true">&ensp;</i></small></h5>
	<h5><small>Total: <i class="fa fa-inr" aria-hidden="true">&ensp;</i></small></h5>
		<br>
	<h5><small>Amount Due:<i class="fa fa-inr" aria-hidden="true">&ensp;</i></small></h5>
	</div>
	</div>
		
	
	<!-- Trigger the modal with a button -->
	
	
	</div>
	</div>
	<

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

