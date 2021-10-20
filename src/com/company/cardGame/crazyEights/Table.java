package com.company.cardGame.crazyEights;

import com.company.Color;
import com.company.Console;
import com.company.cardGame.actor.Names;
import com.company.cardGame.actor.Player;
import com.company.cardGame.deck.Card;
import com.company.cardGame.deck.Deck;
import com.company.cardGame.deck.PlayingCard;
import com.company.cardGame.deck.StandardDeck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO: Create an NPC player

public class Table {
    List<Hand> hands = new ArrayList<>();
    List<Card> discardPile = new ArrayList<>();
    Deck deck;
    Names names = new Names();

    public Table () {
        System.out.println("Crazy Eights");
        addPlayer();
    }

    public void addPlayer() {
        int playerCount = Console.getInt("How many players?", 1, 6, "Invalid entry");
        for (int count = 0; count < playerCount; count++) {
            Player newPlayer = new Player(names.nameGenerator());
            hands.add(new Hand(newPlayer));
        }
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

    private void turn() {
        for (Hand player : hands) {
            System.out.println(Color.CYAN_BOLD + player.getName() + Color.RESET);
            player.displayHand();
            int action = player.getAction(discardPile.get(discardPile.size() -  1));
            switch (action) {
                case 1 -> drawCard(player);
                case 2 -> validateCard(player);
            }
            determineWinner(player);
        }
        System.out.println(discardPile.get(discardPile.size() -  1).display());
    }

    public void drawCard(Hand player) {
        player.addCard(deck.draw());
    }

    public void validateCard(Hand player) {
        System.out.println("\nActive card: " + discardPile.get(discardPile.size() - 1).display());
        int index = player.pickHandCard() - 1;
        Card removedCard = player.removeCard(index);
        Card activeCard = discardPile.get(discardPile.size() -  1);
        if (removedCard.getSuit().equals(activeCard.getSuit()) ||
                removedCard.getRank() == activeCard.getRank() ||
                removedCard.getRank() == 8) {
            if (removedCard.getRank() == 8) {
                int cardSuit = Console.getInt("Select next card's suit: " + Arrays.toString(StandardDeck.SUITS), 1,StandardDeck.SUITS.length, player.getSlap());
                playCard(new PlayingCard(8, StandardDeck.SUITS[cardSuit - 1]));
            } else {
                playCard(removedCard);
            }
        } else {
            player.addCard(removedCard);
            if (Console.getInt("Invalid card, would you like to draw?\n1) Yes\n2) No", 1, 2, "Invalid Selection") == 1) {
                drawCard(player);
            } else {
                validateCard(player);
            }
        }
    }

    public void determineWinner(Hand player) {
        if (player.size() == 0) {
            System.out.println(player.getName() + " Wins!!");
            System.exit(0);
        }
    }

    public void playCard(Card removedCard) {
        discardPile.add(removedCard);
    }
}
