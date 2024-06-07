package com.mycompany.javachess.figure;

import java.awt.Point;
import java.util.Arrays;

public class King extends ChessPiece {

    public King(Boolean isWhite, Point position) {
        super(isWhite, "images" + (isWhite ? "" : "/black") +  "/king.png", position);
    }

    public King(Boolean isWhite) {
        super(isWhite, "images" + (isWhite ? "" : "/black") + "/king.png", new Point(4, isWhite ? 7 : 0));
    }

    @Override
    public Point[] getPossibleMoves() {
        return Arrays.stream(new Point[]{
                new Point(position.x + 1, position.y),
                new Point(position.x - 1, position.y),
                new Point(position.x, position.y + 1),
                new Point(position.x, position.y - 1),
                new Point(position.x + 1, position.y + 1),
                new Point(position.x - 1, position.y - 1),
                new Point(position.x + 1, position.y - 1),
                new Point(position.x - 1, position.y + 1)
        }).filter(it -> it.x >= 0 && it.x < 8 && it.y >= 0 && it.y < 8).toArray(Point[]::new);
    }
}
