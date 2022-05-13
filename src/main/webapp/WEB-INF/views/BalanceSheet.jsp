
<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>


<%@ include file="Includes/Sidenav.jsp"%>
<%@ include file="Includes/Topnav.jsp"%>
<!-- page content -->
  <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_right">
                <div class="col-md-5 col-sm-5   form-group pull-right top_search">
                  <div class="input-group">
                    <label for="time"
								class="col-form-label col-md-4 col-sm-4 label-align">From Date</label>
							
                  </div>
                   <div class="input-group">
                    <label for="time"
								class="col-form-label col-md-4 col-sm-4 label-align">To Date</label>
							
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row" style="display: block;">
              <div class="col-md-6 col-sm-6  ">
                <div class="x_panel">
                  <div class="x_content">

                    <table class="table">
                      <thead>
                        <c:forEach items="${paymentsList }" var="pay">
                       <tr>
                       	<td>${pay.tranCatg }</td>
                       	<td>${pay.tAmntPay }</td>
                       </tr>
                       </c:forEach>
                        <tr>
                          <th><h3><small>Closing Balance</small></h3></th>
                          <td><h3><small><span id="closingBalance"></span></small></h3></td>
                        </tr>
                         <tr>
                          <th><h3><small>Tally</small></h1></th>
                          <td><h3><small><span id="tallyPayments"></span></small></h3></td>
                        </tr>
                      </thead>
                      <tbody>
                    </table>

                  </div>
                </div>
              </div>


              <div class="col-md-6 col-sm-6  ">
                <div class="x_panel">
                  
                  <div class="x_content">

                    <table class="table table-striped">
                      <thead>
                        <c:forEach items="${ReceiptsList }" var="pay">
                        <tr>
                        <td>${pay.tranCat }</td>
                       	<td>${pay.tAmntR }</td>
                        </tr>
                         </c:forEach>
                         <tr>
                        <th><h3><small>Opening Balance</small></th>
                        <td><h3><small>${openingBalance}</small></h3></td>
                        </tr>
                        <tr>
                        <th><h3><small>Tally</small></h3></th>
                        <td><h3><small><span id="tallyReceipts"></span></small></h3></td>
                        </tr>
                      </thead>
                      <tbody>
                    </table>
                    

                  </div>
                </div>
              </div>

              


              

             

              
            </div>
          </div>
        </div>
        <!-- /page content -->


	<%@ include file="Includes/Footer.jsp"%>

	<%@ include file="Includes/FooterScripts.jsp"%>
	<!-- /Datatables -->
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
	var paymentTotal =0;
	var receiptTotal=0;
	<c:forEach items="${paymentsList }" var="pay">
    	paymentTotal = paymentTotal+ parseInt(${pay.tAmntPay});
	</c:forEach>
	<c:forEach items="${ReceiptsList }" var="rec">
	receiptTotal = receiptTotal+ parseInt(${rec.tAmntR});
</c:forEach>

	var closingBalance= parseInt(${openingBalance})-paymentTotal+receiptTotal;
	$('#closingBalance').html(closingBalance);
	var TallyPayments =closingBalance + paymentTotal;
    $("#tallyPayments").html(TallyPayments);	
	var TallyReceipts = receiptTotal+parseInt(${openingBalance});
	$("#tallyReceipts").html(TallyReceipts) ;
	</script>
	

