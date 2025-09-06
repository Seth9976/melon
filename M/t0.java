package M;

import kotlin.jvm.internal.q;
import r1.c;
import r1.m;

public final class t0 implements x0 {
    public final x0 a;
    public final x0 b;

    public t0(x0 x00, x0 x01) {
        this.a = x00;
        this.b = x01;
    }

    @Override  // M.x0
    public final int a(c c0, m m0) {
        return Math.max(this.a.a(c0, m0), this.b.a(c0, m0));
    }

    @Override  // M.x0
    public final int b(c c0, m m0) {
        return Math.max(this.a.b(c0, m0), this.b.b(c0, m0));
    }

    @Override  // M.x0
    public final int c(c c0) {
        return Math.max(this.a.c(c0), this.b.c(c0));
    }

    @Override  // M.x0
    public final int d(c c0) {
        return Math.max(this.a.d(c0), this.b.d(c0));
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof t0 ? q.b(((t0)object0).a, this.a) && q.b(((t0)object0).b, this.b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() * 0x1F + this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "(" + this.a + " ∪ " + this.b + ')';
    }
}

