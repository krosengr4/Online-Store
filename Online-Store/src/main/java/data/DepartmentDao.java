package data;

import models.Department;
import models.Printable;

import java.util.List;

public interface DepartmentDao {

	List<Printable> getAll();

	void add(Department department);

	void delete(int departmentId);

}
