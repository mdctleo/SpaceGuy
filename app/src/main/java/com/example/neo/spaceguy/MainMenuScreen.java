package com.example.neo.spaceguy;

import com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame.Screen;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Game;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Graphics;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Input.TouchEvent;

import java.util.List;

/**
 * Created by neo on 2017-01-05.
 */
public class MainMenuScreen extends Screen {


    public MainMenuScreen(Game game){

        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        int len = touchEvents.size();
        for(int i = 0; i < len; i ++)
        {TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP)
                game.setScreen(new GameScreen(game));
        }



    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.background,0,0);
        g.drawPixmap(Assets.title,15,70);
        g.drawPixmap(Assets.start,-7,400);



    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
