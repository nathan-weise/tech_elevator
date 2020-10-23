package com.techelevator;

import com.techelevator.city.City;
import com.techelevator.city.CityDao;
import com.techelevator.city.JdbcCityDao;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class Example {

    public static void main(String[] args) {

        SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/world");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        CityDao cityDao = new JdbcCityDao(dataSource);

        City badCity = new City();
        badCity.setName("Bad City");

        cityDao.update(badCity);

    }







}
