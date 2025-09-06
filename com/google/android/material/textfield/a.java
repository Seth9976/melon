package com.google.android.material.textfield;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;

public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final int a;
    public final c b;

    public a(c c0, int v) {
        this.a = v;
        this.b = c0;
        super();
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        if(this.a != 0) {
            this.b.getClass();
            float f = (float)(((Float)valueAnimator0.getAnimatedValue()));
            this.b.d.setScaleX(f);
            this.b.d.setScaleY(f);
            return;
        }
        this.b.getClass();
        float f1 = (float)(((Float)valueAnimator0.getAnimatedValue()));
        this.b.d.setAlpha(f1);
    }
}

