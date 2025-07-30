package data;

import models.Product;

import java.util.List;

public interface ProductDao {

	List<Product> getAll();

	List<Product> getByDepartment(int departmentId);

	List<Product> searchByName(String name);

	List<Product> searchByPrice(double minPrice, double maxPrice);

	void add(Product product);

	void update(int productId, Product product);

	void delete(int productId);

}
