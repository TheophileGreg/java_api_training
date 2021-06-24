package fr.lernejo.navy_battle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    Cell cell_with_boat_test;
    Cell cell_without_boat_test;

    @BeforeEach
    void setUp() {
        cell_with_boat_test = new Cell(new Coordinates(2,3), true);
        cell_without_boat_test= new Cell(new Coordinates(3,4), false);
    }

    @Test
    void testHit() {
        boolean shouldBeABoat = cell_with_boat_test.hit();
        boolean shouldnotBeABoat = cell_without_boat_test.hit();
        assertEquals(true, shouldBeABoat);
        assertEquals(false, shouldnotBeABoat);
    }

    @Test
    void testIsVisible(){
        cell_without_boat_test.hit();
        assertEquals(true, cell_without_boat_test.isVisible());
        assertEquals(false, cell_with_boat_test.isVisible());
    }

    @Test
    void testIsBoat(){
        assertEquals(true, cell_with_boat_test.isBoat());
        assertEquals(false, cell_without_boat_test.isBoat());
    }
}
