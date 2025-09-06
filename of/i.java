package of;

import A3.g;
import i.n.i.b.a.s.e.qb;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lf.a;
import rf.c;
import rf.d;
import rf.m;
import rf.p;
import rf.s;

public final class i extends m {
    public final d a;
    public int b;
    public int c;
    public int d;
    public Object e;
    public h f;
    public List g;
    public int h;
    public List i;
    public int j;
    public byte k;
    public int l;
    public static final i m;
    public static final a n;

    static {
        i.n = new a(29);
        i i0 = new i();
        i.m = i0;
        i0.c = 1;
        i0.d = 0;
        i0.e = "";
        i0.f = h.b;
        i0.g = Collections.EMPTY_LIST;
        i0.i = Collections.EMPTY_LIST;
    }

    public i() {
        this.h = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.a = d.a;
    }

    public i(qb qb0) {
        h h1;
        this.h = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.c = 1;
        this.d = 0;
        this.e = "";
        h h0 = h.b;
        this.f = h0;
        this.g = Collections.EMPTY_LIST;
        this.i = Collections.EMPTY_LIST;
        c c0 = new c();
        g g0 = g.w(c0, 1);
        int v = 0;
        boolean z = false;
        while(!z) {
            try {
                try {
                    int v1 = qb0.q();
                    switch(v1) {
                        case 0: {
                        label_20:
                            z = true;
                            continue;
                        }
                        case 8: {
                            this.b |= 1;
                            this.c = qb0.n();
                            continue;
                        }
                        case 16: {
                            this.b |= 2;
                            this.d = qb0.n();
                            continue;
                        }
                        case 24: {
                            int v2 = qb0.n();
                            switch(v2) {
                                case 0: {
                                    h1 = h0;
                                    break;
                                }
                                case 1: {
                                    h1 = h.c;
                                    break;
                                }
                                case 2: {
                                    h1 = h.d;
                                    break;
                                }
                                default: {
                                    h1 = null;
                                }
                            }
                            if(h1 == null) {
                                g0.M(24);
                                g0.M(v2);
                            }
                            else {
                                this.b |= 8;
                                this.f = h1;
                            }
                            continue;
                        }
                        case 0x20: {
                            if((v & 16) != 16) {
                                this.g = new ArrayList();
                                v |= 16;
                            }
                            this.g.add(qb0.n());
                            continue;
                        }
                        case 34: {
                            int v3 = qb0.g(qb0.n());
                            if((v & 16) != 16 && qb0.e() > 0) {
                                this.g = new ArrayList();
                                v |= 16;
                            }
                            while(qb0.e() > 0) {
                                this.g.add(qb0.n());
                            }
                            qb0.f(v3);
                            continue;
                        }
                        case 40: {
                            if((v & 0x20) != 0x20) {
                                this.i = new ArrayList();
                                v |= 0x20;
                            }
                            this.i.add(qb0.n());
                            continue;
                        }
                        case 42: {
                            int v4 = qb0.g(qb0.n());
                            if((v & 0x20) != 0x20 && qb0.e() > 0) {
                                this.i = new ArrayList();
                                v |= 0x20;
                            }
                            while(qb0.e() > 0) {
                                this.i.add(qb0.n());
                            }
                            qb0.f(v4);
                            continue;
                        }
                        case 50: {
                            s s0 = qb0.h();
                            this.b |= 4;
                            this.e = s0;
                            continue;
                        }
                        default: {
                            if(!qb0.t(v1, g0)) {
                                goto label_20;
                            }
                            continue;
                        }
                    }
                }
                catch(p p0) {
                }
                catch(IOException iOException0) {
                    goto label_83;
                }
                p0.a = this;
                throw p0;
            label_83:
                p p1 = new p(iOException0.getMessage());
                p1.a = this;
                throw p1;
            }
            catch(Throwable throwable0) {
            }
            if((v & 16) == 16) {
                this.g = Collections.unmodifiableList(this.g);
            }
            if((v & 0x20) == 0x20) {
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
        if((v & 16) == 16) {
            this.g = Collections.unmodifiableList(this.g);
        }
        if((v & 0x20) == 0x20) {
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

    public i(of.g g0) {
        this.h = -1;
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.a = g0.a;
    }

    @Override  // rf.a
    public final int a() {
        d d0;
        int v1 = this.l;
        if(v1 != -1) {
            return v1;
        }
        int v2 = (this.b & 1) == 1 ? g.d(1, this.c) : 0;
        if((this.b & 2) == 2) {
            v2 += g.d(2, this.d);
        }
        if((this.b & 8) == 8) {
            v2 += g.c(3, this.f.a);
        }
        int v4 = 0;
        for(int v3 = 0; v3 < this.g.size(); ++v3) {
            v4 += g.e(((int)(((Integer)this.g.get(v3)))));
        }
        int v5 = this.g.isEmpty() ? v2 + v4 : v2 + v4 + 1 + g.e(v4);
        this.h = v4;
        int v6 = 0;
        for(int v = 0; v < this.i.size(); ++v) {
            v6 += g.e(((int)(((Integer)this.i.get(v)))));
        }
        int v7 = this.i.isEmpty() ? v5 + v6 : v5 + v6 + 1 + g.e(v6);
        this.j = v6;
        if((this.b & 4) == 4) {
            Object object0 = this.e;
            if(object0 instanceof String) {
                String s = (String)object0;
                try {
                    d0 = new s(s.getBytes("UTF-8"));
                    this.e = d0;
                }
                catch(UnsupportedEncodingException unsupportedEncodingException0) {
                    throw new RuntimeException("UTF-8 not supported?", unsupportedEncodingException0);
                }
            }
            else {
                d0 = (d)object0;
            }
            v7 += d0.size() + g.h(d0.size()) + 1;
        }
        int v8 = this.a.size() + v7;
        this.l = v8;
        return v8;
    }

    @Override  // rf.a
    public final rf.h b() {
        return of.g.e();
    }

    @Override  // rf.a
    public final rf.h c() {
        rf.h h0 = of.g.e();
        ((of.g)h0).f(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        d d0;
        this.a();
        if((this.b & 1) == 1) {
            g0.D(1, this.c);
        }
        if((this.b & 2) == 2) {
            g0.D(2, this.d);
        }
        if((this.b & 8) == 8) {
            g0.C(3, this.f.a);
        }
        if(this.g.size() > 0) {
            g0.M(34);
            g0.M(this.h);
        }
        for(int v1 = 0; v1 < this.g.size(); ++v1) {
            g0.E(((int)(((Integer)this.g.get(v1)))));
        }
        if(this.i.size() > 0) {
            g0.M(42);
            g0.M(this.j);
        }
        for(int v = 0; v < this.i.size(); ++v) {
            g0.E(((int)(((Integer)this.i.get(v)))));
        }
        if((this.b & 4) == 4) {
            Object object0 = this.e;
            if(object0 instanceof String) {
                String s = (String)object0;
                try {
                    d0 = new s(s.getBytes("UTF-8"));
                    this.e = d0;
                }
                catch(UnsupportedEncodingException unsupportedEncodingException0) {
                    throw new RuntimeException("UTF-8 not supported?", unsupportedEncodingException0);
                }
            }
            else {
                d0 = (d)object0;
            }
            g0.O(6, 2);
            g0.M(d0.size());
            g0.I(d0);
        }
        g0.I(this.a);
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        if(this.k == 1) {
            return true;
        }
        this.k = 1;
        return true;
    }
}

