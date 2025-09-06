package F;

import N0.O;
import N0.Z;
import N0.a0;
import ie.H;
import kotlin.jvm.internal.r;
import r1.m;
import we.k;

public final class i0 extends r implements k {
    public final long f;
    public final int g;
    public final int h;
    public final O i;
    public final a0 j;

    public i0(j0 j00, long v, int v1, int v2, O o0, a0 a00) {
        this.f = v;
        this.g = v1;
        this.h = v2;
        this.i = o0;
        this.j = a00;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        long v = ((long)this.g) << 0x20 | ((long)this.h) & 0xFFFFFFFFL;
        m m0 = this.i.getLayoutDirection();
        Z.f(((Z)object0), this.j, ((long)Math.round(0.0f * (((float)(((int)(v & 0xFFFFFFFFL)) - ((int)(this.f & 0xFFFFFFFFL)))) / 2.0f))) & 0xFFFFFFFFL | ((long)Math.round(((m0 == m.a ? -1.0f : 1.0f) + 1.0f) * (((float)(((int)(v >> 0x20)) - ((int)(this.f >> 0x20)))) / 2.0f))) << 0x20);
        return H.a;
    }
}

