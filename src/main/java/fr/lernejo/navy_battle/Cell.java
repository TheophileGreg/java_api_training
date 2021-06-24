package fr.lernejo.navy_battle;

public class Cell {
    private Coordinates coordinateCell;
    private boolean visible;
    private boolean littleBoat;

    Cell(Coordinates coordinates, boolean isBoat){
        coordinateCell = coordinates;
        littleBoat = isBoat;
        visible = false;
    }

    public boolean hit(){
        visible = true;
        if (littleBoat){
           return true; //Boat hit
        }
        return false;
    }

    public boolean isBoat(){
        if (littleBoat){
            return true; //Boat hit
        }
        return false;
    }

    public boolean isVisible(){
        return visible;
    }
}
