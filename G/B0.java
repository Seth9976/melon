package G;

import kotlin.jvm.internal.q;

public final class b0 implements o {
    public final o a;
    public final long b;

    public b0(D d0, long v) {
        this.a = d0;
        this.b = v;
    }

    @Override  // G.o
    public final A0 a(y0 y00) {
        return new c0(this.a.a(y00), this.b);
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof b0 ? ((b0)object0).b == this.b && q.b(((b0)object0).a, this.a) : false;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }
}

