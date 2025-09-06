package com.melon.ui.playermusic;

import E9.g;
import W.p;
import ie.H;
import kotlin.jvm.internal.q;
import r1.f;
import we.k;
import x1.d;
import x1.n;

public final class e implements k {
    public final x1.e a;
    public final float b;

    public e(x1.e e0, float f) {
        this.a = e0;
        this.b = f;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((d)object0), "$this$constrainAs");
        g.v(((d)object0).e, this.a.e, 0.0f, 6);
        g.v(((d)object0).g, this.a.g, 0.0f, 6);
        p.l(((d)object0).d, this.a.d, 0.0f, 6);
        p.l(((d)object0).f, this.a.f, 0.0f, 6);
        ((d)object0).d(new n(new f(this.b), null));
        ((d)object0).c(new n(new f(this.b), null));
        return H.a;
    }
}

