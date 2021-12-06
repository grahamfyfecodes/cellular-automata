package com.fyfe.cellular.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class NeighbourCounterTest {

    private NeighbourCounter testObject = new NeighbourCounter();

    @Test
    public void getNeighbours() {
        Grid grid = new Grid(10, 10);
        System.out.println(testObject.getNeighbours(grid, 0, 0  ));
    }
}