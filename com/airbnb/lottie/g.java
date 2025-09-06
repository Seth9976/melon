package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

public final class g implements Callable {
    public final int a;
    public final Context b;
    public final ZipInputStream c;
    public final String d;

    public g(Context context0, ZipInputStream zipInputStream0, String s, int v) {
        this.a = v;
        this.b = context0;
        this.c = zipInputStream0;
        this.d = s;
        super();
    }

    @Override
    public final Object call() {
        return this.a == 0 ? LottieCompositionFactory.fromZipStreamSync(this.b, this.c, this.d) : LottieCompositionFactory.fromZipStreamSync(this.b, this.c, this.d);
    }
}

