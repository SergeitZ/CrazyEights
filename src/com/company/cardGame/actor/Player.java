package com.company.cardGame.actor;

import com.company.cardGame.crazyEights.Actor;

public class Player implements Actor {
    protected final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
