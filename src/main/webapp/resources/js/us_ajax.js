$(document).ajaxStart(function() {
	$('#wait').show();
});

$(document).ajaxStop(function() {
	console.log("ajaxStop: ");
	setTimeout(function() {
		$('#wait').hide();
	}, 3000);
});
$(document).ajaxError(function() {
	setTimeout(function() {
		$('#wait').hide();
	}, 3000);
});

$(document).ready(function() {

	$("#phone").inputmask({
		"mask" : "0 (999) 999-9999"
	});

	$("#updatephone").inputmask({
		"mask" : "0 (999) 999-9999"
	});

	$(".addClass").click(function() {
		createCaptcha("add");
	});
	$(".editClass").click(function() {
		var my_id_value = $(this).data('id');
		$(".modal-body #updateHiddenValue").val(my_id_value);

		setModalValueWithTableValue(my_id_value, "update", "table", "firstName");
		setModalValueWithTableValue(my_id_value, "update", "table", "lastName");
		setModalValueWithTableValue(my_id_value, "update", "table", "email");
		setModalValueWithTableValue(my_id_value, "update", "table", "phone");

		createCaptcha("update");
	});
	$(".deleteClass").click(function() {
		var my_id_value = $(this).data('id');
		$(".modal-body #hiddenValue").val(my_id_value);

		var firstNameId = my_id_value + "tablefirstName";
		var lastNameId = my_id_value + "tablelastName";

		var userInfoFirstName = document.getElementById(firstNameId).textContent;
		var userInfoLastName = document.getElementById(lastNameId).textContent;

		var userInfo = userInfoFirstName + " " + userInfoLastName;

		userInfo = '<span class="glyphicon glyphicon-eye-open"></span>' + userInfo;
		document.getElementById('deleteUserInfo').innerHTML = userInfo;

		createCaptcha("delete");
	});
	$(".deleteAllClass").click(function() {
		createCaptcha("deleteAll");
	});
});

function setModalValueWithTableValue(id, targetKeyPreffix, sourceKeyPreffix, key) {
	console.log("setModalValueWithTableValue : ", id + sourceKeyPreffix + key);
	console.log("targetKeyPreffix + key : ", targetKeyPreffix + key);
	var value = document.getElementById(id + sourceKeyPreffix + key).textContent;
	console.log("value ", value);

	$("#" + targetKeyPreffix + key).val(value);
}

function insertViaAjax() {
	$('#newUserErrorLbl').hide();
	console.log("NAME1: ", $("#firstName").val());
	console.log("NAME12: ", isEmpty($("#firstName").val()));

	if (isEmpty($("#firstName").val())) {
		displayAddErrorLabel("The firstName cannot be empty.");
		return false;
	}

	if (isEmpty($("#lastName").val())) {
		displayAddErrorLabel("The lastName cannot be empty.");
		return false;
	}

	if (isEmpty($("#email").val())) {
		displayAddErrorLabel("The email cannot be empty.");
		return false;
	}

	if (!validateEmail($("#email").val())) {
		var msg = $("#email").val() + " is not valid email adress.";
		displayAddErrorLabel(msg);
		return false;
	}

	if (isEmpty($("#phone").val())) {
		displayAddErrorLabel("The phone cannot be empty.");
		return false;
	}

	if (!validatePhone($("#phone").val())) {
		var msg = unmask($("#phone").val()) + " is not valid phone.";
		displayAddErrorLabel(msg);
		return false;
	}

	if (!validateCaptcha("add")) {
		var msg = "Invalid Captcha. Try Again";
		displayAddErrorLabel(msg);
		return false;
	}

	$('#newUserErrorLbl').hide();

	var user = {
		"firstName" : $("#firstName").val(),
		"lastName" : $("#lastName").val(),
		"email" : $("#email").val(),
		"phone" : unmask($("#phone").val())
	}

	console.log("NAME: ", $("#firstName").val());
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "insert/",
		// data : "name=" + $("#firstName").val(),
		data : JSON.stringify(user),
		dataType : 'json',
		timeout : 100000,
		success : function(response) {
			if (response.successful) {
				setTimeout(function() {
					$("#newUserModal").modal("hide");
				}, 1000);
				console.log("SUCCESS: ", response);
				perfomIndexAction()();
			} else {
				displayAddErrorLabel(response.resultMessage);
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayAddErrorLabel(e);
		},
		done : function(e) {
			console.log("DONE");
			setTimeout(function() {
				$("#newUserModal").modal("hide");
			}, 1000);
			perfomIndexAction();
		}
	});
}

