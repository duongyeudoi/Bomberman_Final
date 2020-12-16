package Game;

import Graphic.Assets;
import Graphic.GameCamera;
import input.KeyManager;
import input.MouseManager;
import states.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private Display display;
    private int width,height;
    private Thread thread;
    private boolean running = false;
    public String title;
    private BufferStrategy bs;
    private Graphics g;
    private MouseManager mouseManager;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //State
    public State gameState;
    public State getGameStateLevel2;
    public State menuState;
    public State TutorialState;
    public State LooseState;
    public State WinState;

    //Input
    private KeyManager keyManager;

    //Camera
    private GameCamera gameCamera;

    //Handler
    private Handler handler;


    public Game(String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }
    private void init() {

        display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        LooseState = new LooseState(handler);
        WinState = new WinState(handler);
        State.setCurrentState(menuState);
        TutorialState = new TutorialState(handler);

    }
    int x = 0;

    private void tick() {
        keyManager.tick();
        if(State.getCurrentState() != null) {
            State.getCurrentState().tick();
        }

    }
// TODO: ve game
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0,0,width,height);
        //Draw here!
        if(State.getCurrentState() != null) {
            State.getCurrentState().render(g);
        }


        //End draw
        bs.show();
        g.dispose();
    }
    public void run() {
        init();
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;

            }
            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }

        }
        stop();

    }

    public KeyManager getKeyManager() {

        return keyManager;
    }
    public GameCamera getGameCamera() {

        return gameCamera;
    }

    public synchronized void start() {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() {
        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

}
