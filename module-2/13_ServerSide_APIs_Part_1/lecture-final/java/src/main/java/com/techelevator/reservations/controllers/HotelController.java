package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private final HotelDAO hotelDAO;
    private final ReservationDAO reservationDAO;

    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO();
        this.reservationDAO = new MemoryReservationDAO(hotelDAO);
    }

    @RequestMapping(path = "/hotels")
    public List<Hotel> getAllHotels(@RequestParam(defaultValue = "0", name = "star_rating") int starRating,
                                    @RequestParam(defaultValue = "true", name="has_rooms") boolean roomsAvailable) {
        //More code would need to be added to use roomsAvailable
        if (starRating == 0) {
            return hotelDAO.list();
        } else {
            List<Hotel> filteredList = new ArrayList<>();
            for (Hotel hotel : hotelDAO.list()) {
                if (hotel.getStars() == starRating) {
                    filteredList.add(hotel);
                }
            }
            return filteredList;
        }
    }

    @RequestMapping(path = "/hotels/{id}")
    public Hotel getHotel(@PathVariable int id) {
        return hotelDAO.get(id);
    }

    @RequestMapping(path = "/hotels/{hotelId}/reservations")
    public List<Reservation> getReservationsForHotel(@PathVariable int hotelId) {
        return reservationDAO.findByHotel(hotelId);
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    public Reservation createReservation(@RequestBody Reservation newReservation) {
        return reservationDAO.create(newReservation, newReservation.getHotelID());
    }

    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listAllReservations() {
        return reservationDAO.findAll();
    }

    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable  int id) {
        return reservationDAO.get(id);
    }

    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.PUT)
    public void updateReservation(@RequestBody Reservation updatedReservation, @PathVariable int id) {
        reservationDAO.update(updatedReservation);
    }

    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.DELETE)
    public void deleteReservation(@PathVariable int id) {
        reservationDAO.delete(id);
    }


}
