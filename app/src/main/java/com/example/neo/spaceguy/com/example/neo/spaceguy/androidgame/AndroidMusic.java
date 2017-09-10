package com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.example.neo.spaceguy.com.example.neo.spaceguy.interfaces.Music;

import java.io.IOException;

/**
 * Created by neo on 2017-05-06.
 */
public class AndroidMusic implements Music, OnCompletionListener {
    MediaPlayer mediaPlayer;
    boolean isPrepared = false;

    public AndroidMusic(AssetFileDescriptor assetDescriptor){
        mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(assetDescriptor.getFileDescriptor());
                assetDescriptor.getStartOffset();
                assetDescriptor.getLength();
            mediaPlayer.prepare();
            isPrepared = true;
            mediaPlayer.setOnCompletionListener(this);
        } catch (IOException e) {
           throw new RuntimeException("couldn't load music" );
        }
    }
    @Override
    public void onCompletion(MediaPlayer mp) {
        synchronized (this) {
            isPrepared = false; }

    }

    @Override
    public void play() {
        if(mediaPlayer.isPlaying())
            return;
        try {
            synchronized (this) { if (!isPrepared)
                mediaPlayer.prepare();
                mediaPlayer.start();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace(); } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void stop() {
        mediaPlayer.stop();
        synchronized (this) {
            isPrepared = false; }

    }

    @Override
    public void pause() {
        if(mediaPlayer.isPlaying())
            mediaPlayer.pause();

    }

    @Override
    public void setLooping(boolean looping) {
        mediaPlayer.setLooping(looping);

    }

    @Override
    public void setVolume(float volume) {
        mediaPlayer.setVolume(volume, volume);

    }

    @Override
    public boolean isPlaying() {
        return mediaPlayer.isPlaying();
    }

    @Override
    public boolean isStopped() {
        return !isPrepared;
    }

    @Override
    public boolean isLooping() {
        return mediaPlayer.isLooping();
    }

    @Override
    public void dispose() {
        if(mediaPlayer.isPlaying())
            mediaPlayer.stop();
        mediaPlayer.release();

    }
}
