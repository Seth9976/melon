package lf;

import i.n.i.b.a.s.e.M3;
import i.n.i.b.a.s.e.qb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rf.a;
import rf.f;
import rf.h;
import rf.i;
import rf.m;

public final class z extends i {
    public List B;
    public p D;
    public List E;
    public List G;
    public List I;
    public int d;
    public int e;
    public int f;
    public int g;
    public T h;
    public int i;
    public List j;
    public T k;
    public int l;
    public List m;
    public List n;
    public List o;
    public List r;
    public Z w;

    @Override  // rf.h
    public final a a() {
        a a0 = this.e();
        if(!((A)a0).isInitialized()) {
            throw new M3(10);
        }
        return a0;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        A a1;
        A a0;
        try {
            try {
                a0 = null;
                A.T.getClass();
                a1 = new A(qb0, f0);
                goto label_14;
            }
            catch(rf.p p0) {
                A a2 = (A)p0.a;
                try {
                    throw p0;
                }
                catch(Throwable throwable0) {
                    a0 = a2;
                }
            }
        }
        catch(Throwable throwable0) {
        }
        if(a0 != null) {
            this.g(a0);
        }
        throw throwable0;
    label_14:
        this.g(a1);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        this.g(((A)m0));
        return this;
    }

    @Override
    public final Object clone() {
        z z0 = z.f();
        z0.g(this.e());
        return z0;
    }

    public final A e() {
        A a0 = new A(this);
        int v = this.d;
        int v1 = (v & 1) == 1 ? 1 : 0;
        a0.d = this.e;
        if((v & 2) == 2) {
            v1 |= 2;
        }
        a0.e = this.f;
        if((v & 4) == 4) {
            v1 |= 4;
        }
        a0.f = this.g;
        if((v & 8) == 8) {
            v1 |= 8;
        }
        a0.g = this.h;
        if((v & 16) == 16) {
            v1 |= 16;
        }
        a0.h = this.i;
        if((v & 0x20) == 0x20) {
            this.j = Collections.unmodifiableList(this.j);
            this.d &= -33;
        }
        a0.i = this.j;
        if((v & 0x40) == 0x40) {
            v1 |= 0x20;
        }
        a0.j = this.k;
        if((v & 0x80) == 0x80) {
            v1 |= 0x40;
        }
        a0.k = this.l;
        if((this.d & 0x100) == 0x100) {
            this.m = Collections.unmodifiableList(this.m);
            this.d &= 0xFFFFFEFF;
        }
        a0.l = this.m;
        if((this.d & 0x200) == 0x200) {
            this.n = Collections.unmodifiableList(this.n);
            this.d &= 0xFFFFFDFF;
        }
        a0.m = this.n;
        if((this.d & 0x400) == 0x400) {
            this.o = Collections.unmodifiableList(this.o);
            this.d &= 0xFFFFFBFF;
        }
        a0.o = this.o;
        if((this.d & 0x800) == 0x800) {
            this.r = Collections.unmodifiableList(this.r);
            this.d &= 0xFFFFF7FF;
        }
        a0.r = this.r;
        if((v & 0x1000) == 0x1000) {
            v1 |= 0x80;
        }
        a0.w = this.w;
        if((this.d & 0x2000) == 0x2000) {
            this.B = Collections.unmodifiableList(this.B);
            this.d &= 0xFFFFDFFF;
        }
        a0.B = this.B;
        if((v & 0x4000) == 0x4000) {
            v1 |= 0x100;
        }
        a0.D = this.D;
        if((this.d & 0x8000) == 0x8000) {
            this.E = Collections.unmodifiableList(this.E);
            this.d &= 0xFFFF7FFF;
        }
        a0.E = this.E;
        if((this.d & 0x10000) == 0x10000) {
            this.G = Collections.unmodifiableList(this.G);
            this.d &= 0xFFFEFFFF;
        }
        a0.G = this.G;
        if((this.d & 0x20000) == 0x20000) {
            this.I = Collections.unmodifiableList(this.I);
            this.d &= 0xFFFDFFFF;
        }
        a0.I = this.I;
        a0.c = v1;
        return a0;
    }

    public static z f() {
        z z0 = new z();  // 初始化器: Lrf/i;-><init>()V
        z0.e = 6;
        z0.f = 6;
        z0.h = T.E;
        z0.j = Collections.EMPTY_LIST;
        z0.k = T.E;
        z0.m = Collections.EMPTY_LIST;
        z0.n = Collections.EMPTY_LIST;
        z0.o = Collections.EMPTY_LIST;
        z0.r = Collections.EMPTY_LIST;
        z0.w = Z.g;
        z0.B = Collections.EMPTY_LIST;
        z0.D = p.e;
        z0.E = Collections.EMPTY_LIST;
        z0.G = Collections.EMPTY_LIST;
        z0.I = Collections.EMPTY_LIST;
        return z0;
    }

