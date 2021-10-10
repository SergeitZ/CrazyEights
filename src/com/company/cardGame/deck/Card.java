package com.company.cardGame.deck;

public abstract class Card {
    protected int rank;
    protected String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {return rank;}
    public String getSuit() {return suit;}

    public abstract String display();

}
