package com.techelevator.hotels.services;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class HotelService {

  private final String baseUrl;
  private final RestTemplate restTemplate = new RestTemplate();
  private final ConsoleService console = new ConsoleService();

  public HotelService(String url) {
    baseUrl = url;
  }

  /**
   * Create a new reservation in the hotel reservation system
   *
   * @param newReservation
   * @return Reservation
   */
  public Reservation addReservation(String newReservation) {
    Reservation reservation = makeReservation(newReservation);
    HttpHeaders headers = new HttpHeaders(); // adds to API
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Reservation> entity = new HttpEntity<>(reservation, headers); // package them into entity
    try {
      return restTemplate.postForObject(baseUrl + "reservations", entity, Reservation.class);
    } catch (ResourceAccessException | RestClientResponseException e) {
      return null;
    }
  }


  /**
   * Updates an existing reservation by replacing the old one with a new
   * reservation
   *
   * @param csv
   * @return
   */
  public Reservation updateReservation(String csv) {
    Reservation reservation = makeReservation(csv);
    HttpHeaders headers = new HttpHeaders(); // adds to API
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Reservation> entity = new HttpEntity<>(reservation, headers); // package them into entity
    try {
      restTemplate.put(baseUrl + "reservations/" + reservation.getId(), entity);
      return reservation;
    } catch (ResourceAccessException | RestClientResponseException e) {
      return null;
    }
  }

  /**
   * Delete an existing reservation
   *
   * @param id
   */
  public void deleteReservation(int id) {
    try {
      restTemplate.delete(baseUrl + "reservations/" + id);

    } catch (ResourceAccessException e) {
      System.out.println("Couldn't connect to server");
    } catch (RestClientResponseException e) {
      if (e.getRawStatusCode() == 404) {
        System.out.println("That reservation doesn't exist");
      } else {
        System.out.println("Something went wrong. Couldn't delete.");
      }
    }
  }

  /* DON'T MODIFY ANY METHODS BELOW */

  /**
   * List all hotels in the system
   *
   * @return
   */
  public Hotel[] listHotels() {
    Hotel[] hotels = null;
    try {
      hotels = restTemplate.getForObject(baseUrl + "hotels", Hotel[].class);
    } catch (RestClientResponseException ex) {
      // handles exceptions thrown by rest template and contains status codes
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      // i/o error, ex: the server isn't running
      console.printError(ex.getMessage());
    }
    return hotels;
  }

  /**
   * Get the details for a single hotel by id
   *
   * @param id
   * @return Hotel
   */
  public Hotel getHotel(int id) {
    Hotel hotel = null;
    try {
      hotel = restTemplate.getForObject(baseUrl + "hotels/" + id, Hotel.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return hotel;
  }

  /**
   * List all reservations in the hotel reservation system
   *
   * @return Reservation[]
   */
  public Reservation[] listReservations() {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(baseUrl + "reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * List all reservations by hotel id.
   *
   * @param hotelId
   * @return Reservation[]
   */
  public Reservation[] listReservationsByHotel(int hotelId) {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(baseUrl + "hotels/" + hotelId + "/reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * Find a single reservation by the reservationId
   *
   * @param reservationId
   * @return Reservation
   */
  public Reservation getReservation(int reservationId) {
    Reservation reservation = null;
    try {
      reservation = restTemplate.getForObject(baseUrl + "reservations/" + reservationId, Reservation.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservation;
  }

  private Reservation makeReservation(String CSV) {
    String[] parsed = CSV.split(",");

    // invalid input (
    if (parsed.length < 5 || parsed.length > 6) {
      return null;
    }

    // Add method does not include an id and only has 5 strings
    if (parsed.length == 5) {
      // Create a string version of the id and place into an array to be concatenated
      String[] withId = new String[6];
      String[] idArray = new String[] { new Random().nextInt(1000) + "" };
      // place the id into the first position of the data array
      System.arraycopy(idArray, 0, withId, 0, 1);
      System.arraycopy(parsed, 0, withId, 1, 5);
      parsed = withId;
    }

    return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
        parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
  }

}
