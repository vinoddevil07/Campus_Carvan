package cc.beans;

public class Employes {
	
	//employee_id, pass, name, email, phone
	
	
	private String employee_id, pass, name, email, phone;
	
	
	
	
	
	
	
	

	public Employes(String employee_id, String pass, String name, String email, String phone) {
		super();
		this.employee_id = employee_id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	
	
	

	public Employes() {
		super();
		// TODO Auto-generated constructor stub
	}





	public String getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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
	
	
	
	
	

}
