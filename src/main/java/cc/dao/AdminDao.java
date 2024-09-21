package cc.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import cc.beans.Add_vehicles;
import cc.beans.Admin;
import cc.beans.Booking;
import cc.beans.Contacts;
import cc.beans.Driver;
import cc.beans.Feedback;
import cc.beans.Message;
import cc.beans.Notification;
import cc.beans.Parent;
import cc.beans.School;
import cc.beans.School_Vehicle_booking;
import cc.beans.Vehicle_type;
import cc.dbinfo.DBConnection;

public class AdminDao {

	// viewProfile

	public Admin viewProfile(String id) {

		Connection con = DBConnection.openConnection();

		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectQuery = "select * from admin where admin_id=?";
		Admin a = null;

		try {
			ps = con.prepareStatement(selectQuery);
			ps.setString(1, id);
			System.out.println(ps);
			rs = ps.executeQuery(); // execute the query
			rs.next(); // Put the curser on Specfied Row

			// admin_id, admin_pass, name, email, phone

			String name = rs.getString("name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			String pass = rs.getString("admin_pass");
			a = new Admin(); // setting values in admin objects
			a.setEmail(email);// Order is not Important
			a.setName(name);
			a.setPhone(phone);
			a.setAdmin_pass(pass);

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
		return a;// returning Admin class object
	}

	// START viewCONTACTS METHOD

	public ArrayList<Contacts> viewContacts()

	{

		ArrayList<Contacts> contactList = new ArrayList<>();
		Contacts contact = null;

		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from contacts order by date desc";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				// user_name, user_email, user_phone, user_question, date

				String name = rs.getString("user_name");
				String email = rs.getString("user_email");

				String phone = rs.getString("user_phone");

				String question = rs.getString("user_question");

				Date date = rs.getDate("date");

				contact = new Contacts(name, email, phone, question, date); // object creation using fetched record
				contactList.add(contact); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return contactList;

	}

	// END viewCONTACTS METHOD

	// START view Feedback METHOD

	public ArrayList<Feedback> viewFeedbacks()

	{

		ArrayList<Feedback> feedbackList = new ArrayList<>();
		Feedback feedback = null;

		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from feedbacks order by date desc";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				// name, email, remarks, ratings, date

				String name = rs.getString("name");
				String email = rs.getString("email");

				String remarks = rs.getString("remarks");

				String rating = rs.getString("ratings");

				Date date = rs.getDate("date");

				feedback = new Feedback(name, email, remarks, rating, date); // object creation using fetched record
				feedbackList.add(feedback); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return feedbackList;

	}

	// END view Feedbacks METHOD

	public boolean login(String user, String pass) {

		Connection con = DBConnection.openConnection();
		String selectQuery = "select * from admin where admin_id=? and admin_pass=?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			ps.setString(1, user);
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

	public int addDriver(Driver d) {

		Connection con = DBConnection.openConnection();
		String insertQuery = "insert into drivers(driver_id ,password, name, email, phone, city, address, experience, gender, qualification)values(?,?,?,?,?,?,?,?,?,?)";

		int status = 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(insertQuery); /// passes Query to mySQL -> compiler compile the query and
			// store the complied query into buffer and give refernece to ps

			ps.setString(1, d.getDriver_id());
			ps.setString(2, d.getPassword());
			ps.setString(3, d.getName());

			ps.setString(4, d.getEmail());
			ps.setString(5, d.getPhone());
			ps.setString(6, d.getCity());
			ps.setString(7, d.getAddress());
			ps.setString(8, d.getExperience());

			ps.setString(9, d.getGender());
			ps.setString(10, d.getQualification());

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

// Method of  Edit profile of admin 

	public int editProfile(Admin a) {

		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		// admin_id, admin_pass, name, email, phone
		String updateQuery = "update admin set name=?, email=?, phone=? where admin_id=?";
		int status = 0;
		try {

			ps = con.prepareStatement(updateQuery);
			ps.setString(1, a.getName());
			ps.setString(2, a.getEmail());
			ps.setString(3, a.getPhone());
			ps.setString(4, a.getAdmin_id());
			System.out.println(ps);
			status = ps.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return status;
	}

	public int addTypes(Vehicle_type vt) {
		Connection con = DBConnection.openConnection();
		String insertQuery = "insert into vehicles_type (types,hourly_charge,montly_charge)values(?,?,?)";

		int status = 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(insertQuery); /// passes Query to mySQL -> compiler compile the query and
			// store the complied query into buffer and give refernece to ps

			ps.setString(1, vt.getTypes());
			ps.setString(2, vt.getHourly_charge());
			ps.setString(3, vt.getMontly_charge());

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

	// START view Feedback METHOD

	public ArrayList<Vehicle_type> vehicleTypes()

	{

		ArrayList<Vehicle_type> vehicleTypes = new ArrayList<>();
		Vehicle_type vts = null;

		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from vehicles_type";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {

				String type = rs.getString("types");

				vts = new Vehicle_type(); // object creation using fetched record
				vts.setTypes(type);
				vehicleTypes.add(vts); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return vehicleTypes;

	}

	public int addVehicles(Add_vehicles av) {
		Connection con = DBConnection.openConnection();

		// types, number, color, fuel_type, name, description
		String insertQuery = "insert into vehicles(types, number, color, fuel_type, name, description)values(?,?,?,?,?,?)";

		int status = 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(insertQuery); /// passes Query to mySQL -> compiler compile the query and
			// store the complied query into buffer and give refernece to ps

			ps.setString(1, av.getTypes());
			ps.setString(2, av.getNumber());
			ps.setString(3, av.getColor());
			ps.setString(4, av.getFuel_type());
			ps.setString(5, av.getName());
			ps.setString(6, av.getDescription());

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

	public int addNotice(Notification n) {
		Connection con = DBConnection.openConnection();
		String insertQuery = "insert into notification(notice_content, date)values(?,?)";

		int status = 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(insertQuery); /// passes Query to mySQL -> compiler compile the query and
			// store the complied query into buffer and give refernece to ps

			ps.setString(1, n.getNotice_content());
			ps.setDate(2, n.getDate());

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

	// END view Feedbacks METHOD

	public ArrayList<Notification> viewNotice()

	{

		ArrayList<Notification> detailList = new ArrayList<>();
		Notification notice = null;

		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from notification order by date desc limit 1";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				// detail, date

				String detail = rs.getString("notice_content");

				Date date = rs.getDate("date");

				notice = new Notification(detail, date); // object creation using fetched record
				detailList.add(notice); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return detailList;

	}

	public int compose(Message m) {
		Connection con = DBConnection.openConnection();
		// sender_id, receiver_id, subject, message_text, date
		String insertQuery = "insert into message(sender_id, receiver_id, subject, message_text, date)values(?,?,?,?,?)";

		int status = 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(insertQuery); /// passes Query to mySQL -> compiler compile the query and
			// store the complied query into buffer and give refernece to ps

			ps.setString(1, m.getSender_id());
			ps.setString(2, m.getReceiver_id());
			ps.setString(3, m.getSubject());
			ps.setString(4, m.getMessage_text());
			ps.setDate(5, (Date) m.getDate());

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
				status = 0;

			}

		}
		return status;

	}

	public ArrayList<Message> viewinbox()

	{

		ArrayList<Message> messageList = new ArrayList<>();
		Message msg = null;

		Connection con = DBConnection.openConnection();

		String selectQuery = "SELECT * FROM message";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();

			while (rs.next()) {
				// message_id, sender_id, receiver_id, subject, message_text, date

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

		return messageList;

	}

	public ArrayList<Booking> pendingBooking()

	{

		ArrayList<Booking> pendingbooking = new ArrayList<>();

		Connection con = DBConnection.openConnection();

		String selectQuery = "select   p.name,p.parent_id,vb.kid_name,vb.vehicle_type, vb.school_name, vb.booking_id from  parent p ,vehicle_booking vb where  p.parent_id=vb.parent_id and vb.booking_status is null";

		PreparedStatement ps = null;
		ResultSet rs = null;
		Parent p = null;
		try {
			ps = con.prepareStatement(selectQuery);
			System.out.println(ps);
			rs = ps.executeQuery();
			while (rs.next()) {

				p = new Parent();

				String pname = rs.getString("name");
				String id = rs.getString("parent_id");

				p.setName(pname);
				p.setParent_id(id);

				String k_name = rs.getString("kid_name");
				String schoolname = rs.getString("school_name");
				String vehicletype = rs.getString("vehicle_type");
				Booking b = new Booking();

				b.setBooking_id(rs.getInt("booking_id"));
				b.setKidname(k_name);
				b.setSch(schoolname);
				b.setVehicle_type(vehicletype);

				b.setParent(p);// HAS A RELATIONSHIP

				pendingbooking.add(b);

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return pendingbooking;
	}

	public ArrayList<Driver> viewdrivername()

	{

		ArrayList<Driver> driverList = new ArrayList<>();

		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from drivers";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {

				String dname = rs.getString("name");
				String driverid = rs.getString("driver_id");
				Driver d = new Driver();
				d.setName(dname);
				d.setDriver_id(driverid);
				driverList.add(d); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return driverList;

	}

	public ArrayList<Add_vehicles> viewvehiclenumber()

	{

		ArrayList<Add_vehicles> vehiclenumberList = new ArrayList<>();

		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from vehicles";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {

				String vnumber = rs.getString("number");
				Add_vehicles av = new Add_vehicles();
				av.setNumber(vnumber);
				

				vehiclenumberList.add(av); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return vehiclenumberList;

	}

	public ArrayList<Booking> confirmBooking()

	{

		ArrayList<Booking> confirmbooking = new ArrayList<>();

		Connection con = DBConnection.openConnection();

		String selectQuery = "select   p.name,p.parent_id,vb.kid_name,vb.vehicle_type, vb.school_name, vb.booking_id from  parent p ,vehicle_booking vb where  p.parent_id=vb.parent_id and vb.booking_status is null";

		PreparedStatement ps = null;
		ResultSet rs = null;
		Parent p = null;
		try {
			ps = con.prepareStatement(selectQuery);
			System.out.println(ps);
			rs = ps.executeQuery();
			while (rs.next()) {

				p = new Parent();

				String pname = rs.getString("name");
				String id = rs.getString("parent_id");

				p.setName(pname);
				p.setParent_id(id);

				String k_name = rs.getString("kid_name");
				String schoolname = rs.getString("school_name");
				String vehicletype = rs.getString("vehicle_type");
				Booking b = new Booking();

				b.setBooking_id(rs.getInt("booking_id"));
				b.setKidname(k_name);
				b.setSch(schoolname);
				b.setVehicle_type(vehicletype);

				b.setParent(p);// HAS A RELATIONSHIP
				confirmbooking.add(b);
			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return confirmbooking;
	}

	
	


	public int confirmbooking(String[] booking_ids, String driver_name, String vehiclenumber, String message) {
        Connection con = DBConnection.openConnection();
        String updateQuery = "UPDATE vehicle_booking SET driver_id = ?, number = ?, answer = ?, booking_status='confirm' WHERE booking_id = ?";

        int status = 0;
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(updateQuery);
            for (String b : booking_ids) {
                ps.setString(1, driver_name);                     
                ps.setString(2, vehiclenumber);        
                ps.setString(3, message);     
                ps.setString(4,b);           

                ps.addBatch();
            }

            
            int[] rows = ps.executeBatch();

			for (int i = 0; i < rows.length; i++)

			{

				if (rows[i] < 0)
					break;
				else
					status = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			try {
				if (ps != null) {
					ps.close(); 
				}
				if (con != null) {
					con.close(); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return status;
    }
	
	public ArrayList<School_Vehicle_booking> viewSchoolBooking()

	{

		ArrayList<School_Vehicle_booking> bookingList = new ArrayList<>();

		Connection con = DBConnection.openConnection();

		String selectQuery = "select   s.name,s.email, s.phone,s.address,s.city, s.school_id, svb.vehicle_type , svb.charge,svb.booking_id, svb.no_of_students from schools s , school_vehicle_booking svb where s.school_id = svb.school_id and svb.answer is null";

		PreparedStatement ps = null;
		ResultSet rs = null;
		School s = null;
		School_Vehicle_booking svb = null;
		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {

				
				
                String sname = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String city = rs.getString("city");
                String address = rs.getString("address");
               
               
               s = new School();
               svb = new School_Vehicle_booking();
             s.setName(sname);
             s.setEmail(email);
             s.setPhone(phone);
             s.setCity(city);
             s.setAddress(address);
             
             String number_of_kids = rs.getString("no_of_students");  
             String vehicle_type = rs.getString("vehicle_type");  
             String charge = rs.getString("charge");
				int booking_id=rs.getInt("booking_id");
				
				
                 svb.setNo_of_students(number_of_kids);
				svb.setVehicle_type(vehicle_type);
				svb.setCharge(charge);
				svb.setBooking_id(booking_id);
				svb.setSchool(s);// HAS A RELATIONSHIP
				bookingList.add(svb);
       System.out.println(bookingList);
			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return bookingList;
	}
	public int confirmschoolbooking(String[] booking_ids, String driver_name, String vehiclenumber, String message) {
       
		Connection con = DBConnection.openConnection();
        String updateQuery = "UPDATE school_vehicle_booking SET driver_id = ?, vehicle_number = ?, answer = ?,booking_status='confirm' WHERE booking_id = ?";

        int status = 0;
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(updateQuery);
            for (String b : booking_ids) {
                ps.setString(1, driver_name);                     
                ps.setString(2, vehiclenumber);        
                ps.setString(3, message);     
                ps.setInt(4, Integer.parseInt(b));          
                	System.out.println(ps);
                ps.addBatch();
            }

            
            int[] rows = ps.executeBatch();

			for (int i = 0; i < rows.length; i++)

			{

				if (rows[i] < 0)
					break;
				else
					status = 1;
			}

		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			try {
				if (ps != null) {
					ps.close(); 
				}
				if (con != null) {
					con.close(); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return status;
}
	public ArrayList<School> viewschools()

	{

		ArrayList<School> schoolsList = new ArrayList<>();

		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from schools";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {

				String sname = rs.getString("name");
				String id = rs.getString("school_id");
				String founder = rs.getString("founder");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String board = rs.getString("board");
				


				
				School s = new School();
				
				s.setName(sname);
				s.setSchool_id(id);
				s.setFounder(founder);
				s.setEmail(email);
				s.setPhone(phone);
				s.setAddress(address);
				s.setCity(city);
				s.setBoard(board);
				
				

				schoolsList.add(s); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return schoolsList;	
}
	public ArrayList<Parent> viewparents()

	{

		ArrayList<Parent> parentList = new ArrayList<>();

		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from parent";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {

				String pname = rs.getString("name");
				String id = rs.getString("parent_id");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String city = rs.getString("city");
				String gender = rs.getString("gender");



				
				Parent p = new Parent();
				
				p.setName(pname);
				p.setParent_id(id);
				p.setPhone(phone);
				p.setEmail(email);
				p.setCity(city);
				p.setGender(gender);
				

				parentList.add(p); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return parentList;	
}	
	public ArrayList<Driver> viewdrivers()

	{

		ArrayList<Driver> driverList = new ArrayList<>();

		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from drivers";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
           // driver_id, password, name, email, phone, city, address, experience, gender, qualification
				String dname = rs.getString("name");
				String id = rs.getString("driver_id");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String city = rs.getString("city");
				
				String gender = rs.getString("gender");
				String qualification = rs.getString("qualification");
				String experience = rs.getString("experience");
				



				
				Driver d = new Driver();
				
				d.setName(dname);
				d.setDriver_id(id);
				d.setPhone(phone);
				d.setEmail(email);
				d.setAddress(address);
				d.setCity(city);
				
				d.setGender(gender);
				d.setQualification(qualification);
				d.setExperience(experience);
				
				
				

				driverList.add(d); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return driverList;	
}	
	
	public ArrayList<Add_vehicles> viewvehicles()

	{

		ArrayList<Add_vehicles> vehicleList = new ArrayList<>();

		Connection con = DBConnection.openConnection();
//types, number, color, fuel_type, name, description
		String selectQuery = "select  * from vehicles";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {

				String types = rs.getString("types");
				String number = rs.getString("number");
				String color = rs.getString("color");
				String fuel_type = rs.getString("fuel_type");
				String name = rs.getString("name");
				String description = rs.getString("description");


				
				Add_vehicles av = new Add_vehicles();
				
				av.setTypes(types);
				av.setNumber(number);
				av.setColor(color);
				av.setFuel_type(fuel_type);
				av.setName(name);
				av.setDescription(description);

				vehicleList.add(av); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return vehicleList;	
}}