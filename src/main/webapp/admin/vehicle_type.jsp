<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>vehiclestypes</title>


<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>



<%@include file="/common/common_css.html"%>
</head>
<body>


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




	<%
	String message = (String) request.getAttribute("msg");
	%>
	<%@include file="/admin/admin_header.html"%>
	<div class="container-fluid ">

		<h2 class="text-danger" style="text-align: center;">Vehicles
			Types Details</h2>

	</div>

	<div class="row" style="">
		<div class="col-4  "></div>
		<div class="col-4  " style="margin-top: 3%">
			<!--  gx-0 used for remove margin -->
			<form method="post" action="/CampusCarvan/Vehicle_Type" novalidate
				class="needs-validation">
				<div class="form-floating mb-3">
					<input type="text" name="types" class="form-control"
						id="floatingInput" placeholder="name@example.com"
						required="required"> <label for="floatingInput"
						style="color: red">Vehicles Types</label>
					<div class="invalid-feedback">Invalid Vehicle Types</div>
				</div>
				<div class="form-floating mb-3">
				
				<input type="number" name="hourly" class="form-control"
						id="floatingInput" placeholder="name@example.com"
						required="required"> <label for="floatingInput"
						style="color: red">Hourly Charges (Rs)</label>
					<div class="invalid-feedback">Enter Valid Charges</div>
					
				</div>
				<div class="form-floating mb-3">
				
				<input type="number" name="montly" class="form-control"
						id="floatingInput" placeholder="name@example.com"
						required="required"> <label for="floatingInput"
						style="color: red">Montly Charges (Rs)</label>
					<div class="invalid-feedback">Enter Valid Charges</div>
					
				</div>
				
				<!-- Submit button -->
				<div class="text-center">
					<button type="submit" class="btn btn-primary btn-block mb-4">Sign
						in</button>
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


			<div class="col-4 "></div>
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

	<script src="/CampusCarvan/common/validation.js"></script>

</body>
</html>