package de.mika32.GUI;

import java.util.ArrayList;

import de.mika32.Constants.MoveDir;
import de.mika32.tools.Pos;

public class Snake {
    private static ArrayList<Pos> partCords = new ArrayList<>();
    private static MoveDir direction = MoveDir.RIGHT;

    public static ArrayList<Pos> getPos() {
        return partCords;
    }

    public static void addPartCords(Pos p) {
        Snake.partCords.add(p);
    }

    public static MoveDir getDirection() {
        return direction;
    }

    public static void setDirection(MoveDir direction) {
        Snake.direction = direction;
    }
}
