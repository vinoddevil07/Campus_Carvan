package cc.admin_servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.dao.AdminDao;
import cc.utils.UserMessages;

/**
 * Servlet implementation class Confirm_School_Booking
 */
@WebServlet("/Confirm_School_Booking")
public class Confirm_School_Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirm_School_Booking() {
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
		String[] booking_ids = request.getParameterValues("chkbooking");
		String driver_name = request.getParameter("driver");
		String vehiclenumber = request.getParameter("number");
		String message = request.getParameter("answer");

		
		System.out.println( booking_ids);
		
		
		  AdminDao dao = new AdminDao();
	int status=	  dao.confirmschoolbooking(booking_ids, driver_name, vehiclenumber, message);
	if(status>0) {
    	request.setAttribute("msg", UserMessages.Confirm_Booking);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/school_pending_booking.jsp"); // ONLY TAKE RELATIVE PATH
		rd.forward(request, response);  
	
	
	}
	}
}