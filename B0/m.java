package b0;

import A0.f;
import df.v;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;
import x0.e;

public final class m extends r implements k {
    public final float f;
    public final long g;

    public m(long v, float f) {
        this.f = f;
        this.g = v;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        float f = ((f)object0).Y(this.f);
        long v = v.h(0.0f, ((f)object0).Y(this.f) / 2.0f);
        long v1 = v.h(e.d(((f)object0).c()), ((f)object0).Y(this.f) / 2.0f);
        f.k0(((f)object0), this.g, v, v1, f, 0, null, 0x1F0);
        return H.a;
    }
}

