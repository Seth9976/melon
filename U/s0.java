package U;

import a1.U;
import a1.g;
import a1.t;
import e1.i;
import java.util.List;
import je.w;
import r1.c;
import r1.m;

public final class s0 {
    public final g a;
    public final U b;
    public final int c;
    public final int d;
    public final boolean e;
    public final int f;
    public final c g;
    public final i h;
    public final List i;
    public H8.i j;
    public m k;

    public s0(g g0, U u0, boolean z, c c0, i i0, int v) {
        this.a = g0;
        this.b = u0;
        this.c = 0x7FFFFFFF;
        this.d = 1;
        this.e = z;
        this.f = 1;
        this.g = c0;
        this.h = i0;
        this.i = w.a;
    }

    public final void a(m m0) {
        H8.i i0 = this.j;
        if(i0 == null || m0 != this.k || i0.b()) {
            this.k = m0;
            U u0 = t.i(this.b, m0);
            i0 = new H8.i(this.a, u0, this.i, this.g, this.h);
        }
        this.j = i0;
    }
}

