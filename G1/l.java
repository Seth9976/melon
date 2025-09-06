package G1;

import F1.c;
import F1.d;
import F1.j;
import e0.b;
import java.util.ArrayList;

public final class l extends p {
    public static final int[] k;

    static {
        l.k = new int[2];
    }

    @Override  // G1.e
    public final void a(e e0) {
        int v;
        if(b.b(this.j) != 3) {
            h h0 = this.e;
            d d0 = d.c;
            g g0 = this.h;
            g g1 = this.i;
            if(h0.j || this.d != d0) {
            label_98:
                if(g0.c && g1.c && (!g0.j || !g1.j || !h0.j)) {
                    if(!h0.j && this.d == d0 && (this.b.s == 0 && !this.b.z())) {
                        g g4 = (g)g0.l.get(0);
                        g g5 = (g)g1.l.get(0);
                        int v18 = g4.g + g0.f;
                        int v19 = g5.g + g1.f;
                        g0.d(v18);
                        g1.d(v19);
                        h0.d(v19 - v18);
                        return;
                    }
                    if(!h0.j && this.d == d0 && this.a == 1 && g0.l.size() > 0 && g1.l.size() > 0) {
                        g g6 = (g)g0.l.get(0);
                        int v20 = Math.min(((g)g1.l.get(0)).g + g1.f - (g6.g + g0.f), h0.m);
                        int v21 = this.b.w;
                        h0.d((v21 <= 0 ? Math.max(this.b.v, v20) : Math.min(v21, Math.max(this.b.v, v20))));
                    }
                    if(h0.j) {
                        g g7 = (g)g0.l.get(0);
                        g g8 = (g)g1.l.get(0);
                        int v22 = g7.g;
                        int v23 = g0.f + v22;
                        int v24 = g8.g;
                        int v25 = g1.f + v24;
                        float f3 = this.b.g0;
                        if(g7 == g8) {
                            f3 = 0.5f;
                        }
                        else {
                            v22 = v23;
                            v24 = v25;
                        }
                        g0.d(((int)(((float)(v24 - v22 - h0.g)) * f3 + (((float)v22) + 0.5f))));
                        g1.d(g0.g + h0.g);
                    }
                }
            }
            else {
                F1.e e1 = this.b;
                switch(e1.s) {
                    case 2: {
                        F1.e e2 = e1.W;
                        if(e2 != null) {
                            h h1 = e2.d.e;
                            if(h1.j) {
                                h0.d(((int)(((float)h1.g) * e1.x + 0.5f)));
                            }
                        }
                        goto label_98;
                    }
                    case 3: {
                        if(e1.t == 0 || e1.t == 3) {
                            g g2 = e1.e.h;
                            g g3 = e1.e.i;
                            boolean z = e1.K.f != null;
                            boolean z1 = e1.L.f != null;
                            boolean z2 = e1.M.f != null;
                            boolean z3 = e1.N.f != null;
                            int v1 = e1.a0;
                            if(z && z1 && z2 && z3) {
                                float f = e1.Z;
                                ArrayList arrayList0 = g2.l;
                                int[] arr_v = l.k;
                                if(g2.j && g3.j) {
                                    if(g0.c && g1.c) {
                                        l.m(arr_v, ((g)g0.l.get(0)).g + g0.f, ((g)g1.l.get(0)).g - g1.f, g2.g + g2.f, g3.g - g3.f, f, v1);
                                        h0.d(arr_v[0]);
                                        this.b.e.e.d(arr_v[1]);
                                        return;
                                    }
                                }
                                else if(!g0.j || !g1.j) {
                                label_48:
                                    if(g0.c && g1.c && g2.c && g3.c) {
                                        l.m(arr_v, ((g)g0.l.get(0)).g + g0.f, ((g)g1.l.get(0)).g - g1.f, ((g)arrayList0.get(0)).g + g2.f, ((g)g3.l.get(0)).g - g3.f, f, v1);
                                        h0.d(arr_v[0]);
                                        this.b.e.e.d(arr_v[1]);
                                        goto label_98;
                                    }
                                }
                                else if(g2.c && g3.c) {
                                    l.m(arr_v, g0.g + g0.f, g1.g - g1.f, ((g)arrayList0.get(0)).g + g2.f, ((g)g3.l.get(0)).g - g3.f, f, v1);
                                    h0.d(arr_v[0]);
                                    this.b.e.e.d(arr_v[1]);
                                    goto label_48;
                                }
                            }
                            else if(!z || !z2) {
                                if(!z1 || !z3) {
                                    goto label_98;
                                }
                                else if(g2.c && g3.c) {
                                    float f2 = e1.Z;
                                    int v10 = ((g)g2.l.get(0)).g + g2.f;
                                    int v11 = ((g)g3.l.get(0)).g - g3.f;
                                    switch(v1) {
                                        case 0: {
                                            int v15 = this.g(v11 - v10, 1);
                                            int v16 = (int)(((float)v15) * f2 + 0.5f);
                                            int v17 = this.g(v16, 0);
                                            if(v16 != v17) {
                                                v15 = (int)(((float)v17) / f2 + 0.5f);
                                            }
                                            h0.d(v17);
                                            this.b.e.e.d(v15);
                                            goto label_98;
                                        }
                                        case -1: 
                                        case 1: {
                                            int v12 = this.g(v11 - v10, 1);
                                            int v13 = (int)(((float)v12) / f2 + 0.5f);
                                            int v14 = this.g(v13, 0);
                                            if(v13 != v14) {
                                                v12 = (int)(((float)v14) * f2 + 0.5f);
                                            }
                                            h0.d(v14);
                                            this.b.e.e.d(v12);
                                            goto label_98;
                                        }
                                        default: {
                                            goto label_98;
                                        }
                                    }
                                }
                            }
                            else if(g0.c && g1.c) {
                                float f1 = e1.Z;
                                int v2 = ((g)g0.l.get(0)).g + g0.f;
                                int v3 = ((g)g1.l.get(0)).g - g1.f;
                                switch(v1) {
                                    case -1: 
                                    case 0: {
                                        int v4 = this.g(v3 - v2, 0);
                                        int v5 = (int)(((float)v4) * f1 + 0.5f);
                                        int v6 = this.g(v5, 1);
                                        if(v5 != v6) {
                                            v4 = (int)(((float)v6) / f1 + 0.5f);
                                        }
                                        h0.d(v4);
                                        this.b.e.e.d(v6);
                                        goto label_98;
                                    }
                                    case 1: {
                                        int v7 = this.g(v3 - v2, 0);
                                        int v8 = (int)(((float)v7) / f1 + 0.5f);
                                        int v9 = this.g(v8, 1);
                                        if(v8 != v9) {
                                            v7 = (int)(((float)v9) * f1 + 0.5f);
                                        }
                                        h0.d(v7);
                                        this.b.e.e.d(v9);
                                        goto label_98;
                                    }
                                    default: {
                                        goto label_98;
                                    }
                                }
                            }
                        }
                        else {
                            switch(e1.a0) {
                                case -1: {
                                    v = (int)(((float)e1.e.e.g) * e1.Z + 0.5f);
                                    break;
                                }
                                case 0: {
                                    v = (int)(((float)e1.e.e.g) / e1.Z + 0.5f);
                                    break;
                                }
                                case 1: {
                                    v = (int)(((float)e1.e.e.g) * e1.Z + 0.5f);
                                    break;
                                }
                                default: {
                                    v = 0;
                                }
                            }
                            h0.d(v);
                            goto label_98;
                        }
                        break;
                    }
                    default: {
                        goto label_98;
                    }
                }
            }
            return;
        }
        this.l(this.b.K, this.b.M, 0);
    }

