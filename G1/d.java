package G1;

import F1.c;
import F1.e;
import F1.f;
import com.iloen.melon.utils.a;
import java.util.ArrayList;

public final class d extends p {
    public final ArrayList k;
    public int l;

    public d(e e0, int v) {
        super(e0);
        l l1;
        l l0;
        e e4;
        ArrayList arrayList0 = new ArrayList();
        this.k = arrayList0;
        this.f = v;
        e e1 = this.b;
        for(e e2 = e1.o(v); true; e2 = e1.o(this.f)) {
            e e3 = e1;
            e1 = e2;
            e4 = e3;
            if(e1 == null) {
                break;
            }
        }
        this.b = e4;
        int v1 = this.f;
        if(v1 == 0) {
            l0 = e4.d;
        }
        else if(v1 == 1) {
            l0 = e4.e;
        }
        else {
            l0 = null;
        }
        arrayList0.add(l0);
        for(e e5 = e4.n(this.f); e5 != null; e5 = e5.n(this.f)) {
            int v2 = this.f;
            if(v2 == 0) {
                l1 = e5.d;
            }
            else if(v2 == 1) {
                l1 = e5.e;
            }
            else {
                l1 = null;
            }
            arrayList0.add(l1);
        }
        for(Object object0: arrayList0) {
            p p0 = (p)object0;
            int v3 = this.f;
            if(v3 == 0) {
                p0.b.b = this;
            }
            else if(v3 == 1) {
                p0.b.c = this;
            }
        }
        if(this.f == 0 && ((f)this.b.W).A0 && arrayList0.size() > 1) {
            this.b = ((p)a.i(1, arrayList0)).b;
        }
        this.l = this.f == 0 ? this.b.m0 : this.b.n0;
    }

