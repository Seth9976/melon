package of;

import A3.g;
import i.n.i.b.a.s.e.qb;
import java.io.IOException;
import lf.a;
import rf.c;
import rf.d;
import rf.h;
import rf.m;
import rf.p;

public final class b extends m {
    public final d a;
    public int b;
    public int c;
    public int d;
    public byte e;
    public int f;
    public static final b g;
    public static final a h;

    static {
        b.h = new a(25);
        b b0 = new b();
        b.g = b0;
        b0.c = 0;
        b0.d = 0;
    }

    public b() {
        this.e = -1;
        this.f = -1;
        this.a = d.a;
    }

    public b(qb qb0) {
        this.e = -1;
        this.f = -1;
        this.c = 0;
        this.d = 0;
        c c0 = new c();
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
                            case 16: {
                                this.b |= 2;
                                this.d = qb0.n();
                                continue;
                            }
                            default: {
                                if(!qb0.t(v1, g0)) {
                                    z = true;
                                    continue;
                                }
                                continue;
                            }
                        }
                    }
                    catch(p p0) {
                    }
                    catch(IOException iOException0) {
                        goto label_28;
                    }
                    p0.a = this;
                    throw p0;
                label_28:
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

    public b(of.a a0) {
        this.e = -1;
        this.f = -1;
        this.a = a0.a;
    }

    @Override  // rf.a
    public final int a() {
        int v = this.f;
        if(v != -1) {
            return v;
        }
        int v1 = (this.b & 1) == 1 ? g.d(1, this.c) : 0;
        if((this.b & 2) == 2) {
            v1 += g.d(2, this.d);
        }
        int v2 = this.a.size() + v1;
        this.f = v2;
        return v2;
    }

    @Override  // rf.a
    public final h b() {
        return new of.a(0);
    }

    @Override  // rf.a
    public final h c() {
        h h0 = new of.a(0);
        ((of.a)h0).f(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        if((this.b & 1) == 1) {
            g0.D(1, this.c);
        }
        if((this.b & 2) == 2) {
            g0.D(2, this.d);
        }
        g0.I(this.a);
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        if(this.e == 1) {
            return true;
        }
        this.e = 1;
        return true;
    }
}

