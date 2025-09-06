package T;

import e.k;
import kotlin.jvm.internal.q;
import r1.c;
import r1.m;
import x0.e;
import y0.H;
import y0.I;
import y0.M;
import y0.Q;

public final class d implements Q {
    public final a a;
    public final a b;
    public final a c;
    public final a d;

    public d(a a0, a a1, a a2, a a3) {
        this.a = a0;
        this.b = a1;
        this.c = a2;
        this.d = a3;
    }

    public static d a(d d0, b b0, b b1, b b2, int v) {
        if((v & 1) != 0) {
            b0 = d0.a;
        }
        a a0 = d0.b;
        if((v & 4) != 0) {
            b1 = d0.c;
        }
        d0.getClass();
        return new d(b0, a0, b1, b2);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d)) {
            return false;
        }
        if(!q.b(this.a, ((d)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((d)object0).b)) {
            return false;
        }
        return q.b(this.c, ((d)object0).c) ? q.b(this.d, ((d)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + (this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F) * 0x1F;
    }

    @Override  // y0.Q
    public final M i(long v, m m0, c c0) {
        float f = this.a.a(v, c0);
        float f1 = this.b.a(v, c0);
        float f2 = this.c.a(v, c0);
        float f3 = this.d.a(v, c0);
        float f4 = e.c(v);
        float f5 = f + f3;
        if(f5 > f4) {
            float f6 = f4 / f5;
            f *= f6;
            f3 *= f6;
        }
        float f7 = f1 + f2;
        if(f7 > f4) {
            float f8 = f4 / f7;
            f1 *= f8;
            f2 *= f8;
        }
        if(f < 0.0f || f1 < 0.0f || f2 < 0.0f || f3 < 0.0f) {
            L.a.a(("Corner size in Px can\'t be negative(topStart = " + f + ", topEnd = " + f1 + ", bottomEnd = " + f2 + ", bottomStart = " + f3 + ")!"));
        }
        if(Float.compare(f + f1 + f2 + f3, 0.0f) == 0) {
            return new H(k.d(0L, v));
        }
        x0.c c1 = k.d(0L, v);
        m m1 = m.a;
        float f9 = m0 == m1 ? f : f1;
        long v1 = ((long)Float.floatToRawIntBits(f9)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f9)) << 0x20;
        if(m0 == m1) {
            f = f1;
        }
        long v2 = ((long)Float.floatToRawIntBits(f)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f)) << 0x20;
        float f10 = m0 == m1 ? f2 : f3;
        long v3 = ((long)Float.floatToRawIntBits(f10)) << 0x20 | ((long)Float.floatToRawIntBits(f10)) & 0xFFFFFFFFL;
        if(m0 != m1) {
            f3 = f2;
        }
        return new I(e1.b.j(c1, v1, v2, v3, ((long)Float.floatToRawIntBits(f3)) << 0x20 | ((long)Float.floatToRawIntBits(f3)) & 0xFFFFFFFFL));
    }

    @Override
    public final String toString() {
        return "RoundedCornerShape(topStart = " + this.a + ", topEnd = " + this.b + ", bottomEnd = " + this.c + ", bottomStart = " + this.d + ')';
    }
}

