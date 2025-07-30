package data.mysql;

import config.DatabaseConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MySqlDaoBase {

	private final DataSource dataSource;

	public MySqlDaoBase(DataSource dataSource) {
		this.dataSource = DatabaseConfig.setConnection();
	}

	protected Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
