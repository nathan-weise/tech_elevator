package com.techelevator.readfiles;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WordCountDemo {

    public static void main(String[] args) {
        WordCounter wc = new WordCounter();
        int total = 0;
        Path input = Paths.get("alice.txt");
        try (Scanner fileInput = new Scanner(input)) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                total += wc.countWordsInLine(line);

            }
        } catch (IOException e) {
            wc.countWordsInLine("Can't find the file.");
        }
        System.out.println("Words in file: " + total);
    }

}
