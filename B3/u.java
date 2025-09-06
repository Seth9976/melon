package b3;

import e3.x;

public class u {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public static final u h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final String o;

    static {
        u.h = new u(new t());
        u.i = "0";
        u.j = "1";
        u.k = "2";
        u.l = "3";
        u.m = "4";
        u.n = "5";
        u.o = "6";
    }

    public u(t t0) {
        this.a = x.Z(t0.a);
        this.c = x.Z(t0.b);
        this.b = t0.a;
        this.d = t0.b;
        this.e = t0.c;
        this.f = t0.d;
        this.g = t0.e;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof u ? this.b == ((u)object0).b && this.d == ((u)object0).d && this.e == ((u)object0).e && this.f == ((u)object0).f && this.g == ((u)object0).g : false;
    }

    @Override
    public final int hashCode() {
        return (((((int)(this.b ^ this.b >>> 0x20)) * 0x1F + ((int)(this.d >>> 0x20 ^ this.d))) * 0x1F + this.e) * 0x1F + this.f) * 0x1F + this.g;
    }
}

