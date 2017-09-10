package com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame;

import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Game;

/**
 * Created by neo on 2016-12-25.
 */
public abstract class Screen {
    protected final Game game;

    public Screen(Game game){
        this.game = game;
    }

    public abstract void update(float deltaTime);

    public abstract void present(float deltaTime);

    public abstract void pause();

    public abstract void resume();

    public abstract void dispose();
}
