package com.google.android.material.navigation;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;

public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final float a;
    public final NavigationBarItemView b;

    public b(NavigationBarItemView navigationBarItemView0, float f) {
        this.b = navigationBarItemView0;
        this.a = f;
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        float f = (float)(((Float)valueAnimator0.getAnimatedValue()));
        this.b.e(f, this.a);
    }
}

