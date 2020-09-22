package com.techelevator;

import java.util.Scanner;

public class AverageCalculator {


    public static void main(String[] args) {
        System.out.println("Welcome to the Average Calculator!");
        boolean finished = false;
        while (!finished) {

            System.out.print("Please enter some numbers: ");

            Scanner input = new Scanner(System.in);
            String numbers = input.nextLine();

            String[] splitNumbers = numbers.split(" ");

            double[] actualNumbers = new double[splitNumbers.length];

            for (int i = 0; i < splitNumbers.length; i++) {
                actualNumbers[i] = Integer.parseInt(splitNumbers[i]);
            }

            double total = 0;
            for (int i = 0; i < actualNumbers.length; i++) {
                total += actualNumbers[i];
            }
            double average = total / actualNumbers.length;
            System.out.format("The average is: %.1f\n", average);

            System.out.print("Are you finished (yes/no)?");
            String answer = input.nextLine();
            finished = answer.equals("yes");
        }
    }

}
