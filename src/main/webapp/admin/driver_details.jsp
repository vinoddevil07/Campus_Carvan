<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
else{
	
	if(role.equals("admin")){

%>


	<%@include file="/admin/admin_header.html"%>


	<div class="container-fluid bg-info">

		<h2 class="text-light" style="text-align: center;">Driver Details</h2>

	</div>


	<%
	String message = (String) request.getAttribute("msg");
	%>

	<div class="row" style="">
		<div class="col-2  "></div>
		<div class="col-8  " style="margin-top: 3%">
			<!--  gx-0 used for remove margin -->




			<form method="post" action="/CampusCarvan/Driver_Details">

				<div class="form-floating mb-3">
					<input type="text" name="id" class="form-control"
						id="floatingInput" placeholder="name@example.com"
						required="required"> <label for="floatingInput"
						style="color: red">Driver_ID</label>
				</div>
				<div class="form-floating mb-3">
					<input type="password" name="password" class="form-control"
						id="floatingInput" placeholder="name@example.com"
						required="required"> <label for="floatingInput"
						style="color: red">Password</label>
				</div>


				<div class="form-floating mb-3">
					<input type="text" name="name" class="form-control"
						id="floatingPassword" placeholder="Password" required="required">
					<label for="floatingPassword" style="color: red">Name</label>
				</div>

				<div class="form-floating mb-3">
					<input type="email" name="email" class="form-control"
						id="floatingPassword" placeholder="Password" required="required">
					<label for="floatingPassword" style="color: red">Email</label>
				</div>



				<div class="form-floating mb-3">
					<input type="number" name="number" class="form-control"
						id="floatingPassword" placeholder="Password" required="required">
					<label for="floatingPassword" style="color: red">Phone</label>
				</div>


				<div class="form-floating mb-3">
					<select class="form-select" id="floatingSelect"
						aria-label="Floating label select example" name="city"
						required="required">
						<option selected>Select City</option>
						<option value="lucknow">Lucknow</option>
						<option value="kanpur">Kanpur</option>
						<option value="gonda">Gonda</option>
						<option value="gorakpur">Gorakpur</option>
						<option value="barabanki">Barabanki</option>
						<option value="khalilabad">Khalilabad</option>

					</select> <label for="floatingSelect" style="color: red">City</label>
				</div>

				<div class="form-floating mb-3">
					<textarea name="address" rows="5" cols="40" class="form-control"
						placeholder="Enter The Question" required="required"></textarea>
					<label for="floatingPassword" style="color: red">Address</label>
				</div>


				 
                <div class="form-floating mb-3">
					<input type="number" name="experience" class="form-control"
						id="floatingPassword" placeholder="Password" required="required">
					<label for="floatingPassword" style="color: red">Experience</label>
				</div>



				<div class="form-floating mb-3">

					<div class="" align="left">
						<label style="margin-right: 3%; color: red">Gender</label> <input
							type="radio" name="gender" value="male" required="required">
						Male <input type="radio" name="gender" value="female"
							required="required"> Female
					</div>
				</div>


				<div class="form-floating mb-3">
					<textarea name="qualification" rows="5" cols="40"
						class="form-control" placeholder="Enter The Question"
						required="required"></textarea>
					<label for="floatingPassword" style="color: red">Qualification</label>
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
				<div class="col-2"></div>
		</div>
	</div>

	<%@include file="/common/common_footer.html"%>

			<%}}
	else{
		request.setAttribute("msg", "Apna Page Login Kro");
		RequestDispatcher rd = request.getRequestDispatcher("/admin/admin_login.jsp");
		rd.forward(request, response);
		
	}} %>
			
			





		
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>