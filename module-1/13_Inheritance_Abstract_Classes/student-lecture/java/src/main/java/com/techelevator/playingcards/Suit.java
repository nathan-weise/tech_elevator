package com.techelevator.playingcards;

public class Suit {

    public static final Suit HEARTS = new Suit("HeartS");
    public static final Suit CLUBS = new Suit("Clubs");
    public static final Suit SPADES = new Suit("Spades");
    public static final Suit DIAMONDS = new Suit("Diamonds");

    public static final Suit[] ALL_SUITS = new Suit[] {HEARTS, CLUBS, SPADES, DIAMONDS};

    private final String name;

    public Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
