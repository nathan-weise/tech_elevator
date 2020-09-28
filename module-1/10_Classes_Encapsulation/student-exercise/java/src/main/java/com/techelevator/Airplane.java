package com.techelevator;

public class Airplane {

    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int availableFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;
    private int availableCoachSeats;



    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
        availableFirstClassSeats = totalFirstClassSeats;
        availableCoachSeats = totalCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {

        if (forFirstClass) {
            if (availableFirstClassSeats >= totalNumberOfSeats) {
                bookedFirstClassSeats = bookedFirstClassSeats + totalNumberOfSeats;
                return true;
            }
        }
        if (!forFirstClass) {
            if (availableCoachSeats >= totalNumberOfSeats) {
                bookedCoachSeats = bookedCoachSeats + totalNumberOfSeats;
                return true;
            }
        }
        return false;
    }
}
