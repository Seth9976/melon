package of;

import A3.g;
import i.n.i.b.a.s.e.qb;
import java.io.IOException;
import lf.a;
import rf.d;
import rf.f;
import rf.h;
import rf.m;
import rf.p;

public final class e extends m {
    public final d a;
    public int b;
    public b c;
    public c d;
    public c e;
    public c f;
    public c g;
    public byte h;
    public int i;
    public static final e j;
    public static final a k;

    static {
        e.k = new a(27);
        e e0 = new e();
        e.j = e0;
        e0.c = b.g;
        e0.d = c.g;
        e0.e = c.g;
        e0.f = c.g;
        e0.g = c.g;
    }

    public e() {
        this.h = -1;
        this.i = -1;
        this.a = d.a;
    }

    public e(qb qb0, f f0) {
        this.h = -1;
        this.i = -1;
        this.c = b.g;
        this.d = c.g;
        this.e = c.g;
        this.f = c.g;
        this.g = c.g;
        rf.c c0 = new rf.c();
        g g0 = g.w(c0, 1);
        try {
            boolean z = false;
            while(!z) {
                try {
                    int v1 = qb0.q();
                    if(v1 != 0) {
                        of.a a0 = null;
                        switch(v1) {
                            case 10: {
                                if((this.b & 1) == 1) {
                                    b b0 = this.c;
                                    b0.getClass();
                                    a0 = new of.a(0);
                                    a0.f(b0);
                                }
                                b b1 = (b)qb0.j(b.h, f0);
                                this.c = b1;
                                if(a0 != null) {
                                    a0.f(b1);
                                    this.c = a0.d();
                                }
                                this.b |= 1;
                                continue;
                            }
                            case 18: {
                                if((this.b & 2) == 2) {
                                    c c7 = this.d;
                                    c7.getClass();
                                    a0 = c.g(c7);
                                }
                                c c8 = (c)qb0.j(c.h, f0);
                                this.d = c8;
                                if(a0 != null) {
                                    a0.g(c8);
                                    this.d = a0.e();
                                }
                                this.b |= 2;
                                continue;
                            }
                            case 26: {
                                if((this.b & 4) == 4) {
                                    c c5 = this.e;
                                    c5.getClass();
                                    a0 = c.g(c5);
                                }
                                c c6 = (c)qb0.j(c.h, f0);
                                this.e = c6;
                                if(a0 != null) {
                                    a0.g(c6);
                                    this.e = a0.e();
                                }
                                this.b |= 4;
                                continue;
                            }
                            case 34: {
                                if((this.b & 8) == 8) {
                                    c c3 = this.f;
                                    c3.getClass();
                                    a0 = c.g(c3);
                                }
                                c c4 = (c)qb0.j(c.h, f0);
                                this.f = c4;
                                if(a0 != null) {
                                    a0.g(c4);
                                    this.f = a0.e();
                                }
                                this.b |= 8;
                                continue;
                            }
                            case 42: {
                                if((this.b & 16) == 16) {
                                    c c1 = this.g;
                                    c1.getClass();
                                    a0 = c.g(c1);
                                }
                                c c2 = (c)qb0.j(c.h, f0);
                                this.g = c2;
                                if(a0 != null) {
                                    a0.g(c2);
                                    this.g = a0.e();
                                }
                                this.b |= 16;
                                continue;
                            }
                            default: {
                                if(qb0.t(v1, g0)) {
                                    continue;
                                }
                            }
                        }
                    }
                    try {
                        try {
                            z = true;
                            continue;
                        }
                        catch(p p0) {
                        }
                        catch(IOException iOException0) {
                            goto label_89;
                        }
                        p0.a = this;
                        throw p0;
                    label_89:
                        p p1 = new p(iOException0.getMessage());
                        p1.a = this;
                        throw p1;
                    }
                    catch(Throwable throwable0) {
                    }
                }
                catch(p p0) {
                    p0.a = this;
                    throw p0;
                }
                catch(IOException iOException0) {
                    goto label_89;
                }
                catch(Throwable throwable0) {
                }
                try {
                    g0.k();
                }
                catch(IOException unused_ex) {
                }
                throw throwable0;
            }
            try {
                g0.k();
            }
            catch(IOException unused_ex) {
            }
        }
        finally {
            this.a = c0.m();
        }
    }

    public e(of.d d0) {
        this.h = -1;
        this.i = -1;
        this.a = d0.a;
    }

    @Override  // rf.a
    public final int a() {
        int v = this.i;
        if(v != -1) {
            return v;
        }
        int v1 = (this.b & 1) == 1 ? g.f(1, this.c) : 0;
        if((this.b & 2) == 2) {
            v1 += g.f(2, this.d);
        }
        if((this.b & 4) == 4) {
            v1 += g.f(3, this.e);
        }
        if((this.b & 8) == 8) {
            v1 += g.f(4, this.f);
        }
        if((this.b & 16) == 16) {
            v1 += g.f(5, this.g);
        }
        int v2 = this.a.size() + v1;
        this.i = v2;
        return v2;
    }

    @Override  // rf.a
    public final h b() {
        return of.d.e();
    }

    @Override  // rf.a
    public final h c() {
        h h0 = of.d.e();
        ((of.d)h0).f(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        if((this.b & 1) == 1) {
            g0.F(1, this.c);
        }
        if((this.b & 2) == 2) {
            g0.F(2, this.d);
        }
        if((this.b & 4) == 4) {
            g0.F(3, this.e);
        }
        if((this.b & 8) == 8) {
            g0.F(4, this.f);
        }
        if((this.b & 16) == 16) {
            g0.F(5, this.g);
        }
        g0.I(this.a);
    }

    public final boolean g() {
        return (this.b & 4) == 4;
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        if(this.h == 1) {
            return true;
        }
        this.h = 1;
        return true;
    }
}

