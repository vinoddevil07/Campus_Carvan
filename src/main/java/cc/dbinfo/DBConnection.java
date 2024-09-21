package cc.dbinfo;

import java.sql.*;

public class DBConnection

{

	private static Connection con; // Connection hold the address of database

	public static Connection openConnection() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); // Factory method is used to create object
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campuscarvan_db", "root", "admin");

		}
		// protocol
		// localhost -> this is the address of that machine where db has been installed
		// port number -> logical number where database listens
		// database name
		// database userId
		//databse userPassword
		
		catch (SQLException|ClassNotFoundException se) {

			se.printStackTrace();
		}
		
		
		
		
		return con;
	}

	/*
	 * public static void main(String[] args) { Connection c =
	 * DBConnection.openConnection(); System.out.println(c); }
	 */
}
