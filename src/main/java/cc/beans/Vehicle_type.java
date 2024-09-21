package cc.beans;

public class Vehicle_type {

	//types, hourly charge, montly charge
	
	private String types, hourly_charge, montly_charge;
	
	
	
	
	

	public Vehicle_type(String types, String hourly_charge, String montly_charge) {
		super();
		this.types = types;
		this.hourly_charge = hourly_charge;
		this.montly_charge = montly_charge;
	}
	
	
	
	

	public Vehicle_type() {
		super();
		// TODO Auto-generated constructor stub
	}





	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getHourly_charge() {
		return hourly_charge;
	}
	public void setHourly_charge(String hourly_charge) {
		this.hourly_charge = hourly_charge;
	}

	public String getMontly_charge() {
		return montly_charge;
	}

	public void setMontly_charge(String montly_charge) {
		this.montly_charge = montly_charge;
	}
	
}
