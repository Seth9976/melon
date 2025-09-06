package androidx.media3.exoplayer;

import e3.b;

public final class i0 {
    public final long a;
    public final long b;
    public static final i0 c;

    static {
        i0 i00 = new i0(0L, 0L);
        new i0(0x7FFFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFFFL);
        new i0(0x7FFFFFFFFFFFFFFFL, 0L);
        new i0(0L, 0x7FFFFFFFFFFFFFFFL);
        i0.c = i00;
    }

    public i0(long v, long v1) {
        boolean z = false;
        b.c(Long.compare(v, 0L) >= 0);
        if(v1 >= 0L) {
            z = true;
        }
        b.c(z);
        this.a = v;
        this.b = v1;
    }

    public final long a(long v, long v1, long v2) {
        long v3 = this.a;
        long v4 = this.b;
        if(Long.compare(v3, 0L) == 0 && v4 == 0L) {
            return v;
        }
        long v5 = ((v3 ^ v) & (v ^ v - v3)) >= 0L ? v - v3 : 0x8000000000000000L;
        long v6 = v + v4;
        v6 = ((v4 ^ v6) & (v ^ v6)) >= 0L ? v + v4 : 0x7FFFFFFFFFFFFFFFL;
        boolean z = false;
        boolean z1 = Long.compare(v5, v1) <= 0 && v1 <= v6;
        if(v5 <= v2 && v2 <= v6) {
            z = true;
        }
        if(z1 && z) {
            return Math.abs(v1 - v) > Math.abs(v2 - v) ? v2 : v1;
        }
        if(z1) {
            return v1;
        }
        return z ? v2 : v5;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return i0.class == class0 && this.a == ((i0)object0).a && this.b == ((i0)object0).b;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return ((int)this.a) * 0x1F + ((int)this.b);
    }
}

