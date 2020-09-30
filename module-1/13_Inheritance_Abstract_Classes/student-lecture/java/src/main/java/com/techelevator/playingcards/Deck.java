package com.techelevator.playingcards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static final String[] ALL_SUITS = new String[] {"Hearts", "Clubs","Spades","Diamonds"};
    private static final String[] ALL_RANKS = new String[]
            {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};

    private List<Card> cardsInDeck = new ArrayList<>();

    public Deck() {
        for (String suit : ALL_SUITS) {
            for (String rank :ALL_RANKS) {
                Card c = new Card(suit, rank);
                cardsInDeck.add(c);
            }
        }
    }

    public Card drawCard() {
        Card drawnCard = cardsInDeck.remove(0);
        return drawnCard;
    }

    public void shuffle() {
        Collections.shuffle(cardsInDeck);
    }



}
