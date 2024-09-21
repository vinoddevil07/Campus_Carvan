package cc.beans;

public class Driver {

	//driver_id, name, email, phone, city, address, experience, gender, qualification
	
	private String driver_id,password, name, email, phone, city, address, experience, gender, qualification;
	
	
	
	
	
	
	
	
	

	public Driver(String driver_id, String password, String name, String email, String phone, String city,
			String address, String experience, String gender, String qualification) {
		super();
		this.driver_id = driver_id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.address = address;
		this.experience = experience;
		this.gender = gender;
		this.qualification = qualification;
	}
	
	
	
	
	

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}






	public String getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
