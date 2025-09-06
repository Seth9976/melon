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
import rf.t;

public final class g extends h implements t {
    public final int b;
    public int c;
    public List d;
    public int e;

    public g(int v) {
        this.b = v;
        super();
    }

    @Override  // rf.h
    public final a a() {
        if(this.b != 0) {
            a a0 = this.e();
            if(!((Z)a0).isInitialized()) {
                throw new M3(10);
            }
            return a0;
        }
        a a1 = this.d();
        if(!((lf.h)a1).isInitialized()) {
            throw new M3(10);
        }
        return a1;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        lf.h h1;
        lf.h h0;
        Z z1;
        Z z0;
        if(this.b != 0) {
            try {
                try {
                    z0 = null;
                    Z.h.getClass();
                    z1 = new Z(qb0, f0);
                    goto label_15;
                }
                catch(p p0) {
                    Z z2 = (Z)p0.a;
                    try {
                        throw p0;
                    }
                    catch(Throwable throwable0) {
                        z0 = z2;
                    }
                }
            }
            catch(Throwable throwable0) {
            }
            if(z0 != null) {
                this.h(z0);
            }
            throw throwable0;
        label_15:
            this.h(z1);
            return this;
        }
        try {
            try {
                h0 = null;
                h1 = (lf.h)lf.h.h.a(qb0, f0);
                goto label_30;
            }
            catch(p p1) {
                lf.h h2 = (lf.h)p1.a;
                try {
                    throw p1;
                }
                catch(Throwable throwable1) {
                    h0 = h2;
                }
            }
        }
        catch(Throwable throwable1) {
        }
        if(h0 != null) {
            this.g(h0);
        }
        throw throwable1;
    label_30:
        this.g(h1);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        if(this.b != 0) {
            this.h(((Z)m0));
            return this;
        }
        this.g(((lf.h)m0));
        return this;
    }

    @Override
    public final Object clone() {
        if(this.b != 0) {
            g g0 = g.f();
            g0.h(this.e());
            return g0;
        }
        g g1 = new g(0);
        g1.d = Collections.EMPTY_LIST;
        g1.g(this.d());
        return g1;
    }

    public lf.h d() {
        lf.h h0 = new lf.h(this);
        int v = this.c;
        h0.c = this.e;
        if((v & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
            this.c &= -3;
        }
        h0.d = this.d;
        h0.b = (v & 1) == 1 ? 1 : 0;
        return h0;
    }

    public Z e() {
        Z z0 = new Z(this);
        int v = this.c;
        int v1 = 1;
        if((v & 1) == 1) {
            this.d = Collections.unmodifiableList(this.d);
            this.c &= -2;
        }
        z0.c = this.d;
        if((v & 2) != 2) {
            v1 = 0;
        }
        z0.d = this.e;
        z0.b = v1;
        return z0;
    }

    public static g f() {
        g g0 = new g(1);
        g0.d = Collections.EMPTY_LIST;
        g0.e = -1;
        return g0;
    }

    public void g(lf.h h0) {
        if(h0 == lf.h.g) {
            return;
        }
        if((h0.b & 1) == 1) {
            int v = h0.c;
            this.c |= 1;
            this.e = v;
        }
        if(!h0.d.isEmpty()) {
            if(this.d.isEmpty()) {
                this.d = h0.d;
                this.c &= -3;
            }
            else {
                if((this.c & 2) != 2) {
                    this.d = new ArrayList(this.d);
                    this.c |= 2;
                }
                this.d.addAll(h0.d);
            }
        }
        this.a = this.a.b(h0.a);
    }

    public void h(Z z0) {
        if(z0 == Z.g) {
            return;
        }
        if(!z0.c.isEmpty()) {
            if(this.d.isEmpty()) {
                this.d = z0.c;
                this.c &= -2;
            }
            else {
                if((this.c & 1) != 1) {
                    this.d = new ArrayList(this.d);
                    this.c |= 1;
                }
                this.d.addAll(z0.c);
            }
        }
        if((z0.b & 1) == 1) {
            this.c |= 2;
            this.e = z0.d;
        }
        this.a = this.a.b(z0.a);
    }
}

