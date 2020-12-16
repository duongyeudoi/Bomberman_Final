package states;

import Game.Game;
import Graphic.Assets;
import audio.PlaySound;
import entitites.Bomb;
import entitites.BombManage;
import entitites.BotManage;
import entitites.creature.Lodumani;
import entitites.creature.Player;
import tiles.Tile;
import world.World;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import Game.*;
public class GameState extends State {
    private Player player;
    private World world;
    private BombManage bombList;
    private BotManage botList;
    public static PlaySound pS = new PlaySound();
    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, ".\\res\\levels\\Level1EX.txt");
        handler.setWorld(world);
        player = new Player(handler,80,80);
        handler.getGameCamera().move(100,200);
        bombList = new BombManage(handler, player);
        botList = new BotManage(handler);
        for (int i = 0; i < world.HEIGHT; i++) {
            for (int j = 0; j < world.WIDTH; j++) {
                System.out.print(world.tiles[j][i]);
                switch (world.tiles[j][i]) {
                    case 69 :
                        botList.loduList.add(new Lodumani(handler, j * 64, i * 64,1));
                        break;
                    case 96 :
                        botList.loduList.add(new Lodumani(handler, j * 64, i * 64,2));
                        break;
                    default:
                        break;

                }
            }
        }


    }

    @Override
    public void tick() {
        world.tick();
        player.getBombState(bombList.bombList);
        player.getFlameState(bombList.flamesList);
        player.tick();
        handler.getGameCamera().move(1,1);
        //handler.getPlayer(player);
        bombList.getPlayerPos(player);
        bombList.getBotNumber(botList.loduList.size());
        bombList.tick();

        botList.getBombState(bombList.bombList);
        botList.getFlameState(bombList.flamesList);
        botList.getPlayerBound(player.getCollisionBounds(player.getxMove(), player.getyMove()));
        botList.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
        bombList.render(g);
        botList.render(g);
    }
}
