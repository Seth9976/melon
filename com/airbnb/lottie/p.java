package com.airbnb.lottie;

import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;

public final class p implements LazyCompositionTask {
    public final LottieDrawable a;
    public final KeyPath b;
    public final Object c;
    public final LottieValueCallback d;

    public p(LottieDrawable lottieDrawable0, KeyPath keyPath0, Object object0, LottieValueCallback lottieValueCallback0) {
        this.a = lottieDrawable0;
        this.b = keyPath0;
        this.c = object0;
        this.d = lottieValueCallback0;
    }

    @Override  // com.airbnb.lottie.LottieDrawable$LazyCompositionTask
    public final void run(LottieComposition lottieComposition0) {
        this.a.lambda$addValueCallback$17(this.b, this.c, this.d, lottieComposition0);
    }
}

