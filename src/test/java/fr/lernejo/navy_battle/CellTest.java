//package fr.lernejo.navy_battle;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CellTest {
//    Cell cellWithBoatTest;
//    Cell cellWithoutBoatTest;
//    List<Cell> cellsBoats1 = new ArrayList<>();
//    Boat boatTest1;
//
//    @BeforeEach
//    void setUp() {
//        boatTest1 = new Boat(cellsBoats1);
//        cellsBoats1.add(new Cell(new Coordinates(0,1), boatTest1));
//        cellsBoats1.add(new Cell(new Coordinates(0,2), boatTest1));
//        cellWithBoatTest = new Cell(new Coordinates(2,3), boatTest1);
//        cellWithoutBoatTest = new Cell(new Coordinates(3,4), null);
//    }
//
//    @Test
//    void testHit() {
//        boolean shouldBeABoat = cellWithBoatTest.hit();
//        boolean shouldnotBeABoat = cellWithoutBoatTest.hit();
//        assertEquals(true, shouldBeABoat);
//        assertEquals(false, shouldnotBeABoat);
//    }
//
//    @Test
//    void testIsVisible(){
//        cellWithoutBoatTest.hit();
//        assertEquals(true, cellWithoutBoatTest.isVisible());
//        assertEquals(false, cellWithBoatTest.isVisible());
//    }
//
//    @Test
//    void testIsBoat(){
//        assertEquals(true, cellWithBoatTest.getIsBoat());
//        assertEquals(false, cellWithoutBoatTest.getIsBoat());
//    }
//
//    @Test
//    void testGetBoat() {
//        assertEquals(cellWithBoatTest.getBoat(), boatTest1);
//    }
//
//    @Test
//    void testGetCellStatus() {
//        assertEquals(cellWithBoatTest.getCellStatus(), CellStatus.hidden);
//        assertEquals(cellWithoutBoatTest.getCellStatus(), CellStatus.hidden);
//
//        cellWithBoatTest.hit();
//        cellWithoutBoatTest.hit();
//
//        assertEquals(cellWithBoatTest.getCellStatus(), CellStatus.hitted);
//        assertEquals(cellWithoutBoatTest.getCellStatus(), CellStatus.hitted);
//    }
//
//    @Test
//    void testEquals() {
//        Cell cellWithBoatTest1 = new Cell(new Coordinates(2,3), boatTest1);
//        Cell cellWithBoatTest2 = new Cell(new Coordinates(2,3), null);
//        Cell cellWithBoatTest3 = new Cell(new Coordinates(4,3), boatTest1);
//        Cell cellWithBoatTest4 = new Cell(new Coordinates(4,3), null);
//        assertEquals(cellWithBoatTest, cellWithBoatTest1);
//        assertNotEquals(cellWithBoatTest, cellWithBoatTest2);
//
//        assertNotEquals(cellWithBoatTest, cellWithBoatTest3);
//        assertNotEquals(cellWithoutBoatTest, cellWithBoatTest4);
//    }
//
//    @Test
//    void testHashCode() {
//        Cell cellWithBoatTest1 = new Cell(new Coordinates(2,3), boatTest1);
//        Cell cellWithBoatTest2 = new Cell(new Coordinates(2,3), null);
//        Cell cellWithBoatTest3 = new Cell(new Coordinates(4,3), boatTest1);
//        Cell cellWithBoatTest4 = new Cell(new Coordinates(4,3), null);
//        assertEquals(cellWithBoatTest.hashCode(), cellWithBoatTest1.hashCode());
//        assertNotEquals(cellWithBoatTest.hashCode(), cellWithBoatTest2.hashCode());
//
//        assertNotEquals(cellWithBoatTest.hashCode(), cellWithBoatTest3.hashCode());
//        assertNotEquals(cellWithoutBoatTest.hashCode(), cellWithBoatTest4.hashCode());
//    }
//}
