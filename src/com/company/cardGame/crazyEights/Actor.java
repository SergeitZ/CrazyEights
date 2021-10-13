package com.company.cardGame.crazyEights;

import com.company.cardGame.deck.Card;

import java.util.List;

public interface Actor {

    String getName();
    int getAction(Card topcard);
    int pickHandCard(List<Card> cards);
}
