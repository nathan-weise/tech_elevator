package com.techelevator.reservations.models;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.*;

public class Reservation {

    @Autowired
    private HotelDAO hotelDAO;

    private int id;
    @Min(value = 1, message = "Hotel ID needed.")
    private int hotelID;
    @NotBlank(message = "The fullName field is required.")
    private String fullName;
    @NotBlank(message = "Check in date needed.")
    private String checkinDate;
    @NotBlank(message = "Check out date needed.")
    private String checkoutDate;
    @Min(value = 1, message = "Why zero?")
    @Max(value = 5, message = "No parties bro.")
    private int guests;

    @AssertTrue(message = "Hotel doesn't exist.")
    private boolean getHotelIdIsValid() {
        for (Hotel hotel : hotelDAO.list()) {
            if (hotel.getId() == hotelID) {
                return true;
            }
        }
        return false;
    }

    public Reservation() {
        this.hotelDAO = new MemoryHotelDAO();
    }

    public Reservation(int id, int hotelID, String fullName, String checkinDate, String checkoutDate, int guests) {
        this.id = id;
        this.hotelID = hotelID;
        this.fullName = fullName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guests = guests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" + "\n Reservation Details"
                + "\n--------------------------------------------" + "\n Id: " + id + "\n Hotel Id: " + hotelID
                + "\n Full Name: " + fullName + "\n Checkin Date: " + checkinDate + "\n Checkout Date: " + checkoutDate
                + "\n Guests: " + guests;
    }
}
