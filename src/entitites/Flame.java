package entitites;

import Game.Handler;
import Graphic.Animation;
import Graphic.Assets;

import java.awt.*;

public class Flame {
    int x, y, time, width, height;
    private Handler handler;
    private Animation explosion;
    public Flame(Handler handler, int x, int y) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.time = 0;
        explosion = new Animation(300, Assets.flameExplosion);
        width = 64;
        height = 64;
    }

    public void tick() {
        explosion.tick();
        ++ time;
    }

    public void render(Graphics g) {
        g.drawImage(explosion.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffSet()), (int) (y - handler.getGameCamera().getyOffset()) , width, height, null);

    }
    public int getTime() {
        return this.time;
    }

    public Rectangle getStaticBounds() {
        return new Rectangle(x, y, 64, 64);
    }

}

