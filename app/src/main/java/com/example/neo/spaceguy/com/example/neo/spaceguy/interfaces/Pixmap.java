package com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces;

import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Graphics.PixmapFormat;

/**
 * Created by neo on 2016-12-25.
 */
public interface Pixmap {

    public int getWidth();

    public int getHeight();

    public PixmapFormat getFormat();

    public void dipose();
}
