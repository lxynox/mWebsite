/*
author: lxynox
modfied on date: Jul,23,2015
changes:
	change the implementation of resume_content  hover function from jQuery to core javascript 
	*/

window.onload = function() {
	// object detection technology for graceful degradation && browser compatability
	if (!document.getElementById) return false;
	if (!document.getElementsByTagName) return false;
	
	//`/* display && update time in the footer div */
	setInterval(updateTime, 1000);
	
	// /* slide toggle of the contents of each section (education, objective, skills ... etc) */
	var resume_content = document.getElementById("contents");
	var h2_tags = resume_content.getElementsByTagName("h2");

	for (var i=0; i<h2_tags.length; i++) {
		h2_tags[i].onmouseover = function() {
			//alert ("onmouseover reached!");
			// detect whether the web browser(like firefox) count the empty-text as nextSibling 
			if (this.nextSibling.nodeType == 1) 
				this.nextSibling.style.display = "block";// web browser like IE
			else  
				this.nextSibling.nextSibling.style.display = "block";// web browser like firefox
		};
	}
	// alert("bottom of the script");
}

function updateTime() {
	// time clock update in the footer div 
	document.getElementById("copyright").innerHTML = 
		"<p>@copy, "+ new Date()+ "Xuanyu Li, all rights reserved.</p>";

}

function showDetail(i) {
	var id = "project" + i;
	document.getElementById(id).style.display = "block";
}