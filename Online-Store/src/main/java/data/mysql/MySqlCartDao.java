package data.mysql;

import config.DatabaseConfig;
import data.CartDao;
import data.ProductDao;
import models.Cart;
import models.CartItem;
import models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySqlCartDao extends MySqlDaoBase implements CartDao {

	ProductDao productDao = new MySqlProductDao(DatabaseConfig.setConnection());

	public MySqlCartDao(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public Cart getCart() {
		Map<Integer, CartItem> cartMap = new HashMap<>();
		List<CartItem> cartItems = getCartItems();
		Cart cart = new Cart();

		for(CartItem item : cartItems) {
			cartMap.put(item.getProductId(), item);
		}

		cart.setItems(cartMap);
		return cart;
	}

	@Override
	public List<CartItem> getCartItems() {
		List<CartItem> cartItems = new ArrayList<>();
		String query = "SELECT * FROM cart;";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet results = statement.executeQuery();
			while(results.next()) {
				cartItems.add(mapRow(results));
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return cartItems;
	}

	@Override
	public void add(CartItem cartItem) {
		String query = """
				INSERT INTO cart (product_id, quantity, price)
				VALUES (?, ?, ?);
				""";
		Product product = cartItem.getProduct();

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, product.getProductId());
			statement.setInt(2, cartItem.getQuantity());
			statement.setDouble(3, product.getPrice());

			int rows = statement.executeUpdate();
			if(rows > 0)
				System.out.println("Success! Item was added to your cart!");
			else
				System.err.println("ERROR! Could not add item to your cart!!!");

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remove(int productId) {
		String query = """
				DELETE FROM cart
				WHERE product_id = ?;
				""";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, productId);

			int rows = statement.executeUpdate();
			if(rows > 0)
				System.out.println("Success! The item was deleted!!!");
			else
				System.err.println("ERROR! Could not delete item from your cart!!!");

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private CartItem mapRow(ResultSet result) throws SQLException {
		int productId = result.getInt("product_id");
		Product product = productDao.getById(productId);

		int quantity = result.getInt("quantity");
		double price = result.getInt("price");

		return new CartItem(product, quantity);
	}

}
