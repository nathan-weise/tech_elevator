package com.techelevator.readfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class FileReader {


    public static void main(String[] args) {
        //Two ways to represent a file:
        File myFile = new File("input.txt"); //Older style, can convert to Path with .toPath()
        Path myPath = Paths.get("input.txt");    //Newer style, can convert to File with .toFile()

        Scanner userInput = new Scanner(System.in);

        try (Scanner fileInput = new Scanner(myPath)) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not open file.");
        }


    }

}
