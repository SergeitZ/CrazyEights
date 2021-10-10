package com.company.cardGame.deck;

public class PlayingCard extends Card {
    public PlayingCard(int rank, String suit) {
        super(rank, suit);
    }

    @Override
    public String display() {
        String output;
        switch (rank) {
            case 0 -> output = "JR"; //joker
            case 1 -> output = "AC";
            case 11 -> output = "JA";
            case 12 -> output = "QU";
            case 13 -> output = "KI";
            default -> output = rank == 10 ? Integer.toString(rank) : " " + rank;
        }
        return output + suit;
    }
}
