package i.n.i.b.a.s.e;

public final class U2 implements Comparable {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;

    public U2(u u0, d fi$d0, int v, String s) {
        int v5;
        boolean z = false;
        this.b = fi.d(v, false);
        int v1 = u0.e;
        h9 h90 = fi$d0.c;
        int v2 = u0.d & ~fi$d0.f;
        this.c = (v2 & 1) != 0;
        this.d = (v2 & 2) != 0;
        h9 h91 = h90.isEmpty() ? h9.l("") : h90;
        int v3;
        for(v3 = 0; true; ++v3) {
            if(v3 >= h91.size()) {
                v3 = 0x7FFFFFFF;
                v5 = 0;
                break;
            }
            int v4 = fi.a(u0, ((String)h91.get(v3)), fi$d0.e);
            if(v4 > 0) {
                v5 = v4;
                break;
            }
        }
        this.e = v3;
        this.f = v5;
        int v6 = Integer.bitCount(fi$d0.d & v1);
        this.g = v6;
        this.i = (v1 & 0x440) != 0;
        int v7 = fi.a(u0, s, fi.b(s) == null);
        this.h = v7;
        if(v5 > 0 || h90.isEmpty() && v6 > 0 || this.c || this.d && v7 > 0) {
            z = true;
        }
        this.a = z;
    }

    public final int a(U2 u20) {
        b3 b30 = b3.b;
        b3 b31 = b3.c;
        u6 u60 = u6.a.c(this.b, u20.b).b(this.e, u20.e, b31).a(this.f, u20.f);
        int v = this.g;
        u6 u61 = u60.a(v, u20.g).c(this.c, u20.c);
        Boolean boolean0 = Boolean.valueOf(this.d);
        Boolean boolean1 = Boolean.valueOf(u20.d);
        if(this.f != 0) {
            b30 = b31;
        }
        u6 u62 = u61.b(boolean0, boolean1, b30).a(this.h, u20.h);
        if(v == 0) {
            u62 = u62.d(this.i, u20.i);
        }
        return u62.e();
    }

    @Override
    public final int compareTo(Object object0) {
        return this.a(((U2)object0));
    }
}

