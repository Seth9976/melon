package com.melon.ui.playermusic;

import ie.H;
import kotlin.jvm.internal.q;
import we.a;
import we.k;
import y0.N;

public final class g implements k {
    public final a a;

    public g(a a0) {
        this.a = a0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((N)object0), "$this$graphicsLayer");
        float f = (1.0f - Math.abs(((Number)this.a.invoke()).floatValue())) * 0.08f + 0.92f;
        ((N)object0).r(f);
        ((N)object0).s(f);
        return H.a;
    }
}

