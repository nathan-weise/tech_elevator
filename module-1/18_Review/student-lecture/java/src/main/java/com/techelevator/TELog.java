package com.techelevator;

import com.techelevator.util.TELogException;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TELog {

    public static void log(String message) {
        try (FileOutputStream stream = new FileOutputStream("logs/search.log", true);
             PrintWriter writer = new PrintWriter(stream)) {

            writer.println(message);

        } catch (Exception e) {
            throw new TELogException(e.getMessage());
        }

    }

}
