package data;

import models.Printable;
import models.Product;

import java.util.List;

public interface ProductDao {

	List<Printable> getAll();

	Product getById(int productId);

	List<Printable> getByDepartment(int departmentId);

	List<Printable> searchByName(String name);

	List<Printable> searchByPrice(double minPrice, double maxPrice);

	Product add(Product product);

	void update(int productId, Product product);

	void delete(int productId);

}
