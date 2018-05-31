package com.jesm.gameproject.levelupwand;

/**
 * Created by JESM_Family on 2017-11-22.
 */

public class Time {
    static private long currentTime = System.nanoTime();
    static public float deltaTime;

    static public void update(){
        deltaTime = (System.nanoTime() - currentTime) / 1000000000f;
        currentTime = System.nanoTime();
    }
}
