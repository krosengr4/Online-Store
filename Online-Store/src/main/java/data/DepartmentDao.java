package data;

import models.Department;

import java.util.List;

public interface DepartmentDao {

	List<Department> getAll();

	void add(Department department);

	void delete(int departmentId);

}
