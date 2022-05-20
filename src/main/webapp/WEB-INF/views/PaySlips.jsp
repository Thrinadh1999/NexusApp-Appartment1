<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>

<link href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<link href="resources/css/MonthPicker.css" rel="stylesheet" type="text/css" />
<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
<div class="right_col" role="main">
<span class="Transactions"></span>
	<div class="container row">
		<div class="col-md-9">
		<div>
			<h1><large>Payslips</large></h1>
			<hr>
			</div>
			
			<icon type="icon" class="icon-block" data-toggle="modal"
				data-target="#myModal">
		</div>
		<div class="col-md-3">
			<button type="button" class="btn btn-info btn-md page-action-btn"
				data-toggle="modal" data-target="#myModal">
				<i class="fa fa-plus"></i> Generate Payslip
			</button>

		</div>

	</div>



	<table id="datatable" class="table">
		<thead>
			<tr>
				<th>Employee Name</th>
				<th>Date</th>
				<th>Pay</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items='${paySlip}' var="pay">
      <tr>
      <td>${pay.employeeName }</td>
      <td>${pay.month }</td>
      <td>${pay.pay }</td>
			
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
					<h4 class="modal-title">Create Payslip</h4>
				</div>
				<div class="modal-body">
					<form:form modelAttribute="newPay" action="addpaySlip"
						id="demo-form2" class="form-horizontal form-label-left"
						method="POST">
						<form:input id="id" maxlength="2" class="form-control"
							type="hidden" path="id"></form:input>.
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="employeeName">Employee Name<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:select id="Department" class="form-control " path="employeeName">
											<c:forEach items='${emplist}' var="list">
												<form:option value="${list.firstName } ${list.lastName }"> ${list.firstName } ${list.lastName }</form:option>
											</c:forEach>
										</form:select>
							</div>
				</div>
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="month">Month<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="month" path="month"
									required="required" class="form-control"></form:input>
							</div>
				</div>	
				<div class="item form-group">
					<label class="col-form-label col-md-4 col-sm-4 label-align"
								for="pay">Pay<span class="required">*</span>
					</label>
							<div class="col-md-6 col-sm-6 ">
								<form:input type="text" id="pay" path="pay"
									required="required" class="form-control"></form:input>
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
		<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"</script>
<script src="bower_components/jquery.maskedinput/dist/jquery.maskedinput.min.js"></script>
	<script
		src="resources/js/MonthPicker.js"></script>

<script>
//$('#datatable').DataTable();
$('#cancel-button').on('click', function() {
	$('#myModal').modal('hide');
});
$('#submit-button').on('click', function() {
	$('#demo-form2').submit();
});

$(document).ready(function(){
		 $( "#month" ).MonthPicker({MaxMonth: -1});
		 
});
</script>
	
	
	
	
	