    @Override  // G1.p
    public final void d() {
        F1.e e0 = this.b;
        h h0 = this.e;
        if(e0.a) {
            h0.d(e0.s());
        }
        d d0 = d.d;
        d d1 = d.c;
        d d2 = d.a;
        g g0 = this.i;
        g g1 = this.h;
        if(!h0.j) {
            F1.e e1 = this.b;
            d d3 = e1.V[0];
            this.d = d3;
            if(d3 != d1) {
                if(d3 == d0) {
                    F1.e e2 = e1.W;
                    if(e2 != null) {
                        d d4 = e2.V[0];
                        if(d4 == d2 || d4 == d0) {
                            int v = e2.s();
                            int v1 = this.b.K.e();
                            int v2 = this.b.M.e();
                            p.b(g1, e2.d.h, this.b.K.e());
                            p.b(g0, e2.d.i, -this.b.M.e());
                            h0.d(v - v1 - v2);
                            return;
                        }
                    }
                }
                if(d3 == d2) {
                    h0.d(e1.s());
                }
            }
        }
        else if(this.d == d0) {
            F1.e e3 = this.b;
            F1.e e4 = e3.W;
            if(e4 != null) {
                d d5 = e4.V[0];
                if(d5 == d2 || d5 == d0) {
                    p.b(g1, e4.d.h, e3.K.e());
                    p.b(g0, e4.d.i, -this.b.M.e());
                    return;
                }
            }
        }
        if(h0.j) {
            F1.e e5 = this.b;
            if(e5.a) {
                c[] arr_c = e5.S;
                c c0 = arr_c[0];
                c c1 = c0.f;
                if(c1 != null && arr_c[1].f != null) {
                    if(e5.z()) {
                        g1.f = this.b.S[0].e();
                        g0.f = -this.b.S[1].e();
                        return;
                    }
                    g g2 = p.h(this.b.S[0]);
                    if(g2 != null) {
                        p.b(g1, g2, this.b.S[0].e());
                    }
                    g g3 = p.h(this.b.S[1]);
                    if(g3 != null) {
                        p.b(g0, g3, -this.b.S[1].e());
                    }
                    g1.b = true;
                    g0.b = true;
                    return;
                }
                if(c1 == null) {
                    c c2 = arr_c[1];
                    if(c2.f != null) {
                        g g5 = p.h(c2);
                        if(g5 != null) {
                            p.b(g0, g5, -this.b.S[1].e());
                            p.b(g1, g0, -h0.g);
                        }
                    }
                    else if(!(e5 instanceof j) && e5.W != null && e5.k(7).f == null) {
                        p.b(g1, this.b.W.d.h, this.b.t());
                        p.b(g0, g1, h0.g);
                    }
                }
                else {
                    g g4 = p.h(c0);
                    if(g4 != null) {
                        p.b(g1, g4, this.b.S[0].e());
                        p.b(g0, g1, h0.g);
                    }
                }
            }
            else {
                goto label_75;
            }
        }
        else {
        label_75:
            if(this.d == d1) {
                F1.e e6 = this.b;
                switch(e6.s) {
                    case 2: {
                        F1.e e7 = e6.W;
                        if(e7 != null) {
                            h h1 = e7.e.e;
                            h0.l.add(h1);
                            h1.k.add(h0);
                            h0.b = true;
                            h0.k.add(g1);
                            h0.k.add(g0);
                        }
                        break;
                    }
                    case 3: {
                        if(e6.t == 3) {
                            g1.a = this;
                            g0.a = this;
                            e6.e.h.a = this;
                            e6.e.i.a = this;
                            h0.a = this;
                            if(e6.A()) {
                                h0.l.add(this.b.e.e);
                                this.b.e.e.k.add(h0);
                                this.b.e.e.a = this;
                                h0.l.add(this.b.e.h);
                                h0.l.add(this.b.e.i);
                                this.b.e.h.k.add(h0);
                                this.b.e.i.k.add(h0);
                            }
                            else if(this.b.z()) {
                                this.b.e.e.l.add(h0);
                                h0.k.add(this.b.e.e);
                            }
                            else {
                                this.b.e.e.l.add(h0);
                            }
                        }
                        else {
                            h h2 = e6.e.e;
                            h0.l.add(h2);
                            h2.k.add(h0);
                            this.b.e.h.k.add(h0);
                            this.b.e.i.k.add(h0);
                            h0.b = true;
                            h0.k.add(g1);
                            h0.k.add(g0);
                            g1.l.add(h0);
                            g0.l.add(h0);
                        }
                    }
                }
            }
            F1.e e8 = this.b;
            c[] arr_c1 = e8.S;
            c c3 = arr_c1[0];
            c c4 = c3.f;
            if(c4 != null && arr_c1[1].f != null) {
                if(e8.z()) {
                    g1.f = this.b.S[0].e();
                    g0.f = -this.b.S[1].e();
                    return;
                }
                g g6 = p.h(this.b.S[0]);
                g g7 = p.h(this.b.S[1]);
                if(g6 != null) {
                    g6.b(this);
                }
                if(g7 != null) {
                    g7.b(this);
                }
                this.j = 4;
                return;
            }
            if(c4 == null) {
                c c5 = arr_c1[1];
                if(c5.f != null) {
                    g g9 = p.h(c5);
                    if(g9 != null) {
                        p.b(g0, g9, -this.b.S[1].e());
                        this.c(g1, g0, -1, h0);
                    }
                }
                else if(!(e8 instanceof j)) {
                    F1.e e9 = e8.W;
                    if(e9 != null) {
                        p.b(g1, e9.d.h, e8.t());
                        this.c(g0, g1, 1, h0);
                    }
                }
            }
            else {
                g g8 = p.h(c3);
                if(g8 != null) {
                    p.b(g1, g8, this.b.S[0].e());
                    this.c(g0, g1, 1, h0);
                }
            }
        }
    }

