<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Pranava EET</title>
<link rel="icon" href="resources/images/favicon.png" type="image/png" />
<!-- Bootstrap -->
<link href="resources/vendors/bootstrap/dist/css/bootstrap.css"	rel="stylesheet">
<!-- Custom Theme Style -->
<link href="resources/build/css/custom.min.css" rel="stylesheet">
<style type="text/css">/*! normalize.css v5.0.0 | MIT License | github.com/necolas/normalize.css */html{font-family:sans-serif;line-height:1.15;-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%}body{margin:0}article,aside,footer,header,nav,section{display:block}h1{font-size:2em;margin:.67em 0}figcaption,figure,main{display:block}figure{margin:1em 40px}hr{box-sizing:content-box;height:0;overflow:visible}pre{font-family:monospace,monospace;font-size:1em}a{background-color:transparent;-webkit-text-decoration-skip:objects}a:active,a:hover{outline-width:0}abbr[title]{border-bottom:none;text-decoration:underline;text-decoration:underline dotted}b,strong{font-weight:inherit}b,strong{font-weight:bolder}code,kbd,samp{font-family:monospace,monospace;font-size:1em}dfn{font-style:italic}mark{background-color:#ff0;color:#000}small{font-size:80%}sub,sup{font-size:75%;line-height:0;position:relative;vertical-align:baseline}sub{bottom:-.25em}sup{top:-.5em}audio,video{display:inline-block}audio:not([controls]){display:none;height:0}img{border-style:none}svg:not(:root){overflow:hidden}button,input,optgroup,select,textarea{font-family:sans-serif;font-size:100%;line-height:1.15;margin:0}button,input{overflow:visible}button,select{text-transform:none}[type=reset],[type=submit],button,html [type=button]{-webkit-appearance:button}[type=button]::-moz-focus-inner,[type=reset]::-moz-focus-inner,[type=submit]::-moz-focus-inner,button::-moz-focus-inner{border-style:none;padding:0}[type=button]:-moz-focusring,[type=reset]:-moz-focusring,[type=submit]:-moz-focusring,button:-moz-focusring{outline:1px dotted ButtonText}fieldset{border:1px solid silver;margin:0 2px;padding:.35em .625em .75em}legend{box-sizing:border-box;color:inherit;display:table;max-width:100%;padding:0;white-space:normal}progress{display:inline-block;vertical-align:baseline}textarea{overflow:auto}[type=checkbox],[type=radio]{box-sizing:border-box;padding:0}[type=number]::-webkit-inner-spin-button,[type=number]::-webkit-outer-spin-button{height:auto}[type=search]{-webkit-appearance:textfield;outline-offset:-2px}[type=search]::-webkit-search-cancel-button,[type=search]::-webkit-search-decoration{-webkit-appearance:none}::-webkit-file-upload-button{-webkit-appearance:button;font:inherit}details,menu{display:block}summary{display:list-item}canvas{display:inline-block}template{display:none}[hidden]{display:none}/*! Simple HttpErrorPages | MIT X11 License | https://github.com/AndiDittrich/HttpErrorPages */body,html{width:100%;height:100%;background-color:#21232a}body{color:#fff;text-align:center;text-shadow:0 2px 4px rgba(0,0,0,.5);padding:0;min-height:100%;-webkit-box-shadow:inset 0 0 75pt rgba(0,0,0,.8);box-shadow:inset 0 0 75pt rgba(0,0,0,.8);display:table;font-family:"Open Sans",Arial,sans-serif}h1{font-family:inherit;font-weight:500;line-height:1.1;color:inherit;font-size:36px}h1 small{font-size:68%;font-weight:400;line-height:1;color:#777}a{text-decoration:none;color:#fff;font-size:inherit;border-bottom:dotted 1px #707070}.lead{color:silver;font-size:21px;line-height:1.4}.cover{display:table-cell;vertical-align:middle;padding:0 20px}footer{position:fixed;width:100%;height:40px;left:0;bottom:0;color:#a0a0a0;font-size:14px}</style>
<style>
a {
    text-decoration: none;
    color: deepskyblue;
    font-size: inherit;
    border-bottom: none;
}
a:hover, a:focus{
	color: greenyellow;
}
</style>
</head>

<body>
	<div class="cover">
    	<a href="http://www.pranavaeet.com"><img src="resources/images/logo.png" alt="Pranava EET"/></a><br/><br/>
    	
    	<div class="col-md-4 col-sm-3 col-xs-0"></div>
    	<div class="col-md-4 col-sm-6 col-xs-12">        
       		<h3>Sign In</h3><br/>     
       		<c:if test="${not empty message}">       		
       		<h4 style="color:darkorange;">${message}</h4> <br/>     		
       		</c:if>  		
       		<div class="col-md-1 col-sm-0 col-xs-0"></div>
       		<div class="col-md-10 col-sm-10 col-xs-10">
       			
       			<form class="form-horizontal" action="<c:url value='/login'/>" method='post'>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />					
					<div style="border:1px solid #fff; padding:15px;">
						<div class="form-group">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<h5 style="float:left;">Username / Email </h5>
							</div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<input type="text" class="form-control" id="loginFormUsername" name="home_username" placeholder="Username / Email" required />
							</div>
							
						</div>
						<div class="form-group">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<h5 style="float:left;">Password </h5>
								<a style="margin-top:10px;" class="pull-right" href="forgot-password">Forgot Password?</a>
							</div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<input type="password" class="form-control" name="home_password" placeholder="Password" required />
							</div>
						</div>
						<div class="form-group" style="text-align:center;">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<h5 style="float:left;"> </h5>
							</div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<input style="width:100%;background:#398439;color:#fff;" class="btn" type="submit" value="Sign In" />
							</div>						
						</div>					
					</div>
					<div class="clearfix"></div>					
					
				</form>
       		</div>
       		<div class="col-md-1 col-sm-0 col-xs-0"></div>  
       		     						
    	</div>
    	<div class="col-md-4 col-sm-3 col-xs-0"></div>   
    	<div class="clearfix"></div>
      	<div style="height:100px;margin-top:10px;">
			<p style="text-align:center;margin-top:30px;">By signing in, you agree to our <a href="terms" target="_blank">Terms of Usage</a> and accept our <a href="privacy" target="_blank">Privacy Policy</a>.</p>
		</div>    
		<br/><br/> 
		<div class="clearfix"></div>
		<div style="bottom:0;height:auto;margin-top:40px;width:100%;text-align:center">
	        <p>©2019 All Rights Reserved. <a href="https://www.pranavaeet.com">Pranava EET LLP</a></p>
	    </div>        
    </div> 
    
    <!-- jQuery -->
<script src="resources/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="resources/build/js/custom.js"></script>

</body>
</html>