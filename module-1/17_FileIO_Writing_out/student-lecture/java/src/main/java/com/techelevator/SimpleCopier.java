package com.techelevator;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SimpleCopier {

    private String source;
    private String destination;

    public SimpleCopier(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public void makeCopy() {
        Path sourcePath = Paths.get(source); //Need this for the Scanner
        try (Scanner sourceScanner = new Scanner(sourcePath);
             PrintWriter destinationWriter = new PrintWriter(destination)) {

            while (sourceScanner.hasNextLine()) {
                String line = sourceScanner.nextLine();
                destinationWriter.println(line);
        }


    } catch (IOException exception) {
        System.out.println("Could't read from source file");
    }

}
