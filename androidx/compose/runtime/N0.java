package androidx.compose.runtime;

import androidx.collection.F;
import androidx.collection.K;
import kotlin.jvm.internal.q;
import we.n;

public final class n0 {
    public int a;
    public v b;
    public a c;
    public n d;
    public int e;
    public F f;
    public K g;

    public n0(v v0) {
        this.b = v0;
    }

    public static boolean a(E e0, K k0) {
        q.e(e0, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        P0 p00 = e0.c;
        if(p00 == null) {
            p00 = V.f;
        }
        return !p00.a(e0.n().f, k0.g(e0));
    }

    public final boolean b() {
        if(this.b != null) {
            return this.c == null ? false : this.c.a();
        }
        return false;
    }

    public final P c(Object object0) {
        v v0 = this.b;
        if(v0 != null) {
            P p0 = v0.q(this, object0);
            return p0 == null ? P.a : p0;
        }
        return P.a;
    }

    public final void d() {
        v v0 = this.b;
        if(v0 != null) {
            v0.o = true;
        }
        this.b = null;
        this.f = null;
        this.g = null;
    }

    public final void e(boolean z) {
        if(z) {
            this.a |= 0x20;
            return;
        }
        this.a &= -33;
    }

    public final void f(n n0) {
        this.d = n0;
    }
}

