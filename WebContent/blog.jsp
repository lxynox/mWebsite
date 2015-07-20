<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mWebsite.bean.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>my blog</title>
		<link href="./blogs/blog.css" rel="stylesheet">
		<script src="./script/index.js"></script>	
		<script src="//code.jquery.com/jquery-1.10.2.js"></script>
   		<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--> 		
		<script type="text/javascript" src="http://www.wufangbo.com/demo/jquery-1.4.4.min.js"></script>
	</head>
	
<%  Contact contact = (Contact) request.getAttribute("contact");
	Article article = (Article) request.getAttribute("article");
 	List<Contact> contactList = (List<Contact>) application.getAttribute("contactList");
 	List<Article> articleList = (List<Article>) application.getAttribute("articleList");
	%>
	<body>
<!-- left navi bar -->	
		<div id="left_side">
			<header>
				<h1 id="home">HOME</h1>	
				<nav class="tags">
					<dl>
						<dt><a href="index.html">About Me</a></dt>
						<dt style="background-color: #750F19"><a href="./blogs/blog.jsp">Blog</a></dt>
						<dt><a href="">Software Engineering</a></dt>
						<dt><a href="">Android</a></dt>
						<dt><a href="./resume/resume.html">Resume</a></dt>  
					</dl>
				</nav>
			</header>
			<p>I am <b>Xuanyu Li</b>.</p> 
			<p>I'm currently working on the field of <i>Software Engineering</i> (J2EE and Android developer).</p>
			<p>I'm a big fan of software and technology and their magical power that changes people's lives.</p>
			<div class="head_image">
		  	<img src="./images/me.jpg" alt="images/me.png" width="200" height="200">	
			</div>
			<p>I could be reached at <span><i><a href="mailto:xli6@wpi.edu">xli6@wpi.edu</a></i></span></p>
		</div> 

<!-- right content section -->
		<div id="right_side">
			<div id="blog_nav">
				<ul>
					<li id="oldBlog">My Blogs</li>
					<li id="newBlog">New Blog</li>
					<li id="comments">Comments</li>
				</ul>
			</div>
			<!-- some contents about the blogs go here -->
<!-- comments container -->
			<div id="comments_div">
				<form action="contactService" method="get" class="basic-grey">
				<input type="hidden" name="requestType" value="add"><!-- hidden input to pass the request type -->
					<h1>Contact Form
						<span>Please fill all the texts in the fields.</span>
					</h1>
					<label>
						<span>Your Name :</span>
						<input id="name" type="text" name="name" placeholder="Your Full Name" />
					</label>
					<label>
						<span>Your Email :</span>
						<input id="email" type="email" name="email" placeholder="Valid Email Address" />
					</label>
					<label>
						<span>Message :</span>
						<textarea id="message" name="message" placeholder="Your Message"></textarea>
					</label>
					<label>
						<span>Subject :</span>
						<select name="subject">
							<option value="Job Inquiry">Job Inquiry</option>
							<option value="General Question">General Question</option>
						</select>
					</label>
					<label>
						<span>&nbsp;</span>
						<input type="submit" class="button" value="Send" />
					</label>
				</form>
			</div>
<!-- new blog container -->

<!--TODO: move the below style to css file once completed -->

			<div id="newBlog_div">
				<form id="newBlog_form" action="articleService" method="get">
					<input type="hidden" name="requestType" value="add">
					<fieldset>
						<legend>new blog</legend>
						<table id = "newUserTable">
						<colgroup span = "2">
							<col width = "2" style = "padding-left:30px">
							<col width = "2" style = "">
						</colgroup>
							<!-- the first column of the table - span of 1 -->
							<tr>
								<td>Title</td>
								<td><input type = "text" id = "blog_title" name = "title" 
								placeholder = "Article Title (within 25 words)"> </td>
							</tr>	
							<tr>
								<td>Tag</td>
								<td><input type = "text" id = "blog_tag" name = "tag" 
								placeholder = "Article Tag (within 15 words)"> </td>
							</tr>
						</table>	
							
						<textarea name="blog_paragraph">
							here to type texts
						</textarea>
						<br><br>
						<input id= "newBlog_button" type="submit" name="submit_blog" value="Submit">
					</fieldset>
				</form>
			</div>
