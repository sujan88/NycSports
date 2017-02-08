<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item</title>
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
	<spring:url value="/admin/addNewItem" var="myactionurl"/>
	<form:form modelAttribute="item" action="${myactionurl }" method="post" enctype="multipart/form-data">
		<div class="container">
			<div class="form-group">
				&nbsp;&nbsp;<label>Add Item</label>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">Name</label> 
				<form:input id="name" path="name" class="form-control" />
			</div>
			<form:errors path="name" cssStyle="color : red;" /> 
			<div class="form-group">
				<label class="control-label col-sm-2" for="productId">Product Id</label> 
				<form:input
					id="productId" path="productId" class="form-control" />
			</div>
			<form:errors path="productId" cssStyle="color : red;" /> 
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="description">Description</label>
				<form:textarea rows="10" cols="20" id="description" path="description"
					class="form-control"></form:textarea>
			</div>
			<div class="form-group">
            <label class="control-label col-sm-2" for="category">Category </label>
 		 	<form:select path="category.name">
		    	<form:option value="-" label=" --Select Category-- "/>
		
		  		<form:options  items="${categories}" itemValue="name" itemLabel="name" />
		    </form:select>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="unitPrice">Price</label> 
				<form:input
					id="unitPrice" path="unitPrice" class="form-control" />
			</div>
						<form:errors path="unitPrice" cssStyle="color : red;" /> 
			
			<div class="form-group">
				<div class="fileinput fileinput-new" data-provides="fileinput">
					<span class="btn btn-default btn-file"><span>Choose
							file</span><form:input type="file" path="productImage" /></span> <span
						class="fileinput-filename"></span>
				</div>
			</div>
			<div class="form-group">

				<input id="addNew" name="save" type="submit" class="btn btn-info"
					value='Add New' /> <a href="<spring:url value="/admin/item" />">
					<span class="btn btn-info">Cancel</span>
				</a>
			</div>
		</div>
	</form:form>
</body>
</html>
