package com.example.neo.spaceguy;

import com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame.Screen;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.FileIO;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Game;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Graphics;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Input.TouchEvent;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Pixmap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import static com.example.neo.spaceguy.Assets.asteroid;
import static com.example.neo.spaceguy.SpaceGuyWorld.hiScore;

/**
 * Created by neo on 2017-03-20.
 */
public class GameScreen extends Screen {
    enum GameState{
        Ready,
        Death,
        Running,
        GameOver
    }

    GameState state = GameState.Running;
    SpaceGuyWorld world;
    int oldScore = 0;
    String score = "0";
    String highScore = "0";

    public GameScreen(Game game){
        super(game);
        world = new SpaceGuyWorld();
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        if(state == GameState.Ready)
            updateReady(touchEvents);
        if(state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if(state == GameState.GameOver)
            updateGameOver(touchEvents);


    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.background,0,0);

        if(state == GameState.Ready)
            drawReadyUI();
        if(state == GameState.Running)
            drawRunningUI();
        if(state == GameState.GameOver)
            drawGameOverUI();



        g.drawPixmap(Assets.score,120,0);
        drawText(g,score,200,1);
    }

    private void drawWorld (SpaceGuyWorld world){
        Graphics g = game.getGraphics();
        SpaceGuy spaceguy = world.spaceGuy;
        List<Asteroid> asteroids = world.asteroids;

        for(Asteroid a : asteroids){
            Pixmap asteroidPixmap = asteroid;
            g.drawPixmap(asteroidPixmap,a.getX(),a.getY());
        }

        Pixmap spaceGuyPixmap = Assets.mainCharacter;
        g.drawPixmap(spaceGuyPixmap,spaceguy.getX(),spaceguy.getY());


    }

    private void drawText(Graphics g, String line,int x,int y){
        int len = line.length();
        for(int i = 0; i < len; i++){
            char character = line.charAt(i);

            if(character == ' '){
                x = x + 20;
                continue;
            }

            int srcX = 0;
            int srcWidth = 20;
            srcX = (character - '0') * 20;


            g.drawPixmap(Assets.numbers,x,y,srcX,0,srcWidth,30);
            x = x + srcWidth;


        }

    }

    private void drawReadyUI(){
        //TODO
    }

    private void drawRunningUI(){
        drawWorld(world);
    }

    private void drawGameOverUI(){
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.gameOver,15,70);
        g.drawPixmap(Assets.best,100,150);

        highScore = "" + hiScore;
        drawText(g,highScore,150,230);
    }

    private void drawDeathUI(){
        Graphics g = game.getGraphics();
        int x = 0;
       while (x < 156){
            int srcWidth = 30;
            g.drawPixmap(Assets.aMainCharacter,world.spaceGuy.getX(),world.spaceGuy.getY(),x,0,srcWidth,29);
            x = x + srcWidth;
        }
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

    private void updateReady(List < TouchEvent > touchEvents){

    }

    private void updateRunning(List < TouchEvent > touchEvents, float deltaTime) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_DOWN) {
                world.spaceGuy.moveDirection(event.x);
            }

        }

        world.update(deltaTime);

        if(world.gameOver){
            state = GameState.GameOver;

            loadHighScore(game.getFileIO());

            if(world.score > hiScore)
                hiScore = world.score;

            saveHighScore(game.getFileIO());
            System.out.println(hiScore);
        }

        if (oldScore != world.score){
            oldScore = world.score;
            score = "" + oldScore;
        }
    }

    private void updateGameOver(List <TouchEvent> touchEvents){
        int len = touchEvents.size();
        for (int i = 0; i < len; i++){
        TouchEvent event = touchEvents.get(i);
        if (event.type == TouchEvent.TOUCH_UP)
            game.setScreen(new MainMenuScreen(game));
            return;
    }

    }

    public void loadHighScore(FileIO files){
        BufferedReader in = null;
        try{
            in = new BufferedReader(new InputStreamReader(files.readFile(".spaceguy")));
            hiScore = Integer.parseInt(in.readLine());
        }catch (IOException e){

        }catch (NumberFormatException e){

        }finally{
            try{
                if ( in != null)
                    in.close();
            } catch (IOException e){}
        }

    }

    public static void saveHighScore(FileIO files){
        BufferedWriter out = null;
        try{
            out = new BufferedWriter(new OutputStreamWriter(files.writeFile(".spaceguy")));
            out.write(Integer.toString(hiScore));
        }catch(IOException e){

        }finally{
            try{
                if(out != null)
                    out.close();
            }catch(IOException e){}
        }}
}