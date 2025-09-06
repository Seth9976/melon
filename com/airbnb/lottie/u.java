package com.airbnb.lottie;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;

public final class u implements ValueAnimator.AnimatorUpdateListener {
    public final LottieDrawable a;

    public u(LottieDrawable lottieDrawable0) {
        this.a = lottieDrawable0;
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        this.a.lambda$new$0(valueAnimator0);
    }
}

