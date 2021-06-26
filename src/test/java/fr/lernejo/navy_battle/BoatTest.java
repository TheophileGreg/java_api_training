package fr.lernejo.navy_battle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoatTest {

    List<Cell> cellsBoats1 = new ArrayList<>();
    Boat boatTest1;

    @BeforeEach
    void setUp() {
        boatTest1 = new Boat(cellsBoats1, 1);
        cellsBoats1.add(new Cell(new Coordinates(0,1), boatTest1));
        cellsBoats1.add(new Cell(new Coordinates(0,2), boatTest1));
    }

    @Test
    void checkBoat() {
        assertEquals(boatTest1.checkBoat(), BoatStatus.intact);
    }

    @Test
    void getCells() {
        assertEquals(boatTest1.getCells(), cellsBoats1);
    }
}
