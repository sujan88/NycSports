//module -container for application – controllers, services, filters, directives, etc.
var cartApp = angular.module('cartApp', []);
 
	var contextRoot = "/" + window.location.pathname.split( '/' )[1];

	// $http service for reading data  [from servers]
	// $scoe binds data betwen controller & View [HTML DOM]	
cartApp.controller('cartCtrl',  function ($scope, $http) {
	
	$scope.refreshCart = function(cartId) {
		  						$http.get(contextRoot + '/rest/cart/'+$scope.cartId)
		  						 	 .success(function(data) {
		  						 		 		$scope.cart = data;
		  						 	 		});
		  					};
	
 //ECLIPSE Default - Strict validation of JavaScript keywords usage delete .vs. del
 // disable under Window.preferences
	$scope.clearCart = function() {
		  						$http.del(contextRoot + '/rest/cart/'+$scope.cartId)
		  							 .success($scope.refreshCart($scope.cartId));
		  						
	  					  };
	  					  
	$scope.initCartId = function(cartId) {
		  					$scope.cartId=cartId;
		  					$scope.refreshCart($scope.cartId);
	  						};
	  						
	  $scope.addToCart = function(productId) {
		  						$http.put(contextRoot + '/rest/cart/add/'+productId)
		  						 	 .success(function(data) {
		  						 		 		$scope.refreshCart($http.get(contextRoot + '/rest/cart/get/cartId'));
		  						 		 		alert("Product Successfully added to the Cart!");
		  						 	 		});
		  					};
	  $scope.removeFromCart = function(productId) {
			  						$http.put(contextRoot + '/rest/cart/remove/'+productId)
			  						 	 .success(function(data) {
			  						 		 	$scope.refreshCart($http.get(contextRoot + '/rest/cart/get/cartId'));
			  						 	 		});
			  					};
	  });
