package entitites;

import Game.Handler;
import entitites.creature.Lodumani;
import states.State;

import java.awt.*;
import java.util.ArrayList;

public class BotManage {
    public ArrayList<Lodumani> loduList;
    private Rectangle playerBounds;
    private Handler handler;
    public ArrayList<Bomb> bombList = new ArrayList<>();
    public ArrayList<Flame> flamesList = new ArrayList<>();

    public BotManage(Handler handler) {
        this.handler = handler;
        loduList = new ArrayList<>();

    }

    public void getBombState(ArrayList<Bomb> bombList) {
        this.bombList = bombList;
    }

    public void getFlameState(ArrayList<Flame> flamesList) {
        this. flamesList = flamesList;
    }



    public void tick() {
        int i = 0;
        while (i < loduList.size()) {
            loduList.get(i).getBombState(bombList);
            loduList.get(i).getFlameState(flamesList);
            loduList.get(i).tick();
            if (loduList.get(i).getCollisionBounds(loduList.get(i).getxMove(), loduList.get(i).getyMove()).intersects(playerBounds)) {
                State.setCurrentState(handler.getGame().LooseState);
            }
            if (loduList.get(i).death == true) {
                loduList.remove(i);
            } else {
                ++ i;
            }
        }


    }

    public void render(Graphics g) {
        for (Lodumani lodu : loduList) {
            lodu.render(g);
        }
    }

    public void getPlayerBound(Rectangle playerBound) {
        this.playerBounds = playerBound;
    }

}
