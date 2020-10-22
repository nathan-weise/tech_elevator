package com.techelevator;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JdbcCityDAO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class DAOExample {


    public static void main(String[] args) {

        BasicDataSource worldDataSource = new BasicDataSource();
        worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
        worldDataSource.setUsername("postgres");
        worldDataSource.setPassword("postgres1"); //Don't make this a habit--use an environment variable or external config file.

        CityDAO cityDAO = new JdbcCityDAO(worldDataSource);

//        for (int i = 100; i < 300; i++) {
//            City myCity = cityDAO.findCityById(i);
//            System.out.println(myCity.getName() + " " + myCity.getPopulation());
//        }

        List<City> usaCities = cityDAO.findCityByCountryCode("USA");
        for (City c : usaCities) {
            System.out.println(c.getName() + ", " + c.getDistrict());
        }

        List<City> ohioCities = cityDAO.findCityByDistrict("Ohio");
        for (City c : ohioCities) {
            System.out.println(c.getName() + ", " + c.getDistrict());
        }

        City wuhan = cityDAO.findCityById(1894);
        wuhan.setPopulation(12_000_000);
        cityDAO.update(wuhan);

        City norwood = new City();
        norwood.setName("Norwood");
        norwood.setDistrict("Ohio");
        norwood.setCountryCode("USA");
        norwood.setPopulation(20_000);
        cityDAO.create(norwood);
        System.out.println("Norwood created with id: " + norwood.getId());
        cityDAO.delete(norwood.getId());
    }
}
