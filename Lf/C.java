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

public final class c extends h implements t {
    public int b;
    public d c;
    public long d;
    public float e;
    public double f;
    public int g;
    public int h;
    public int i;
    public lf.h j;
    public List k;
    public int l;
    public int m;

    @Override  // rf.h
    public final a a() {
        a a0 = this.d();
        if(!((e)a0).isInitialized()) {
            throw new M3(10);
        }
        return a0;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        e e1;
        e e0;
        try {
            try {
                e0 = null;
                e.w.getClass();
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
        c c0 = c.e();
        c0.f(this.d());
        return c0;
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
        if((v & 0x20) == 0x20) {
            v1 |= 0x20;
        }
        e0.h = this.h;
        if((v & 0x40) == 0x40) {
            v1 |= 0x40;
        }
        e0.i = this.i;
        if((v & 0x80) == 0x80) {
            v1 |= 0x80;
        }
        e0.j = this.j;
        if((v & 0x100) == 0x100) {
            this.k = Collections.unmodifiableList(this.k);
            this.b &= 0xFFFFFEFF;
        }
        e0.k = this.k;
        if((v & 0x200) == 0x200) {
            v1 |= 0x100;
        }
        e0.l = this.l;
        if((v & 0x400) == 0x400) {
            v1 |= 0x200;
        }
        e0.m = this.m;
        e0.b = v1;
        return e0;
    }

    public static c e() {
        c c0 = new c();  // 初始化器: Lrf/h;-><init>()V
        c0.c = d.b;
        c0.j = lf.h.g;
        c0.k = Collections.EMPTY_LIST;
        return c0;
    }

    public final void f(e e0) {
        if(e0 == e.r) {
            return;
        }
        if((e0.b & 1) == 1) {
            d d0 = e0.c;
            d0.getClass();
            this.b |= 1;
            this.c = d0;
        }
        int v = e0.b;
        if((v & 2) == 2) {
            this.b |= 2;
            this.d = e0.d;
        }
        if((v & 4) == 4) {
            this.b |= 4;
            this.e = e0.e;
        }
        if((v & 8) == 8) {
            this.b |= 8;
            this.f = e0.f;
        }
        if((v & 16) == 16) {
            this.b |= 16;
            this.g = e0.g;
        }
        if((v & 0x20) == 0x20) {
            this.b |= 0x20;
            this.h = e0.h;
        }
        if((v & 0x40) == 0x40) {
            this.b |= 0x40;
            this.i = e0.i;
        }
        if((v & 0x80) == 0x80) {
            lf.h h0 = e0.j;
            if((this.b & 0x80) == 0x80) {
                lf.h h1 = this.j;
                if(h1 == lf.h.g) {
                    this.j = h0;
                }
                else {
                    g g0 = new g(0);
                    g0.d = Collections.EMPTY_LIST;
                    g0.g(h1);
                    g0.g(h0);
                    this.j = g0.d();
                }
            }
            else {
                this.j = h0;
            }
            this.b |= 0x80;
        }
        if(!e0.k.isEmpty()) {
            if(this.k.isEmpty()) {
                this.k = e0.k;
                this.b &= 0xFFFFFEFF;
            }
            else {
                if((this.b & 0x100) != 0x100) {
                    this.k = new ArrayList(this.k);
                    this.b |= 0x100;
                }
                this.k.addAll(e0.k);
            }
        }
        int v1 = e0.b;
        if((v1 & 0x100) == 0x100) {
            this.b |= 0x200;
            this.l = e0.l;
        }
        if((v1 & 0x200) == 0x200) {
            this.b |= 0x400;
            this.m = e0.m;
        }
        this.a = this.a.b(e0.a);
    }
}

