package com.mycompany.javachess.figure;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rook extends ChessPiece {

    public Rook(Boolean isWhite, Point position) {
        super(isWhite, "images" + (isWhite ? "" : "/black") + "/rook.png", position);
    }

    public Rook(Boolean isWhite){
        super(isWhite, "images" + (isWhite ? "" : "/black") + "/rook.png", new Point(0, isWhite ? 7: 0));
    }

    @Override
    public Point[] getPossibleMoves() {
        List<Point> moves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            moves.add(new Point(position.x + i, position.y));
            moves.add(new Point(position.x - i, position.y));
            moves.add(new Point(position.x, position.y + i));
            moves.add(new Point(position.x, position.y - i));
        }

        return Arrays.stream(moves.toArray(new Point[0]))
                .filter(it -> it.x >= 0 && it.x < 8 && it.y >= 0 && it.y < 8)
                .toArray(Point[]::new);
    }
}
