package cc.drivers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cc.beans.Driver;
import cc.dao.AdminDao;
import cc.utils.UserMessages;

/**
 * Servlet implementation class Driver_Details
 */
@WebServlet("/Driver_Details")
public class Driver_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Driver_Details() {
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
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("number");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String experience = request.getParameter("experience");
		String gender = request.getParameter("gender");
		String qualification = request.getParameter("qualification");

		System.out.println(id + name + password + email + phone + city + address + experience + gender + qualification);

		
		  // Creating Bean Class Objects java.util.Date d = new java.util.Date();
		  /*java.sql.Date todayDate = new java.sql.Date(.getTime());*/
		  
		  
		  Driver d = new Driver(id,password, name, email, phone, city, address,experience, gender,qualification);
		  
		  // creating dao class object
		  
		  AdminDao dao = new AdminDao();
		  
		  int status = dao.addDriver(d); // calling dao class
		  
		  // method and passing bean class object
		  
		  if (status > 0) {
			  request.setAttribute("msg", UserMessages.ADD_DRIVERS);
				RequestDispatcher rd = request.getRequestDispatcher("/admin/driver_details.jsp"); // ONLY TAKE RELATIVE PATH
				rd.forward(request, response);
		 
		  
		  }
		  else {
			  request.setAttribute("msg", UserMessages.ID_EXISTS);
				RequestDispatcher rd = request.getRequestDispatcher("/admin/driver_details.jsp"); // ONLY TAKE RELATIVE PATH
				rd.forward(request, response);
			  
		  }
		 

	}

}
