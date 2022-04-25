<!-- jQuery -->
<script src="resources/vendors/jquery/dist/jquery.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
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
<script src="resources/vendors/summernote/summernote.min.js"></script>
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
	
	var searchTerm, panelContainerId;
	$.expr[':'].containsCaseSensitive = function(n, i, m) {
		return jQuery(n).text().toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
	};

	$('#search_bar').on('change keyup paste', function() {
		searchTerm = $(this).val();
		$('.searchPanel').each(function() {
			panelContainerId = '#' + $(this).attr('id');
			$(panelContainerId + ':not(:containsCaseInsensitive(' + searchTerm + '))').hide();
			$(panelContainerId + ':containsCaseInsensitive(' + searchTerm + ')').show();
		});
	});
})
</script>
<script>
$(function(){
	function idleTimerCheck() {
	    var t;
	    window.onload = resetTimer;
	    window.onmousemove = resetTimer;
	    window.onmousedown = resetTimer;        
	    window.ontouchstart = resetTimer;  
	    window.onclick = resetTimer;      
	    window.onkeypress = resetTimer;   
	    window.addEventListener('scroll', resetTimer, true); 

	    function reloadFunction() {
	    	bootbox.confirm({
	    	    backdrop: false,
	    		message: "<b>You have been inactive for 20 minutes. Page will be refreshed to re-activate your session. <br> Clicking Cancel may cause unexpected errors.</b>",
	    	    buttons: {
	    	        confirm: {
	    	            label: 'Okay',
	    	            className: 'btn-xs btn-success'
	    	        },
	    	        cancel: {
	    	            label: 'Cancel',
	    	            className: 'btn-xs btn-danger'
	    	        }
	    	    },
	    	    callback: function (result) {
	    	        if(result){
	    	        	var isInIframe = window.frameElement && window.frameElement.nodeName == "IFRAME";
	    	            if(isInIframe){        	
	    	            	window.parent.location.reload();
	    	            }else{
	    	            	window.location.reload();	
	    	            }
	    	        }
	    	    }
	    	});
	    }

	    function resetTimer() {
	        clearTimeout(t);
	        t = setTimeout(reloadFunction, 1200000);  // time is in milliseconds
	    }
	}
	idleTimerCheck();
})
</script>
