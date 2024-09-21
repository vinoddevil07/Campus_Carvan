<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, cc.beans.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vehicles Details</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html"%>

</head>
<body>
	<%@include file="/admin/admin_header.html"%>

	<h1 style="color: red; text-align: center;">Vehicles Details</h1>
	<%
AdminDao dao=new AdminDao();
ArrayList<Add_vehicles>vehiclesList=dao.viewvehicles();
//types, number, color, fuel_type, name, description

%>

<form action="" method="post">
<div style="margin: 3%">

<table class="table table-striped" style="border: 1px solid black;">
    <thead class="bg-warning">
        <tr>
            <th scope="col">Vehicles Types</th>
            <th scope="col">Vehicles Number</th>
            <th scope="col">Color</th>
            <th scope="col">Fuel_type</th>
            <th scope="col">Vehicles Name</th>
            <th scope="col">Description</th>
                  
        </tr>
    </thead>
    <tbody>
        <% for(Add_vehicles av : vehiclesList){ %>
            <tr>
                
                <td><%= av.getTypes()%></td>
                <td><%= av.getNumber()%></td>
                <td><%= av.getColor() %></td>
                <td><%= av.getFuel_type()%></td>
                 <td><%= av.getName()%></td>
                <td><%= av.getDescription()%></td>
                
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