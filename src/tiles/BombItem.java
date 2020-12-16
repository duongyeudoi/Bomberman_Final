package tiles;

import Graphic.Assets;

import java.awt.image.BufferedImage;

public class BombItem extends Tile {
    public BombItem( int id) {
        super(Assets.bombItem, id);
        super.solidState = false;
    }
}
