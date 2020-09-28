package com.techelevator;


import com.techelevator.playingcards.Card;
import com.techelevator.playingcards.Deck;

public class Lecture {

    public static void main(String[] args) {

        Card myCard = new Card("Hearts");
        myCard.setRank("Ace");

        System.out.println(myCard.getSuit());

        myCard.setFaceUp(true);
        Card yourCard = new Card();

        yourCard.setSuit("Spades");
        yourCard.setRank("Jack");

        if (myCard.isFaceUp()) {
            System.out.println("My cad is face up");
        } else {
            System.out.println("My card is face down.");
        }

        System.out.println(myCard.getName());
        System.out.println(yourCard.getName());

        System.out.println("My card has a value of " + myCard);

        System.out.println("-------WAR-------");
        Deck myDeck = new Deck();
        myDeck.shuffle();
        myCard = myDeck.drawCard();
        System.out.println(myCard);
        yourCard = myDeck.drawCard();
        System.out.println(yourCard);

    }
}
