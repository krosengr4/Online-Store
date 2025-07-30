package config;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConfig {

	private static final BasicDataSource basicDataSource = new BasicDataSource();

	public static BasicDataSource setConnection() {
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/online_store");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword(System.getenv("SQL_PASSWORD"));
		return basicDataSource;
	}

}
