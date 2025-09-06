package lf;

import i.n.i.b.a.s.e.qb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rf.c;
import rf.d;
import rf.f;
import rf.m;
import rf.p;

public final class e extends m {
    public final d a;
    public int b;
    public lf.d c;
    public long d;
    public float e;
    public double f;
    public int g;
    public int h;
    public int i;
    public h j;
    public List k;
    public int l;
    public int m;
    public byte n;
    public int o;
    public static final e r;
    public static final a w;

    static {
        e.w = new a(2);
        e e0 = new e();
        e.r = e0;
        e0.g();
    }

    public e() {
        this.n = -1;
        this.o = -1;
        this.a = d.a;
    }

    public e(qb qb0, f f0) {
        g g1;
        this.n = -1;
        this.o = -1;
        this.g();
        c c0 = new c();
        A3.g g0 = A3.g.w(c0, 1);
        int v = 0;
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
                            int v2 = qb0.n();
                            lf.d d0 = lf.d.b(v2);
                            if(d0 == null) {
                                g0.M(8);
                                g0.M(v2);
                            }
                            else {
                                this.b |= 1;
                                this.c = d0;
                            }
                            continue;
                        }
                        case 16: {
                            this.b |= 2;
                            long v3 = qb0.o();
                            this.d = -(v3 & 1L) ^ v3 >>> 1;
                            continue;
                        }
                        case 29: {
                            this.b |= 4;
                            this.e = Float.intBitsToFloat(qb0.l());
                            continue;
                        }
                        case 33: {
                            this.b |= 8;
                            this.f = Double.longBitsToDouble(qb0.m());
                            continue;
                        }
                        case 40: {
                            this.b |= 16;
                            this.g = qb0.n();
                            continue;
                        }
                        case 0x30: {
                            this.b |= 0x20;
                            this.h = qb0.n();
                            continue;
                        }
                        case 56: {
                            this.b |= 0x40;
                            this.i = qb0.n();
                            continue;
                        }
                        case 66: {
                            if((this.b & 0x80) == 0x80) {
                                h h0 = this.j;
                                h0.getClass();
                                g1 = new g(0);
                                g1.d = Collections.EMPTY_LIST;
                                g1.g(h0);
                            }
                            else {
                                g1 = null;
                            }
                            h h1 = (h)qb0.j(h.h, f0);
                            this.j = h1;
                            if(g1 != null) {
                                g1.g(h1);
                                this.j = g1.d();
                            }
                            this.b |= 0x80;
                            continue;
                        }
                        case 74: {
                            if((v & 0x100) != 0x100) {
                                this.k = new ArrayList();
                                v = 0x100;
                            }
                            this.k.add(qb0.j(e.w, f0));
                            continue;
                        }
                        case 80: {
                            this.b |= 0x200;
                            this.m = qb0.n();
                            continue;
                        }
                        case 88: {
                            this.b |= 0x100;
                            this.l = qb0.n();
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
                    goto label_75;
                }
                p0.a = this;
                throw p0;
            label_75:
                p p1 = new p(iOException0.getMessage());
                p1.a = this;
                throw p1;
            }
            catch(Throwable throwable0) {
            }
            if((v & 0x100) == 0x100) {
                this.k = Collections.unmodifiableList(this.k);
            }
            try {
                g0.k();
                this.a = c0.m();
                throw throwable0;
            }
            catch(IOException unused_ex) {
                this.a = c0.m();
                throw throwable0;
            }
            catch(Throwable throwable1) {
            }
            this.a = c0.m();
            throw throwable1;
        }
        if((v & 0x100) == 0x100) {
            this.k = Collections.unmodifiableList(this.k);
        }
        try {
            g0.k();
            this.a = c0.m();
            return;
        }
        catch(IOException unused_ex) {
            this.a = c0.m();
            return;
        }
        catch(Throwable throwable2) {
        }
        this.a = c0.m();
        throw throwable2;
    }

    public e(lf.c c0) {
        this.n = -1;
        this.o = -1;
        this.a = c0.a;
    }

    @Override  // rf.a
    public final int a() {
        int v1 = this.o;
        if(v1 != -1) {
            return v1;
        }
        int v2 = (this.b & 1) == 1 ? A3.g.c(1, this.c.a) : 0;
        if((this.b & 2) == 2) {
            v2 += A3.g.i(this.d >> 0x3F ^ this.d << 1) + 1;
        }
        if((this.b & 4) == 4) {
            v2 += 5;
        }
        if((this.b & 8) == 8) {
            v2 += 9;
        }
        if((this.b & 16) == 16) {
            v2 += A3.g.d(5, this.g);
        }
        if((this.b & 0x20) == 0x20) {
            v2 += A3.g.d(6, this.h);
        }
        if((this.b & 0x40) == 0x40) {
            v2 += A3.g.d(7, this.i);
        }
        if((this.b & 0x80) == 0x80) {
            v2 += A3.g.f(8, this.j);
        }
        for(int v = 0; v < this.k.size(); ++v) {
            v2 += A3.g.f(9, ((rf.a)this.k.get(v)));
        }
        if((this.b & 0x200) == 0x200) {
            v2 += A3.g.d(10, this.m);
        }
        if((this.b & 0x100) == 0x100) {
            v2 += A3.g.d(11, this.l);
        }
        int v3 = this.a.size() + v2;
        this.o = v3;
        return v3;
    }

    @Override  // rf.a
    public final rf.h b() {
        return lf.c.e();
    }

    @Override  // rf.a
    public final rf.h c() {
        return e.h(this);
    }

    @Override  // rf.a
    public final void d(A3.g g0) {
        this.a();
        if((this.b & 1) == 1) {
            g0.C(1, this.c.a);
        }
        if((this.b & 2) == 2) {
            long v1 = this.d;
            g0.O(2, 0);
            g0.N(v1 >> 0x3F ^ v1 << 1);
        }
        if((this.b & 4) == 4) {
            float f = this.e;
            g0.O(3, 5);
            g0.K(Float.floatToRawIntBits(f));
        }
        if((this.b & 8) == 8) {
            double f1 = this.f;
            g0.O(4, 1);
            g0.L(Double.doubleToRawLongBits(f1));
        }
        if((this.b & 16) == 16) {
            g0.D(5, this.g);
        }
        if((this.b & 0x20) == 0x20) {
            g0.D(6, this.h);
        }
        if((this.b & 0x40) == 0x40) {
            g0.D(7, this.i);
        }
        if((this.b & 0x80) == 0x80) {
            g0.F(8, this.j);
        }
        for(int v = 0; v < this.k.size(); ++v) {
            g0.F(9, ((rf.a)this.k.get(v)));
        }
        if((this.b & 0x200) == 0x200) {
            g0.D(10, this.m);
        }
        if((this.b & 0x100) == 0x100) {
            g0.D(11, this.l);
        }
        g0.I(this.a);
    }

    public final void g() {
        this.c = lf.d.b;
        this.d = 0L;
        this.e = 0.0f;
        this.f = 0.0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = h.g;
        this.k = Collections.EMPTY_LIST;
        this.l = 0;
        this.m = 0;
    }

    public static lf.c h(e e0) {
        lf.c c0 = lf.c.e();
        c0.f(e0);
        return c0;
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        int v = this.n;
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        if((this.b & 0x80) == 0x80 && !this.j.isInitialized()) {
            this.n = 0;
            return false;
        }
        for(int v1 = 0; v1 < this.k.size(); ++v1) {
            if(!((e)this.k.get(v1)).isInitialized()) {
                this.n = 0;
                return false;
            }
        }
        this.n = 1;
        return true;
    }
}

