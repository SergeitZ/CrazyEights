package com.company.cardGame.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StandardDeck implements Deck {
    private List<Card> cards = new ArrayList<>();
    public final String[] SUITS = {"\u2664", "\u2665", "\u2666", "\u2667"};
    public final int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    public StandardDeck() {
        for (String suit : SUITS) {
            for (int val : VALUES) {
                cards.add(new PlayingCard(val, suit));
            }
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public Card draw() {
        return cards.remove(cards.size() - 1 );
    }

}