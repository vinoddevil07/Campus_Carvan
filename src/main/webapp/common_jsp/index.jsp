<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<%@include file="/common/common_css.html"%>

</head>
<body style="overflow-x: hidden">



	<%@include file="/common/common_header.html"%>
	<%@include file="/common_jsp/view_notification.jsp"%>
	
	<div class="row " style="background-color: #FFCB3F">


		<div class="col-6" style="margin-top: 5%">
			<h2 align="center">
				<b>Campus Carvan: Your Trusted School Transportation Solution</b>
			</h2>
			<div style="margin-top: 4%; text-align: center">
				<h6>
					<b><p>Ensure safe, reliable school transportation with
							Campus Carvan. Tailored for</p>
						<p>campus needs, our experienced drivers and innovative
							technology</p>
						<p>guarantee punctual service, every time. Say goodbye to
							worries</p>
						<p>and hello to hassle-free journeys. Partner with</p> us today!</b>
				</h6>
			</div>

		</div>
		<div class="col-6">

			<img alt="" src="/CampusCarvan/images/cc photo.jpg">
		</div>





	</div>
	<div style="margin-top: 5%">
		<%@include file="/common_jsp/faq's.jsp"%>
	</div>

	<div style="margin-top: 5%">
		<%@include file="/common/common_footer.html"%>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
