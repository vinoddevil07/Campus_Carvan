package cc.parent;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.beans.Admin;
import cc.beans.Parent;
import cc.dao.AdminDao;
import cc.dao.ParentDao;

/**
 * Servlet implementation class Parent_EditProfile
 */
@WebServlet("/Parent_EditProfile")
public class Parent_EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Parent_EditProfile() {
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
		HttpSession hs = request.getSession(false);// will give the reference of Existing Sessions
	    
	    String parent_id =(String)hs.getAttribute("sessionKey");
	    String name = request.getParameter("name");
	    String email=request.getParameter("email");
	    String phone=request.getParameter("number");
	    Parent p = new Parent();
	    p.setName(name);
	    p.setEmail(email);
	    p.setPhone(phone);
	    p.setParent_id(parent_id);
	    
	    ParentDao dao = new ParentDao();
	    int status = dao.editProfile(p); // Passing Parent Object for Updation on the basis of object
	    if(status>0) {
	    	response.sendRedirect("/CampusCarvan/parent/parent_profile.jsp");
	    	
	    }
	    
	}

}
