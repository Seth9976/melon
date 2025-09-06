package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public final class e extends Drawable {
    public final Drawable a;
    public final Drawable b;
    public final float[] c;
    public float d;

    public e(Drawable drawable0, Drawable drawable1) {
        this.a = drawable0.getConstantState().newDrawable().mutate();
        Drawable drawable2 = drawable1.getConstantState().newDrawable().mutate();
        this.b = drawable2;
        drawable2.setAlpha(0);
        this.c = new float[2];
    }

    public final void a(float f) {
        if(this.d != f) {
            this.d = f;
            B.a(this.c, f);
            this.a.setAlpha(((int)(this.c[0] * 255.0f)));
            this.b.setAlpha(((int)(this.c[1] * 255.0f)));
            this.invalidateSelf();
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas0) {
        this.a.draw(canvas0);
        this.b.draw(canvas0);
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.a.getIntrinsicHeight(), this.b.getIntrinsicHeight());
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.a.getIntrinsicWidth(), this.b.getIntrinsicWidth());
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return Math.max(this.a.getMinimumHeight(), this.b.getMinimumHeight());
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return Math.max(this.a.getMinimumWidth(), this.b.getMinimumWidth());
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    // 去混淆评级： 低(20)
    @Override  // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.a.isStateful() || this.b.isStateful();
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setAlpha(int v) {
        Drawable drawable0 = this.b;
        Drawable drawable1 = this.a;
        if(Float.compare(this.d, 0.5f) <= 0) {
            drawable1.setAlpha(v);
            drawable0.setAlpha(0);
        }
        else {
            drawable1.setAlpha(0);
            drawable0.setAlpha(v);
        }
        this.invalidateSelf();
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setBounds(int v, int v1, int v2, int v3) {
        super.setBounds(v, v1, v2, v3);
        this.a.setBounds(v, v1, v2, v3);
        this.b.setBounds(v, v1, v2, v3);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter0) {
        this.a.setColorFilter(colorFilter0);
        this.b.setColorFilter(colorFilter0);
        this.invalidateSelf();
    }

    // 去混淆评级： 低(20)
    @Override  // android.graphics.drawable.Drawable
    public final boolean setState(int[] arr_v) {
        return this.a.setState(arr_v) || this.b.setState(arr_v);
    }
}

