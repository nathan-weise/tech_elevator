package com.techelevator.readfiles;

public class WordCounter {

    public int countWordsInLine(String line) {
        line = line.trim();
        if (line.length() == 0) {
            return 0;
        } else {
            String[] words = line.split(" +");
            return words.length;
        }
    }

}
