package models;

public class Department {

	int departmentId;
	String name;

	public Department(int departmentId, String name) {
		this.departmentId = departmentId;
		this.name = name;
	}

	//region Setters and Getters
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//endregion
}
