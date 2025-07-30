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

	private Product mapRow(ResultSet result) throws SQLException {
		int productId = result.getInt("product_id");
		int departmentId = result.getInt("department_id");
		String sku = result.getString("SKU");
		String name = result.getString("name");
		double price = result.getDouble("price");

		return new Product(productId, departmentId, sku, name, price);
	}

}
