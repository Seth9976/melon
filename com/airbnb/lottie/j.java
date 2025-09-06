package com.airbnb.lottie;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

public final class j implements Callable {
    public final WeakReference a;
    public final Context b;
    public final int c;
    public final String d;

    public j(WeakReference weakReference0, Context context0, int v, String s) {
        this.a = weakReference0;
        this.b = context0;
        this.c = v;
        this.d = s;
    }

    @Override
    public final Object call() {
        return LottieCompositionFactory.lambda$fromRawRes$3(this.a, this.b, this.c, this.d);
    }
}

