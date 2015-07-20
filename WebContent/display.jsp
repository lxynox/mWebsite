<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mWebsite.bean.Contact, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<% Contact contact = (Contact) request.getAttribute("contact");
 List<Contact> contactList = (List<Contact>) request.getAttribute("contactList");
	%>
<body>
<!-- table to display the added contact -->
	<table>
		<tr>
			<td>Name</td>
			<td>Email</td>
			<td>Message</td>
			<td>Subject</td>
		</tr>
		<tr>
			<td><%= contact.getName() %></td>
			<td><%= contact.getEmail() %></td>
			<td><%= contact.getMessage() %></td> 
			<td><%= contact.getSubject() %></td>
		</tr>
	</table>
	<!-- css files -->
	<style>
		table {
			#width: 80%;
			text-align: center;
		}
		table tr td {
			width: 200px;
			#background-color: lightgrey;
			border-right: solid 1px lightgrey;
		}
		a {
			text-decoration: none;
		}
		p {
			margin-left: 50px;
			margin-top: 50px;
			font-style: italic; 
		}
		#view_more_hinter, #collapse_hinter {
			border: 1px solid lightgrey;
			border-radius: 5px 5px 5px 5px;
			width: 150px;
			padding: 15px;
		}
		#view_more_hinter:hover {
			border-width: 3px;
		}
		#collapse_hinter:hover {
			border-width: 3px;
		}
	</style>
	
<!-- div to display the contacts -->
	<% 
	int i = 0; 
	for (Contact contact2: contactList) { 
		if (i == 5) {
		%>
		<p id="view_more_hinter" onclick="showMore()"> View More Comments </p>
	<%	}
		%>
	<div id="comment_container<%=(i+1)%>" style="border-bottom: solid lightgrey 2px">
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
</body>
<script>
/* folder and unfolder the comments block */
collapse();
function showMore() {
	document.getElementById("collapse_hinter").style.display = "block";
	<% for (i=contactList.size(); i>5; i--) {
		%>
		document.getElementById("comment_container<%=i%>").style.display = "block";
	<%	
	}
	%>
}
function collapse() {
	document.getElementById("collapse_hinter").style.display = "none";
	<% for (i=contactList.size(); i>5; i--) {
		%>
		document.getElementById("comment_container<%=i%>").style.display = "none";
	<%	
	}
	%>
}	
</script>
</html>