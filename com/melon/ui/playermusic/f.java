package com.melon.ui.playermusic;

import E9.g;
import W.p;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;
import x1.d;
import x1.n;

public final class f implements k {
    public final float a;
    public final float b;

    public f(float f, float f1) {
        this.a = f;
        this.b = f1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((d)object0), "$this$constrainAs");
        g.v(((d)object0).e, ((d)object0).c.e, this.a, 4);
        p.l(((d)object0).d, ((d)object0).c.d, 0.0f, 6);
        p.l(((d)object0).f, ((d)object0).c.f, 0.0f, 6);
        ((d)object0).d(new n(new r1.f(this.b), null));
        ((d)object0).c(new n(new r1.f(this.b), null));
        return H.a;
    }
}

