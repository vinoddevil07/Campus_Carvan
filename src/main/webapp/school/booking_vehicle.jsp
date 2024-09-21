<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, java.util.*, cc.beans.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookingVehicles</title>

<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>

<%@include file="/common/common_css.html"%>
</head>

<%
String admin_id = (String) session.getAttribute("sessionKey");
String role = (String) session.getAttribute("role");
System.out.print(session.getId());
if (admin_id == null || session.isNew()) {
	request.setAttribute("msg", "Unauthorised Access, please login Krlo");
	RequestDispatcher rd = request.getRequestDispatcher("/school/school_login.jsp");
	rd.forward(request, response);
} else {
	if (role.equals("school")) {
%>

<body>
	<%
	String vehicleType = request.getParameter("v_type");
	%>

	<%
	UserDao dao = new UserDao();
	ArrayList<Vehicle_type> viewcharge = dao.viewcharges(vehicleType);
	%>

	<%@include file="/school/school_header.html"%>
     
	
		<h2 class="text-danger" style="text-align: center;">Booking Details</h2>
<div class="container-fluid" style="margin: 5%;margin-left: 15%" >
		<%
		String message = (String) request.getAttribute("msg");
		%>

		<div class="row" style="margin-top: 3%">
			<div class="col-md-6">
				<form method="post" action="/CampusCarvan/School_Vehicle_Booking">
					<%
					String h_charge="";
					String m_charge="";
					for (Vehicle_type vts : viewcharge) {
						h_charge=vts.getHourly_charge();
						m_charge=vts.getMontly_charge();
					}
					%>
					<div class="mb-3">
						<label for="vehicleType" class="form-label">Vehicle Type</label>
						<input type="text" class="form-control" id="vehicleType" name="vtype" value="<%=vehicleType %>" readonly>
					</div>

					<div class="mb-3">
						<label class="form-label">Hourly Charge</label>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="charge" id="hourlyCharge" value="<%=h_charge %>" checked>
							<label class="form-check-label" for="hourlyCharge">
								<%=h_charge %> RS
							</label>
						</div>
					</div>

					<div class="mb-3">
						<label class="form-label">Monthly Charge</label>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="charge" id="monthlyCharge" value="<%=m_charge %>">
							<label class="form-check-label" for="monthlyCharge">
								<%=m_charge %> RS
							</label>
						</div>
					</div>

					<div class="mb-3">
						<label for="numberOfKids" class="form-label">Number of kids</label>
						<input type="number" class="form-control" id="number" name="number" value="number">
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>
			</div>

			<div class="col-md-6">
				<img style="height: 80%;width: 50%" alt="" src="/CampusCarvan/images/q.r.jpg" class="img-fluid">
			</div>
		</div>

		<%
		if (message != null) {
		%>
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
			<strong><%=message%></strong>
			<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
		</div>
		<%
		}
		%>
	</div>

	<%@include file="/common/common_footer.html"%>

	<%
	} else {
	request.setAttribute("msg", "Apna Page Login Kro");
	RequestDispatcher rd = request.getRequestDispatcher("/school/school_login.jsp");
	rd.forward(request, response);
	}
	}
	%>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
