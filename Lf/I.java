package lf;

import i.n.i.b.a.s.e.M3;
import i.n.i.b.a.s.e.qb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rf.a;
import rf.f;
import rf.h;
import rf.m;
import rf.p;

public final class i extends rf.i {
    public List B;
    public List D;
    public int E;
    public T G;
    public int I;
    public List M;
    public List N;
    public List S;
    public List T;
    public Z V;
    public List W;
    public g0 X;
    public List Y;
    public int d;
    public int e;
    public int f;
    public int g;
    public List h;
    public List i;
    public List j;
    public List k;
    public List l;
    public List m;
    public List n;
    public List o;
    public List r;
    public List w;

    @Override  // rf.h
    public final a a() {
        a a0 = this.e();
        if(!((k)a0).isInitialized()) {
            throw new M3(10);
        }
        return a0;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        k k1;
        k k0;
        try {
            try {
                k0 = null;
                k.i0.getClass();
                k1 = new k(qb0, f0);
                goto label_14;
            }
            catch(p p0) {
                k k2 = (k)p0.a;
                try {
                    throw p0;
                }
                catch(Throwable throwable0) {
                    k0 = k2;
                }
            }
        }
        catch(Throwable throwable0) {
        }
        if(k0 != null) {
            this.g(k0);
        }
        throw throwable0;
    label_14:
        this.g(k1);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        this.g(((k)m0));
        return this;
    }

    @Override
    public final Object clone() {
        i i0 = i.f();
        i0.g(this.e());
        return i0;
    }

    public final k e() {
        k k0 = new k(this);
        int v = this.d;
        int v1 = (v & 1) == 1 ? 1 : 0;
        k0.d = this.e;
        if((v & 2) == 2) {
            v1 |= 2;
        }
        k0.e = this.f;
        if((v & 4) == 4) {
            v1 |= 4;
        }
        k0.f = this.g;
        if((v & 8) == 8) {
            this.h = Collections.unmodifiableList(this.h);
            this.d &= -9;
        }
        k0.g = this.h;
        if((this.d & 16) == 16) {
            this.i = Collections.unmodifiableList(this.i);
            this.d &= -17;
        }
        k0.h = this.i;
        if((this.d & 0x20) == 0x20) {
            this.j = Collections.unmodifiableList(this.j);
            this.d &= -33;
        }
        k0.i = this.j;
        if((this.d & 0x40) == 0x40) {
            this.k = Collections.unmodifiableList(this.k);
            this.d &= -65;
        }
        k0.k = this.k;
        if((this.d & 0x80) == 0x80) {
            this.l = Collections.unmodifiableList(this.l);
            this.d &= 0xFFFFFF7F;
        }
        k0.m = this.l;
        if((this.d & 0x100) == 0x100) {
            this.m = Collections.unmodifiableList(this.m);
            this.d &= 0xFFFFFEFF;
        }
        k0.n = this.m;
        if((this.d & 0x200) == 0x200) {
            this.n = Collections.unmodifiableList(this.n);
            this.d &= 0xFFFFFDFF;
        }
        k0.r = this.n;
        if((this.d & 0x400) == 0x400) {
            this.o = Collections.unmodifiableList(this.o);
            this.d &= 0xFFFFFBFF;
        }
        k0.w = this.o;
        if((this.d & 0x800) == 0x800) {
            this.r = Collections.unmodifiableList(this.r);
            this.d &= 0xFFFFF7FF;
        }
        k0.B = this.r;
        if((this.d & 0x1000) == 0x1000) {
            this.w = Collections.unmodifiableList(this.w);
            this.d &= 0xFFFFEFFF;
        }
        k0.D = this.w;
        if((this.d & 0x2000) == 0x2000) {
            this.B = Collections.unmodifiableList(this.B);
            this.d &= 0xFFFFDFFF;
        }
        k0.E = this.B;
        if((this.d & 0x4000) == 0x4000) {
            this.D = Collections.unmodifiableList(this.D);
            this.d &= 0xFFFFBFFF;
        }
        k0.G = this.D;
        if((v & 0x8000) == 0x8000) {
            v1 |= 8;
        }
        k0.M = this.E;
        if((v & 0x10000) == 0x10000) {
            v1 |= 16;
        }
        k0.N = this.G;
        if((v & 0x20000) == 0x20000) {
            v1 |= 0x20;
        }
        k0.S = this.I;
        if((this.d & 0x40000) == 0x40000) {
            this.M = Collections.unmodifiableList(this.M);
            this.d &= 0xFFFBFFFF;
        }
        k0.T = this.M;
        if((this.d & 0x80000) == 0x80000) {
            this.N = Collections.unmodifiableList(this.N);
            this.d &= 0xFFF7FFFF;
        }
        k0.W = this.N;
        if((this.d & 0x100000) == 0x100000) {
            this.S = Collections.unmodifiableList(this.S);
            this.d &= 0xFFEFFFFF;
        }
        k0.X = this.S;
        if((this.d & 0x200000) == 0x200000) {
            this.T = Collections.unmodifiableList(this.T);
            this.d &= 0xFFDFFFFF;
        }
        k0.Z = this.T;
        if((v & 0x400000) == 0x400000) {
            v1 |= 0x40;
        }
        k0.b0 = this.V;
        if((this.d & 0x800000) == 0x800000) {
            this.W = Collections.unmodifiableList(this.W);
            this.d &= 0xFF7FFFFF;
        }
        k0.c0 = this.W;
        if((v & 0x1000000) == 0x1000000) {
            v1 |= 0x80;
        }
        k0.d0 = this.X;
        if((this.d & 0x2000000) == 0x2000000) {
            this.Y = Collections.unmodifiableList(this.Y);
            this.d &= 0xFDFFFFFF;
        }
        k0.e0 = this.Y;
        k0.c = v1;
        return k0;
    }

