package cc.vehicles;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.beans.Add_vehicles;

import cc.dao.AdminDao;
import cc.utils.UserMessages;

/**
 * Servlet implementation class Add_Vehicles
 */
@WebServlet("/Add_Vehicles")
public class Add_Vehicles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Vehicles() {
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
		String type = request.getParameter("vtype");
		String number = request.getParameter("number");
		String color = request.getParameter("color");
		String fuel = request.getParameter("fuel");
		String name = request.getParameter("name");
		String discription = request.getParameter("description");
		
		Add_vehicles av = new Add_vehicles(type,number,color,fuel,name,discription);
		
		AdminDao dao = new AdminDao();
		int status = dao.addVehicles(av);
		if(status>0) {
			request.setAttribute("msg", UserMessages.ADD_VEHICLES);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/add_vehicles.jsp"); // ONLY TAKE RELATIVE PATH
			rd.forward(request, response);
		}
		else {
			request.setAttribute("msg", UserMessages.INVALID_NUMBER);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/add_vehicles.jsp"); // ONLY TAKE RELATIVE PATH
			rd.forward(request, response);
			
		}
		
		
		
		
		
		
	}

}
