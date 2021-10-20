package com.company.cardGame.crazyEights;

import com.company.cardGame.deck.Card;

import java.util.ArrayList;
import java.util.List;


public class Hand {
    private List<Card> cards = new ArrayList<>();
    private Actor player;
    private String slap = "Slap!!";

    public Hand(Actor player) {
        this.player = player;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void displayHand() {
        StringBuilder output = new StringBuilder();
        for (Card card : cards) {
            output.append(card.display()).append(" |");
        }
        System.out.println(output);
    }

    public Card removeCard(int index) {
        //take card at index of hand and return to the table
        return cards.remove(index);
    }

    public String getName() {
        return player.getName();
    }

    public int getAction(Card topCard) {
        return player.getAction(topCard);
    }

    public int pickHandCard() {
        return player.pickHandCard(cards);
    }

    public int size() { return cards.size(); }

    public String getSlap() {
        return slap;
    }
}
