package com.robinch.montyhall.service;

public class SimulatorResult {
    private int nrOfTries;
    private int nrOfWinsByChanging;
    private int nrOfWinsBySticking;

    public SimulatorResult(int nrOfTries, int nrOfWinsByChanging, int nrOfWinsBySticking) {
        this.nrOfTries = nrOfTries;
        this.nrOfWinsByChanging = nrOfWinsByChanging;
        this.nrOfWinsBySticking = nrOfWinsBySticking;
    }

    public int getNrOfTries() {
        return nrOfTries;
    }

    public int getNrOfWinsByChanging() {
        return nrOfWinsByChanging;
    }

    public int getNrOfWinsBySticking() {
        return nrOfWinsBySticking;
    }
}
