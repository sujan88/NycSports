<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="jumbotron text-left">
		<h1>Newyork Sport Store</h1>
	</div>

	<form:form modelAttribute="userDetail"
		action="/NycSports/addUserDetails" method="post">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<h3>Add Customer Information</h3>
					<div class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-lg-3" for="firstName">*First
								name:</label>
							<div class="col-sm-7">
								<form:input id="firstName" path="firstName" class="form-control" />
								<form:errors path="firstName" style="color: red;" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-lg-3" for="lastName">*Last
								name:</label>
							<div class="col-sm-7">
								<form:input class="form-control" id="lastName" path="lastName" />
								<form:errors path="lastName" style="color: red;" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-lg-3" for="email">*Email:</label>
							<div class="col-sm-7">
								<form:input class="form-control"
									placeholder="eg.example@newyork.com" id="email" path="email" />
								<form:errors path="email" style="color: red;" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-lg-3" for="dob">DOB:</label>
							<div class="col-sm-7">
								<form:input class="form-control" placeholder="MM/DD/YYYY"
									id="dob" path="dob" />
								<form:errors path="dob" style="color: red;" />
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<h3>Shipping Address</h3>
					<div class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-sm-2" for="street">Street:</label>
							<div class="col-sm-8">
								<form:input class="form-control" id="street"
									path="addresse.street" />
								<form:errors path="addresse.street"
									style="color: red;" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="city">City:</label>
							<div class="col-sm-8">
								<form:input class="form-control" id="city" path="addresse.city" />
								<form:errors id="addresse.city" style="color: red;" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="state">State:</label>
							<div class="col-sm-8">
								<form:input class="form-control" id="state"
									placeholder="Eg.IA (Must be 2 characters)"
									path="addresse.state" />
								<form:errors path="addresse.state" style="color: red;" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="zipCode">ZipCode:</label>
							<div class="col-sm-8">
								<form:input class="form-control" id="zipCode"
									path="addresse.zipCode" />
								<form:errors path="addresse.zipCode" style="color: red;" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="country">Country:</label>
							<div class="btn dropdown-toggle">
								<form:select path="addresse.country">
									<form:option value="-" label="Select Country" />
									<form:option value="United States" label="United States" />
									<form:option value="France" label="France" />
									<form:option value="Mexico" label="Mexico" />
									<form:option value="Chinese" label="Chinese" />
								</form:select>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<label class="control-label col-sm-3" for="state"></label>
					<div class="col-sm-8">
						<input id="addUser" name="Save" type="submit"
							class="btn btn-primary col-sm-3" />
					</div>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>