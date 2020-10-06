package com.techelevator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class LetterGenerator {

    public static void main(String[] args) {

        Path outputDirectory = Paths.get("letters");
        try {
            Files.createDirectory(outputDirectory);
        } catch (FileAlreadyExistsException e) {
            System.out.println("Using existing directory for output.");
        } catch (IOException e) {
            System.out.println("No place to put the letter files.");
            System.exit(-1);
        }

        List<String> myFriends = new ArrayList<>();
        myFriends.add("Christopher");
        myFriends.add("Sam");
        myFriends.add("Kurt");
        myFriends.add("Stephanie");

        for (String friend : myFriends) {

            try (PrintWriter writer = new PrintWriter("letters/" + friend + ".txt")) {
                FormLetter letter = new FormLetter(friend, "Good luck on today's assignment!");
                writer.println(letter.toString());
                writer.println("PS: You can do it!");
            } catch (IOException e) {
                System.out.println("Error while writing out letters.");
            }

        }


    }
}
