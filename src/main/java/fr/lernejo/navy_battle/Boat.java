package fr.lernejo.navy_battle;

import java.util.List;

public class Boat {
    private List<OwnCell> cells;

    Boat(List<OwnCell> cellsArgs){
        cells = cellsArgs;
    }

    public BoatStatus checkBoat(){
        int hitCounter = 0;
        for (Cell c: cells) {
            if (c.getCellStatus() == CellStatus.hitted){
                hitCounter += 1;
            }
        }
        if (hitCounter == cells.size()){
            return BoatStatus.sunked;
        } else if (hitCounter > 0){
            return BoatStatus.hitted;
        } else {
            return BoatStatus.intact;
        }
    }

    public List<OwnCell> getCells() {
        return cells;
    }
}
