package models;

public class Department implements Printable{

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

	@Override
	public void print() {
		System.out.println("-----DEPARTMENT-----");
		System.out.println("Department ID: " + this.departmentId);
		System.out.println("Department Name: " + this.name);
		System.out.println("----------------------------------------------");
	}
}
