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

public final class a0 extends i {
    public int d;
    public int e;
    public int f;
    public T g;
    public int h;
    public T i;
    public int j;
    public List k;
    public e l;

    @Override  // rf.h
    public final a a() {
        a a0 = this.e();
        if(!((b0)a0).isInitialized()) {
            throw new M3(10);
        }
        return a0;
    }

    @Override  // rf.h
    public final h b(qb qb0, f f0) {
        b0 b01;
        b0 b00;
        try {
            try {
                b00 = null;
                b0.o.getClass();
                b01 = new b0(qb0, f0);
                goto label_14;
            }
            catch(p p0) {
                b0 b02 = (b0)p0.a;
                try {
                    throw p0;
                }
                catch(Throwable throwable0) {
                    b00 = b02;
                }
            }
        }
        catch(Throwable throwable0) {
        }
        if(b00 != null) {
            this.g(b00);
        }
        throw throwable0;
    label_14:
        this.g(b01);
        return this;
    }

    @Override  // rf.h
    public final h c(m m0) {
        this.g(((b0)m0));
        return this;
    }

    @Override
    public final Object clone() {
        a0 a00 = a0.f();
        a00.g(this.e());
        return a00;
    }

    public final b0 e() {
        b0 b00 = new b0(this);
        int v = this.d;
        int v1 = (v & 1) == 1 ? 1 : 0;
        b00.d = this.e;
        if((v & 2) == 2) {
            v1 |= 2;
        }
        b00.e = this.f;
        if((v & 4) == 4) {
            v1 |= 4;
        }
        b00.f = this.g;
        if((v & 8) == 8) {
            v1 |= 8;
        }
        b00.g = this.h;
        if((v & 16) == 16) {
            v1 |= 16;
        }
        b00.h = this.i;
        if((v & 0x20) == 0x20) {
            v1 |= 0x20;
        }
        b00.i = this.j;
        if((v & 0x40) == 0x40) {
            this.k = Collections.unmodifiableList(this.k);
            this.d &= -65;
        }
        b00.j = this.k;
        if((v & 0x80) == 0x80) {
            v1 |= 0x40;
        }
        b00.k = this.l;
        b00.c = v1;
        return b00;
    }

    public static a0 f() {
        a0 a00 = new a0();  // 初始化器: Lrf/i;-><init>()V
        a00.g = T.E;
        a00.i = T.E;
        a00.k = Collections.EMPTY_LIST;
        a00.l = e.r;
        return a00;
    }

    public final void g(b0 b00) {
        if(b00 == b0.n) {
            return;
        }
        int v = b00.c;
        if((v & 1) == 1) {
            int v1 = b00.d;
            this.d |= 1;
            this.e = v1;
        }
        if((v & 2) == 2) {
            this.d |= 2;
            this.f = b00.e;
        }
        if((v & 4) == 4) {
            T t0 = b00.f;
            if((this.d & 4) == 4) {
                T t1 = this.g;
                if(t1 == T.E) {
                    this.g = t0;
                }
                else {
                    S s0 = T.p(t1);
                    s0.g(t0);
                    this.g = s0.e();
                }
            }
            else {
                this.g = t0;
            }
            this.d |= 4;
        }
        int v2 = b00.c;
        if((v2 & 8) == 8) {
            this.d |= 8;
            this.h = b00.g;
        }
        if((v2 & 16) == 16) {
            T t2 = b00.h;
            if((this.d & 16) == 16) {
                T t3 = this.i;
                if(t3 == T.E) {
                    this.i = t2;
                }
                else {
                    S s1 = T.p(t3);
                    s1.g(t2);
                    this.i = s1.e();
                }
            }
            else {
                this.i = t2;
            }
            this.d |= 16;
        }
        if((b00.c & 0x20) == 0x20) {
            this.d |= 0x20;
            this.j = b00.i;
        }
        if(!b00.j.isEmpty()) {
            if(this.k.isEmpty()) {
                this.k = b00.j;
                this.d &= -65;
            }
            else {
                if((this.d & 0x40) != 0x40) {
                    this.k = new ArrayList(this.k);
                    this.d |= 0x40;
                }
                this.k.addAll(b00.j);
            }
        }
        if((b00.c & 0x40) == 0x40) {
            e e0 = b00.k;
            if((this.d & 0x80) == 0x80) {
                e e1 = this.l;
                if(e1 == e.r) {
                    this.l = e0;
                }
                else {
                    c c0 = e.h(e1);
                    c0.f(e0);
                    this.l = c0.d();
                }
            }
            else {
                this.l = e0;
            }
            this.d |= 0x80;
        }
        this.d(b00);
        this.a = this.a.b(b00.b);
    }
}

