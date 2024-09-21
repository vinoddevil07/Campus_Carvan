package cc.admin_servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.dao.AdminDao;
import cc.utils.UserMessages;




/**
 * Servlet implementation class Admin_Login
 */
@WebServlet("/Admin_Login")
public class Admin_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Admin_Login() {
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

		String id = request.getParameter("email");
		String pass = request.getParameter("password");
		
		
		
		

		System.out.println("user name is: " + id + "password is: " + pass);
		
		
		
		AdminDao dao = new AdminDao();
		
	boolean status =dao.login(id,pass);
		

		if (status==true) {
			
			HttpSession hs = request.getSession(); 
			// Creating new Session
			// String sessionId= hs.getId();
			// System.out.println("Session id is:" + sessionId);
			// Binding admin user in Session
            hs.setAttribute("sessionKey", id);
			hs.setAttribute("role", "admin");
			response.sendRedirect("/CampusCarvan/admin/admin_home.jsp"); // it is used to navigate the broswer on another url(page)			
			} 
		
		else {			
            request.setAttribute("msg", UserMessages.LOGIN_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/admin_login.jsp"); // ONLY TAKE RELATIVE PATH
			rd.forward(request, response);
		}

	}

}
