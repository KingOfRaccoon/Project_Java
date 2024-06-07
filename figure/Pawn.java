package com.mycompany.javachess.figure;

import java.awt.Point;

public class Pawn extends ChessPiece {

    public Pawn(Boolean isWhite, Point position) {
        super(isWhite, "images/pawn.png", position);
    }

    public Pawn(Boolean isWhite) {
        super(isWhite, "images" + (isWhite ? "" : "/black") + "/pawn.png", new Point(2, isWhite ? 6 : 1));
    }

    @Override
    public Point[] getPossibleMoves() {
        return new Point[]{
                new Point(position.x, position.y + (getIsWhite() ? -1 : 1)),
                new Point(position.x, position.y + 2 * (getIsWhite() ? -1 : 1))
        };
    }
}