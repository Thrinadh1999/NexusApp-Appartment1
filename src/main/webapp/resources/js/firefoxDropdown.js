var fixFirefoxDropdownIssue = function() {
	jQuery('select option').each(function() {
	jQuery(this).text(jQuery(this).attr('label'));
	});
}	
 
function iframeResize(obj) {	  
	 try{
		 var height = obj.contentWindow.document.body.scrollHeight;
		  obj.style.height = height+'px';   
	 }catch(resizeErr){
		 console.log('Error with Iframe resize');
	 }	    
 } 