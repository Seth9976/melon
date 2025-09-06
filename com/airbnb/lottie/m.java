package com.airbnb.lottie;

public final class m implements LazyCompositionTask {
    public final int a;
    public final LottieDrawable b;
    public final int c;

    public m(LottieDrawable lottieDrawable0, int v, int v1) {
        this.a = v1;
        this.b = lottieDrawable0;
        this.c = v;
        super();
    }

    @Override  // com.airbnb.lottie.LottieDrawable$LazyCompositionTask
    public final void run(LottieComposition lottieComposition0) {
        switch(this.a) {
            case 0: {
                this.b.lambda$setFrame$15(this.c, lottieComposition0);
                return;
            }
            case 1: {
                this.b.lambda$setMaxFrame$7(this.c, lottieComposition0);
                return;
            }
            default: {
                this.b.lambda$setMinFrame$5(this.c, lottieComposition0);
            }
        }
    }
}

