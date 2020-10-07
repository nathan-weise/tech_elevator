package com.techelevator.exceptions;

public class Program {

    public static void main(String[] args) {
        //A
        try {
            //B
            Employee newEmployee = new Employee("Mary", "Smith", -123);
            //C
        } catch (InvalidEmployeeIdException myException) {
            //Take appropriate action.
            //D
        }
        //E
    }
}
