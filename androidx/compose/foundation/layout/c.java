package androidx.compose.foundation.layout;

import M.t;
import M.v;
import N0.k0;
import r0.e;
import r0.q;
import r1.a;

public final class c implements t, v {
    public final r1.c a;
    public final long b;

    public c(k0 k00, long v) {
        this.a = k00;
        this.b = v;
    }

    @Override  // M.t
    public final q a(q q0, e e0) {
        return q0.then(new BoxChildDataElement(e0, false));
    }

    // 去混淆评级： 低(20)
    public final float b() {
        return a.c(this.b) ? this.a.R(a.g(this.b)) : Infinityf;
    }

    // 去混淆评级： 低(20)
    public final float c() {
        return a.d(this.b) ? this.a.R(a.h(this.b)) : Infinityf;
    }

    public final float d() {
        return this.a.R(a.i(this.b));
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof c && kotlin.jvm.internal.q.b(this.a, ((c)object0).a) && a.b(this.b, ((c)object0).b);
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.a + ", constraints=" + a.l(this.b) + ')';
    }
}

