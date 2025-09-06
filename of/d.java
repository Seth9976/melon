package of;

import i.n.i.b.a.s.e.qb;
import rf.a;
import rf.f;
import rf.h;
import rf.m;
import rf.p;
import rf.t;

public final class d extends h implements t {
    public int b;
    public b c;
    public c d;
    public c e;
    public c f;
    public c g;

    @Override  // rf.h
    public final a a() {
        a a0 = this.d();
        ((e)a0).isInitialized();
        return a0;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        e e1;
        e e0;
        try {
            try {
                e0 = null;
                e.k.getClass();
                e1 = new e(qb0, f0);
                goto label_14;
            }
            catch(p p0) {
                e e2 = (e)p0.a;
                try {
                    throw p0;
                }
                catch(Throwable throwable0) {
                    e0 = e2;
                }
            }
        }
        catch(Throwable throwable0) {
        }
        if(e0 != null) {
            this.f(e0);
        }
        throw throwable0;
    label_14:
        this.f(e1);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        this.f(((e)m0));
        return this;
    }

    @Override
    public final Object clone() {
        d d0 = d.e();
        d0.f(this.d());
        return d0;
    }

    public final e d() {
        e e0 = new e(this);
        int v = this.b;
        int v1 = (v & 1) == 1 ? 1 : 0;
        e0.c = this.c;
        if((v & 2) == 2) {
            v1 |= 2;
        }
        e0.d = this.d;
        if((v & 4) == 4) {
            v1 |= 4;
        }
        e0.e = this.e;
        if((v & 8) == 8) {
            v1 |= 8;
        }
        e0.f = this.f;
        if((v & 16) == 16) {
            v1 |= 16;
        }
        e0.g = this.g;
        e0.b = v1;
        return e0;
    }

    public static d e() {
        d d0 = new d();  // 初始化器: Lrf/h;-><init>()V
        d0.c = b.g;
        d0.d = c.g;
        d0.e = c.g;
        d0.f = c.g;
        d0.g = c.g;
        return d0;
    }

    public final void f(e e0) {
        if(e0 == e.j) {
            return;
        }
        if((e0.b & 1) == 1) {
            b b0 = e0.c;
            if((this.b & 1) == 1) {
                b b1 = this.c;
                if(b1 == b.g) {
                    this.c = b0;
                }
                else {
                    of.a a0 = new of.a(0);
                    a0.f(b1);
                    a0.f(b0);
                    this.c = a0.d();
                }
            }
            else {
                this.c = b0;
            }
            this.b |= 1;
        }
        if((e0.b & 2) == 2) {
            c c0 = e0.d;
            if((this.b & 2) == 2) {
                c c1 = this.d;
                if(c1 == c.g) {
                    this.d = c0;
                }
                else {
                    of.a a1 = c.g(c1);
                    a1.g(c0);
                    this.d = a1.e();
                }
            }
            else {
                this.d = c0;
            }
            this.b |= 2;
        }
        if(e0.g()) {
            c c2 = e0.e;
            if((this.b & 4) == 4) {
                c c3 = this.e;
                if(c3 == c.g) {
                    this.e = c2;
                }
                else {
                    of.a a2 = c.g(c3);
                    a2.g(c2);
                    this.e = a2.e();
                }
            }
            else {
                this.e = c2;
            }
            this.b |= 4;
        }
        if((e0.b & 8) == 8) {
            c c4 = e0.f;
            if((this.b & 8) == 8) {
                c c5 = this.f;
                if(c5 == c.g) {
                    this.f = c4;
                }
                else {
                    of.a a3 = c.g(c5);
                    a3.g(c4);
                    this.f = a3.e();
                }
            }
            else {
                this.f = c4;
            }
            this.b |= 8;
        }
        if((e0.b & 16) == 16) {
            c c6 = e0.g;
            if((this.b & 16) == 16) {
                c c7 = this.g;
                if(c7 == c.g) {
                    this.g = c6;
                }
                else {
                    of.a a4 = c.g(c7);
                    a4.g(c6);
                    this.g = a4.e();
                }
            }
            else {
                this.g = c6;
            }
            this.b |= 16;
        }
        this.a = this.a.b(e0.a);
    }
}

