<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, cc.beans.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>School Pending Booking</title>
<%
    response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@include file="/common/common_css.html"%>

</head>
<body>
	<%@include file="/admin/admin_header.html"%>

	<h1 style="color: red; text-align: center;">School Pending Booking</h1>
	
		<% String message = (String)request.getAttribute("msg"); %>
	
	<%
AdminDao dao=new AdminDao();
ArrayList<School_Vehicle_booking>pendingList=dao.viewSchoolBooking();

ArrayList<Driver>driverList=dao.viewdrivername();

ArrayList<Add_vehicles>vehiclenumberList=dao.viewvehiclenumber();

%>



<form action="/CampusCarvan/Confirm_School_Booking" method="post">
<div style="margin: 3%">

<table class="table table-striped" style="border: 1px solid black;">
    <thead class="bg-warning">
        <tr>
            <th scope="col">Checkbox</th>
            <th scope="col">School Name</th>
            
              <th scope="col">Vehicle Type</th>
               <th scope="col">Charges</th>
            <th scope="col">Number of Kids</th>
           
          
        </tr>
    </thead>
    <tbody>
        <% for(School_Vehicle_booking b : pendingList)
        { %>
            <tr>
                <td><input type="checkbox" name="chkbooking" value="<%=b.getBooking_id()%>"></td>
                <td><%= b.getSchool().getName()%></td>
                
                  <td><%= b.getVehicle_type()%></td>
                  <td><%= b.getCharge() %></td>
                <td><%= b.getNo_of_students()%></td>
                
            </tr>
        <% } %>
    </tbody>
</table>
</div>
	<div class="row">
	
	<div class="col-1 "></div>
	<div class="col-5 ">
	        
	

	<div class="form-floating mb-3">
					<select class="form-select" id="floatingSelect"
						aria-label="Floating label select example" name="driver" required="required">
						<option  selected>Drivers name</option>
						<% for(Driver d : driverList){ %>
						<option  value="<%=d.getName()%>"><%=d.getName() %>||<%=d.getDriver_id() %></option>
						<% } %>

					</select> <label for="floatingSelect" style="color: red"><strong>Select Driver</strong></label>
				</div>
	        
	
</div>

	<div class="col-5 ">
	
	<div class="form-floating mb-3">
					<select class="form-select" id="floatingSelect"
						aria-label="Floating label select example" name="number" required="required">
						<option  selected>Number</option>
	       <% for(Add_vehicles d : vehiclenumberList){ %>
						
						<option value="<%=d.getNumber()%>"><%=d.getNumber() %></option>
						<% } %>

					</select> <label for="floatingSelect" style="color: red"><strong>Vehicle number</strong></label>
				</div></div>
	<div class="col-1 "></div>

</div>
<br>
<br>
<div class="row">
<div class="col-3"></div>
<div class="col-6">
<div class="form-floating mb-3">
					<textarea name="answer" rows="5" cols="40" class="form-control"
						placeholder="Enter The Answer" required="required"></textarea>
					<label for="id" class="form-label" style="color: red"><strong>Answer</strong>  </label>
				</div>
				
				</div>
			<div class="text-center">
			
			<button type="submit" class="btn btn-primary" style="margin-right: 20px"> Submit  </button>
				
			</div>
			
				<div class="col-3"></div>
				
		</div>		
			</form>	
			 <%  if(message!=null){ %>
 
 <div class="alert alert-danger alert-dismissible fade show" role="alert" align="left">
  <strong><%=message %></strong> 
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

<%} %>
	<%@include file="/common/common_footer.html"%>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>