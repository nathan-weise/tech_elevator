package com.techelevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FizzWriterWorkstation {

    public static void main(String[] args) {

        int fizzBuzzNumber = 0;
        int number = 0;

        String line = "";
        List<String> fizzBuzzList = new ArrayList<>();


        try (PrintWriter destinationWriter = new PrintWriter("FizzBuzz.txt")) {

            for (int i = 0; i < 300; i++) {
                number = number + 1;
                String numberAsString = Integer.toString(number);
                if (number % 3 == 0 && number % 5 == 0) {
                    destinationWriter.println("FizzBuzz");
                    fizzBuzzList.add("FizzBuzz");
                }else if (numberAsString.contains("3")) {
                    destinationWriter.println("Fizz");
                    fizzBuzzList.add("Fizz");
                }else if (numberAsString.contains("5")) {
                    destinationWriter.println("Buzz");
                    fizzBuzzList.add("Buzz");
                } else if (number % 3 == 0) {
                    destinationWriter.println("Fizz");
                    fizzBuzzList.add("Fizz" );
                } else if (number % 5 == 0) {
                    destinationWriter.println("Buzz");
                    fizzBuzzList.add("Buzz");
                } else {
                    number = number;
                    destinationWriter.println(number);
                    line = Integer.toString(number);
                    fizzBuzzList.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

            // PrintWriter destinationWriter = new PrintWriter("FizzBuzz.txt")) {

            //      while (list.hasNextLine()) {
            //          String line = sourceScanner.nextLine();
            //          destinationWriter.println(line);
        }


    }
}

