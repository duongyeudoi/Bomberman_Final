package tiles;

import Graphic.Assets;

import java.awt.image.BufferedImage;

public class FlameItem extends Tile {

    public FlameItem(int id) {
        super(Assets.flameItem, id);
        super.solidState = false;
    }
}
