package cc.schools;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.beans.Parent;
import cc.beans.School;
import cc.dao.ParentDao;
import cc.dao.SchoolDao;

/**
 * Servlet implementation class School_EditProfile
 */
@WebServlet("/School_EditProfile")
public class School_EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public School_EditProfile() {
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
	    
	    String school_id =(String)hs.getAttribute("sessionKey");
	    String name = request.getParameter("name");
	    String email=request.getParameter("email");
	    String phone=request.getParameter("number");
	    String address=request.getParameter("address");
	    
	    System.out.println(address);
	    
	    School s = new School();
	    s.setName(name); 
	    s.setEmail(email);
	    s.setPhone(phone);
	    s.setAddress(address);
	    s.setSchool_id(school_id);
	    
	    
	    SchoolDao dao = new SchoolDao();
	    int status = dao.editProfile(s); // Passing Parent Object for Updation on the basis of object
	    if(status>0) {
	    	response.sendRedirect("/CampusCarvan/school/school_profile.jsp");
	    	
	    }
	    
	}
	}

