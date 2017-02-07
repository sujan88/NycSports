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
	box-shadow: 0 1px 0 rgba(255, 255, 255, .6) inset;
	border-radius: 2px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<spring:message
									code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
								<br />
							</div>
						</c:if>
						<form action="<spring:url value="/postLogin"></spring:url>"
							method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-input-large" placeholder="User Name"
										name='username' type="text">
								</div>
								<div class="form-group">
									<input class=" form-input-large" placeholder="Password"
										name='password' type="password" value="">
								</div>
								<div class="form-group">
									<input type='checkbox' name="keepMe" />Remember Me? <br />
								</div>
								<input class="btn btn-lg btn-success btn-mini" type="submit"
									value="Login">
							</fieldset>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>

						<div class="a-divider a-divider-break">
							<h5>New to NycSports?</h5>
						</div>

						<span id="auth-create-account-link"
							class="a-button a-button-span12"> <span
							class="a-button-inner"> 
							
							<a id="createAccountSubmit"
								tabindex="6" href="/NycSports/register" class="a-button-text"
								role="button"> Create your Nyc account </a>
						</span></span>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>