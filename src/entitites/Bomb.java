package entitites;

import Game.Handler;
import Graphic.Animation;
import Graphic.Assets;
import tiles.Tile;

import java.awt.*;

public class Bomb extends Entity {

    private Animation anistatic;
    private int time;
    public boolean isSolid;
    public Bomb(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        anistatic = new Animation(300, Assets.bomb_static);
        time = 0;
        bounds = new Rectangle((int) x, (int) y, width, height);
        isSolid = false;
    }

    @Override
    public void tick() {
        anistatic.tick();
        ++ time;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(anistatic.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffSet()), (int) (y - handler.getGameCamera().getyOffset()) , width, height, null);

    }
    public int getTime() {
        return this.time;
    }
}
