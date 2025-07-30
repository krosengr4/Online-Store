package data;

import models.Product;

import java.util.List;

public interface ProductDao {

	List<Product> getAll();

	List<Product> getByDepartment();

	List<Product> searchByName();

	void add();

	void update();

	void delete();

}
