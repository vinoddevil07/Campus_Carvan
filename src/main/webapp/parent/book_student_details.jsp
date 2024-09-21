<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, java.util.*, cc.beans.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>


<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1
response.setHeader("Pragma", "no-cache"); //HTTP 1.0
response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>


<%@include file="/common/common_css.html"%>
</head>



<%
String admin_id = (String) session.getAttribute("sessionKey");
String role = (String) session.getAttribute("role");
System.out.print(session.getId());
if (admin_id == null || session.isNew()) {
	request.setAttribute("msg", "Unauthorised Access, please login Krlo");
	RequestDispatcher rd = request.getRequestDispatcher("/parent/parent_login.jsp");
	rd.forward(request, response);
} else {
	if (role.equals("parent")) {
%>



<body>	
<%@include file="/parent/parent_header.html"%>


<form action="/CampusCarvan/Booking_Student" method="post">

 <% String vehicleType = request.getParameter("vtype");
       String Charge = request.getParameter("charge");
       String kids = request.getParameter("kids");
       int numberOfKids = Integer.parseInt(kids); // Parse 'kids' parameter into an integer


    %>
<div align="center" style="margin: 10%">
	
	
   

    <h4>Vehicle Type: <%= vehicleType %></h4>
     <h4>Charge: <%= Charge %></h4> 
     
 
    <h4>Number of Kids: <%=kids %></h4>
	<br>
	
	<div class="container-fluid ">
	<h3 style="text-align: center" class="text-danger">
			 Fill the kids details
		</h3>
	</div><br>

	
	<input type="text" name="no" value="<%=numberOfKids%>">
		<input type="text" name="charge" value="<%=Charge %>">
		<input type="text" name="vtype" value="<%=vehicleType%>">
	
	
	
	<% for (int i = 1; i <= numberOfKids; i++) {
    %>
    
    <div class="form-floating mb-3">
					<input type="text" name="name<%=i%>" class="form-control"
						id="floatingPassword" placeholder="Password" required="required"> <label
						for="floatingPassword" style="color: red">Student Name</label>
				</div>
    
    <div class="form-floating mb-3">
					<input type="number" name="standard<%=i%>" class="form-control"
						id="floatingPassword" placeholder="Password" required="required"> <label
						for="floatingPassword" style="color: red">Standard</label>
				</div>
    
    
         <div class="form-floating mb-3">
					<input type="number" name="age<%=i%>" class="form-control"
						id="floatingPassword" placeholder="Password" required="required"> <label
						for="floatingPassword" style="color: red">Age</label>
				</div>
				  <div class="form-floating mb-3">
					<input type="text" name="school<%=i%>" class="form-control"
						id="floatingPassword" placeholder="Password" required="required"> <label
						for="floatingPassword" style="color: red">School Name</label>
				</div>
				<hr>
				<br>
				
    <%     
       }
    %>
	
	<div class="text-center">
					<button type="submit" class="btn btn-primary btn-block mb-4">Submit</button>
				</div>
	
	</div>
	
	</form>
	<%@include file="/common/common_footer.html"%>

	<%
	} else {
	request.setAttribute("msg", "Apna Page Login Kro");
	RequestDispatcher rd = request.getRequestDispatcher("/parent/parent_login.jsp");
	rd.forward(request, response);

	}
	}
	%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>