function updateViaAjax() {
	$('#updateUserErrorLbl').hide();
	console.log("NAME1: ", $("#updateFirstName").val());
	console.log("NAME12: ", isEmpty($("#updateFirstName").val()));

	if (isEmpty($("#updateHiddenValue").val())) {
		var msg = "Invalid user choice.";
		displayUpdateErrorLabel(msg);
		return false;
	}

	if (isEmpty($("#updatefirstName").val())) {
		displayUpdateErrorLabel("The firstName cannot be empty.");
		return false;
	}

	if (isEmpty($("#updatelastName").val())) {
		displayUpdateErrorLabel("The lastName cannot be empty.");
		return false;
	}

	if (isEmpty($("#updateemail").val())) {
		displayUpdateErrorLabel("The email cannot be empty.");
		return false;
	}

	if (!validateEmail($("#updateemail").val())) {
		var msg = $("#updateemail").val() + " is not valid email adress.";
		displayUpdateErrorLabel(msg);
		return false;
	}

	if (isEmpty($("#updatephone").val())) {
		displayUpdateErrorLabel("The phone cannot be empty.");
		return false;
	}

	if (!validatePhone($("#updatephone").val())) {
		var msg = unmask($("#updatephone").val()) + " is not valid phone.";
		displayUpdateErrorLabel(msg);
		return false;
	}

	if (!validateCaptcha("update")) {
		var msg = "Invalid Captcha. Try Again";
		displayUpdateErrorLabel(msg);
		return false;
	}

	$('#newUserErrorLbl').hide();

	var user = {
		"id" : $("#updateHiddenValue").val(),
		"firstName" : $("#updatefirstName").val(),
		"lastName" : $("#updatelastName").val(),
		"email" : $("#updateemail").val(),
		"phone" : unmask($("#updatephone").val())
	}

	console.log("NAME: ", $("#updatefirstName").val());
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "update/",
		// data : "name=" + $("#firstName").val(),
		data : JSON.stringify(user),
		dataType : 'json',
		timeout : 100000,
		success : function(response) {
			if (response.successful) {
				setTimeout(function() {
					$("#updateUserModal").modal("hide");
				}, 1000);
				console.log("SUCCESS: ", response);
				perfomIndexAction()();
			} else {
				displayUpdateErrorLabel(response.resultMessage);
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayUpdateErrorLabel(e);
		},
		done : function(e) {
			console.log("DONE");
			setTimeout(function() {
				$("#updateUserModal").modal("hide");
			}, 1000);
			perfomIndexAction();
		}
	});
}

function deleteViaAjax() {

	if (isEmpty($("#hiddenValue").val())) {
		var msg = "Invalid user choice.";
		displayDeleteErrorLabel(msg);
		return false;
	}

	if (!validateCaptcha("delete")) {
		var msg = "Invalid Captcha. Try Again";
		displayDeleteErrorLabel(msg);
		return false;
	}

	var user = {
		"id" : $("#hiddenValue").val()
	}

	console.log("NAME: ", $("#hiddenValue").val());
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "delete/",
		// data : "name=" + $("#firstName").val(),
		data : JSON.stringify(user),
		dataType : 'json',
		timeout : 100000,
		success : function(response) {
			if (response.successful) {
				setTimeout(function() {
					$("#deleteUserModal").modal("hide");
				}, 1000);
				console.log("SUCCESS: ", response);
				perfomIndexAction()();
			} else {
				displayDeleteErrorLabel(response.resultMessage);
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayDeleteErrorLabel(e);
		},
		done : function(e) {
			console.log("DONE");
			setTimeout(function() {
				$("#deleteUserModal").modal("hide");
			}, 1000);
			perfomIndexAction();
		}
	});
}

function deleteAllViaAjax() {

	if (!validateCaptcha("deleteAll")) {
		var msg = "Invalid Captcha. Try Again";
		displayDeleteAllErrorLabel(msg);
		return false;
	}

	var umpRequest = {
		"processName" : "deleteAll"
	}

	console.log("JSON: ", JSON.stringify(umpRequest));

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "deleteAll/",
		data : JSON.stringify(umpRequest),
		dataType : 'json',
		timeout : 100000,
		success : function(response) {
			console.log("SUCCESS: ", response);
			if (response.successful) {
				setTimeout(function() {
					$("#deleteAllUserModal").modal("hide");
				}, 1000);
				console.log("SUCCESS: ", response);
				perfomIndexAction()();
			} else {
				displayDeleteAllErrorLabel(response.resultMessage);
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayDeleteAllErrorLabel(e);
		},
		done : function(e) {
			console.log("DONE");
			setTimeout(function() {
				$("#deleteAllUserModal").modal("hide");
			}, 1000);
			perfomIndexAction();
		}
	});
}

