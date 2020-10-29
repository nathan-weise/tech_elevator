package com.techelevator.reservations.diexample;

import org.springframework.stereotype.Component;

@Component
public class Alex implements Person {
    @Override
    public String getName() {
        return "Alex";
    }
}
