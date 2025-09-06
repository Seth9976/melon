package lf;

import i.n.i.b.a.s.e.qb;
import rf.a;
import rf.f;
import rf.h;
import rf.m;
import rf.p;
import rf.t;

public final class c0 extends h implements t {
    public int b;
    public int c;
    public int d;
    public d0 e;
    public int f;
    public int g;
    public e0 h;

    @Override  // rf.h
    public final a a() {
        a a0 = this.d();
        ((f0)a0).isInitialized();
        return a0;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        f0 f01;
        f0 f00;
        try {
            try {
                f00 = null;
                f0.l.getClass();
                f01 = new f0(qb0);
                goto label_14;
            }
            catch(p p0) {
                f0 f02 = (f0)p0.a;
                try {
                    throw p0;
                }
                catch(Throwable throwable0) {
                    f00 = f02;
                }
            }
        }
        catch(Throwable throwable0) {
        }
        if(f00 != null) {
            this.f(f00);
        }
        throw throwable0;
    label_14:
        this.f(f01);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        this.f(((f0)m0));
        return this;
    }

    @Override
    public final Object clone() {
        c0 c00 = c0.e();
        c00.f(this.d());
        return c00;
    }

    public final f0 d() {
        f0 f00 = new f0(this);
        int v = this.b;
        int v1 = (v & 1) == 1 ? 1 : 0;
        f00.c = this.c;
        if((v & 2) == 2) {
            v1 |= 2;
        }
        f00.d = this.d;
        if((v & 4) == 4) {
            v1 |= 4;
        }
        f00.e = this.e;
        if((v & 8) == 8) {
            v1 |= 8;
        }
        f00.f = this.f;
        if((v & 16) == 16) {
            v1 |= 16;
        }
        f00.g = this.g;
        if((v & 0x20) == 0x20) {
            v1 |= 0x20;
        }
        f00.h = this.h;
        f00.b = v1;
        return f00;
    }

    public static c0 e() {
        c0 c00 = new c0();  // 初始化器: Lrf/h;-><init>()V
        c00.e = d0.c;
        c00.h = e0.b;
        return c00;
    }

    public final void f(f0 f00) {
        if(f00 == f0.k) {
            return;
        }
        int v = f00.b;
        if((v & 1) == 1) {
            this.b |= 1;
            this.c = f00.c;
        }
        if((v & 2) == 2) {
            this.b |= 2;
            this.d = f00.d;
        }
        if((v & 4) == 4) {
            d0 d00 = f00.e;
            d00.getClass();
            this.b |= 4;
            this.e = d00;
        }
        int v1 = f00.b;
        if((v1 & 8) == 8) {
            this.b |= 8;
            this.f = f00.f;
        }
        if((v1 & 16) == 16) {
            this.b |= 16;
            this.g = f00.g;
        }
        if((v1 & 0x20) == 0x20) {
            e0 e00 = f00.h;
            e00.getClass();
            this.b |= 0x20;
            this.h = e00;
        }
        this.a = this.a.b(f00.a);
    }
}

