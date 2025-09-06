package com.airbnb.lottie;

public final class n implements LazyCompositionTask {
    public final LottieDrawable a;
    public final float b;
    public final float c;

    public n(LottieDrawable lottieDrawable0, float f, float f1) {
        this.a = lottieDrawable0;
        this.b = f;
        this.c = f1;
    }

    @Override  // com.airbnb.lottie.LottieDrawable$LazyCompositionTask
    public final void run(LottieComposition lottieComposition0) {
        this.a.lambda$setMinAndMaxProgress$14(this.b, this.c, lottieComposition0);
    }
}

