package G;

import kotlin.jvm.internal.H;
import kotlin.jvm.internal.r;
import we.k;

public final class g0 extends r implements k {
    public final H f;
    public final Object g;
    public final G.k h;
    public final u i;
    public final p j;
    public final float k;
    public final k l;

    public g0(H h0, Object object0, G.k k0, u u0, p p0, float f, k k1) {
        this.f = h0;
        this.g = object0;
        this.h = k0;
        this.i = u0;
        this.j = p0;
        this.k = f;
        this.l = k1;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        long v = ((Number)object0).longValue();
        y0 y00 = this.h.f();
        Object object1 = this.h.h();
        f0 f00 = new f0(0, this.j);
        n n0 = new n(this.g, y00, this.i, v, object1, v, f00);
        f.l(n0, v, this.k, this.h, this.j, this.l);
        this.f.a = n0;
        return ie.H.a;
    }
}

