package org.example;

public class Card {

    protected String suit;
    protected String symbol;
    protected int value;

    /**
     *
     * @param suit
     * @param symbol
     * @param value
     */
    public Card(String suit, String symbol, int value){
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.symbol + this.suit;
    }

    ///Getters
    public String getSuit() {
        return this.suit;
    }
    public String getSymbol() {
        return this.symbol;
    }
    public int getValue() {
        return this.value;
    }

    ///Setters
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
