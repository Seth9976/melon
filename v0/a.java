package v0;

import ie.H;
import kotlin.jvm.internal.r;
import we.k;
import y0.M;
import y0.N;
import y0.n;

public final class a extends r implements k {
    public final float f;
    public final float g;
    public final int h;
    public final boolean i;

    public a(float f, float f1, int v, boolean z) {
        this.f = f;
        this.g = f1;
        this.h = v;
        this.i = z;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        float f = ((N)object0).D.b() * this.f;
        float f1 = ((N)object0).D.b() * this.g;
        ((N)object0).h((f <= 0.0f || f1 <= 0.0f ? null : new n(f, f1, this.h)));
        ((N)object0).A(M.a);
        ((N)object0).f(this.i);
        return H.a;
    }
}

