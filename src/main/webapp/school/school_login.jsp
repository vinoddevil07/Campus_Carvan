<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>School_login</title>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html"%>
</head>
<body>

	<%
	String message = (String) request.getAttribute("msg");
	%>




	<%@include file="/common/common_header.html"%>


	<div class="container-fluid ">

		<h2 class="text-danger" style="text-align: center;">School Login
			Form</h2>

	</div>

	<div class="row" style="">
		<div class="col-4  "></div>
		<div class="col-4  " style="margin-top: 3%">

			<!--  gx-0 used for remove margin -->

			<form method="post" action="/CampusCarvan/School_Login" novalidate
				class="needs-validation">

				<div class="form-floating mb-3">
					<input type="text" name="name" class="form-control"
						id="floatingInput" placeholder="name@example.com"
						required="required"> <label for="floatingInput"
						style="color: red">Email address</label>

					<div class="invalid-feedback">ID shi se Daalo</div>


				</div>
				<div class="form-floating">
					<input type="password" name="password" class="form-control"
						id="floatingPassword" placeholder="Password" required="required">
					<label for="floatingPassword" style="color: red">Password</label>
					<div class="invalid-feedback">Strong password banao</div>

				</div>

				<!-- 2 column grid layout for inline styling -->
				<div class="row mb-4">
					<div class="col d-flex justify-content-center">
						<!-- Checkbox -->
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value=""
								id="form2Example31" checked /> <label class="form-check-label"
								for="form2Example31"> Remember me </label>
						</div>
					</div>

					<div class="col">
						<!-- Simple link -->
						<a href="#!">Forgot password?</a>
					</div>
				</div>

				<!-- Submit button -->
				<div class="text-center">
					<button type="submit" class="btn btn-primary btn-block mb-4">Sign
						in</button>
				</div>
				<div class="text-center">
				<p>
					Not a member? <a
						href="/CampusCarvan/school/school_registration.jsp">Register</a>
				</p>
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

	<script src="/CampusCarvan/common/validation.js"></script>
</body>
</html>