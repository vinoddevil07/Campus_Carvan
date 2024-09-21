package cc.parent;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.beans.Message;
import cc.dao.ParentDao;
import cc.utils.UserMessages;

/**
 * Servlet implementation class Parent_Compose
 */
@WebServlet("/Parent_Compose")
public class Parent_Compose extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Parent_Compose() {
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
		
		HttpSession session = request.getSession(false);

		String sender_id = (String)session.getAttribute("sessionKey");
		String revieverid = request.getParameter("recieverid");
		String subject = request.getParameter("subject");
		String message= request.getParameter("message");
		System.out.println(sender_id+"   "+revieverid+"    "+subject+"   "+message);
		
		  java.util.Date d = new java.util.Date(); 
		  java.sql.Date todayDate = new java.sql.Date(d.getTime()); 
		  Message m = new Message(sender_id,revieverid,subject,message,todayDate); 
		  ParentDao dao = new ParentDao(); 
		  int status = dao.compose(m); 
		  if(status>0) {
			  request.setAttribute("msg", UserMessages.MSG_SEND);
				RequestDispatcher rd = request.getRequestDispatcher("/parent/parent_compose.jsp"); // ONLY TAKE RELATIVE PATH
				rd.forward(request, response);
				}
		 
	}

}
