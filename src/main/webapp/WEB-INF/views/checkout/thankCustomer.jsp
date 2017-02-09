<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Thank you </title>
</head>
<body>


<div class="jumbotron text-xs-center" style="background-color:white">
  <h1 class="display-3">Thank You!</h1>
  <p class="lead"><strong>Please check your Email. </strong> Thanks for the order. your order will be delivered to you on <strong>
				<fmt:formatDate type="date"	value="${shippingDate}" /> </strong>!</p>
				<p>Your Order Number is <strong>${orderId} </strong></p>
  <hr>
  <p>
    You can check your details with us. <a href="">Contact us</a>
  </p>
  <p class="lead">
    <a class="btn btn-primary btn-sm" href="<spring:url value="/welcome" />" role="button">Continue to homepage</a>
  </p>
</div>



</body>
</html>



