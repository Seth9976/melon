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

public final class q extends h implements t {
    public int b;
    public r c;
    public List d;
    public y e;
    public s f;

    @Override  // rf.h
    public final a a() {
        a a0 = this.d();
        if(!((lf.t)a0).isInitialized()) {
            throw new M3(10);
        }
        return a0;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        lf.t t1;
        lf.t t0;
        try {
            try {
                t0 = null;
                lf.t.j.getClass();
                t1 = new lf.t(qb0, f0);
                goto label_14;
            }
            catch(p p0) {
                lf.t t2 = (lf.t)p0.a;
                try {
                    throw p0;
                }
                catch(Throwable throwable0) {
                    t0 = t2;
                }
            }
        }
        catch(Throwable throwable0) {
        }
        if(t0 != null) {
            this.f(t0);
        }
        throw throwable0;
    label_14:
        this.f(t1);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        this.f(((lf.t)m0));
        return this;
    }

    @Override
    public final Object clone() {
        q q0 = q.e();
        q0.f(this.d());
        return q0;
    }

    public final lf.t d() {
        lf.t t0 = new lf.t(this);
        int v = this.b;
        int v1 = (v & 1) == 1 ? 1 : 0;
        t0.c = this.c;
        if((v & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
            this.b &= -3;
        }
        t0.d = this.d;
        if((v & 4) == 4) {
            v1 |= 2;
        }
        t0.e = this.e;
        if((v & 8) == 8) {
            v1 |= 4;
        }
        t0.f = this.f;
        t0.b = v1;
        return t0;
    }

    public static q e() {
        q q0 = new q();  // 初始化器: Lrf/h;-><init>()V
        q0.c = r.b;
        q0.d = Collections.EMPTY_LIST;
        q0.e = y.l;
        q0.f = s.b;
        return q0;
    }

    public final void f(lf.t t0) {
        if(t0 == lf.t.i) {
            return;
        }
        if((t0.b & 1) == 1) {
            r r0 = t0.c;
            r0.getClass();
            this.b |= 1;
            this.c = r0;
        }
        if(!t0.d.isEmpty()) {
            if(this.d.isEmpty()) {
                this.d = t0.d;
                this.b &= -3;
            }
            else {
                if((this.b & 2) != 2) {
                    this.d = new ArrayList(this.d);
                    this.b |= 2;
                }
                this.d.addAll(t0.d);
            }
        }
        if((t0.b & 2) == 2) {
            y y0 = t0.e;
            if((this.b & 4) == 4) {
                y y1 = this.e;
                if(y1 == y.l) {
                    this.e = y0;
                }
                else {
                    w w0 = w.e();
                    w0.f(y1);
                    w0.f(y0);
                    this.e = w0.d();
                }
            }
            else {
                this.e = y0;
            }
            this.b |= 4;
        }
        if((t0.b & 4) == 4) {
            s s0 = t0.f;
            s0.getClass();
            this.b |= 8;
            this.f = s0;
        }
        this.a = this.a.b(t0.a);
    }
}

