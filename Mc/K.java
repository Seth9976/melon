package Mc;

import F.s;
import O.j;
import O.w;
import Oc.c;
import ie.H;
import kotlin.jvm.internal.q;
import m0.b;

public final class k implements we.k {
    public final c a;
    public final boolean b;
    public final boolean c;

    public k(c c0, boolean z, boolean z1) {
        this.a = c0;
        this.b = z;
        this.c = z1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((w)object0), "$this$MelonLazyColumn");
        s s0 = new s(4, this.a.a);
        b b0 = new b(0xDA480CDF, new l(this.a.a, this.b, this.c), true);
        ((j)(((w)object0))).u(this.a.a.size(), null, s0, b0);
        return H.a;
    }
}

