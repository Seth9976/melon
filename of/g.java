package of;

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
    public int b;
    public int c;
    public int d;
    public Object e;
    public of.h f;
    public List g;
    public List h;

    @Override  // rf.h
    public final a a() {
        a a0 = this.d();
        ((i)a0).isInitialized();
        return a0;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        i i1;
        i i0;
        try {
            try {
                i0 = null;
                i.n.getClass();
                i1 = new i(qb0);
                goto label_14;
            }
            catch(p p0) {
                i i2 = (i)p0.a;
                try {
                    throw p0;
                }
                catch(Throwable throwable0) {
                    i0 = i2;
                }
            }
        }
        catch(Throwable throwable0) {
        }
        if(i0 != null) {
            this.f(i0);
        }
        throw throwable0;
    label_14:
        this.f(i1);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        this.f(((i)m0));
        return this;
    }

    @Override
    public final Object clone() {
        g g0 = g.e();
        g0.f(this.d());
        return g0;
    }

    public final i d() {
        i i0 = new i(this);
        int v = this.b;
        int v1 = (v & 1) == 1 ? 1 : 0;
        i0.c = this.c;
        if((v & 2) == 2) {
            v1 |= 2;
        }
        i0.d = this.d;
        if((v & 4) == 4) {
            v1 |= 4;
        }
        i0.e = this.e;
        if((v & 8) == 8) {
            v1 |= 8;
        }
        i0.f = this.f;
        if((v & 16) == 16) {
            this.g = Collections.unmodifiableList(this.g);
            this.b &= -17;
        }
        i0.g = this.g;
        if((this.b & 0x20) == 0x20) {
            this.h = Collections.unmodifiableList(this.h);
            this.b &= -33;
        }
        i0.i = this.h;
        i0.b = v1;
        return i0;
    }

    public static g e() {
        g g0 = new g();  // 初始化器: Lrf/h;-><init>()V
        g0.c = 1;
        g0.e = "";
        g0.f = of.h.b;
        g0.g = Collections.EMPTY_LIST;
        g0.h = Collections.EMPTY_LIST;
        return g0;
    }

    public final void f(i i0) {
        if(i0 == i.m) {
            return;
        }
        int v = i0.b;
        if((v & 1) == 1) {
            this.b |= 1;
            this.c = i0.c;
        }
        if((v & 2) == 2) {
            this.b |= 2;
            this.d = i0.d;
        }
        if((v & 4) == 4) {
            this.b |= 4;
            this.e = i0.e;
        }
        if((v & 8) == 8) {
            of.h h0 = i0.f;
            h0.getClass();
            this.b |= 8;
            this.f = h0;
        }
        if(!i0.g.isEmpty()) {
            if(this.g.isEmpty()) {
                this.g = i0.g;
                this.b &= -17;
            }
            else {
                if((this.b & 16) != 16) {
                    this.g = new ArrayList(this.g);
                    this.b |= 16;
                }
                this.g.addAll(i0.g);
            }
        }
        if(!i0.i.isEmpty()) {
            if(this.h.isEmpty()) {
                this.h = i0.i;
                this.b &= -33;
            }
            else {
                if((this.b & 0x20) != 0x20) {
                    this.h = new ArrayList(this.h);
                    this.b |= 0x20;
                }
                this.h.addAll(i0.i);
            }
        }
        this.a = this.a.b(i0.a);
    }
}

