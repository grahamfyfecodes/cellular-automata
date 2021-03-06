package com.fyfe.cellular;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CellularAutomataApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(CellularAutomataApplication.class);
        builder.headless(false);
        builder.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting...");
    }
}
