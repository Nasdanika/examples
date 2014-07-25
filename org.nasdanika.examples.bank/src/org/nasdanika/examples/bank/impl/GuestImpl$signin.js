define(function() {
	return function(form) {
		var fe = jQuery(form).children(".form-group")
		fe.removeClass("has-error");
		if (form.onlineId.value && form.password.value) {
			jQuery.ajax(form.action, {
				data: {
					onlineId: form.onlineId.value,
					password: form.password.value
				},
				type: "POST",
				success: function(data, status, jqXHR) {
					window.location.href = data;
				},
				error: function(jqXHR, status, error) {
					if ("Unauthorized" == error) {
						fe.addClass("has-error");
						jQuery('#authentication-failed-modal').modal();
						fe.eq(0).children()[0].focus();												
					} else {
						alert(status+": "+error);
					}
				}
			});
		} else if (form.onlineId.value) {
			var pwd = jQuery(form).children(".form-group").eq(1)
			pwd.addClass("has-error");
			pwd.children()[0].focus();
			alert("Enter password");
		} else if (form.password.value) {
			var onlineId = jQuery(form).children(".form-group").eq(0);
			onlineId.addClass("has-error");
			onlineId.children()[0].focus();
			alert("Enter Online ID");			
		} else {
			var fe = jQuery(form).children(".form-group")
			fe.addClass("has-error");
			fe.eq(0).children()[0].focus();
			alert("Enter Online ID and Password");			
		}
	};
});