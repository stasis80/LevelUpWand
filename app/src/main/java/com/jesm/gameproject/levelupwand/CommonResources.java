package com.jesm.gameproject.levelupwand;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Vibrator;

public class CommonResources {

    // 사운드, 배경 사운드 id
    static private SoundPool mSound;
    static private int[] sndBackId = new int[10];

    // 배경

    static public Bitmap[] arTopBack = new Bitmap[3];
    static public Bitmap[] arBottomBack = new Bitmap[3];

    static public void set(Context context, int scrW, int scrH) {
        makeBackground(context, scrW, scrH);
        makeSound(context);
    }

    //-------------------
    // 배경
    //-----------------
    private static void makeBackground(Context context, int scrW, int scrH) {
        for (int i = 0; i < 3; i++) {
            Bitmap topTmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.topBack1 + i);
            arTopBack[i] = Bitmap.createScaledBitmap(topTmp, scrW, scrH, true);
            Bitmap bottomTmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.bottomBack1 + i);
            arBottomBack[i] = Bitmap.createScaledBitmap(topTmp, scrW, scrH, true);

        }

    }

    //-----------
    // Sound
    //---------------
    private static void makeSound(Context context) {
        // 롤리팝 이전 버전인가?
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            mSound = new SoundPool(5, AudioManager.STREAM_MUSIC, 1);

        }else {
            AudioAttributes attributes = new AudioAttributes.Builder().setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setFlags(AudioAttributes.FLAG_AUDIBILITY_ENFORCED).setUsage(AudioAttributes.USAGE_GAME).build();
            mSound = new SoundPool.Builder().setAudioAttributes(attributes).setMaxStreams(5).build();
        }
        // 배경 사운드 종류 : 스테이지에 따라
        for (int i =0; i < 10; i++){
            sndBackId[i] = mSound.load(context, R.raw.backSound1+i, 1);
        }

    }


}

