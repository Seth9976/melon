package lf;

import A3.g;
import i.n.i.b.a.s.e.qb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rf.c;
import rf.d;
import rf.f;
import rf.j;
import rf.p;

public final class k extends j {
    public List B;
    public List D;
    public List E;
    public List G;
    public int I;
    public int M;
    public T N;
    public int S;
    public List T;
    public int V;
    public List W;
    public List X;
    public int Y;
    public List Z;
    public final d b;
    public Z b0;
    public int c;
    public List c0;
    public int d;
    public g0 d0;
    public int e;
    public List e0;
    public int f;
    public byte f0;
    public List g;
    public int g0;
    public List h;
    public static final k h0;
    public List i;
    public static final a i0;
    public int j;
    public List k;
    public int l;
    public List m;
    public List n;
    public int o;
    public List r;
    public List w;

    static {
        k.i0 = new a(3);
        k k0 = new k();
        k.h0 = k0;
        k0.n();
    }

    public k() {
        this.j = -1;
        this.l = -1;
        this.o = -1;
        this.I = -1;
        this.V = -1;
        this.Y = -1;
        this.f0 = -1;
        this.g0 = -1;
        this.b = d.a;
    }

    public k(qb qb0, f f0) {
        this.j = -1;
        this.l = -1;
        this.o = -1;
        this.I = -1;
        this.V = -1;
        this.Y = -1;
        this.f0 = -1;
        this.g0 = -1;
        this.n();
        c c0 = d.k();
        g g0 = g.w(c0, 1);
        int v = 0;
        boolean z = false;
        while(!z) {
            try {
                try {
                    int v1 = qb0.q();
                    S s0 = null;
                    switch(v1) {
                        case 0: {
                        label_19:
                            z = true;
                            continue;
                        }
                        case 8: {
                            this.c |= 1;
                            this.d = qb0.i();
                            continue;
                        }
                        case 16: {
                            if((v & 0x20) != 0x20) {
                                this.i = new ArrayList();
                                v |= 0x20;
                            }
                            this.i.add(qb0.i());
                            continue;
                        }
                        case 18: {
                            int v2 = qb0.g(qb0.n());
                            if((v & 0x20) != 0x20 && qb0.e() > 0) {
                                this.i = new ArrayList();
                                v |= 0x20;
                            }
                            while(qb0.e() > 0) {
                                this.i.add(qb0.i());
                            }
                            qb0.f(v2);
                            continue;
                        }
                        case 24: {
                            this.c |= 2;
                            this.e = qb0.i();
                            continue;
                        }
                        case 0x20: {
                            this.c |= 4;
                            this.f = qb0.i();
                            continue;
                        }
                        case 42: {
                            if((v & 8) != 8) {
                                this.g = new ArrayList();
                                v |= 8;
                            }
                            this.g.add(qb0.j(Y.n, f0));
                            continue;
                        }
                        case 50: {
                            if((v & 16) != 16) {
                                this.h = new ArrayList();
                                v |= 16;
                            }
                            this.h.add(qb0.j(T.G, f0));
                            continue;
                        }
                        case 56: {
                            if((v & 0x40) != 0x40) {
                                this.k = new ArrayList();
                                v |= 0x40;
                            }
                            this.k.add(qb0.i());
                            continue;
                        }
                        case 58: {
                            int v3 = qb0.g(qb0.n());
                            if((v & 0x40) != 0x40 && qb0.e() > 0) {
                                this.k = new ArrayList();
                                v |= 0x40;
                            }
                            while(qb0.e() > 0) {
                                this.k.add(qb0.i());
                            }
                            qb0.f(v3);
                            continue;
                        }
                        case 66: {
                            if((v & 0x200) != 0x200) {
                                this.r = new ArrayList();
                                v |= 0x200;
                            }
                            this.r.add(qb0.j(n.l, f0));
                            continue;
                        }
                        case 74: {
                            if((v & 0x400) != 0x400) {
                                this.w = new ArrayList();
                                v |= 0x400;
                            }
                            this.w.add(qb0.j(A.T, f0));
                            continue;
                        }
                        case 82: {
                            if((v & 0x800) != 0x800) {
                                this.B = new ArrayList();
                                v |= 0x800;
                            }
                            this.B.add(qb0.j(I.Y, f0));
                            continue;
                        }
                        case 90: {
                            if((v & 0x1000) != 0x1000) {
                                this.D = new ArrayList();
                                v |= 0x1000;
                            }
                            this.D.add(qb0.j(V.w, f0));
                            continue;
                        }
                        case 106: {
                            if((v & 0x2000) != 0x2000) {
                                this.E = new ArrayList();
                                v |= 0x2000;
                            }
                            this.E.add(qb0.j(v.i, f0));
                            continue;
                        }
                        case 0x80: {
                            if((v & 0x4000) != 0x4000) {
                                this.G = new ArrayList();
                                v |= 0x4000;
                            }
                            this.G.add(qb0.i());
                            continue;
                        }
                        case 130: {
                            int v4 = qb0.g(qb0.n());
                            if((v & 0x4000) != 0x4000 && qb0.e() > 0) {
                                this.G = new ArrayList();
                                v |= 0x4000;
                            }
                            while(qb0.e() > 0) {
                                this.G.add(qb0.i());
                            }
                            qb0.f(v4);
                            continue;
                        }
                        case 0x88: {
                            this.c |= 8;
                            this.M = qb0.i();
                            continue;
                        }
                        case 0x92: {
                            if((this.c & 16) == 16) {
                                s0 = this.N.q();
                            }
                            T t0 = (T)qb0.j(T.G, f0);
                            this.N = t0;
                            if(s0 != null) {
                                s0.g(t0);
                                this.N = s0.e();
                            }
                            this.c |= 16;
                            continue;
                        }
                        case 0x98: {
                            this.c |= 0x20;
                            this.S = qb0.i();
                            continue;
                        }
                        case 0xA2: {
                            if((v & 0x80) != 0x80) {
                                this.m = new ArrayList();
                                v |= 0x80;
                            }
                            this.m.add(qb0.j(T.G, f0));
                            continue;
                        }
                        case 0xA8: {
                            if((v & 0x100) != 0x100) {
                                this.n = new ArrayList();
                                v |= 0x100;
                            }
                            this.n.add(qb0.i());
                            continue;
                        }
                        case 170: {
                            int v5 = qb0.g(qb0.n());
                            if((v & 0x100) != 0x100 && qb0.e() > 0) {
                                this.n = new ArrayList();
                                v |= 0x100;
                            }
                            while(qb0.e() > 0) {
                                this.n.add(qb0.i());
                            }
                            qb0.f(v5);
                            continue;
                        }
                        case 0xB0: {
                            if((v & 0x40000) != 0x40000) {
                                this.T = new ArrayList();
                                v |= 0x40000;
                            }
                            this.T.add(qb0.i());
                            continue;
                        }
                        case 0xB2: {
                            int v6 = qb0.g(qb0.n());
                            if((v & 0x40000) != 0x40000 && qb0.e() > 0) {
                                this.T = new ArrayList();
                                v |= 0x40000;
                            }
                            while(qb0.e() > 0) {
                                this.T.add(qb0.i());
                            }
                            qb0.f(v6);
                            continue;
                        }
                        case 0xBA: {
                            if((v & 0x80000) != 0x80000) {
                                this.W = new ArrayList();
                                v |= 0x80000;
                            }
                            this.W.add(qb0.j(T.G, f0));
                            continue;
                        }
                        case 0xC0: {
                            if((v & 0x100000) != 0x100000) {
                                this.X = new ArrayList();
                                v |= 0x100000;
                            }
                            this.X.add(qb0.i());
                            continue;
                        }
                        case 0xC2: {
                            int v7 = qb0.g(qb0.n());
                            if((v & 0x100000) != 0x100000 && qb0.e() > 0) {
                                this.X = new ArrayList();
                                v |= 0x100000;
                            }
                            while(qb0.e() > 0) {
                                this.X.add(qb0.i());
                            }
                            qb0.f(v7);
                            continue;
                        }
                        case 202: {
                            if((v & 0x200000) != 0x200000) {
                                this.Z = new ArrayList();
                                v |= 0x200000;
                            }
                            this.Z.add(qb0.j(h.h, f0));
                            continue;
                        }
                        case 0xF2: {
                            if((this.c & 0x40) == 0x40) {
                                Z z1 = this.b0;
                                z1.getClass();
                                s0 = Z.g(z1);
                            }
                            Z z2 = (Z)qb0.j(Z.h, f0);
                            this.b0 = z2;
                            if(s0 != null) {
                                ((lf.g)s0).h(z2);
                                this.b0 = ((lf.g)s0).e();
                            }
                            this.c |= 0x40;
                            continue;
                        }
                        case 0xF8: {
                            if((v & 0x800000) != 0x800000) {
                                this.c0 = new ArrayList();
                                v |= 0x800000;
                            }
                            this.c0.add(qb0.i());
                            continue;
                        }
                        case 0xFA: {
                            int v8 = qb0.g(qb0.n());
                            if((v & 0x800000) != 0x800000 && qb0.e() > 0) {
                                this.c0 = new ArrayList();
                                v |= 0x800000;
                            }
                            while(qb0.e() > 0) {
                                this.c0.add(qb0.i());
                            }
                            qb0.f(v8);
                            continue;
                        }
                        case 0x102: {
                            if((this.c & 0x80) == 0x80) {
                                s0 = this.d0.g();
                            }
                            g0 g00 = (g0)qb0.j(g0.f, f0);
                            this.d0 = g00;
                            if(s0 != null) {
                                ((o)s0).k(g00);
                                this.d0 = ((o)s0).g();
                            }
                            this.c |= 0x80;
                            continue;
                        }
                        case 0x10A: {
                            if((v & 0x2000000) != 0x2000000) {
                                this.e0 = new ArrayList();
                                v |= 0x2000000;
                            }
                            break;
                        }
                        default: {
                            if(!this.l(qb0, g0, f0, v1)) {
                                goto label_19;
                            }
                            continue;
                        }
                    }
                    this.e0.add(qb0.j(l.h, f0));
                    continue;
                }
                catch(p p0) {
                }
                catch(IOException iOException0) {
                    goto label_225;
                }
                p0.a(this);
                throw p0;
            label_225:
                p p1 = new p(iOException0.getMessage());
                p1.a(this);
                throw p1;
            }
            catch(Throwable throwable0) {
            }
            if((v & 0x20) == 0x20) {
                this.i = Collections.unmodifiableList(this.i);
            }
            if((v & 8) == 8) {
                this.g = Collections.unmodifiableList(this.g);
            }
            if((v & 16) == 16) {
                this.h = Collections.unmodifiableList(this.h);
            }
            if((v & 0x40) == 0x40) {
                this.k = Collections.unmodifiableList(this.k);
            }
            if((v & 0x200) == 0x200) {
                this.r = Collections.unmodifiableList(this.r);
            }
            if((v & 0x400) == 0x400) {
                this.w = Collections.unmodifiableList(this.w);
            }
            if((v & 0x800) == 0x800) {
                this.B = Collections.unmodifiableList(this.B);
            }
            if((v & 0x1000) == 0x1000) {
                this.D = Collections.unmodifiableList(this.D);
            }
            if((v & 0x2000) == 0x2000) {
                this.E = Collections.unmodifiableList(this.E);
            }
            if((v & 0x4000) == 0x4000) {
                this.G = Collections.unmodifiableList(this.G);
            }
            if((v & 0x80) == 0x80) {
                this.m = Collections.unmodifiableList(this.m);
            }
            if((v & 0x100) == 0x100) {
                this.n = Collections.unmodifiableList(this.n);
            }
            if((v & 0x40000) == 0x40000) {
                this.T = Collections.unmodifiableList(this.T);
            }
            if((v & 0x80000) == 0x80000) {
                this.W = Collections.unmodifiableList(this.W);
            }
            if((v & 0x100000) == 0x100000) {
                this.X = Collections.unmodifiableList(this.X);
            }
            if((v & 0x200000) == 0x200000) {
                this.Z = Collections.unmodifiableList(this.Z);
            }
            if((v & 0x800000) == 0x800000) {
                this.c0 = Collections.unmodifiableList(this.c0);
            }
            if((v & 0x2000000) == 0x2000000) {
                this.e0 = Collections.unmodifiableList(this.e0);
            }
            try {
                g0.k();
                goto label_269;
            }
            catch(IOException unused_ex) {
                goto label_269;
            }
            catch(Throwable throwable1) {
            }
            this.b = c0.m();
            throw throwable1;
        label_269:
            this.b = c0.m();
            this.k();
            throw throwable0;
        }
        if((v & 0x20) == 0x20) {
            this.i = Collections.unmodifiableList(this.i);
        }
        if((v & 8) == 8) {
            this.g = Collections.unmodifiableList(this.g);
        }
        if((v & 16) == 16) {
            this.h = Collections.unmodifiableList(this.h);
        }
        if((v & 0x40) == 0x40) {
            this.k = Collections.unmodifiableList(this.k);
        }
        if((v & 0x200) == 0x200) {
            this.r = Collections.unmodifiableList(this.r);
        }
        if((v & 0x400) == 0x400) {
            this.w = Collections.unmodifiableList(this.w);
        }
        if((v & 0x800) == 0x800) {
            this.B = Collections.unmodifiableList(this.B);
        }
        if((v & 0x1000) == 0x1000) {
            this.D = Collections.unmodifiableList(this.D);
        }
        if((v & 0x2000) == 0x2000) {
            this.E = Collections.unmodifiableList(this.E);
        }
        if((v & 0x4000) == 0x4000) {
            this.G = Collections.unmodifiableList(this.G);
        }
        if((v & 0x80) == 0x80) {
            this.m = Collections.unmodifiableList(this.m);
        }
        if((v & 0x100) == 0x100) {
            this.n = Collections.unmodifiableList(this.n);
        }
        if((v & 0x40000) == 0x40000) {
            this.T = Collections.unmodifiableList(this.T);
        }
        if((v & 0x80000) == 0x80000) {
            this.W = Collections.unmodifiableList(this.W);
        }
        if((v & 0x100000) == 0x100000) {
            this.X = Collections.unmodifiableList(this.X);
        }
        if((v & 0x200000) == 0x200000) {
            this.Z = Collections.unmodifiableList(this.Z);
        }
        if((v & 0x800000) == 0x800000) {
            this.c0 = Collections.unmodifiableList(this.c0);
        }
        if((v & 0x2000000) == 0x2000000) {
            this.e0 = Collections.unmodifiableList(this.e0);
        }
        try {
            g0.k();
            goto label_313;
        }
        catch(IOException unused_ex) {
            goto label_313;
        }
        catch(Throwable throwable2) {
        }
        this.b = c0.m();
        throw throwable2;
    label_313:
        this.b = c0.m();
        this.k();
    }

