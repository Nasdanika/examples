var jqForm = jQuery(this);
var formGroups = jqForm.children(".form-group");
formGroups.removeClass("has-error");
var errorMessageContainer = jqForm.children("#signupErrorMessage");
errorMessageContainer.html("");

if (this.onlineId.value && this.customerName.value && this.password.value && this.passwordConfirm.value) {
	if (this.password.value!=this.passwordConfirm.value) {
		errorMessageContainer.html("Passwords don't match");
		var pwd = formGroups.eq(3);
		pwd.addClass("has-error");
		pwd.children()[0].focus();
		
		pwd = formGroups.eq(3);
		pwd.addClass("has-error");				
	} else {
		// TODO - validate id and password minimal length and maybe password strength.
		
		// TODO - post, display error message if any, navigate to new user otherwise.
		jQuery.ajax(this.action, {
			data: {
				onlineId: this.onlineId.value,
				customerName: this.customerName.value,
				password: this.password.value,
				passwordConfirm: this.passwordConfirm.value
			},
			type: "POST",
			success: function(data, status, jqXHR) {
				//console.log("Navigating to "+data);
				window.location.href = data;
			},
			error: function(jqXHR, status, error) {
				if ("Unauthorized" == error) {
					fe.addClass("has-error");
					jQuery('#authentication-failed-modal').modal();
					fe.eq(0).children()[0].focus();												
				} else {
					errorMessageContainer.html(status+": "+error);		
				}
			}
		});
	}
} else {
	
	// These validations are not required because input fields are marked as requied
	// They are here to demonstrate how to implement validations.
	
	var error = "";
	
	if (!this.passwordConfirm.value) {
		var pc = formGroups.eq(3);
		pc.addClass("has-error");
		pc.children()[0].focus();
		error = "<LI>Password confirmation is blank</LI>";			
	}
	
	if (!this.password.value) {
		var pwd = formGroups.eq(2);
		pwd.addClass("has-error");
		pwd.children()[0].focus();
		error = "<LI>Password is blank</LI>"+error;
	}
	
	if (!this.customerName.value) {
		var customerName = formGroups.eq(1);
		customerName.addClass("has-error");
		customerName.children()[0].focus();
		error = "<LI>Customer name is blank</LI>"+error;			
	}	
	
	if (!this.onlineId.value) {
		var onlineId = formGroups.eq(0);
		onlineId.addClass("has-error");
		onlineId.children()[0].focus();
		error = "<LI>Online ID is blank</LI>"+error;			
	}
	
	errorMessageContainer.html("<UL>"+error+"</UL>");			
}

return false;