<!-- old blog container -->
			<div id="oldBlog_div">
				<h3 style="border-bottom:solid lightgrey 2px">Blogs</h3>
				
				<%
			if (articleList != null) {
				int i = 0;
				for (Article articles: articleList) {
					%>
					
				<div id="article_container<%= (i+1)%>" class="article_container" style="border-bottom: 1px solid lightgrey">
					<table>
						<tr>
							<td>#<%=articles.getId() %></td>
							<td><i><%=articles.getTag() %></i></td>
							<td><%=articles.getTimestamp() %></td>
						</tr>
					</table>
					<h4 style="margin-top:50px;margin-left:50px;color:navy">
						<strong><%= articles.getTitle().toUpperCase() %></strong>
						<span  id="view_paragraph_hinter<%= (i+1)%>" style="display:block;float:right;margin-right:50px;color:black" 
						onclick="showParagraph(<%= (i+1)%>)"><i>View Paragraph</i></span>
					</h4>
					
					<div style="text-align:center;display:none" id="oldBlog_paragraph<%= (i+1)%>">
					    <%=articles.getParagraph() %>
					</div>
					<p id="close_paragraph<%= (i+1) %>" onclick="collapseParagraph(<%= (i+1)%>)">Collapse Paragraph</p>
				</div>
				<% 	i++;
				}
			}
				%>
				<!-- empty div for spacing  -->
				<div style="height: 100px"></div> 
				
				<h3 style="border-bottom:solid lightgrey 2px">Comments</h3>
			<!-- div to display the contacts -->
				<% 
			if (contactList != null) {
				int i = 0; 
				for (Contact contact2: contactList) { 
					if (i == 5) {
					%>
					<p id="view_more_hinter" onclick="showMore()"> View More Comments </p>
				<%	}
					%>
				<div id="comment_container<%=(i+1)%>" style="border-bottom: solid lightgrey 1px">
					<table>
						<tr>
							<td><%=contact2.getName() %></td>
							<td><a href="mailto:<%=contact2.getEmail()%>"><%=contact2.getEmail() %></a></td>
							<td><%=contact2.getSubject() %></td>
							<%  Calendar time = contact2.getTime(); 
							    int year = time.get(Calendar.YEAR);
								int month = time.get(Calendar.MONTH);
								int day = time.get(Calendar.DAY_OF_MONTH);
								
								int hour = time.get(Calendar.HOUR);
								int minute = time.get(Calendar.MINUTE);
								int second = time.get(Calendar.SECOND);
							   %>
							<td><%=year+"/"+month+"/"+day+ " " + hour+":"+minute+":"+second %></td>
						</tr>
					</table>
					<p><%= contact2.getMessage() %>
						<span style="float:right; margin-right: 50px"><Strong>floor <%= (i+1)%></Strong>
						</span>
					</p>
				</div>
				<% i++;
				  } %>
 
				 <p id="collapse_hinter" onclick="collapse()"> Collapse Comments </p>
	<!-- case: no comments available -->
		 <%	} else {%>
		 	<p style="padding: 10px; font-size: 1.1em; text-align: center"><i>no comments yet :(</i></p>
		 <% }%>
			</div>
		</div>
		
<!-- bottom div -->
		<div id="footer">
			<p id="copyright"></p>
		</div>

<script type="text/javascript">	  
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

/* folder and unfolder the comments block */
collapse();
function showMore() {
	document.getElementById("collapse_hinter").style.display = "block";
	document.getElementById("view_more_hinter").style.display = "none";
	<%
	int i; 
	if (contactList != null) {
		for (i=contactList.size(); i>5; i--) {
			%>
			document.getElementById("comment_container<%=i%>").style.display = "block";
		<%	
		}
	}
	%>
}
function collapse() {
	document.getElementById("collapse_hinter").style.display = "none";
	document.getElementById("view_more_hinter").style.display = "block";
	<% 
	if (contactList != null) {
		for (i=contactList.size(); i>5; i--) {
			%>
			document.getElementById("comment_container<%=i%>").style.display = "none";
		<%	
		}
	}
	%>
}	

/* folder and unfolder the paragraph block */
function showParagraph(i) {
	document.getElementById("oldBlog_paragraph"+i).style.display = "block";
	document.getElementById("close_paragraph"+i).style.display = "block";
	document.getElementById("view_paragraph_hinter"+i).style.display = "none";
}
function collapseParagraph(i) {
	document.getElementById("oldBlog_paragraph"+i).style.display = "none";
	document.getElementById("close_paragraph"+i).style.display = "none";
	document.getElementById("view_paragraph_hinter"+i).style.display = "block";
}	
 

</script>

	</body>
</html>