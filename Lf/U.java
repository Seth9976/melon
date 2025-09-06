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
import rf.m;
import rf.p;

public final class u extends i {
    public int d;
    public int e;
    public List f;

    @Override  // rf.h
    public final a a() {
        a a0 = this.e();
        if(!((v)a0).isInitialized()) {
            throw new M3(10);
        }
        return a0;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        v v1;
        v v0;
        try {
            try {
                v0 = null;
                v.i.getClass();
                v1 = new v(qb0, f0);
                goto label_14;
            }
            catch(p p0) {
                v v2 = (v)p0.a;
                try {
                    throw p0;
                }
                catch(Throwable throwable0) {
                    v0 = v2;
                }
            }
        }
        catch(Throwable throwable0) {
        }
        if(v0 != null) {
            this.f(v0);
        }
        throw throwable0;
    label_14:
        this.f(v1);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        this.f(((v)m0));
        return this;
    }

    @Override
    public final Object clone() {
        u u0 = new u();  // 初始化器: Lrf/i;-><init>()V
        u0.f = Collections.EMPTY_LIST;
        u0.f(this.e());
        return u0;
    }

    public final v e() {
        v v0 = new v(this);
        int v1 = this.d;
        v0.d = this.e;
        if((v1 & 2) == 2) {
            this.f = Collections.unmodifiableList(this.f);
            this.d &= -3;
        }
        v0.e = this.f;
        v0.c = (v1 & 1) == 1 ? 1 : 0;
        return v0;
    }

    public final void f(v v0) {
        if(v0 == v.h) {
            return;
        }
        if((v0.c & 1) == 1) {
            int v1 = v0.d;
            this.d |= 1;
            this.e = v1;
        }
        if(!v0.e.isEmpty()) {
            if(this.f.isEmpty()) {
                this.f = v0.e;
                this.d &= -3;
            }
            else {
                if((this.d & 2) != 2) {
                    this.f = new ArrayList(this.f);
                    this.d |= 2;
                }
                this.f.addAll(v0.e);
            }
        }
        this.d(v0);
        this.a = this.a.b(v0.b);
    }
}

