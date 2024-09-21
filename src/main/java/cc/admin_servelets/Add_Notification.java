package cc.admin_servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.beans.Notification;
import cc.dao.AdminDao;
import cc.utils.UserMessages;

/**
 * Servlet implementation class Add_Notification
 */
@WebServlet("/Add_Notification")
public class Add_Notification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Notification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String detail = request.getParameter("notification");
		
		//Creating Bean Class Objects
				java.util.Date d = new java.util.Date();
				java.sql.Date todayDate = new java.sql.Date(d.getTime());
				Notification n = new Notification(detail , todayDate);
				//creating dao class object
				
				AdminDao dao = new AdminDao();
				int status  =dao.addNotice(n);   // calling dao class 
				         
				
				  
				  // method and passing bean class object
				  
				  if(status >0) {
					  

						request.setAttribute("msg", UserMessages.ADD_NOTICE);
						RequestDispatcher rd = request.getRequestDispatcher("/admin/notification.jsp"); // ONLY TAKE RELATIVE PATH
						rd.forward(request, response);
						
				  }
				  else {
					  
				  }
		
		
	}

}
