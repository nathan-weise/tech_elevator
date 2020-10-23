package com.techelevator.city;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCityDao implements CityDao {

	private static final String ALL_FIELDS = "id, name, district, countrycode, population";

	private final JdbcTemplate jdbcTemplate;

	public JdbcCityDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(City newCity) {
		String sql = "INSERT INTO city (name, district, countrycode, population) VALUES (?,?,?,?) RETURNING id";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, newCity.getName(), newCity.getDistrict(),
				newCity.getCountryCode(), newCity.getPopulation());
		if (rowSet.next()) {
			newCity.setId(rowSet.getLong("id"));
		}
	}

	@Override
	public City findCityById(long id) {
		City result = new City();
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT " + ALL_FIELDS + " FROM city WHERE id = ?;", id);
		if (rowSet.next()) {
			result = mapRowToCity(rowSet);
		} else {
			result = null;
		}
		return result;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		List<City> result  = new ArrayList<>();
		String sql = "SELECT " + ALL_FIELDS + " FROM city WHERE countrycode = ?;";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, countryCode);
		while (rowSet.next()) {
			City city = mapRowToCity(rowSet);
			result.add(city);
		}
		return result;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		List<City> result  = new ArrayList<>();
		String sql = "SELECT " + ALL_FIELDS + " FROM city WHERE district = ?;";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, district);
		while (rowSet.next()) {
			City city = mapRowToCity(rowSet);
			result.add(city);
		}
		return result;
	}

	@Override
	public void update(City city) {
		String sql = "UPDATE city SET name = ?, district = ?, countrycode = ?," +
				" population =? WHERE id = ?;";
		int updatedCount = jdbcTemplate.update(sql, city.getName(), city.getDistrict(), city.getCountryCode(),
				city.getPopulation(), city.getId());
		if (updatedCount != 1) {
			throw new RuntimeException("Unexpected number of cities updated.");
		}
	}

	@Override
	public void delete(long id) {
		jdbcTemplate.update("DELETE FROM city WHERE id = ?", id);
	}

	private City mapRowToCity(SqlRowSet rowSet) {
		City city = new City();
		city.setId(rowSet.getLong("id"));
		city.setName(rowSet.getString("name"));
		String district = rowSet.getString("district");
		if (district != null) {
			city.setDistrict(district);
		}
		city.setCountryCode(rowSet.getString("countrycode"));
		city.setPopulation(rowSet.getInt("population"));
		return city;
	}

}
