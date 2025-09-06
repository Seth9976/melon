package com.airbnb.lottie;

public final class q implements LazyCompositionTask {
    public final int a;
    public final LottieDrawable b;
    public final float c;

    public q(LottieDrawable lottieDrawable0, float f, int v) {
        this.a = v;
        this.b = lottieDrawable0;
        this.c = f;
        super();
    }

    @Override  // com.airbnb.lottie.LottieDrawable$LazyCompositionTask
    public final void run(LottieComposition lottieComposition0) {
        switch(this.a) {
            case 0: {
                this.b.lambda$setMaxProgress$8(this.c, lottieComposition0);
                return;
            }
            case 1: {
                this.b.lambda$setMinProgress$6(this.c, lottieComposition0);
                return;
            }
            default: {
                this.b.lambda$setProgress$16(this.c, lottieComposition0);
            }
        }
    }
}

