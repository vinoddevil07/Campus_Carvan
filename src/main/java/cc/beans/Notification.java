package cc.beans;

import java.sql.Date;

public class Notification {

	// notice_id, notice_content, date
	private int notice_id;
	private String notice_content;
	private Date date;

	public Notification(String notice_content, Date date) {
		super();
		this.notice_content = notice_content;
		this.date = date;
	}

	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
