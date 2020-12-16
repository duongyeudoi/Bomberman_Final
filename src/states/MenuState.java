package states;

import Game.*;
import Graphic.Assets;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;
import audio.PlayMusic;
import audio.PlaySound;

import java.awt.*;

public class MenuState extends State {
  //  public UIManager uImanager,tutManager;
    public UIManager uImanager,tutManager,gameManager;
    public MenuState(Handler handler) {
        super(handler);
        PlayMusic play = new PlayMusic();
        play.playMusic(".\\res\\audio\\menu.wav");
        uImanager = new UIManager(handler);
        tutManager = new UIManager(handler);
       try {
           handler.getMouseManager().setUiManager(uImanager);
       } catch (NullPointerException e) {
           e.printStackTrace();
       }

        //handler.getMouseManager().setUiManager(uImanager);
        uImanager.addObject(new UIImageButton(350, 352, 300, 110, Assets.startButton, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(uImanager);
                State.setCurrentState(handler.getGame().gameState);
                PlaySound start = new PlaySound();
                start.playMusic(".\\res\\audio\\start.wav");
                play.stop();
                play.playMusic(".\\res\\audio\\xmas.wav");
            }
        }));

        uImanager.addObject(new UIImageButton(350, 480, 300, 110, Assets.closeButton, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                System.exit(0);

            }
        }));
        uImanager.addObject(new UIImageButton(10, 600, 71, 70, Assets.tutorialButton, new ClickListener() {
            @Override
            public void onClick() {

                handler.getMouseManager().setUiManager(tutManager);
                State.setCurrentState(handler.getGame().TutorialState);

            }
        }));
        tutManager.addObject(new UIImageButton(450, 550, 70, 79, Assets.back, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(uImanager);
                State.setCurrentState(handler.getGame().menuState);
            }
        }));
        uImanager.addObject(new UIImageButton(10, 500, 71, 70, Assets.soundButton, new ClickListener() {
            @Override
            public void onClick() {
                play.stop();
            }
        }));

        uImanager.addObject(new UIImageButton(350, 480, 300, 110, Assets.closeButton, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                System.exit(0);

            }
        }));

    }

    @Override
    public void tick() {
        uImanager.tick();
        //  AudioManager.menu.play();

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background1,0,0,960,704,null);
        g.drawImage(Assets.title,0,0,960,704,null);
        uImanager.render(g);


    }
}
