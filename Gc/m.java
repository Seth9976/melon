package gc;

import Cb.i;
import b3.E;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class m implements k {
    public final E a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    public m(E e0, long v, long v1, long v2, long v3) {
        this.a = e0;
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.e = v3;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((StringBuilder)object0), "$this$buildDebug");
        ((StringBuilder)object0).append("onPrepared() currentItem: " + this.a.a);
        i.a(((StringBuilder)object0), "durationMs: " + this.b);
        i.a(((StringBuilder)object0), "setDurationMs: " + this.c);
        i.a(((StringBuilder)object0), "contentPositionMs: " + this.d);
        i.a(((StringBuilder)object0), "setContentPositionMs: " + this.e);
        return H.a;
    }
}

