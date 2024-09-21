<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="cc.dao.*, java.util.*, cc.beans.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>AddVehicles</title>

    <%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
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
    <%
    String vehicleType = request.getParameter("v_type");
    %>

    <%
    UserDao dao = new UserDao();
    ArrayList<Vehicle_type> viewcharge = dao.viewcharges(vehicleType);
    %>

    <%@include file="/parent/parent_header.html"%>

    <div class="container-fluid">

        <h2 class="text-danger" style="text-align: center;">Booking Details</h2>

    </div>

    <%
    String message = (String) request.getAttribute("msg");
    %>

    <div class="row" style="margin-left: 10%">
        <div class="col-md-8" style="margin-top: 3%">
            <form method="post" action="/CampusCarvan/parent/book_student_details.jsp">

                <% String h_charge=""; String m_charge=""; for (Vehicle_type vts : viewcharge) { h_charge=vts.getHourly_charge(); m_charge=vts.getMontly_charge(); } %>

                <div class="mb-3">
                    <label for="vehicleType" class="form-label"><strong>Vehicle Type</strong></label>
                    <input type="text" class="form-control" id="vehicleType" name="vtype" value="<%=vehicleType %>" readonly>
                </div>

                <div class="mb-3">
                    <label class="form-label"><strong>Hourly Charge</strong></label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="charge" id="hourlyCharge" value="<%=h_charge %>" checked>
                        <label class="form-check-label" for="hourlyCharge">
                            <%=h_charge %> RS
                        </label>
                    </div>
                </div>

                <div class="mb-3">
                    <label class="form-label"><strong>Monthly Charge</strong></label>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="charge" id="monthlyCharge" value="<%=m_charge %>">
                        <label class="form-check-label" for="monthlyCharge">
                            <%=m_charge %> RS
                        </label>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="kids" class="form-label"><strong>Number Of Kids</strong></label>
                    <select class="form-select" id="kids" name="kids" required>
                        <option value="" selected disabled>Select</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary"><strong>Submit</strong></button>
                </div>

            </form>

            <%
            if (message != null) {
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong><%=message%></strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
            }
            %>

        </div>

        <!-- QR Code Column -->
        <div class="col-md-4" style="margin-top: 3%">
            <div class="mb-3 text-center">
                <img src="/CampusCarvan/images/q.r.jpg" alt="QR Code" class="img-fluid" style="height: 80%; width: 80%">
            </div>
        </div>
    </div>

    <%@include file="/common/common_footer.html"%>

    <%
    } else {
        request.setAttribute("msg", "Apna Page Login Kro");
        RequestDispatcher rd = request.getRequestDispatcher("/parent/parent_login.jsp");
        rd.forward(request, response);
    }
    }
    %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
