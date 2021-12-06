package com.fyfe.cellular.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class GridView extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        var center = new Point(getWidth() / 2, getHeight() / 2);
        var radius = Math.min(getWidth() / 2, getHeight() / 2) - 5;
        var diameter = radius * 2;
        var innerRadius = (int)(radius * 0.9);
        var innerDiameter = innerRadius * 2;
        var barWidth = (int)(innerRadius * 1.4);
        var barHeight = (int)(innerRadius * 0.35);

        g.setColor(Color.WHITE);
        g.fillOval(center.x - radius, center.y - radius, diameter, diameter);
        g.setColor(Color.RED);
        g.fillOval(center.x - innerRadius, center.y - innerRadius, innerDiameter, innerDiameter);
        g.setColor(Color.WHITE);
        g.fillRect(center.x - barWidth/2, center.y - barHeight/2, barWidth, barHeight);
    }
}
