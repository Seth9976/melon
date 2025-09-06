package lf;

import A3.g;
import i.n.i.b.a.s.e.qb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rf.c;
import rf.d;
import rf.f;
import rf.h;
import rf.m;
import rf.p;

public final class y extends m {
    public final d a;
    public int b;
    public int c;
    public int d;
    public x e;
    public T f;
    public int g;
    public List h;
    public List i;
    public byte j;
    public int k;
    public static final y l;
    public static final a m;

    static {
        y.m = new a(9);
        y y0 = new y();
        y.l = y0;
        y0.c = 0;
        y0.d = 0;
        y0.e = x.b;
        y0.f = T.E;
        y0.g = 0;
        y0.h = Collections.EMPTY_LIST;
        y0.i = Collections.EMPTY_LIST;
    }

    public y() {
        this.j = -1;
        this.k = -1;
        this.a = d.a;
    }

    public y(qb qb0, f f0) {
        x x1;
        this.j = -1;
        this.k = -1;
        this.c = 0;
        this.d = 0;
        x x0 = x.b;
        this.e = x0;
        this.f = T.E;
        this.g = 0;
        this.h = Collections.EMPTY_LIST;
        this.i = Collections.EMPTY_LIST;
        c c0 = new c();
        g g0 = g.w(c0, 1);
        int v = 0;
        boolean z = false;
        while(!z) {
            try {
                int v1 = qb0.q();
                S s0 = null;
                switch(v1) {
                    case 0: {
                    label_71:
                        z = true;
                        break;
                    }
                    case 8: {
                        this.b |= 1;
                        this.c = qb0.n();
                        continue;
                    }
                    default: {
                        if(v1 == 16) {
                            this.b |= 2;
                            this.d = qb0.n();
                        }
                        else {
                            switch(v1) {
                                case 24: {
                                    int v2 = qb0.n();
                                    switch(v2) {
                                        case 0: {
                                            x1 = x0;
                                            break;
                                        }
                                        case 1: {
                                            x1 = x.c;
                                            break;
                                        }
                                        case 2: {
                                            x1 = x.d;
                                            break;
                                        }
                                        default: {
                                            x1 = null;
                                        }
                                    }
                                    if(x1 == null) {
                                        g0.M(24);
                                        g0.M(v2);
                                    }
                                    else {
                                        this.b |= 4;
                                        this.e = x1;
                                    }
                                    break;
                                }
                                case 34: {
                                    if((this.b & 8) == 8) {
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
                                    this.b |= 8;
                                    break;
                                }
                                case 40: {
                                    this.b |= 16;
                                    this.g = qb0.n();
                                    break;
                                }
                                default: {
                                    a a0 = y.m;
                                    switch(v1) {
                                        case 50: {
                                            if((v & 0x20) != 0x20) {
                                                this.h = new ArrayList();
                                                v |= 0x20;
                                            }
                                            this.h.add(qb0.j(a0, f0));
                                            break;
                                        }
                                        case 58: {
                                            if((v & 0x40) != 0x40) {
                                                this.i = new ArrayList();
                                                v |= 0x40;
                                            }
                                            this.i.add(qb0.j(a0, f0));
                                            break;
                                        }
                                        default: {
                                            if(qb0.t(v1, g0)) {
                                                break;
                                            }
                                            goto label_71;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }
            catch(p p0) {
                p0.a = this;
                throw p0;
            }
            catch(IOException iOException0) {
                goto label_84;
            }
            catch(Throwable throwable0) {
                goto label_87;
            }
            continue;
            try {
                try {
                    this.b |= 1;
                    this.c = qb0.n();
                    continue;
                }
                catch(p p0) {
                }
                catch(IOException iOException0) {
                    goto label_84;
                }
                p0.a = this;
                throw p0;
            label_84:
                p p1 = new p(iOException0.getMessage());
                p1.a = this;
                throw p1;
            }
            catch(Throwable throwable0) {
            }
        label_87:
            if((v & 0x20) == 0x20) {
                this.h = Collections.unmodifiableList(this.h);
            }
            if((v & 0x40) == 0x40) {
                this.i = Collections.unmodifiableList(this.i);
            }
            try {
                g0.k();
                this.a = c0.m();
                throw throwable0;
            }
            catch(IOException unused_ex) {
                this.a = c0.m();
                throw throwable0;
            }
            catch(Throwable throwable1) {
            }
            this.a = c0.m();
            throw throwable1;
        }
        if((v & 0x20) == 0x20) {
            this.h = Collections.unmodifiableList(this.h);
        }
        if((v & 0x40) == 0x40) {
            this.i = Collections.unmodifiableList(this.i);
        }
        try {
            g0.k();
            this.a = c0.m();
            return;
        }
        catch(IOException unused_ex) {
            this.a = c0.m();
            return;
        }
        catch(Throwable throwable2) {
        }
        this.a = c0.m();
        throw throwable2;
    }

    public y(w w0) {
        this.j = -1;
        this.k = -1;
        this.a = w0.a;
    }

    @Override  // rf.a
    public final int a() {
        int v1 = this.k;
        if(v1 != -1) {
            return v1;
        }
        int v2 = (this.b & 1) == 1 ? g.d(1, this.c) : 0;
        if((this.b & 2) == 2) {
            v2 += g.d(2, this.d);
        }
        if((this.b & 4) == 4) {
            v2 += g.c(3, this.e.a);
        }
        if((this.b & 8) == 8) {
            v2 += g.f(4, this.f);
        }
        if((this.b & 16) == 16) {
            v2 += g.d(5, this.g);
        }
        for(int v3 = 0; v3 < this.h.size(); ++v3) {
            v2 += g.f(6, ((rf.a)this.h.get(v3)));
        }
        for(int v = 0; v < this.i.size(); ++v) {
            v2 += g.f(7, ((rf.a)this.i.get(v)));
        }
        int v4 = this.a.size() + v2;
        this.k = v4;
        return v4;
    }

    @Override  // rf.a
    public final h b() {
        return w.e();
    }

    @Override  // rf.a
    public final h c() {
        h h0 = w.e();
        ((w)h0).f(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        if((this.b & 1) == 1) {
            g0.D(1, this.c);
        }
        if((this.b & 2) == 2) {
            g0.D(2, this.d);
        }
        if((this.b & 4) == 4) {
            g0.C(3, this.e.a);
        }
        if((this.b & 8) == 8) {
            g0.F(4, this.f);
        }
        if((this.b & 16) == 16) {
            g0.D(5, this.g);
        }
        for(int v1 = 0; v1 < this.h.size(); ++v1) {
            g0.F(6, ((rf.a)this.h.get(v1)));
        }
        for(int v = 0; v < this.i.size(); ++v) {
            g0.F(7, ((rf.a)this.i.get(v)));
        }
        g0.I(this.a);
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        int v = this.j;
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        if((this.b & 8) == 8 && !this.f.isInitialized()) {
            this.j = 0;
            return false;
        }
        for(int v1 = 0; v1 < this.h.size(); ++v1) {
            if(!((y)this.h.get(v1)).isInitialized()) {
                this.j = 0;
                return false;
            }
        }
        for(int v2 = 0; v2 < this.i.size(); ++v2) {
            if(!((y)this.i.get(v2)).isInitialized()) {
                this.j = 0;
                return false;
            }
        }
        this.j = 1;
        return true;
    }
}

