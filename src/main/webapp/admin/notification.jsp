<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Parent Registration</title>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html"%>
</head>
<body>




	<%@include file="/common/common_header.html"%>


	<div class="container-fluid">

		<h2 class="text-danger" style="text-align: center;">Notification</h2>

	</div>


	<%
	String message = (String) request.getAttribute("msg");
	%>

	<div class="row" style="">
		<div class="col-4  "></div>
		<div class="col-4  " style="margin-top: 3%">
			<!--  gx-0 used for remove margin -->
			<form method="post" action="/CampusCarvan/Add_Notification">


				<div class="form-floating mb-3">
					<textarea name="notification" rows="5" cols="40"
						class="form-control" placeholder="Enter The Question"
						required="required"></textarea>
					<label for="floatingPassword" style="color: red">Notification</label>
				</div>



				<div class="text-center mb-3" style="margin-top: 1%">
					<button type="submit" class="btn btn-primary "
						style="color: white; margin-right: 2%">Submit</button>
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

			<div class="col-4"></div>
		</div>
	</div>

	<%@include file="/common/common_footer.html"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>