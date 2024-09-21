<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.* , cc.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SchoolEditProfile</title>
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




	<%-- <%@include file="/common/common_header.html" %>
 --%>


	<%
	String school_id = (String) session.getAttribute("sessionKey");
	String role = (String) session.getAttribute("role");
	System.out.print(session.getId());
	if (school_id == null || session.isNew()) {
		request.setAttribute("msg", "Unauthorised Access, Please login First!");
		RequestDispatcher rd = request.getRequestDispatcher("/school/school_login.jsp");
		rd.forward(request, response);
	} else {

		if (role.equals("school")) {
	%>

	<%@include file="/school/school_header.html"%>


	<div class="container-fluid bg-success">
		<h1>
			Hello
			<%=school_id%>
			You are
			<%=role%></h1>

		<%
		SchoolDao dao = new SchoolDao();
		School s = dao.viewProfile(school_id); // passing session id value
		%>



		<!-- 
		Edit PROFILE CODE START HERE
 -->

		<form method="post" action="/CampusCarvan/School_EditProfile">
			<section class="vh-100" style="background-color: #f4f5f7;">
				<div class="container py-5 h-100">
					<div
						class="row d-flex justify-content-center align-items-center h-100">
						<div class="col col-lg-6 mb-4 mb-lg-0">
							<div class="card mb-3" style="border-radius: .5rem;">
								<div class="row g-0">
									<div class="col-md-4 gradient-custom text-center "
										style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
										<img src="/CampusCarvan/images/cclogo.png" alt="Avatar"
											class="img-fluid my-5" style="width: 80px;" /> Name: <input
											type="text" name="name" class="form-control"
											value="<%=s.getName()%>">


										<p>
											You are
											<%=role%></p>
										<a href="/CampusCarvan/school/school_edit_profile.jsp"><i
											class="far fa-edit mb-5"></i></a>
									</div>
									<div class="col-md-8">
										<div class="card-body p-4">
											<h6>Information</h6>
											<hr class="mt-0 mb-4">
											<div class="row pt-1">
												<div class="col-6 mb-3">
													<h6>Email</h6>
													Email: <input type="email" name="email"
														class="form-control" value="<%=s.getEmail()%>">


												</div>
												<div class="col-6 mb-3">
													<h6>Phone</h6>
													Phone: <input type="number" name="number"
														class="form-control" value="<%=s.getPhone()%>">



												</div>
												<div class="col-6 mb-3">
													<h6>Address</h6>
													<textarea name="address" rows="4" cols="10"
														class="form-control"> <%=s.getAddress()%></textarea>



												</div>
												<button class="btn btn-success">Edit Profile</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</form>

		<!-- // PROFILE CODES END HERE -->



	</div>



	<%@include file="/common/common_css.html"%>
	<%@include file="/common/common_footer.html"%>
	<%
	}

	else {
	request.setAttribute("msg", "Apna Page Login Kro");
	RequestDispatcher rd = request.getRequestDispatcher("/school/school_login.jsp");
	rd.forward(request, response);

	}
	}
	%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>