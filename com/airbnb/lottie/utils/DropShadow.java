package com.airbnb.lottie.utils;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

public class DropShadow {
    private int color;
    private float dx;
    private float dy;
    private float radius;
    private float[] vecs;

    public DropShadow() {
        this.radius = 0.0f;
        this.dx = 0.0f;
        this.dy = 0.0f;
        this.color = 0;
    }

    public DropShadow(float f, float f1, float f2, int v) {
        this.radius = f;
        this.dx = f1;
        this.dy = f2;
        this.color = v;
        this.vecs = null;
    }

    public DropShadow(DropShadow dropShadow0) {
        this.radius = dropShadow0.radius;
        this.dx = dropShadow0.dx;
        this.dy = dropShadow0.dy;
        this.color = dropShadow0.color;
        this.vecs = null;
    }

    public void applyTo(Paint paint0) {
        if(Color.alpha(this.color) > 0) {
            paint0.setShadowLayer(Math.max(this.radius, 1.401298E-45f), this.dx, this.dy, this.color);
            return;
        }
        paint0.clearShadowLayer();
    }

    public void applyTo(ComposeOp offscreenLayer$ComposeOp0) {
        if(Color.alpha(this.color) > 0) {
            offscreenLayer$ComposeOp0.shadow = this;
            return;
        }
        offscreenLayer$ComposeOp0.shadow = null;
    }

    public void applyWithAlpha(int v, Paint paint0) {
        int v1 = Utils.mixOpacities(Color.alpha(this.color), MiscUtils.clamp(v, 0, 0xFF));
        if(v1 > 0) {
            int v2 = Color.argb(v1, Color.red(this.color), Color.green(this.color), Color.blue(this.color));
            paint0.setShadowLayer(Math.max(this.radius, 1.401298E-45f), this.dx, this.dy, v2);
            return;
        }
        paint0.clearShadowLayer();
    }

    public void applyWithAlpha(int v, ComposeOp offscreenLayer$ComposeOp0) {
        DropShadow dropShadow0 = new DropShadow(this);
        offscreenLayer$ComposeOp0.shadow = dropShadow0;
        dropShadow0.multiplyOpacity(v);
    }

    public int getColor() {
        return this.color;
    }

    public float getDx() {
        return this.dx;
    }

    public float getDy() {
        return this.dy;
    }

    public float getRadius() {
        return this.radius;
    }

    public void multiplyOpacity(int v) {
        this.color = Color.argb(Math.round(((float)(MiscUtils.clamp(v, 0, 0xFF) * Color.alpha(this.color))) / 255.0f), Color.red(this.color), Color.green(this.color), Color.blue(this.color));
    }

    public boolean sameAs(DropShadow dropShadow0) {
        return this.radius == dropShadow0.radius && this.dx == dropShadow0.dx && this.dy == dropShadow0.dy && this.color == dropShadow0.color;
    }

    public void setColor(int v) {
        this.color = v;
    }

    public void setDx(float f) {
        this.dx = f;
    }

    public void setDy(float f) {
        this.dy = f;
    }

    public void setRadius(float f) {
        this.radius = f;
    }

    public void transformBy(Matrix matrix0) {
        if(this.vecs == null) {
            this.vecs = new float[2];
        }
        float[] arr_f = this.vecs;
        arr_f[0] = this.dx;
        arr_f[1] = this.dy;
        matrix0.mapVectors(arr_f);
        float[] arr_f1 = this.vecs;
        this.dx = arr_f1[0];
        this.dy = arr_f1[1];
        this.radius = matrix0.mapRadius(this.radius);
    }
}

