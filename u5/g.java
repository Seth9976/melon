package u5;

import e1.m;
import kotlin.jvm.internal.q;

public final class g {
    public final m a;
    public final m b;
    public static final g c;

    static {
        g.c = new g(b.e, b.e);
    }

    public g(m m0, m m1) {
        this.a = m0;
        this.b = m1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        return q.b(this.a, ((g)object0).a) ? q.b(this.b, ((g)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Size(width=" + this.a + ", height=" + this.b + ')';
    }
}

