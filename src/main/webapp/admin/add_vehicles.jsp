<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, java.util.*, cc.beans.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddVehicles</title>


<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>


<%@include file="/common/common_css.html"%>
</head>



<%
String admin_id=(String)session.getAttribute("sessionKey");
String role = (String)session.getAttribute("role");
System.out.print(session.getId());
if(admin_id==null|| session.isNew())
{
	request.setAttribute("msg", "Unauthorised Access, please login Krlo");
	RequestDispatcher rd = request.getRequestDispatcher("/admin/admin_login.jsp");
	rd.forward(request, response);
}
else{	if(role.equals("admin")){

	

%>



<body>
	<%AdminDao dao = new AdminDao();
ArrayList<Vehicle_type> vlist= dao.vehicleTypes();
%>







	<%@include file="/admin/admin_header.html"%>



	<div class="container-fluid">

		<h2 class="text-danger" style="text-align: center;">Add Vehicles
			Details</h2>

	</div>


	<%
	String message = (String) request.getAttribute("msg");
	%>

	<div class="row" style="">
		<div class="col-2  "></div>
		<div class="col-8  " style="margin-top: 3%">
			<!--  gx-0 used for remove margin -->




			<form method="post" action="/CampusCarvan/Add_Vehicles">


				<div class="form-floating mb-3">
					<select class="form-select" id="floatingSelect"
						aria-label="Floating label select example" name="vtype"
						required="required">
						<option value="vtype">Select Type</option>
						<% for (Vehicle_type vts : vlist) { %>
						<option value="<%= vts.getTypes()%>"><%= vts.getTypes() %></option>
						<% }%>
					</select> <label for="floatingSelect" style="color: red">Select
						Vehicle Types</label>
				</div>

				<div class="form-floating mb-3">
					<input type="text" name="number" class="form-control"
						id="floatingInput" placeholder="name@example.com"
						required="required"> <label for="floatingInput"
						style="color: red">Number</label>
				</div>
				<div class="form-floating mb-3">
					<input type="text" name="color" class="form-control"
						id="floatingInput" placeholder="name@example.com"
						required="required"> <label for="floatingInput"
						style="color: red">Color</label>
				</div>


				<div class="form-floating mb-3">

					<div class="" align="left">
						<label style="margin-right: 3%; color: red">Fuel Type</label> <input
							type="radio" name="fuel" value="Diesel" required="required">
						Diesel <input type="radio" name="fuel" value="Petrol"
							required="required">Petrol <input type="radio"
							name="fuel" value="Electric" required="required">Electric
					</div>
				</div>


				<div class="form-floating mb-3">
					<input type="text" name="name" class="form-control"
						id="floatingPassword" placeholder="Password" required="required">
					<label for="floatingPassword" style="color: red">Name</label>
				</div>





				<div class="form-floating mb-3">
					<textarea name="description" rows="5" cols="40"
						class="form-control" placeholder="Enter The Question"
						required="required"></textarea>
					<label for="floatingPassword" style="color: red">Description</label>
				</div>


				<div class="text-center mb-3" style="margin-top: 1%">
					<button type="submit" class="btn btn-primary "
						style="color: white; margin-right: 2%">Submit</button>
					<button type="reset" class="btn btn-primary " style="color: white">Reset</button>
				</div>



			</form>
			<%
			if (message != null) {
			%>

			<div class="alert alert-danger alert-dismissible fade show"
				role="alert">
				<strong><%=message%></strong>
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>

			<%
			}
			%>


			<div class="col-2"></div>
		</div>
	</div>

	<%@include file="/common/common_footer.html"%>
	
	
	<%}
else{
	request.setAttribute("msg", "Apna Page Login Kro");
	RequestDispatcher rd = request.getRequestDispatcher("/admin/admin_login.jsp");
	rd.forward(request, response);
	
}} %>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>