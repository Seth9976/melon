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
import rf.m;
import rf.p;

public final class h extends m {
    public final d a;
    public int b;
    public int c;
    public List d;
    public byte e;
    public int f;
    public static final h g;
    public static final a h;

    static {
        h.h = new a(0);
        h h0 = new h();
        h.g = h0;
        h0.c = 0;
        h0.d = Collections.EMPTY_LIST;
    }

    public h() {
        this.e = -1;
        this.f = -1;
        this.a = d.a;
    }

    public h(qb qb0, f f0) {
        this.e = -1;
        this.f = -1;
        this.c = 0;
        this.d = Collections.EMPTY_LIST;
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
                            z = true;
                            continue;
                        }
                        case 8: {
                            this.b |= 1;
                            this.c = qb0.n();
                            continue;
                        }
                        case 18: {
                            if((v & 2) != 2) {
                                this.d = new ArrayList();
                                v = 2;
                            }
                            break;
                        }
                        default: {
                            if(!qb0.t(v1, g0)) {
                                z = true;
                                continue;
                            }
                            continue;
                        }
                    }
                    this.d.add(qb0.j(lf.f.h, f0));
                    continue;
                }
                catch(p p0) {
                }
                catch(IOException iOException0) {
                    goto label_30;
                }
                p0.a = this;
                throw p0;
            label_30:
                p p1 = new p(iOException0.getMessage());
                p1.a = this;
                throw p1;
            }
            catch(Throwable throwable0) {
            }
            if((v & 2) == 2) {
                this.d = Collections.unmodifiableList(this.d);
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
        if((v & 2) == 2) {
            this.d = Collections.unmodifiableList(this.d);
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

    public h(lf.g g0) {
        this.e = -1;
        this.f = -1;
        this.a = g0.a;
    }

    @Override  // rf.a
    public final int a() {
        int v1 = this.f;
        if(v1 != -1) {
            return v1;
        }
        int v2 = (this.b & 1) == 1 ? g.d(1, this.c) : 0;
        for(int v = 0; v < this.d.size(); ++v) {
            v2 += g.f(2, ((rf.a)this.d.get(v)));
        }
        int v3 = this.a.size() + v2;
        this.f = v3;
        return v3;
    }

    @Override  // rf.a
    public final rf.h b() {
        rf.h h0 = new lf.g(0);
        h0.d = Collections.EMPTY_LIST;
        return h0;
    }

    @Override  // rf.a
    public final rf.h c() {
        rf.h h0 = new lf.g(0);
        h0.d = Collections.EMPTY_LIST;
        ((lf.g)h0).g(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        if((this.b & 1) == 1) {
            g0.D(1, this.c);
        }
        for(int v = 0; v < this.d.size(); ++v) {
            g0.F(2, ((rf.a)this.d.get(v)));
        }
        g0.I(this.a);
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        int v = this.e;
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        if((this.b & 1) == 1) {
            for(int v1 = 0; v1 < this.d.size(); ++v1) {
                if(!((lf.f)this.d.get(v1)).isInitialized()) {
                    this.e = 0;
                    return false;
                }
            }
            this.e = 1;
            return true;
        }
        this.e = 0;
        return false;
    }
}

