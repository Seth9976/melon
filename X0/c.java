package x0;

import A7.d;

public final class c {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public static final c e;

    static {
        c.e = new c(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public c(float f, float f1, float f2, float f3) {
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
    }

    public final long a() {
        return ((long)Float.floatToRawIntBits((this.d - this.b) / 2.0f + this.b)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits((this.c - this.a) / 2.0f + this.a)) << 0x20;
    }

    public final long b() {
        return ((long)Float.floatToRawIntBits(this.d - this.b)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(this.c - this.a)) << 0x20;
    }

    public final long c() {
        return ((long)Float.floatToRawIntBits(this.a)) << 0x20 | ((long)Float.floatToRawIntBits(this.b)) & 0xFFFFFFFFL;
    }

    public final c d(c c0) {
        return new c(Math.max(this.a, c0.a), Math.max(this.b, c0.b), Math.min(this.c, c0.c), Math.min(this.d, c0.d));
    }

    public final boolean e() {
        int v = 0;
        int v1 = Float.compare(this.a, this.c) < 0 ? 0 : 1;
        if(this.b >= this.d) {
            v = 1;
        }
        return v1 | v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c)) {
            return false;
        }
        if(Float.compare(this.a, ((c)object0).a) != 0) {
            return false;
        }
        if(Float.compare(this.b, ((c)object0).b) != 0) {
            return false;
        }
        return Float.compare(this.c, ((c)object0).c) == 0 ? Float.compare(this.d, ((c)object0).d) == 0 : false;
    }

    public final boolean f(c c0) {
        int v = 0;
        int v1 = Float.compare(this.a, c0.c) >= 0 ? 0 : 1;
        int v2 = c0.a < this.c ? 1 : 0;
        int v3 = this.b < c0.d ? 1 : 0;
        if(c0.b < this.d) {
            v = 1;
        }
        return v1 & v2 & v3 & v;
    }

    public final c g(float f, float f1) {
        return new c(this.a + f, this.b + f1, this.c + f, this.d + f1);
    }

    public final c h(long v) {
        return new c(Float.intBitsToFloat(((int)(v >> 0x20))) + this.a, Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) + this.b, Float.intBitsToFloat(((int)(v >> 0x20))) + this.c, Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) + this.d);
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.d) + d.a(this.c, d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        return "Rect.fromLTRB(" + df.d.N(this.a) + ", " + df.d.N(this.b) + ", " + df.d.N(this.c) + ", " + df.d.N(this.d) + ')';
    }
}

