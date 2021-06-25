package fr.lernejo.navy_battle;

import java.util.ArrayList;
import java.util.List;

public class OwnBoard implements Board {

    private  List<OwnCell> listCells = new ArrayList<>();
    OwnBoard(List<Boat> boats){
        List<Coordinates> boatsCoordinates = new ArrayList<>();
        for (Boat b: boats) {
            for (Cell c: b.getCells()) {
                boatsCoordinates.add(c.coordinateCell);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Coordinates actCoordinates = new Coordinates(i, j);
                if (boatsCoordinates.contains(actCoordinates))
                {
                    for (Boat b: boats
                    ) {
                        for (OwnCell c: b.getCells()
                        ) {
                            if (actCoordinates.equals(c.coordinateCell)) {
                                listCells.add(c);
                            }
                        }
                    }
                } else {
                    OwnCell actCell = new OwnCell (actCoordinates, false, null);
                    listCells.add(actCell);
                }

            }
        }
    }

    public List<OwnCell> getListCells() {
        return listCells;
    }

    @Override
    public OwnCell getCell(String coordinatesAlpha) {
        for (OwnCell e : listCells) {
            if (e.coordinateCell.toString().equals(coordinatesAlpha) ){
                return e;
            }
        }
        return null;
    }
}
