package fr.lernejo.navy_battle;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final private Board myBoard;
    final private List<Boat> boats = new ArrayList<>();

    public Game(){
        //creer ses boats
        List<Cell> cellsBoats1 = new ArrayList<>();
        Boat boat1 = new Boat(cellsBoats1, 1);
        cellsBoats1.add(new Cell(new Coordinates(0,1), boat1));
        cellsBoats1.add(new Cell(new Coordinates(0,2), boat1));
        List<Cell> cellsBoats2 = new ArrayList<>();
        Boat boat2 = new Boat(cellsBoats2, 2);
        cellsBoats2.add(new Cell(new Coordinates(4,1), boat2));
        cellsBoats2.add(new Cell(new Coordinates(4,2), boat2));
        boats.add(boat1);
        boats.add(boat2);
        myBoard = new Board(boats);
    }

    public FireResult fire(String coordinatesAlpha){
        Cell cellToFire = myBoard.getCell(coordinatesAlpha);
        if(cellToFire.hit()){
            Boat boatFire = cellToFire.getBoat();
            if (boatFire.checkBoat() == BoatStatus.sunked){
                return FireResult.sunk;
            }
            return FireResult.hit;
        }
        else {
            return FireResult.miss;
        }
    }

    public GameStatus getStatus(){
        for (Boat b: boats)
        {
            if (b.checkBoat() == BoatStatus.intact || b.checkBoat() == BoatStatus.hitted)
            {
                return GameStatus.onGoing;
            }
        }
        return GameStatus.lost;
    }

    @Override
    public String toString() {
        int i = 0;
        String boardString = "\nGameBoard: \n 1 : signifie Touché - 0 : signifie loupé et X : signifie vierge \n" ;
        for ( Cell e : myBoard.getListCells()) {
            i++;
            if (!e.isVisible()){ boardString = boardString + " X "; }
            else if( e.isVisible() && e.isBoat()){ boardString = boardString + " 1 "; }
            else{ boardString = boardString + " 0 "; }
            if (i % 10 == 0){ boardString = boardString + "\n"; } }
        return  boardString;
    }
}
