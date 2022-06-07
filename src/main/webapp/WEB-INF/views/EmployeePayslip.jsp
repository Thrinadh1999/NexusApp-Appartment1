<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="pageWidth"id="empPaycolour">
<div class="right_col" role="main">
<span class="EmployeePaySlips"></span>
	<div class="container row">
		<div class="col-sm-12" id="empPaylip">
		<div class="page-title">
            <div class="titleflex">
            <div class="headingEmployeePayslip">
            <h3>S&M Scholary Solutions</h3>
            <h3 id="titl" >Employee PaySlip</h3>
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
		<div class="empDeta">
		<h6>Date of Joining: </h6>
		<h6>Pay Period: </h6>
		<h6>Worked Days: </h6>
		</div>
		<div class="empPay">
		<c:forEach items='${totalPayments}' var="payslip">
		<h6>Employee Name: ${payslip.employeeName}</h6>
		</c:forEach>
		<h6>Department:${depName.name}</h6>
		<br>
		</div>
		</div>
		<hr>
		
		<table class="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Employee Name</th>
				<th>Month</th>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items='${totalPayments}' var="payslip">
      <tr> 
      		
			<td>${payslip.id }
			<td>${payslip.employeeName}</td>
			<td>${payslip.month }</td>
			<td>${payslip.pay }</td>
			
			
			</tr>
			</c:forEach>

		</tbody>
	</table>
	<hr>
	<div class="amountDetails">
	<h5>Total Earnings: <i class="fa fa-inr" aria-hidden="true">&ensp;</i></h5>
	<h5>Amount in Words: <i class="fa fa-inr" aria-hidden="true">&ensp;</i></h5>
	</div>
	<hr>
	<div class="container row">
		<div class="emprSig">
		<h5>Employer Signature</h5>
		</div>
		<div class="empSig">
		<h5>Employee Signature</h5>
		</div>
		</div>
		<hr>
	<p id="bottomLine"><large> This is a System Generated Payslip</large></p>
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

