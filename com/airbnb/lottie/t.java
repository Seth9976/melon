package com.airbnb.lottie;

public final class t implements LazyCompositionTask {
    public final LottieDrawable a;
    public final String b;
    public final String c;
    public final boolean d;

    public t(LottieDrawable lottieDrawable0, String s, String s1, boolean z) {
        this.a = lottieDrawable0;
        this.b = s;
        this.c = s1;
        this.d = z;
    }

    @Override  // com.airbnb.lottie.LottieDrawable$LazyCompositionTask
    public final void run(LottieComposition lottieComposition0) {
        this.a.lambda$setMinAndMaxFrame$12(this.b, this.c, this.d, lottieComposition0);
    }
}

