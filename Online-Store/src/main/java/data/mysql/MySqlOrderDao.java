package data.mysql;

import data.OrderDao;
import models.Order;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MySqlOrderDao extends MySqlDaoBase implements OrderDao {

	DataSource dataSource;

	public MySqlOrderDao(DataSource dataSource) {
		super(dataSource);
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
