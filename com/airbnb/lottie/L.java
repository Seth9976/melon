package com.airbnb.lottie;

public final class l implements LazyCompositionTask {
    public final int a;
    public final LottieDrawable b;
    public final String c;

    public l(LottieDrawable lottieDrawable0, String s, int v) {
        this.a = v;
        this.b = lottieDrawable0;
        this.c = s;
        super();
    }

    @Override  // com.airbnb.lottie.LottieDrawable$LazyCompositionTask
    public final void run(LottieComposition lottieComposition0) {
        switch(this.a) {
            case 0: {
                this.b.lambda$setMinAndMaxFrame$11(this.c, lottieComposition0);
                return;
            }
            case 1: {
                this.b.lambda$setMaxFrame$10(this.c, lottieComposition0);
                return;
            }
            default: {
                this.b.lambda$setMinFrame$9(this.c, lottieComposition0);
            }
        }
    }
}

