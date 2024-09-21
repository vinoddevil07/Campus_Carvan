<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, java.util.*, cc.beans.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminInbox</title>
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




	<%@include file="/admin/admin_header.html"%>



		<div class="container-fluid">

		<h1 class="text-danger" style="text-align: center;">Inbox</h1>

	</div>
	
	 <%

        AdminDao dao = new AdminDao(); // DAO class object
        ArrayList<Message> messageList = dao.viewinbox();
    %>



	<table class="table table-striped" style="border: 1px solid black;">
    <thead class="bg-warning">
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
				<td scope="row"><%=m.getSender_id() %></td>
				<td><%=m.getReceiver_id() %></td>
				<td><%=m.getSubject() %></td>
				<td><%=m.getMessage_text() %></td>
				<td><%= m.getDate() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>







	<%@include file="/admin/admin_footer.html"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>