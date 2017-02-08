<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="login" align="right" style="margin-top:0px">
	<c:if test="#session.existUser == null">
		<li><a class="login" href="<spring:url value="/login"/>">Login</a></li> 			
		<li><a class="login" href="<spring:url value="/register"/>">Register</a></li>
	</c:if>
	
	<c:if test="#session.existUser != null">
					
		<li>
			${session.existUser.firstName }
		</li>
			
		<li>
			<a class="login" href="<spring:url value="/logout"/>">Logout</a>
		</li>
	</c:if>
</div>


<li><a href="<spring:url value="/welcome"/>">Home</a></li>
<li><a href="<spring:url value="/products/"/>">Products</a></li>
<li><a href="<spring:url value="/products/add"/>">Add Product</a></li>
<li><a href="<spring:url value="/cart/"/>">Cart</a></li>

