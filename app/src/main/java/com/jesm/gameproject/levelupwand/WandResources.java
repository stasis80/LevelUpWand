package com.jesm.gameproject.levelupwand;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class WandResources {
    // Wand
    static public Bitmap[] arWand = new Bitmap[10]; // wand 10 레벨당 1개씩.

    //-----------------------------
    // Wand
    //-----------------------------
    private static void makeWand(Context context) {
        //원본 이미지
        for (int i = 0; i < 10; i++) {
            arWand[i] = BitmapFactory.decodeResource(context.getResources(), R.drawable.wand1 + i);

        }
    }
}
