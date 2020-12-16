package tiles;

import Graphic.Assets;

import java.awt.image.BufferedImage;

public class PortalTile extends Tile {
    public PortalTile( int id) {
        super(Assets.portal, id);
        super.solidState = false;
    }


}
