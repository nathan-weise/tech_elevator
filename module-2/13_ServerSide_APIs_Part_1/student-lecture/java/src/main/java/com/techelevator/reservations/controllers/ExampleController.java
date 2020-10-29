package com.techelevator.reservations.controllers;

import com.techelevator.reservations.models.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/salutation")
public class ExampleController {

    @RequestMapping(path = "engish", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello from the Spring Framework!";
    }
    @RequestMapping(path = "espanol", method = RequestMethod.GET)
    public String sayHelloInSpanish() {
        return "Hola from the Spring Framework!";
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public String questionIntentions() {
        return "Why are you so hostile?";
    }

    @RequestMapping(path = "/location")
    public Address getAnAddress() {
        Address address = new Address("1600 Pennsylavania Ave", "Oval Office","Flavortown","Ohio","12345");
        return address;
    }


}
