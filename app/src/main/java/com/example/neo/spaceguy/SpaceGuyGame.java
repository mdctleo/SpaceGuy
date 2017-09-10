package com.example.neo.spaceguy;

import com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame.AndroidGame;
import com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame.Screen;

/**
 * Created by neo on 2017-01-04.
 */
public class SpaceGuyGame extends AndroidGame {
    public Screen getStartScreen(){
        return new LoadingScreen(this);
    }

}
