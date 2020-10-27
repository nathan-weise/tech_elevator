package com.techelevator;

import com.techelevator.hotels.models.Hotel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class RestTemplateDemo {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        //DELETE
        try {
            restTemplate.delete("http://localhost:3000/hotels/7");
        } catch (ResourceAccessException e) {
            System.out.println("Connect to server...");
        } catch (RestClientResponseException e) {
            System.out.println("Couldn't delete that thing...");
        }

        //UPDATE
        Hotel hotelToUpdate = restTemplate.getForObject("http://localhost:3000/hotels/3", Hotel.class);
        hotelToUpdate.setRoomsAvailable(0);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Hotel> entity = new HttpEntity<>(hotelToUpdate, headers);
        restTemplate.put("http://localhost:3000/hotels/3", entity);

        //CREATE
        Hotel newHotel = new Hotel();
        newHotel.setName("The Haunted Hotel");
        newHotel.setRoomsAvailable(666);
        newHotel.setStars(3);
        newHotel.setCoverImage("creepy.png");
        entity = new HttpEntity<>(newHotel, headers);
        newHotel = restTemplate.postForObject("http://localhost:3000/hotels", entity, Hotel.class);
        System.out.println(newHotel);
    }
}
