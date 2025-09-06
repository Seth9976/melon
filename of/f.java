package of;

import i.n.i.b.a.s.e.qb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rf.a;
import rf.h;
import rf.m;
import rf.p;
import rf.t;

public final class f extends h implements t {
    public int b;
    public List c;
    public List d;

    @Override  // rf.h
    public final a a() {
        a a0 = this.d();
        ((j)a0).isInitialized();
        return a0;
    }

    @Override  // rf.h
    public final h b(qb qb0, rf.f f0) {
        j j1;
        j j0;
        try {
            try {
                j0 = null;
                j.h.getClass();
                j1 = new j(qb0, f0);
                goto label_14;
            }
            catch(p p0) {
                j j2 = (j)p0.a;
                try {
                    throw p0;
                }
                catch(Throwable throwable0) {
                    j0 = j2;
                }
            }
        }
        catch(Throwable throwable0) {
        }
        if(j0 != null) {
            this.e(j0);
        }
        throw throwable0;
    label_14:
        this.e(j1);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        this.e(((j)m0));
        return this;
    }

    @Override
    public final Object clone() {
        f f0 = new f();  // 初始化器: Lrf/h;-><init>()V
        f0.c = Collections.EMPTY_LIST;
        f0.d = Collections.EMPTY_LIST;
        f0.e(this.d());
        return f0;
    }

    public final j d() {
        j j0 = new j(this);
        if((this.b & 1) == 1) {
            this.c = Collections.unmodifiableList(this.c);
            this.b &= -2;
        }
        j0.b = this.c;
        if((this.b & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
            this.b &= -3;
        }
        j0.c = this.d;
        return j0;
    }

    public final void e(j j0) {
        if(j0 == j.g) {
            return;
        }
        if(!j0.b.isEmpty()) {
            if(this.c.isEmpty()) {
                this.c = j0.b;
                this.b &= -2;
            }
            else {
                if((this.b & 1) != 1) {
                    this.c = new ArrayList(this.c);
                    this.b |= 1;
                }
                this.c.addAll(j0.b);
            }
        }
        if(!j0.c.isEmpty()) {
            if(this.d.isEmpty()) {
                this.d = j0.c;
                this.b &= -3;
            }
            else {
                if((this.b & 2) != 2) {
                    this.d = new ArrayList(this.d);
                    this.b |= 2;
                }
                this.d.addAll(j0.c);
            }
        }
        this.a = this.a.b(j0.a);
    }
}

