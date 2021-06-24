package fr.lernejo.navy_battle;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Cell> board = new ArrayList<>();

    Board(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Cell actCell = new Cell (new Coordinates(i, j), i==j);
                board.add(actCell);
            }
        }
    }

    public List<Cell> getBoard() {
        return board;
    }

    public Cell getCell(String coordinatesAlpha){
        return board.get(0);
    }
}
