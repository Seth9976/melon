package G1;

import F1.c;
import F1.d;
import e0.b;

public abstract class p implements e {
    public int a;
    public F1.e b;
    public m c;
    public d d;
    public final h e;
    public int f;
    public boolean g;
    public final g h;
    public final g i;
    public int j;

    public p(F1.e e0) {
        this.e = new h(this);
        this.f = 0;
        this.g = false;
        this.h = new g(this);
        this.i = new g(this);
        this.j = 1;
        this.b = e0;
    }

    public static void b(g g0, g g1, int v) {
        g0.l.add(g1);
        g0.f = v;
        g1.k.add(g0);
    }

    public final void c(g g0, g g1, int v, h h0) {
        g0.l.add(g1);
        g0.l.add(this.e);
        g0.h = v;
        g0.i = h0;
        g1.k.add(g0);
        h0.k.add(g0);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int v, int v1) {
        if(v1 == 0) {
            int v2 = this.b.w;
            int v3 = v2 <= 0 ? Math.max(this.b.v, v) : Math.min(v2, v);
            return v3 == v ? v : v3;
        }
        int v4 = this.b.z;
        int v5 = v4 <= 0 ? Math.max(this.b.y, v) : Math.min(v4, v);
        return v5 == v ? v : v5;
    }

    public static g h(c c0) {
        c c1 = c0.f;
        if(c1 != null) {
            F1.e e0 = c1.d;
            switch(b.b(c1.e)) {
                case 1: {
                    return e0.d.h;
                }
                case 2: {
                    return e0.e.h;
                }
                case 3: {
                    return e0.d.i;
                }
                case 4: {
                    return e0.e.i;
                }
                case 5: {
                    return e0.e.k;
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    public static g i(c c0, int v) {
        c c1 = c0.f;
        if(c1 != null) {
            F1.e e0 = c1.d;
            l l0 = v == 0 ? e0.d : e0.e;
            switch(b.b(c1.e)) {
                case 1: 
                case 2: {
                    return l0.h;
                }
                case 3: 
                case 4: {
                    return l0.i;
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    // 去混淆评级： 低(20)
    public long j() {
        return this.e.j ? ((long)this.e.g) : 0L;
    }

    public abstract boolean k();

    public final void l(c c0, c c1, int v) {
        g g0 = p.h(c0);
        g g1 = p.h(c1);
        if(g0.j && g1.j) {
            int v1 = c0.e() + g0.g;
            int v2 = g1.g - c1.e();
            int v3 = v2 - v1;
            h h0 = this.e;
            if(!h0.j) {
                d d0 = d.c;
                if(this.d == d0) {
                    switch(this.a) {
                        case 0: {
                            h0.d(this.g(v3, v));
                            break;
                        }
                        case 1: {
                            h0.d(Math.min(this.g(h0.m, v), v3));
                            break;
                        }
                        case 2: {
                            F1.e e0 = this.b;
                            F1.e e1 = e0.W;
                            if(e1 != null) {
                                l l0 = v == 0 ? e1.d : e1.e;
                                h h1 = l0.e;
                                if(h1.j) {
                                    h0.d(this.g(((int)(((float)h1.g) * (v == 0 ? e0.x : e0.A) + 0.5f)), v));
                                }
                            }
                            break;
                        }
                        case 3: {
                            F1.e e2 = this.b;
                            l l1 = e2.d;
                            if(l1.d != d0 || l1.a != 3 || (e2.e.d != d0 || e2.e.a != 3)) {
                                if(v == 0) {
                                    l1 = e2.e;
                                }
                                h h2 = l1.e;
                                if(h2.j) {
                                    h0.d((v == 1 ? ((int)(((float)h2.g) / e2.Z + 0.5f)) : ((int)(e2.Z * ((float)h2.g) + 0.5f))));
                                }
                            }
                        }
                    }
                }
            }
            if(h0.j) {
                int v4 = h0.g;
                g g2 = this.i;
                g g3 = this.h;
                if(v4 == v3) {
                    g3.d(v1);
                    g2.d(v2);
                    return;
                }
                float f = v == 0 ? this.b.g0 : this.b.h0;
                if(g0 == g1) {
                    v1 = g0.g;
                    v2 = g1.g;
                    f = 0.5f;
                }
                g3.d(((int)(((float)(v2 - v1 - v4)) * f + (((float)v1) + 0.5f))));
                g2.d(g3.g + h0.g);
            }
        }
    }
}

