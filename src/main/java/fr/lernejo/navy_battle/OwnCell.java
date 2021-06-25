package fr.lernejo.navy_battle;

import java.util.Objects;

public class OwnCell extends Cell{
    private Boat boat;

    OwnCell(Coordinates coordinates, boolean boatBool, Boat boatArg) {
        super(coordinates, boatBool);
        boat = boatArg;
    }


    public Boat getBoat() {
        return boat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OwnCell ownCell = (OwnCell) o;
        return Objects.equals(boat, ownCell.boat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), boat);
    }
}
