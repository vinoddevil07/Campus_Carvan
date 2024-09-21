package cc.schools;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import cc.dao.SchoolDao;
import cc.utils.UserMessages;

/**
 * Servlet implementation class School_Login
 */
@WebServlet("/School_Login")
public class School_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public School_Login() {
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
		String  id = request.getParameter("name");
		String pass = request.getParameter("password");
		
	    SchoolDao  dao = new SchoolDao();
		boolean status = dao.login(id, pass);
		if(status==true) {
			HttpSession hs = request.getSession(); // Creating new Session
			//String sessionId= hs.getId();
			//System.out.println("Session id is:" + sessionId);
			hs.setAttribute("sessionKey", id); // Binding School user in Session
			hs.setAttribute("role", "school");
			System.out.println("user name is: " + id + "password is: " + pass);
			response.sendRedirect("/CampusCarvan/school/school_home.jsp");
            // it is used to navigate the broswer on another url(page)
			
			
		}
		else {
			request.setAttribute("msg", UserMessages.LOGIN_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/school/school_login.jsp");  // ONLY TAKE RELATIVE PATH
			rd.forward(request, response);
		}
	}

}
