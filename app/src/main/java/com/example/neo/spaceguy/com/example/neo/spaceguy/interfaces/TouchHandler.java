package com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces;

import android.view.View.OnTouchListener;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Input.TouchEvent;

import java.util.List;

/**
 * Created by neo on 2016-12-29.
 */
public interface TouchHandler extends OnTouchListener {
    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public List<TouchEvent>getTouchEvents();
}
