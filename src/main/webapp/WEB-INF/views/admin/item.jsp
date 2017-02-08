<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item</title>
<link rel='stylesheet' href='//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css'>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="<spring:url value="/welcome" />">NycSports</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="<spring:url value="/admin" />">Home</a></li>
			<li class="active"><a href="<spring:url value='/admin/item' />">Product</a></li>
			<li><a href="<spring:url value='/logout' />">Logout</a></li>
		</ul>
	</div>
	</nav>
	<div>
		<a href="<spring:url value="/admin/addItem" />"> <span
			class="btn btn-info">Add new item</span>
		</a>
	</div>
	<br />
	<table class="table table-bordered">
		<thead>
			<tr>
				<th></th>
				<th>Name</th>
				<th>Product ID</th>
				<th>Price</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${items}" var="item">
				<tr>
					<td><img
						src="<c:url value="../resource/images/${item.productId}.png"/>"
						alt="test" /></td>
					<td>${item.name}</td>
					<td>${item.productId}</td>
					<td>${item.unitPrice}</td>
					<td><a
						href="<spring:url value="/admin/editItem/${item.productId}" />"> <span
							class="btn btn-info">Edit / Delete</span>
					</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>