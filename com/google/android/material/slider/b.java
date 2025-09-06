package com.google.android.material.slider;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import e6.a;

public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final BaseSlider a;

    public b(BaseSlider baseSlider0) {
        this.a = baseSlider0;
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        float f = (float)(((Float)valueAnimator0.getAnimatedValue()));
        BaseSlider baseSlider0 = this.a;
        for(Object object0: baseSlider0.l) {
            ((F6.b)object0).j0 = 1.2f;
            ((F6.b)object0).h0 = f;
            ((F6.b)object0).i0 = f;
            ((F6.b)object0).k0 = a.b(0.0f, 1.0f, 0.19f, 1.0f, f);
            ((F6.b)object0).invalidateSelf();
        }
        baseSlider0.postInvalidateOnAnimation();
    }
}

