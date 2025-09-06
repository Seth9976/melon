package androidx.compose.foundation.lazy.layout;

import B0.b;
import De.w;
import I.u0;
import P0.z0;
import X0.j;
import X0.k;
import X0.l;
import X0.s;
import X0.u;
import X0.x;
import kotlin.jvm.internal.q;
import r0.p;
import we.a;

public final class V extends p implements z0 {
    public a a;
    public Q b;
    public u0 c;
    public boolean d;
    public boolean e;
    public j f;
    public final T g;
    public T h;

    public V(a a0, Q q0, u0 u00, boolean z, boolean z1) {
        this.a = a0;
        this.b = q0;
        this.c = u00;
        this.d = z;
        this.e = z1;
        this.g = new T(this, 0);
        this.m0();
    }

    @Override  // r0.p
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override  // P0.z0
    public final void l(x x0) {
        u.m(x0);
        ((l)x0).g(s.J, this.g);
        if(this.c == u0.a) {
            j j0 = this.f;
            if(j0 != null) {
                w w0 = u.a[11];
                s.t.a(x0, j0);
                goto label_14;
            }
            q.m("scrollAxisRange");
            throw null;
        }
        j j1 = this.f;
        if(j1 != null) {
            w w1 = u.a[10];
            s.s.a(x0, j1);
        label_14:
            T t0 = this.h;
            if(t0 != null) {
                X0.a a0 = new X0.a(null, t0);
                ((l)x0).g(k.f, a0);
            }
            X0.a a1 = new X0.a(null, new b(new S(this, 0), 27));
            ((l)x0).g(k.B, a1);
            u.f(x0, this.b.c());
            return;
        }
        q.m("scrollAxisRange");
        throw null;
    }

    public final void m0() {
        this.f = new j(new S(this, 1), new S(this, 2), this.e);
        this.h = this.d ? new T(this, 1) : null;
    }
}

