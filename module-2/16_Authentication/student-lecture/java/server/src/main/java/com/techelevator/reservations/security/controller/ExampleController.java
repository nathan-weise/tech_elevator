package com.techelevator.reservations.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class ExampleController {

    @GetMapping("/greeting")
    @PreAuthorize("isAuthenticated()")
    public String sayHello(Principal principal) {
        return "Hello " + principal.getName();
    }
}