    @Override  // G1.p
    public final void e() {
        g g0 = this.h;
        if(g0.j) {
            this.b.b0 = g0.g;
        }
    }

    @Override  // G1.p
    public final void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    @Override  // G1.p
    public final boolean k() {
        return this.d != d.c || this.b.s == 0;
    }

    public static void m(int[] arr_v, int v, int v1, int v2, int v3, float f, int v4) {
        int v5 = v1 - v;
        int v6 = v3 - v2;
        switch(v4) {
            case -1: {
                int v7 = (int)(((float)v6) * f + 0.5f);
                int v8 = (int)(((float)v5) / f + 0.5f);
                if(v7 <= v5) {
                    arr_v[0] = v7;
                    arr_v[1] = v6;
                    return;
                }
                if(v8 <= v6) {
                    arr_v[0] = v5;
                    arr_v[1] = v8;
                }
                return;
            }
            case 0: {
                arr_v[0] = (int)(((float)v6) * f + 0.5f);
                arr_v[1] = v6;
                return;
            }
            case 1: {
                arr_v[0] = v5;
                arr_v[1] = (int)(((float)v5) * f + 0.5f);
            }
        }
    }

    public final void n() {
        this.g = false;
        this.h.c();
        this.h.j = false;
        this.i.c();
        this.i.j = false;
        this.e.j = false;
    }

    @Override
    public final String toString() {
        return "HorizontalRun " + this.b.l0;
    }
}

