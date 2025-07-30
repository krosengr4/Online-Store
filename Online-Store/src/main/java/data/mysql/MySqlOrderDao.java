package data.mysql;

import data.OrderDao;
import models.Order;

import javax.sql.DataSource;
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
