package com.fyfe.cellular.model;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GridFactory {

    private static final Random RAND = new Random();

    public Grid createRandomGrid(int rows, int cols) {
        Grid grid = new Grid(rows, cols);
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++){
                grid.setTile(x, y, RAND.nextBoolean());
            }
        }
        return grid;
    }
}
