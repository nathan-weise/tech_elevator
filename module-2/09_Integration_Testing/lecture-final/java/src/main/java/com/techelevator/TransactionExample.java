package com.techelevator;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionExample {

	private static JdbcTemplate jdbcTemplate;

	public static void main(String[] args) throws SQLException {
		
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dataSource.setUsername("postgres");
		dataSource.setPassword(System.getenv("DB_PASSWORD"));
		dataSource.setAutoCommit(false);
		
		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update("UPDATE actor SET first_name = 'David';");

		jdbcTemplate.update("TRUNCATE actor CASCADE;");

		displayActorNames();

		Connection currentConnection = dataSource.getConnection();
		currentConnection.rollback(); //Or .commit()

		displayActorNames();
					
		dataSource.destroy();
	}

	public static void displayActorNames() {
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT first_name, last_name FROM actor;");
		while (rowSet.next()) {
			String firstName = rowSet.getString("first_name");
			String lastName = rowSet.getString("last_name");
			System.out.println(firstName + " " + lastName);
		}
	}



}
