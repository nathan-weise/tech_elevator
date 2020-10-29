package com.techelevator.reservations.diexample;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private Person person;

    public ExampleController(Person injectedPerson) {
        person = injectedPerson;
    }


    @GetMapping("/greeting")
    public String sendGreeting() {
        return "Hello from " + person.getName();
    }


}
