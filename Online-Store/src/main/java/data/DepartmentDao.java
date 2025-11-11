package data;

import models.Department;
import models.Printable;

import java.util.List;

public interface DepartmentDao {

	List<Printable> getAll();

	Department getById(int departmentId);

	Department add(Department department);

	void delete(int departmentId);

}
