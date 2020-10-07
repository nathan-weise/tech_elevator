package com.techelevator.exceptions;

public class WhileLoopExamples {

    public static void main(String[] args) {


        int i = 5;

       System.out.println("Before the while loop.");

       while (i > 0) {
           System.out.println("Java is amazing");
           i = i - 1;
       }

        do {
            System.out.println("Java is amazing.");
            i = i - 1;
        } while (i > 0);

            System.out.println("After the while loop.");
    }

}
