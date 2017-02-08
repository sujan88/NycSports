<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

  	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resource/js/cart.js"/>"></script>

<title>Cart</title>
<style type="text/css">@import url("<c:url value="/resource/css/cart.css"/>");</style>
</head>
<body>
	<section>
 			<div id="prod" class="container"  >
   			     <div id="result" style="display:none" > </div>
			</div>
 	</section>	

 	<section class="container" >
 	
		<div class="row">
		<div class="col-md-5">
	    <a href="#" onclick="make_visible('formInput');return false;"><img src="<c:url value="/resource/images/orderNow.png"></c:url>" alt="image"  style = "width:100%"/></a>
       </div>
 		<div class="col-md-5">

			<div>
					<!-- checkout via web flow using URL parameter -->
				 <%-- <a href="<spring:url value="/checkout?cartId=${cartId}"/>" class="btn btn-success pull-right"> <span
					class="glyphicon-shopping-cart glyphicon"></span> Check out
				</a> --%>
				<a href="<spring:url value="/checkoutCart?cartId=${cartId}"/>" class="btn btn-success pull-right"  style="background-color:#006699;"> <span
					class="glyphicon-shopping-cart glyphicon"></span> Check out
				</a>
			</div>
			<table class="table table-hover">
				<tr>
					<th>---ID---</th>
					<th>Name</th>
					<th>Unit price</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</table>
	<table id="cart_table" class="table table-hover">
	
		<c:forEach  var="item" items ="${cart.cartItems}" >
				<tr>
					<td>${item.product.productId}</td>
					<td>${item.product.name}</td>
					<td>${item.product.unitPrice}</td>
					<td>${item.quantity}</td>
					<td>${item.totalPrice}</td>
					<td><a href="#" class="label label-danger" onclick="removeFromCart('${item.product.productId}');"> <span
							class="glyphicon glyphicon-remove" /></span> Remove
					</a></td>
				</tr>
		</c:forEach>
  
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>${cart.grandTotal}</th>
					<th></th>
				</tr>
			</table>
			
			<a href="<spring:url value="/products" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Continue shopping
			</a>
		</div></div>
	</section>
	
	
	
	<div id="formInput" style="display:none" > 
<p id="success" >  </p> 
<p id="errors" >  </p>
	<h3 align="center">Add to Cart</h3>

	<!-- No action method handled by AJAX-->
	<form id="cartForm" method="post">

			<input type="hidden" id="pid" name="pid" value="P8">
          
 
         <p>
            <label for="qty"> Quantity: </label>
            <input value="1" id="qty"  name="qty" type="text"/>
        </p>
 
           <center>  <input type="button" value="Add To Cart" onclick="addToCartMore();return false;"></center>
    
    </form>
  <h4 align="center"> 
     <a href="#" onclick="make_hidden('formInput');resetForm('formInput');"> <b>EXIT</b> </a> 
  </h4>

</div>
</body>
</html>
