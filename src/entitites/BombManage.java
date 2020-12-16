package entitites;

import Game.Handler;
import audio.PlaySound;
import entitites.creature.Player;
import javafx.util.Pair;
import states.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BombManage {
    public ArrayList<Bomb> bombList;
    public int botNumber;
    private Handler handler;
    private Player player;
    private int playerPosX, playerPosY;
    Rectangle playerRec;
    public int explosionLength;
    Pair<Integer, Integer> ePos;
    public ArrayList<Pair<Integer, Integer>> exposionPos;
    public ArrayList<Flame> flamesList = new ArrayList<>();
    public  int bombLimit;
    public  boolean hasPortal;
    public int levelUptick;
    public int mucDo;
    public BombManage(Handler handler, Player player) {
        this.player = player;
        bombList = new ArrayList<Bomb>();
        this.handler = handler;
        playerRec = new Rectangle(0, 0, 18, 18);
        explosionLength = 1;
        exposionPos = new ArrayList<>();
        bombLimit = 1;
        hasPortal = false;
        levelUptick = 0;
        mucDo = 20;
    }

    public void getBotNumber(int botNumber) {
        this.botNumber = botNumber;
    }


    public void tick() {
        getInput();
        int i = 0;
        while (i < bombList.size()) {
            bombList.get(i).tick();
            if (bombList.get(i).getTime() == 120) {
                PlaySound p = new PlaySound();
                p.playMusic(".\\res\\audio\\explosion.wav");
                explosionOn((int) bombList.get(i).getX(), (int) bombList.get(i).getY());
                bombList.remove(i);
            } else {
                ++ i;
            }
        }
        i = 0;
        while (i < flamesList.size()) {
            flamesList.get(i).tick();
            if (flamesList.get(i).getTime() == 30) {
                flamesList.remove(i);
            } else {
                ++ i;
            }
        }
    }

    public void render(Graphics g) {
     //   g.drawRect((int) (playerRec.x - handler.getGameCamera().getxOffSet()), (int) (playerRec.y - handler.getGameCamera().getyOffset()) , playerRec.width, playerRec.height);
        for (Bomb b : bombList) {
            b.render(g);
           // g.drawRect((int) (b.bounds.x - handler.getGameCamera().getxOffSet()), (int) (b.bounds.y - handler.getGameCamera().getyOffset()) , b.bounds.width, b.bounds.height);
        }
        for (Flame f : flamesList) {
            f.render(g);
        }
    }



    private void getInput() {
        if (handler.getKeyManager().space) {
            for (Bomb b : bombList) {
                if (b.x == playerPosX && b.y == playerPosY) {
                    return;
                }
            }
            if (bombList.size() < bombLimit) {
                PlaySound p = new PlaySound();
                p.playMusic(".\\res\\audio\\place_bomb.wav");
                bombList.add(new Bomb(handler, playerPosX, playerPosY, 64, 64));
            }
        }
    }

    public void getPlayerPos(Player player) {
        this.playerPosX = (int) player.getX();
        this.playerPosY = (int) player.getY();
   //     System.out.println(playerPosX + " " + playerPosY);
        playerRec.x = this.playerPosX + 24;
        playerRec.y = this.playerPosY + 46;
        this.playerPosX += 36;
        this.playerPosY += 36;
        int tX = playerPosX / 64;
        int tY = playerPosY / 64;
        if (this.playerPosX > tX * 64 + 60) {
            this.playerPosX = 64 * (tX + 1);
        } else {
            this.playerPosX = 64 * (tX);
        }
        if (this.playerPosY > tY * 64 + 48) {
            this.playerPosY = 64 * (tY + 1);
        } else {
            this.playerPosY = 64 * (tY);
        }

        // An Item

        switch (handler.getWorld().getTile(playerPosX / 64, playerPosY / 64).getId()) {
            case 4 :
                handler.getWorld().changeTile(playerPosX / 64, playerPosY / 64, 0);
                ++ bombLimit;
                break;
            case 5 :
                handler.getWorld().changeTile(playerPosX / 64, playerPosY / 64, 0);
                ++ explosionLength;
                break;
            case 3 :
                if (botNumber == 0) {
                    {
                        System.out.println("YOU WIN !");
                        ++ levelUptick;
                    }
                    if (levelUptick == 20) {
                        State.setCurrentState(handler.getGame().WinState);
                    }

                    //handler.getGame().stop();
                }
                break;
        }
    }

    public void explosionOn(int x, int y) {
        flamesList.add(new Flame(handler, x, y));
        Random rand = new Random();
        int so;
        int i = 1;


        while ( i <= explosionLength) {
            if (handler.getWorld().getTile(x / 64 + i, y / 64).getId() != 1) {
                if (handler.getWorld().getTile(x / 64 + i, y / 64).getId() == 2) {
                    so = rand.nextInt(mucDo);
                    if (so == 1) {
                        //DropBombItem
                        handler.getWorld().changeTile(x / 64 + i, y / 64, 4);
                        break;
                    } else if (so == 2) {
                        //DropFlameItem
                        handler.getWorld().changeTile(x / 64 + i, y / 64, 5);
                        break;
                    } else if (so >= 15 && hasPortal == false) {
                        //DropFlameItem
                        handler.getWorld().changeTile(x / 64 + i, y / 64, 3);
                        hasPortal = true;
                        break;
                    } else {
                        //DropGrass
                        handler.getWorld().changeTile(x / 64 + i, y / 64, 0);
                        break;
                    }
                }
                flamesList.add(new Flame(handler, x + 64 * i, y));
                ++ i;

                } else {
                break;
            }
        }

        i = 1;
        while ( i <= explosionLength) {
            if (handler.getWorld().getTile(x / 64 - i, y / 64).getId() != 1) {
                if (handler.getWorld().getTile(x / 64 - i, y / 64).getId() == 2) {
                    so = rand.nextInt(mucDo);
                    if (so == 1) {
                        //DropBombItem
                        handler.getWorld().changeTile(x / 64 - i, y / 64, 4);
                        break;
                    } else if (so == 2) {
                        //DropFlameItem
                        handler.getWorld().changeTile(x / 64 - i, y / 64, 5);
                        break;
                    } else if (so >= 15 && hasPortal == false) {
                        //DropFlameItem
                        handler.getWorld().changeTile(x / 64 - i, y / 64, 3);
                        hasPortal = true;
                        break;
                    } else {
                        //DropGrass
                        handler.getWorld().changeTile(x / 64 - i, y / 64, 0);
                        break;
                    }
                }
                flamesList.add(new Flame(handler, x - 64 * i, y));
                ++ i;
            } else {
                break;
            }
        }

        i = 1;
        while ( i <= explosionLength) {
            if (handler.getWorld().getTile(x / 64, y / 64 + i).getId() != 1) {

                if (handler.getWorld().getTile(x / 64, y / 64 + i).getId() == 2) {
                    so = rand.nextInt(mucDo);
                    if (so == 1) {
                        //DropBombItem
                        handler.getWorld().changeTile(x / 64, y / 64 + i, 4);
                        break;
                    } else if (so == 2) {
                        //DropFlameItem
                        handler.getWorld().changeTile(x / 64, y / 64 + i, 5);
                        break;
                    } else if (so >= 15 && hasPortal == false) {
                        //DropFlameItem
                        handler.getWorld().changeTile(x / 64 , y / 64 + i, 3);
                        hasPortal = true;
                        break;
                    } else {
                        //DropGrass
                        handler.getWorld().changeTile(x / 64, y / 64 + i, 0);
                        break;
                    }
                }
                flamesList.add(new Flame(handler, x , y + 64 * i));
                ++ i;
            } else {
                break;
            }
        }

        i = 1;
        while ( i <= explosionLength) {
            if (handler.getWorld().getTile(x / 64, y / 64 - i).getId() != 1) {

                if (handler.getWorld().getTile(x / 64, y / 64 - i).getId() == 2) {
                    so = rand.nextInt(mucDo);
                    if (so == 1) {
                        //DropBombItem
                        handler.getWorld().changeTile(x / 64, y / 64 - i, 4);
                        break;
                    } else if (so == 2) {
                        //DropFlameItem
                        handler.getWorld().changeTile(x / 64, y / 64 - i, 5);
                        break;
                    } else if (so >= 15 && hasPortal == false) {
                        //DropFlameItem
                        handler.getWorld().changeTile(x / 64 , y / 64 - i, 3);
                        hasPortal = true;
                        break;
                    } else {
                        //DropGrass
                        handler.getWorld().changeTile(x / 64, y / 64 - i, 0);
                        break;
                    }
                }
                flamesList.add(new Flame(handler, x , y - 64 * i));
                ++ i;
            } else {
                break;
            }
        }
    }
}
