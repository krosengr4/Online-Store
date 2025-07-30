package data.mysql;

import data.DepartmentDao;
import models.Department;
import models.Printable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlDepartmentDao extends MySqlDaoBase implements DepartmentDao {

	public MySqlDepartmentDao(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public List<Printable> getAll() {
		List<Printable> departmentList = new ArrayList<>();
		String query = "SELECT * FROM departments;";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet results = statement.executeQuery();
			while(results.next()) {
				departmentList.add(mapRow(results));
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return departmentList;
	}

	@Override
	public void add(Department department) {
		String query = """
				INSERT INTO departments (name)
				VALUES (?);
				""";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, department.getName());

			int rows = statement.executeUpdate();
			if(rows > 0)
				System.out.println("Success! Department was created!");
			else
				System.err.println("ERROR! Could not create new department!!!");

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int departmentId) {
		String query = """
				DELETE FROM departments
				WHERE department_id = ?;
				""";

		try(Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, departmentId);

			int rows = statement.executeUpdate();
			if(rows > 0)
				System.out.println("Success! Department deleted!");
			else
				System.err.println("ERROR! Could not delete the department!!!");

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Department mapRow(ResultSet result) throws SQLException {
		int departmentId = result.getInt("department_id");
		String name = result.getString("name");

		return new Department(departmentId, name);
	}
}
