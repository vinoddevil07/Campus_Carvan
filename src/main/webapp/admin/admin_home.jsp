<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminHome</title>

<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>

<%@include file="/common/common_css.html" %>
</head>
<body>
<div class="container-fluid bg-info" align="center"> <h2> Campus Carvan</h2> </div>

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
 
<%@include file="/admin/admin_header.html" %>

<div class="row">
    <div class="col-3">
        <img style="height: 350px; width: 100%; object-fit: cover;" alt="Schools" src="/CampusCarvan/images/schools.jpg">
        <button type="button" class="btn btn-dark w-100 mt-2">
            <a style="color: white; text-decoration: none;" href="/CampusCarvan/admin/view_school_details.jsp"><strong>School Details</strong></a>
        </button>
    </div>
    <div class="col-3">
        <img style="height: 350px; width: 100%; object-fit: cover;" alt="Placeholder" src="/CampusCarvan/images/pexels-vidalbalielojrfotografia-1682497.jpg">
        <button type="button" class="btn btn-dark w-100 mt-2">
            <a style="color: white; text-decoration: none;" href="/CampusCarvan/admin/view_parent_details.jsp"><strong>Parent Details</strong></a>
        </button>
    </div>
    <div class="col-3">
        <img style="height: 350px; width: 100%; object-fit: cover;" alt="Placeholder" src="/CampusCarvan/images/pexels-jeshoots-com-147458-13861.jpg">
        <button type="button" class="btn btn-dark w-100 mt-2">
            <a style="color: white; text-decoration: none;" href="/CampusCarvan/admin/view_drivers_details.jsp"><strong>Drivers Details</strong></a>
        </button>
    </div>
    <div class="col-3">
        <img style="height: 350px; width: 100%; object-fit: cover;" alt="Placeholder" src="/CampusCarvan/images/add driver.webp">
        <button type="button" class="btn btn-dark w-100 mt-2">
            <a style="color: white; text-decoration: none;" href="/CampusCarvan/admin/driver_details.jsp"><strong>Add Drivers</strong></a>
        </button>
    </div>
</div>

<div class="row mt-4" style="margin-top: 10%;margin-bottom: 10%">
    <div class="col-3">
        <img style="height: 350px; width: 100%; object-fit: cover;" alt="Placeholder" src="/CampusCarvan/images/vehicles.jpeg">
        <button type="button" class="btn btn-dark w-100 mt-2">
            <a style="color: white; text-decoration: none;" href="/CampusCarvan/admin/view_vehicles_details.jsp"><strong>Vehicle Details</strong></a>
        </button>
    </div>
    <div class="col-3">
        <img style="height: 350px; width: 100%; object-fit: cover;" alt="Placeholder" src="/CampusCarvan/images/confirmed1.jpg">
        <button type="button" class="btn btn-dark w-100 mt-2">
            <a style="color: white; text-decoration: none;" href="/CampusCarvan/admin/view_confirm_booking.jsp"><strong>School Confirm Booking</strong></a>
        </button>
    </div>
    <div class="col-3">
        <img style="height: 350px; width: 100%; object-fit: cover;" alt="Placeholder" src="/CampusCarvan/images/pending.jpg">
        <button type="button" class="btn btn-dark w-100 mt-2">
            <a style="color: white; text-decoration: none;" href="/CampusCarvan/admin/school_pending_booking.jsp"><strong>School Pending Booking</strong></a>
        </button>
    </div>
    <div class="col-3">
        <img style="height: 350px; width: 100%; object-fit: cover;" alt="Placeholder" src="/CampusCarvan/images/contact-us.jpg">
        <button type="button" class="btn btn-dark w-100 mt-2">
            <a style="color: white; text-decoration: none;" href="/CampusCarvan/admin/view_contacts.jsp"><strong>Contact</strong></a>
        </button>
    </div>
</div>




<%@include file="/admin/admin_footer.html" %>
<%}
	else{
		request.setAttribute("msg", "Apna Page Login Kro");
		RequestDispatcher rd = request.getRequestDispatcher("/admin/admin_login.jsp");
		rd.forward(request, response);
		
	}

} %>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>