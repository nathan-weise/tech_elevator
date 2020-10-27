package com.techelevator;

public class Dog {

    String dogName;
    final String dogBread;

    public Dog(String dogBread, String dogName) {
        this.dogBread = dogBread;
        this.dogName = dogName;

        System.out.println("The " + dogBread + " is named " + dogName + "!" );


    }

    public static void main(String[] args) {

        Dog a1 = new Dog("Lab", "Max");

        a1.dogName = "Fred";

        Dog a2 = new Dog("Golden Retriever", "Buddy");

        Dog a3 = new Dog("Rottweiler", "Frank");

        Dog a4 = new Dog("Beagle", "Humphrey");

        Dog a5 = new Dog("Akita", "George");

    }
}
