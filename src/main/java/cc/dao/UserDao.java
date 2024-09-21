package cc.dao;

import cc.beans.Contacts;
import java.sql.*;
import java.util.ArrayList;

import cc.beans.Feedback;
import cc.beans.UserFeedback;
import cc.beans.Vehicle_type;
import cc.dbinfo.DBConnection;

public class UserDao {
   // View Feedback
	
	// START view Feedback METHOD

			public ArrayList<Feedback> viewFeedbacks()

			{
				
				ArrayList<Feedback>feedbackList= new ArrayList<>();
				Feedback feedback=null;
				
				
				
				Connection con = DBConnection.openConnection();

				String selectQuery = "select  * from feedbacks where ratings=5 order by date desc limit 9 ";
				PreparedStatement ps = null;
				ResultSet rs = null;

				try {
					ps = con.prepareStatement(selectQuery);
					rs = ps.executeQuery();
					while(rs.next()) {
						//name, email, remarks, ratings, date
						
						String name = rs.getString("name");
						String email = rs.getString("email");

						String remarks= rs.getString("remarks");

						String rating = rs.getString("ratings");

						Date date = rs.getDate("date");
						
						feedback= new Feedback(name, email, remarks,rating, date); // object creation using fetched record
						feedbackList.add(feedback); // adding object into ArrayList

					}
					
					
					
				} catch (SQLException se) {
					se.printStackTrace();
		            
				}

				return feedbackList;

			}

			// END view Feedbacks METHOD
	
	
	
	
	
	
	
	public int addContact(Contacts c) {

		String name = c.getUser_name();
		String email = c.getUser_email();
		String phone = c.getUser_phone();
		String text = c.getUser_question();

		/*
		 * System.out.println("FROM DAO CLASS OUTPUT:"); System.out.println(name+" "
		 * +email+" " +phone+" " +text);
		 */

		Connection con = DBConnection.openConnection();
		String insertQuery = "insert into contacts(user_name, user_email, user_phone, user_question, date)values(?,?,?,?,?)";

		int status = 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(insertQuery); /// passes Query to mySQL -> compiler compile the query and
			// store the complied query into buffer and give refernece to ps

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);

			ps.setString(4, text);
			ps.setDate(5, c.getDate());
			System.out.println(ps);
			status = ps.executeUpdate();

		}

		catch (SQLException se) {
			se.printStackTrace();
		}

		finally {

			try {
				if (ps != null)
					;
				ps.close();
				if (con != null)
					con.close();

			}

			catch (SQLException se) {
				se.printStackTrace();

			}

		}
		return status;
	}

	public int addFeedback(Feedback f) {
		/*
		 * String name = f.getName(); String email = f.getEmail(); String number =
		 * f.getRemarks(); int r = f.getRating();
		 * 
		 * 
		 * System.out.println("FROM DAO CLASS OUTPUT:");
		 * 
		 * System.out.println(name +" " + email +" " + number +" " + r);
		 */

		Connection con = DBConnection.openConnection();
		String insertQuery = "insert into feedbacks( name, email, remarks, ratings, date) values(?,?,?,?,?)";
		int status = 0;
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, f.getName());
			ps.setString(2, f.getEmail());
			ps.setString(3, f.getRemarks());
			ps.setString(4, f.getRating());
			ps.setDate(5, f.getDate());

			status = ps.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {

			try {
				if (ps != null)
					;
				ps.close();
				if (con != null)
					con.close();

			}

			catch (SQLException se) {
				se.printStackTrace();

			}

		}
		return status;
	}
	
	public ArrayList<Vehicle_type> viewVehicle()

	{
		
		ArrayList<Vehicle_type>viewVehicle= new ArrayList<>();
		Vehicle_type view=null;
		
		
		
		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from vehicles_type";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			
				while(rs.next()) {
					//types, hourly_charge, montly_charge
					
					String types = rs.getString("types");
					String hourly = rs.getString("hourly_charge");
					String monthly =rs.getString("montly_charge");

    
					
					view= new Vehicle_type(types,hourly, monthly); // object creation using fetched record
					viewVehicle.add(view); // adding object into ArrayList

				}
				
				
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
			

			return viewVehicle;

	}

	public int addUserFeedback(UserFeedback f) {
		Connection con = DBConnection.openConnection();
		//user_id, feedback_text, role, rating, date
		String insertQuery = "insert into user_feedback(user_id, feedback_text, role, rating, date) values(?,?,?,?,?)";
		int status = 0;
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, f.getUser_id());
			ps.setString(2, f.getRole());
			ps.setString(3, f.getFeedback_text());
			ps.setString(4, f.getRating());
			ps.setDate(5,  (Date) f.getDate());
			
			
			

			status = ps.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {

			try {
				if (ps != null)
					;
				ps.close();
				if (con != null)
					con.close();

			}

			catch (SQLException se) {
				se.printStackTrace();

			}

		}
		
	
		
	return status;


}
	// START view Feedback METHOD

				public ArrayList<UserFeedback> viewUserFeedbacks()

				{
					
					ArrayList<UserFeedback>feedbackList= new ArrayList<>();
					UserFeedback feedback=null;
					
					
					
					Connection con = DBConnection.openConnection();

					String selectQuery = "select  * from user_feedback";
					PreparedStatement ps = null;
					ResultSet rs = null;

					try {
						ps = con.prepareStatement(selectQuery);
						rs = ps.executeQuery();
						while(rs.next()) {
					//user_id, feedback_text, role, rating, date

							
							String id = rs.getString("user_id");
							String feedback_text = rs.getString("feedback_text");

							String role= rs.getString("role");

							String rating = rs.getString("rating");

							Date date = rs.getDate("date");
							
							feedback= new UserFeedback(id,feedback_text, role,rating, date); // object creation using fetched record
							feedbackList.add(feedback); // adding object into ArrayList

						}
						
						
						
					} catch (SQLException se) {
						se.printStackTrace();
			            
					}

					return feedbackList;

				}

				// END view Feedbacks METHOD
				
				
				public ArrayList<Vehicle_type> viewcharges(String vt)

				{

					ArrayList<Vehicle_type> viewcharges = new ArrayList<>();
					Vehicle_type vts = null;

					Connection con = DBConnection.openConnection();
                     //types, hourly_charge, montly_charge
					String selectQuery = "select  * from vehicles_type where types=?";
					PreparedStatement ps = null;
					ResultSet rs = null;

					try {
						ps = con.prepareStatement(selectQuery);
						ps.setString(1, vt);
						rs = ps.executeQuery();
						while (rs.next()) {

							String hc = rs.getString("hourly_charge");
							String mc = rs.getString("montly_charge");

							vts = new Vehicle_type(); // object creation using fetched record
							vts.setHourly_charge(hc);
							vts.setMontly_charge(mc);
							viewcharges.add(vts); // adding object into ArrayList

						}

					} catch (SQLException se) {
						se.printStackTrace();

					}

					return viewcharges;

				}
				
		
}
	