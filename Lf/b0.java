package lf;

import A3.g;
import d5.v;
import i.n.i.b.a.s.e.qb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rf.c;
import rf.d;
import rf.f;
import rf.j;
import rf.p;

public final class b0 extends j {
    public final d b;
    public int c;
    public int d;
    public int e;
    public T f;
    public int g;
    public T h;
    public int i;
    public List j;
    public e k;
    public byte l;
    public int m;
    public static final b0 n;
    public static final a o;

    static {
        b0.o = new a(22);
        b0 b00 = new b0();
        b0.n = b00;
        b00.d = 0;
        b00.e = 0;
        b00.f = T.E;
        b00.g = 0;
        b00.h = T.E;
        b00.i = 0;
        b00.j = Collections.EMPTY_LIST;
        b00.k = e.r;
    }

    public b0() {
        this.l = -1;
        this.m = -1;
        this.b = d.a;
    }

    public b0(qb qb0, f f0) {
        this.l = -1;
        this.m = -1;
        this.d = 0;
        this.e = 0;
        this.f = T.E;
        this.g = 0;
        this.h = T.E;
        this.i = 0;
        this.j = Collections.EMPTY_LIST;
        this.k = e.r;
        c c0 = new c();
        g g0 = g.w(c0, 1);
        int v = 0;
        boolean z = false;
        while(!z) {
            try {
                int v1 = qb0.q();
                switch(v1) {
                    case 0: {
                        z = true;
                        break;
                    }
                    case 8: {
                        this.c |= 1;
                        this.d = qb0.n();
                        continue;
                    }
                    default: {
                        S s0 = null;
                        switch(v1) {
                            case 16: {
                                this.c |= 2;
                                this.e = qb0.n();
                                break;
                            }
                            case 26: {
                                if((this.c & 4) == 4) {
                                    T t0 = this.f;
                                    t0.getClass();
                                    s0 = T.p(t0);
                                }
                                T t1 = (T)qb0.j(T.G, f0);
                                this.f = t1;
                                if(s0 != null) {
                                    s0.g(t1);
                                    this.f = s0.e();
                                }
                                this.c |= 4;
                                break;
                            }
                            case 34: {
                                if((this.c & 16) == 16) {
                                    T t2 = this.h;
                                    t2.getClass();
                                    s0 = T.p(t2);
                                }
                                T t3 = (T)qb0.j(T.G, f0);
                                this.h = t3;
                                if(s0 != null) {
                                    s0.g(t3);
                                    this.h = s0.e();
                                }
                                this.c |= 16;
                                break;
                            }
                            case 40: {
                                this.c |= 8;
                                this.g = qb0.n();
                                break;
                            }
                            case 0x30: {
                                this.c |= 0x20;
                                this.i = qb0.n();
                                break;
                            }
                            case 58: {
                                if((v & 0x40) != 0x40) {
                                    this.j = new ArrayList();
                                    v = 0x40;
                                }
                                this.j.add(qb0.j(h.h, f0));
                                break;
                            }
                            case 66: {
                                if((this.c & 0x40) == 0x40) {
                                    e e0 = this.k;
                                    e0.getClass();
                                    s0 = e.h(e0);
                                }
                                e e1 = (e)qb0.j(e.w, f0);
                                this.k = e1;
                                if(s0 != null) {
                                    ((lf.c)s0).f(e1);
                                    this.k = ((lf.c)s0).d();
                                }
                                this.c |= 0x40;
                                break;
                            }
                            default: {
                                if(this.l(qb0, g0, f0, v1)) {
                                    break;
                                }
                                z = true;
                                break;
                            }
                        }
                    }
                }
            }
            catch(p p0) {
                p0.a = this;
                throw p0;
            }
            catch(IOException iOException0) {
                goto label_89;
            }
            catch(Throwable throwable0) {
                goto label_92;
            }
            continue;
            try {
                try {
                    this.c |= 1;
                    this.d = qb0.n();
                    continue;
                }
                catch(p p0) {
                }
                catch(IOException iOException0) {
                    goto label_89;
                }
                p0.a = this;
                throw p0;
            label_89:
                p p1 = new p(iOException0.getMessage());
                p1.a = this;
                throw p1;
            }
            catch(Throwable throwable0) {
            }
        label_92:
            if((v & 0x40) == 0x40) {
                this.j = Collections.unmodifiableList(this.j);
            }
            try {
                g0.k();
                goto label_99;
            }
            catch(IOException unused_ex) {
                goto label_99;
            }
            catch(Throwable throwable1) {
            }
            this.b = c0.m();
            throw throwable1;
        label_99:
            this.b = c0.m();
            this.k();
            throw throwable0;
        }
        if((v & 0x40) == 0x40) {
            this.j = Collections.unmodifiableList(this.j);
        }
        try {
            g0.k();
            goto label_109;
        }
        catch(IOException unused_ex) {
            goto label_109;
        }
        catch(Throwable throwable2) {
        }
        this.b = c0.m();
        throw throwable2;
    label_109:
        this.b = c0.m();
        this.k();
    }

