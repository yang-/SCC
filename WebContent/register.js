$(function(){
	$(".offCampusRow").hide();
	// $(".offCampus:input").prop("required", false);
	// $( document ).tooltip({ position: { my: "left+15 center", at: "right center" } });
	var today = new Date();
	var startDate = new Date(2013, 7, 1);
	startDate = today.getTime()<startDate.getTime()?startDate:today;
	$( "#form-flightDate" ).datepicker({ 
		minDate: startDate, 
		maxDate: new Date(2013, 8, 1),
		onClose: function() {
			$( this ).valid();
		} 
	});

	$("#form-flightArrivalTime").mask("99:99");
	$('input[type=text]').keypress(function(e){
		if ( e.which == 13 ) return false;
	});
	$('input[type=email]').keypress(function(e){
		if ( e.which == 13 ) return false;
	});
	initRecaptcha();
			
	$.validator.addMethod("chinese", function(value, element) { 
		return this.optional(element) || !/[u4e00-u9fa5]/.test(value); 
	}, "Please enter chinese characters.");
	$.validator.addMethod("time12", function(value, element) { 
		return this.optional(element) || /^(([0]?[1-9])|([1][0-2])):([0-5]?[0-9])?$/.test(value); 
	}, "Please valid time.");
	$.validator.addMethod("time24", function(value, element) { 
		return this.optional(element) || /^(([0-1]?[0-9])|([2][0-3])):([0-5]?[0-9])?$/.test(value); 
	}, "Please valid time.");
	$("#signUpForm").validate({
		focusInvalid: true,
		onkeyup: function(element) {$(element).valid()},
		onfocusout: function(element) {$(element).valid()},
		rules: {
			"lastName": {
				required: true,
				chinese: true
			},
			"firstName": {
				required: true,
				chinese: true
			},
			"email": {
				required: true,
				email: true
			},
			"emergencyContact": {
				required: true,
				minlength: 10
			},
			"flightDate": "required",
			"flightArrivalTime": "required time24",
			"flightNumber": "required",
			"flightArrivalTerminal": "required",
			"destination": "required",
			"offCampus-addr1": {
				required: function(){
					return $("#form-destination").val() == 'other';
				}
			},
			"offCampus-city": {
				required: function(){
					return $("#form-destination").val() == 'other';
				}
			},
			"offCampus-zip": {
				required: function(){
					return $("#form-destination").val() == 'other';
				},
				number: true
			},
			"studentId": {
				required: true,
				number: true,
				minlength: 9
			},
			"major": "required",
			"qq": {
				required: true,
				number: true
			},
			"qqName": "required"
		},
		messages: {
			"lastName": "请输入真实中文姓名。",
			"firstName": "请输入真实中文姓名。",
			"email": {
				required: "请输入常用邮箱。",
				email: "请正确输入常用邮箱。"
			},
			"emergencyContact": {
				required: "请输入国内紧急联系电话。",
				minlength: "请正确输入国内紧急联系电话。"
			},
			"flightDate": "请选择你的到达日期（美国东部时间）。",
			"flightArrivalTime": "请输入航班到达时间（美国东部时间）",
			"flightNumber": "请输入你乘坐航班的航班号",
			"flightArrivalTerminal": "请选择航班到达JFK机场的航站楼。",
			"destination": "请选择你在石溪的住址。",
			"offCampus-addr1": "请输入你在石溪的校外住址。",
			"offCampus-city": "请输入你在石溪的校外住址。",
			"offCampus-zip": {
				required: "请输入你住址的邮编。",
				number: "请正确输入你住址的邮编。"
			},
			"studentId": {
				required: "请输入你的学号。",
				number: "请正确输入你的学号。",
				minlength: "请正确输入你的学号。"
			},
			"major": "请选择你的专业。",
			"qq": {
				required: "请输入你的QQ号。",
				number: "请正确输入你的QQ号。"
			},
			"qqName": "请输入你的QQ接机群群名片。"
		}
	});



});

function formDestinationChange(select){
	if (select == "other") {
		$(".offCampusRow").css("display", "table-row");
		// $(".offCampus:input").prop("required", true);
	} else {
		$(".offCampusRow").hide();
		// $(".offCampus:input").prop("required", false);
	};			
}

function initRecaptcha(){
	Recaptcha.create("6LcQjOASAAAAAOb3OKWr6GfOVHhdkEjgdfkBzxwy", 'captchadiv', {
		theme : "white",
		callback : function(){
			$('input[type=text]').keypress(function(e){
				if ( e.which == 13 ) return false;
			});
		}
	});
}

function verify(){
	var response = Recaptcha.get_response();
	if (response == "") {
		Recaptcha.focus_response_field();
	} else{
		var jqxhr = $.ajax({
			type: "POST",
			url: "Recaptcha",
			data: { 
				recaptcha_challenge_field: Recaptcha.get_challenge(), 
				recaptcha_response_field: response
				}
		}).done(function( data ) {
			if (data == "good") {
				$('.captcha').css("display","none");
				$('input[type="submit"]').css("display","inline-block");
				// $('input[type="submit"]').removeAttr('disabled');
				Recaptcha.destroy();
			} else{
				Recaptcha.reload();
				// alert("bad"); 
			};
		}).fail(function() { 
			Recaptcha.destroy();
			$("div#captchadiv").append("Error #1");
		});
		
	};
}