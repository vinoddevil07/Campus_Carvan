i
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="cc.dao.*, java.util.*, cc.beans.*, cc.common_servlets.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewVehicles</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html" %>
</head>
<body>
<div class="container-fluid bg-info" align="center"> <h2> Campus Carvan</h2> </div>




<%@include file="/common/common_header.html" %>







<h1>Employes</h1>
<%
EmployeDao dao = new EmployeDao();// user class object
ArrayList<Employes>emplist=dao.viewEmployes();
%>

<div class="row">
<%
for(Employes e :emplist){
%>
<div class="col-4  mx-2" >
<div class="card">
<div class="card-body">
<h2 class="card-title" style="text-align: center"><%=e.getName() %> </h2>
<p class="card-text"><strong>Id is:</strong><%=e.getEmployee_id()%></p>
<p class="card-text"><strong> Email:</strong><%=e.getEmail()%></p>
<p class="card-text"><strong>Password:</strong><%=e.getPass()%></p>
<p class="card-text"><strong>Phone:</strong><%=e.getPhone()%></p>

</div>
</div>

</div>
<%} %>
</div>  <!-- row-close -->


<%@include file="/admin/admin_footer.html" %>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>