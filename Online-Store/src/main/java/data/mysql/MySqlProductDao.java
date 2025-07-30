package data.mysql;

import data.ProductDao;
import models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductDao extends MySqlDaoBase implements ProductDao {

	public MySqlProductDao(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public List<Product> getAll() {
		List<Product> productsList = new ArrayList<>();
		String query = "SELECT * FROM products;";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet results = statement.executeQuery();
			while(results.next()) {
				productsList.add(mapRow(results));
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return productsList;
	}

	@Override
	public Product getById(int productId) {
		String query = """
				SELECT * FROM products
				WHERE product_id = ?;
				""";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, productId);

			ResultSet results = statement.executeQuery();
			if(results.next()) {
				return mapRow(results);
			} else {
				System.out.println("Could not find a product with that ID...");
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	@Override
	public List<Product> getByDepartment(int departmentId) {
		List<Product> productList = new ArrayList<>();
		String query = """
				SELECT * FROM products
				WHERE department_id = ?;
				""";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, departmentId);

			ResultSet results = statement.executeQuery();
			while(results.next()) {
				productList.add(mapRow(results));
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return productList;
	}

	@Override
	public List<Product> searchByName(String name) {
		List<Product> productList = new ArrayList<>();
		String query = """
				SELECT * FROM products
				WHERE name LIKE ?;
				""";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, "%" + name + "%");

			ResultSet results = statement.executeQuery();
			while(results.next()) {
				productList.add(mapRow(results));
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return productList;
	}

	@Override
	public List<Product> searchByPrice(double minPrice, double maxPrice) {
		List<Product> productList = new ArrayList<>();
		String query = """
				SELECT * FROM products
				WHERE price BETWEEN ? AND ?;
				""";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setDouble(1, minPrice);
			statement.setDouble(2, maxPrice);

			ResultSet results = statement.executeQuery();
			while(results.next()) {
				productList.add(mapRow(results));
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return productList;
	}

	@Override
	public void add(Product product) {
		String query = """
				INSERT INTO products (department_id, SKU, name, price)
				VALUES (?, ?, ?, ?);
				""";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, product.getDepartmentId());
			statement.setString(2, product.getSku());
			statement.setString(3, product.getName());
			statement.setDouble(4, product.getPrice());

			int rows = statement.executeUpdate();
			if(rows > 0)
				System.out.println("Success! The new product was added!");
			else
				System.err.println("ERROR! Could not add product!!!");

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(int productId, Product product) {
		String query = """
				UPDATE products
				SET department_id = ?,
				SKU = ?,
				name = ?,
				price = ?
				WHERE product_id = ?;
				""";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, product.getDepartmentId());
			statement.setString(2, product.getSku());
			statement.setString(3, product.getName());
			statement.setDouble(4, product.getPrice());
			statement.setInt(5, productId);

			int rows = statement.executeUpdate();
			if(rows > 0)
				System.out.println("Success! The product was updated!");
			else
				System.err.println("ERROR! Could not update the product!!!");

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int productId) {
		String query = """
				DELETE FROM products
				WHERE product_id = ?;
				""";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, productId);

			int rows = statement.executeUpdate();
			if(rows > 0)
				System.out.println("Success! Product was deleted!");
			else
				System.err.println("ERROR! Could not delete the product!!!");

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Product mapRow(ResultSet result) throws SQLException {
		int productId = result.getInt("product_id");
		int departmentId = result.getInt("department_id");
		String sku = result.getString("SKU");
		String name = result.getString("name");
		double price = result.getDouble("price");

		return new Product(productId, departmentId, sku, name, price);
	}

}
