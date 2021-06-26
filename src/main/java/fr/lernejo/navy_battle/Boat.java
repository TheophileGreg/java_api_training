package fr.lernejo.navy_battle;

import java.util.List;

public class Boat {
    private final int idBoat;
    private final List<Cell> cells;

    Boat(List<Cell> cellsArgs, int idBoatArgs){
        idBoat = idBoatArgs;
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

    public List<Cell> getCells() {
        return cells;
    }

    @Override
    public String toString() {
        return String.valueOf(idBoat) ;
    }
}
