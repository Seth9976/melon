package x1;

import N0.x;
import kotlin.jvm.internal.q;
import we.k;

public final class h implements x {
    public final e a;
    public final k b;
    public final Object c;

    public h(e e0, k k0) {
        this.a = e0;
        this.b = k0;
        this.c = e0.c;
    }

    @Override  // N0.x
    public final Object D() {
        return this.c;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof h && q.b(this.a.c, ((h)object0).a.c) && this.b == ((h)object0).b;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.c.hashCode() * 0x1F;
    }
}