    public b0(a0 a00) {
        super(a00);
        this.l = -1;
        this.m = -1;
        this.b = a00.a;
    }

    @Override  // rf.a
    public final int a() {
        int v1 = this.m;
        if(v1 != -1) {
            return v1;
        }
        int v2 = (this.c & 1) == 1 ? g.d(1, this.d) : 0;
        if((this.c & 2) == 2) {
            v2 += g.d(2, this.e);
        }
        if((this.c & 4) == 4) {
            v2 += g.f(3, this.f);
        }
        if((this.c & 16) == 16) {
            v2 += g.f(4, this.h);
        }
        if((this.c & 8) == 8) {
            v2 += g.d(5, this.g);
        }
        if((this.c & 0x20) == 0x20) {
            v2 += g.d(6, this.i);
        }
        for(int v = 0; v < this.j.size(); ++v) {
            v2 += g.f(7, ((rf.a)this.j.get(v)));
        }
        if((this.c & 0x40) == 0x40) {
            v2 += g.f(8, this.k);
        }
        int v3 = this.h();
        int v4 = this.b.size() + (v3 + v2);
        this.m = v4;
        return v4;
    }

    @Override  // rf.a
    public final rf.h b() {
        return a0.f();
    }

    @Override  // rf.a
    public final rf.h c() {
        rf.h h0 = a0.f();
        ((a0)h0).g(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        v v0 = new v(this);
        if((this.c & 1) == 1) {
            g0.D(1, this.d);
        }
        if((this.c & 2) == 2) {
            g0.D(2, this.e);
        }
        if((this.c & 4) == 4) {
            g0.F(3, this.f);
        }
        if((this.c & 16) == 16) {
            g0.F(4, this.h);
        }
        if((this.c & 8) == 8) {
            g0.D(5, this.g);
        }
        if((this.c & 0x20) == 0x20) {
            g0.D(6, this.i);
        }
        for(int v1 = 0; v1 < this.j.size(); ++v1) {
            g0.F(7, ((rf.a)this.j.get(v1)));
        }
        if((this.c & 0x40) == 0x40) {
            g0.F(8, this.k);
        }
        v0.V(200, g0);
        g0.I(this.b);
    }

    @Override  // rf.t
    public final rf.a getDefaultInstanceForType() {
        return b0.n;
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        int v = this.l;
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        int v1 = this.c;
        if((v1 & 2) == 2) {
            if((v1 & 4) == 4 && !this.f.isInitialized()) {
                this.l = 0;
                return false;
            }
            if((this.c & 16) == 16 && !this.h.isInitialized()) {
                this.l = 0;
                return false;
            }
            for(int v2 = 0; v2 < this.j.size(); ++v2) {
                if(!((h)this.j.get(v2)).isInitialized()) {
                    this.l = 0;
                    return false;
                }
            }
            if((this.c & 0x40) == 0x40 && !this.k.isInitialized()) {
                this.l = 0;
                return false;
            }
            if(!this.g()) {
                this.l = 0;
                return false;
            }
            this.l = 1;
            return true;
        }
        this.l = 0;
        return false;
    }

    public final a0 n() {
        a0 a00 = a0.f();
        a00.g(this);
        return a00;
    }
}

