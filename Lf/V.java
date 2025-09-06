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
import rf.j;
import rf.p;

public final class v extends j {
    public final d b;
    public int c;
    public int d;
    public List e;
    public byte f;
    public int g;
    public static final v h;
    public static final a i;

    static {
        v.i = new a(8);
        v v0 = new v();
        v.h = v0;
        v0.d = 0;
        v0.e = Collections.EMPTY_LIST;
    }

    public v() {
        this.f = -1;
        this.g = -1;
        this.b = d.a;
    }

    public v(qb qb0, f f0) {
        this.f = -1;
        this.g = -1;
        this.d = 0;
        this.e = Collections.EMPTY_LIST;
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
                            this.c |= 1;
                            this.d = qb0.n();
                            continue;
                        }
                        case 18: {
                            if((v & 2) != 2) {
                                this.e = new ArrayList();
                                v = 2;
                            }
                            break;
                        }
                        default: {
                            if(!this.l(qb0, g0, f0, v1)) {
                                z = true;
                                continue;
                            }
                            continue;
                        }
                    }
                    this.e.add(qb0.j(h.h, f0));
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
                this.e = Collections.unmodifiableList(this.e);
            }
            try {
                g0.k();
                goto label_40;
            }
            catch(IOException unused_ex) {
                goto label_40;
            }
            catch(Throwable throwable1) {
            }
            this.b = c0.m();
            throw throwable1;
        label_40:
            this.b = c0.m();
            this.k();
            throw throwable0;
        }
        if((v & 2) == 2) {
            this.e = Collections.unmodifiableList(this.e);
        }
        try {
            g0.k();
            goto label_50;
        }
        catch(IOException unused_ex) {
            goto label_50;
        }
        catch(Throwable throwable2) {
        }
        this.b = c0.m();
        throw throwable2;
    label_50:
        this.b = c0.m();
        this.k();
    }

    public v(u u0) {
        super(u0);
        this.f = -1;
        this.g = -1;
        this.b = u0.a;
    }

    @Override  // rf.a
    public final int a() {
        int v1 = this.g;
        if(v1 != -1) {
            return v1;
        }
        int v2 = (this.c & 1) == 1 ? g.d(1, this.d) : 0;
        for(int v = 0; v < this.e.size(); ++v) {
            v2 += g.f(2, ((rf.a)this.e.get(v)));
        }
        int v3 = this.h();
        int v4 = this.b.size() + (v3 + v2);
        this.g = v4;
        return v4;
    }

    @Override  // rf.a
    public final rf.h b() {
        rf.h h0 = new u();  // 初始化器: Lrf/i;-><init>()V
        h0.f = Collections.EMPTY_LIST;
        return h0;
    }

    @Override  // rf.a
    public final rf.h c() {
        rf.h h0 = new u();  // 初始化器: Lrf/i;-><init>()V
        h0.f = Collections.EMPTY_LIST;
        ((u)h0).f(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        d5.v v0 = new d5.v(this);
        if((this.c & 1) == 1) {
            g0.D(1, this.d);
        }
        for(int v1 = 0; v1 < this.e.size(); ++v1) {
            g0.F(2, ((rf.a)this.e.get(v1)));
        }
        v0.V(200, g0);
        g0.I(this.b);
    }

    @Override  // rf.t
    public final rf.a getDefaultInstanceForType() {
        return v.h;
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        int v = this.f;
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        for(int v1 = 0; v1 < this.e.size(); ++v1) {
            if(!((h)this.e.get(v1)).isInitialized()) {
                this.f = 0;
                return false;
            }
        }
        if(!this.g()) {
            this.f = 0;
            return false;
        }
        this.f = 1;
        return true;
    }
}

