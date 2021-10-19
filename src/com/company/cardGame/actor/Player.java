package com.company.cardGame.actor;

import com.company.Console;
import com.company.cardGame.crazyEights.Actor;
import com.company.cardGame.deck.Card;

import java.util.List;

public class Player implements Actor {
    protected final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAction(Card topCard) {
        //Display hand and value
        System.out.println("Active card: " + topCard.display() + "\n");
        return Console.getInt("1) Draw\n2) Play card", 1, 2, "Invalid entry");
    }

    @Override
    public int pickHandCard(List<Card> cardList) {
        cardList.forEach(card -> System.out.print(card.display() + " |"));
        System.out.println();
        return Console.getInt("Enter selection 1-" + cardList.size(), 1, cardList.size(), "Invalid entry");
    }
}
