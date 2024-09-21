package cc.common_servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cc.beans.Feedback;
import cc.dao.UserDao;
import cc.utils.UserMessages;

/**
 * Servlet implementation class userFeedBack
 */
@WebServlet("/userFeedBack")
public class userFeedBack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userFeedBack() {
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

		String name = request.getParameter("name");
		String email = request.getParameter("email");

		String query = request.getParameter("textarea");

		String rating = request.getParameter("rating");
		

		/*System.out.println(" user name is: " + name);
		System.out.println(" email  is: " + email);

		System.out.println(" number is: " + query);
		System.out.println(" rating is: " + r);*/

		// Creating Bean Class Objects
		java.util.Date d = new java.util.Date();
		java.sql.Date todayDate = new java.sql.Date(d.getTime());
		Feedback f = new Feedback(name, email, query, rating, todayDate);

		// creating dao class object

		UserDao dao = new UserDao();

		int status = dao.addFeedback(f); // calling dao class

		// method and passing bean class object

		if (status > 0) {
			request.setAttribute("msg", UserMessages.FEEDBACK_MESSAGE);
			RequestDispatcher rd = request.getRequestDispatcher("/common_jsp/feedback.jsp"); // ONLY TAKE RELATIVE PATH
			rd.forward(request, response);
		}

	}

}
