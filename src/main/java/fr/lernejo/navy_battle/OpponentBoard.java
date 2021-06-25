package fr.lernejo.navy_battle;

import java.util.ArrayList;
import java.util.List;

public class OpponentBoard implements Board{

    private  List<OpponentCell> listCells = new ArrayList<>();

    OpponentBoard(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Coordinates actCoordinates = new Coordinates(i, j);
                    OpponentCell actCell = new OpponentCell (actCoordinates, false);
                    listCells.add(actCell);
            }
        }
   }

    public List<OpponentCell> getListCells() {
        return listCells;
    }

    @Override
    public OpponentCell getCell(String coordinatesAlpha) {
        for (OpponentCell e : listCells) {
            if (e.coordinateCell.toString().equals(coordinatesAlpha) ){
                return e;
            }
        }
        return null;
    }
}
