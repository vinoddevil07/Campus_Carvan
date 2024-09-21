package cc.beans;

public class Add_vehicles {
	
	
	//vehicle_types, number, color, fuel_type, name, description
	
	private String types, number, color, fuel_type, name, description;
	
	
	
	
	

	public Add_vehicles(String types, String number, String color, String fuel_type, String name, String description) {
		super();
		this.types = types;
		this.number = number;
		this.color = color;
		this.fuel_type = fuel_type;
		this.name = name;
		this.description = description;
	}
	
	
	

	public Add_vehicles() {
		super();
		// TODO Auto-generated constructor stub
	}




	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuel_type() {
		return fuel_type;
	}

	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
