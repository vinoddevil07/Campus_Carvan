package cc.beans;

public class School_Vehicle_booking {

	// booking_id, school_id, vehicle_type, charge, no_of_students, booking_status,
	// driver_id, vehicle_number, answer

	private int booking_id;
	private String school_id, vehicle_type, charge, no_of_students, booking_status, driver_id, 
	vehicle_number, answer;
	
	private School school;
	
	
	
	
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public School_Vehicle_booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public School_Vehicle_booking(String school_id, String vehicle_type, String charge, String no_of_students) {
		super();
		this.school_id = school_id;
		this.vehicle_type = vehicle_type;
		this.charge = charge;
		this.no_of_students = no_of_students;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getSchool_id() {
		return school_id;
	}
	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getNo_of_students() {
		return no_of_students;
	}
	public void setNo_of_students(String no_of_students) {
		this.no_of_students = no_of_students;
	}
	public String getBooking_status() {
		return booking_status;
	}
	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}
	public String getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}
	public String getVehicle_number() {
		return vehicle_number;
	}
	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
}