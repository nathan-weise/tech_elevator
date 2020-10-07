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
        try (Scanner sourceScanner = new Scanner(sourcePath); //Scanner will read lines from the source file
             PrintWriter destinationWriter = new PrintWriter(destination)) { //PrintWriter will write lines to the destination file

            while (sourceScanner.hasNextLine()) { //Loop through all the lines of the source file.
                String line = sourceScanner.nextLine();  //Read a line from the source file.
                //line = line.toUpperCase(); //Here's where could alter the line.
                destinationWriter.println(line);        //Write that line out to the destination file.
            }

        } catch (IOException exception) {
            System.out.println("Something went wrong.");
        }
    }

    public static void main(String[] args) {
        SimpleCopier myCopier = new SimpleCopier("demo/example.txt", "demo/output.txt");
        myCopier.makeCopy();
        System.out.println("File was copied.");
    }


}
