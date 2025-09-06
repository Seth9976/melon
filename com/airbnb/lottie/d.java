package com.airbnb.lottie;

import java.util.concurrent.Callable;

public final class d implements Callable {
    public final LottieAnimationView a;
    public final int b;

    public d(LottieAnimationView lottieAnimationView0, int v) {
        this.a = lottieAnimationView0;
        this.b = v;
    }

    @Override
    public final Object call() {
        return this.a.lambda$fromRawRes$1(this.b);
    }
}

