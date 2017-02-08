<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customer</title>
</head>
<body>
	<section><div class="container">
	<img src="<c:url value="/resource/images/shipping.png"></c:url>" alt="image"  style = "height:40%;width:40%"/>
					
			</div>
	
	</section>
	<section class="container">
		<form:form modelAttribute="shippingDetail" action="details" method="post" class="form-horizontal">
			<fieldset>
				<legend>Shipping Details</legend>
	                <p>
		  		     <form:errors path="*" cssStyle="color : red;" /> 
		           </p>
 				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name" >Name </label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="shippingDate" />Ship Date (dd/mm/yyyy)</label>
					<div class="col-lg-10">
						<form:input id="shippingDate" path="shippingDate" type="text" class="form:input-large" />
					</div>
				</div>

 
				<div class="form-group">
					<label class="control-label col-lg-2" for="streetName">Street Name</label>
					<div class="col-lg-10">
						<form:input id="streetName" path="shippingAddress.street" type="text"
							class="form:input-large" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="city">City</label>
					<div class="col-lg-10">
						<form:input id="city" path="shippingAddress.city" type="text"
							class="form:input-large" />
					</div>
				</div>

 				<div class="form-group">
					<label class="control-label col-lg-2" for="state">State</label>
					<div class="col-lg-10">
						<form:input id="state" path="shippingAddress.state" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="country">Country</label>
					<div class="col-lg-10">
						<form:input id="country" path="shippingAddress.country" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zipCode">Zip Code</label>
					<div class="col-lg-10">
						<form:input id="zipCode" path="shippingAddress.zipCode" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<button id="back" class="btn btn-default" >back</button>
						
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" />
						<button id="btnCancel" class="btn btn-default" >Cancel</button>
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>
