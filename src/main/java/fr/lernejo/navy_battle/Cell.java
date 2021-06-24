package fr.lernejo.navy_battle;

import java.util.Objects;

public class Cell {
    public Coordinates coordinateCell;
    private CellStatus cellStatus;
    private Boat boat;

    Cell(Coordinates coordinates, Boat boatArgs){
        coordinateCell = coordinates;
        cellStatus = CellStatus.hidden;
        boat = boatArgs;
    }

    public boolean hit(){
        cellStatus = CellStatus.hitted;
        if (boat != null){
           return true; //Boat hit
        }
        return false;
    }

    public boolean isBoat(){
        if (boat != null){
            return true; //Boat hit
        }
        return false;
    }

    public Boat getBoat() {
        return boat;
    }

    public boolean isVisible(){
        return cellStatus == CellStatus.hitted;
    }

    public CellStatus getCellStatus(){
        return cellStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return coordinateCell.equals(cell.coordinateCell) && cellStatus == cell.cellStatus && Objects.equals(boat, cell.boat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateCell, cellStatus, boat);
    }
}