    @Override  // G1.e
    public final void a(G1.e e0) {
        int v34;
        int v30;
        int v27;
        int v24;
        int v23;
        int v22;
        boolean z1;
        int v13;
        int v12;
        int v14;
        int v9;
        int v8;
        int v7;
        float f;
        F1.d d0;
        int v3;
        g g0 = this.h;
        if(g0.j) {
            g g1 = this.i;
            if(g1.j) {
                e e1 = this.b.W;
                boolean z = e1 instanceof f ? ((f)e1).A0 : false;
                int v = g1.g - g0.g;
                ArrayList arrayList0 = this.k;
                int v1 = arrayList0.size();
                int v2;
                for(v2 = 0; true; ++v2) {
                    v3 = -1;
                    if(v2 >= v1) {
                        v2 = -1;
                        break;
                    }
                    if(((p)arrayList0.get(v2)).b.j0 != 8) {
                        break;
                    }
                }
                int v4 = v1 - 1;
                while(v4 >= 0) {
                    if(((p)arrayList0.get(v4)).b.j0 == 8) {
                        --v4;
                    }
                    else {
                        v3 = v4;
                        if(true) {
                            break;
                        }
                    }
                }
                int v5 = 0;
                while(true) {
                    d0 = F1.d.c;
                    if(v5 >= 2) {
                        goto label_79;
                    }
                    f = 0.0f;
                    int v6 = 0;
                    v7 = 0;
                    v8 = 0;
                    v9 = 0;
                    while(v6 < v1) {
                        p p0 = (p)arrayList0.get(v6);
                        e e2 = p0.b;
                        if(e2.j0 != 8) {
                            ++v9;
                            if(v6 > 0 && v6 >= v2) {
                                v7 += p0.h.f;
                            }
                            h h0 = p0.e;
                            int v10 = h0.g;
                            int v11 = p0.d == d0 ? 0 : 1;
                            if(v11 == 0) {
                                v12 = 0;
                                v13 = v7;
                                if(p0.a == 1 && v5 == 0) {
                                    v14 = h0.m;
                                    ++v8;
                                    v12 = 1;
                                    goto label_59;
                                }
                                else if(h0.j) {
                                    v14 = v10;
                                    v12 = 1;
                                    goto label_59;
                                }
                            }
                            else {
                                v12 = v11;
                                if(this.f == 0 && !e2.d.e.j || this.f == 1 && !e2.e.e.j) {
                                    return;
                                }
                                v13 = v7;
                            }
                            v14 = v10;
                        label_59:
                            if(v12 == 0) {
                                ++v8;
                                float f1 = e2.o0[this.f];
                                if(f1 >= 0.0f) {
                                    f += f1;
                                }
                                v7 = v13;
                            }
                            else {
                                v7 = v13 + v14;
                            }
                            if(v6 < v1 - 1 && v6 < v3) {
                                v7 -= p0.i.f;
                            }
                        }
                        ++v6;
                    }
                    z1 = z;
                    if(v7 < v || v8 == 0) {
                        break;
                    }
                    ++v5;
                    z = z1;
                }
                int v15 = v8;
                int v16 = v9;
                goto label_84;
            label_79:
                z1 = z;
                f = 0.0f;
                v15 = 0;
                v16 = 0;
                v7 = 0;
            label_84:
                int v17 = z1 ? g1.g : g0.g;
                if(v7 > v) {
                    v17 = z1 ? v17 + ((int)(((float)(v7 - v)) / 2.0f + 0.5f)) : v17 - ((int)(((float)(v7 - v)) / 2.0f + 0.5f));
                }
                if(v15 > 0) {
                    float f2 = (float)(v - v7);
                    int v18 = (int)(f2 / ((float)v15) + 0.5f);
                    int v20 = 0;
                    for(int v19 = 0; v19 < v1; v19 = v24 + 1) {
                        p p1 = (p)arrayList0.get(v19);
                        e e3 = p1.b;
                        h h1 = p1.e;
                        if(e3.j0 == 8 || (p1.d != d0 || h1.j)) {
                            v24 = v19;
                        }
                        else {
                            int v21 = f > 0.0f ? ((int)(e3.o0[this.f] * f2 / f + 0.5f)) : v18;
                            if(this.f == 0) {
                                v22 = e3.w;
                                v23 = e3.v;
                            }
                            else {
                                v22 = e3.z;
                                v23 = e3.y;
                            }
                            v24 = v19;
                            int v25 = p1.a == 1 ? Math.min(v21, h1.m) : v21;
                            int v26 = v22 <= 0 ? Math.max(v23, v25) : Math.min(v22, Math.max(v23, v25));
                            if(v26 != v21) {
                                ++v20;
                                v21 = v26;
                            }
                            h1.d(v21);
                        }
                    }
                    v27 = v17;
                    if(v20 > 0) {
                        v15 -= v20;
                        v7 = 0;
                        for(int v28 = 0; v28 < v1; ++v28) {
                            p p2 = (p)arrayList0.get(v28);
                            if(p2.b.j0 != 8) {
                                if(v28 > 0 && v28 >= v2) {
                                    v7 += p2.h.f;
                                }
                                v7 += p2.e.g;
                                if(v28 < v1 - 1 && v28 < v3) {
                                    v7 -= p2.i.f;
                                }
                            }
                        }
                    }
                    if(this.l == 2 && v20 == 0) {
                        this.l = 0;
                    }
                }
                else {
                    v27 = v17;
                }
                if(v7 > v) {
                    this.l = 2;
                }
                if(v16 > 0 && v15 == 0 && v2 == v3) {
                    this.l = 2;
                }
                int v29 = this.l;
                if(v29 == 1) {
                    if(v16 > 1) {
                        v30 = (v - v7) / (v16 - 1);
                    }
                    else {
                        v30 = v16 == 1 ? (v - v7) / 2 : 0;
                    }
                    if(v15 > 0) {
                        v30 = 0;
                    }
                    int v32 = v27;
                    for(int v31 = 0; v31 < v1; ++v31) {
                        p p3 = (p)arrayList0.get((z1 ? v1 - (v31 + 1) : v31));
                        g g2 = p3.i;
                        g g3 = p3.h;
                        if(p3.b.j0 == 8) {
                            g3.d(v32);
                            g2.d(v32);
                        }
                        else {
                            if(v31 > 0) {
                                v32 = z1 ? v32 - v30 : v32 + v30;
                            }
                            if(v31 > 0 && v31 >= v2) {
                                v32 = z1 ? v32 - g3.f : v32 + g3.f;
                            }
                            if(z1) {
                                g2.d(v32);
                            }
                            else {
                                g3.d(v32);
                            }
                            h h2 = p3.e;
                            int v33 = h2.g;
                            if(p3.d == d0) {
                                v34 = v32;
                                if(p3.a == 1) {
                                    v33 = h2.m;
                                }
                            }
                            else {
                                v34 = v32;
                            }
                            v32 = z1 ? v34 - v33 : v34 + v33;
                            if(z1) {
                                g3.d(v32);
                            }
                            else {
                                g2.d(v32);
                            }
                            p3.g = true;
                            if(v31 < v1 - 1 && v31 < v3) {
                                v32 = z1 ? v32 - -g2.f : v32 - g2.f;
                            }
                        }
                    }
                    return;
                }
                if(v29 == 0) {
                    int v35 = (v - v7) / (v16 + 1);
                    if(v15 > 0) {
                        v35 = 0;
                    }
                    int v37 = v27;
                    for(int v36 = 0; v36 < v1; ++v36) {
                        p p4 = (p)arrayList0.get((z1 ? v1 - (v36 + 1) : v36));
                        g g4 = p4.i;
                        g g5 = p4.h;
                        if(p4.b.j0 == 8) {
                            g5.d(v37);
                            g4.d(v37);
                        }
                        else {
                            int v38 = z1 ? v37 - v35 : v37 + v35;
                            if(v36 > 0 && v36 >= v2) {
                                v38 = z1 ? v38 - g5.f : v38 + g5.f;
                            }
                            if(z1) {
                                g4.d(v38);
                            }
                            else {
                                g5.d(v38);
                            }
                            int v39 = p4.d != d0 || p4.a != 1 ? p4.e.g : Math.min(p4.e.g, p4.e.m);
                            v37 = z1 ? v38 - v39 : v38 + v39;
                            if(z1) {
                                g5.d(v37);
                            }
                            else {
                                g4.d(v37);
                            }
                            if(v36 < v1 - 1 && v36 < v3) {
                                v37 = z1 ? v37 - -g4.f : v37 - g4.f;
                            }
                        }
                    }
                    return;
                }
                if(v29 == 2) {
                    float f3 = this.f == 0 ? this.b.g0 : this.b.h0;
                    if(z1) {
                        f3 = 1.0f - f3;
                    }
                    int v40 = ((int)(((float)(v - v7)) * f3 + 0.5f)) >= 0 && v15 <= 0 ? ((int)(((float)(v - v7)) * f3 + 0.5f)) : 0;
                    int v41 = z1 ? v27 - v40 : v27 + v40;
                    for(int v42 = 0; v42 < v1; ++v42) {
                        p p5 = (p)arrayList0.get((z1 ? v1 - (v42 + 1) : v42));
                        g g6 = p5.i;
                        g g7 = p5.h;
                        if(p5.b.j0 == 8) {
                            g7.d(v41);
                            g6.d(v41);
                        }
                        else {
                            if(v42 > 0 && v42 >= v2) {
                                v41 = z1 ? v41 - g7.f : v41 + g7.f;
                            }
                            if(z1) {
                                g6.d(v41);
                            }
                            else {
                                g7.d(v41);
                            }
                            int v43 = p5.d != d0 || p5.a != 1 ? p5.e.g : p5.e.m;
                            v41 = z1 ? v41 - v43 : v41 + v43;
                            if(z1) {
                                g7.d(v41);
                            }
                            else {
                                g6.d(v41);
                            }
                            if(v42 < v1 - 1 && v42 < v3) {
                                v41 = z1 ? v41 - -g6.f : v41 - g6.f;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override  // G1.p
    public final void d() {
        ArrayList arrayList0 = this.k;
        for(Object object0: arrayList0) {
            ((p)object0).d();
        }
        int v = arrayList0.size();
        if(v < 1) {
            return;
        }
        e e0 = ((p)arrayList0.get(0)).b;
        e e1 = ((p)arrayList0.get(v - 1)).b;
        g g0 = this.i;
        g g1 = this.h;
        if(this.f == 0) {
            c c0 = e1.M;
            g g2 = p.i(e0.K, 0);
            int v1 = e0.K.e();
            e e2 = this.m();
            if(e2 != null) {
                v1 = e2.K.e();
            }
            if(g2 != null) {
                p.b(g1, g2, v1);
            }
            g g3 = p.i(c0, 0);
            int v2 = c0.e();
            e e3 = this.n();
            if(e3 != null) {
                v2 = e3.M.e();
            }
            if(g3 != null) {
                p.b(g0, g3, -v2);
            }
        }
        else {
            c c1 = e1.N;
            g g4 = p.i(e0.L, 1);
            int v3 = e0.L.e();
            e e4 = this.m();
            if(e4 != null) {
                v3 = e4.L.e();
            }
            if(g4 != null) {
                p.b(g1, g4, v3);
            }
            g g5 = p.i(c1, 1);
            int v4 = c1.e();
            e e5 = this.n();
            if(e5 != null) {
                v4 = e5.N.e();
            }
            if(g5 != null) {
                p.b(g0, g5, -v4);
            }
        }
        g1.a = this;
        g0.a = this;
    }

    @Override  // G1.p
    public final void e() {
        for(int v = 0; true; ++v) {
            ArrayList arrayList0 = this.k;
            if(v >= arrayList0.size()) {
                break;
            }
            ((p)arrayList0.get(v)).e();
        }
    }

    @Override  // G1.p
    public final void f() {
        this.c = null;
        for(Object object0: this.k) {
            ((p)object0).f();
        }
    }

    @Override  // G1.p
    public final long j() {
        ArrayList arrayList0 = this.k;
        int v = arrayList0.size();
        long v1 = 0L;
        for(int v2 = 0; v2 < v; ++v2) {
            p p0 = (p)arrayList0.get(v2);
            long v3 = v1 + ((long)p0.h.f);
            long v4 = p0.j();
            v1 = ((long)p0.i.f) + (v4 + v3);
        }
        return v1;
    }

    @Override  // G1.p
    public final boolean k() {
        ArrayList arrayList0 = this.k;
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            if(!((p)arrayList0.get(v1)).k()) {
                return false;
            }
        }
        return true;
    }

    public final e m() {
        for(int v = 0; true; ++v) {
            ArrayList arrayList0 = this.k;
            if(v >= arrayList0.size()) {
                break;
            }
            e e0 = ((p)arrayList0.get(v)).b;
            if(e0.j0 != 8) {
                return e0;
            }
        }
        return null;
    }

    public final e n() {
        ArrayList arrayList0 = this.k;
        for(int v = arrayList0.size() - 1; v >= 0; --v) {
            e e0 = ((p)arrayList0.get(v)).b;
            if(e0.j0 != 8) {
                return e0;
            }
        }
        return null;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ChainRun ");
        stringBuilder0.append((this.f == 0 ? "horizontal : " : "vertical : "));
        for(Object object0: this.k) {
            stringBuilder0.append("<");
            stringBuilder0.append(((p)object0));
            stringBuilder0.append("> ");
        }
        return stringBuilder0.toString();
    }
}

