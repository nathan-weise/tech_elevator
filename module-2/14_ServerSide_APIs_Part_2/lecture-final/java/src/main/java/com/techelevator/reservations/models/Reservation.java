package com.techelevator.reservations.models;

import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;


import javax.validation.constraints.*;

public class Reservation {

    private HotelDAO hotelDAO;

    private int id;
    @Min(value = 1, message = "The hotelID field is required.")
    private int hotelID;
    @NotBlank(message = "The fullName field is required.")
    private String fullName;
    @NotBlank(message = "You must specify a checkinDate.")
    private String checkinDate;
    @NotBlank(message = "You must specify a checkoutDate.")
    private String checkoutDate;
    @Min(value = 1, message = "The minimum number of guests is 1.")
    @Max(value = 5, message = "The maximum number of guests is 5.")
    private int guests;

    @AssertTrue(message = "That hotel id doesn't exist.")
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
