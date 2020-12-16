package world;

import Game.*;
import tiles.Tile;
import utils.SolveMapInputFile;
import utils.Utils;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class World {
    public int WIDTH, HEIGHT, level;
    public int[][] tiles;
    private Handler handler;

    public World(Handler handler, String path)  {
        this.handler = handler;
        loadWorld(path);

    }

    public void tick() {

    }

    public void render(Graphics g) {
        int xStart = (int) Math.max(0,handler.getGameCamera().getxOffSet() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(WIDTH, (handler.getGameCamera().getxOffSet() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(HEIGHT, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                try {
                    getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffSet()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }


    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= WIDTH || y >= HEIGHT)
            return Tile.grassTile;
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.grassTile;
        }
        return t;
    }

    public void changeTile(int x, int y, int type) {
        tiles[x][y] = type;
    }

    private void loadWorld(String path) {
        String fileData = "";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            Scanner myReader = new Scanner(fileInputStream);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fileData += data + '\n';
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SolveMapInputFile inputFileData = new SolveMapInputFile(fileData);

        WIDTH = inputFileData.Width;
        HEIGHT = inputFileData.Height;
        tiles = new int[WIDTH][HEIGHT];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
               tiles[j][i] = inputFileData.mapp[i][j];
               }
            }
    }


    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
}






