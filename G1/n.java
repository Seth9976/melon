package G1;

import F1.c;
import F1.d;
import F1.j;
import e0.b;

public final class n extends p {
    public g k;
    public a l;

    @Override  // G1.e
    public final void a(e e0) {
        int v;
        if(b.b(this.j) != 3) {
            h h0 = this.e;
            d d0 = d.c;
            if(h0.c && !h0.j && this.d == d0) {
                F1.e e1 = this.b;
                switch(e1.t) {
                    case 2: {
                        F1.e e2 = e1.W;
                        if(e2 != null) {
                            h h1 = e2.e.e;
                            if(h1.j) {
                                h0.d(((int)(((float)h1.g) * e1.A + 0.5f)));
                            }
                        }
                        break;
                    }
                    case 3: {
                        h h2 = e1.d.e;
                        if(h2.j) {
                            switch(e1.a0) {
                                case -1: {
                                    v = (int)(((float)h2.g) / e1.Z + 0.5f);
                                    break;
                                }
                                case 0: {
                                    v = (int)(((float)h2.g) * e1.Z + 0.5f);
                                    break;
                                }
                                case 1: {
                                    v = (int)(((float)h2.g) / e1.Z + 0.5f);
                                    break;
                                }
                                default: {
                                    v = 0;
                                }
                            }
                            h0.d(v);
                        }
                    }
                }
            }
            g g0 = this.h;
            if(g0.c) {
                g g1 = this.i;
                if(g1.c && (!g0.j || !g1.j || !h0.j)) {
                    if(!h0.j && this.d == d0 && (this.b.s == 0 && !this.b.A())) {
                        g g2 = (g)g0.l.get(0);
                        g g3 = (g)g1.l.get(0);
                        int v1 = g2.g + g0.f;
                        int v2 = g3.g + g1.f;
                        g0.d(v1);
                        g1.d(v2);
                        h0.d(v2 - v1);
                        return;
                    }
                    if(!h0.j && this.d == d0 && this.a == 1 && g0.l.size() > 0 && g1.l.size() > 0) {
                        g g4 = (g)g0.l.get(0);
                        int v3 = ((g)g1.l.get(0)).g + g1.f - (g4.g + g0.f);
                        int v4 = h0.m;
                        if(v3 < v4) {
                            h0.d(v3);
                        }
                        else {
                            h0.d(v4);
                        }
                    }
                    if(h0.j && g0.l.size() > 0 && g1.l.size() > 0) {
                        g g5 = (g)g0.l.get(0);
                        g g6 = (g)g1.l.get(0);
                        int v5 = g5.g;
                        int v6 = g0.f + v5;
                        int v7 = g6.g;
                        int v8 = g1.f + v7;
                        float f = this.b.h0;
                        if(g5 == g6) {
                            f = 0.5f;
                        }
                        else {
                            v5 = v6;
                            v7 = v8;
                        }
                        g0.d(((int)(((float)(v7 - v5 - h0.g)) * f + (((float)v5) + 0.5f))));
                        g1.d(g0.g + h0.g);
                    }
                }
            }
            return;
        }
        this.l(this.b.L, this.b.N, 1);
    }

