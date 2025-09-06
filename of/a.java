package of;

import i.n.i.b.a.s.e.qb;
import rf.f;
import rf.h;
import rf.m;
import rf.p;
import rf.t;

public final class a extends h implements t {
    public final int b;
    public int c;
    public int d;
    public int e;

    public a(int v) {
        this.b = v;
        super();
    }

    @Override  // rf.h
    public final rf.a a() {
        if(this.b != 0) {
            rf.a a0 = this.e();
            ((c)a0).isInitialized();
            return a0;
        }
        rf.a a1 = this.d();
        ((b)a1).isInitialized();
        return a1;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        b b1;
        b b0;
        c c1;
        c c0;
        if(this.b != 0) {
            try {
                try {
                    c0 = null;
                    c.h.getClass();
                    c1 = new c(qb0);
                    goto label_15;
                }
                catch(p p0) {
                    c c2 = (c)p0.a;
                    try {
                        throw p0;
                    }
                    catch(Throwable throwable0) {
                        c0 = c2;
                    }
                }
            }
            catch(Throwable throwable0) {
            }
            if(c0 != null) {
                this.g(c0);
            }
            throw throwable0;
        label_15:
            this.g(c1);
            return this;
        }
        try {
            try {
                b0 = null;
                b.h.getClass();
                b1 = new b(qb0);
                goto label_31;
            }
            catch(p p1) {
                b b2 = (b)p1.a;
                try {
                    throw p1;
                }
                catch(Throwable throwable1) {
                    b0 = b2;
                }
            }
        }
        catch(Throwable throwable1) {
        }
        if(b0 != null) {
            this.f(b0);
        }
        throw throwable1;
    label_31:
        this.f(b1);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        if(this.b != 0) {
            this.g(((c)m0));
            return this;
        }
        this.f(((b)m0));
        return this;
    }

    @Override
    public final Object clone() {
        if(this.b != 0) {
            a a0 = new a(1);
            a0.g(this.e());
            return a0;
        }
        a a1 = new a(0);
        a1.f(this.d());
        return a1;
    }

    public b d() {
        b b0 = new b(this);
        int v = this.c;
        int v1 = (v & 1) == 1 ? 1 : 0;
        b0.c = this.d;
        if((v & 2) == 2) {
            v1 |= 2;
        }
        b0.d = this.e;
        b0.b = v1;
        return b0;
    }

    public c e() {
        c c0 = new c(this);
        int v = this.c;
        int v1 = (v & 1) == 1 ? 1 : 0;
        c0.c = this.d;
        if((v & 2) == 2) {
            v1 |= 2;
        }
        c0.d = this.e;
        c0.b = v1;
        return c0;
    }

    public void f(b b0) {
        if(b0 == b.g) {
            return;
        }
        int v = b0.b;
        if((v & 1) == 1) {
            int v1 = b0.c;
            this.c |= 1;
            this.d = v1;
        }
        if((v & 2) == 2) {
            this.c |= 2;
            this.e = b0.d;
        }
        this.a = this.a.b(b0.a);
    }

    public void g(c c0) {
        if(c0 == c.g) {
            return;
        }
        int v = c0.b;
        if((v & 1) == 1) {
            int v1 = c0.c;
            this.c |= 1;
            this.d = v1;
        }
        if((v & 2) == 2) {
            this.c |= 2;
            this.e = c0.d;
        }
        this.a = this.a.b(c0.a);
    }
}

