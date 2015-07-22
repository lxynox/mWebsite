/* using jQuery syntax from google */
$(document).ready(function() {
//  navigator click events 
	$("#oldBlog").click(function() {
		$(this).css("background-color","#750F19");
		$("#newBlog").css("background-color", "#CD5C5C");
		$("#comments").css("background-color", "#CD5C5C");
		$("#oldBlog_div").css("display", "block");
		$("#comments_div").css("display", "none");
		$("#newBlog_div").css("display", "none");
	});
	$("#newBlog").click(function() {
		$(this).css("background-color","#750F19");
		$("#oldBlog").css("background-color", "#CD5C5C");
		$("#comments").css("background-color", "#CD5C5C");
		$("#newBlog_div").css("display", "block");
		$("#oldBlog_div").css("display", "none");
		$("#comments_div").css("display", "none");
	});
	$("#comments").click(function() {
		$(this).css("background-color", "#750F19");
		$("#newBlog").css("background-color", "#CD5C5C");
		$("#oldBlog").css("background-color", "#CD5C5C");
		$("#comments_div").css("display", "block");
		$("#newBlog_div").css("display", "none");
		$("#oldBlog_div").css("display", "none");
	});

});