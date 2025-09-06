package com.iloen.melon.utils.system;

import Cb.i;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class c implements k {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public c(int v, int v1, int v2, int v3) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((StringBuilder)object0), "$this$buildDebug");
        ((StringBuilder)object0).append("setVolumeFromKeyDownInternal() Dlna");
        i.a(((StringBuilder)object0), "dlnaVolume: " + this.a);
        i.a(((StringBuilder)object0), "adjustedVolume: " + this.b);
        i.a(((StringBuilder)object0), "unitVolume: " + this.c);
        i.a(((StringBuilder)object0), "emitVolume: " + this.d);
        return H.a;
    }
}

