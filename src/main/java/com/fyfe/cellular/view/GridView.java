package com.fyfe.cellular.view;

import com.fyfe.cellular.model.Grid;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class GridView extends JPanel {

    private final Grid grid;
    private final int width;
    private final int height;
    private final int cellWidth;
    private final int cellHeight;

    public GridView(Grid grid, int width, int height) {
        this.grid = grid;
        this.width = width;
        this.height = height - 40;
        this.cellWidth = width / grid.getRows();
        this.cellHeight = this.height / grid.getCols();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintGrid(g);
    }

    private void paintGrid(Graphics g) {
        IntStream.range(1, grid.getRows()).forEach(i ->
                drawRows(g, i)
        );
        IntStream.range(1, grid.getCols()).forEach(i ->
                drawCols(g, i)
        );
    }

    private void drawRows(Graphics g, int i) {
        g.drawLine(
                0, i * cellHeight, width, i * cellHeight
        );
    }

    private void drawCols(Graphics g, int i) {
        g.drawLine(
                i * cellWidth, 0,i * cellWidth, height
        );
    }
}
