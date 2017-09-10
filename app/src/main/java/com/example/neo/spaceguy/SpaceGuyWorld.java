package com.example.neo.spaceguy;

import android.graphics.Rect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by neo on 2017-01-12.
 */
public class SpaceGuyWorld {
    public static final int WORLD_WIDTH = 320;
    public static final int WORLD_HEIGHT = 480;
    public static final int SCORE_INCREMENT = 1;
    public static final float TICK_INITIAL = 0.01f;
    public static final float TICK_DECREMENT = 0.05f;

    public SpaceGuy spaceGuy;
    public List<Asteroid> asteroids;
    public boolean gameOver = false;
    public int score;
    public int scoreIncrementTime;
    public static int hiScore;

    Random random;
    float tickTime = 0;
    float tick = TICK_INITIAL;
    private int difficulty = 80;
    private int moreAsteroidLimit = 0;

    public SpaceGuyWorld(){
        spaceGuy = new SpaceGuy(WORLD_WIDTH/2, WORLD_HEIGHT - 60);
        asteroids = new ArrayList<Asteroid>();
        random = new Random();
        score = 0;
        hiScore = 0;
    }

    public void update(float deltaTime){

        if(gameOver)
            return;

        tickTime = tickTime + deltaTime;
        while(tickTime > tick){
            tickTime = tickTime - tick;
            for(Asteroid a : asteroids){
                a.move();
            }
            spaceGuy.move();
            isGameOver();
        }

        setScoreIncrement();

       if(moreAsteroidLimit == difficulty){
            moreAsteroids();
            moreAsteroidLimit = 0;
            if(difficulty > 15)
                difficulty--;

           if(difficulty > 12){
               for(Asteroid a : asteroids){
                   a.increaseSpeed(1);
               }
               difficulty--;
           }




          }

         moreAsteroidLimit++;
        destroyAsteroids();
        System.out.println(asteroids.size());



    }

    public void moreAsteroids(){
        asteroids.add(new Asteroid(random.nextInt(320 + 1)));

    }

    public boolean checkCollision(Asteroid a){
      int aUpperBound = a.getY() - a.getHeight() / 2;
      int aLeftBound = a.getX() - a.getWidth() / 2;
      int aBottomBound = a.getY() + a.getHeight() / 2;
      int aRightBound = a.getX() + a.getWidth() / 2;

      int sUpperBound = spaceGuy.getY() - spaceGuy.getHeight() / 2;
      int sLeftBound = spaceGuy.getX() - spaceGuy.getWidth() / 2;
      int sBottomBound = spaceGuy.getY() + spaceGuy.getHeight() / 2;
      int sRightBound = spaceGuy.getX() + spaceGuy.getWidth() / 2;


       Rect as = new Rect(aLeftBound,aUpperBound,aRightBound,aBottomBound);




      if(as.intersects(sLeftBound,sUpperBound,sRightBound,sBottomBound))
          return true;

        return false;

    }

    public void isGameOver(){
        for(Asteroid a : asteroids){
           if(checkCollision(a)){
               gameOver = true;
               break;
           }
        }


    }

    public void setScoreIncrement(){
        if(scoreIncrementTime == 30){
            score++;
            scoreIncrementTime = 0;
        } else
            scoreIncrementTime++;


    }

    public void destroyAsteroids(){
        Iterator<Asteroid> iter = asteroids.iterator();
        while (iter.hasNext()) {
            Asteroid a = iter.next();

            if (a.getY() - a.getHeight() / 2 > 480) {
                iter.remove();
            }
        }
    }




}
