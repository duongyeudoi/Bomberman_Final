package Game;

import Graphic.GameCamera;
import entitites.BombManage;
import entitites.creature.Player;
import input.KeyManager;
import input.MouseManager;
import world.World;

public class Handler {
    private Game game;
    private World world;
    public BombManage bM;
    public Player player;
    public Handler(Game game) {
        this.game = game;
    }
    public void setBombManage(BombManage bM) {
        this.bM = bM;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }
    public int getWidth() {
        return game.getWidth();
    }
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }
    public Player getPlayer() {
        return this.player;
    }

}
