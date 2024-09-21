<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, cc.beans.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>School Details</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html"%>

</head>
<body>
	<%@include file="/admin/admin_header.html"%>

	<h1 style="color: red; text-align: center;">School Details</h1>
	<%
AdminDao dao=new AdminDao();
ArrayList<School>schoolList=dao.viewschools();

%>

<form action="/CampusCarvan/Confirm_Booking" method="post">
<div style="margin: 3%">

<table class="table table-striped" style="border: 1px solid black;">
    <thead class="bg-warning">
        <tr>
            <th scope="col">School Name</th>
            <th scope="col">School Id</th>          
            <th scope="col">Founder</th>
            <th scope="col">E-mail</th>
            <th scope="col">Phone</th>
            <th scope="col">Address</th>
            <th scope="col">City</th>
            <th scope="col">Board</th>
            
        </tr>
    </thead>
    <tbody>
        <% for(School s : schoolList){ %>
            <tr>
                
                <td><%= s.getName()%></td>
                <td><%= s.getSchool_id()%></td>
                <td><%= s.getFounder()%></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getPhone()%></td>
                <td><%= s.getAddress()%></td>
                <td><%= s.getCity()%></td>
                <td><%= s.getBoard()%></td>
            </tr>
        <% } %>
    </tbody>
</table>
</div>
	
<br>
<br>
<div class="row">
			<div class="text-center">
			
			<button type="submit" class="btn btn-primary" style="margin-right: 20px"> Submit  </button>
				
			</div>
			
				<div class="col-3"></div>
				
		</div>		
			</form>	
	<%@include file="/common/common_footer.html"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>