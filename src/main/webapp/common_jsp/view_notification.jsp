<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="cc.dao.*, cc.beans.*, java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>


<%
AdminDao dao=new AdminDao();
ArrayList<Notification> notice=dao.viewNotice();
%>
<div class="row" style="yellow">
<%
for(Notification n : notice){
%>
<marquee onmouseover="stop()" onmouseout="start()" direction="right" style="width: 100%; height:22px ; color: red " ><strong><%=n.getNotice_content() %></strong></marquee>

<%} %>
</div>

</html>