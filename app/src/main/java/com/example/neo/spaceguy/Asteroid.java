package com.example.neo.spaceguy;

/**
 * Created by neo on 2017-01-07.
 */
public class Asteroid {
    int y;
    int x;
    int width;
    int height;
    public int dy = 1;
    public int START_HEIGHT = -5;

    public Asteroid(int x){
        this.x = x;
        this.y = START_HEIGHT;
        width = Assets.asteroid.getWidth();
        height = Assets.asteroid.getHeight();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void move(){
        this.y = this.y + dy;
    }

    public void increaseSpeed(int y){this.y = this.y + y;}
}
