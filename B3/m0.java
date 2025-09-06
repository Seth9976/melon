package b3;

import java.util.Objects;

public final class m0 {
    public Object a;
    public Object b;
    public int c;
    public long d;
    public long e;
    public boolean f;
    public b g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final String l;

    static {
        m0.h = "0";
        m0.i = "1";
        m0.j = "2";
        m0.k = "3";
        m0.l = "4";
    }

    public m0() {
        this.g = b.f;
    }

    public final long a(int v, int v1) {
        a a0 = this.g.a(v);
        return a0.b == -1 ? 0x8000000000000001L : a0.g[v1];
    }

    public final int b(long v) {
        b b0 = this.g;
        int v1 = b0.a;
        if(Long.compare(v, 0x8000000000000000L) != 0 && (this.d == 0x8000000000000001L || v < this.d)) {
            int v2;
            for(v2 = b0.d; v2 < v1; ++v2) {
                if(b0.a(v2).a == 0x8000000000000000L || b0.a(v2).a > v) {
                    a a0 = b0.a(v2);
                    if(a0.b != -1 && a0.a(-1) >= a0.b) {
                        continue;
                    }
                    break;
                }
            }
            return v2 >= v1 ? -1 : v2;
        }
        return -1;
    }

    public final int c(long v) {
        b b0 = this.g;
        long v1 = this.d;
        int v2 = b0.b(b0.a - 1);
        int v3;
        for(v3 = b0.a - 1 - v2; v3 >= 0 && v != 0x8000000000000000L; --v3) {
            a a0 = b0.a(v3);
            long v4 = a0.a;
            if(v4 != 0x8000000000000000L) {
                if(v < v4) {
                    continue;
                }
                break;
            }
            else if(v1 != 0x8000000000000001L && (!a0.i || a0.b != -1) && v >= v1) {
                break;
            }
        }
        if(v3 >= 0) {
            a a1 = b0.a(v3);
            int v5 = a1.b;
            if(v5 != -1) {
                int v6 = 0;
                while(v6 < v5) {
                    switch(a1.f[v6]) {
                        case 0: 
                        case 1: {
                            return v3;
                        }
                        default: {
                            ++v6;
                        }
                    }
                }
                return -1;
            }
            return v3;
        }
        return -1;
    }

    public final long d(int v) {
        return this.g.a(v).a;
    }

    public final int e(int v, int v1) {
        a a0 = this.g.a(v);
        return a0.b == -1 ? 0 : a0.f[v1];
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return m0.class.equals(class0) && Objects.equals(this.a, ((m0)object0).a) && Objects.equals(this.b, ((m0)object0).b) && this.c == ((m0)object0).c && this.d == ((m0)object0).d && this.e == ((m0)object0).e && this.f == ((m0)object0).f && Objects.equals(this.g, ((m0)object0).g);
        }
        return false;
    }

    public final int f(int v) {
        return this.g.a(v).a(-1);
    }

    public final boolean g(int v) {
        return v == this.g.a - 1 && this.g.b(v);
    }

    public final boolean h(int v) {
        return this.g.a(v).i;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        Object object0 = this.b;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return this.g.hashCode() + ((((((v1 + 0xD9) * 0x1F + v) * 0x1F + this.c) * 0x1F + ((int)(this.d ^ this.d >>> 0x20))) * 0x1F + ((int)(this.e ^ this.e >>> 0x20))) * 0x1F + this.f) * 0x1F;
    }

    public final void i(Object object0, Object object1, int v, long v1, long v2, b b0, boolean z) {
        this.a = object0;
        this.b = object1;
        this.c = v;
        this.d = v1;
        this.e = v2;
        this.g = b0;
        this.f = z;
    }
}

