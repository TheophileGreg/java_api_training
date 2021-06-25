package fr.lernejo.navy_battle;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private OwnBoard myBoard;
    private OpponentBoard opponentBoard;
    private List<Boat> boats = new ArrayList<>();

    public Game(){
        //creer ses boats
        List<OwnCell> cellsBoats1 = new ArrayList<>();
        Boat boat1 = new Boat(cellsBoats1);
        cellsBoats1.add(new OwnCell(new Coordinates(0,1), true, boat1));
        cellsBoats1.add(new OwnCell(new Coordinates(0,2), true, boat1));

        List<OwnCell> cellsBoats2 = new ArrayList<>();
        Boat boat2 = new Boat(cellsBoats2);
        cellsBoats2.add(new OwnCell(new Coordinates(4,1), true,boat1));
        cellsBoats2.add(new OwnCell(new Coordinates(4,2), true,boat1));

        boats.add(boat1);
        boats.add(boat2);

        myBoard = new OwnBoard(boats);
        opponentBoard = new OpponentBoard();

    }

    public FireResult fireMe(String coordinatesAlpha, Board board){
        OwnCell cellToFire = myBoard.getCell(coordinatesAlpha);
        if(cellToFire.hit()){
            if (cellToFire.getBoat().checkBoat() == BoatStatus.sunked){
                return FireResult.sunk;
            }
            return FireResult.hit;
        }
        else {
            return FireResult.miss;
        }
    }

    public FireResult fireOpponent(String coordinatesAlpha, Board board){
        OpponentCell cellToFire = opponentBoard.getCell(coordinatesAlpha);
        if(cellToFire.hit()){
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

    public OwnBoard getMyBoard() {
        return myBoard;
    }

    public OpponentBoard getOpponentBoard() {
        return opponentBoard;
    }

    public String toStringMe() {
        int i = 0;
        String boardString = "\nGameBoard: \n 1 : signifie Touché - 0 : signifie loupé et X : signifie vierge \n" ;
        for ( OwnCell e : myBoard.getListCells()
             ) {
            i++;
            if (!e.isVisible()){
                boardString = boardString + " X ";
            }
            else if( e.isVisible() && e.getIsBoat()){
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

    public String toStringOpponent() {
        int i = 0;
        String boardString = "\nGameBoard: \n 1 : signifie Touché - 0 : signifie loupé et X : signifie vierge \n" ;
        for ( Cell e : opponentBoard.getListCells()
        ) {
            i++;
            if (!e.isVisible()){
                boardString = boardString + " X ";
            }
            else if( e.isVisible() && e.getIsBoat()){
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
