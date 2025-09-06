package lf;

import A3.g;
import i.n.i.b.a.s.e.qb;
import java.io.IOException;
import rf.c;
import rf.d;
import rf.h;
import rf.m;
import rf.p;

public final class f0 extends m {
    public final d a;
    public int b;
    public int c;
    public int d;
    public d0 e;
    public int f;
    public int g;
    public e0 h;
    public byte i;
    public int j;
    public static final f0 k;
    public static final a l;

    static {
        f0.l = new a(23);
        f0 f00 = new f0();
        f0.k = f00;
        f00.c = 0;
        f00.d = 0;
        f00.e = d0.c;
        f00.f = 0;
        f00.g = 0;
        f00.h = e0.b;
    }

    public f0() {
        this.i = -1;
        this.j = -1;
        this.a = d.a;
    }

    public f0(qb qb0) {
        this.i = -1;
        this.j = -1;
        this.c = 0;
        this.d = 0;
        d0 d00 = d0.c;
        this.e = d00;
        this.f = 0;
        this.g = 0;
        e0 e00 = e0.b;
        this.h = e00;
        c c0 = new c();
        g g0 = g.w(c0, 1);
        try {
            boolean z = false;
            while(!z) {
                try {
                    d0 d01 = null;
                    int v1 = qb0.q();
                alab1:
                    switch(v1) {
                        case 0: {
                            z = true;
                            break;
                        }
                        case 8: {
                            this.b |= 1;
                            this.c = qb0.n();
                            continue;
                        }
                        default: {
                            if(v1 == 16) {
                                this.b |= 2;
                                this.d = qb0.n();
                                break;
                            }
                            else {
                                switch(v1) {
                                    case 24: {
                                        int v2 = qb0.n();
                                        switch(v2) {
                                            case 0: {
                                                d01 = d0.b;
                                                break;
                                            }
                                            case 1: {
                                                d01 = d00;
                                                break;
                                            }
                                            case 2: {
                                                d01 = d0.d;
                                            }
                                        }
                                        if(d01 == null) {
                                            g0.M(24);
                                            g0.M(v2);
                                        }
                                        else {
                                            this.b |= 4;
                                            this.e = d01;
                                        }
                                        break alab1;
                                    }
                                    case 0x20: {
                                        this.b |= 8;
                                        this.f = qb0.n();
                                        break alab1;
                                    }
                                    case 40: {
                                        this.b |= 16;
                                        this.g = qb0.n();
                                        break alab1;
                                    }
                                    case 0x30: {
                                        int v3 = qb0.n();
                                        switch(v3) {
                                            case 0: {
                                                d01 = e00;
                                                break;
                                            }
                                            case 1: {
                                                d01 = e0.c;
                                                break;
                                            }
                                            case 2: {
                                                d01 = e0.d;
                                            }
                                        }
                                        if(d01 == null) {
                                            g0.M(0x30);
                                            g0.M(v3);
                                        }
                                        else {
                                            this.b |= 0x20;
                                            this.h = d01;
                                        }
                                        break alab1;
                                    }
                                    default: {
                                        if(qb0.t(v1, g0)) {
                                            break alab1;
                                        }
                                    }
                                }
                            }
                            z = true;
                            break;
                        }
                    }
                }
                catch(p p0) {
                    p0.a = this;
                    throw p0;
                }
                catch(IOException iOException0) {
                    goto label_79;
                }
                catch(Throwable throwable0) {
                    goto label_82;
                }
                continue;
                try {
                    try {
                        this.b |= 1;
                        this.c = qb0.n();
                        continue;
                    }
                    catch(p p0) {
                    }
                    catch(IOException iOException0) {
                        goto label_79;
                    }
                    p0.a = this;
                    throw p0;
                label_79:
                    p p1 = new p(iOException0.getMessage());
                    p1.a = this;
                    throw p1;
                }
                catch(Throwable throwable0) {
                }
                try {
                label_82:
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

    public f0(c0 c00) {
        this.i = -1;
        this.j = -1;
        this.a = c00.a;
    }

    @Override  // rf.a
    public final int a() {
        int v = this.j;
        if(v != -1) {
            return v;
        }
        int v1 = (this.b & 1) == 1 ? g.d(1, this.c) : 0;
        if((this.b & 2) == 2) {
            v1 += g.d(2, this.d);
        }
        if((this.b & 4) == 4) {
            v1 += g.c(3, this.e.a);
        }
        if((this.b & 8) == 8) {
            v1 += g.d(4, this.f);
        }
        if((this.b & 16) == 16) {
            v1 += g.d(5, this.g);
        }
        if((this.b & 0x20) == 0x20) {
            v1 += g.c(6, this.h.a);
        }
        int v2 = this.a.size() + v1;
        this.j = v2;
        return v2;
    }

    @Override  // rf.a
    public final h b() {
        return c0.e();
    }

    @Override  // rf.a
    public final h c() {
        h h0 = c0.e();
        ((c0)h0).f(this);
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
        if((this.b & 4) == 4) {
            g0.C(3, this.e.a);
        }
        if((this.b & 8) == 8) {
            g0.D(4, this.f);
        }
        if((this.b & 16) == 16) {
            g0.D(5, this.g);
        }
        if((this.b & 0x20) == 0x20) {
            g0.C(6, this.h.a);
        }
        g0.I(this.a);
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        if(this.i == 1) {
            return true;
        }
        this.i = 1;
        return true;
    }
}

