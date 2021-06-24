package fr.lernejo.navy_battle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private List<Boat> boatsTest = new ArrayList<>();
    private Board boardtest;

    @BeforeEach
    void setUp() {
        List<Cell> cellsBoats1 = new ArrayList<>();
        Boat boatTest1 = new Boat(cellsBoats1);
        cellsBoats1.add(new Cell(new Coordinates(0,1), boatTest1));
        cellsBoats1.add(new Cell(new Coordinates(0,2), boatTest1));

        List<Cell> cellsBoats2 = new ArrayList<>();
        Boat boatTest2 = new Boat(cellsBoats2);
        cellsBoats2.add(new Cell(new Coordinates(4,1), boatTest2));
        cellsBoats2.add(new Cell(new Coordinates(4,2), boatTest2));

        boatsTest.add(boatTest1);
        boatsTest.add(boatTest2);

        boardtest = new Board(boatsTest);
    }

    @Test
    void getListCells() {
        List<Cell> listCells = new ArrayList<>();
        List<Coordinates> boatsCoordinates = new ArrayList<>();
        for (Boat b: boatsTest) {
            for (Cell c: b.getCells()) {
                boatsCoordinates.add(c.coordinateCell);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Coordinates actCoordinates = new Coordinates(i, j);
                if (boatsCoordinates.contains(actCoordinates))
                {
                    for (Boat b: boatsTest
                    ) {
                        for (Cell c: b.getCells()
                        ) {
                            if (actCoordinates.equals(c.coordinateCell)) {
                                listCells.add(c);
                            }
                        }
                    }
                } else {
                    Cell actCell = new Cell (actCoordinates, null);
                    listCells.add(actCell);
                }

            }
        }
        assertEquals(boardtest.getListCells(), listCells);
    }

    @Test
    void testGetCell() {
        Coordinates coordinatesTest  = new Coordinates(1,1);
        Cell cellTest = new Cell(coordinatesTest, null);
        assertEquals(boardtest.getCell("B2"), cellTest);
    }

}
