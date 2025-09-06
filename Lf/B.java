package lf;

import i.n.i.b.a.s.e.M3;
import i.n.i.b.a.s.e.qb;
import rf.a;
import rf.d;
import rf.h;
import rf.m;
import rf.p;
import rf.s;
import rf.t;

public final class b extends h implements t {
    public final int b;
    public int c;
    public int d;
    public Object e;

    public b(int v) {
        this.b = v;
        super();
    }

    @Override  // rf.h
    public final a a() {
        if(this.b != 0) {
            a a0 = this.e();
            if(!((l)a0).isInitialized()) {
                throw new M3(10);
            }
            return a0;
        }
        a a1 = this.d();
        if(!((f)a1).isInitialized()) {
            throw new M3(10);
        }
        return a1;
    }

    @Override  // rf.h
    public final h b(qb qb0, rf.f f0) {
        f f2;
        f f1;
        l l1;
        l l0;
        if(this.b != 0) {
            try {
                try {
                    l0 = null;
                    l.h.getClass();
                    l1 = new l(qb0);
                    goto label_15;
                }
                catch(p p0) {
                    l l2 = (l)p0.a;
                    try {
                        throw p0;
                    }
                    catch(Throwable throwable0) {
                        l0 = l2;
                    }
                }
            }
            catch(Throwable throwable0) {
            }
            if(l0 != null) {
                this.g(l0);
            }
            throw throwable0;
        label_15:
            this.g(l1);
            return this;
        }
        try {
            try {
                f1 = null;
                f.h.getClass();
                f2 = new f(qb0, f0);
                goto label_31;
            }
            catch(p p1) {
                f f3 = (f)p1.a;
                try {
                    throw p1;
                }
                catch(Throwable throwable1) {
                    f1 = f3;
                }
            }
        }
        catch(Throwable throwable1) {
        }
        if(f1 != null) {
            this.f(f1);
        }
        throw throwable1;
    label_31:
        this.f(f2);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        if(this.b != 0) {
            this.g(((l)m0));
            return this;
        }
        this.f(((f)m0));
        return this;
    }

    @Override
    public final Object clone() {
        if(this.b != 0) {
            b b0 = new b(1);
            b0.e = d.a;
            b0.g(this.e());
            return b0;
        }
        b b1 = new b(0);
        b1.e = e.r;
        b1.f(this.d());
        return b1;
    }

    public f d() {
        f f0 = new f(this);
        int v = this.c;
        int v1 = (v & 1) == 1 ? 1 : 0;
        f0.c = this.d;
        if((v & 2) == 2) {
            v1 |= 2;
        }
        f0.d = (e)this.e;
        f0.b = v1;
        return f0;
    }

    public l e() {
        l l0 = new l(this);
        int v = this.c;
        int v1 = (v & 1) == 1 ? 1 : 0;
        l0.c = this.d;
        if((v & 2) == 2) {
            v1 |= 2;
        }
        l0.d = (s)this.e;
        l0.b = v1;
        return l0;
    }

    public void f(f f0) {
        if(f0 == f.g) {
            return;
        }
        int v = f0.b;
        if((v & 1) == 1) {
            int v1 = f0.c;
            this.c |= 1;
            this.d = v1;
        }
        if((v & 2) == 2) {
            e e0 = f0.d;
            if((this.c & 2) == 2) {
                e e1 = (e)this.e;
                if(e1 == e.r) {
                    this.e = e0;
                }
                else {
                    c c0 = e.h(e1);
                    c0.f(e0);
                    this.e = c0.d();
                }
            }
            else {
                this.e = e0;
            }
            this.c |= 2;
        }
        this.a = this.a.b(f0.a);
    }

    public void g(l l0) {
        if(l0 == l.g) {
            return;
        }
        int v = l0.b;
        if((v & 1) == 1) {
            int v1 = l0.c;
            this.c |= 1;
            this.d = v1;
        }
        if((v & 2) == 2) {
            s s0 = l0.d;
            s0.getClass();
            this.c |= 2;
            this.e = s0;
        }
        this.a = this.a.b(l0.a);
    }
}

