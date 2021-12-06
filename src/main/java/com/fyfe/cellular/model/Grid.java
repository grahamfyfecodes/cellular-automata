package com.fyfe.cellular.model;

public class Grid {

    private final int rows;
    private final int cols;
    private final boolean[][] grid;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new boolean[rows][cols];
    }

    public void setTile(int row, int col, boolean value) {
        if(row >= 0 && row < rows && col >= 0 && col < cols) {
            grid[row][col] = value;
        }
        else {
            System.out.printf("Tile out of bounds: r:%d d:%d", row, col);
        }
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
