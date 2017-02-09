<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<style type="text/css">@import url("<c:url value="/resource/css/creditcard.css"/>");</style>
<title>Customer</title>
</head>
<body>

	
	
	<div class="creditCardForm">
    <div class="heading">
        <h1><spring:message code="confirmPurchase"/></h1>
    </div>
    <div class="payment">
        <form:form modelAttribute="creditCard"  action="details"  method="post">
         <form:errors path="*" cssStyle="color:red"/>
            <div class="form-group owner">
                <label for="name"><spring:message code="owner"/></label>
                <form:input id="name" path="name" type="text" class="form-control" />
            </div>
            <div class="form-group CVV">
                <label for="cvv">CVV</label>
                <form:input id="cvv" path="cvv" type="text" class="form-control" />
            </div>
            <div class="form-group" id="card-number-field">
                <label for="number"><spring:message code="cardNumber"/></label>
               <form:input id="number" path="number" type="text" class="form-control" />
            </div>
            <div class="form-group" id="expiryDate">
                <label><spring:message code="expirationDate"/></label>
               <form:input id="expiryDate" path="expiryDate" type="text" class="form-control"/>
            </div>
            <div class="form-group" id="credit_cards">
            <img src="<c:url value="/resource/images/cc/visa.jpg"></c:url>" />
             <img src="<c:url value="/resource/images/cc/mastercard.jpg"></c:url>" />
              <img src="<c:url value="/resource/images/cc/amex.jpg"></c:url>" />

            </div>
            <div class="form-group" id="pay-now">
                <button type="submit" class="btn btn-default" id="confirm-purchase"><spring:message code="confirm"/></button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
