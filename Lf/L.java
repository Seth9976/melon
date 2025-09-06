package lf;

import A3.g;
import i.n.i.b.a.s.e.qb;
import java.io.IOException;
import rf.c;
import rf.d;
import rf.h;
import rf.m;
import rf.p;
import rf.s;

public final class l extends m {
    public final d a;
    public int b;
    public int c;
    public s d;
    public byte e;
    public int f;
    public static final l g;
    public static final a h;

    static {
        l.h = new a(4);
        l l0 = new l();
        l.g = l0;
        l0.c = 0;
        l0.d = d.a;
    }

    public l() {
        this.e = -1;
        this.f = -1;
        this.a = d.a;
    }

    public l(qb qb0) {
        this.e = -1;
        this.f = -1;
        this.c = 0;
        this.d = d.a;
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
                            case 18: {
                                this.b |= 2;
                                this.d = qb0.h();
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

    public l(b b0) {
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
            v1 += this.d.size() + g.h(this.d.size()) + 1;
        }
        int v2 = this.a.size() + v1;
        this.f = v2;
        return v2;
    }

    @Override  // rf.a
    public final h b() {
        h h0 = new b(1);
        h0.e = d.a;
        return h0;
    }

    @Override  // rf.a
    public final h c() {
        h h0 = new b(1);
        h0.e = d.a;
        ((b)h0).g(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        if((this.b & 1) == 1) {
            g0.D(1, this.c);
        }
        if((this.b & 2) == 2) {
            s s0 = this.d;
            g0.O(2, 2);
            g0.M(s0.size());
            g0.I(s0);
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

