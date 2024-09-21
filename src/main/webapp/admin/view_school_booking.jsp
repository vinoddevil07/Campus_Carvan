<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, cc.beans.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Booking</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html"%>

</head>
<body>
	<%@include file="/admin/admin_header.html"%>

	<h1 style="color: red; text-align: center;">Confirm Booking</h1>
	<%
SchoolDao dao=new SchoolDao();
ArrayList<School_Vehicle_booking>confirmList=dao.confirmschoolbooking();

%>


	<div style="margin: 3%">

		<table class="table table-striped" style="border: 1px solid black;">
			<thead class="bg-warning">
				<tr>
				<th scope="col">Driver Name</th>
					<th scope="col">Number of Kids</th>
					
					<th scope="col">Vehicle Number</th>
					<th scope="col">Vehicle Type</th>
					<th scope="col">Charge</th>

				</tr>
			</thead>
			<tbody>
				<% for(School_Vehicle_booking b : confirmList){ %>
				<tr>
					<td><%= b.getDriver_id()%></td>
					<td><%= b.getNo_of_students()%></td>
					<td><%= b.getVehicle_number()%></td>
					<td><%= b.getVehicle_type()%></td>
					<td><%= b.getCharge()%></td>

				</tr>
				<% } %>
			</tbody>
		</table>

		<%@include file="/common/common_footer.html"%>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>