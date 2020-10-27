package com.techelevator.city;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JdbcCityDaoIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ";

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	private JdbcCityDao sut;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before
	public void setup() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update("TRUNCATE country CASCADE"); //remove existing data

		String sqlInsertCountry = "INSERT INTO country " +
				"(code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold," +
				" localname, governmentform, headofstate, capital, code2)" +
				"VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL," +
				"'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', NULL, 'AF')";

		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);

		sut = new JdbcCityDao(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test
	public void new_city_can_be_created_and_retrieved() {
		//Arrange
		City testCity = createTestCity();

		//Act
		sut.create(testCity);
		City retrievedCity = sut.findCityById(testCity.getId());

		//Assert
		assertCitiesAreEqual(testCity, retrievedCity);
	}

	@Test
	public void all_city_info_is_updated_correctly() {
		//Arrange
		City testCity = createTestCity();
		sut.create(testCity);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sqlInsertCountry = "INSERT INTO country " +
				"(code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold," +
				" localname, governmentform, headofstate, capital, code2)" +
				"VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL," +
				"'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', NULL, 'AF')";
		jdbcTemplate.update(sqlInsertCountry, "ABC");

		//Act
		testCity.setName("New Name");
		testCity.setDistrict("New District");
		testCity.setPopulation(999);
		testCity.setCountryCode("ABC");
		sut.update(testCity);

		//Assert
		City retrievedCity = sut.findCityById(testCity.getId());
		assertCitiesAreEqual(testCity, retrievedCity);

	}

	@Test
	public void city_is_deleted() {
		//Arrange
		City testCity = createTestCity();
		sut.create(testCity);
		Long id = testCity.getId();

		//Act
		sut.delete(testCity.getId());

		//Assert
		City retrievedCity = sut.findCityById(id);
		Assert.assertNull(retrievedCity);
	}

	@Test public void all_cities_for_country_code_are_found() {
		//Arrange
		for (int i = 0; i < 100; i++) {
			City testCity = createTestCity();
			testCity.setName("Test City " + i);
			testCity.setPopulation(i);
			sut.create(testCity);
		}

		//Act
		List<City> results = sut.findCityByCountryCode(TEST_COUNTRY);

		//Assert
		Assert.assertEquals(100, results.size());
		for (int i = 0; i < 100; i++) {
			City testCity = results.get(i);
			Assert.assertEquals("Test City " + i, testCity.getName());
			Assert.assertEquals(i, testCity.getPopulation());
		}
	}

	@Test
	public void all_cities_for_district_are_found() {
		//Arrange
		List<City> citiesInDistrict = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			City testCity = createTestCity();
			testCity.setName("Test City " + i);
			testCity.setDistrict("Target District");
			citiesInDistrict.add(testCity);
			sut.create(testCity);
		}
		sut.create(createTestCity()); //add city not in target district

		//Act
		List<City> results = sut.findCityByDistrict("Target District");

		//Assert
		Assert.assertEquals(50, results.size());
		for (City expected : citiesInDistrict) {
			boolean cityFound = false;
			for (City actual : results) {
				if (expected.getName().equals(actual.getName())) {
					cityFound = true;
					break;
				}
			}
			Assert.assertTrue(cityFound);
		}
	}
	private City createTestCity() {
		City testCity = new City();
		testCity.setName("Testville");
		testCity.setDistrict("Test District");
		testCity.setPopulation(1);
		testCity.setCountryCode(TEST_COUNTRY);
		return testCity;
	}

	private void assertCitiesAreEqual(City expected, City actual) {
		Assert.assertEquals(expected.getName(), actual.getName());
		Assert.assertEquals(expected.getDistrict(), actual.getDistrict());
		Assert.assertEquals(expected.getPopulation(), actual.getPopulation());
		Assert.assertEquals(expected.getCountryCode(), actual.getCountryCode());
	}

}
