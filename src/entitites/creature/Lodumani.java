package entitites.creature;

import Game.Handler;
import Graphic.Animation;
import Graphic.Assets;
import entitites.Bomb;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Lodumani extends Creature {

    private Animation animDown, animUp, animLeft, animRight;
    int moveDirTime;
    private int dir;
    public boolean death;
    int type;

    public Lodumani(Handler handler, float x, float y, int type) {

        super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.type = type;
        bounds.x = 12;
        bounds.y = 24;
        bounds.height = 50;
        if (type == 2) {
            bounds.height = 45;
        }
        bounds.width = 35;
        if (type == 2) {
            bounds.width = 28;
        }
        death = false;
        moveDirTime = 0;
        dir = 0;

        xMove = 3;
        yMove = 3;

        speed = 2;
        if (type == 2)
            speed = 4;

        //Animations
        if (type == 1) {
            animDown = new Animation(500, Assets.lodumani_down);
            animLeft = new Animation(500, Assets.lodumani_left);
            animRight = new Animation(500, Assets.lodumani_right);
            animUp = new Animation(500, Assets.lodumani_up);
        }
        if (type == 2) {
            animDown = new Animation(500, Assets.manidulo_down);
            animLeft = new Animation(500, Assets.manidulo_left);
            animRight = new Animation(500, Assets.manidulo_right);
            animUp = new Animation(500, Assets.manidulo_up);
        }
    }

    public boolean checkCollisionWithBombforLodumani(float xOffset, float yOffset) {
        if (bombList.size() <= 0 )
            return false;
        for (Bomb b : bombList) {
            if (b.getStaticBounds().intersects(getCollisionBounds(xOffset, yOffset))) {
                return true;
            }
        }
        return false;
    }

    public int xPosGrid() {
        int res = (int) super.getX();
        res += 36;
        int tX = res / 64;
        if (res > tX * 64 + 60) {
            res = 64 * (tX + 1);
        } else
            res = 64 * tX;
        return res / 64;

        //int res = (int) super.getX();
    }

    public int yPosGrid() {
        int res = (int) super.getY();
        res += 36;
        int tY = res / 64;
        if (res > tY * 64 + 48) {
            res = 64 * (tY + 1);
        } else {
            res = 64 * tY;
        }
        return res / 64;
    }

    public boolean canMoveDir(int v) {
        int X = xPosGrid();
        int Y = yPosGrid();
        int upType = handler.getWorld().getTile(X, Y - 1).getId();
        int downType = handler.getWorld().getTile(X, Y + 1).getId();
        int leftType = handler.getWorld().getTile(X - 1, Y).getId();
        int rightType = handler.getWorld().getTile(X + 1, Y).getId();
        switch (v) {
            case 0:
                if (upType != 1 && upType != 2) {
                    return true;
                }
                break;
            case 1:
                if (rightType != 1 && rightType != 2) {
                    return true;
                }
                break;
            case 2:
                if (downType != 1 && downType != 2) {
                    return true;
                }
                break;
            case 3:
                if (leftType != 1 && leftType != 2) {
                    return true;
                }
                break;
        }
        return false;

    }

    void automove() {
        Random random = new Random();
        if (super.x == super.xOld && super.y == yOld) {
            ++ dir;
            if (dir == 4) {
                dir = random.nextInt(4);
            }
            //moveDirTime = 400;
        }

        Rectangle b = getCollisionBounds(xMove - 1, yMove - 1);
        if (type == 2) {
            b = getCollisionBounds(xMove -1 , yMove -1 );
        }
        System.out.println(moveDirTime);
        if (dir != 0 && dir != 2 && moveDirTime > 600 && b.x > 64 * (b.x / 64) && b.x < 64 * (b.x / 64) + 64 - 1 - b.width) {
            int X = b.x / 64;
            int Y = b.y / 64;
            if (handler.getWorld().getTile(X, Y - 1).getId() == 0 && random.nextBoolean()) {
                dir = 0;
                moveDirTime = 0;
                if (type == 2)
                    moveDirTime = 300;
            }
            if (handler.getWorld().getTile(X, Y + 1).getId() == 0 && random.nextBoolean()) {
                dir = 2;
                moveDirTime = 0;
                if (type == 2)
                    moveDirTime = 300;
            }
        }

        if (dir != 1 && dir != 3 && moveDirTime > 600 && b.y > 64 * (b.y / 64) && b.y < 64 * (b.y / 64) + 64 - 1 - b.height) {
            int X = b.x / 64;
            int Y = b.y / 64;
            if (handler.getWorld().getTile(X - 1, Y).getId() == 0 && random.nextBoolean()) {
                dir = 3;
                moveDirTime = 0;
                if (type == 2)
                    moveDirTime = 300;
            }
            if (handler.getWorld().getTile(X + 1, Y).getId() == 0 && random.nextBoolean()) {
                dir = 1;
                moveDirTime = 0;
                if (type == 2)
                    moveDirTime = 300;
            }
        }


        switch (dir) {
            case 0 :
                //UP
                yMove = -speed;
                xMove = 0;
                break;
            case 1 :
                //RIGHT
                xMove = speed;
                yMove = 0;
                break;
            case 2 :
                //DOWN
                yMove = speed;
                xMove = 0;
                break;
            case 3:
                //LEFT
                xMove = -speed;
                yMove = 0;
                break;
        }


        if (checkCollisionWithFlame(xMove, yMove)) {
            death = true;
        }

        if (!checkCollisionWithBombforLodumani(xMove, 0)) {
            moveX();
        } else {
            xMove *= -1;
            x += xMove;
        }

        if (!checkCollisionWithBombforLodumani(0, yMove)) {
            moveY();
        } else {
            yMove *= -1;
            y += yMove;
        }

    }

    @Override
    public void tick() {
        animDown.tick();
        animUp.tick();
        animRight.tick();
        animLeft.tick();
        automove();
        ++ moveDirTime;
        if (moveDirTime > 1000000) {
            moveDirTime = 400;
        }
    }

    @Override
    public void render(Graphics g) {
        //System.out.println(x + " " + y);
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffSet()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
       // Rectangle b = getCollisionBounds(xMove, yMove);
       // g.drawRect( (int) (b.x - handler.getGameCamera().getxOffSet()), (int) (b.y - handler.getGameCamera().getyOffset()), b.width, b.height);
    }

    private BufferedImage getCurrentAnimationFrame() {
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
