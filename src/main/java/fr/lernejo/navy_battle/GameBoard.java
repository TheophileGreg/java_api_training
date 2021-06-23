package fr.lernejo.navy_battle;

import java.util.List;

public class GameBoard {

    private List<Coordinates> board;

    public GameBoard(){
        for (int i = 0; i < 10; i++) {
            for (int j = i % 2; j < 10; j += 2) {
                board.add(new Coordinates(i, j));
            }
        }
    }

}
