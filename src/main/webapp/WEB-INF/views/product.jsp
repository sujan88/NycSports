<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
 	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resource/js/cart.js"/>"></script>
	
<title>Products</title>
</head>
<body>

 	<section class="container" >
	
		<div class="row">
		<div class="col-xs-4">
	<img src="<c:url value="/resource/images/${product.productId}.png"></c:url>" alt="image"  style = "width:100%"/>
</div>
		
			<div class="col-xs-4">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>Item Code : </strong><span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong>manufacturer</strong> : ${product.manufacturer}
				</p>
				<p>
					<strong>category</strong> : ${product.category.name}
				</p>
				<p>
					<strong>Status</strong> : ${product.status}
				</p>
				<p>
					<strong>Availble units in stock </strong> : ${product.unitsInStock}
				</p>
				<p>
					<form action="#" id="form"><input value="1" type="text" id="quantity" name="quantity"/> <input type="hidden" id="productId" name="productId" value="${product.productId}"/>
					</form>
				</p>
				<h4><spring:eval expression =  "product.unitPrice" /> <spring:message code="currency.type"/></h4>
				<p ng-controller="cartCtrl">
 					<a href="#" class="btn btn-warning btn-large" onclick="addToCart();return false;"> 
<span class="glyphicon-shopping-cart glyphicon"></span> Order Now </a>
<a href="<spring:url value="/cart" />" class="btn btn-default">
	<span class="glyphicon-hand-right glyphicon"></span> View Cart
</a>

 <a href="<spring:url value="/products" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> back
					</a>

				</p>

			</div>
			
			<div class="col-xs-4" id="cd-cart"></div>
			
			
	
		<c:forEach  var="item" items ="${cart.cartItems}" >
				
					
					${item.product.name}     ${item.product.unitPrice}    ${item.quantity} <br/>
					
					<a href="#" class="label label-danger" onclick="removeFromCart('${item.product.productId}');"> <span
							class="glyphicon glyphicon-remove" /></span> Remove
					</a>

		</c:forEach>
  
				 ${cart.grandTotal}
					
			
		</div>
<!--/div-->
	</section>
</body>
</html>
