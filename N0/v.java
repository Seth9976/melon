package N0;

import P0.I;
import P0.L;
import P0.f;
import Q0.u;
import Y0.c;
import Y0.d;
import androidx.collection.z;
import r0.p;
import we.k;

public final class V extends p {
    public long a;
    public long b;
    public k c;
    public c d;

    public final void m0() {
        c c0 = this.d;
        if(c0 != null) {
            c0.b();
        }
        long v = this.a;
        long v1 = this.b;
        k k0 = this.c;
        I i0 = f.v(this);
        int v2 = i0.b;
        d d0 = ((u)L.a(i0)).getRectManager().b;
        d0.getClass();
        z z0 = (z)d0.d;
        c c1 = new c(d0, v2, v, (v1 == 0L ? v : v1), this, k0);
        c c2 = z0.b(v2);
        if(c2 == null) {
            z0.h(v2, c1);
            c2 = c1;
        }
        c c3 = c2;
        if(c3 != c1) {
            c c4;
            while((c4 = c3.f) != null) {
                c3 = c4;
            }
            c3.f = c1;
        }
        this.d = c1;
    }

    @Override  // r0.p
    public final void onAttach() {
        this.m0();
    }

    @Override  // r0.p
    public final void onDetach() {
        c c0 = this.d;
        if(c0 != null) {
            c0.b();
        }
    }
}

