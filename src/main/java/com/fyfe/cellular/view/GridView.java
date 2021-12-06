package com.fyfe.cellular.view;

import com.fyfe.cellular.model.Grid;
import com.fyfe.cellular.model.NeighbourCounter;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class GridView extends JPanel {

    public static final float BOX_RATIO = 0.8f;

    private final Grid grid;
    private final float width;
    private final float height;
    private final float cellWidth;
    private final float cellHeight;

    private final float boxWidth;
    private final float boxHeight;
    private final float boxXOffset;
    private final float boxYOffset;

    private final NeighbourCounter neighbourCounter;

    public GridView(Grid grid, float width, float height, NeighbourCounter neighbourCounter) {
        this.grid = grid;
        this.width = width;
        this.height = height;
        this.neighbourCounter = neighbourCounter;
        this.cellWidth = width / grid.getRows();
        this.cellHeight = this.height / grid.getCols();

        boxWidth = (int) (cellWidth * BOX_RATIO);
        boxHeight = (int) (cellHeight * BOX_RATIO);
        boxXOffset = (cellWidth - boxWidth) / 2;
        boxYOffset = (cellHeight - boxHeight) / 2;
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

        drawAllCells(g);
    }

    private void drawAllCells(Graphics g) {
        for(int x = 0; x < grid.getRows(); x++) {
            for(int y = 0; y < grid.getCols(); y++) {
                if(grid.getGrid()[x][y]) {
                    drawCell(g, x, y);
//                    drawNeighbourCount(g, x, y);
                }
            }
        }
    }

    private void drawNeighbourCount(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        g.setFont(new Font(Font.SERIF, Font.BOLD, (int)(cellWidth * 1f)));
        g.drawString(
                neighbourCounter.countNeighbours(grid, x, y) + "",
                (int)(x * cellWidth + boxXOffset),
                (int)(y * cellHeight + boxYOffset)
        );
    }

    private void drawCell(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(
                (int)(x * cellWidth + boxXOffset),
                (int)(y * cellHeight + boxYOffset),
                (int)boxWidth,
                (int)boxHeight
        );
    }

    private void drawRows(Graphics g, float i) {
        g.drawLine(
                0, (int)(i * cellHeight), (int)width, (int)(i * cellHeight)
        );
    }

    private void drawCols(Graphics g, float i) {
        g.drawLine(
                (int)(i * cellWidth), 0,(int)(i * cellWidth), (int)height
        );
    }
}
