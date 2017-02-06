<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css"	rel="stylesheet">

		<div class="jumbotron" style="background-color:white">
		 
			
				<tiles:insertAttribute name="heading" />
	
			<p>
				<tiles:insertAttribute name="tagline" />
			</p>
		
		</div>
