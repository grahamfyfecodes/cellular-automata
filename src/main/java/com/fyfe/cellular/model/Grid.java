package com.fyfe.cellular.model;

import com.fyfe.cellular.util.Pair;

import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    public Stream<Cell> stream() {
        return IntStream.range(0, rows * cols)
                .mapToObj(n -> new Pair<>(n % rows, n / cols))
                .map(p -> new Cell(p.x(), p.y(), grid[p.x()][p.y()]));
    }

    public static class Cell {

        private final int x;
        private final int y;
        private final boolean value;

        private Cell(int x, int y, boolean value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "x=" + x +
                    ", y=" + y +
                    ", value=" + value +
                    '}';
        }
    }
}
