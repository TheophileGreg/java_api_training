package fr.lernejo.navy_battle;

import java.util.Objects;

public abstract class Cell {
    public Coordinates coordinateCell;
    private CellStatus cellStatus;
    private boolean isBoat;

    Cell(Coordinates coordinates, boolean boatBool){
        coordinateCell = coordinates;
        cellStatus = CellStatus.hidden;
        isBoat = boatBool;
    }

    public boolean hit(){
        cellStatus = CellStatus.hitted;
        if (isBoat){
           return true;
        }
        return false;
    }

    public boolean getIsBoat() {
        if (isBoat) {
            return true;
        }
        return false;
    }

    public void setIsBoat(boolean boat) {
        isBoat = boat;
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
        return coordinateCell.equals(cell.coordinateCell) && cellStatus == cell.cellStatus && Objects.equals(isBoat, cell.isBoat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinateCell, cellStatus, isBoat);
    }
}
