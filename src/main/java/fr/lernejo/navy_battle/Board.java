package fr.lernejo.navy_battle;

import java.util.ArrayList;
import java.util.List;

public class Board {

    final private List<Cell> listCells = new ArrayList<>();

    Board(List<Boat> boats){
        List<Coordinates> boatsCoordinates = new ArrayList<>();
        for (Boat b: boats) {
            for (Cell c: b.getCells()) {
                boatsCoordinates.add(c.coordinateCell); } }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Coordinates actCoordinates = new Coordinates(i, j);
                if (boatsCoordinates.contains(actCoordinates)) {
                     for (Boat b: boats) {
                         for (Cell c: b.getCells()) {
                             if (actCoordinates.equals(c.coordinateCell)) { listCells.add(c); } } } }
                else {
                    Cell actCell = new Cell (actCoordinates, null);
                    listCells.add(actCell);
                } } } }

    public List<Cell> getListCells() {
        return listCells;
    }

    public Cell getCell(String coordinatesAlpha){
        for (Cell e : listCells) {
            if (e.coordinateCell.toString().equals(coordinatesAlpha) ){
                return e;
            }
        }
        return null;
    }
}
