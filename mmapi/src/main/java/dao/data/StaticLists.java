package dao.data;

import dao.model.Character;
import dao.model.Media;

import java.util.ArrayList;
import java.util.List;

public class StaticLists {

    public static final List<Character> characters = new ArrayList<>(List.of(
            new Character(1, "Hannibal Lecter", new ArrayList<>(List.of("Psychiatrist", "Cannibal")), true,"","", 1),
            new Character(2, "Le Chiffre", new ArrayList<>(List.of("Terrorist", "Poker gambler")), false,"", "", 2),
            new Character(3, "Cliff Unger", new ArrayList<>(List.of("Captain", "PT", "Father")), false, "", "", 3),
            new Character(4, "Galen Erso", new ArrayList<>(List.of("Scientist", "Father")), false, "", "", 4)
    ));
    public static final List<Media> media = new ArrayList<>(List.of(
            new Media(1, "Hannibal", "Serie", "", 2013),
            new Media(2, "Casino Royale", "Movie", "", 2006),
            new Media(3, "Death Stranding", "Videogame", "", 2019),
            new Media(4, "Rogue One", "Movie", "", 2016),
            new Media(5, "Indiana Jones 5", "Movie", "", 2023),
            new Media(6, "Doctor Strange", "Movie", "", 2016),
            new Media(7, "At Eternity's Gate", "Movie", "", 2018),
            new Media(8, "The Hunt (Jagten)", "Movie", "", 2012),
            new Media(9, "Another Round (Druk)", "Movie", "", 2020),
            new Media(10, "Pusher I", "Movie", "", 1996)
    ));


}
