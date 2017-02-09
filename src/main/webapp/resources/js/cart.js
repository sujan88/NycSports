$(document).ready(function() {
	
	var cartId;
	
	addToCart = function(){
		
			$.ajax({
		 		url: '/NycSports/rest/cart/add/' +  $('#productId').val()+'/'+$('#quantity').val(),
		 		type: 'PUT',
				dataType: "json",
				success: function(){
					$("#errors_cart").hide();
					$("#cd-cart").html("");
					$("#cd-cart").append("<H4> Successfully Added To Cart. </H4>");
					$("#cd-cart").append("<p> Product Id : "+$('#productId').val()+" <br/>");
					$("#cd-cart").append("Quantity: : "+$('#quantity').val()+" </p>");
					$("#cd-cart").css('color','white')
					$("#cd-cart").css('background-color','gray')
					$("#cd-cart").show();
				},
				error: function( errorObject){						
					$("#errors_cart").html("");
					$("#errors_cart").append("<span> <span class='label label-warning'>Warning</span> : Please input a number. </span>");
					$("#errors_cart").css('color','red')
					$("#errors_cart").css('background-color','white')
					$("#errors_cart").show();
				}
			});
		}

	addToCartMore = function(){

		$.ajax({
	 		url: '/NycSports/rest/cart/add/' +  $('#pid').val()+'/'+$('#qty').val(),
	 		type: 'PUT',
			dataType: "json",
			success: function(data){
				
 		 		$("#success").html("");
 		 		$("#success").append(" <center> Successfully added to the Cart! </center>")
 		 		location.reload(true);

			},
			error: function( errorObject){		
				$("#errors").html("");
				$("#errors").append("<span> <span class='label label-warning'>Warning</span> : Please input a number. </span>");
				
			}
		});
	}
	
	
	   removeFromCart = function(productId) {
			$.ajax({
				url: '/NycSports/rest/cart/remove/'+ productId,
		 		type: 'PUT',
				dataType: "json",
			 	 success: function (response) {
		 		 		location.reload(true);
					},
					error: function(){						
						alert('Error while request..');
			 	 } 
		   });
	   }

	   viewMiniCart = function(){
			
			$.ajax({
		 		url: '/NycSports/rest/cart/mini',
		 		type: 'GET',
				dataType: "json",
				contentType: "application/json",
				success: function(cart){
					
	 		 		alert("succuss");

				},
				error: function( ){						
					alert('Error while request..');
				}
			});
		}

	   viewAddToCart = function(){
			
			$.ajax({
		 		url: '/NycSports/rest/cart/mini',
		 		type: 'GET',
				dataType: "json",
			
				success: function(cart){
					
	 		 		alert("succuss");

				},
				error: function( ){						
					alert('Error while request..');
				}
			});
		}

	 // Click on Product [row]  in cart
       $("#cart_table").find("tr").click(function() {  
	       	var productId=  $(this).find("td:first").html();
				showProduct(productId);
	          });

	   // Get product object from Server...
	   function showProduct(productId) {
			$.ajax({
				url: '/webstore08/rest/cart/showProduct',
		 		type: 'GET',
		 		async:false,
				dataType: "json",
				data:'id=' + productId,
			 	 success: function (response) {
		 		 		 displayProduct(response);
					},
					error: function(){						
 			 	 } 
		   });
	   }
	   
	   function displayProduct(product) {
	 
			$('#result').html("");
			$("#result").append('<h4 align="right"> <a href="#" onclick="toggle_visibility(\'result\');"><b>CLOSE</b> </a> </h4>');
			$("#result").append( '<H3 align="center"> Product Information <H3>');                
			$("#result").append( '<H4 align="center">' + product.productId + '<H4>');                
			$("#result").append( '<H4 align="center">' + product.name + '<H4>');               	 
			$("#result").append( '<H4 align="center">' + product.unitPrice + '<H4>');                
			$("#result").append( '<H4 align="center">' + product.manufacturer + '<H4>');                
			$("#result").append( '<H4 align="center">' + product.category.name + '<H4>');                
			$("#result").attr("style", "display: block")
	 		} 
	 
	   toggle_visibility = function(id) {
	       var e = document.getElementById(id);
	       if(e.style.display == 'block')
	          e.style.display = 'none';
	       else
	          e.style.display = 'block';
	    }	   
//------------------TO BE Implemented-------------------------------------	   
	   
		 getCartId = function( ) {
				$.ajax({
					url: '/NycSports/rest/cart/getId/',
					type: 'GET',
					success : function(id) {
					 		 		 cartId = id;
					 	 		}
			});
		 }


 
		 refreshCart = function() {
		 		getCartId();
				$.ajax({
					url: '/NycSports/rest/cart/'+ cartId,
					type: 'GET',
					dataType: "json",
					success : function(cartData) {
						$("#formInput").append("DDDDDDDDDDDDDDDDDDDDDDDDDDDDD")
  					 }
			});
		 }


});



resetForm = function(id) {
	$("#success").html("");
    var element = document.getElementById(id);
    $(element)[0].reset();

    }	  
	


make_hidden = function(id) {
    var e = document.getElementById(id);
        e.style.display = 'none';
        }	   

make_visible = function(id) {
    var e = document.getElementById(id);
    e.style.display = 'block';
 }	   

 