package com.techelevator;

import java.util.Scanner;

public class Puzzle {

    public static void main(String[] args) {
        System.out.print("Please enter a number with several digits: ");
        Scanner userInput = new Scanner(System.in);
        String s = userInput.nextLine();

        for (long n = Long.parseLong(s); n > 0; n = n / 10) {
            System.out.print(n % 10);
        }
    }
}
