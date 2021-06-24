package fr.lernejo.navy_battle;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {

    private List<Cell> board = new ArrayList<>();

    public GameBoard(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Cell actCell = new Cell (new Coordinates(i, j), i==j);
                board.add(actCell);
            }
        }
    }

    public Cell findCell(Coordinates coordinates){
        for (Cell e: board
             ) {
            if(e.hashCode() == coordinates.hashCode()){
                return e;
            }
        }
        return null;
    }
    public FireResult hitACell(Coordinates coordinates){
        if(findCell(coordinates).hit()){
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
        for ( Cell e : board
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
