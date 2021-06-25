package fr.lernejo.navy_battle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private List<Boat> boatsTest = new ArrayList<>();
    private OwnBoard boardtest;

    @BeforeEach
    void setUp() {
        List<OwnCell> cellsBoats1 = new ArrayList<>();
        Boat boatTest1 = new Boat(cellsBoats1);
        cellsBoats1.add(new OwnCell(new Coordinates(0,1), true, boatTest1));
        cellsBoats1.add(new OwnCell(new Coordinates(0,2), true, boatTest1));

        List<OwnCell> cellsBoats2 = new ArrayList<>();
        Boat boatTest2 = new Boat(cellsBoats2);
        cellsBoats2.add(new OwnCell(new Coordinates(4,1), true, boatTest2));
        cellsBoats2.add(new OwnCell(new Coordinates(4,2), true, boatTest2));

        boatsTest.add(boatTest1);
        boatsTest.add(boatTest2);

        boardtest = new OwnBoard(boatsTest);
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
                    Cell actCell = new OwnCell (actCoordinates, false, null);
                    listCells.add(actCell);
                }

            }
        }
        assertEquals(boardtest.getListCells(), listCells);
    }

    @Test
    void testGetCell() {
        Coordinates coordinatesTest  = new Coordinates(1,1);
        Cell cellTest = new OwnCell(coordinatesTest, false,null);
        assertEquals(boardtest.getCell("B2"), cellTest);
    }

}
