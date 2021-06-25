package fr.lernejo.navy_battle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoatTest {

    List<OwnCell> cellsBoats1 = new ArrayList<>();
    Boat boatTest1;

    @BeforeEach
    void setUp() {
        boatTest1 = new Boat(cellsBoats1);
        cellsBoats1.add(new OwnCell(new Coordinates(0,1),true, boatTest1));
        cellsBoats1.add(new OwnCell(new Coordinates(0,2), true, boatTest1));
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
