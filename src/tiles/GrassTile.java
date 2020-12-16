package tiles;

import Graphic.Assets;

import java.awt.image.BufferedImage;

public class GrassTile extends Tile {
    public GrassTile( int id) {
        super(Assets.grass, id);
        super.solidState = false;
    }
}
