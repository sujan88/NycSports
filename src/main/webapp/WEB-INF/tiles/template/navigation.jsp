<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="" align="right" style="margin-top:0px; margin-bottom:4px">
	<c:if test="#session.existUser == null">
	 <a class="btn btn-success" href="<spring:url value="/login"/>"><spring:message code="login" text="Login" /></a>		
	</c:if>
	
	<c:if test="#session.existUser != null">
					
		
			${session.existUser.firstName }
		
			
		
			<a class="btn btn-info" href="<spring:url value="/logout"/>"><spring:message code="logout" text="Logout" /></a>
	</c:if>
</div>


<li><a href="<spring:url value="/welcome"/>"><spring:message code="home" text="Home" /></a></li>
<li><a href="<spring:url value="/products/"/>"><spring:message code="product" text="Products" /></a></li>
<li><a href="<spring:url value="/cart/"/>"><spring:message code="cart" text="Cart" /></a></li>

