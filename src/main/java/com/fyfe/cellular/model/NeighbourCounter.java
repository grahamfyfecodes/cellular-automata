package com.fyfe.cellular.model;

import com.fyfe.cellular.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.floorMod;
import static java.util.Arrays.asList;

@Service
public class NeighbourCounter {

    private final List<Pair<Integer, Integer>> offsets;

    public NeighbourCounter() {
        this.offsets = asList(
                new Pair<>(-1, -1),
                new Pair<>(0, -1),
                new Pair<>(1, -1),
                new Pair<>(-1, 0),
                new Pair<>(1, 0),
                new Pair<>(-1, 1),
                new Pair<>(0, 1),
                new Pair<>(1, 1)
        );
    }

    public int countNeighbours(Grid grid, int x, int y) {
        return getNeighbours(grid, x, y).stream()
                .mapToInt(p -> grid.getGrid()[p.x()][p.y()] ? 1 : 0)
                .sum();
    }

    public List<Pair<Integer, Integer>> getNeighbours(Grid grid, int x, int y) {
        return offsets.stream()
                .map(p -> new Pair<>(
                        (floorMod(p.x() + x,  grid.getCols())),
                        (floorMod(p.y() + y,  grid.getRows()))
                ))
                .collect(Collectors.toList());
    }
}
