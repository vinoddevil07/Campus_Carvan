<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, cc.beans.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Drivers Details</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html"%>

</head>
<body>
	<%@include file="/admin/admin_header.html"%>

	<h1 style="color: red; text-align: center;">Drivers Details</h1>
	<%
AdminDao dao=new AdminDao();
ArrayList<Driver>driverList=dao.viewdrivers();

%>

<form action="" method="post">
<div style="margin: 3%">

<table class="table table-striped" style="border: 1px solid black;">
    <thead class="bg-warning">
        <tr>
            <th scope="col">Driver Name</th>
            <th scope="col">Driver Id</th>
            <th scope="col">Phone</th>
            <th scope="col">E-mail</th>
            <th scope="col">Address</th>
            <th scope="col">City</th>
             <th scope="col">Gender</th>
            
            <th scope="col">Qualification</th>
             <th scope="col">Experience</th>       
        </tr>
    </thead>
    <tbody>
        <% for(Driver d : driverList){ %>
            <tr>
                
                <td><%= d.getName()%></td>
                <td><%= d.getDriver_id()%></td>
                <td><%= d.getPhone() %></td>
                <td><%= d.getEmail()%></td>
                 <td><%= d.getAddress()%></td>
                <td><%= d.getCity()%></td>
                <td><%= d.getGender()%></td>
                <td><%= d.getQualification()%></td>
                 <td><%= d.getExperience()%></td>
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