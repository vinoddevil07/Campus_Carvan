package cc.beans;

import java.util.Date;

public class UserFeedback {
//user_id, feedback_text, role, rating, date

	private String user_id, feedback_text, role, rating;
	private Date date;
	
	



	public UserFeedback(String user_id, String feedback_text, String role, String rating, Date date) {
		super();
		this.user_id = user_id;
		this.feedback_text = feedback_text;
		this.role = role;
		this.rating = rating;
		this.date = date;
	}


	public UserFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFeedback_text() {
		return feedback_text;
	}
	public void setFeedback_text(String feedback_text) {
		this.feedback_text = feedback_text;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
