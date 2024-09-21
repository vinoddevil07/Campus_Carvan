

package cc.parent;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cc.beans.Contacts;
import cc.beans.Parent;
import cc.dao.ParentDao;
import cc.dao.UserDao;
import cc.utils.UserMessages;

/**
 * Servlet implementation class Parent_Registration
 */
@WebServlet("/Parent_Registration")
public class Parent_Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Parent_Registration() {
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
		
		String  id = request.getParameter("id");
		String pass = request.getParameter("password");

		String name = request.getParameter("name");

		String num = request.getParameter("number");

		String em = request.getParameter("email");

		String ci = request.getParameter("city");
		String gen = request.getParameter("gender");

		String tex = request.getParameter("textarea");

      
		//Creating Bean Class Objects
				java.util.Date d = new java.util.Date();
				java.sql.Date todayDate = new java.sql.Date(d.getTime());
				Parent p = new Parent( id, pass , name , num , em, ci, gen, tex, todayDate);
				
				//creating dao class object
				
				ParentDao dao = new ParentDao();
				
				
				  int status  = dao.addParent(p);   // calling dao class 
				         
				
				  
				  // method and passing bean class object
				  
				  if(status >0) {
					  

					  request.setAttribute("msg", UserMessages.REGISTRATION_MESSAGE);
						RequestDispatcher rd = request.getRequestDispatcher("/parent/parent_registration.jsp"); // ONLY TAKE RELATIVE PATH
						rd.forward(request, response);
						
				  }

      
		
		
		
		
		
	}

}
