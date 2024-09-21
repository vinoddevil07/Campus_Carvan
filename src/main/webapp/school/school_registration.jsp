<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">

<title>Schools Registration</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html"%>
</head>
<body>




	<%@include file="/common/common_header.html"%>


	<div class="container-fluid bg-info">

		<h2 class="text-light" style="text-align: center;">School
			Registrations</h2>
	</div>



	<%
	String message = (String) request.getAttribute("msg");
	%>

	<div class="row" style="">
		<div class="col-2  "></div>
		<div class="col-8  " style="margin-top: 3%">
		
		
			<!--  gx-0 used for remove margin -->




			<form method="post" action="/CampusCarvan/School_Registrations">

				<div class="form-floating mb-3">
					<input type="text" name="id" class="form-control"
						id="floatingInput" placeholder="name@example.com"
						required="required"> <label for="floatingInput"
						style="color: red">SCHOOL_ID</label>
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
					<textarea name="address" rows="5" cols="40" class="form-control"
						placeholder="Enter The Question" required="required"></textarea>
					<label for="floatingPassword" style="color: red">Address</label>
				</div>

				<div class="form-floating mb-3">
					<input type="text" name="founder" class="form-control"
						id="floatingInput" placeholder="name@example.com"
						required="required"> <label for="floatingInput"
						style="color: red">FOUNDER </label>
				</div>

				<div class="form-floating mb-3">
					<input type="text" name="board" class="form-control"
						id="floatingInput" placeholder="name@example.com"
						required="required"> <label for="floatingInput"
						style="color: red">BOARD </label>
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>