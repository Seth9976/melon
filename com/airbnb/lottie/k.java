package com.airbnb.lottie;

import java.io.InputStream;
import java.util.concurrent.Callable;

public final class k implements Callable {
    public final InputStream a;
    public final String b;
    public final boolean c;

    public k(InputStream inputStream0, String s, boolean z) {
        this.a = inputStream0;
        this.b = s;
        this.c = z;
    }

    @Override
    public final Object call() {
        return LottieCompositionFactory.fromJsonInputStreamSync(this.a, this.b, this.c);
    }
}

