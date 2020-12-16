package states;

import Game.Handler;
import Graphic.Assets;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;
import states.MenuState;

import java.awt.*;

public class TutorialState extends State  {

    public TutorialState(Handler handler) {
        super(handler);






    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background2,0,0,960,704,null);
        g.drawImage(Assets.controlTutorial,150,0,666,512,null);
        g.drawImage(Assets.back[0],450,550,70,79,null);

    }
}
