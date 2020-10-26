package com.techelevator;

import com.techelevator.hotels.Hotel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateDemo {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response1 = restTemplate.getForEntity("http://localhost:3000/hotels/3", String.class);
        System.out.println(response1.getStatusCode());
        System.out.println(response1.getBody());

        ResponseEntity<Hotel> response2 = restTemplate.getForEntity("http://localhost:3000/hotels/3", Hotel.class);
        System.out.println(response2.getStatusCode());
        Hotel myHotel = response2.getBody();
        System.out.println(myHotel.getName());
        System.out.println(myHotel.getRoomsAvailable());

        myHotel = restTemplate.getForObject("http://localhost:3000/hotels/2", Hotel.class);
        System.out.println(myHotel.getName());
        System.out.println(myHotel.getRoomsAvailable());

    }
}
