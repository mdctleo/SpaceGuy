package com.example.neo.spaceguy;

/**
 * Created by neo on 2017-01-05.
 */
public class SpaceGuy {
    public int x,y;
    public int width,height;
    public final int dx = 1;
    public final int dy = 5;
    public int directionX = 0;

    public SpaceGuy(int x, int y){
        this.x = x;
        this.y = y;
        directionX = this.x;
        width = Assets.mainCharacter.getWidth();
        height = Assets.mainCharacter.getHeight();
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void moveDirection(int x){
        directionX = x;
    }

    public void move(){
        if (directionX > getX()){
            this.x = this.x + dx;
        }

        if(directionX < getX()){
            this.x = this.x - dx;
        }

    }
}
