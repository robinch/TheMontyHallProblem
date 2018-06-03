package com.robinch.montyhall.client;

import com.robinch.montyhall.service.MontyHallSimulator;
import com.robinch.montyhall.service.SimulatorResult;

public class Client {

    public SimulatorResult runSimulation (int nrOfTries) {
        MontyHallSimulator simulator = new MontyHallSimulator();
        return simulator.simulate(nrOfTries);
    }

    public String prettifyResults(SimulatorResult result) {
        if (result.getNrOfTries() < 1) {
            throw new IllegalArgumentException("Use a result with more than 0 nrOfTries");
        }

        int nrOfTries = result.getNrOfTries();
        int winsBySticking = result.getNrOfWinsBySticking();
        int winsByChanging = result.getNrOfWinsByChanging();
        float percentageWinsBySticking = calculateWinPercentage(winsBySticking, nrOfTries);
        float percentageWinsByChanging= calculateWinPercentage(winsByChanging, nrOfTries);

        String prettyResults = String.format("Nr of tries: %d%n", nrOfTries);

        prettyResults += String.format("Wins by sticking to your choice: %d (%.2f%%)%n"
                , winsBySticking, percentageWinsBySticking);

        prettyResults +=  String.format("Wins by changing your choice: %d (%.2f%%)%n"
                , winsByChanging, percentageWinsByChanging);

        return prettyResults;
    }

    private float calculateWinPercentage(int wins, int tries) {
        return 100 * ((float) wins) / (float) tries;
    }

    public static void main(String[] args) {
        int nrOfTries = 10_000_000;

        if (args.length > 0) {
            try {
                nrOfTries = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.format(
                        "Error: Input '%s' could not be read as a number.%n" +
                                "Please use a number between 0 and %d%n" +
                                "The default value %d will be used instead%n%n",
                        args[0], Integer.MAX_VALUE , nrOfTries);
            }
        }

        Client client = new Client();
        String results = client.prettifyResults(client.runSimulation(nrOfTries));
        System.out.println(results);
    }
}
