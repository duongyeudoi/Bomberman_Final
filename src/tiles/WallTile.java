package tiles;

import Graphic.Assets;

import java.awt.image.BufferedImage;

public class WallTile extends Tile {
    public WallTile(int id) {
        super(Assets.wall, id);
        solidState = true;
    }
}

