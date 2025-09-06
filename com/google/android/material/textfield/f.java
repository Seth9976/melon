package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import z6.i;

public final class f extends i {
    public e S;
    public static final int T;

    @Override  // z6.i
    public final void f(Canvas canvas0) {
        if(this.S.s.isEmpty()) {
            super.f(canvas0);
            return;
        }
        canvas0.save();
        canvas0.clipOutRect(this.S.s);
        super.f(canvas0);
        canvas0.restore();
    }

    @Override  // z6.i
    public final Drawable mutate() {
        this.S = new e(this.S);
        return this;
    }

    public final void w(float f, float f1, float f2, float f3) {
        RectF rectF0 = this.S.s;
        if(f == rectF0.left && f1 == rectF0.top && f2 == rectF0.right && f3 == rectF0.bottom) {
            return;
        }
        rectF0.set(f, f1, f2, f3);
        this.invalidateSelf();
    }
}

