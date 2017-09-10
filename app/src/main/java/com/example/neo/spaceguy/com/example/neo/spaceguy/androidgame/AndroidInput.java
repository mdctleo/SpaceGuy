package com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame;


import android.content.Context;
import android.view.View;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Input;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.TouchHandler;

import java.util.List;

/**
 * Created by neo on 2016-12-30.
 */
public class AndroidInput implements Input {
    AccelerometerHandler accelHandler;
    TouchHandler touchHandler;

    public AndroidInput(Context context, View view, float scaleX, float scaleY){
        accelHandler = new AccelerometerHandler(context);
            touchHandler = new SingleTouchHandler(view,scaleX,scaleY);


    }


   /* @Override
      public boolean isKeyPressed(int keyCode) {
      return 0;
    } */

    @Override
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    @Override
    public int getTouchX(int pointer) {
        return touchHandler.getTouchX(pointer);
    }

    @Override
    public int getTouchY(int pointer) {
        return touchHandler.getTouchY(pointer);
    }

    @Override
    public float getAccelX() {
        return accelHandler.getAccelX();
    }

    @Override
    public float getAccelY() {
        return accelHandler.getAccelY();
    }

    @Override
    public float getAccelZ() {
        return accelHandler.getAccelZ();
    }

   /* @Override
    public List<KeyEvent> getKeyEvents() {
        return null;
    }*/

    @Override
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }
}
