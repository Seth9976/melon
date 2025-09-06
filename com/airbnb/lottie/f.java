package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

public final class f implements Callable {
    public final int a;
    public final Context b;
    public final String c;
    public final String d;

    public f(Context context0, String s, String s1, int v) {
        this.a = v;
        this.b = context0;
        this.c = s;
        this.d = s1;
        super();
    }

    @Override
    public final Object call() {
        return this.a == 0 ? LottieCompositionFactory.fromAssetSync(this.b, this.c, this.d) : LottieCompositionFactory.lambda$fromUrl$0(this.b, this.c, this.d);
    }
}

