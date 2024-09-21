<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, java.util.*, cc.beans.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewVehicles</title>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html"%>
</head>
<body>
	<div class="container-fluid bg-info" align="center">
		<h2>Campus Carvan</h2>
	</div>
	<%@include file="/parent/parent_header.html"%>
	<h1 align="center">Vehicles</h1>

	<%
	String[] vehicles = { "schoolbus.webp", "car.jpeg", "erickshow.jpg", "van.avif" };
	int i = 0;
	UserDao dao = new UserDao();// user class object
	ArrayList<Vehicle_type> viewVehicle = dao.viewVehicle();
	%>
	<form>
	<div class="row">
		<%
		for (Vehicle_type vt : viewVehicle) {
		%>
		
	
		<div class="col-4  mx-2">
			<div class="card">
				<div class="card-body">
					<img src="/CampusCarvan/images/<%=vehicles[i]%>"
						class="card-img-top" alt="..." style="width: 25%; height: 40%">

					<h2 class="card-title" style="text-align: center">
						<%=vt.getTypes()%>
					</h2>
					<p class="card-text" >
						Hourly Charges:<%=vt.getHourly_charge()%></p>
					<p class="card-text">
						Montly Charges:<%=vt.getMontly_charge()%></p>
                    <div>

			<button type="button" class="btn btn-primary"
				style="width: 10%%; height: 85%; margin-bottom:" >
				<a style="color: white" href="/CampusCarvan/parent/booking_vehicle.jsp?v_type=<%=vt.getTypes() %> ">  <strong>BOOKING</strong></a>
				</button>

		</div>
				</div>
			</div>

		</div>
		<%
		i++;
		}
		%>
	</div>
</form>
	<!-- row-close -->


	<%@include file="/admin/admin_footer.html"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>