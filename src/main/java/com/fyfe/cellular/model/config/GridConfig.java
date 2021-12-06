package com.fyfe.cellular.model.config;

import com.fyfe.cellular.model.Grid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GridConfig {

    private static final int ROWS = 5;
    private static final int COLS = 5;

    @Bean
    public Grid grid() {
        Grid grid = new Grid(ROWS, COLS);
        grid.setTile(2, 2, true);
        return grid;
    }
}
