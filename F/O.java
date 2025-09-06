package F;

import N0.Z;
import N0.a0;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;

public final class o extends r implements k {
    public final q f;
    public final a0 g;
    public final long h;

    public o(q q0, a0 a00, long v) {
        this.f = q0;
        this.g = a00;
        this.h = v;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        this.f.c.getClass();
        long v = ((long)this.g.a) << 0x20 | ((long)this.g.b) & 0xFFFFFFFFL;
        Z.f(((Z)object0), this.g, ((long)Math.round(0.0f * (((float)(((int)(this.h >> 0x20)) - ((int)(v >> 0x20)))) / 2.0f))) << 0x20 | ((long)Math.round(0.0f * (((float)(((int)(this.h & 0xFFFFFFFFL)) - ((int)(v & 0xFFFFFFFFL)))) / 2.0f))) & 0xFFFFFFFFL);
        return H.a;
    }
}

