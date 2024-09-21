package cc.beans;

import java.sql.Date;

public class Parent {
	//parent_id, password, name, phone, email, city, gender, question, date	
	private String parent_id, password, name, phone, email, city, gender, question;
	private Date date;
	
	
	
	
	
	
	
	
	public Parent(String parent_id, String password, String name, String phone, String email, String city,
			String gender, String question, Date date) {
		this.parent_id = parent_id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.gender = gender;
		this.question = question;
		this.date = date;
	}
	
	
	
	
	
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}





	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	
	
}
