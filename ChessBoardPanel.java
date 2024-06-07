package com.mycompany.javachess;

import com.mycompany.javachess.figure.*;
import com.mycompany.javachess.figure.ChessPiece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ChessBoardPanel extends JPanel {

    private static final int BOARD_SIZE = 8;
    private ChessPiece selectedPiece;
    private List<Point> highlightedCells;

    public ChessBoardPanel() {
        setPreferredSize(new Dimension(600, 600));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / (getWidth() / BOARD_SIZE);
                int y = e.getY() / (getHeight() / BOARD_SIZE);

                if (selectedPiece != null) {
                    selectedPiece.setPosition(new Point(x, y));
                    highlightedCells = List.of(selectedPiece.getPossibleMoves());
                    repaint();
                }
            }
        });
        highlightedCells = new ArrayList<>();
    }

    public void setSelectedPiece(String type, Boolean isWhite) {
        switch (type) {
            case "пешка":
                selectedPiece = new Pawn(isWhite);
                break;
            case "ладья":
                selectedPiece = new Rook(isWhite);
                break;
            case "конь":
                selectedPiece = new Knight(isWhite);
                break;
            case "слон":
                selectedPiece = new Bishop(isWhite);
                break;
            case "ферзь":
                selectedPiece = new Queen(isWhite);
                break;
            case "король":
                selectedPiece = new King(isWhite);
                break;
            default:
                selectedPiece = null;
                break;
        }
        if (selectedPiece != null)
            highlightedCells = List.of(selectedPiece.getPossibleMoves());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = Math.min(getWidth() / BOARD_SIZE, getHeight() / BOARD_SIZE);

        // Рисуем шахматную доску
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
            }
        }

        // Рисуем фигуру
        if (selectedPiece != null) {
            Point position = selectedPiece.getPosition();
            if (selectedPiece.getImage() != null) {
                g.drawImage(selectedPiece.getImage(), position.x * cellSize, position.y * cellSize, cellSize, cellSize, this);
            }

            // Рисуем возможные ходы
            g.setColor(Color.BLUE);
            for (Point move : highlightedCells) {
                g.fillRect(move.x * cellSize, move.y * cellSize, cellSize, cellSize);
            }
        }
    }
}