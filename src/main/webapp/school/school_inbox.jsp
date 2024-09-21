<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, java.util.*, cc.beans.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ParentInbox</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html"%>
</head>
<body>
	<div class="container-fluid bg-info" align="center">
		<h2>Campus Carvan</h2>
	</div>




	<%-- <%@include file="/common/common_header.html" %>
 --%>


	<%
	String school_id = (String) session.getAttribute("sessionKey");
	String role = (String) session.getAttribute("role");
	System.out.print(session.getId());
	if (school_id == null || session.isNew()) {
		request.setAttribute("msg", "Unauthorised Access, Please login First!");
		RequestDispatcher rd = request.getRequestDispatcher("/school/school_login.jsp");
		rd.forward(request, response);
	} else {

		if (role.equals("school")) {
	%>

	<%@include file="/school/school_header.html"%>


	<h1>CONTACTS</h1>

	<%
SchoolDao dao = new SchoolDao();// dao class object
ArrayList<Message>messageList=dao.viewinbox(school_id);

%>


	<table class="table">
		<thead>
			<tr>
				<th scope="col">Sender</th>
				<th scope="col">Reciever</th>
				<th scope="col">Subject</th>
				<th scope="col">Message</th>
				<th scope="col">Date</th>
			</tr>
		</thead>
		<tbody>

			<%
    
    for(Message m : messageList)
    {
    
    %>
			<tr>
				<th scope="row"><%=m.getSender_id() %></th>
				<th><%=m.getReceiver_id() %></th>
				<th><%=m.getSubject() %></th>
				<th><%=m.getMessage_text() %></th>
				<th><%= m.getDate() %>
			</tr>
			<%} %>
		</tbody>
	</table>


	<%@include file="/admin/admin_footer.html"%>

	<%
	}

	else {
	request.setAttribute("msg", "Apna Page Login Kro");
	RequestDispatcher rd = request.getRequestDispatcher("/school/school_login.jsp");
	rd.forward(request, response);

	}
	}
	%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>