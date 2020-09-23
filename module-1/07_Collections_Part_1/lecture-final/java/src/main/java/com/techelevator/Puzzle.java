package com.techelevator;


import java.util.Scanner;

public class Puzzle {

    public static void main(String[] args) {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        int half = alphabet.length() / 2;
        String rotated = alphabet.substring(half) + alphabet.substring(0, half);

        char[] output = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            int position = alphabet.indexOf(letter);
            if (position > -1) {
                output[i] = rotated.charAt(position);
            } else {
                output[i] = letter;
            }
        }
        System.out.println(new String(output));
    }
}
