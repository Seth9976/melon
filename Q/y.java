package Q;

import I.u0;
import androidx.compose.foundation.lazy.layout.z;
import kotlin.jvm.internal.r;
import r0.g;
import r0.h;
import r1.m;
import we.k;
import y5.a;

public final class y extends r implements k {
    public final int f;
    public final z g;
    public final long h;
    public final x i;
    public final long j;
    public final u0 k;
    public final g l;
    public final h m;
    public final int n;

    public y(z z0, long v, x x0, long v1, u0 u00, g g0, h h0, int v2, int v3) {
        this.f = v3;
        this.g = z0;
        this.h = v;
        this.i = x0;
        this.j = v1;
        this.k = u00;
        this.l = g0;
        this.m = h0;
        this.n = v2;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            m m0 = this.g.b.getLayoutDirection();
            return a.A(this.g, ((Number)object0).intValue(), this.h, this.i, this.j, this.k, this.l, this.m, m0, false, this.n);
        }
        m m1 = this.g.b.getLayoutDirection();
        return a.A(this.g, ((Number)object0).intValue(), this.h, this.i, this.j, this.k, this.l, this.m, m1, false, this.n);
    }
}

