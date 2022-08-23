package org.example;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Snap extends CardGame {


    public static void shuffleCards(ArrayList<Card> playerOneCards, ArrayList<Card> playerTwoCards) {
        for (int i = 0; i < cards.size(); i++) {
            if (i % 2 == 0) {
                playerOneCards.add(cards.get(i));
            } else {
                playerTwoCards.add(cards.get(i));
            }
        }
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        ArrayList<Card> cards = game.populateCardList();
        game.sortCards(CardSorting.shuffle);
        ArrayList<Card> playerOneCards = new ArrayList<>();
        ArrayList<Card> playerTwoCards = new ArrayList<>();
        shuffleCards(playerOneCards, playerTwoCards);
        Reader rdr = new InputStreamReader(System.in);
        Scanner scanner = new Scanner(rdr);
        int index = 0;
        ArrayList<Card> snapCards = new ArrayList<>();
        boolean snap = false;
        Player playerOne = new Player(playerOneCards, "Player 1");
        Player playerTwo = new Player(playerTwoCards, "Player 2");
        Player currentPlayer = playerOne;
        while (!snap) {
            String enter = scanner.nextLine();
            if (enter.equals("")) {
                Card latestCard = game.dealCard(currentPlayer.getDeck(), index);
                if (index < 25) index++;
                else {
                    System.out.println("Reshuffling cards...");
                    index = 0;
                    game.sortCards(CardSorting.shuffle);
                    playerOneCards.clear();
                    playerTwoCards.clear();
                    shuffleCards(playerOneCards, playerTwoCards);
                }
                snapCards.add(latestCard);
                System.out.println(currentPlayer.getName() + " played:");
                if (currentPlayer == playerOne) {
                    currentPlayer = playerTwo;
                } else {
                    currentPlayer = playerOne;
                }
                if (snapCards.size() < 2) System.out.println(snapCards);
                else {
                    System.out.println((snapCards.get(snapCards.size() - 1) + ", " + (snapCards.get(snapCards.size() - 2))));
                    if ((snapCards.get(snapCards.size() - 1).getSymbol())
                            .equals(snapCards.get(snapCards.size() - 2).getSymbol())) {
                        int timer = 3;
                        while (timer > 0 && !enter.toLowerCase().equals("snap")) {
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                            timer--;
                            try {
                                if (rdr.ready()) {
                                    System.out.println("\r" + timer + " ");
                                }
                            } catch (IOException e) {
                                return;
                            }
                        }
                        if (enter.toLowerCase().equals("snap") && timer > 0) {
                            snap = true;
                            System.out.println("\r SNAP");
                        } else {
                            System.out.println("\r Too late!");
                            timer = 3;
                        }

                    }
                }


            }

        }
    }
}

