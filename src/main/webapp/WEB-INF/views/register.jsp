<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<style>
.a-divider.a-divider-break {
	text-align: center;
	position: relative;
	top: 2px;
	padding-top: 1px;
	margin-bottom: 14px;
	line-height: 0;
}

.btn.btn-lg.btn-success.btn-mini {
	color: #fff;
	width: 100%;
}

.form-input-large {
	width: 100%;
}

.a-button-span12 {
	width: 100% !important;
}

.a-button {
	background: #e7e9ec;
	border-radius: 3px;
	border-color: #adb1b8 #a2a6ac #8d9096;
	border-style: solid;
	border-width: 1px;
	cursor: pointer;
	display: inline-block;
	padding: 0;
	text-align: center;
	text-decoration: none !important;
	vertical-align: middle;
}

.a-button-inner {
	display: block;
	position: relative;
	overflow: hidden;
	height: 29px;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .6) inset;
	border-radius: 2px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Nyc Registration</title>
</head>
<body>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
		
	</script>
	<script>
		$(document).ready(
				function() {
					var contextRoot = getContextPath();
					registerNewCustomer = function() {
						var sendToSend = JSON.stringify(serializeObject($('#newCustomer')));
						
						if ($('#inputPassword').val() == $('#inputVerifypassword').val()) {
							$.ajax({
								url: contextRoot + '/register',
								type: 'POST',
								dataType: 'json', 
								data: sendToSend,
								contentType : 'application/json',
								success: function(response) {
								},
								error: function(xhr, exception) {
									console.log(xhr);
									
									make_hidden('errorsUsername');
									make_hidden('errorsPassord');
									make_hidden('errorsVerifypassword');
									
									if(xhr.status == "200") {
										window.location.replace(contextRoot + '/welcome');
									} else if(xhr.status == "409") {
										$('#errorsUsername').html("");
										$('#errorsPassord').html("");
										$('#errorsVerifypassword').html("");
										$('#errorsUsername').append("Account already existed. Please enter other username");
										make_visible('errorsUsername');
									} else if(xhr.status == "400") {
										var json = JSON.parse(xhr.responseText);
										$('#errorsUsername').html("");
										$('#errorsPassord').html("");
										$('#errorsVerifypassword').html("");
										
										if(json.hasOwnProperty('username')) {
											$('#errorsUsername').append(json['username']);
											make_visible('errorsUsername');
										}
										
										if(json.hasOwnProperty('password')) {
											$('#errorsPassord').append(json['password']);
											make_visible('errorsPassord');
										}
									}
								}
							});
						} else {
							$('#errorsUsername').html("");
							$('#errorsPassord').html("");
							$('#errorsVerifypassword').html("");
							$('#errorsVerifypassword').append("Mishmatch password and verify password");
							make_visible('errorsVerifypassword');
						}
					};

					make_hidden = function(id) {
						var element = document.getElementById(id);
						element.style.display = 'none';
					}

					make_visible = function(id) {
						var element = document.getElementById(id);
						element.style.display = 'block';
					}
					
					function serializeObject(form) {
						var jsonObject = {};
						var array = form.serializeArray();
						$.each(array, function() {
							jsonObject[this.name] = this.value;
						});
						return jsonObject;

					};

					function getContextPath() {
						return window.location.pathname.substring(0,
								window.location.pathname.indexOf("/", 2));
					};
					
				});
	</script>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Create Account</h3>
					</div>
					<div class="panel-body">
						<form id="newCustomer" method="post">
							<fieldset>
								<div class="form-group">
									<input id="inputUsername" class="form-input-large"
										placeholder="Your name" name='username' type="text">
									<div id="errorsUsername" style="display: none; color : red;"></div>
								</div>
								<div class="form-group">
									<input id="inputPassword" class=" form-input-large"
										placeholder="Password" name='password' type="password"
										value="">
									<div id="errorsPassord" style="display: none; color : red;"></div>
								</div>
								<div class="form-group">
									<input id="inputVerifypassword" class=" form-input-large"
										placeholder="Password again" name='verifyPassword'
										type="password" value="">
									<div id="errorsVerifypassword" style="display: none; color : red;"></div>
								</div>
								<div class="btn btn-lg btn-success btn-mini"
									onclick="registerNewCustomer();">Create your Nyc account</div>

							</fieldset>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>