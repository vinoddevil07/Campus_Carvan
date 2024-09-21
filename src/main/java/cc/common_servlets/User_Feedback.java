package cc.common_servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;

import cc.beans.Contacts;
import cc.beans.UserFeedback;
import cc.dao.UserDao;

/**
 * Servlet implementation class User_Feedback
 */
@WebServlet("/User_Feedback")
public class User_Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User_Feedback() {
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

		String id = (String) session.getAttribute("sessionKey");
		String role = (String) session.getAttribute("role");
		
		String feedback = request.getParameter("feedback");
		String rating = request.getParameter("rating");

		java.util.Date d = new java.util.Date();
		java.sql.Date todayDate = new java.sql.Date(d.getTime());
		UserFeedback f = new UserFeedback(id, role, feedback, rating, todayDate);

		//System.out.println("id is: "+id + "role is: "+role+ " "+feedback+" "+ rating+ " "+todayDate);
		 
		
		UserDao dao = new UserDao();
		int status = dao.addUserFeedback(f);
		if(status > 0 || role.equals("parent") ){
		
			response.sendRedirect("/CampusCarvan/parent/parent_home.jsp"); 
		
            
        } else {
			
			response.sendRedirect("/CampusCarvan/school/school_home.jsp"); 
            
        	
        }

	}
}
