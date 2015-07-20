// jQuery
/* scroll the image gallery at an interval of 2s */
function autoScroll() {
	var _scroll = $("#image_slide>ul");
	//ul往左边移动200px
	_scroll.animate({marginLeft:"-200px"},1000,function(){
		//把第一个li丢最后面去
		_scroll.css({marginLeft:0}).find("li:first").appendTo(_scroll);
	});
}

$(document).ready(function() {
	//两秒后调用
	var _scrolling = setInterval("autoScroll()",2000);
	$("#image_slide>ul").hover(function(){
		//鼠标移动DIV上停止
		clearInterval(_scrolling);
	},function(){
		//离开继续调用
		_scrolling=setInterval("autoScroll()",2000);
	});
});