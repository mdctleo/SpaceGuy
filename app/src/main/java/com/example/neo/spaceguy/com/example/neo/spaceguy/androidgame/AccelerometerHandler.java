package com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by neo on 2016-12-26.
 */
public class AccelerometerHandler implements SensorEventListener{

    float accelX;
    float accelY;
    float accelZ;

    public AccelerometerHandler(Context context){
        SensorManager manager = (SensorManager) context.getSystemService(context.SENSOR_SERVICE);

        if(manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0){
            Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            manager.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_GAME);
        }
    }

    public float getAccelX(){
        return accelX;
    }

    public float getAccelY(){
        return accelY;
    }

    public float getAccelZ(){
        return accelZ;
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
