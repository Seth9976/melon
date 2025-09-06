package androidx.compose.foundation.lazy.layout;

import B2.p;
import O.m;
import androidx.collection.K;
import kotlin.jvm.internal.q;
import m0.b;
import o0.c;
import we.n;

public final class u {
    public final c a;
    public final m b;
    public final K c;

    public u(c c0, m m0) {
        this.a = c0;
        this.b = m0;
        this.c = new K();
    }

    public final n a(int v, Object object0, Object object1) {
        K k0 = this.c;
        t t0 = (t)k0.g(object0);
        if(t0 != null && t0.c == v && q.b(t0.b, object1)) {
            n n0 = t0.d;
            if(n0 == null) {
                b b0 = new b(0x53AF4291, new p(17, t0.e, t0), true);
                t0.d = b0;
                return b0;
            }
            return n0;
        }
        t t1 = new t(this, v, object0, object1);
        k0.l(object0, t1);
        n n1 = t1.d;
        if(n1 == null) {
            b b1 = new b(0x53AF4291, new p(17, this, t1), true);
            t1.d = b1;
            return b1;
        }
        return n1;
    }

    public final Object b(Object object0) {
        if(object0 != null) {
            t t0 = (t)this.c.g(object0);
            if(t0 != null) {
                return t0.b;
            }
            v v0 = (v)this.b.invoke();
            int v1 = v0.b(object0);
            return v1 == -1 ? null : v0.a(v1);
        }
        return null;
    }
}

