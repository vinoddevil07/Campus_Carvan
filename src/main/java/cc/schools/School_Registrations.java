package cc.schools;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.beans.School;

import cc.dao.SchoolDao;
import cc.utils.UserMessages;

/**
 * Servlet implementation class School_Registrations
 */
@WebServlet("/School_Registrations")
public class School_Registrations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public School_Registrations() {
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
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String address = request.getParameter("address");
		String founder = request.getParameter("founder");
		String board = request.getParameter("board");
		String city = request.getParameter("city");
		
		
		//Creating Bean Class Objects
		java.util.Date d = new java.util.Date();
		java.sql.Date todayDate = new java.sql.Date(d.getTime());
		School s = new School(id,password, name, email, number, address,founder, board,city, todayDate);
		  
		  // creating dao class object
		  
		  SchoolDao dao = new SchoolDao();
		  
		  int status = dao.addSchool(s); // calling dao class
		  
		  // method and passing bean class object
		  
		  if (status > 0) {
		  
			  request.setAttribute("msg", UserMessages.REGISTRATION_MESSAGE);
				RequestDispatcher rd = request.getRequestDispatcher("/school/school_registration.jsp"); // ONLY TAKE RELATIVE PATH
				rd.forward(request, response);
		  
		  }
		  else {
			  request.setAttribute("msg", UserMessages.USER_EXISTENCE);
				RequestDispatcher rd = request.getRequestDispatcher("/school/school_registration.jsp"); // ONLY TAKE RELATIVE PATH
				rd.forward(request, response);
			  
		  }
		 

		
		
		
	}

}
