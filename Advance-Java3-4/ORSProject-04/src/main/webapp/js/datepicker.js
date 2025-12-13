$(document).ready(function() {
	var currentYear = new Date().getFullYear();
	var maxYear = currentYear - 18;

	$("#udate").datepicker({
		dateFormat : 'dd-mm-yy',
		changeMonth : true,
		changeYear : true,
		yearRange : '1970:' + maxYear,
		minDate : new Date(1970, 0, 1),
		maxDate : new Date(maxYear, 11, 31)
	});
});

$(function() {
	var today = new Date();
	var currentYear = today.getFullYear();
	var currentMonth = today.getMonth();
	var currentDay = today.getDate();

	var maxDate = new Date(currentYear, currentMonth + 3, currentDay);

	$("#udatee").datepicker({
		dateFormat : 'dd-mm-yy',
		changeMonth : true,
		changeYear : true,
		yearRange : currentYear + ":" + currentYear,
		minDate : today,
		maxDate : maxDate,
		beforeShowDay : function(date) {
			return [ date.getDay() !== 0 ];
		}
	});
});
