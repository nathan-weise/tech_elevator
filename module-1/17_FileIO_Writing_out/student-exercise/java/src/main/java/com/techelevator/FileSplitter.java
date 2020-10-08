package com.techelevator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		System.out.println("Where is the input file (please include the path to the file)? ");
		String inputFile = userInput.nextLine();

		System.out.println("How many lines of text (max) should there be in the split files? ");
		String inputMaxLines = userInput.nextLine();
		int maxLines = Integer.parseInt(inputMaxLines);
		int lineCounter = 0;
		String line;
		int loopCounter = 1;
		int filesNeeded = 0;
		int fileNameBreak = inputFile.indexOf(".");
		String fileName1 = inputFile.substring(0, fileNameBreak);
		String fileName2 = inputFile.substring(fileNameBreak);

		Path file = Paths.get(inputFile);
		try (Scanner fileScanner = new Scanner(file)) {

			while (fileScanner.hasNextLine()) {
				PrintWriter fileWriter = new PrintWriter(fileName1 + "-" + loopCounter + fileName2);

				for (int i = 0; i < maxLines && fileScanner.hasNextLine(); i++) {
					line = fileScanner.nextLine();
					fileWriter.println(line);
					//lineCounter = lineCounter + 1;
				}
				fileWriter.close();
				loopCounter = loopCounter + 1;
			}
			System.out.println("Your file has been split!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}



