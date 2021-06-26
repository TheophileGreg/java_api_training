package fr.lernejo.navy_battle;

import java.util.Objects;

public class Cell {
    public Coordinates coordinateCell;
    private CellStatus cellStatus;
    private boolean isBoat;
    private Boat boat;

    Cell(Coordinates coordinates, Boat boatArgs){
        coordinateCell = coordinates;
        cellStatus = CellStatus.hidden;
        boat = boatArgs;
        isBoat = boatArgs != null;
    }

    public boolean hit(){
        cellStatus = CellStatus.hitted;
        if (isBoat){
           return true; //Boat hit
        }
        return false;
    }

    public boolean isBoat(){
        return isBoat;
    }

    public void setBoat(boolean boat) {
        isBoat = boat;
    }

    public Boat getBoat() {
        return this.boat;
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

    @Override
    public String toString() {
        return "Cell{" +
            "coordinateCell=" + coordinateCell +
            ", cellStatus=" + cellStatus +
            ", isBoat=" + isBoat +
            ", boat=" + boat +
            '}';
    }
}
