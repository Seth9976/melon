package com.airbnb.lottie;

public final class o implements LazyCompositionTask {
    public final LottieDrawable a;
    public final int b;
    public final int c;

    public o(LottieDrawable lottieDrawable0, int v, int v1) {
        this.a = lottieDrawable0;
        this.b = v;
        this.c = v1;
    }

    @Override  // com.airbnb.lottie.LottieDrawable$LazyCompositionTask
    public final void run(LottieComposition lottieComposition0) {
        this.a.lambda$setMinAndMaxFrame$13(this.b, this.c, lottieComposition0);
    }
}

