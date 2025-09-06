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

public final class w extends h implements t {
    public int b;
    public int c;
    public int d;
    public x e;
    public T f;
    public int g;
    public List h;
    public List i;

    @Override  // rf.h
    public final a a() {
        a a0 = this.d();
        if(!((y)a0).isInitialized()) {
            throw new M3(10);
        }
        return a0;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        y y1;
        y y0;
        try {
            try {
                y0 = null;
                y.m.getClass();
                y1 = new y(qb0, f0);
                goto label_14;
            }
            catch(p p0) {
                y y2 = (y)p0.a;
                try {
                    throw p0;
                }
                catch(Throwable throwable0) {
                    y0 = y2;
                }
            }
        }
        catch(Throwable throwable0) {
        }
        if(y0 != null) {
            this.f(y0);
        }
        throw throwable0;
    label_14:
        this.f(y1);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        this.f(((y)m0));
        return this;
    }

    @Override
    public final Object clone() {
        w w0 = w.e();
        w0.f(this.d());
        return w0;
    }

    public final y d() {
        y y0 = new y(this);
        int v = this.b;
        int v1 = (v & 1) == 1 ? 1 : 0;
        y0.c = this.c;
        if((v & 2) == 2) {
            v1 |= 2;
        }
        y0.d = this.d;
        if((v & 4) == 4) {
            v1 |= 4;
        }
        y0.e = this.e;
        if((v & 8) == 8) {
            v1 |= 8;
        }
        y0.f = this.f;
        if((v & 16) == 16) {
            v1 |= 16;
        }
        y0.g = this.g;
        if((v & 0x20) == 0x20) {
            this.h = Collections.unmodifiableList(this.h);
            this.b &= -33;
        }
        y0.h = this.h;
        if((this.b & 0x40) == 0x40) {
            this.i = Collections.unmodifiableList(this.i);
            this.b &= -65;
        }
        y0.i = this.i;
        y0.b = v1;
        return y0;
    }

    public static w e() {
        w w0 = new w();  // 初始化器: Lrf/h;-><init>()V
        w0.e = x.b;
        w0.f = T.E;
        w0.h = Collections.EMPTY_LIST;
        w0.i = Collections.EMPTY_LIST;
        return w0;
    }

    public final void f(y y0) {
        if(y0 == y.l) {
            return;
        }
        int v = y0.b;
        if((v & 1) == 1) {
            this.b |= 1;
            this.c = y0.c;
        }
        if((v & 2) == 2) {
            this.b |= 2;
            this.d = y0.d;
        }
        if((v & 4) == 4) {
            x x0 = y0.e;
            x0.getClass();
            this.b |= 4;
            this.e = x0;
        }
        if((y0.b & 8) == 8) {
            T t0 = y0.f;
            if((this.b & 8) == 8) {
                T t1 = this.f;
                if(t1 == T.E) {
                    this.f = t0;
                }
                else {
                    S s0 = T.p(t1);
                    s0.g(t0);
                    this.f = s0.e();
                }
            }
            else {
                this.f = t0;
            }
            this.b |= 8;
        }
        if((y0.b & 16) == 16) {
            this.b |= 16;
            this.g = y0.g;
        }
        if(!y0.h.isEmpty()) {
            if(this.h.isEmpty()) {
                this.h = y0.h;
                this.b &= -33;
            }
            else {
                if((this.b & 0x20) != 0x20) {
                    this.h = new ArrayList(this.h);
                    this.b |= 0x20;
                }
                this.h.addAll(y0.h);
            }
        }
        if(!y0.i.isEmpty()) {
            if(this.i.isEmpty()) {
                this.i = y0.i;
                this.b &= -65;
            }
            else {
                if((this.b & 0x40) != 0x40) {
                    this.i = new ArrayList(this.i);
                    this.b |= 0x40;
                }
                this.i.addAll(y0.i);
            }
        }
        this.a = this.a.b(y0.a);
    }
}

