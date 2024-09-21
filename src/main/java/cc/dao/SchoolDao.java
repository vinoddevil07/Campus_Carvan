package cc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cc.beans.Booking;
import cc.beans.Message;
import cc.beans.School;
import cc.beans.School_Vehicle_booking;
import cc.dbinfo.DBConnection;
import cc.schools.School_Vehicle_Booking;

public class SchoolDao {

	// viewProfile

	public School viewProfile(String school_id) {

		Connection con = DBConnection.openConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectQuery = "select * from schools where school_id=?";
		School s = null;

		try {
			ps = con.prepareStatement(selectQuery);
			ps.setString(1, school_id);
			System.out.println(ps);
			rs = ps.executeQuery(); // execute the query
			rs.next(); // Put the curser on Specfied Row

			// admin_id, admin_pass, name, email, phone

			String name = rs.getString("name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			String pass = rs.getString("password");
			s = new School(); // setting values in admin objects
			s.setEmail(email);// Order is not Important
			s.setName(name);
			s.setPhone(phone);
			s.setPassword(pass);

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
		return s;// returning School class object
	}

	public int addSchool(School s) {
		Connection con = DBConnection.openConnection();
		String insertQuery = "insert into schools(  school_id, password, name, email, phone, address, founder, board, city, date)values(?,?,?,?,?,?,?,?,?,?)";

		int status = 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(insertQuery); /// passes Query to mySQL -> compiler compile the query and
			// store the complied query into buffer and give refernece to ps

			ps.setString(1, s.getSchool_id());
			ps.setString(2, s.getPassword());
			ps.setString(3, s.getName());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getPhone());
			ps.setString(6, s.getAddress());
			ps.setString(7, s.getFounder());
			ps.setString(8, s.getBoard());
			ps.setString(9, s.getCity());
			ps.setDate(10, s.getDate());

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
				status=0;

			}

		}
		return status;

	}

	public boolean login(String id, String pass) {

		Connection con = DBConnection.openConnection();
		String selectQuery = "select * from schools  where school_id=? and password=?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			ps.setString(1, id);
			ps.setString(2, pass);

			System.out.println(ps);

			rs = ps.executeQuery();

			if (rs.next() == true)
				return true;
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return false;
	}

	public int editProfile(School s) {
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		// admin_id, admin_pass, name, email, phone,address
		String updateQuery = "update schools set name=?, email=?, phone=?,address=? where school_id=?";
		int status = 0;
		try {

			ps = con.prepareStatement(updateQuery);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPhone());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getSchool_id());
			
			System.out.println(ps);
			status = ps.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return status;

	}

	public int compose(Message m) {
		Connection con = DBConnection.openConnection();
		//sender_id, receiver_id, subject, message_text, date
		String insertQuery = "insert into message(sender_id, receiver_id, subject, message_text, date)values(?,?,?,?,?)";

		int status = 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(insertQuery); /// passes Query to mySQL -> compiler compile the query and
			// store the complied query into buffer and give refernece to ps

			ps.setString(1, m.getSender_id());
			ps.setString(2, m.getReceiver_id());
			ps.setString(3, m.getSubject());
			ps.setString(4,m.getMessage_text());
			ps.setDate(5,(Date) m.getDate() );
			
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
				status=0;

			}

		}
		return status;

	}
	public ArrayList<Message> viewinbox(String rid)

	{

		ArrayList<Message> messageList = new ArrayList<>();
		Message msg = null;

		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from message where receiver_id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			ps.setString(1, rid);
			rs = ps.executeQuery();
			while (rs.next()) {
				//message_id, sender_id, receiver_id, subject, message_text, date

				String senderid = rs.getString("sender_id");
				String receiverid = rs.getString("receiver_id");

				String subject = rs.getString("subject");

				String message = rs.getString("message_text");

				

				Date date = rs.getDate("date");

				msg = new Message(senderid, receiverid, subject, message, date); // object creation using fetched record
				messageList.add(msg); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return messageList ;

		
		
	}

	public int schoolBooking(School_Vehicle_booking b) {
	    Connection con = null;
	    PreparedStatement ps = null;
	    int status = 0;
	    
	    try {
	        con = DBConnection.openConnection();
	        
	        String insertQuery = "insert into school_vehicle_booking(school_id, vehicle_type, charge, no_of_students) values(?,?,?,?)";
	        
	        ps = con.prepareStatement(insertQuery); 
	        ps.setString(1, b.getSchool_id());
	        ps.setString(2, b.getVehicle_type());
	        ps.setString(3, b.getCharge());
	        ps.setString(4, b.getNo_of_students());
	        
	        status = ps.executeUpdate();
	        
	      
	        if(status > 0) {
	            System.out.println("successful");
	        } 
	        else {
	            System.out.println("failed");
	        }
	        
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } finally {
	        try {
	            if (ps != null) ps.close();
	            if (con != null) con.close();
	        } catch (SQLException se) {
	            se.printStackTrace();
	        }
	    }
	    return status;
	}
	public ArrayList<School_Vehicle_booking> confirmschoolbooking()

	{

		ArrayList<School_Vehicle_booking> confirmbookingList = new ArrayList<>();

		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from school_vehicle_booking where booking_status is not null ";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {

				String dname = rs.getString("driver_id");
				String number = rs.getString("vehicle_number");
				String no_of_kids = rs.getString("no_of_students");
									
				String vtype = rs.getString("vehicle_type");
				String charge = rs.getString("charge");

			
				
			
				
				School_Vehicle_booking svb = new School_Vehicle_booking();
				svb.setDriver_id(dname);
				svb.setVehicle_number(number);
				svb.setNo_of_students(no_of_kids);
				svb.setVehicle_type(vtype);
				svb.setCharge(charge);
				
                     
                     confirmbookingList.add(svb); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return confirmbookingList;
}

}
	

