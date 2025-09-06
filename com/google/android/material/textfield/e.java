package com.google.android.material.textfield;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import z6.h;
import z6.i;
import z6.o;

public final class e extends h {
    public final RectF s;

    public e(e e0) {
        super(e0);
        this.s = e0.s;
    }

    public e(o o0, RectF rectF0) {
        super(o0);
        this.s = rectF0;
    }

    @Override  // z6.h
    public final Drawable newDrawable() {
        Drawable drawable0 = new f(this);  // 初始化器: Lz6/i;-><init>(Lz6/h;)V
        drawable0.S = this;
        ((i)drawable0).invalidateSelf();
        return drawable0;
    }
}

