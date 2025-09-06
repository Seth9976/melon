package com.iloen.melon.utils.system;

import Cb.i;
import ie.H;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.q;
import we.k;

public final class b implements k {
    public final int a;
    public final double b;
    public final D c;
    public final int d;
    public final double e;
    public final int f;
    public final int g;

    public b(int v, double f, D d0, int v1, double f1, int v2, int v3) {
        this.a = v;
        this.b = f;
        this.c = d0;
        this.d = v1;
        this.e = f1;
        this.f = v2;
        this.g = v3;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((StringBuilder)object0), "$this$buildDebug");
        ((StringBuilder)object0).append("setVolumeFromKeyDownInternal() Cast");
        i.a(((StringBuilder)object0), "maxVolume: " + this.a);
        i.a(((StringBuilder)object0), "rawVolume: " + this.b);
        i.a(((StringBuilder)object0), "adjustedVolume: " + this.c.a);
        i.a(((StringBuilder)object0), "unitVolume: " + this.d);
        i.a(((StringBuilder)object0), "adjustedUnitVolume: " + this.e);
        i.a(((StringBuilder)object0), "emitVolume: " + this.f);
        i.a(((StringBuilder)object0), "adjustedEmitVolume: " + this.g);
        return H.a;
    }
}