    public k(i i0) {
        super(i0);
        this.j = -1;
        this.l = -1;
        this.o = -1;
        this.I = -1;
        this.V = -1;
        this.Y = -1;
        this.f0 = -1;
        this.g0 = -1;
        this.b = i0.a;
    }

    @Override  // rf.a
    public final int a() {
        int v1 = this.g0;
        if(v1 != -1) {
            return v1;
        }
        int v2 = (this.c & 1) == 1 ? g.d(1, this.d) : 0;
        int v4 = 0;
        for(int v3 = 0; v3 < this.i.size(); ++v3) {
            v4 += g.e(((int)(((Integer)this.i.get(v3)))));
        }
        int v5 = this.i.isEmpty() ? v2 + v4 : v2 + v4 + 1 + g.e(v4);
        this.j = v4;
        if((this.c & 2) == 2) {
            v5 += g.d(3, this.e);
        }
        if((this.c & 4) == 4) {
            v5 += g.d(4, this.f);
        }
        for(int v6 = 0; v6 < this.g.size(); ++v6) {
            v5 += g.f(5, ((rf.a)this.g.get(v6)));
        }
        for(int v7 = 0; v7 < this.h.size(); ++v7) {
            v5 += g.f(6, ((rf.a)this.h.get(v7)));
        }
        int v9 = 0;
        for(int v8 = 0; v8 < this.k.size(); ++v8) {
            v9 += g.e(((int)(((Integer)this.k.get(v8)))));
        }
        int v10 = this.k.isEmpty() ? v5 + v9 : v5 + v9 + 1 + g.e(v9);
        this.l = v9;
        for(int v11 = 0; v11 < this.r.size(); ++v11) {
            v10 += g.f(8, ((rf.a)this.r.get(v11)));
        }
        for(int v12 = 0; v12 < this.w.size(); ++v12) {
            v10 += g.f(9, ((rf.a)this.w.get(v12)));
        }
        for(int v13 = 0; v13 < this.B.size(); ++v13) {
            v10 += g.f(10, ((rf.a)this.B.get(v13)));
        }
        for(int v14 = 0; v14 < this.D.size(); ++v14) {
            v10 += g.f(11, ((rf.a)this.D.get(v14)));
        }
        for(int v15 = 0; v15 < this.E.size(); ++v15) {
            v10 += g.f(13, ((rf.a)this.E.get(v15)));
        }
        int v17 = 0;
        for(int v16 = 0; v16 < this.G.size(); ++v16) {
            v17 += g.e(((int)(((Integer)this.G.get(v16)))));
        }
        int v18 = this.G.isEmpty() ? v10 + v17 : v10 + v17 + 2 + g.e(v17);
        this.I = v17;
        if((this.c & 8) == 8) {
            v18 += g.d(17, this.M);
        }
        if((this.c & 16) == 16) {
            v18 += g.f(18, this.N);
        }
        if((this.c & 0x20) == 0x20) {
            v18 += g.d(19, this.S);
        }
        for(int v19 = 0; v19 < this.m.size(); ++v19) {
            v18 += g.f(20, ((rf.a)this.m.get(v19)));
        }
        int v21 = 0;
        for(int v20 = 0; v20 < this.n.size(); ++v20) {
            v21 += g.e(((int)(((Integer)this.n.get(v20)))));
        }
        int v22 = this.n.isEmpty() ? v18 + v21 : v18 + v21 + 2 + g.e(v21);
        this.o = v21;
        int v24 = 0;
        for(int v23 = 0; v23 < this.T.size(); ++v23) {
            v24 += g.e(((int)(((Integer)this.T.get(v23)))));
        }
        int v25 = this.T.isEmpty() ? v22 + v24 : v22 + v24 + 2 + g.e(v24);
        this.V = v24;
        for(int v26 = 0; v26 < this.W.size(); ++v26) {
            v25 += g.f(23, ((rf.a)this.W.get(v26)));
        }
        int v28 = 0;
        for(int v27 = 0; v27 < this.X.size(); ++v27) {
            v28 += g.e(((int)(((Integer)this.X.get(v27)))));
        }
        int v29 = this.X.isEmpty() ? v25 + v28 : v25 + v28 + 2 + g.e(v28);
        this.Y = v28;
        for(int v30 = 0; v30 < this.Z.size(); ++v30) {
            v29 += g.f(25, ((rf.a)this.Z.get(v30)));
        }
        if((this.c & 0x40) == 0x40) {
            v29 += g.f(30, this.b0);
        }
        int v32 = 0;
        for(int v31 = 0; v31 < this.c0.size(); ++v31) {
            v32 += g.e(((int)(((Integer)this.c0.get(v31)))));
        }
        int v33 = this.c0.size() * 2 + (v29 + v32);
        if((this.c & 0x80) == 0x80) {
            v33 += g.f(0x20, this.d0);
        }
        for(int v = 0; v < this.e0.size(); ++v) {
            v33 += g.f(33, ((rf.a)this.e0.get(v)));
        }
        int v34 = this.h();
        int v35 = this.b.size() + (v34 + v33);
        this.g0 = v35;
        return v35;
    }

