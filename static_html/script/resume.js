document.getElementById("copyright").innerHTML = 
	"<p>@copy, "+ new Date()+ "Xuanyu Li, all rights reserved.</p>";
	
function showDetail(i) {
	var id = "project" + i;
	document.getElementById(id).style.display = "block";
}

$(function(){ 
	$("h2").hover(function(){ 
		$(this).next().slideDown(200); 
	});
	// some more events
});