package com.techelevator;

import java.text.Normalizer;

public class FormLetter {

    private String recipient;
    private String message;

    public FormLetter(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Dear " + recipient + ",\n" + message + "\nSincerely yours,\nMe";
    }
}
