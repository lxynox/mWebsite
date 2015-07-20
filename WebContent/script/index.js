/**
 * @author: lxynox
 * Date: 16, Jul, 2015
 * Description: js source for index.html
 */

// javascript
/* change the font color of the Header dynamically */
var state = 0;
function changeColor() { 
	var color = ["white", "#750F19"];
	document.getElementById("home").style.color = color[state++%2];
// footer: get copyright &&  update time 
	document.getElementById("copyright").innerHTML = 
	"<p>@copy, "+ new Date()+ "Xuanyu Li, all rights reserved.</p>";
} 
setInterval("changeColor()", 1000);



