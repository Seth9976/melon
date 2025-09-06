package i.n.i.b.a.s.e;

public final class c {
    public final long a;
    public final long b;
    public final long c;
    public final float d;
    public final float e;

    public c(long v, long v1, long v2, float f, float f1) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = f;
        this.e = f1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? this.a == ((c)object0).a && this.b == ((c)object0).b && this.c == ((c)object0).c && this.d == ((c)object0).d && this.e == ((c)object0).e : false;
    }

    @Override
    public final int hashCode() {
        int v = ((((int)(this.a ^ this.a >>> 0x20)) * 0x1F + ((int)(this.b ^ this.b >>> 0x20))) * 0x1F + ((int)(this.c >>> 0x20 ^ this.c))) * 0x1F;
        int v1 = 0;
        int v2 = Float.compare(this.d, 0.0f) == 0 ? 0 : Float.floatToIntBits(this.d);
        float f = this.e;
        if(f != 0.0f) {
            v1 = Float.floatToIntBits(f);
        }
        return (v + v2) * 0x1F + v1;
    }
}

