package a1;

import A0.h;
import A7.d;
import r1.o;

public final class m implements b {
    public final long a;
    public final long b;

    public m(long v, long v1) {
        this.a = v;
        this.b = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null || !(object0 instanceof m) || !p.a.equals(p.a)) {
            return false;
        }
        if(!o.a(this.a, ((m)object0).a)) {
            return false;
        }
        return o.a(this.b, ((m)object0).b) ? h.b.equals(h.b) : false;
    }

    @Override
    public final int hashCode() {
        return h.b.hashCode() + d.a(1.0f, d.c(d.c(p.a.hashCode() * 0x1F, 0x1F, this.a), 961, this.b), 0x1F);
    }

    @Override
    public final String toString() {
        return "Bullet(shape=" + p.a + ", size=" + o.d(this.a) + ", padding=" + o.d(this.b) + ", brush=null, alpha=1.0, drawStyle=" + h.b + ')';
    }
}

