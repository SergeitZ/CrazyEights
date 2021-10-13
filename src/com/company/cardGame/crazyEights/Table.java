package com.company.cardGame.crazyEights;

import com.company.Console;
import com.company.cardGame.actor.Player;
import com.company.cardGame.deck.Card;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.StandardDeck;

import java.util.ArrayList;
import java.util.List;

public class Table {
    List<Hand> hands = new ArrayList<>();
    List<Card> discardPile = new ArrayList<>();
    Deck deck;

    public Table () {
        addPlayer();

    }

    public void playRound() {
        deck = new StandardDeck();
        deck.shuffle();
        discardPile.add(deck.draw());
        for (int count = 0; count < 5; count++) {
         hands.forEach(hand -> hand.addCard(deck.draw()));
        }
        while (true) {
        turn();
        }
    }

    public void addPlayer() {
       int playerCount = Console.getInt("How many players?", 1, 6, "invalid player selection");
        for (int count = 0; count < playerCount; count++) {
            Player newPlayer = new Player("Player" + (count + 1));
            hands.add(new Hand(newPlayer));
        }
    }

    private void turn() {
        for (Hand player : hands) {
            System.out.println(player.getName());
            player.displayHand();
            int action = player.getAction(discardPile.get(discardPile.size() -  1));
            switch (action) {
                case 1 -> drawCard(player);
                case 2 -> discardCard(player);
            }
        }
        System.out.println(discardPile.get(discardPile.size() -  1).display());
    }

    public void drawCard(Hand player) {
        player.addCard(deck.draw());
    }

    public void discardCard(Hand player) {
        int index = player.pickHandCard() - 1;
        Card removedCard = player.removeCard(index);
        Card activeCard = discardPile.get(discardPile.size() -  1);
        if (removedCard.getSuit().equals(activeCard.getSuit()) || removedCard.getRank() == activeCard.getRank()) {
            discardPile.add(removedCard);
        } else {
            player.addCard(removedCard);
        }
    }
}
