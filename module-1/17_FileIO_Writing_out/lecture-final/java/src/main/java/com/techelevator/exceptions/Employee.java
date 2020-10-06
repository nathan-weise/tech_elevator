package com.techelevator.exceptions;

import java.math.BigDecimal;

public class Employee {

    private String firstName;
    private String lastName;
    private int id;
    private BigDecimal annualSalary;

    public Employee(String firstName, String lastName, int id) throws InvalidEmployeeIdException {
        this.firstName = firstName;
        this.lastName = lastName;
        if (id > 0) {
            this.id = id;
        } else {
            throw new InvalidEmployeeIdException();
        }
    }
}
