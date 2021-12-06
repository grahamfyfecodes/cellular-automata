package com.fyfe.cellular.view.config;

import com.fyfe.cellular.view.GridView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

@Configuration
public class JFrameConfig {

    private static final String NAME = "Cellular Automata";
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    @Bean
    public JFrame jFrame(GridView gridView) {
        JFrame jFrame = new JFrame(NAME);
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.getContentPane().add(gridView, BorderLayout.CENTER);
        jFrame.setVisible(true);
        return jFrame;
    }
}
