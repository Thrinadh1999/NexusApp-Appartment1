<title>S&M Employee Manager</title>
<link rel="icon" href="resources/images/favicon.png" type="image/png" />
<!-- Bootstrap -->
<link href="resources/vendors/bootstrap/dist/css/bootstrap.css"	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="resources/build/css/custom.css" rel="stylesheet">
<!-- Font Awesome -->
<link rel="stylesheet" href="resources/vendors/fontawesome.5.13.1/css/all.css">
<!-- iCheck -->
<link href="resources/vendors/iCheck/skins/flat/green.css"	rel="stylesheet">
<link href="resources/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
<link href="resources/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
<link href="resources/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
<link href="resources/css/fileinput.min.css" rel="stylesheet">
<link href="resources/vendors/summernote/summernote.css" rel="stylesheet">
<link href="resources/vendors/inputmask/css/inputmask.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="resources/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<!-- NProgress -->
<link href="resources/vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- iCheck -->

<!-- bootstrap-progressbar -->
<link href="resources/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
<!-- JQVMap -->
<link href="resources/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
<!-- bootstrap-daterangepicker -->
<link href="resources/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="resources/build/css/custom.css" rel="stylesheet">
  </head>
<style>
p,ul,ol{
	text-align: justify;
}
.hideOverflow{
	white-space: nowrap;
    overflow-x: hidden;
    text-overflow: ellipsis;
}
.dropdown-menu a{
	display: list-item;
    padding: 5px 10px;
    border-bottom: 1px dotted;
    font-size: 12px;
}
.form-control{
	font-size:13px;
}
.info-number{
	width:30px;
	display:inline-block;
	padding-right:25px;
	margin-top: -10px;
	margin-left: 12px;
	color: blue;
	border-right: 2px dotted;
}
.info-number .badge{
	font-size: 8px;
	line-height:7px;
	right: 5px;
	top: -2px;
	color: white;
	background: red;
}
#search_bar{
	width: 100%;
    border: 1px solid yellowgreen;
    background-color: beige;
    border-radius: 30px;
    height: 28px;
    padding: 4px 10px;
    line-height: 1.32857143;
    color: #555;
}
.btn-xs{
	font-size:12px;
}
.username{
	float: left;
    margin: 5px 0 0 0;
    font-weight:300;
    font-size: 14px;
    width: 400px;
    text-overflow: ellipsis;
    text-align: left;
    overflow-x: auto;
    white-space:nowrap;
}
</style>
<style>
@media only screen and (max-width: 479px) {
   .browserOnly{ display: none !important; }
   .btn.btn-app {
	    position: relative;
	    padding: 7px;
	    margin: 15px 10px;
	    min-width: 40px;
	    height: 37px;
	    box-shadow: none;
	    border-radius: 50%;
	    text-align: center;
	    color: cyan;
	    border: 2px solid #ddd;
	    background-color: darkslategrey;
	    font-size: 9px;
	}
	.btn.btn-app::focus, .btn.btn-app::hover, .btn.btn-app::click {
		color: lawngreen;
	}
	#search_bar{
		margin-top:10px;
	}
	.x_title h2{
		display:contents;
	}
	.username{
	    font-size: 12px;
	    width: 200px;
	}
}
@media only screen and (min-width: 479px) {
   .mobileOnly{ display: none !important; }
   .btn.btn-app {
	    position: relative;
	    padding: 5px;
	    margin: 5px;
	    min-width: 75px;
	    height: 50px;
	    box-shadow: none;
	    text-align: center;
	    color: cyan;
	    border: 3px solid #ddd;
	    background-color: darkslategrey;
	    font-size: 10px;
	    border-radius: 15%;
	}
	.btn-app-text{
		font-size:11px;
	}
}
</style>
<script>
function resizeIframe(obj){
	var height = obj.contentWindow.document.body.scrollHeight;
	obj.style.height = height+20+'px'; 
}
</script>