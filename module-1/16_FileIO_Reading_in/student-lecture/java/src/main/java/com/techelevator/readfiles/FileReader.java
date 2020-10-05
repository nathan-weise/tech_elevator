package com.techelevator.readfiles;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReader {


    public static void main(String[] args) {
        //Two ways to represent a file:
        File myFile = new File("input.txt"); //Older style, can convert to Path with .toPath()
        Path myPath = Paths.get("input.txt");    //Newer style, can convert to File with .toFile()


    }

}
