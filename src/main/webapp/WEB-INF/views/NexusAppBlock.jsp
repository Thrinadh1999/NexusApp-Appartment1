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




