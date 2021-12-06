package com.fyfe.cellular.view.config;

import com.fyfe.cellular.model.Grid;
import com.fyfe.cellular.view.GridView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

@Configuration
public class ViewConfig {

    private static final String NAME = "Cellular Automata";
    private static final int WIDTH = 360;
    private static final int HEIGHT = 400;

    @Bean
    public JFrame jFrame(GridView gridView) {
        JFrame jFrame = new JFrame(NAME);
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().add(gridView, BorderLayout.CENTER);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        return jFrame;
    }

    @Bean
    public GridView gridView(Grid grid) {
        return new GridView(grid, WIDTH, HEIGHT);
    }
}
