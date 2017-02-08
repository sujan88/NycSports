<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Order Confirmation</title>
</head>

<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Order</h1>
				<p>Order Confirmation</p>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<form:form modelAttribute="order" action="confirm" method="post" class="form-horizontal">

				<div
					class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
					<div class="text-center">
						<h1>Receipt</h1>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<address>
								<strong>Shipping Address</strong> <br>
								${orderSession.shippingDetail.name}<br>
								${orderSession.shippingDetail.shippingAddress.street}
								<br>
								${orderSession.shippingDetail.shippingAddress.state}  ,${orderSession.shippingDetail.shippingAddress.zipCode}
								<br>
								${orderSession.shippingDetail.shippingAddress.country}
								<br>
							</address>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6 text-right">
							<p>
								<em>Shipping DateDate: <fmt:formatDate type="date"
										value="${orderSession.shippingDetail.shippingDate}" /></em>
							</p>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<address>
								<strong>Billing Information</strong> <br>
								<%-- ${order.creditCard.name}   
								<br>
								${order.creditCard.billingAddress.street}
								<br>
								${order.creditCard.billingAddress.state},${order.creditCard.billingAddress.zipCode}
								<br>
								${order.creditCard.billingAddress.country} --%>
								<br> <abbr title="Phone">Phone:</abbr>
								${orderSession.customer.phoneNumber}
								<br> <abbr title="CC Number">CC Number:</abbr>
								
								<%-- ${order.creditCard.number} --%>
							</address>
						</div>

					</div>
					<div class="row">

						<table class="table table-hover">
							<thead>
								<tr>
									<th>Product</th>
									<th>#</th>
									<th class="text-center">Price</th>
									<th class="text-center">Total</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="cartItem" items="${orderSession.cart.cartItems}">
									<tr>
										<td class="col-md-9"><em>${cartItem.product.name}</em></td>
										<td class="col-md-1" style="text-align: center">
											${cartItem.quantity}</td>
										<td class="col-md-1 text-center">$${cartItem.product.unitPrice}</td>
										<td class="col-md-1 text-center">$${cartItem.totalPrice}</td>
									</tr>
								</c:forEach>

								<tr>
									<td> </td>
									<td> </td>
									<td class="text-right"><h4>
											<strong>Grand Total: </strong>
										</h4></td>
									<td class="text-center text-danger"><h4>
											<strong>$${orderSession.cart.grandTotal}</strong>
										</h4></td>
								</tr>
							</tbody>
						</table>
						<button id="back" class="btn btn-default"
							>back</button>

						<button type="submit" class="btn btn-success" >
							Confirm   <span class="glyphicon glyphicon-chevron-right"></span>
						</button>
						<button id="btnCancel" class="btn btn-default"
							>Cancel</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
