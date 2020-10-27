package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.Scanner;

/* Working with JDBC entails a lot of boilerplate code which can become 
 * tedious and error prone. The Spring JBDC framework can help eliminate 
 * much of the boilerplate code, and limit the tedium and mistakes. */
public class SpringJDBCExample {

	public static void main(String[] args) {

		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */
		BasicDataSource dvdstoreDataSource = new BasicDataSource();
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dvdstoreDataSource.setUsername("postgres");
		dvdstoreDataSource.setPassword("postgres1"); //Don't make this a habit--use an environment variable or external config file.

		JdbcTemplate jdcbTemplate = new JdbcTemplate(dvdstoreDataSource);

		String query = "SELECT first_name, last_name FROM actor WHERE last_name LIKE 'C%';";

		jdcbTemplate.queryForRowSet(query);

		SqlRowSet results = jdcbTemplate.queryForRowSet(query);

		while (results.next()) {
			System.out.println(results.getString("first_name") + " " + results.getString("last_name"));
		}

		System.out.println("-----------DIVIDER---------------");


		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter a letter last name begins with: ");
		String lastLetter = userInput.nextLine();
		lastLetter = lastLetter.substring(0,1);
		lastLetter = lastLetter.toUpperCase();
		System.out.print("Please enter a letter first name contains: ");
		String firstLetter = userInput.nextLine();
		firstLetter = firstLetter.substring(0,1);
		firstLetter = firstLetter.toUpperCase();


		String paramQuery = "SELECT first_name, last_name FROM actor WHERE last_name LIKE ? AND first_name LIKE ?;";

		results = jdcbTemplate.queryForRowSet(paramQuery, lastLetter + "%", "%" + firstLetter + "%");

		while (results.next()) {
			System.out.println(results.getString("first_name") + " " + results.getString("last_name"));
		}

		System.out.println("-----------DIVIDER---------------");

		String updateQuery = "INSERT INTO actor (first_name, last_name) VALUES ('EVE', 'FEVE');";
		jdcbTemplate.update(updateQuery);

		jdcbTemplate.update("DELETE FROM actor WHERE last_name = 'FEVE';");
	}
}
