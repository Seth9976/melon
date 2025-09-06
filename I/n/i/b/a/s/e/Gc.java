package i.n.i.b.a.s.e;

import java.util.List;

public final class gc extends i {
    public final long b;
    public final long c;
    public final long d;
    public final int e;
    public final long f;
    public final long g;
    public final long h;
    public final p1 i;
    public final e j;
    public final c k;

    public gc(long v, long v1, long v2, int v3, long v4, long v5, long v6, p1 p10, e e0, c c0) {
        M7.J(p10.d == (c0 != null));
        this.b = v;
        this.c = v1;
        this.d = v2;
        this.e = v3;
        this.f = v4;
        this.g = v5;
        this.h = v6;
        this.i = p10;
        this.j = e0;
        this.k = c0;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int a() {
        return this.i.m.size();
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int d(Object object0) {
        if(!(object0 instanceof Integer)) {
            return -1;
        }
        int v = ((int)(((Integer)object0))) - this.e;
        return v < 0 || v >= this.a() ? -1 : v;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final g h(int v, g g0, boolean z) {
        M7.z(v, this.a());
        Integer integer0 = null;
        p1 p10 = this.i;
        String s = z ? p10.a(v).a : null;
        if(z) {
            integer0 = (int)(this.e + v);
        }
        long v1 = p10.d(v);
        g4 g40 = p10.a(v);
        g4 g41 = p10.a(0);
        g0.getClass();
        g0.a = s;
        g0.b = integer0;
        g0.c = 0;
        g0.d = v1;
        g0.e = b4.a(g40.b - g41.b) - this.f;
        g0.g = Ud.e;
        g0.f = false;
        return g0;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final h j(int v, h h0, long v1) {
        long v6;
        M7.z(v, 1);
        p1 p10 = this.i;
        long v2 = p10.b;
        long v3 = p10.e;
        int v4 = 0;
        long v5 = this.h;
        if(!p10.d || v3 == 0x8000000000000001L || v2 != 0x8000000000000001L) {
            v6 = v5;
        }
        else if(v1 > 0L) {
            v5 += v1;
            if(v5 > this.g) {
                v6 = 0x8000000000000001L;
                goto label_36;
            }
            goto label_12;
        }
        else {
        label_12:
            long v7 = this.f + v5;
            long v8 = p10.d(0);
            int v9 = 0;
            while(v9 < p10.m.size() - 1 && v7 >= v8) {
                v7 -= v8;
                ++v9;
                v8 = p10.d(v9);
            }
            g4 g40 = p10.a(v9);
            List list0 = g40.c;
            int v10 = list0.size();
            while(true) {
                if(v4 >= v10) {
                    v4 = -1;
                    break;
                }
                if(((x0)list0.get(v4)).b == 2) {
                    break;
                }
                ++v4;
            }
            if(v4 != -1) {
                Wc wc0 = ((z5)((x0)g40.c.get(v4)).c.get(0)).f();
                if(wc0 != null && wc0.b(v8) != 0L) {
                    v5 = wc0.a(wc0.d(v7, v8)) + v5 - v7;
                }
            }
            v6 = v5;
        }
    label_36:
        int v11 = this.a();
        h0.a(this.j, p10, this.b, this.c, this.d, true, p10.d && v3 != 0x8000000000000001L && v2 == 0x8000000000000001L, this.k, v6, this.g, v11 - 1, this.f);
        return h0;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final int l() {
        return 1;
    }

    @Override  // i.n.i.b.a.s.e.i
    public final Object o(int v) {
        M7.z(v, this.a());
        return (int)(this.e + v);
    }
}

