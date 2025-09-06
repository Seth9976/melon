package lf;

import A3.g;
import i.n.i.b.a.s.e.qb;
import java.io.IOException;
import rf.d;
import rf.h;
import rf.m;
import rf.p;

public final class f extends m {
    public final d a;
    public int b;
    public int c;
    public e d;
    public byte e;
    public int f;
    public static final f g;
    public static final a h;

    static {
        f.h = new a(1);
        f f0 = new f();
        f.g = f0;
        f0.c = 0;
        f0.d = e.r;
    }

    public f() {
        this.e = -1;
        this.f = -1;
        this.a = d.a;
    }

    public f(qb qb0, rf.f f0) {
        c c1;
        this.e = -1;
        this.f = -1;
        this.c = 0;
        this.d = e.r;
        rf.c c0 = new rf.c();
        g g0 = g.w(c0, 1);
        try {
            boolean z = false;
            while(!z) {
                try {
                    try {
                        int v1 = qb0.q();
                        switch(v1) {
                            case 0: {
                                z = true;
                                continue;
                            }
                            case 8: {
                                this.b |= 1;
                                this.c = qb0.n();
                                continue;
                            }
                            case 18: {
                                if((this.b & 2) == 2) {
                                    e e0 = this.d;
                                    e0.getClass();
                                    c1 = e.h(e0);
                                }
                                else {
                                    c1 = null;
                                }
                                e e1 = (e)qb0.j(e.w, f0);
                                this.d = e1;
                                if(c1 != null) {
                                    c1.f(e1);
                                    this.d = c1.d();
                                }
                                break;
                            }
                            default: {
                                if(!qb0.t(v1, g0)) {
                                    z = true;
                                    continue;
                                }
                                continue;
                            }
                        }
                        this.b |= 2;
                        continue;
                    }
                    catch(p p0) {
                    }
                    catch(IOException iOException0) {
                        goto label_38;
                    }
                    p0.a = this;
                    throw p0;
                label_38:
                    p p1 = new p(iOException0.getMessage());
                    p1.a = this;
                    throw p1;
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

    public f(b b0) {
        this.e = -1;
        this.f = -1;
        this.a = b0.a;
    }

    @Override  // rf.a
    public final int a() {
        int v = this.f;
        if(v != -1) {
            return v;
        }
        int v1 = (this.b & 1) == 1 ? g.d(1, this.c) : 0;
        if((this.b & 2) == 2) {
            v1 += g.f(2, this.d);
        }
        int v2 = this.a.size() + v1;
        this.f = v2;
        return v2;
    }

    @Override  // rf.a
    public final h b() {
        h h0 = new b(0);
        h0.e = e.r;
        return h0;
    }

    @Override  // rf.a
    public final h c() {
        h h0 = new b(0);
        h0.e = e.r;
        ((b)h0).f(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        if((this.b & 1) == 1) {
            g0.D(1, this.c);
        }
        if((this.b & 2) == 2) {
            g0.F(2, this.d);
        }
        g0.I(this.a);
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        int v = this.e;
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        int v1 = this.b;
        if((v1 & 1) == 1) {
            if((v1 & 2) == 2) {
                if(!this.d.isInitialized()) {
                    this.e = 0;
                    return false;
                }
                this.e = 1;
                return true;
            }
            this.e = 0;
            return false;
        }
        this.e = 0;
        return false;
    }
}

