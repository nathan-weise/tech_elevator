package com.techelevator;


import com.techelevator.playingcards.Card;
import com.techelevator.playingcards.Deck;

public class Lecture {

    public static void main(String[] args) {

        Card myCard = new Card("Hearts");

        System.out.println(myCard.getSuit());

        myCard.setFaceUp(true);
        Card yourCard = new Card();
        System.out.println(yourCard.getSuit());

        myCard.flip();
        myCard.flip();
        myCard.flip();
        myCard.flip();
        myCard.flip();

        if (myCard.isFaceUp()) {
            System.out.println("My card is face up.");
        } else {
            System.out.println("My card is face down.");
        }


        System.out.println(myCard.getName());
        System.out.println(yourCard.getName());

        System.out.println("My card has a value of " + myCard.getValue());

        if (myCard.isHigherThan(yourCard)) {
            System.out.println("I win.");
        } else {
            System.out.println("You win");
        }

        Card anotherCard = new Card("Clubs", "King");

        Card jaredsCard = new Card();
        if (jaredsCard.isHigherThan("Two")) {
            System.out.println("Jared beat the deuce.");
        }

        yourCard.flip();
        System.out.println("My card is " + myCard);
        System.out.println("Your card is " + yourCard);

        Card firstQueen = new Card("Diamonds", "Queen");
        Card secondQueen = new Card("Diamonds", "Queen");
        if (firstQueen.equals(secondQueen)) {
            System.out.println("Queens match!");
        } else {
            System.out.println("No match.");
        }

        final int studentsInJava = 20;
        //studentsInJava += 1; //Not allowed!

        System.out.println("Number of cards created = " + Card.getCreatedCount());

        System.out.println("-------WAR-------");
        Deck myDeck = new Deck();
        myDeck.shuffle();
        myCard = myDeck.drawCard();
        myCard.flip();
        System.out.println("My card is: " + myCard);
        yourCard = myDeck.drawCard();
        yourCard.flip();
        System.out.println("Your card is: " + yourCard);
        if (myCard.isHigherThan(yourCard)) {
            System.out.println("I win!");
        } else {
            System.out.println("You win...this time.");
        }

    }
}