    @Override  // rf.a
    public final rf.h b() {
        return i.f();
    }

    @Override  // rf.a
    public final rf.h c() {
        rf.h h0 = i.f();
        ((i)h0).g(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        d5.v v0 = new d5.v(this);
        if((this.c & 1) == 1) {
            g0.D(1, this.d);
        }
        if(this.i.size() > 0) {
            g0.M(18);
            g0.M(this.j);
        }
        for(int v2 = 0; v2 < this.i.size(); ++v2) {
            g0.E(((int)(((Integer)this.i.get(v2)))));
        }
        if((this.c & 2) == 2) {
            g0.D(3, this.e);
        }
        if((this.c & 4) == 4) {
            g0.D(4, this.f);
        }
        for(int v3 = 0; v3 < this.g.size(); ++v3) {
            g0.F(5, ((rf.a)this.g.get(v3)));
        }
        for(int v4 = 0; v4 < this.h.size(); ++v4) {
            g0.F(6, ((rf.a)this.h.get(v4)));
        }
        if(this.k.size() > 0) {
            g0.M(58);
            g0.M(this.l);
        }
        for(int v5 = 0; v5 < this.k.size(); ++v5) {
            g0.E(((int)(((Integer)this.k.get(v5)))));
        }
        for(int v6 = 0; v6 < this.r.size(); ++v6) {
            g0.F(8, ((rf.a)this.r.get(v6)));
        }
        for(int v7 = 0; v7 < this.w.size(); ++v7) {
            g0.F(9, ((rf.a)this.w.get(v7)));
        }
        for(int v8 = 0; v8 < this.B.size(); ++v8) {
            g0.F(10, ((rf.a)this.B.get(v8)));
        }
        for(int v9 = 0; v9 < this.D.size(); ++v9) {
            g0.F(11, ((rf.a)this.D.get(v9)));
        }
        for(int v10 = 0; v10 < this.E.size(); ++v10) {
            g0.F(13, ((rf.a)this.E.get(v10)));
        }
        if(this.G.size() > 0) {
            g0.M(130);
            g0.M(this.I);
        }
        for(int v11 = 0; v11 < this.G.size(); ++v11) {
            g0.E(((int)(((Integer)this.G.get(v11)))));
        }
        if((this.c & 8) == 8) {
            g0.D(17, this.M);
        }
        if((this.c & 16) == 16) {
            g0.F(18, this.N);
        }
        if((this.c & 0x20) == 0x20) {
            g0.D(19, this.S);
        }
        for(int v12 = 0; v12 < this.m.size(); ++v12) {
            g0.F(20, ((rf.a)this.m.get(v12)));
        }
        if(this.n.size() > 0) {
            g0.M(170);
            g0.M(this.o);
        }
        for(int v13 = 0; v13 < this.n.size(); ++v13) {
            g0.E(((int)(((Integer)this.n.get(v13)))));
        }
        if(this.T.size() > 0) {
            g0.M(0xB2);
            g0.M(this.V);
        }
        for(int v14 = 0; v14 < this.T.size(); ++v14) {
            g0.E(((int)(((Integer)this.T.get(v14)))));
        }
        for(int v15 = 0; v15 < this.W.size(); ++v15) {
            g0.F(23, ((rf.a)this.W.get(v15)));
        }
        if(this.X.size() > 0) {
            g0.M(0xC2);
            g0.M(this.Y);
        }
        for(int v16 = 0; v16 < this.X.size(); ++v16) {
            g0.E(((int)(((Integer)this.X.get(v16)))));
        }
        for(int v17 = 0; v17 < this.Z.size(); ++v17) {
            g0.F(25, ((rf.a)this.Z.get(v17)));
        }
        if((this.c & 0x40) == 0x40) {
            g0.F(30, this.b0);
        }
        for(int v18 = 0; v18 < this.c0.size(); ++v18) {
            g0.D(0x1F, ((int)(((Integer)this.c0.get(v18)))));
        }
        if((this.c & 0x80) == 0x80) {
            g0.F(0x20, this.d0);
        }
        for(int v1 = 0; v1 < this.e0.size(); ++v1) {
            g0.F(33, ((rf.a)this.e0.get(v1)));
        }
        v0.V(19000, g0);
        g0.I(this.b);
    }

    @Override  // rf.t
    public final rf.a getDefaultInstanceForType() {
        return k.h0;
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        int v = this.f0;
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        if((this.c & 2) == 2) {
            for(int v1 = 0; v1 < this.g.size(); ++v1) {
                if(!((Y)this.g.get(v1)).isInitialized()) {
                    this.f0 = 0;
                    return false;
                }
            }
            for(int v2 = 0; v2 < this.h.size(); ++v2) {
                if(!((T)this.h.get(v2)).isInitialized()) {
                    this.f0 = 0;
                    return false;
                }
            }
            for(int v3 = 0; v3 < this.m.size(); ++v3) {
                if(!((T)this.m.get(v3)).isInitialized()) {
                    this.f0 = 0;
                    return false;
                }
            }
            for(int v4 = 0; v4 < this.r.size(); ++v4) {
                if(!((n)this.r.get(v4)).isInitialized()) {
                    this.f0 = 0;
                    return false;
                }
            }
            for(int v5 = 0; v5 < this.w.size(); ++v5) {
                if(!((A)this.w.get(v5)).isInitialized()) {
                    this.f0 = 0;
                    return false;
                }
            }
            for(int v6 = 0; v6 < this.B.size(); ++v6) {
                if(!((I)this.B.get(v6)).isInitialized()) {
                    this.f0 = 0;
                    return false;
                }
            }
            for(int v7 = 0; v7 < this.D.size(); ++v7) {
                if(!((V)this.D.get(v7)).isInitialized()) {
                    this.f0 = 0;
                    return false;
                }
            }
            for(int v8 = 0; v8 < this.E.size(); ++v8) {
                if(!((v)this.E.get(v8)).isInitialized()) {
                    this.f0 = 0;
                    return false;
                }
            }
            if((this.c & 16) == 16 && !this.N.isInitialized()) {
                this.f0 = 0;
                return false;
            }
            for(int v9 = 0; v9 < this.W.size(); ++v9) {
                if(!((T)this.W.get(v9)).isInitialized()) {
                    this.f0 = 0;
                    return false;
                }
            }
            for(int v10 = 0; v10 < this.Z.size(); ++v10) {
                if(!((h)this.Z.get(v10)).isInitialized()) {
                    this.f0 = 0;
                    return false;
                }
            }
            if((this.c & 0x40) == 0x40 && !this.b0.isInitialized()) {
                this.f0 = 0;
                return false;
            }
            for(int v11 = 0; v11 < this.e0.size(); ++v11) {
                if(!((l)this.e0.get(v11)).isInitialized()) {
                    this.f0 = 0;
                    return false;
                }
            }
            if(!this.g()) {
                this.f0 = 0;
                return false;
            }
            this.f0 = 1;
            return true;
        }
        this.f0 = 0;
        return false;
    }

    public final void n() {
        this.d = 6;
        this.e = 0;
        this.f = 0;
        this.g = Collections.EMPTY_LIST;
        this.h = Collections.EMPTY_LIST;
        this.i = Collections.EMPTY_LIST;
        this.k = Collections.EMPTY_LIST;
        this.m = Collections.EMPTY_LIST;
        this.n = Collections.EMPTY_LIST;
        this.r = Collections.EMPTY_LIST;
        this.w = Collections.EMPTY_LIST;
        this.B = Collections.EMPTY_LIST;
        this.D = Collections.EMPTY_LIST;
        this.E = Collections.EMPTY_LIST;
        this.G = Collections.EMPTY_LIST;
        this.M = 0;
        this.N = T.E;
        this.S = 0;
        this.T = Collections.EMPTY_LIST;
        this.W = Collections.EMPTY_LIST;
        this.X = Collections.EMPTY_LIST;
        this.Z = Collections.EMPTY_LIST;
        this.b0 = Z.g;
        this.c0 = Collections.EMPTY_LIST;
        this.d0 = g0.e;
        this.e0 = Collections.EMPTY_LIST;
    }
}

