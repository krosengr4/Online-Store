package data.mysql;

import data.OrderDao;
import models.Order;
import models.OrderLineItems;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderDao extends MySqlDaoBase implements OrderDao {

	DataSource dataSource;

	public MySqlOrderDao(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public List<Order> getAll() {
		List<Order> orderList = new ArrayList<>();
		String query = "SELECT * FROM orders;";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet results = statement.executeQuery();
			while(results.next()) {
				orderList.add(mapRow(results));
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return orderList;
	}

	@Override
	public Order getById(int orderId) {
		String query = """
				SELECT * FROM orders
				WHERE order_id = ?;
				""";
		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, orderId);

			ResultSet result = statement.executeQuery();
			if(result.next()) {
				return mapRow(result);
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	@Override
	public List<OrderLineItems> getLineItems(int orderId) {
		List<OrderLineItems> lineItemsList = new ArrayList<>();
		String query = """
				SELECT * FROM order_line_items
				WHERE order_id = ?;
				""";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, orderId);

			ResultSet result = statement.executeQuery();
			if(result.next()) {
				int lineItemId = result.getInt("line_item_id");
				int newOrderId = result.getInt("order_id");
				int productId = result.getInt("product_id");
				int quantity = result.getInt("quantity");
				BigDecimal salesPrice = result.getBigDecimal("sales_price");

				lineItemsList.add(new OrderLineItems(lineItemId, newOrderId, productId, quantity, salesPrice));
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return lineItemsList;
	}


	private Order mapRow(ResultSet result) throws SQLException {
		int orderId = result.getInt("order_id");
		LocalDateTime dateTime = result.getTimestamp("date").toLocalDateTime();
		String customerName = result.getString("name");
		String address = result.getString("address");
		String city = result.getString("city");
		String state = result.getString("state");

		return new Order(orderId, dateTime, customerName, address, city, state);
	}

}
