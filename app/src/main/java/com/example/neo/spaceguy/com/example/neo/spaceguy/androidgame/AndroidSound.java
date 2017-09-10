package com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame;

import android.media.SoundPool;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Sound;

/**
 * Created by neo on 2017-05-06.
 */
public class AndroidSound implements Sound {
    int soundId;
    SoundPool soundPool;

    public AndroidSound(SoundPool soundPool, int soundId){
        this.soundId = soundId;
        this.soundPool = soundPool;
    }

    @Override
    public void play(float volume) {
        soundPool.play(soundId, volume, volume, 0 ,0, 1);

    }

    @Override
    public void dispose() {
        soundPool.unload(soundId);

    }
}
