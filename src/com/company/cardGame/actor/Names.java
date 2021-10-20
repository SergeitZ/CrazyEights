package com.company.cardGame.actor;

import java.util.List;
import java.util.Random;

public class Names {
    private List<String> first = List.of(
            "Hidden",
            "Eagle",
            "Sharp",
            "Bloody",
            "Night",
            "Long",
            "Rising",
            "Sun",
            "Red",
            "Novice",
            "Bald",
            "Scarlet",
            "Short",
            "Shadow",
            "Flaming",
            "Dark",
            "Invisible",
            "Eye",
            "Fallen",
            "Moon",
            "White",
            "Ancient",
            "Light",
            "Secret",
            "Fiery",
            "Deadly");

    private List<String> last = List.of(
            "Vision",
            "Dagger",
            "Sword",
            "Wing",
            "Blade",
            "Shadow",
            "Knife",
            "Moon",
            "Eden",
            "NIght",
            "Saber",
            "Killer",
            "Secret",
            "Feather",
            "Sun",
            "Arrow",
            "Turkey",
            "Eagle",
            "Blood",
            "Light",
            "Demon",
            "Tomahawk",
            "Revelation",
            "Embers",
            "Novice");

    public String nameGenerator() {
        Random random = new Random();
        return first.get(random.nextInt(first.size())) + " " + last.get(random.nextInt(last.size()));
    }
}
