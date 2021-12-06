package com.fyfe.cellular.view.config;

import com.fyfe.cellular.model.Grid;
import com.fyfe.cellular.model.NeighbourCounter;
import com.fyfe.cellular.view.GridView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

@Configuration
public class ViewConfig {

    private static final String NAME = "Cellular Automata";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int TOP_HEIGHT = 40;

    @Bean
    public JFrame jFrame(GridView gridView) {
        JFrame jFrame = new JFrame(NAME);
        jFrame.setSize(WIDTH, HEIGHT + TOP_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().add(gridView, BorderLayout.CENTER);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        return jFrame;
    }

    @Bean
    public GridView gridView(Grid grid, NeighbourCounter neighbourCounter) {
        return new GridView(grid, WIDTH, HEIGHT, neighbourCounter);
    }
}
