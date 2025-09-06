package r1;

import A7.d;
import e1.u;
import kotlin.jvm.internal.q;
import s1.a;

public final class e implements c {
    public final float a;
    public final float b;
    public final a c;

    public e(float f, float f1, a a0) {
        this.a = f;
        this.b = f1;
        this.c = a0;
    }

    @Override  // r1.c
    public final float W() {
        return this.b;
    }

    @Override  // r1.c
    public final float b() {
        return this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e)) {
            return false;
        }
        if(Float.compare(this.a, ((e)object0).a) != 0) {
            return false;
        }
        return Float.compare(this.b, ((e)object0).b) == 0 ? q.b(this.c, ((e)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F);
    }

    @Override  // r1.c
    public final long j(float f) {
        return u.M(0x100000000L, this.c.a(f));
    }

    @Override  // r1.c
    public final float m(long v) {
        if(!p.a(o.b(v), 0x100000000L)) {
            throw new IllegalStateException("Only Sp can convert to Px");
        }
        return this.c.b(o.c(v));
    }

    @Override
    public final String toString() {
        return "DensityWithConverter(density=" + this.a + ", fontScale=" + this.b + ", converter=" + this.c + ')';
    }
}

