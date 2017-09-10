package com.example.neo.spaceguy;

import com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame.Screen;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Game;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Graphics;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Graphics.PixmapFormat;

/**
 * Created by neo on 2017-01-05.
 */
public class LoadingScreen extends Screen {
    public LoadingScreen(Game game){
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.mainCharacter = g.newPixmap("main character.png", PixmapFormat.ARGB4444);
        Assets.asteroid = g.newPixmap("asteroid.png",PixmapFormat.ARGB4444);
        Assets.title = g.newPixmap("Title.png",PixmapFormat.ARGB4444);
        Assets.start = g.newPixmap("Start.png",PixmapFormat.ARGB4444);
        Assets.score = g.newPixmap("Score.png",PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("GameOver.png",PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("Numbers.png",PixmapFormat.ARGB4444);
        Assets.best = g.newPixmap("Best.png",PixmapFormat.ARGB4444);
        Assets.aMainCharacter = g.newPixmap("main character animated.png", PixmapFormat.ARGB4444);

        game.setScreen(new MainMenuScreen(game));

    }

    @Override
    public void present(float deltaTime) {

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
