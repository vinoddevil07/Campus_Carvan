package cc.beans;

import java.sql.Date;

public class Feedback {
	
	// name , email, remarks, ratings, date
	
	
	private String name , email , remarks, ratings ;
	private Date date;
	
	
	
	
	
	
	
	public Feedback(String name, String email, String remarks, String rating, Date date) {
		super();
		this.name = name;
		this.email = email;
		this.remarks = remarks;
		this.ratings = rating;
		this.date = date;
	}
	
	
	
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRating() {
		return ratings;
	}
	public void setRating(String rating) {
		this.ratings = rating;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

	

}
