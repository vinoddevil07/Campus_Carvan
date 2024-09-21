<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>parentHome</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html" %>
</head>
<body>
<div class="container-fluid bg-info" align="center"> <h2> Campus Carvan</h2> </div>




<%-- <%@include file="/common/common_header.html" %>
 --%>


<%
String parent_id=(String)session.getAttribute("sessionKey");
String role = (String)session.getAttribute("role");
System.out.print(session.getId());
if(parent_id==null|| session.isNew())
{
	request.setAttribute("msg", "Unauthorised Access, Please login First!");
	RequestDispatcher rd = request.getRequestDispatcher("/parent/parent_login.jsp");
	rd.forward(request, response);
}
else{ if(role.equals("parent")){
	

%>

<%@include file="/parent/parent_header.html" %>



<div class="row" style="margin-bottom: 10%;margin: 5%;margin-left: 5%">

    <div class="col-3">
        <img style="height: 350px; width: 100%; object-fit: cover;" alt="Placeholder" src="/CampusCarvan/images/booking.png">
        <button type="button" class="btn btn-dark w-100 mt-2">
            <a style="color: white; text-decoration: none;" href="/CampusCarvan/parent/view_vehicles.jsp"><strong>Booking</strong></a>
        </button>
    </div>


    <div class="col-3">
        <img style="height: 350px; width: 100%; object-fit: cover;" alt="Schools" src="/CampusCarvan/images/confirmed1.jpg">
        <button type="button" class="btn btn-dark w-100 mt-2">
            <a style="color: white; text-decoration: none;" href="/CampusCarvan/parent/confirm_booking.jsp"><strong>Confired Booking</strong></a>
        </button>
    </div>

   
        
</div>



<%@include file="/common/common_css.html" %>
<%@include file="/common/common_footer.html" %>


<%}
else{
	request.setAttribute("msg", "Apna Page Login Kro");
	RequestDispatcher rd = request.getRequestDispatcher("/parent/parent_login.jsp");
	rd.forward(request, response);
	
}} %>


<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>