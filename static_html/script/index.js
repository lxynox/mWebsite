/**
 * @author: lxynox
 * Date: 16, Jul, 2015
 * Description: js source for index.html
 */


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

/* image scroll functions - at an interal of 2 seconds */ 
function autoScroll() {
	var _scroll = $("#image_slide>ul");
	//ul往左边移动200px
	_scroll.animate({marginLeft:"-200px"},1000,function(){
		//把第一个li丢最后面去
		_scroll.css({marginLeft:0}).find("li:first").appendTo(_scroll);
	});
}
$(function(){
	//两秒后调用
	var _scrolling=setInterval("autoScroll()",2000);
	$("#image_slide>ul").hover(function(){
		//鼠标移动DIV上停止
		clearInterval(_scrolling);
	},function(){
		//离开继续调用
		_scrolling=setInterval("autoScroll()",2000);
	});
});

