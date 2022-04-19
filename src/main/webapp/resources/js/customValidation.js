$(function() {

	$('.container').prepend(
		$("<div class='loader'><div class='loader-container'><h3><img src='resources/images/loading_icon.gif' width='440' height='290' alt='Loading . . .' /></h3></div></div>"));

	$(window).load(function() {
		$(".loader").fadeOut(1000);
	});
	$(window).bind('beforeunload', function() {
		$(".loader").fadeIn(2000);
		sessionStorage.clear();
	});

	$(".phoneNumberMask").inputmask();

	$('.requireDatePicker').daterangepicker({
		singleDatePicker : true,
		showDropdowns : true,
		format : "YYYY-MM-DD",
		calender_style : "picker_3"
	});

	var searchTerm, panelContainerId;
	$.expr[':'].containsCaseInsensitive = function(n, i, m) {
		return jQuery(n).text().toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
	};

	$('#accordion_search_bar').on('change keyup paste click', function() {
		searchTerm = $(this).val();
		$('#accordion > .panel').each(function() {
			panelContainerId = '#' + $(this).attr('id');
			$(panelContainerId + ':not(:containsCaseInsensitive(' + searchTerm + '))').hide();
			$(panelContainerId + ':containsCaseInsensitive(' + searchTerm + ')').show();
		});
	});

	$('#accordion_30search_bar').on('change keyup paste click', function() {
		searchTerm = $(this).val();
		$('#accordion > .panel').each(function() {
			panelContainerId = '#' + $(this).attr('id');
			$(panelContainerId + ':not(:containsCaseInsensitive(' + searchTerm + '))').hide();
			$(panelContainerId + ':containsCaseInsensitive(' + searchTerm + ')').show();
		});
	});

	fixFirefoxDropdownIssue();
	
})