package com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame;

import android.graphics.Bitmap;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Graphics.PixmapFormat;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Pixmap;

/**
 * Created by neo on 2016-12-30.
 */
public class AndroidPixmap implements Pixmap {
    Bitmap bitmap;
    PixmapFormat format;

    public AndroidPixmap(Bitmap bitmap, PixmapFormat pixmapFormat){
        this.bitmap = bitmap;
        this.format = pixmapFormat;
    }


    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public PixmapFormat getFormat() {
        return format;
    }

    @Override
    public void dipose() {
        bitmap.recycle();

    }
}
