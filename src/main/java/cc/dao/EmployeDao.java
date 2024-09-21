package cc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cc.beans.Employes;
import cc.dbinfo.DBConnection;

public class EmployeDao{

	public int addEmployee(Employes e) {
		
		Connection con = DBConnection.openConnection();
		
		String insertQuery = "insert into employee(employee_id, pass, name, email, phone)values(?,?,?,?,?)";

		int status = 0;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(insertQuery); /// passes Query to mySQL -> compiler compile the query and
			// store the complied query into buffer and give refernece to ps

			ps.setString(1, e.getEmployee_id());
			ps.setString(2, e.getPass());
			ps.setString(3, e.getName());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPhone());
			
			

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
	
	
	public ArrayList<Employes> viewEmployes()

	{

		ArrayList<Employes> employeeList = new ArrayList<>();
		Employes employes = null;

		Connection con = DBConnection.openConnection();

		String selectQuery = "select  * from employee";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement(selectQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				// employee_id, pass, name, email, phone

				String id = rs.getString("employee_id");
				String pass = rs.getString("pass");

				String name = rs.getString("name");

				String email = rs.getString("email");

				String phone = rs.getString("phone");

				employes = new Employes(id, pass, name,email,phone); // object creation using fetched record
			    employeeList.add(employes); // adding object into ArrayList

			}

		} catch (SQLException se) {
			se.printStackTrace();

		}

		return employeeList;

	}

	// END viewCONTACTS METHOD
	

}
