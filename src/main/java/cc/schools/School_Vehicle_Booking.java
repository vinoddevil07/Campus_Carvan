package cc.schools;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.beans.Booking;
import cc.beans.School_Vehicle_booking;
import cc.dao.ParentDao;
import cc.dao.SchoolDao;

/**
 * Servlet implementation class School_Vehicle_Booking
 */
@WebServlet("/School_Vehicle_Booking")
public class School_Vehicle_Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public School_Vehicle_Booking() {
        super();
        // TODO Auto-generated constructor stub
    }

	public School_Vehicle_Booking(String school_id, String vehicle_type, String charge, String numberOfKids) {
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
		HttpSession session = request.getSession(false);

		String school_id = (String)session.getAttribute("sessionKey");
        String vehicle_type = request.getParameter("vtype");
		
		String charge = request.getParameter("charge");
		
		String numberOfKids= request.getParameter("number");
	
		
		System.out.println(school_id+vehicle_type+charge+numberOfKids);
		
		  School_Vehicle_booking b = new School_Vehicle_booking(school_id,vehicle_type,charge,numberOfKids);
		  
		  
		  SchoolDao dao = new SchoolDao();
		  
		  dao.schoolBooking(b);
		 
		
	}

}
