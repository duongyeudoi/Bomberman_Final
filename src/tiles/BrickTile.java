package tiles;

import Graphic.Assets;

import java.awt.image.BufferedImage;

public class BrickTile extends Tile {
    public BrickTile( int id) {
        super(Assets.brick, id);
        super.solidState = true;
    }

}
