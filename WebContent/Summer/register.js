$(function(){
	$(".offCampus").prop("disabled", true);
	$(".offCampus:input").prop("required", false);
	$( document ).tooltip({ position: { my: "left+15 center", at: "right center" } });
	var today = new Date();
	var startDate = new Date(2013, 7, 1);
	startDate = today.getTime()<startDate.getTime()?startDate:today;
	$( "#form-flightDate" ).datepicker({ minDate: startDate, maxDate: new Date(2013, 8, 1) });
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
