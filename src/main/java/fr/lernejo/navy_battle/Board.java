package fr.lernejo.navy_battle;

import java.util.ArrayList;
import java.util.List;

public interface Board {

    default Cell getCell(String coordinatesAlpha){
        return null;
    }
}
