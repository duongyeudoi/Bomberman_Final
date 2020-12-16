package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
//STATIC STUFF
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile wallTile = new WallTile(1);
    public static Tile brickTile = new BrickTile(2);
    public static Tile portalTile = new PortalTile(3);
    public static Tile bombItem = new BombItem(4);
    public static Tile flameItem = new FlameItem(5);


    //CLASS
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    protected boolean solidState;
    protected BufferedImage texture;
    protected int id;
    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);


    }

    public boolean isSolid() {
        return solidState;
    }


    public int getId() {
        return id;
    }
}
