package com.techelevator.cart;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class CartJdbcDao implements CartDao {

	private JdbcTemplate jdbcTemplate;

	public CartJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public void save(Cart newCart) {
		// Implement this method to save cart to database
		String sql = "INSERT INTO cart (username, cookie_value, created) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, newCart.getId(), newCart.getUsername(), newCart.getCookieValue(), newCart.getCreated());
	}

	@Override
	public List<Cart> getAllCarts() {
		// Implement this method to pull in all carts from database
		List<Cart> result = new ArrayList<>();
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT id, username, cookie_value, created FROM carts;");
		while (rowSet.next()) {
			Cart cart = mapRowToCart(rowSet);
			result.add(cart);
		}
		return result;
	}

	private Cart mapRowToCart(SqlRowSet results) {
		Cart cartRow = new Cart();
		cartRow.setId(results.getLong("id"));
		cartRow.setUsername(results.getString("username"));
		cartRow.setCookieValue(results.getString("cookie_value"));
		cartRow.setCreated(results.getDate("created").toLocalDate());
		return cartRow;
	}

}
