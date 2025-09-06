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
import rf.q;
import rf.r;
import rf.t;

public final class o extends h implements t {
    public final int b;
    public int c;
    public List d;

    public o(int v) {
        this.b = v;
        super();
    }

    @Override  // rf.h
    public final a a() {
        switch(this.b) {
            case 0: {
                a a1 = this.d();
                if(!((p)a1).isInitialized()) {
                    throw new M3(10);
                }
                return a1;
            }
            case 1: {
                a a2 = this.e();
                if(!((M)a2).isInitialized()) {
                    throw new M3(10);
                }
                return a2;
            }
            case 2: {
                a a3 = this.g();
                ((g0)a3).isInitialized();
                return a3;
            }
            default: {
                a a0 = this.f();
                ((N)a0).isInitialized();
                return a0;
            }
        }
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        N n1;
        N n0;
        g0 g01;
        g0 g00;
        M m1;
        M m0;
        p p3;
        p p2;
        switch(this.b) {
            case 0: {
                try {
                    try {
                        p2 = null;
                        p.f.getClass();
                        p3 = new p(qb0, f0);
                        goto label_31;
                    }
                    catch(rf.p p1) {
                        p p4 = (p)p1.a;
                        try {
                            throw p1;
                        }
                        catch(Throwable throwable1) {
                            p2 = p4;
                        }
                    }
                }
                catch(Throwable throwable1) {
                }
                if(p2 != null) {
                    this.h(p2);
                }
                throw throwable1;
            label_31:
                this.h(p3);
                return this;
            }
            case 1: {
                try {
                    try {
                        m0 = null;
                        M.f.getClass();
                        m1 = new M(qb0, f0);
                        goto label_47;
                    }
                    catch(rf.p p5) {
                        M m2 = (M)p5.a;
                        try {
                            throw p5;
                        }
                        catch(Throwable throwable2) {
                            m0 = m2;
                        }
                    }
                }
                catch(Throwable throwable2) {
                }
                if(m0 != null) {
                    this.i(m0);
                }
                throw throwable2;
            label_47:
                this.i(m1);
                return this;
            }
            case 2: {
                try {
                    try {
                        g00 = null;
                        g0.f.getClass();
                        g01 = new g0(qb0, f0);
                        goto label_63;
                    }
                    catch(rf.p p6) {
                        g0 g02 = (g0)p6.a;
                        try {
                            throw p6;
                        }
                        catch(Throwable throwable3) {
                            g00 = g02;
                        }
                    }
                }
                catch(Throwable throwable3) {
                }
                if(g00 != null) {
                    this.k(g00);
                }
                throw throwable3;
            label_63:
                this.k(g01);
                return this;
            }
            default: {
                try {
                    try {
                        n0 = null;
                        N.f.getClass();
                        n1 = new N(qb0);
                        goto label_15;
                    }
                    catch(rf.p p0) {
                        N n2 = (N)p0.a;
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
                    this.j(n0);
                }
                throw throwable0;
            label_15:
                this.j(n1);
                return this;
            }
        }
    }

    @Override  // rf.h
    public final h c(m m0) {
        switch(this.b) {
            case 0: {
                this.h(((p)m0));
                return this;
            }
            case 1: {
                this.i(((M)m0));
                return this;
            }
            case 2: {
                this.k(((g0)m0));
                return this;
            }
            default: {
                this.j(((N)m0));
                return this;
            }
        }
    }

    @Override
    public final Object clone() {
        switch(this.b) {
            case 0: {
                o o1 = new o(0);
                o1.d = Collections.EMPTY_LIST;
                o1.h(this.d());
                return o1;
            }
            case 1: {
                o o2 = new o(1);
                o2.d = Collections.EMPTY_LIST;
                o2.i(this.e());
                return o2;
            }
            case 2: {
                o o3 = new o(2);
                o3.d = Collections.EMPTY_LIST;
                o3.k(this.g());
                return o3;
            }
            default: {
                o o0 = new o(3);
                o0.d = q.b;
                o0.j(this.f());
                return o0;
            }
        }
    }

    public p d() {
        p p0 = new p(this);
        if((this.c & 1) == 1) {
            this.d = Collections.unmodifiableList(this.d);
            this.c &= -2;
        }
        p0.b = this.d;
        return p0;
    }

    public M e() {
        M m0 = new M(this);
        if((this.c & 1) == 1) {
            this.d = Collections.unmodifiableList(this.d);
            this.c &= -2;
        }
        m0.b = this.d;
        return m0;
    }

    public N f() {
        N n0 = new N(this);
        if((this.c & 1) == 1) {
            this.d = ((r)this.d).a0();
            this.c &= -2;
        }
        n0.b = (r)this.d;
        return n0;
    }

    public g0 g() {
        g0 g00 = new g0(this);
        if((this.c & 1) == 1) {
            this.d = Collections.unmodifiableList(this.d);
            this.c &= -2;
        }
        g00.b = this.d;
        return g00;
    }

    public void h(p p0) {
        if(p0 == p.e) {
            return;
        }
        if(!p0.b.isEmpty()) {
            if(this.d.isEmpty()) {
                this.d = p0.b;
                this.c &= -2;
            }
            else {
                if((this.c & 1) != 1) {
                    this.d = new ArrayList(this.d);
                    this.c |= 1;
                }
                this.d.addAll(p0.b);
            }
        }
        this.a = this.a.b(p0.a);
    }

    public void i(M m0) {
        if(m0 == M.e) {
            return;
        }
        if(!m0.b.isEmpty()) {
            if(this.d.isEmpty()) {
                this.d = m0.b;
                this.c &= -2;
            }
            else {
                if((this.c & 1) != 1) {
                    this.d = new ArrayList(this.d);
                    this.c |= 1;
                }
                this.d.addAll(m0.b);
            }
        }
        this.a = this.a.b(m0.a);
    }

    public void j(N n0) {
        if(n0 == N.e) {
            return;
        }
        if(!n0.b.isEmpty()) {
            if(((r)this.d).isEmpty()) {
                this.d = n0.b;
                this.c &= -2;
            }
            else {
                if((this.c & 1) != 1) {
                    this.d = new q(((r)this.d));
                    this.c |= 1;
                }
                ((r)this.d).addAll(n0.b);
            }
        }
        this.a = this.a.b(n0.a);
    }

    public void k(g0 g00) {
        if(g00 == g0.e) {
            return;
        }
        if(!g00.b.isEmpty()) {
            if(this.d.isEmpty()) {
                this.d = g00.b;
                this.c &= -2;
            }
            else {
                if((this.c & 1) != 1) {
                    this.d = new ArrayList(this.d);
                    this.c |= 1;
                }
                this.d.addAll(g00.b);
            }
        }
        this.a = this.a.b(g00.a);
    }
}

