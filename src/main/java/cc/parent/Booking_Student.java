package cc.parent;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.beans.Booking;
import cc.dao.ParentDao;

/**
 * Servlet implementation class Booking_Student
 */
@WebServlet("/Booking_Student")
public class Booking_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Booking_Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		HttpSession session = request.getSession(false);

		String parent_id = (String)session.getAttribute("sessionKey");
		String vehicle_type = request.getParameter("vtype");
		
		String charge = request.getParameter("charge");
		
		
		int number = Integer.parseInt(request.getParameter("no"));

		System.out.println("total kids" + number);
		String[] name = new String[number];
		String[] standard = new String[number];
		String[] age = new String[number];
		String[] school = new String[number];

		for (int i = 0; i < number; i++) {
			name[i] = request.getParameter("name" + (i + 1));
			standard[i] = request.getParameter("standard" + (i + 1));
			age[i] = request.getParameter("age" + (i + 1));
			school[i]= request.getParameter("school" +(i+1));

			System.out.println(school[i]);
		
			 

		}
		
		  Booking b = new Booking(name, age, standard,school, vehicle_type, parent_id,charge ); 
		  
		  ParentDao dao = new ParentDao(); 
		  
		  dao.vehicleBooking(b);

	}
}
