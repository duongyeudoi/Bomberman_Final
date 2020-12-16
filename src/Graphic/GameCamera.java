package Graphic;

import Game.Handler;
import entitites.Entity;
import tiles.Tile;

public class GameCamera {
    private float xOffSet, yOffset;
    private Handler handler;

    public GameCamera(Handler  handler, float xOffSet, float yOffset) {
        this.xOffSet = xOffSet;
        this.yOffset = yOffset;
        this.handler = handler;
    }
    public void checkBlankSpace() {
        if (xOffSet < 0) {
            xOffSet = 0;
        } else if (xOffSet > handler.getWorld().getWIDTH() * Tile.TILEWIDTH - handler.getWidth()) {
            xOffSet = handler.getWorld().getWIDTH() * Tile.TILEWIDTH - handler.getWidth();

        }
        if (yOffset < 0) {
            yOffset = 0;
        } else if (yOffset > handler.getWorld().getHEIGHT() * Tile.TILEHEIGHT - handler.getHeight()) {
            yOffset = handler.getWorld().getHEIGHT() * Tile.TILEHEIGHT - handler.getHeight();
        }
    }
    public void move(float xAmt, float yAmt) {
        xOffSet += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }
    public void centerOnEntity (Entity e) {
        xOffSet = e.getX() - handler.getWidth() / 2 + e.getWidth() /2 ;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();

    }

    public float getxOffSet() {
        return xOffSet;
    }

    public void setxOffSet(float xOffSet) {
        this.xOffSet = xOffSet;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
