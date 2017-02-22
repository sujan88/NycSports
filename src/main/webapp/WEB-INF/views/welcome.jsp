<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	  
	Language : <a href="?language=en_US">English</a>|<a href="?language=zh_CN"> <spring:message code="chinese" text="Chinese" /> </a>
	 
	<h3>
	 <spring:message code="welcome" text="Welcome to NycSports" />
	</h3>
	
	
	<form action="search" method="get" ><select name="category"> 
<option value="all">-select category-</option>
<c:forEach items="${categoryList}" var="ctg">
 <option value="${ctg.name}">${ctg.name}</option></c:forEach> </select>
 <input type="submit" value="Search"/></form>

 <br/>
 <c:if test="${catProducts != null }">
 <section class="container">
		<div class="row">
			
			<c:forEach items="${catProducts}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
					<img src="<c:url value="/resource/images/${product.productId}.png"></c:url>" alt="image"  style = "width:100%"/>
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p><spring:eval expression =  "product.unitPrice" /><spring:message code="currency.type"/></p>
							<p>Available ${product.unitsInStock} units in stock</p>
							<p><spring:eval expression =  "product.activeDate" /></p>
							<p>
								<a
									href=" <spring:url value="/products/product?id=${product.productId}" /> "
									class="btn btn-primary"> 
									<span class="glyphicon-info-sign glyphicon" /></span> <spring:message code="detail" text="Details" />
								</a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
	
 </c:if>
 <c:if test="${catProducts == null }">
 	
	<h3> <strong><spring:message code="nProducts" text="Newest Products" />
	</strong></h3>
<section class="container">

		<div class="row">
			
			<c:forEach items="${nProducts}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
					<img src="<c:url value="/resource/images/${product.productId}.png"></c:url>" alt="image"  style = "width:100%"/>
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p><spring:eval expression =  "product.unitPrice" /><spring:message code="currency.type"/></p>
							<p>Available ${product.unitsInStock} units in stock</p>
							<p><spring:eval expression =  "product.activeDate" /></p>
							<p>
								<a
									href=" <spring:url value="/products/product?id=${product.productId}" /> "
									class="btn btn-primary"> 
									<span class="glyphicon-info-sign glyphicon" /></span> <spring:message code="detail" text="Details" />
								</a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
	
<h3> <strong><spring:message code="cproducts" text="Cheapest Products"/></strong></h3>
	<section class="container">
		<div class="row">
			
			<c:forEach items="${pProducts}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
					<img src="<c:url value="/resource/images/${product.productId}.png"></c:url>" alt="image"  style = "width:100%"/>
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p><spring:eval expression =  "product.unitPrice" /><spring:message code="currency.type"/></p>
							<p>Available ${product.unitsInStock} units in stock</p>
							<p><spring:eval expression =  "product.activeDate" /></p>
							<p>
								<a
									href=" <spring:url value="/products/product?id=${product.productId}" /> "
									class="btn btn-primary"> 
									<span class="glyphicon-info-sign glyphicon" /></span> <spring:message code="detail" text="Details" />
								</a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
 </c:if>
 </body>
</html>