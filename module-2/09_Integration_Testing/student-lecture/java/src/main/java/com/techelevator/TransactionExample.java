package com.techelevator;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class TransactionExample {

	public static void main(String[] args) {
		
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dataSource.setUsername("postgres");
		dataSource.setPassword(System.getenv("DB_PASSWORD"));
		dataSource.setAutoCommit(false);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


					
		dataSource.destroy();
	}

}
