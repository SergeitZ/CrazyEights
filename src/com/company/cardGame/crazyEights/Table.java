package com.company.cardGame.crazyEights;

import com.company.cardGame.actor.Player;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;

import java.util.ArrayList;
import java.util.List;

public class Table {
    List<Hand> hands = new ArrayList<>();
    Deck deck;

    public Table () {
        addPlayer();
    }

    public void playRound() {
        deck = new StandardDeck();
        deck.shuffle();
        for (int count = 0; count < 5; count++) {
         hands.forEach(hand -> hand.addCard(deck.draw()));
        }
        hands.forEach(Hand::displayHand);
    }

    public void addPlayer() {
        hands.add(new Hand(new Player("Sergio")));
    }

}
