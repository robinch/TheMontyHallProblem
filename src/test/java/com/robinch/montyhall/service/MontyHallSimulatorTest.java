package com.robinch.montyhall.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MontyHallSimulatorTest {

    @Test
    public void simulate_nrOfTries4711_winsByStickingPlusWinsByChangingEquals4711() {
        MontyHallSimulator simulator = new MontyHallSimulator();
        SimulatorResult result = simulator.simulate(4711);
        assertThat(result.getNrOfWinsBySticking() + result.getNrOfWinsByChanging(), is(4711));
    }

    @Test
    public void simulate_nrOfTries213_resultNrOfTriesEquals213() {
        MontyHallSimulator simulator = new MontyHallSimulator();
        SimulatorResult result = simulator.simulate(213);
        assertThat(result.getNrOfTries(), is(213));
    }

    @Test(expected = IllegalArgumentException.class)
    public void simulate_nrOfTriesNegative123_throwIllegalArgumentException() {
        MontyHallSimulator simulator = new MontyHallSimulator();
        simulator.simulate(-123);
    }
}