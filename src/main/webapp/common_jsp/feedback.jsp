<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Give Us Your Valuable Feedback</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v6.2.0/css/all.css">
<%@include file="/common/common_css.html"%>

<style>
.star-rating {
	display: flex;
	justify-content: center;
	font-size: 2rem;
	text-align: center;
	margin: 1rem 0;
}

.star-rating .star {
	cursor: pointer;
	color: #ddd;
}

.star-rating .star.active {
	color: #f78c30;
}
</style>


</head>
<body>
	<%
	String message = (String)request.getAttribute("msg");
	%>


	<%@include file="/common/common_header.html"%>



	<div class="row">

		<div class="col-4"></div>

		<div class="col-4">

			<h2 class="text-danger" align="center">Share Your Feedback</h2>

			<form method="post" action="/CampusCarvan/userFeedBack"
				style="text-align: center;">


				<div class="form-floating mb-3">

					<input type="text" name="name" class="form-control"
						placeholder="Enter The Place" required="required"> <label
						for="id" class="form-label"> Name </label>
				</div>

				<div class=" form-floating mb-3">
					<input type="email" name="email" class="form-control"
						placeholder="Enter Email" required="required"> <label
						for="id" class="form-label"> E-mail</label>
				</div>


				<div class="form-floating mb-3">
					<textarea name="textarea" rows="5" cols="40" class="form-control"
						placeholder="Enter The Question" required="required"></textarea>
					<label for="id" class="form-label"> Query </label>
				</div>



				<div class="rating" align="center" >
					<strong>Rating:</strong> <input type="radio" id="rating-1"
						name="rating" value="1" required="required"> 1 <input
						type="radio" id="rating-2" name="rating" value="2"
						required="required"> 2 <input type="radio" id="rating-3"
						name="rating" value="3" required="required"> 3 <input
						type="radio" id="rating-4" name="rating" value="4"
						required="required"> 4 <input type="radio" id="rating-5"
						name="rating" value="5" required="required"> 5

				</div>
				<div class="text-center">

					<button type="submit" class="btn btn-primary"
						style="margin-right: 20px">Submit</button>

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

		<div class="col-4"></div>


	</div>


	<div>
		<%@include file="/common/common_footer.html"%>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


</body>

</html>