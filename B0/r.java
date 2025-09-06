package b0;

import A0.f;
import A0.i;
import ie.H;
import we.a;
import we.k;
import x0.e;

public final class r extends kotlin.jvm.internal.r implements k {
    public final a f;
    public final int g;
    public final float h;
    public final float i;
    public final long j;
    public final i k;
    public final long l;

    public r(a a0, int v, float f, float f1, long v1, i i0, long v2) {
        this.f = a0;
        this.g = v;
        this.h = f;
        this.i = f1;
        this.j = v1;
        this.k = i0;
        this.l = v2;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        float f = ((Number)this.f.invoke()).floatValue();
        float f1 = (this.g == 0 || e.b(((f)object0).c()) > e.d(((f)object0).c()) ? this.h : this.h + this.i) / ((float)(((double)((f)object0).S(e.d(((f)object0).c()))) * 3.141593)) * 360.0f;
        w.c(((f)object0), Math.min(f * 360.0f, f1) + (270.0f + f * 360.0f), 360.0f - f * 360.0f - Math.min(f * 360.0f, f1) * 2.0f, this.j, this.k);
        w.c(((f)object0), 270.0f, f * 360.0f, this.l, this.k);
        return H.a;
    }
}

