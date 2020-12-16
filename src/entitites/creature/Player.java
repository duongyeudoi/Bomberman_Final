package entitites.creature;

import Game.*;
import Graphic.Animation;
import Graphic.Assets;
import audio.PlaySound;
import entitites.Bomb;
import entitites.BombManage;
import states.GameState;
import states.State;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private BombManage bM;
    private Animation animDown, animUp, animLeft, animRight;
    private Animation ike_death;
    public boolean turnOnDeath;
    public Player(Handler handler, float x, float y) {

        super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x = 12;
        bounds.y = 24;
        bounds.height = 48;
        bounds.width = 32;
        turnOnDeath = false;

        //Animations
        animDown = new Animation(500, Assets.player_down);
        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);
        animUp = new Animation(500, Assets.player_up);
        ike_death = new Animation(100, Assets.ike_death);
    }


    @Override
    public void tick() {
        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();
        ike_death.tick();
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

    }

    public void setbM(BombManage bM) {
        this.bM = bM;
    }
    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up) {
            yMove = -speed;
        }
        if (handler.getKeyManager().down) {
            yMove = +speed;
        }
        if (handler.getKeyManager().left) {
            xMove = -speed;
        }
        if (handler.getKeyManager().right) {
            xMove = speed;
        }

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffSet()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
      //  g.setColor(Color.RED);
      //  Rectangle b = getCollisionBounds(xMove, yMove);
        //g.drawRect( (int) (b.x - handler.getGameCamera().getxOffSet()), (int) (b.y - handler.getGameCamera().getyOffset()), b.width, b.height);
        //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffSet()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (isDeath == true) {
            if (ike_death.getCurrentFrame() == Assets.ike_death[5] && turnOnDeath) {
                //handler.getGame().stop();
               // PlaySound playSound = new PlaySound();
               // playSound.playMusic("D:\\OOP\\Game\\res\\audio\\levelfail.wav");
                State.setCurrentState(handler.getGame().LooseState);
            } else
            {
                turnOnDeath = true;
            }
            return ike_death.getCurrentFrame();
        }
        if (xMove < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {
            return animUp.getCurrentFrame();
        } else {
            return animDown.getCurrentFrame();
        }
    }

}