    @Override  // G1.p
    public final void d() {
        g g0 = this.k;
        F1.e e0 = this.b;
        h h0 = this.e;
        if(e0.a) {
            h0.d(e0.m());
        }
        d d0 = d.d;
        d d1 = d.a;
        d d2 = d.c;
        g g1 = this.i;
        g g2 = this.h;
        if(!h0.j) {
            F1.e e1 = this.b;
            this.d = e1.V[1];
            if(e1.F) {
                this.l = new a(this);  // 初始化器: LG1/h;-><init>(LG1/p;)V
            }
            d d3 = this.d;
            if(d3 != d2) {
                if(d3 == d0) {
                    F1.e e2 = this.b.W;
                    if(e2 != null && e2.V[1] == d1) {
                        int v = e2.m();
                        int v1 = this.b.L.e();
                        int v2 = this.b.N.e();
                        p.b(g2, e2.e.h, this.b.L.e());
                        p.b(g1, e2.e.i, -this.b.N.e());
                        h0.d(v - v1 - v2);
                        return;
                    }
                }
                if(d3 == d1) {
                    h0.d(this.b.m());
                }
            }
        }
        else if(this.d == d0) {
            F1.e e3 = this.b;
            F1.e e4 = e3.W;
            if(e4 != null && e4.V[1] == d1) {
                p.b(g2, e4.e.h, e3.L.e());
                p.b(g1, e4.e.i, -this.b.N.e());
                return;
            }
        }
        boolean z = h0.j;
        if(z) {
            F1.e e5 = this.b;
            if(e5.a) {
                c[] arr_c = e5.S;
                c c0 = arr_c[2];
                c c1 = c0.f;
                if(c1 != null && arr_c[3].f != null) {
                    if(e5.A()) {
                        g2.f = this.b.S[2].e();
                        g1.f = -this.b.S[3].e();
                    }
                    else {
                        g g3 = p.h(this.b.S[2]);
                        if(g3 != null) {
                            p.b(g2, g3, this.b.S[2].e());
                        }
                        g g4 = p.h(this.b.S[3]);
                        if(g4 != null) {
                            p.b(g1, g4, -this.b.S[3].e());
                        }
                        g2.b = true;
                        g1.b = true;
                    }
                    F1.e e6 = this.b;
                    if(e6.F) {
                        p.b(g0, g2, e6.d0);
                    }
                }
                else if(c1 != null) {
                    g g5 = p.h(c0);
                    if(g5 != null) {
                        p.b(g2, g5, this.b.S[2].e());
                        p.b(g1, g2, h0.g);
                        F1.e e7 = this.b;
                        if(e7.F) {
                            p.b(g0, g2, e7.d0);
                        }
                    }
                }
                else {
                    c c2 = arr_c[3];
                    if(c2.f == null) {
                        c c3 = arr_c[4];
                        if(c3.f != null) {
                            g g7 = p.h(c3);
                            if(g7 != null) {
                                p.b(g0, g7, 0);
                                p.b(g2, g0, -this.b.d0);
                                p.b(g1, g2, h0.g);
                            }
                        }
                        else if(!(e5 instanceof j) && e5.W != null && e5.k(7).f == null) {
                            p.b(g2, this.b.W.e.h, this.b.u());
                            p.b(g1, g2, h0.g);
                            F1.e e9 = this.b;
                            if(e9.F) {
                                p.b(g0, g2, e9.d0);
                            }
                        }
                    }
                    else {
                        g g6 = p.h(c2);
                        if(g6 != null) {
                            p.b(g1, g6, -this.b.S[3].e());
                            p.b(g2, g1, -h0.g);
                        }
                        F1.e e8 = this.b;
                        if(e8.F) {
                            p.b(g0, g2, e8.d0);
                        }
                    }
                }
            }
            else {
                goto label_95;
            }
        }
        else {
        label_95:
            if(z || this.d != d2) {
                h0.b(this);
            }
            else {
                F1.e e10 = this.b;
                switch(e10.t) {
                    case 2: {
                        F1.e e11 = e10.W;
                        if(e11 != null) {
                            h h1 = e11.e.e;
                            h0.l.add(h1);
                            h1.k.add(h0);
                            h0.b = true;
                            h0.k.add(g2);
                            h0.k.add(g1);
                        }
                        break;
                    }
                    case 3: {
                        if(!e10.A()) {
                            F1.e e12 = this.b;
                            if(e12.s != 3) {
                                h h2 = e12.d.e;
                                h0.l.add(h2);
                                h2.k.add(h0);
                                h0.b = true;
                                h0.k.add(g2);
                                h0.k.add(g1);
                            }
                        }
                    }
                }
            }
            F1.e e13 = this.b;
            c[] arr_c1 = e13.S;
            c c4 = arr_c1[2];
            c c5 = c4.f;
            if(c5 != null && arr_c1[3].f != null) {
                if(e13.A()) {
                    g2.f = this.b.S[2].e();
                    g1.f = -this.b.S[3].e();
                }
                else {
                    g g8 = p.h(this.b.S[2]);
                    g g9 = p.h(this.b.S[3]);
                    if(g8 != null) {
                        g8.b(this);
                    }
                    if(g9 != null) {
                        g9.b(this);
                    }
                    this.j = 4;
                }
                if(this.b.F) {
                    this.c(g0, g2, 1, this.l);
                }
            }
            else if(c5 == null) {
                c c6 = arr_c1[3];
                if(c6.f == null) {
                    c c7 = arr_c1[4];
                    if(c7.f != null) {
                        g g12 = p.h(c7);
                        if(g12 != null) {
                            p.b(g0, g12, 0);
                            this.c(g2, g0, -1, this.l);
                            this.c(g1, g2, 1, h0);
                        }
                    }
                    else if(!(e13 instanceof j)) {
                        F1.e e15 = e13.W;
                        if(e15 != null) {
                            p.b(g2, e15.e.h, e13.u());
                            this.c(g1, g2, 1, h0);
                            if(this.b.F) {
                                this.c(g0, g2, 1, this.l);
                            }
                            if(this.d == d2) {
                                F1.e e16 = this.b;
                                if(e16.Z > 0.0f) {
                                    l l1 = e16.d;
                                    if(l1.d == d2) {
                                        l1.e.k.add(h0);
                                        h0.l.add(this.b.d.e);
                                        h0.a = this;
                                    }
                                }
                            }
                        }
                    }
                }
                else {
                    g g11 = p.h(c6);
                    if(g11 != null) {
                        p.b(g1, g11, -this.b.S[3].e());
                        this.c(g2, g1, -1, h0);
                        if(this.b.F) {
                            this.c(g0, g2, 1, this.l);
                        }
                    }
                }
            }
            else {
                g g10 = p.h(c4);
                if(g10 != null) {
                    p.b(g2, g10, this.b.S[2].e());
                    this.c(g1, g2, 1, h0);
                    if(this.b.F) {
                        this.c(g0, g2, 1, this.l);
                    }
                    if(this.d == d2) {
                        F1.e e14 = this.b;
                        if(e14.Z > 0.0f) {
                            l l0 = e14.d;
                            if(l0.d == d2) {
                                l0.e.k.add(h0);
                                h0.l.add(this.b.d.e);
                                h0.a = this;
                            }
                        }
                    }
                }
            }
            if(h0.l.size() == 0) {
                h0.c = true;
            }
        }
    }

    @Override  // G1.p
    public final void e() {
        g g0 = this.h;
        if(g0.j) {
            this.b.c0 = g0.g;
        }
    }

    @Override  // G1.p
    public final void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    @Override  // G1.p
    public final boolean k() {
        return this.d != d.c || this.b.t == 0;
    }

    public final void m() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        g g0 = this.k;
        g0.c();
        g0.j = false;
        this.e.j = false;
    }

    @Override
    public final String toString() {
        return "VerticalRun " + this.b.l0;
    }
}

