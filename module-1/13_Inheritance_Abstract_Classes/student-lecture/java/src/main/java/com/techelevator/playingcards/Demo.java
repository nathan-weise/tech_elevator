package com.techelevator.playingcards;

public class Demo {

    public static void main(String[] args) {
        Deck myDeck = new Deck();
        myDeck.shuffle();
        Card first = myDeck.drawCard();
        Card second = myDeck.drawCard();
        first.flip();
        second.flip();
        System.out.println("Cards drawn: " + first + " and " + second);

        Card weirdCard = new Card(Suit.HEARTS, "Thirty-Three");

        Card ace = new Card(Suit.SPADES, "Ace");
    }
}
