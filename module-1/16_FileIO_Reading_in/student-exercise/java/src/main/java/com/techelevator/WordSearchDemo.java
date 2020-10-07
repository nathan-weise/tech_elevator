package com.techelevator;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WordSearchDemo {

    public static void main(String[] args) {

        String userInputFile;
        String userInputWord;
        String userWord = "";
        String userInputCase = "";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("What is the file that should be searched? ");
            userInputFile = scanner.nextLine();
            System.out.print("What is the search word you are looking for? ");
            userInputWord = scanner.nextLine();
            System.out.print("Should the search be case sensitive (Y/N)? ");
            userInputCase = scanner.nextLine();
        }

        boolean userInputCaseResult;
        if (userInputCase.equals("Y")) {
            userInputCaseResult = true;
        } else {
            userInputCaseResult = false;
        }
        if (!userInputCaseResult) {
            userWord = userInputWord.toLowerCase();
        } else {
            userWord = userInputWord;
        }

        Path input = Paths.get(userInputFile);
        try (Scanner fileInput = new Scanner(input)) {
            int lineNumber = 1;
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                if (line.indexOf(userWord) > 0) {
                   System.out.println(lineNumber + ") " + line);
                }
                lineNumber += 1;
            }
        } catch (NoSuchFileException e) {
            System.out.print("File named " + '"' + userInputFile + '"' + " does not exist.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
