/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javachess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author aid
 */
public class JavaChess extends JFrame implements ItemListener {

    private final ChessBoardPanel chessBoardPanel;

    public JavaChess() {
        setTitle("Chess Board");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chessBoardPanel = new ChessBoardPanel();
        add(chessBoardPanel, BorderLayout.CENTER);

        // Панель с выпадающим списком фигур
        JPanel pieceSelectionPanel = new JPanel();
        String[] pieces = {
                "Ничего не выбрано",
                "Белая пешка",
                "Белая ладья",
                "Белый конь",
                "Белый слон",
                "Белый ферзь",
                "Белый король",
                "Черная пешка",
                "Черная ладья",
                "Черный конь",
                "Черный слон",
                "Черный ферзь",
                "Черный король"
        };
        JComboBox<String> pieceComboBox = new JComboBox<>(pieces);

        pieceSelectionPanel.add(new JLabel("Выберите фигуру: "));
        pieceSelectionPanel.add(pieceComboBox);
        pieceComboBox.addItemListener(this);

        add(pieceSelectionPanel, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JavaChess gui = new JavaChess();
            gui.setVisible(true);
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String[] command = e.getItemSelectable().getSelectedObjects()[0].toString().split(" ");
        chessBoardPanel.setSelectedPiece(command[1], command[0].contains("Бел"));
    }
}
