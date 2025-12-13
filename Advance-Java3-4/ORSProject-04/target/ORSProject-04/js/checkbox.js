$(function() {
	$("#selectall").click(function() {
		$('.case').prop('checked', this.checked);
	});
	$(".case").click(
			function() {
				$("#selectall").prop("checked",
						$(".case").length === $(".case:checked").length);
			});
});