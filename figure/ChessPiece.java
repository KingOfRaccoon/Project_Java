package com.mycompany.javachess.figure;

import javax.imageio.ImageIO;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class ChessPiece {

    public Point position;
    protected Boolean isWhite;
    protected BufferedImage image;

    public ChessPiece(Boolean isWhite, String imagePath, Point position) {
        try {
            this.image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        this.position = position;
        this.isWhite = isWhite;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Boolean getIsWhite() {
        return isWhite;
    }

    public void setIsWhite(Boolean isWhite) {
        this.isWhite = isWhite;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public abstract Point[] getPossibleMoves();
}
