package com.iloen.melon.activity.crop;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;

public final class h {
    public final View a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public Rect f;
    public RectF g;
    public RectF h;
    public Matrix i;
    public boolean j;
    public float k;
    public boolean l;
    public Drawable m;
    public Drawable n;
    public Drawable o;
    public final Paint p;
    public final Paint q;
    public final Paint r;

    public h(CropImageView cropImageView0) {
        this.e = 1;
        this.j = false;
        this.l = false;
        this.p = new Paint();
        this.q = new Paint();
        this.r = new Paint();
        this.a = cropImageView0;
    }

    public final Rect a() {
        RectF rectF0 = new RectF(this.h.left, this.h.top, this.h.right, this.h.bottom);
        this.i.mapRect(rectF0);
        return new Rect(Math.round(rectF0.left), Math.round(rectF0.top), Math.round(rectF0.right), Math.round(rectF0.bottom));
    }

    public final Rect b() {
        return new Rect(((int)this.h.left), ((int)this.h.top), ((int)this.h.right), ((int)this.h.bottom));
    }

    public final int c(float f, float f1) {
        boolean z = false;
        Rect rect0 = this.a();
        int v = 0x20;
        if(this.l) {
            float f2 = f - ((float)rect0.centerX());
            float f3 = f1 - ((float)rect0.centerY());
            int v1 = (int)Math.sqrt(f3 * f3 + f2 * f2);
            int v2 = this.f.width();
            if(((float)Math.abs(v1 - v2 / 2)) <= 20.0f) {
                if(Float.compare(Math.abs(f3), Math.abs(f2)) > 0) {
                    if(f3 < 0.0f) {
                        return this.d ? 8 : 1;
                    }
                    return this.d ? 16 : 1;
                }
                if(f2 < 0.0f) {
                    return this.d ? 2 : 1;
                }
                return this.d ? 4 : 1;
            }
            if(v1 >= v2 / 2) {
                return 1;
            }
        }
        else {
            boolean z1 = Float.compare(f1, ((float)rect0.top) - 20.0f) >= 0 && f1 < ((float)rect0.bottom) + 20.0f;
            float f4 = (float)rect0.left;
            if(f >= f4 - 20.0f && f < ((float)rect0.right) + 20.0f) {
                z = true;
            }
            int v3 = Math.abs(f4 - f) >= 20.0f || !z1 ? 1 : 3;
            if(Math.abs(((float)rect0.right) - f) < 20.0f && z1) {
                v3 |= 4;
            }
            if(Math.abs(((float)rect0.top) - f1) < 20.0f && z) {
                v3 |= 8;
            }
            if(Math.abs(((float)rect0.bottom) - f1) < 20.0f && z) {
                v3 |= 16;
            }
            if(v3 != 1 || !rect0.contains(((int)f), ((int)f1))) {
                v = v3;
            }
        }
        return (v & 0x20) != 0 || this.d ? v : 1;
    }

    public final void d(Matrix matrix0, Rect rect0, RectF rectF0, boolean z, boolean z1) {
        if(z) {
            z1 = true;
        }
        this.i = new Matrix(matrix0);
        this.h = rectF0;
        this.g = new RectF(rect0);
        this.j = z1;
        this.l = z;
        this.k = this.h.width() / this.h.height();
        this.f = this.a();
        this.p.setARGB(0x7D, 50, 50, 50);
        this.q.setARGB(0x7D, 50, 50, 50);
        this.r.setStrokeWidth(3.0f);
        this.r.setStyle(Paint.Style.STROKE);
        this.r.setAntiAlias(true);
        this.e = 1;
        Resources resources0 = this.a.getResources();
        this.m = resources0.getDrawable(0x7F0802B4);  // drawable:camera_crop_width
        this.n = resources0.getDrawable(0x7F0802B3);  // drawable:camera_crop_height
        this.o = resources0.getDrawable(0x7F080691);  // drawable:indicator_autocrop
    }
}

