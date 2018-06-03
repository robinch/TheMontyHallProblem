package com.robinch.montyhall.service;

import java.util.Random;

public class MontyHallSimulator {
    private static final int NR_OF_BOXES = 3;

    private Random random = new Random();

    public SimulatorResult simulate(int nrOfTries) {
        if (nrOfTries < 1 ) {
            throw new IllegalArgumentException("nrOfTries should be a positive number");
        }

        int winsBySticking= 0;
        int winsByChanging = 0;

        for (int i = 0; i < nrOfTries; i++) {
            int winningBox = getRandomBox();
            int firstChosenBox= getRandomBox();

            int revealedNonWinningBox= getRevealedNonWinningBox(firstChosenBox, winningBox);
            int changedChoice = getNonChosenNonRevealedBox(firstChosenBox, revealedNonWinningBox);

            if (firstChosenBox == winningBox) {
                winsBySticking++;
            }

            if (changedChoice == winningBox) {
                winsByChanging++;
            }
        }

        return new SimulatorResult(nrOfTries, winsByChanging, winsBySticking);
    }

    private int getRandomBox() {
        return random.nextInt(NR_OF_BOXES);
    }

    private int getRevealedNonWinningBox(int firstChosenBox, int winningBox) {
        int revealedBox = winningBox;
        while (revealedBox == firstChosenBox || revealedBox == winningBox) {
            revealedBox = getRandomBox();
        }

        return revealedBox;
    }

    private int getNonChosenNonRevealedBox(int firstChosenBox, int revealedBox) {
        return NR_OF_BOXES - firstChosenBox - revealedBox;
    }
}
