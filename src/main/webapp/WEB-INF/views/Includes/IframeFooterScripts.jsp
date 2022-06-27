<!-- jQuery -->
<script src="resources/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="resources/build/js/custom.js"></script>
<!-- iCheck -->
<script src="resources/vendors/iCheck/icheck.min.js"></script>
<!-- jQuery custom content scroller -->
<script src="resources/vendors/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<!-- Bootstrap Datepicker -->
<script src="resources/js/moment/moment.min.js"></script>
<script src="resources/js/datepicker/daterangepicker.js"></script>
<!-- Bootstrap fileinput -->
<script src="resources/js/fileinput.min.js"></script>
<script src="resources/vendors/inputmask/dist/jquery.inputmask.min.js"></script>
<script src="resources/vendors/inputmask/dist/inputmask.min.js"></script>
<script src="resources/vendors/bootbox/bootbox.min.js"></script>
<script src="resources/customscripts/pnotifyMessage.js"></script>
<script src="resources/vendors/pnotify/dist/pnotify.js"></script>
<script src="resources/vendors/pnotify/dist/pnotify.buttons.js"></script>
<script src="resources/vendors/pnotify/dist/pnotify.nonblock.js"></script>
<script src="resources/js/firefoxDropdown.js"></script>
<script src="resources/js/customValidation.js"></script>
<script src="resources/js/disableAutofill.js"></script>
<script>
$(function(){
    $('.phoneMask').inputmask("999-999-9999");
	
	$('.nofillform').disableAutoFill({});
	
	$('.fileUpload').fileinput({
		'showUpload': false,
		'showCaption': false
	});
	$('[rel="tooltip"]').tooltip({
		placement: "bottom"
	});
})
</script>