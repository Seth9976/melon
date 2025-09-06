package com.google.android.material.internal;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;
import w6.d;

public final class y {
    public final TextPaint a;
    public final w b;
    public float c;
    public float d;
    public boolean e;
    public final WeakReference f;
    public d g;

    public y(x x0) {
        this.a = new TextPaint(1);
        this.b = new w(this, 0);
        this.e = true;
        new WeakReference(null);
        this.f = new WeakReference(x0);
    }

    public final float a(String s) {
        if(!this.e) {
            return this.c;
        }
        this.b(s);
        return this.c;
    }

    public final void b(String s) {
        TextPaint textPaint0 = this.a;
        float f = 0.0f;
        this.c = s == null ? 0.0f : textPaint0.measureText(s, 0, s.length());
        if(s != null) {
            f = Math.abs(textPaint0.getFontMetrics().ascent);
        }
        this.d = f;
        this.e = false;
    }

    public final void c(d d0, Context context0) {
        if(this.g != d0) {
            this.g = d0;
            if(d0 != null) {
                TextPaint textPaint0 = this.a;
                w w0 = this.b;
                d0.f(context0, textPaint0, w0);
                x x0 = (x)this.f.get();
                if(x0 != null) {
                    textPaint0.drawableState = x0.getState();
                }
                d0.e(context0, textPaint0, w0);
                this.e = true;
            }
            x x1 = (x)this.f.get();
            if(x1 != null) {
                x1.a();
                x1.onStateChange(x1.getState());
            }
        }
    }
}

