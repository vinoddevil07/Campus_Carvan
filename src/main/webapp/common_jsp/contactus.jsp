<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONTACT US</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html" %>
</head>
<body>
<%
	String message = (String)request.getAttribute("msg");
	%>

<div class="container-fluid bg-info" align="center"> <h2> Campus Carvan</h2> </div>




<%@include file="/common/common_header.html" %>




	<div class="container-fluid bg-primary">
		<h1 style="text-align: center" class="text-warning">
			<i class="fas fa-users"></i> Contact Us <i
				class="fas fa-users"></i>
		</h1>
	</div>


	<div class="row" style="color: blue">
		<div class="col-4">
			
		</div>
		<div class="col-4" >

			<form method="post" action="/CampusCarvan/ContactUs"  novalidate class="needs-validation">
				<div class="form-floating mb-3">

					<input type="text" name="name" class="form-control"
						placeholder="Enter The Place" required="required"> <label
						for="id" class="form-label"> Name </label>
																	<div class="invalid-feedback"> Invalid Username</div>
						
				</div>

				<div class=" form-floating mb-3">
					<input type="email" name="email" class="form-control"
						placeholder="Enter Email" required="required"> <label
						for="id" class="form-label"> E-mail</label>
					<div class="invalid-feedback">Invalid  Email</div>
						
				</div>

				<div class="form-floating mb-3">
					<input type="number" name="number" class="form-control"
						placeholder="Enter The Question" required="required">
					<label for="id" class="form-label"> Phone  </label>
							
					
				</div>
				<div class="form-floating mb-3">
					<textarea name="textarea" rows="5" cols="40" class="form-control"
						placeholder="Enter The Question" required="required"></textarea>
					<label for="id" class="form-label"> Query  </label>
					</div>
				

			<div class="text-center">
			
			<button type="submit" class="btn btn-primary" style="margin-right: 20px"> Submit  </button>
			<button type="reset" class="btn btn-primary" style="margin-right: 20px"> Reset  </button>
				
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

		</div>

		<div class="col-4">
			

		</div>


	</div>





		<%@include file="/common/common_footer.html" %>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
			<script src="/CampusCarvan/common/validation.js"></script>
		

</body>
</html>