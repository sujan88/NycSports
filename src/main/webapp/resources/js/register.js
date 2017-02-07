$(document).ready(function() {
	//var contextRoot = getContextPath();
	//var sendToSend = JSON.stringify(serializeObject($('#newCustomer')));
	
	registerNewCustomer = function() {
		alert("hung duong");
		if(sendToSend.password == sendToSend.verifyPassword) {
			
		} else {
			$("#errors-username").html("");
			$("#errors-passord").html("");
			$("#errors-verifypassword").html("");
			$("#errors-verifypassword").append("Mishmatch password and verify password");
		}
	}
	
	// Translate form to array
	// Then put in JSON format
	function serializeObject(form) {
		var jsonObject = {};
		var array = form.serializeArray();
		$.each(array, function() {
			jsonObject[this.name] = this.value;
		});
		return jsonObject;

	};
})