package com.example.neo.spaceguy.com.example.neo.spaceguy.androidgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neo on 2016-12-28.
 */
public class Pool<E> {

    private final List<E> freeObjects;
    private final PoolObjectFactory<E> factory;
    private final int maxSize;


    public interface PoolObjectFactory<E>{
        public E createObject();


    }

    public Pool(PoolObjectFactory<E>factory, int maxSize) {
        this.factory = factory;
        this.maxSize = maxSize;
        this.freeObjects=new ArrayList<E>(maxSize);
    }

    public E newObject(){
        E object = null;

        if (freeObjects.isEmpty())
            object = factory.createObject();
        else
            object=freeObjects.remove(freeObjects.size() - 1);
        return object;

    }

    public void free(E object) {
        if (freeObjects.size()<maxSize)
            freeObjects.add(object);
    }





}
