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
				<legend><spring:message code="customerDetails"/></legend>

		  		<p>
		  		     <form:errors path="*" cssStyle="color : red;" /> 
		        </p>
  
			<form:input id="customerId" path="customerId" type="hidden"  value="${customer.customerId}"  />
	
				<div >
					<label class="control-label col-lg-2" for="name"><spring:message code="name"/></label>
					<div >
						<form:input id="name" path="name"  value="${customer.name}" type="text" />					
					</div>
				</div>
 
				<div class="form-group">
					<label class="control-label col-lg-2" for="streetName"><spring:message code="street"/></label>
					<div class="col-lg-10">
						<form:input id="streetName" path="billingAddress.street" value="${customer.billingAddress.street}" type="text"
							 />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="city"><spring:message code="city"/></label>
					<div class="col-lg-10">
						<form:input id="city" path="billingAddress.city" value="${customer.billingAddress.city}" type="text"
							/>
					</div>
				</div>
 				<div class="form-group">
					<label class="control-label col-lg-2" for="state"><spring:message code="state"/></label>
					<div class="col-lg-10">
						<form:input id="state" path="billingAddress.state"  value="${customer.billingAddress.state}" type="text"
							/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="country"><spring:message code="country"/></label>
					<div class="col-lg-10">
						<form:input id="country" path="billingAddress.country" value="${customer.billingAddress.country}"  type="text"
							 />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zipCode"><spring:message code="zipcode"/></label>
					<div class="col-lg-10">
						<form:input id="zipCode" path="billingAddress.zipCode" value="${customer.billingAddress.zipCode}" type="text"
							 />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="phoneNumber"><spring:message code="phone"/></label>
					<div class="col-lg-10">
						<form:input id="phoneNumber" path="phoneNumber" value="${customer.phoneNumber}" type="text"
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
