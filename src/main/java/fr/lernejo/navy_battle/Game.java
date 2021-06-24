package fr.lernejo.navy_battle;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board mainBoard;

    public Game(){
        //init le board
        mainBoard = new Board();
        //placer les boats
    }


//    public Cell findCell(Coordinates coordinates){
//        for (Cell e: board
//             ) {
//            if(e.hashCode() == coordinates.hashCode()){
//                return e;
//            }
//        }
//        return null;
//    }
    public FireResult fire(String coordinatesAlpha){
        Cell cellToFire = mainBoard.getCell(coordinatesAlpha);
        if(cellToFire.hit()){
            return FireResult.Sunk;
        }
        else {
            return FireResult.Miss;
        }
    }

    @Override
    public String toString() {
        int i = 0;
        String boardString = "\nGameBoard: \n 1 : signifie frappe - 0 : signifie loupé et X : signifie vierge \n" ;
        for ( Cell e : mainBoard.getBoard()
             ) {
            i++;
            if (!e.isVisible()){
                boardString = boardString + " X ";
            }
            else if( e.isVisible() && e.isBoat()){
                boardString = boardString + " 1 ";
            }
            else{
                boardString = boardString + " 0 ";
            }
            if (i % 10 == 0){
                boardString = boardString + "\n";
            }

        }
        return  boardString;
    }
}
