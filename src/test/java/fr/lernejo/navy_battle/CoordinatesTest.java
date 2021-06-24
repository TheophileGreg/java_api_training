package fr.lernejo.navy_battle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    Coordinates coordinatesTest;
    @BeforeEach
    void setUp() {
        coordinatesTest  = new Coordinates(3,4);
    }

    @Test
    void testgetX() {
        assertEquals(3, coordinatesTest.getX());
    }

    @Test
    void testgetY() {
        assertEquals(4, coordinatesTest.getY());
    }

    @Test
    void testHashCode() {
        Coordinates coordinatesTestBis = new Coordinates(3,4);
        int hashCodeTest = coordinatesTestBis.hashCode();
        assertEquals(hashCodeTest,coordinatesTest.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("D5", coordinatesTest.toString());
    }
}
