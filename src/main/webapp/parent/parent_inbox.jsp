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
	String parent_id = (String) session.getAttribute("sessionKey");
	String role = (String) session.getAttribute("role");
	System.out.print(session.getId());
	if (parent_id == null || session.isNew()) {
		request.setAttribute("msg", "Unauthorised Access, Please login First!");
		RequestDispatcher rd = request.getRequestDispatcher("/parent/parent_login.jsp");
		rd.forward(request, response);
	}
	else{	if(role.equals("parent")){

		

		%>

	<%@include file="/parent/parent_header.html"%>


	<h1 align="center">Inbox</h1>

	<%
ParentDao dao = new ParentDao();// dao class object
ArrayList<Message>messageList=dao.viewinbox(parent_id);
if(messageList.size()>0)
{
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
				<th scope="row"><%=m.getSender_id() %></th>
				<th><%=m.getReceiver_id() %></th>
				<th><%=m.getSubject() %></th>
				<th><%=m.getMessage_text() %></th>
				<th><%= m.getDate() %>
			</tr>
			<%} %>
		</tbody>
	</table>


<%}

else{
%>
<h2>no message yet</h2>

<%} %>

	<%@include file="/admin/admin_footer.html"%>
	
	
		<%}
else{
	request.setAttribute("msg", "Apna Page Login Kro");
	RequestDispatcher rd = request.getRequestDispatcher("/parent/parent_login.jsp");
	rd.forward(request, response);
	
}} %>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>