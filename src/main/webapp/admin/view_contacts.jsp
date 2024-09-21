<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, java.util.*, cc.beans.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW CONTACTS</title>
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


	<%@include file="/admin/admin_header.html"%>


		<div class="container-fluid">

		<h2 class="text-danger" style="text-align: center;">Contacts</h2>

	</div>
	
	<%
AdminDao dao = new AdminDao();// dao class object
ArrayList<Contacts>contactList=dao.viewContacts(); 
%>

<div style="margin: 3%">

<table class="table table-striped" style="border: 1px solid black;">
    <thead class="bg-warning">
        <tr>
            	<th scope="col">UserName</th>
				<th scope="col">EmailID</th>
				<th scope="col">PhoneNumber</th>
				<th scope="col">UserQuestions</th>
				<th scope="col">Date</th>
        </tr>
    </thead>
    <tbody>
          <%  for(Contacts c : contactList){ %>
            <tr>
              <td scope="row"><%=c.getUser_name() %></td>
				<td><%=c.getUser_email() %></td>
				<td><%=c.getUser_phone() %></td>
				<td><%=c.getUser_question() %></td>
				<td><%= c.getDate() %></td>
            </tr>
        <% } %>
</table>
</div>

	<%@include file="/admin/admin_footer.html"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>