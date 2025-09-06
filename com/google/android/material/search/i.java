package com.google.android.material.search;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import e6.a;

public final class i implements ValueAnimator.AnimatorUpdateListener {
    public final l a;
    public final float b;
    public final float c;
    public final Rect d;

    public i(l l0, float f, float f1, Rect rect0) {
        this.a = l0;
        this.b = f;
        this.c = f1;
        this.d = rect0;
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        this.a.getClass();
        float f = valueAnimator0.getAnimatedFraction();
        this.a.c.getClass();
        this.a.c.a(((float)this.d.left), ((float)this.d.top), ((float)this.d.right), ((float)this.d.bottom), a.a(this.b, this.c, f));
    }
}

