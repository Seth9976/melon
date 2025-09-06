package gc;

import Cb.i;
import Sb.a;
import U4.F;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class p implements k {
    public final boolean a;
    public final int b;
    public final long c;
    public final int d;
    public final a e;

    public p(boolean z, int v, long v1, int v2, a a0) {
        this.a = z;
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.e = a0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((StringBuilder)object0), "$this$buildDebug");
        ((StringBuilder)object0).append("stopImpl() keepNotification: " + this.a);
        i.a(((StringBuilder)object0), "itemIndex: " + this.b);
        i.a(((StringBuilder)object0), "setContentPositionMs: " + this.c);
        i.a(((StringBuilder)object0), "playbackState: " + F.a0(this.d));
        i.a(((StringBuilder)object0), "exception: " + (this.e == null ? null : this.e.getMessage()));
        return H.a;
    }
}

