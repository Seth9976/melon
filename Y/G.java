package Y;

import De.I;
import V4.E;
import kotlin.jvm.internal.r;
import v0.d;
import we.a;
import we.k;
import y0.e;

public final class g extends r implements k {
    public final long f;
    public final a g;
    public final boolean h;

    public g(long v, a a0, boolean z) {
        this.f = v;
        this.g = a0;
        this.h = z;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        e e0 = I.t(((d)object0), Float.intBitsToFloat(((int)(((d)object0).a.c() >> 0x20))) / 2.0f);
        y0.k k0 = new y0.k(this.f, 5);
        return ((d)object0).a(new E(this.g, e0, k0, this.h, 1));
    }
}

