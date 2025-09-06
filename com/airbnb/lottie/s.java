package com.airbnb.lottie;

public final class s implements LazyCompositionTask {
    public final int a;
    public final LottieDrawable b;

    public s(LottieDrawable lottieDrawable0, int v) {
        this.a = v;
        this.b = lottieDrawable0;
        super();
    }

    @Override  // com.airbnb.lottie.LottieDrawable$LazyCompositionTask
    public final void run(LottieComposition lottieComposition0) {
        if(this.a != 0) {
            this.b.lambda$playAnimation$3(lottieComposition0);
            return;
        }
        this.b.lambda$resumeAnimation$4(lottieComposition0);
    }
}

