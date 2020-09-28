package com.techelevator.playingcards;

import java.util.HashMap;
import java.util.Map;

public class Card {

    private String suit;
    private String rank;
    private Boolean faceUp = false;

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
        setSuit("Spades");
        setRank("Ace");
    }
    public Card(String suit) {
        setSuit(suit);
        setRank("Ace");
    }
    public Card(String suit, String rank) {
        setSuit(suit);
        setRank(rank);
    }

    public String getSuit() {
        return suit;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) {
        this.rank = rank;
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
        } //setFaceUp(!isFaceUp))); // another option
    }
    public int getValue() {
        return rankValues.get(getRank());
    }
    public boolean isHigherThan(Card otherCard) {
        return getValue() > otherCard.getValue();
    }
}


