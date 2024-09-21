package cc.beans;

import java.util.Date;

public class Message {
	// message_id, sender_id, receiver_id, subject, message_text, date
	private int message_id;
	private String sender_id, receiver_id, subject, message_text;
	private Date date;
	
	
	public Message(String sender_id, String receiver_id, String subject, String message_text, Date date) {
		super();
		this.sender_id = sender_id;
		this.receiver_id = receiver_id;
		this.subject = subject;
		this.message_text = message_text;
		this.date = date;
	}
	
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	public String getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage_text() {
		return message_text;
	}
	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
