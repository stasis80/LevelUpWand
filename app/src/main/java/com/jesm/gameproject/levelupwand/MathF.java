package com.jesm.gameproject.levelupwand;

import android.graphics.PointF;

/**
 * Created by JESM_Family on 2017-12-13.
 */

public class MathF {
    static private PointF pos = new PointF();
    static private float dx, dy, m;

    static public float distance(PointF p1, PointF p2) {
        return (float) Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }

    static public float distance(float x, float y, float px, float py) {
        return (float) Math.sqrt((x - px) * (x - px) + (y - py) * (y - py));
    }

    static public float lerp(float start, float end, float rate) {
        return start + (end - start) * rate;
    }

    static public PointF direction(PointF p, PointF t) {
        m = (float) -Math.atan2(t.y - p.y, t.x - p.x);

        pos.x = (float) Math.cos(m);
        pos.y = -(float) Math.sin(m);

        return pos;
    }

    static public PointF lerp(PointF p1, PointF p2, float rate) {
        if (distance(p1, p2) < 1f) return p2;

        dx = p2.x - p1.x;
        dy = p2.y - p1.y;

        if (dx == 0) {
            pos.x = p1.x;
            pos.y = p1.y + dy * rate;
        } else {
            m = dy / dx;
            pos.x = p1.x + dx * rate;
            pos.y = p1.y + dx * m * rate;
        }
        return pos;
    }

    static public boolean hitTest(PointF p, float r, PointF t) {
        //return (distance(p, t) < r);
        return (p.x - t.x) * (p.x - t.x) + (p.y - t.y) * (p.y - t.y) < r * r;
    }

    static public boolean hitTest(float x, float y, float r, float tx, float ty) {
        //return (distance(x, y, tx, ty) < r);
        return (x - tx) * (x - tx) + (y - ty) * (y - ty) < r * r;
    }

    static public int repeat(int n, int end) {
        if (++n >= end) n = 0;
        return n;
    }

    static public float cwDegree(PointF p1, PointF p2) {
        double rad = -Math.atan2(p2.y - p1.y, p2.x - p1.x);
        return 90 - (float) Math.toDegrees(rad);
    }

    static public float clamp(float org, float min, float max) {
        return Math.max(min, Math.min(org, max));
    }

    //충돌 판정(1) 사각형 : 사각형
    static public boolean checkCollision(/*사:사*/float x, float y, float w, float h, float tx, float ty, float tw, float th) {
        return (w + tw) <= Math.abs(x - tx) && (h - th) <= Math.abs(y - ty);
    }

    //충돌 판정(2) 원 : 원
    static public boolean checkCollision(/*원:원*/float x, float y, float r, float tx, float ty, float tr) {
        return (x - tx) * (x - tx) + (y - ty) * (y - ty) <= (r + tr) * (r + tr);
    }

    //충돌 판정(3) 원 : 사각형
    static public boolean checkCollision(/*원:사*/float x, float y, float r, float tx, float ty, float tw, float th) {
        return (Math.abs(x - tx) <= (tw + r) && Math.abs(y - ty) <= th + r);
    }

    // distance -  두 점의 거리(3)
    static public float distSqr(float x, float y, float px, float py) {
        return (x - px) * (x - px) + (y - py) * (y - py);
    }
}
