package lf;

import i.n.i.b.a.s.e.M3;
import i.n.i.b.a.s.e.qb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rf.a;
import rf.f;
import rf.h;
import rf.i;
import rf.p;

public final class m extends i {
    public int d;
    public int e;
    public List f;
    public List g;
    public List h;
    public List i;

    @Override  // rf.h
    public final a a() {
        a a0 = this.e();
        if(!((n)a0).isInitialized()) {
            throw new M3(10);
        }
        return a0;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        n n1;
        n n0;
        try {
            try {
                n0 = null;
                n.l.getClass();
                n1 = new n(qb0, f0);
                goto label_14;
            }
            catch(p p0) {
                n n2 = (n)p0.a;
                try {
                    throw p0;
                }
                catch(Throwable throwable0) {
                    n0 = n2;
                }
            }
        }
        catch(Throwable throwable0) {
        }
        if(n0 != null) {
            this.g(n0);
        }
        throw throwable0;
    label_14:
        this.g(n1);
        return this;
    }

    @Override  // rf.h
    public final h c(rf.m m0) {
        this.g(((n)m0));
        return this;
    }

    @Override
    public final Object clone() {
        m m0 = m.f();
        m0.g(this.e());
        return m0;
    }

    public final n e() {
        n n0 = new n(this);
        int v = this.d;
        n0.d = this.e;
        if((v & 2) == 2) {
            this.f = Collections.unmodifiableList(this.f);
            this.d &= -3;
        }
        n0.e = this.f;
        if((this.d & 4) == 4) {
            this.g = Collections.unmodifiableList(this.g);
            this.d &= -5;
        }
        n0.f = this.g;
        if((this.d & 8) == 8) {
            this.h = Collections.unmodifiableList(this.h);
            this.d &= -9;
        }
        n0.g = this.h;
        if((this.d & 16) == 16) {
            this.i = Collections.unmodifiableList(this.i);
            this.d &= -17;
        }
        n0.h = this.i;
        n0.c = (v & 1) == 1 ? 1 : 0;
        return n0;
    }

    public static m f() {
        m m0 = new m();  // 初始化器: Lrf/i;-><init>()V
        m0.e = 6;
        m0.f = Collections.EMPTY_LIST;
        m0.g = Collections.EMPTY_LIST;
        m0.h = Collections.EMPTY_LIST;
        m0.i = Collections.EMPTY_LIST;
        return m0;
    }

    public final void g(n n0) {
        if(n0 == n.k) {
            return;
        }
        if((n0.c & 1) == 1) {
            int v = n0.d;
            this.d |= 1;
            this.e = v;
        }
        if(!n0.e.isEmpty()) {
            if(this.f.isEmpty()) {
                this.f = n0.e;
                this.d &= -3;
            }
            else {
                if((this.d & 2) != 2) {
                    this.f = new ArrayList(this.f);
                    this.d |= 2;
                }
                this.f.addAll(n0.e);
            }
        }
        if(!n0.f.isEmpty()) {
            if(this.g.isEmpty()) {
                this.g = n0.f;
                this.d &= -5;
            }
            else {
                if((this.d & 4) != 4) {
                    this.g = new ArrayList(this.g);
                    this.d |= 4;
                }
                this.g.addAll(n0.f);
            }
        }
        if(!n0.g.isEmpty()) {
            if(this.h.isEmpty()) {
                this.h = n0.g;
                this.d &= -9;
            }
            else {
                if((this.d & 8) != 8) {
                    this.h = new ArrayList(this.h);
                    this.d |= 8;
                }
                this.h.addAll(n0.g);
            }
        }
        if(!n0.h.isEmpty()) {
            if(this.i.isEmpty()) {
                this.i = n0.h;
                this.d &= -17;
            }
            else {
                if((this.d & 16) != 16) {
                    this.i = new ArrayList(this.i);
                    this.d |= 16;
                }
                this.i.addAll(n0.h);
            }
        }
        this.d(n0);
        this.a = this.a.b(n0.b);
    }
}

