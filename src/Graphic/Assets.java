package Graphic;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Assets {
    private static final int width = 61, height = 63;
    public static BufferedImage bomb,wall, grass, brick,portal, balloon, Oneal, bombItem, flameItem, speedItem;
    public static BufferedImage youWin;
    public static BufferedImage[] player_down,player_up,player_left, player_right, bomb_static, flameExplosion;
    public static BufferedImage[] ike_death;
    public static BufferedImage[] lodumani_down, lodumani_up, lodumani_left, lodumani_right;
    public static BufferedImage[] manidulo_down, manidulo_up, manidulo_left, manidulo_right;
    public static BufferedImage[] startButton, tutorialButton, closeButton, back;
    public static BufferedImage background1,title,background2,controlTutorial;
    public static BufferedImage[] soundButton;

    public static void init() {
        SpriteSheet player = new SpriteSheet(ImageLoader.loadImage(".\\res\\asset\\character\\ike.png"));
        SpriteSheet flame = new SpriteSheet(ImageLoader.loadImage(".\\res\\asset\\bomb\\bomb_effect\\bomb_fire.png"));
        SpriteSheet lodumani = new SpriteSheet(ImageLoader.loadImage(".\\res\\asset\\character\\lodumani.png"));
        SpriteSheet ikeDeath = new SpriteSheet(ImageLoader.loadImage(".\\res\\asset\\character\\ike_death.png"));
        SpriteSheet manidulo = new SpriteSheet(ImageLoader.loadImage(".\\res\\asset\\character\\manidulo.png"));

        //Assets for Tiles and Items

        grass = ImageLoader.loadImage(".\\res\\asset\\map_asset\\desert\\floor.png");
        brick = ImageLoader.loadImage(".\\res\\asset\\map_asset\\desert\\brick_new.png");
        wall = ImageLoader.loadImage(".\\res\\asset\\map_asset\\desert\\stone_new.png");
        portal = ImageLoader.loadImage(".\\res\\asset\\item\\dooropen.png");
        balloon = ImageLoader.loadImage(".\\res\\asset\\character\\lodumani.png");
        Oneal = ImageLoader.loadImage(".\\res\\asset\\character\\evie.png");
        bombItem = ImageLoader.loadImage(".\\res\\asset\\item\\bomb_incre.png");
        speedItem = ImageLoader.loadImage(".\\res\\asset\\item\\speedup.png");
        flameItem = ImageLoader.loadImage(".\\res\\asset\\item\\bomb_power.png");


        /*
        //Assets for Tiles and Items
        grass = ImageLoader.loadImage(".\\res\\asset\\map_asset\\xmas\\floor.png");
        brick = ImageLoader.loadImage(".\\res\\asset\\map_asset\\xmas\\gift_box.png");
        wall = ImageLoader.loadImage(".\\res\\asset\\map_asset\\xmas\\stone.png");
        portal = ImageLoader.loadImage(".\\res\\asset\\item\\dooropen.png");
        balloon = ImageLoader.loadImage(".\\res\\asset\\character\\lodumani.png");
        Oneal = ImageLoader.loadImage(".\\res\\asset\\character\\evie.png");
        bombItem = ImageLoader.loadImage(".\\res\\asset\\item\\bomb_incre.png");
        speedItem = ImageLoader.loadImage(".\\res\\asset\\item\\speedup.png");
        flameItem = ImageLoader.loadImage(".\\res\\asset\\item\\bomb_power.png");

         */




        //Assets for Ike_death
        ike_death = new BufferedImage[6];

        ike_death[0] = ikeDeath.crop(0, 0, 50, 64);
        ike_death[1] = ikeDeath.crop(50, 0, 50, 64);
        ike_death[2] = ikeDeath.crop(100, 0, 50, 64);
        ike_death[3] = ikeDeath.crop(150, 0, 50, 64);
        ike_death[4] = ikeDeath.crop(200, 0, 50, 64);
        ike_death[5] = ikeDeath.crop(200, 0, 50, 64);

        //Assets for player
        player_down = new BufferedImage[4];
        player_up = new BufferedImage[4];
        player_left = new BufferedImage[4];
        player_right = new BufferedImage[4];

        player_down[0] = player.crop(0,0,width,height);
        player_down[1] = player.crop(width - 5,0,width,height);
        player_down[2] = player.crop(width *2 - 8,0,width,height);
        player_down[3] = player.crop(width * 3 - 10,0,width,height);


        player_left[0] = player.crop(0,height + 10,width,height);
        player_left[1] = player.crop(width - 5,height + 10,width,height);
        player_left[2] = player.crop(width * 2 - 8,height + 10,width,height);
        player_left[3] = player.crop(width * 3 - 10,height + 10,width,height);


        player_right[0] = player.crop(0,height * 2 + 20, width, height);
        player_right[1] = player.crop(width - 5,height * 2 + 20, width, height);
        player_right[2] = player.crop(width * 2 - 8,height * 2 + 20, width, height);
        player_right[3] = player.crop(width * 3 - 10,height * 2 + 20, width, height);


        player_up[0] = player.crop(0,height * 3 + 30,width,height);
        player_up[1] = player.crop(width - 5,height * 3 + 30,width,height);
        player_up[2] = player.crop(width * 2 - 8,height * 3 + 30,width,height);
        player_up[3] = player.crop(width * 3 - 10,height * 3 + 30,width,height);

        //Assets for lodumani
        lodumani_down = new BufferedImage[4];
        lodumani_up = new BufferedImage[4];
        lodumani_left = new BufferedImage[4];
        lodumani_right = new BufferedImage[4];

        lodumani_down[0] = lodumani.crop(0,0,width,height);
        lodumani_down[1] = lodumani.crop(width - 5,0,width,height);
        lodumani_down[2] = lodumani.crop(width *2 - 8,0,width,height);
        lodumani_down[3] = lodumani.crop(width * 3 - 10,0,width,height);


        lodumani_left[0] = lodumani.crop(0,height + 10,width,height);
        lodumani_left[1] = lodumani.crop(width - 5,height + 10,width,height);
        lodumani_left[2] = lodumani.crop(width * 2 - 8,height + 10,width,height);
        lodumani_left[3] = lodumani.crop(width * 3 - 10,height + 10,width,height);


        lodumani_right[0] = lodumani.crop(0,height * 2 + 20, width, height);
        lodumani_right[1] = lodumani.crop(width - 5,height * 2 + 20, width, height);
        lodumani_right[2] = lodumani.crop(width * 2 - 8,height * 2 + 20, width, height);
        lodumani_right[3] = lodumani.crop(width * 3 - 10,height * 2 + 20, width, height);


        lodumani_up[0] = lodumani.crop(0,height * 3 + 30,width,height);
        lodumani_up[1] = lodumani.crop(width - 5,height * 3 + 30,width,height);
        lodumani_up[2] = lodumani.crop(width * 2 - 8,height * 3 + 30,width,height);
        lodumani_up[3] = lodumani.crop(width * 3 - 10,height * 3 + 30,width,height);

        //Assets for manidulo
        manidulo_down = new BufferedImage[4];
        manidulo_up = new BufferedImage[4];
        manidulo_left = new BufferedImage[4];
        manidulo_right = new BufferedImage[4];

        manidulo_down[0] = manidulo.crop(0,0,width,height);
        manidulo_down[1] = manidulo.crop(width - 5,0,width,height);
        manidulo_down[2] = manidulo.crop(width *2 - 8,0,width,height);
        manidulo_down[3] = manidulo.crop(width * 3 - 10,0,width,height);


        manidulo_left[0] = manidulo.crop(0,height + 10,width,height);
        manidulo_left[1] = manidulo.crop(width - 5,height + 10,width,height);
        manidulo_left[2] = manidulo.crop(width * 2 - 8,height + 10,width,height);
        manidulo_left[3] = manidulo.crop(width * 3 - 10,height + 10,width,height);


        manidulo_right[0] = manidulo.crop(0,height * 2 + 20, width, height);
        manidulo_right[1] = manidulo.crop(width - 5,height * 2 + 20, width, height);
        manidulo_right[2] = manidulo.crop(width * 2 - 8,height * 2 + 20, width, height);
        manidulo_right[3] = manidulo.crop(width * 3 - 10,height * 2 + 20, width, height);


        manidulo_up[0] =  manidulo.crop(0,height * 3 + 30,width,height);
        manidulo_up[1] = manidulo.crop(width - 5,height * 3 + 30,width,height);
        manidulo_up[2] = manidulo.crop(width * 2 - 8,height * 3 + 30,width,height);
        manidulo_up[3] = manidulo.crop(width * 3 - 10,height * 3 + 30,width,height);

        //Assets for bomb_static
        bomb_static = new BufferedImage[4];
        bomb_static[0] = ImageLoader.loadImage(".\\res\\asset\\bomb\\ball_bomb.png");
        bomb_static[1] = ImageLoader.loadImage(".\\res\\asset\\bomb\\ball_bomb1.png");
        bomb_static[2] = ImageLoader.loadImage(".\\res\\asset\\bomb\\ball_bomb2.png");
        bomb_static[3] = ImageLoader.loadImage(".\\res\\asset\\bomb\\ball_bomb2.png");

        //Assets for flame
        flameExplosion = new BufferedImage[4];
        int W = 63;
        int H = 63;
        flameExplosion[0] = flame.crop(0, 0, W, H);
        flameExplosion[1] = flame.crop(W, 0, W, H);
        flameExplosion[2] = flame.crop(W + W, 0, W, H);
        flameExplosion[3] = flame.crop(W + W + W, 0, W, H);

        //MenuState
        startButton = new BufferedImage[2];
        closeButton = new BufferedImage[2];
        tutorialButton = new BufferedImage[2];
        startButton[0] = ImageLoader.loadImage(".\\res\\asset\\menu\\single.png");
        startButton[1] = ImageLoader.loadImage(".\\res\\asset\\menu\\single.png");
        background1 = ImageLoader.loadImage(".\\res\\asset\\menu\\bg.png");
        title = ImageLoader.loadImage(".\\res\\asset\\menu\\title.png");
        closeButton[0] = ImageLoader.loadImage(".\\res\\asset\\menu\\exit.png");
        closeButton[1] = ImageLoader.loadImage(".\\res\\asset\\menu\\exit.png");
        tutorialButton[0] = ImageLoader.loadImage(".\\res\\asset\\menu\\button_tutorial.png");
        tutorialButton[1] = ImageLoader.loadImage(".\\res\\asset\\menu\\button_tutorial.png");
        soundButton = new BufferedImage[2];
        soundButton[0] = ImageLoader.loadImage(".\\res\\asset\\menu\\sound_on.png");
        soundButton[1] = ImageLoader.loadImage(".\\res\\asset\\menu\\sound_off.png");

        //TutorialState
        back = new BufferedImage[2];
        background2 = ImageLoader.loadImage(".\\res\\asset\\menu\\bg2.png");
        back[0] = ImageLoader.loadImage(".\\res\\asset\\menu\\button_back.png");
        back[1] = ImageLoader.loadImage(".\\res\\asset\\menu\\button_back.png");

        controlTutorial = ImageLoader.loadImage(".\\res\\asset\\menu\\control_tutorial.png");
        youWin = ImageLoader.loadImage(".\\res\\asset\\you_win.png");

















    }
}
