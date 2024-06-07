package com.mycompany.javachess.figure;

import java.awt.Point;
import java.util.Arrays;

public class Knight extends ChessPiece {

    public Knight(Boolean isWhite, Point position) {
        super(isWhite, "images" + (isWhite ? "" : "/black") + "/knight.png", position);
    }

    public Knight(Boolean isWhite){
        super(isWhite, "images" + (isWhite ? "" : "/black") + "/knight.png", new Point(6, isWhite ? 7 : 0));
    }

    @Override
    public Point[] getPossibleMoves() {
        return Arrays.stream(new Point[]{
                new Point(position.x + 2, position.y + 1),
                new Point(position.x + 2, position.y - 1),
                new Point(position.x - 2, position.y + 1),
                new Point(position.x - 2, position.y - 1),
                new Point(position.x + 1, position.y + 2),
                new Point(position.x + 1, position.y - 2),
                new Point(position.x - 1, position.y + 2),
                new Point(position.x - 1, position.y - 2)
        }).filter(it -> it.x >= 0 && it.x < 8 && it.y >= 0 && it.y < 8).toArray(Point[]::new);
    }
}
