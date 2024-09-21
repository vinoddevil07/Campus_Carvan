package cc.beans;

public class Booking {

	private int booking_id;
	private String[] kid_name, age, standard, school;
	private String vehicle_type, parent_id, charge;
	
	private String kidname,ag,std,sch;
		
    private String driver_id , number , answer ;
    
    
    private String booking_status;
    
    
    
    
    
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getKidname() {
		return kidname;
	}

	public void setKidname(String kidname) {
		this.kidname = kidname;
	}

	public String getAg() {
		return ag;
	}

	public void setAg(String ag) {
		this.ag = ag;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getSch() {
		return sch;
	}

	public void setSch(String sch) {
		this.sch = sch;
	}

	private Parent parent;
	
	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}
	
	
	

	public Booking(String[] kid_name, String[] age, String[] standard, String[] school, String vehicle_type,
			String parent_id, String charge) {
		super();
		this.kid_name = kid_name;
		this.age = age;
		this.standard = standard;
		this.school = school;
		this.vehicle_type = vehicle_type;
		this.parent_id = parent_id;
		this.charge = charge;
	}
	
	
	

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String[] getKid_name() {
		return kid_name;
	}

	public void setKid_name(String[] kid_name) {
		this.kid_name = kid_name;
	}

	public String[] getAge() {
		return age;
	}

	public void setAge(String[] age) {
		this.age = age;
	}

	public String[] getStandard() {
		return standard;
	}

	public void setStandard(String[] standard) {
		this.standard = standard;
	}

	public String[] getSchool() {
		return school;
	}

	public void setSchool(String[] school) {
		this.school = school;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	

	
	
}
