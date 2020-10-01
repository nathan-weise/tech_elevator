package com.techelevator.playingcards;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private static final Suit DEFAULT_SUIT = Suit.SPADES;
    private static final String DEFAULT_RANK = "Ace";

    private static int createdCount;

    private final Suit suit;
    private final String rank;
    private boolean faceUp = false;

    private Map<String, Integer> rankValues = setupRankValues();
    private Map<String, Integer> setupRankValues() {
        Map<String, Integer> result = new HashMap<>();
        result.put("Ace", 1);
        result.put("Two", 2);
        result.put("Three", 3);
        result.put("Four", 4);
        result.put("Five", 5);
        result.put("Six", 6);
        result.put("Seven", 7);
        result.put("Eight", 8);
        result.put("Nine", 9);
        result.put("Ten", 10);
        result.put("Jack", 11);
        result.put("Queen", 12);
        result.put("King", 13);
        return result;
    }

    public Card() {
        this(DEFAULT_SUIT, DEFAULT_RANK);
    }

    public Card(Suit suit) {
        this(suit, DEFAULT_RANK);
    }

    public Card(Suit suit, String rank) {
        this.suit = suit;
        this.rank = rank;

        createdCount++;
    }

    public static int getCreatedCount() {
        return createdCount;
    }


    public Suit getSuit() {
        return suit;
    }



    public String getRank() {
        return rank;
    }



    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public String getName() {
        return getRank() + " of " + getSuit();
    }

    public void flip() {
        if (isFaceUp()) {
            setFaceUp(false);
        } else {
            setFaceUp(true);
        }
        //setFaceUp(!isFaceUp()); //another option
    }

    public int getValue() {
        return rankValues.get(getRank());
    }

    public boolean isHigherThan(Card otherCard) {
        return this.getValue() > otherCard.getValue();
    }

    public boolean isHigherThan(String rank) {
        return this.getValue() > rankValues.get(rank);
    }

    public String toString() {
        if (isFaceUp()) {
            return getName();
        } else {
            return "Face Down Card";
        }
    }

    public boolean equals(Object otherObject) {
        boolean result = false;
        if (otherObject instanceof Card) {
            Card otherCard = (Card) otherObject;
            result = otherCard.getName().equals(this.getName());
        }
        return result;
    }


}
