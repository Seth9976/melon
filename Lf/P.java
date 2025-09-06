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

public final class p extends m {
    public final d a;
    public List b;
    public byte c;
    public int d;
    public static final p e;
    public static final a f;

    static {
        p.f = new a(6);
        p p0 = new p();
        p.e = p0;
        p0.b = Collections.EMPTY_LIST;
    }

    public p() {
        this.c = -1;
        this.d = -1;
        this.a = d.a;
    }

    public p(qb qb0, f f0) {
        this.c = -1;
        this.d = -1;
        this.b = Collections.EMPTY_LIST;
        c c0 = new c();
        g g0 = g.w(c0, 1);
        boolean z = false;
        boolean z1 = false;
        while(!z1) {
            try {
                try {
                    int v = qb0.q();
                    switch(v) {
                        case 0: {
                            z1 = true;
                            continue;
                        }
                        case 10: {
                            break;
                        }
                        default: {
                            if(!qb0.t(v, g0)) {
                                z1 = true;
                                continue;
                            }
                            continue;
                        }
                    }
                    if(!z) {
                        this.b = new ArrayList();
                        z = true;
                    }
                    this.b.add(qb0.j(t.j, f0));
                    continue;
                }
                catch(rf.p p0) {
                }
                catch(IOException iOException0) {
                    goto label_26;
                }
                p0.a = this;
                throw p0;
            label_26:
                rf.p p1 = new rf.p(iOException0.getMessage());
                p1.a = this;
                throw p1;
            }
            catch(Throwable throwable0) {
            }
            if(z) {
                this.b = Collections.unmodifiableList(this.b);
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
        if(z) {
            this.b = Collections.unmodifiableList(this.b);
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

    public p(o o0) {
        this.c = -1;
        this.d = -1;
        this.a = o0.a;
    }

    @Override  // rf.a
    public final int a() {
        int v = this.d;
        if(v != -1) {
            return v;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < this.b.size(); ++v1) {
            v2 += g.f(1, ((rf.a)this.b.get(v1)));
        }
        int v3 = this.a.size() + v2;
        this.d = v3;
        return v3;
    }

    @Override  // rf.a
    public final h b() {
        h h0 = new o(0);
        h0.d = Collections.EMPTY_LIST;
        return h0;
    }

    @Override  // rf.a
    public final h c() {
        h h0 = new o(0);
        h0.d = Collections.EMPTY_LIST;
        ((o)h0).h(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        for(int v = 0; v < this.b.size(); ++v) {
            g0.F(1, ((rf.a)this.b.get(v)));
        }
        g0.I(this.a);
    }

    public final o g() {
        o o0 = new o(0);
        o0.d = Collections.EMPTY_LIST;
        o0.h(this);
        return o0;
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        int v = this.c;
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        for(int v1 = 0; v1 < this.b.size(); ++v1) {
            if(!((t)this.b.get(v1)).isInitialized()) {
                this.c = 0;
                return false;
            }
        }
        this.c = 1;
        return true;
    }
}

