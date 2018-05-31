package com.jesm.gameproject.levelupwand;

import android.graphics.Bitmap;

public class MonsterResources {
    //===================
    // 몬스터 1 : 슬라임
    //==================
    // 본체
    static public Bitmap imgSlime;
    static public int m1w, m1h;

    // 공격 : 침
    static public Bitmap imgSlimeSaliva;
    static public int m1aw, m1ah;

    // 파괴
    static public Bitmap[] arSlimeDead = new Bitmap[3]; // 슬라임 반짝이면서 죽음.
    static public int m1dw, m1dh;
}
