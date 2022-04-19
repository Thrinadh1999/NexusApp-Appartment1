
<%@ include file="Includes/JSPTags.jsp"%>

<%@ include file="Includes/HeaderScripts.jsp"%>

</head>
	<body class="nav-md footer_fixed">
		<div class="container body">
			<div class="main_container">
				<%@ include file="Includes/TopNavigationBar.jsp"%>

				<!-- page content -->
				<div class="right_col" role="main">
					<div class="row">
						<div class="clearfix"></div>
						<div class="x_panel">
							<div class="x_title">
								<h2>My Profile</h2>
								<div class="clearfix"></div>
							</div>
							<div class="x_content">
								<div class="row">
									<div class="col-md-8 col-sm-8 col-xs-12">
										<div class="x_panel">
											<div class="x_title">
												<h2>Profile Information</h2>
												<div class="clearfix"></div>
											</div>
											<div class="x_content">
												<form:form class="form-horizontal form-label-left"
												action="updateUserProfile?${_csrf.parameterName}=${_csrf.token}" 
												id="updateProfileForm" modelAttribute="userProfile">
													<form:hidden path="username" value="${username}" />
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-12 control-label">First Name: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:input path="firstname" class="form-control" required="required" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-12 control-label">Last Name: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:input path="lastname" class="form-control" required="required" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-12 control-label">Email: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:input path="email" type="email" class="form-control" required="required" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-12 control-label">Mobile: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:input path="mobile" class="form-control phoneMask" required="required" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-12 control-label">Gender: </label>
														<div class="col-md-8 p-0" style="margin:5px 0">
															<form:radiobutton path="gender" class="radio-button-styled" value="Male" required="required" /> Male
															<form:radiobutton path="gender" class="radio-button-styled" value="Female" required="required" /> Female
															<form:radiobutton path="gender" class="radio-button-styled" value="Other" required="required" /> Other
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-12 control-label">Date Of Birth: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:input path="dateOfBirth" class="form-control dobPicker" required="required" />
														</div>
													</div>
													<div class="form-group">
														<div class="col-md-12 col-sm-12 col-xs-12 p-0" style="text-align:center;">
															<input type="submit" value="Update" class="btn btn-success"/>
														</div>
													</div>
												</form:form>
											</div>
										</div>
									</div>
									<div class="col-md-4 col-sm-4 col-xs-12">
										<div class="x_panel">
											<div class="x_title">
												<h2>Profile Picture</h2>
												<a class="btn btn-sm btn-primary pull-right" href="javascript:void();"
												data-toggle="modal" data-target="#updatePictureModal">Update</a>
												<div class="clearfix"></div>
											</div>
											<div class="x_content">
												<img src="data:image/png;base64,${imageString}" alt="No Picture" style="height:305px;max-width:100%;"/>
												
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="x_panel">
											<div class="x_title">
												<h2>Profile Address</h2>
												<div class="clearfix"></div>
											</div>
											<div class="x_content">
												<form:form class="form-horizontal form-label-left"
												action="updateUserAddress?${_csrf.parameterName}=${_csrf.token}" 
												id="updateAddressForm" modelAttribute="userProfile">
													<form:hidden path="username" value="${username}" />
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-12 control-label">Address 1: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:input path="address1" class="form-control" required="required" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-12 control-label">Address 2: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:input path="address2" class="form-control" required="required" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-12 control-label">Country: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:select path="country" class="form-control" required="required" id="countryOpt">
															<c:forEach var="st" items="${countryList}">
															<form:option value="${st.id}" label="${st.countryName}"></form:option>
															</c:forEach>
															</form:select>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-12 control-label">State: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:select path="state" class="form-control" required="required" id="stateOpt">
															<c:forEach var="st" items="${stateList}">
															<form:option value="${st.id}" label="${st.stateName}" class="stateOptions state_${st.countryId}"></form:option>
															</c:forEach>
															</form:select>
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-12 control-label">City: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:input path="city" class="form-control" required="required"/>															
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-3 col-sm-3 col-xs-12 control-label">Zipcode: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:input path="zipcode" class="form-control" required="required" />
														</div>
													</div>
													<div class="form-group">
														<div class="col-md-12 col-sm-12 col-xs-12 p-0" style="text-align:center;">
															<input type="submit" value="Update" class="btn btn-success"/> 
														</div>
													</div>
												</form:form>
											</div>
										</div>
									</div>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="x_panel">
											<div class="x_title">
												<h2>Change Password</h2>
												<div class="clearfix"></div>
											</div>
											<div class="x_content">
												<form:form class="form-horizontal form-label-left"
												action="updatePassword?${_csrf.parameterName}=${_csrf.token}" 
												id="updatePwdForm" modelAttribute="password">
													<form:hidden path="username" value="${username}" />
													<div class="form-group">
														<label class="col-md-4 col-sm-4 xol-xs-12 control-label">New Password: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:input path="password" type="password" class="form-control" 
															placeholder="Type New Password" required="required" 
															id="passwordVal" data-validator="required" />
														</div>
													</div>
													<div class="form-group">
														<label class="col-md-4 col-sm-4 xol-xs-12  control-label">Confirm Password: </label>
														<div class="col-md-8 col-sm-8 col-xs-12 p-0">
															<form:input path="confirmPassword" type="password" class="form-control" 
															placeholder="Re-type New Password" required="required" 
															id="cnfPasswordVal" data-validator="required" />
														</div>
													</div>
													<div class="form-group">
														<div class="col-md-12 col-sm-12 col-xs-12 p-0" style="text-align:center;">
															<a href="#" id="updateButton" class="btn btn-success">Update</a>
															<p id="updateText" style="color:red;font-size:medium;font-weight:600;display:none;">Please Wait . . . </p> 
														</div>
													</div>
												</form:form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div id="updatePictureModal" class="modal fade" role="dialog" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									<h4 class="modal-title">Update Profile Picture</h4>
								</div>
								<div class="modal-body">
									<form:form class="form-horizontal form-label-left"
									action="updateUserPicture?${_csrf.parameterName}=${_csrf.token}" 
									id="updatePictureForm" modelAttribute="userProfile" enctype="multipart/form-data">
										<form:hidden path="username" value="${username}" />
										<div class="form-group">
											<div class="col-md-9 col-sm-9 col-xs-9 p-0" style="text-align:center;">
												<form:input path="imageUpload" type="file" class="imageFileUpload" accept="image/*"/> 
											</div>
											<!-- <div class="col-md-3 col-sm-3 col-xs-3 p-0" style="text-align:center;">
												<input type="submit" value="Update" class="btn btn-success"/> 
											</div> -->
										</div>
									</form:form>
								</div>
								<div class="modal-footer"></div>
							</div>
						</div>
					</div>
					
					<div style="height: 50px"></div>
				</div>
				<%@ include file="Includes/Footer.jsp"%>
			</div>
		</div>
		<!-- /page content -->
		<%@ include file="Includes/FooterScripts.jsp"%>
		<script>
		$(function(){
			$('#updateButton').on('click', function(e){
				e.preventDefault();
				var pwd = $('#passwordVal').val();
				var cnf = $('#cnfPasswordVal').val();
				if(pwd === cnf){
					if(pwd.length<8){
						alert('Password should have minimum 8 characters !!');
						return false;
					}else{
						$('#updateButton').hide();
						$('#updateText').show();
						$('#updatePwdForm').submit();
					}
				}else{
					alert('Passwords do not match. Please try again.');
					return false;
				}
			});
			
			$('#countryOpt').on('change keyup paste click', function(){
			    var selected = $(this).val();
			    $('.stateOptions').hide();
			    $('.state_'+selected).show();
			});
			
			$('#stateOpt').on('keyup change', function(){
			    var selected = $(this).val();
			    $('.cityOptions').hide();
			    $('.city_'+selected).show();
			});
			
			$('.imageFileUpload').fileinput({
				'showUpload': true,
				'showCaption': false,
				'maxFileSize': 5000
			});
			
			$('.dobPicker').on("keypress keydown keyup", function(e) {
				e.stopPropagation();
			    return false;
			});
			
			var cdate = moment().utcOffset(330).subtract('18','years');
			$('.dobPicker').daterangepicker({
				singleDatePicker : true,
				showDropdowns : true,
				format : "DD-MM-YYYY",
				maxDate: cdate,
				startDate: cdate,
				calender_style : "picker_3"
			});
			
			$('.dobPicker').on("change", function(e) {
				var selectedValue = $(this).val();				
				var sdate = moment(selectedValue, "DD-MM-YYYY").utcOffset(330);
				var diff = sdate.diff(cdate, 'years');
				if(diff<18){
					bootbox.alert('Previous Date cannot be selected.');
					$(this).val('');
					return false;
				}
			});
		})
		</script>
	</body>
</html>