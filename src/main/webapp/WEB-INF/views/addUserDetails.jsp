<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<script>
		$(document)
				.ready(
						function() {
							var contextRoot = getContextPath();
							addCustomerInfor = function() {
								var customer = new Object();
								customer.firstName = $("#inputFirstName").val();
								customer.lastName = $("#inputLastName").val();
								customer.email = $("#inputEmail").val();
								customer.dob = $("#inputDOB").val();
			
								var address = new Object();
								address.street = $("#inputStreet").val();
								address.city = $("#inputCity").val();
								address.state = $("#inputState").val();
								address.zipCode = $("#inputZipCode").val();
								
								var dataObject = new Object();
								dataObject.customer = customer;
								dataObject.address = address;
								
								var data = JSON.stringify(dataObject);
								
								console.log(data);
				
								$.ajax({
									url : contextRoot + '/addUserDetails',
									type : 'POST',
									dataType : 'json',
									data : data,
									contentType : 'application/json',
									success : function(response) {
									},
									error : function(xhr, exception) {
										console.log(xhr);

									}
								});
							};

							make_hidden = function(id) {
								var element = document.getElementById(id);
								element.style.display = 'none';
							};

							make_visible = function(id) {
								var element = document.getElementById(id);
								element.style.display = 'block';
							};

							function getContextPath() {
								return window.location.pathname.substring(0,
										window.location.pathname
												.indexOf("/", 2));
							};

						});
	</script>

	<div class="jumbotron text-left">
		<h1>Newyork Store</h1>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-5">
				<h3>Add Customer Information</h3>
				<form id="customerInfor" class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-3" for="firstname">*First
							name:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputFirstName">
						</div>
						<div id="errorsFirstName" style="display: none; color: red;"></div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="lastname">*Last
							name:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputLastName">
						</div>
						<div id="errorsLastName" style="display: none; color: red;"></div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="email">*Email:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control"
								placeholder="eg.example@newyork.com" id="inputEmail">
						</div>
						<div id="errorsEmail" style="display: none; color: red;"></div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="dob">DOB:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" placeholder="MM/DD/YYYY"
								id="inputDOB">
						</div>
						<div id="errorsDOB" style="display: none; color: red;"></div>
					</div>
				</form>
			</div>
			<div class="col-sm-5">
				<h3>Shipping Address</h3>
				<form id="shippingAddress" class="form-horizontal">
					<div class="form-group">
						<label class="control-label col-sm-3" for="street">Street:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputStreet">
						</div>
						<div id="errorsStreet" style="display: none; color: red;"></div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="city">City:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputCity">
						</div>
						<div id="errorsCity" style="display: none; color: red;"></div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="state">State:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputState">
						</div>
						<div id="errorsState" style="display: none; color: red;"></div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="zipCode">ZipCode:</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="inputZipCode">
						</div>
						<div id="errorsZipCode" style="display: none; color: red;"></div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="country">Country:</label>
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle col-sm-4"
								type="button" data-toggle="dropdown">
								Select Country <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">United States</a></li>
								<li><a href="#">Vietname</a></li>
								<li><a href="#">Chinese</a></li>
							</ul>
						</div>
					</div>
				</form>
			</div>
			<div class="col-sm-5">
				<label class="control-label col-sm-3" for="state"></label>
				<div class="col-sm-8">
					<button type="button" class="btn btn-primary col-sm-3" onclick="addCustomerInfor();">Save</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>