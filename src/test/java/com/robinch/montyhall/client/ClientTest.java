package com.robinch.montyhall.client;

import com.robinch.montyhall.service.SimulatorResult;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void runSimulation_nrOfTries15_resultNrOfTries15() {
        Client client = new Client();
        SimulatorResult result = client.runSimulation(15);
        assertThat(result.getNrOfTries(), is(15));
    }

    @Test
    public void prettifyResults_simulatorResultNrOfTries10Change7Stick3_matchingPrint() {
        Client client = new Client();
        SimulatorResult result = new SimulatorResult(10, 7, 3);
        String prettyResults = client.prettifyResults(result);
        assertThat(prettyResults,
                is("Nr of tries: 10\n" +
                        "Wins by sticking to your choice: 3 (30.00%)\n" +
                        "Wins by changing your choice: 7 (70.00%)\n"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void prettyResults_simulatorResultNrOfTries0_throwIllegalArgumentException() {
        Client client = new Client();
        SimulatorResult result = new SimulatorResult(0, 0, 0);
        client.prettifyResults(result);
    }
}