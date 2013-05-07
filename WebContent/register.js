$(function(){
	$(".offCampus").prop("disabled", true);
	$(".offCampus:input").prop("required", false);
	$( document ).tooltip({ position: { my: "left+15 center", at: "right center" } });
	var today = new Date();
	var startDate = new Date(2013, 7, 1);
	startDate = today.getTime()<startDate.getTime()?startDate:today;
	$( "#form-flightDate" ).datepicker({ minDate: startDate, maxDate: new Date(2013, 8, 1) });

	$("#form-flightArrivalTime").mask("99:99");
	$('input[type=text]').keypress(function(e){
		if ( e.which == 13 ) return false;
	});
	$('input[type=email]').keypress(function(e){
		if ( e.which == 13 ) return false;
	});
	initRecaptcha();
			
});

function formDestinationChange(select){
	if (select == "other") {
		$(".offCampus").prop("disabled", false);
		$(".offCampus:input").prop("required", true);
	} else {
		$(".offCampus").prop("disabled", true);
		$(".offCampus:input").prop("required", false);
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