package states;

import Game.Handler;
import Graphic.Assets;
import UI.ClickListener;
import UI.UIImageButton;
import UI.UIManager;
import states.MenuState;

import java.awt.*;

public class LooseState extends State  {
    public UIManager lose;

    public LooseState(Handler handler) {
        super(handler);

    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background2,0,0,960,704,null);
        g.drawImage(Assets.closeButton[0],350, 480, 300, 110,null);
    }
}