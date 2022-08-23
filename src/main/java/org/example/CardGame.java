package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardGame {

    public static ArrayList<Card> cards = new ArrayList<>();
    public static String[] suits = {"♣", "♥", "♠", "♦"};

    public static String[] symbols = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public static int[] values = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    ///Populate card list
    public static ArrayList<Card> populateCardList() {
        for (int i = 0; i < 4; i++) { /// four rounds of 13 cards = 52
            for (int j = 0; j < values.length; j++) {
                Card currentCard = new Card(suits[i], symbols[j], values[j]);
                cards.add(currentCard);
                //System.out.println(currentCard.toString());
            }

        }
        //System.out.println(cards.size());
        return cards;
    }

    ///Deal card
    public Card dealCard(ArrayList<Card> cards, int i) {
        if (i < 52) {
            return cards.get(i);
        }
        return null;
    }

    ///Sort / shuffle cards
    public static void sortCards(CardSorting cardSort) {
        switch (cardSort) {
            case bySuit:
                Collections.sort(cards, (a, b) -> {
                    return (a.getSuit().compareTo(b.getSuit()));
                });
                break;
            case byValue:
                Collections.sort(cards, (a, b) -> {
                    return a.getValue() - b.getValue();
                });
                break;
            case shuffle:
                Collections.shuffle(cards);
                break;
        }
//        for (Card c : cards) {
//            System.out.println(c.toString());
//        }
    }

    public static void main(String[] args) {
        populateCardList();
        sortCards(CardSorting.shuffle);
    }
}
