package org.example;

import java.util.ArrayList;

public class Player {

    protected ArrayList<Card> deck;
    protected String name;
    public Player(ArrayList<Card> deck, String name){
        this.deck = deck;
        this.name = name;
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }
    public String getName() {
        return this.name;
    }
}