function getUserAllViaAjax() {

	var umpRequest = {
		"processName" : "getUserAll"
	}

	console.log("JSON: ", JSON.stringify(umpRequest));

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "getUserAll/",
		data : JSON.stringify(umpRequest),
		dataType : 'json',
		timeout : 100000,
		success : function(response) {
			console.log("SUCCESS: ", response);
			if (response.successful) {
				$.each(response.liseUser, function(id, firstName, lastName, email, phone) {
					var htmlrow = "<td id=\"" + id + "tablefirstName\">" + firstName + "</td>";
					htmlrow += "<td id=\"" + id + "tablelastName\">" + lastName + "</td>";
					htmlrow += "<td id=\"" + id + "tableemail\">" + email + "</td>";
					htmlrow += "<td id=\"" + id + "tablephone\">" + phone + "</td>";
					htmlrow += "<td><button type=\"button\" data-id=\"" + id + " class=\"btn btn-default btn-success editClass\" data-toggle=\"modal\" data-target=\"#updateUserModal\">Edit</button></td>";
					htmlrow += "<td><button type=\"button\" data-id=\"" + id + " class=\"btn btn-default btn-danger deleteClass\" data-toggle=\"modal\" data-target=\"#deleteUserModal\">Delete</button></td>";
					// $('#tableListUserCollection').append(htmlrow);
					document.getElementById('tableListUserCollection').innerHTML = htmlrow;
				});
			} else {
				perfomIndexAction();
			}
		},
		error : function(e) {
			console.log("ERROR: ", e);
		},
		done : function(e) {
			console.log("DONE");
			perfomIndexAction();
		}
	});
}

function isEmpty(val) {
	return (val === undefined || val == null || val.length <= 0) ? true : false;
}

function perfomIndexAction() {
	var link = "/SpringMVCMongoDBAjaxMaven/index";
	$(location).attr('href', link);
}

function displayAddErrorLabel(val) {
	$('#newUserErrorLbl').show();
	val = '<span class="glyphicon glyphicon-eye-open"></span>' + val;
	document.getElementById('newUserErrorLbl').innerHTML = val;
}

function displayUpdateErrorLabel(val) {
	$('#updateUserErrorLbl').show();
	val = '<span class="glyphicon glyphicon-eye-open"></span>' + val;
	document.getElementById('updateUserErrorLbl').innerHTML = val;
}

function displayDeleteErrorLabel(val) {
	$('#deleteUserErrorLbl').show();
	val = '<span class="glyphicon glyphicon-eye-open"></span>' + val;
	document.getElementById('deleteUserErrorLbl').innerHTML = val;
}

function displayDeleteAllErrorLabel(val) {
	$('#deleteAllUserErrorLbl').show();
	val = '<span class="glyphicon glyphicon-eye-open"></span>' + val;
	document.getElementById('deleteAllUserErrorLbl').innerHTML = val;
}

function validateEmail(email) {
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}

function validatePhone(phone) {
	var regExp = /[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\s\./0-9]*$/;
	console.log("xxxxxxxxx : ", phone.match(regExp));
	if (phone.match(regExp)) {
		return true;
	}
	return false;
}

function unmask(value) {
	var output = value.replace(new RegExp(/[^\d]/, 'g'), '');
	return output;
}

var code;
function createCaptcha(component) {
	document.getElementById(component + 'captcha').innerHTML = "";
	$("#" + component + "CpatchaTextBox").val("");
	
	var charsArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@!#$%^&*";
	var lengthOtp = 6;
	var captcha = [];
	for (var i = 0; i < lengthOtp; i++) {
		var index = Math.floor(Math.random() * charsArray.length + 1); // get
		if (captcha.indexOf(charsArray[index]) == -1)
			captcha.push(charsArray[index]);
		else
			i--;
	}
	var canv = document.createElement("canvas");
	canv.id = component + "captcha";
	canv.width = 100;
	canv.height = 50;
	var ctx = canv.getContext("2d");
	ctx.font = "25px Georgia";
	var gradient = ctx.createLinearGradient(0, 0, canv.width, 0);
	gradient.addColorStop("0", "magenta");
	gradient.addColorStop("0.5", "blue");
	gradient.addColorStop("1.0", "red");
	ctx.strokeStyle = gradient;
	ctx.strokeText(captcha.join(""), 0, 30);
	code = captcha.join("");
	document.getElementById(component + "captcha").appendChild(canv);
}
function validateCaptcha(component) {
	if (document.getElementById(component + "CpatchaTextBox").value == code) {
		return true;
	} else {
		createCaptcha(component);
		return false;
	}
}
