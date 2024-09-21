package cc.vehicles;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cc.beans.Vehicle_type;
import cc.dao.AdminDao;
import cc.dao.ParentDao;
import cc.utils.UserMessages;

/**
 * Servlet implementation class Vehicle_Type
 */
@WebServlet("/Vehicle_Type")
public class Vehicle_Type extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Vehicle_Type() {
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
		String types = request.getParameter("types");
		String hourly = request.getParameter("hourly");
		String montly = request.getParameter("montly");


		Vehicle_type vt = new Vehicle_type(types, hourly, montly);

		AdminDao dao = new AdminDao();
		int status = dao.addTypes(vt);
		if (status > 0) {

			request.setAttribute("msg", UserMessages.ADD_TYPE);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/vehicle_type.jsp"); // ONLY TAKE RELATIVE PATH
			rd.forward(request, response);

		} else {
			request.setAttribute("msg", UserMessages.INVALID_MESSAGE);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/vehicle_type.jsp"); // ONLY TAKE RELATIVE PATH
			rd.forward(request, response);

		}

	}

}
