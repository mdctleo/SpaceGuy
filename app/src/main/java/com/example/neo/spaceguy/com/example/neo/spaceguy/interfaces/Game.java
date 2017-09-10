package com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces;

import com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame.Screen;

/**
 * Created by neo on 2016-12-25.
 */
public interface Game {

    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public Audio getAudio();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();

    public Screen getStartScreen();

}
