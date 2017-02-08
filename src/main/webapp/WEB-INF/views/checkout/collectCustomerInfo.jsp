<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">

	<style type="text/css">@import url("<c:url value="/resource/css/cart.css"/>");</style>
<title>Customer</title>
</head>
<body>
	<section><div class="container">
	<img src="<c:url value="/resource/images/customer.png"></c:url>" alt="image"  style = "height:20%;width:20%"/>
					
			</div>
	
	</section>
	<section  >
		<form:form modelAttribute="customer" method="post" action="shipping" id="formform" >
			<fieldset>
				<legend>Customer Details</legend>

		  		<p>
		  		     <form:errors path="*" cssStyle="color : red;" /> 
		        </p>
  
			<form:input id="customerId" path="customerId" type="hidden" value="1"  />
	
				<div >
					<label class="control-label col-lg-2" for="name">Name</label>
					<div >
						<form:input id="name" path="name" type="text" />					
					</div>
				</div>
 
				<div class="form-group">
					<label class="control-label col-lg-2" for="streetName">Street Name</label>
					<div class="col-lg-10">
						<form:input id="streetName" path="billingAddress.street" type="text"
							 />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="city">City</label>
					<div class="col-lg-10">
						<form:input id="city" path="billingAddress.city" type="text"
							/>
					</div>
				</div>
 				<div class="form-group">
					<label class="control-label col-lg-2" for="state">State</label>
					<div class="col-lg-10">
						<form:input id="state" path="billingAddress.state" type="text"
							/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="country">Country</label>
					<div class="col-lg-10">
						<form:input id="country" path="billingAddress.country" type="text"
							 />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zipCode">Zip Code</label>
					<div class="col-lg-10">
						<form:input id="zipCode" path="billingAddress.zipCode" type="text"
							 />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="phoneNumber">Phone Number</label>
					<div class="col-lg-10">
						<form:input id="phoneNumber" path="phoneNumber" type="text"
						/>
					</div>
				</div>
<br/>
			
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<button type="submit" id="btnAdd" size=5 class="button">Add</button>   
						<button id="btnCancel" class="button">Cancel</button>
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>
