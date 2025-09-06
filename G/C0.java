package G;

import kotlin.jvm.internal.q;

public final class c0 implements A0 {
    public final A0 a;
    public final long b;

    public c0(A0 a00, long v) {
        this.a = a00;
        this.b = v;
    }

    @Override  // G.A0
    public final long a(u u0, u u1, u u2) {
        return this.a.a(u0, u1, u2) + this.b;
    }

    @Override  // G.A0
    public final boolean b() {
        return this.a.b();
    }

    @Override  // G.A0
    public final u c(long v, u u0, u u1, u u2) {
        return v >= this.b ? this.a.c(v - this.b, u0, u1, u2) : u2;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof c0 ? ((c0)object0).b == this.b && q.b(((c0)object0).a, this.a) : false;
    }

    @Override  // G.A0
    public final u h(long v, u u0, u u1, u u2) {
        return v >= this.b ? this.a.h(v - this.b, u0, u1, u2) : u0;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }
}

