package com.techelevator.reservations.dao;

import com.techelevator.reservations.models.Address;
import com.techelevator.reservations.models.Hotel;

import java.util.ArrayList;
import java.util.List;

public class MemoryHotelDAO implements HotelDAO {

    private static final List<Hotel> allHotels = setupHotels();

    @Override
    public Hotel get(int id) {
        for (Hotel hotel : allHotels) {
            if (hotel.getId() == id) {
                return hotel;
            }
        }
        return null;
    }

    @Override
    public List<Hotel> list() {
        return allHotels;
    }

    @Override
    public void create(Hotel hotel) {
        allHotels.add(hotel);
    }


    private static List<Hotel> setupHotels() {
        List<Hotel> result = new ArrayList<>();
        result.add(new Hotel(1,
                "Aloft Cleveland",
                new Address("1111 W 10th St","","Cleveland","Ohio","44115"),
                4,
                48,274));
        result.add(new Hotel(2,
                "Hilton Cleveland Downtown",
                new Address("100 Lakeside Ave","","Cleveland","Ohio","44114"),
                4,
                12,287));
        result.add(new Hotel(3,
                "Metropolitan at the 9",
                new Address("2017 E 9th St","","Cleveland","Ohio","48226"),
                5,
                22,319));
        result.add(new Hotel(4,
                "The Westin Pittsburgh",
                new Address("1000 Penn Ave","","Pittsburgh","Pennsylvania","15222"),
                4,
                60,131));
        result.add(new Hotel(5,
                "Hilton Columbus Downtown",
                new Address("401 N High St","","Columbus","Ohio","43215"),
                4,
                34,190));
        result.add(new Hotel(6,
                "The Summit A Dolce Hotel",
                new Address("5345 Medpace Way","","Cincinnati","Ohio","43215"),
                4,
                43,218));
        result.add(new Hotel(7,
                "Greektown Detroit",
                new Address("1200 St Antoine St","","Detroit","Michigan","48226"),
                4,
                75,185));

        return result;
    }
}
