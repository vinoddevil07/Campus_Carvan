package cc.beans;

import java.sql.Date;

public class School {
	// school_id, password, name, email, phone, address, founder, board, city, date
	
	private String  school_id, password, name, email, phone, address, founder, board, city;
	private Date date;
	

	
	
	public School(String school_id, String password, String name, String email, String phone, String address,
			String founder, String board, String city, Date date) {
		super();
		this.school_id = school_id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.founder = founder;
		this.board = board;
		this.city = city;
		this.date = date;
	}
	
	
	
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}








	public String getSchool_id() {
		return school_id;
	}
	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