    public static i f() {
        i i0 = new i();  // 初始化器: Lrf/i;-><init>()V
        i0.e = 6;
        i0.h = Collections.EMPTY_LIST;
        i0.i = Collections.EMPTY_LIST;
        i0.j = Collections.EMPTY_LIST;
        i0.k = Collections.EMPTY_LIST;
        i0.l = Collections.EMPTY_LIST;
        i0.m = Collections.EMPTY_LIST;
        i0.n = Collections.EMPTY_LIST;
        i0.o = Collections.EMPTY_LIST;
        i0.r = Collections.EMPTY_LIST;
        i0.w = Collections.EMPTY_LIST;
        i0.B = Collections.EMPTY_LIST;
        i0.D = Collections.EMPTY_LIST;
        i0.G = T.E;
        i0.M = Collections.EMPTY_LIST;
        i0.N = Collections.EMPTY_LIST;
        i0.S = Collections.EMPTY_LIST;
        i0.T = Collections.EMPTY_LIST;
        i0.V = Z.g;
        i0.W = Collections.EMPTY_LIST;
        i0.X = g0.e;
        i0.Y = Collections.EMPTY_LIST;
        return i0;
    }

    public final void g(k k0) {
        if(k0 == k.h0) {
            return;
        }
        int v = k0.c;
        if((v & 1) == 1) {
            int v1 = k0.d;
            this.d |= 1;
            this.e = v1;
        }
        if((v & 2) == 2) {
            this.d |= 2;
            this.f = k0.e;
        }
        if((v & 4) == 4) {
            this.d |= 4;
            this.g = k0.f;
        }
        if(!k0.g.isEmpty()) {
            if(this.h.isEmpty()) {
                this.h = k0.g;
                this.d &= -9;
            }
            else {
                if((this.d & 8) != 8) {
                    this.h = new ArrayList(this.h);
                    this.d |= 8;
                }
                this.h.addAll(k0.g);
            }
        }
        if(!k0.h.isEmpty()) {
            if(this.i.isEmpty()) {
                this.i = k0.h;
                this.d &= -17;
            }
            else {
                if((this.d & 16) != 16) {
                    this.i = new ArrayList(this.i);
                    this.d |= 16;
                }
                this.i.addAll(k0.h);
            }
        }
        if(!k0.i.isEmpty()) {
            if(this.j.isEmpty()) {
                this.j = k0.i;
                this.d &= -33;
            }
            else {
                if((this.d & 0x20) != 0x20) {
                    this.j = new ArrayList(this.j);
                    this.d |= 0x20;
                }
                this.j.addAll(k0.i);
            }
        }
        if(!k0.k.isEmpty()) {
            if(this.k.isEmpty()) {
                this.k = k0.k;
                this.d &= -65;
            }
            else {
                if((this.d & 0x40) != 0x40) {
                    this.k = new ArrayList(this.k);
                    this.d |= 0x40;
                }
                this.k.addAll(k0.k);
            }
        }
        if(!k0.m.isEmpty()) {
            if(this.l.isEmpty()) {
                this.l = k0.m;
                this.d &= 0xFFFFFF7F;
            }
            else {
                if((this.d & 0x80) != 0x80) {
                    this.l = new ArrayList(this.l);
                    this.d |= 0x80;
                }
                this.l.addAll(k0.m);
            }
        }
        if(!k0.n.isEmpty()) {
            if(this.m.isEmpty()) {
                this.m = k0.n;
                this.d &= 0xFFFFFEFF;
            }
            else {
                if((this.d & 0x100) != 0x100) {
                    this.m = new ArrayList(this.m);
                    this.d |= 0x100;
                }
                this.m.addAll(k0.n);
            }
        }
        if(!k0.r.isEmpty()) {
            if(this.n.isEmpty()) {
                this.n = k0.r;
                this.d &= 0xFFFFFDFF;
            }
            else {
                if((this.d & 0x200) != 0x200) {
                    this.n = new ArrayList(this.n);
                    this.d |= 0x200;
                }
                this.n.addAll(k0.r);
            }
        }
        if(!k0.w.isEmpty()) {
            if(this.o.isEmpty()) {
                this.o = k0.w;
                this.d &= 0xFFFFFBFF;
            }
            else {
                if((this.d & 0x400) != 0x400) {
                    this.o = new ArrayList(this.o);
                    this.d |= 0x400;
                }
                this.o.addAll(k0.w);
            }
        }
        if(!k0.B.isEmpty()) {
            if(this.r.isEmpty()) {
                this.r = k0.B;
                this.d &= 0xFFFFF7FF;
            }
            else {
                if((this.d & 0x800) != 0x800) {
                    this.r = new ArrayList(this.r);
                    this.d |= 0x800;
                }
                this.r.addAll(k0.B);
            }
        }
        if(!k0.D.isEmpty()) {
            if(this.w.isEmpty()) {
                this.w = k0.D;
                this.d &= 0xFFFFEFFF;
            }
            else {
                if((this.d & 0x1000) != 0x1000) {
                    this.w = new ArrayList(this.w);
                    this.d |= 0x1000;
                }
                this.w.addAll(k0.D);
            }
        }
        if(!k0.E.isEmpty()) {
            if(this.B.isEmpty()) {
                this.B = k0.E;
                this.d &= 0xFFFFDFFF;
            }
            else {
                if((this.d & 0x2000) != 0x2000) {
                    this.B = new ArrayList(this.B);
                    this.d |= 0x2000;
                }
                this.B.addAll(k0.E);
            }
        }
        if(!k0.G.isEmpty()) {
            if(this.D.isEmpty()) {
                this.D = k0.G;
                this.d &= 0xFFFFBFFF;
            }
            else {
                if((this.d & 0x4000) != 0x4000) {
                    this.D = new ArrayList(this.D);
                    this.d |= 0x4000;
                }
                this.D.addAll(k0.G);
            }
        }
        int v2 = k0.c;
        if((v2 & 8) == 8) {
            this.d |= 0x8000;
            this.E = k0.M;
        }
        if((v2 & 16) == 16) {
            T t0 = k0.N;
            if((this.d & 0x10000) == 0x10000) {
                T t1 = this.G;
                if(t1 == T.E) {
                    this.G = t0;
                }
                else {
                    S s0 = T.p(t1);
                    s0.g(t0);
                    this.G = s0.e();
                }
            }
            else {
                this.G = t0;
            }
            this.d |= 0x10000;
        }
        if((k0.c & 0x20) == 0x20) {
            this.d |= 0x20000;
            this.I = k0.S;
        }
        if(!k0.T.isEmpty()) {
            if(this.M.isEmpty()) {
                this.M = k0.T;
                this.d &= 0xFFFBFFFF;
            }
            else {
                if((this.d & 0x40000) != 0x40000) {
                    this.M = new ArrayList(this.M);
                    this.d |= 0x40000;
                }
                this.M.addAll(k0.T);
            }
        }
        if(!k0.W.isEmpty()) {
            if(this.N.isEmpty()) {
                this.N = k0.W;
                this.d &= 0xFFF7FFFF;
            }
            else {
                if((this.d & 0x80000) != 0x80000) {
                    this.N = new ArrayList(this.N);
                    this.d |= 0x80000;
                }
                this.N.addAll(k0.W);
            }
        }
        if(!k0.X.isEmpty()) {
            if(this.S.isEmpty()) {
                this.S = k0.X;
                this.d &= 0xFFEFFFFF;
            }
            else {
                if((this.d & 0x100000) != 0x100000) {
                    this.S = new ArrayList(this.S);
                    this.d |= 0x100000;
                }
                this.S.addAll(k0.X);
            }
        }
        if(!k0.Z.isEmpty()) {
            if(this.T.isEmpty()) {
                this.T = k0.Z;
                this.d &= 0xFFDFFFFF;
            }
            else {
                if((this.d & 0x200000) != 0x200000) {
                    this.T = new ArrayList(this.T);
                    this.d |= 0x200000;
                }
                this.T.addAll(k0.Z);
            }
        }
        if((k0.c & 0x40) == 0x40) {
            Z z0 = k0.b0;
            if((this.d & 0x400000) == 0x400000) {
                Z z1 = this.V;
                if(z1 == Z.g) {
                    this.V = z0;
                }
                else {
                    g g0 = Z.g(z1);
                    g0.h(z0);
                    this.V = g0.e();
                }
            }
            else {
                this.V = z0;
            }
            this.d |= 0x400000;
        }
        if(!k0.c0.isEmpty()) {
            if(this.W.isEmpty()) {
                this.W = k0.c0;
                this.d &= 0xFF7FFFFF;
            }
            else {
                if((this.d & 0x800000) != 0x800000) {
                    this.W = new ArrayList(this.W);
                    this.d |= 0x800000;
                }
                this.W.addAll(k0.c0);
            }
        }
        if((k0.c & 0x80) == 0x80) {
            g0 g00 = k0.d0;
            if((this.d & 0x1000000) == 0x1000000) {
                g0 g01 = this.X;
                if(g01 == g0.e) {
                    this.X = g00;
                }
                else {
                    o o0 = new o(2);
                    o0.d = Collections.EMPTY_LIST;
                    o0.k(g01);
                    o0.k(g00);
                    this.X = o0.g();
                }
            }
            else {
                this.X = g00;
            }
            this.d |= 0x1000000;
        }
        if(!k0.e0.isEmpty()) {
            if(this.Y.isEmpty()) {
                this.Y = k0.e0;
                this.d &= 0xFDFFFFFF;
            }
            else {
                if((this.d & 0x2000000) != 0x2000000) {
                    this.Y = new ArrayList(this.Y);
                    this.d |= 0x2000000;
                }
                this.Y.addAll(k0.e0);
            }
        }
        this.d(k0);
        this.a = this.a.b(k0.b);
    }
}

