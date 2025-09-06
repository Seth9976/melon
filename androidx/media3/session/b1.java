package androidx.media3.session;

import I6.Q;
import I6.V;
import I6.p0;
import android.os.Bundle;
import b3.E;
import b3.N;
import b3.g;
import e3.b;
import java.util.Objects;

public final class b1 implements v0 {
    public final k a;
    public final int b;

    public b1(k k0, int v) {
        this.a = k0;
        this.b = v;
    }

    @Override  // androidx.media3.session.v0
    public final void a(int v, N n0) {
        Bundle bundle0 = n0.c();
        this.a.c0(v, bundle0);
    }

    @Override  // androidx.media3.session.v0
    public final void d() {
        this.a.d();
    }

    @Override  // androidx.media3.session.v0
    public final void e(int v) {
        this.a.e(v);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 == null || object0.getClass() != b1.class ? false : Objects.equals(this.a.asBinder(), ((b1)object0).a.asBinder());
    }

    @Override  // androidx.media3.session.v0
    public final void f(int v, v1 v10, boolean z, boolean z1, int v1) {
        Bundle bundle0 = v10.a(z, z1).c(v1);
        this.a.e0(v, bundle0);
    }

    @Override  // androidx.media3.session.v0
    public final void g(int v, k1 k10, N n0, boolean z, boolean z1) {
        Bundle bundle0;
        boolean z2 = false;
        int v1 = this.b;
        b.j(v1 != 0);
        boolean z3 = z || !n0.a(17);
        if(z1 || !n0.a(30)) {
            z2 = true;
        }
        k k0 = this.a;
        if(v1 >= 2) {
            k1 k11 = k10.q(n0, z, z1);
            if(k0 instanceof c0) {
                bundle0 = new Bundle();
                j1 j10 = new j1(k11);
                bundle0.putBinder(k1.l0, j10);
            }
            else {
                bundle0 = k11.t(v1);
            }
            Bundle bundle1 = new Bundle();
            bundle1.putBoolean("0", z3);
            bundle1.putBoolean("1", z2);
            k0.g0(v, bundle0, bundle1);
            return;
        }
        k0.u(k10.q(n0, z, true).t(v1), v, z3);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.a.asBinder()});
    }

    @Override  // androidx.media3.session.v0
    public final void i(int v, Bundle bundle0) {
        this.a.t0(v, bundle0);
    }

    @Override  // androidx.media3.session.v0
    public final void m(int v, V v1) {
        Q q0 = V.o();
        for(int v2 = 0; v2 < v1.size(); ++v2) {
            q0.a(((androidx.media3.session.b)v1.get(v2)).b());
        }
        p0 p00 = q0.g();
        this.a.f(v, p00);
    }

    @Override  // androidx.media3.session.v0
    public final void o(int v, r r0) {
        String s = r.j;
        Object object0 = r0.c;
        int v1 = r0.d;
        Bundle bundle0 = new Bundle();
        bundle0.putInt(r.g, r0.a);
        bundle0.putLong(r.h, r0.b);
        d0 d00 = r0.e;
        if(d00 != null) {
            d00.getClass();
            Bundle bundle1 = new Bundle();
            bundle1.putBundle("0", d00.a);
            bundle1.putBoolean("1", d00.b);
            bundle1.putBoolean("2", d00.c);
            bundle1.putBoolean("3", d00.d);
            bundle0.putBundle(r.i, bundle1);
        }
        u1 u10 = r0.f;
        if(u10 != null) {
            Bundle bundle2 = u10.b();
            bundle0.putBundle(r.l, bundle2);
        }
        bundle0.putInt(r.k, v1);
        if(object0 != null) {
            switch(v1) {
                case 2: {
                    bundle0.putBundle(s, ((E)object0).d(false));
                    break;
                }
                case 3: {
                    Q q0 = V.o();
                    for(int v2 = 0; v2 < ((V)object0).size(); ++v2) {
                        q0.a(((E)((V)object0).get(v2)).d(false));
                    }
                    bundle0.putBinder(s, new g(q0.g()));
                    break;
                }
                case 1: 
                case 4: {
                    throw new IllegalStateException();
                }
            }
        }
        this.a.q(v, bundle0);
    }

    @Override  // androidx.media3.session.v0
    public final void p(int v, String s) {
        this.a.v0(v, s, 0, null);
    }

    @Override  // androidx.media3.session.v0
    public final void q(int v, w1 w10) {
        Bundle bundle0 = w10.b();
        this.a.J(v, bundle0);
    }

    @Override  // androidx.media3.session.v0
    public final void r(int v, u1 u10) {
        Bundle bundle0 = u10.b();
        this.a.Y(v, bundle0);
    }
}