    public final void g(A a0) {
        if(a0 == A.S) {
            return;
        }
        int v = a0.c;
        if((v & 1) == 1) {
            int v1 = a0.d;
            this.d |= 1;
            this.e = v1;
        }
        if((v & 2) == 2) {
            this.d |= 2;
            this.f = a0.e;
        }
        if((v & 4) == 4) {
            this.d |= 4;
            this.g = a0.f;
        }
        if((v & 8) == 8) {
            T t0 = a0.g;
            if((this.d & 8) == 8) {
                T t1 = this.h;
                if(t1 == T.E) {
                    this.h = t0;
                }
                else {
                    S s0 = T.p(t1);
                    s0.g(t0);
                    this.h = s0.e();
                }
            }
            else {
                this.h = t0;
            }
            this.d |= 8;
        }
        if((a0.c & 16) == 16) {
            this.d |= 16;
            this.i = a0.h;
        }
        if(!a0.i.isEmpty()) {
            if(this.j.isEmpty()) {
                this.j = a0.i;
                this.d &= -33;
            }
            else {
                if((this.d & 0x20) != 0x20) {
                    this.j = new ArrayList(this.j);
                    this.d |= 0x20;
                }
                this.j.addAll(a0.i);
            }
        }
        if((a0.c & 0x20) == 0x20) {
            T t2 = a0.j;
            if((this.d & 0x40) == 0x40) {
                T t3 = this.k;
                if(t3 == T.E) {
                    this.k = t2;
                }
                else {
                    S s1 = T.p(t3);
                    s1.g(t2);
                    this.k = s1.e();
                }
            }
            else {
                this.k = t2;
            }
            this.d |= 0x40;
        }
        if((a0.c & 0x40) == 0x40) {
            this.d |= 0x80;
            this.l = a0.k;
        }
        if(!a0.l.isEmpty()) {
            if(this.m.isEmpty()) {
                this.m = a0.l;
                this.d &= 0xFFFFFEFF;
            }
            else {
                if((this.d & 0x100) != 0x100) {
                    this.m = new ArrayList(this.m);
                    this.d |= 0x100;
                }
                this.m.addAll(a0.l);
            }
        }
        if(!a0.m.isEmpty()) {
            if(this.n.isEmpty()) {
                this.n = a0.m;
                this.d &= 0xFFFFFDFF;
            }
            else {
                if((this.d & 0x200) != 0x200) {
                    this.n = new ArrayList(this.n);
                    this.d |= 0x200;
                }
                this.n.addAll(a0.m);
            }
        }
        if(!a0.o.isEmpty()) {
            if(this.o.isEmpty()) {
                this.o = a0.o;
                this.d &= 0xFFFFFBFF;
            }
            else {
                if((this.d & 0x400) != 0x400) {
                    this.o = new ArrayList(this.o);
                    this.d |= 0x400;
                }
                this.o.addAll(a0.o);
            }
        }
        if(!a0.r.isEmpty()) {
            if(this.r.isEmpty()) {
                this.r = a0.r;
                this.d &= 0xFFFFF7FF;
            }
            else {
                if((this.d & 0x800) != 0x800) {
                    this.r = new ArrayList(this.r);
                    this.d |= 0x800;
                }
                this.r.addAll(a0.r);
            }
        }
        if((a0.c & 0x80) == 0x80) {
            Z z0 = a0.w;
            if((this.d & 0x1000) == 0x1000) {
                Z z1 = this.w;
                if(z1 == Z.g) {
                    this.w = z0;
                }
                else {
                    g g0 = Z.g(z1);
                    g0.h(z0);
                    this.w = g0.e();
                }
            }
            else {
                this.w = z0;
            }
            this.d |= 0x1000;
        }
        if(!a0.B.isEmpty()) {
            if(this.B.isEmpty()) {
                this.B = a0.B;
                this.d &= 0xFFFFDFFF;
            }
            else {
                if((this.d & 0x2000) != 0x2000) {
                    this.B = new ArrayList(this.B);
                    this.d |= 0x2000;
                }
                this.B.addAll(a0.B);
            }
        }
        if((a0.c & 0x100) == 0x100) {
            p p0 = a0.D;
            if((this.d & 0x4000) == 0x4000) {
                p p1 = this.D;
                if(p1 == p.e) {
                    this.D = p0;
                }
                else {
                    o o0 = new o(0);
                    o0.d = Collections.EMPTY_LIST;
                    o0.h(p1);
                    o0.h(p0);
                    this.D = o0.d();
                }
            }
            else {
                this.D = p0;
            }
            this.d |= 0x4000;
        }
        if(!a0.E.isEmpty()) {
            if(this.E.isEmpty()) {
                this.E = a0.E;
                this.d &= 0xFFFF7FFF;
            }
            else {
                if((this.d & 0x8000) != 0x8000) {
                    this.E = new ArrayList(this.E);
                    this.d |= 0x8000;
                }
                this.E.addAll(a0.E);
            }
        }
        if(!a0.G.isEmpty()) {
            if(this.G.isEmpty()) {
                this.G = a0.G;
                this.d &= 0xFFFEFFFF;
            }
            else {
                if((this.d & 0x10000) != 0x10000) {
                    this.G = new ArrayList(this.G);
                    this.d |= 0x10000;
                }
                this.G.addAll(a0.G);
            }
        }
        if(!a0.I.isEmpty()) {
            if(this.I.isEmpty()) {
                this.I = a0.I;
                this.d &= 0xFFFDFFFF;
            }
            else {
                if((this.d & 0x20000) != 0x20000) {
                    this.I = new ArrayList(this.I);
                    this.d |= 0x20000;
                }
                this.I.addAll(a0.I);
            }
        }
        this.d(a0);
        this.a = this.a.b(a0.b);
    }
}

