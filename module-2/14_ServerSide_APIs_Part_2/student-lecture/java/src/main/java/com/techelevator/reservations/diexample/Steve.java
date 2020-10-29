package com.techelevator.reservations.diexample;


import org.springframework.stereotype.Component;

@Component
public class Steve implements Person {
    @Override
    public String getName() {
        return "Steve";
    }
}
