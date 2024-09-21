<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="cc.dao.*, java.util.*, cc.beans.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIEW FEEDACKS</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html" %>
</head>
<body>
<div class="container-fluid" align="center"> <h2 class="text-danger"> Campus Carvan</h2> </div>




<%-- <%@include file="/common/common_header.html" %>
 --%>




<%@include file="/admin/admin_header.html" %>


<h1>VIEW FEEDBACKS</h1>

<%
AdminDao dao = new AdminDao();// dao class object
ArrayList<Feedback>feedbackList=dao.viewFeedbacks();

%>

<div class="row">
<%
for(Feedback f : feedbackList){
%>
<div class="col-4 g-info mx-2">
<div class="card">
<div class="card-body">
<h5 class="card-title"><%=f.getName() %> review</h5>
<p class="card-text"> <%=f.getRemarks() %></p>
<h4 class="card-text">Rating :<%=f.getRating()%></h4>

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