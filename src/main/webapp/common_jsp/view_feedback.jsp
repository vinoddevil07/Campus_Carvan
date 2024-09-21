<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cc.dao.*, cc.beans.*, java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rating and Reviews</title>
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
    %>
    <%@include file="/common/common_css.html" %>
</head>
<body>
    <%@include file="/common/common_header.html" %>

    <div class="container mt-5">
        <h1 class="text-center text-danger mb-5">Rating And Reviews</h1>
        
        <div class="row row-cols-1 row-cols-md-3 g-4">
            <%
                UserDao dao = new UserDao();
                ArrayList<UserFeedback> feedbackList = dao.viewUserFeedbacks();
                
                for (UserFeedback f : feedbackList) {
            %>
            <div class="col">
                <div class="card h-100 shadow-sm">
                    <div class="card-body">
                        <h5 class="card-title text-primary"><%= f.getUser_id() %>, <%= f.getRole() %></h5>
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h6 class="card-text text-warning mb-0">Rating: <%= f.getRating() %></h6>
                            <span class="badge bg-secondary"><%= f.getDate() %></span>
                        </div>
                        <p class="card-text"><%= f.getFeedback_text() %></p>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div> <!-- row-close -->
    </div> <!-- container-close -->

    <%@include file="/common/common_footer.html" %>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
