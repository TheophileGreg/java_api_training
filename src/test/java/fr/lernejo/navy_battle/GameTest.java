package fr.lernejo.navy_battle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    Game gameTest;

    @BeforeEach
    void setUp() {
        gameTest = new Game();
    }

    @Test
    void fire() {
        FireResult resultfireHit =  gameTest.fire("A2");
        FireResult resultfireMiss =  gameTest.fire("A1");
        FireResult resultfireSunk = gameTest.fire("A3");
        assertEquals(FireResult.hit, resultfireHit);
        assertEquals(FireResult.sunk, resultfireSunk);
        assertEquals(FireResult.miss, resultfireMiss);
    }

    @Test
    void getStatus() {
        gameTest.fire("A2");
        assertEquals(GameStatus.onGoing ,gameTest.getStatus());
        gameTest.fire("A3");
        gameTest.fire("E3");
        gameTest.fire("E2");
        assertEquals(GameStatus.lost ,gameTest.getStatus());
    }

    @Test
    void testToString() {

        String board = "\nGameBoard: \n" +
            " 1 : signifie Touché - 0 : signifie loupé et X : signifie vierge \n" +
            " X  1  X  X  X  X  X  X  X  X \n" +
            " X  X  X  X  X  X  X  X  X  X \n" +
            " X  X  X  X  X  X  X  X  X  X \n" +
            " X  X  X  X  X  X  X  X  X  X \n" +
            " X  X  X  X  X  X  X  X  X  X \n" +
            " X  X  X  X  X  X  X  X  X  X \n" +
            " X  X  X  X  X  X  X  X  X  X \n" +
            " X  X  X  X  X  X  X  X  X  X \n" +
            " X  X  X  X  X  X  X  X  X  X \n" +
            " X  X  X  X  X  X  X  X  X  X \n";

        gameTest.fire("A2");
        assertEquals(board, gameTest.toString());
    }
}
