package com.airbnb.lottie;

import java.util.concurrent.atomic.AtomicBoolean;

public final class i implements LottieListener {
    public final int a;
    public final String b;
    public final AtomicBoolean c;

    public i(String s, AtomicBoolean atomicBoolean0, int v) {
        this.a = v;
        this.b = s;
        this.c = atomicBoolean0;
        super();
    }

    @Override  // com.airbnb.lottie.LottieListener
    public final void onResult(Object object0) {
        if(this.a != 0) {
            LottieCompositionFactory.lambda$cache$19(this.b, this.c, ((Throwable)object0));
            return;
        }
        LottieCompositionFactory.lambda$cache$18(this.b, this.c, ((LottieComposition)object0));
    }
}

