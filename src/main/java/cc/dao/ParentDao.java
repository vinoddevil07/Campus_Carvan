package cc.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cc.beans.Add_vehicles;
import cc.beans.Booking;
import cc.beans.Message;
import cc.beans.Parent;
import cc.dbinfo.DBConnection;

public class ParentDao {
	
	public Parent viewProfile(String id) {

		Connection con = DBConnection.openConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String selectQuery = "select * from parent where parent_id=?";
		Parent p = null;

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
			String pass = rs.getString("password");
			p = new Parent(); // setting values in parent objects
			p.setEmail(email);// Order is not Important
			p.setName(name);
			p.setPhone(phone);
			p.setPassword(pass);
			p.setCity(pass);

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
		return p;// returning Parent class object
	}

	public boolean login(String user, String pass) {

		Connection con = DBConnection.openConnection();
		String selectQuery = "select * from parent  where parent_id=? and password=?";

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

	public int addParent(Parent p) {
		// TODO Auto-generated method stub

		Connection con = DBConnection.openConnection();
		String insertQuery = "insert into parent(parent_id, password, name, phone, email, city, gender, question, date)values(?,?,?,?,?,?,?,?,?)";
		int status = 0;
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(insertQuery);
			ps.setString(1, p.getParent_id());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getName());
			ps.setString(4, p.getPhone());
			ps.setString(5, p.getEmail());
			ps.setString(6, p.getCity());
			ps.setString(7, p.getGender());
			ps.setString(8, p.getQuestion());
			ps.setDate(9, p.getDate());
			
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

	public int editProfile(Parent p) {

		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		// parent_id, password, name, phone, email, city, gender, question, date
		String updateQuery = "update parent set name=?, email=?, phone=? where parent_id=?";
		int status = 0;
		try {

			ps = con.prepareStatement(updateQuery);
			ps.setString(1, p.getName());
			ps.setString(2, p.getEmail());
			ps.setString(3, p.getPhone());
			ps.setString(4, p.getParent_id());
			System.out.println(ps);
			status = ps.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}

		return status;
	}

	public int compose(Message m) {
		Connection con = DBConnection.openConnection();
		// message_id, sender_id, receiver_id, subject, message_text, date
		String insertQuery = "insert into message(sender_id, receiver_id, subject, message_text, date)values(?,?,?,?,?)";
		int status = 0;
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(insertQuery);

			ps.setString(1, m.getSender_id());
			ps.setString(2, m.getReceiver_id());
			ps.setString(3, m.getSubject());
			ps.setString(4, m.getMessage_text());
			ps.setDate(5, (Date) m.getDate());

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

	public ArrayList<Message> viewinbox(String rid)

	{

		ArrayList<Message> messageList = new ArrayList<>();
		Message msg = null;

		Connection con = DBConnection.openConnection();

		String selectQuery = "SELECT * FROM messages WHERE receiver_id =?";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			ps.setString(1, rid);
			ps.setString(2, rid);
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

	public void vehicleBooking(Booking b) {

		Connection con = DBConnection.openConnection();
		// message_id, sender_id, receiver_id, subject, message_text, date

		// b.getAge().
		int status = 0;
		String[] age = b.getAge();
		String[] name = b.getKid_name();
		String[] standard = b.getStandard();
		String[] school = b.getSchool();

		int len = name.length;

		String insertQuery = "insert into vehicle_booking(parent_id, vehicle_type, charge, kid_name, standard, kid_age,school_name)values(?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(insertQuery);

			for (int i = 0; i < len; i++) {

				ps.setString(1, b.getParent_id());
				ps.setString(2, b.getVehicle_type());
				ps.setString(3, b.getCharge());
				ps.setString(4, name[i]);
				ps.setString(5, standard[i]);
				ps.setString(6, age[i]);
				ps.setString(7, school[i]);
				// ps.executeUpdate()

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
			e.printStackTrace(); // Exception handling
		} finally {
			try {
				if (ps != null) {
					ps.close(); // Closing PreparedStatement
				}
				if (con != null) {
					con.close(); // Closing Connection
				}
			} catch (SQLException e) {
				e.printStackTrace(); // Exception handling
			}
		}}
		public ArrayList<Booking> confirmbooking()

		{

			ArrayList<Booking> confirmbookingList = new ArrayList<>();

			Connection con = DBConnection.openConnection();

			String selectQuery = "select  * from vehicle_booking where booking_status is not null ";
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = con.prepareStatement(selectQuery);
				rs = ps.executeQuery();
				while (rs.next()) {

					
					String dname = rs.getString("driver_id");
					String number = rs.getString("number");
					String kname = rs.getString("kid_name");
					String sname = rs.getString("school_name");					
					String vtype = rs.getString("vehicle_type");
					Booking b = new Booking();
					
					b.setDriver_id(dname);
	                b.setNumber(number);
	                b.setKidname(kname);
	                b.setSch(sname);
	                b.setVehicle_type(vtype);
	                     
	                     confirmbookingList.add(b); // adding object into ArrayList

				}

			} catch (SQLException se) {
				se.printStackTrace();

			}

			return confirmbookingList;
	}
	
}
