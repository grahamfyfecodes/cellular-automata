package com.fyfe.cellular.model.config;

import com.fyfe.cellular.model.Grid;
import com.fyfe.cellular.model.GridFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GridConfig {

    private static final int ROWS = 350;
    private static final int COLS = 350;

    @Bean
    public Grid grid(GridFactory gridFactory) {
        return gridFactory.createRandomGrid(ROWS, COLS);
    }
}
