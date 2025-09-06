package of;

import A3.g;
import i.n.i.b.a.s.e.qb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lf.a;
import rf.c;
import rf.d;
import rf.f;
import rf.h;
import rf.m;
import rf.p;

public final class j extends m {
    public final d a;
    public List b;
    public List c;
    public int d;
    public byte e;
    public int f;
    public static final j g;
    public static final a h;

    static {
        j.h = new a(28);
        j j0 = new j();
        j.g = j0;
        j0.b = Collections.EMPTY_LIST;
        j0.c = Collections.EMPTY_LIST;
    }

    public j() {
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.a = d.a;
    }

    public j(qb qb0, f f0) {
        int v2;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.b = Collections.EMPTY_LIST;
        this.c = Collections.EMPTY_LIST;
        c c0 = new c();
        g g0 = g.w(c0, 1);
        int v = 0;
        boolean z = false;
        while(!z) {
            try {
                try {
                    int v1 = qb0.q();
                alab1:
                    switch(v1) {
                        case 0: {
                        label_14:
                            z = true;
                            continue;
                        }
                        case 10: {
                            if((v & 1) != 1) {
                                this.b = new ArrayList();
                                v |= 1;
                            }
                            this.b.add(qb0.j(i.n, f0));
                            continue;
                        }
                        case 40: {
                            if((v & 2) != 2) {
                                this.c = new ArrayList();
                                v |= 2;
                            }
                            this.c.add(qb0.n());
                            continue;
                        }
                        case 42: {
                            v2 = qb0.g(qb0.n());
                            if((v & 2) != 2 && qb0.e() > 0) {
                                this.c = new ArrayList();
                                v |= 2;
                            }
                            while(true) {
                                if(qb0.e() <= 0) {
                                    break alab1;
                                }
                                this.c.add(qb0.n());
                            }
                        }
                        default: {
                            if(!qb0.t(v1, g0)) {
                                goto label_14;
                            }
                            continue;
                        }
                    }
                    qb0.f(v2);
                    continue;
                }
                catch(p p0) {
                }
                catch(IOException iOException0) {
                    goto label_42;
                }
                p0.a = this;
                throw p0;
            label_42:
                p p1 = new p(iOException0.getMessage());
                p1.a = this;
                throw p1;
            }
            catch(Throwable throwable0) {
            }
            if((v & 1) == 1) {
                this.b = Collections.unmodifiableList(this.b);
            }
            if((v & 2) == 2) {
                this.c = Collections.unmodifiableList(this.c);
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
        if((v & 1) == 1) {
            this.b = Collections.unmodifiableList(this.b);
        }
        if((v & 2) == 2) {
            this.c = Collections.unmodifiableList(this.c);
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

    public j(of.f f0) {
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.a = f0.a;
    }

    @Override  // rf.a
    public final int a() {
        int v = this.f;
        if(v != -1) {
            return v;
        }
        int v3 = 0;
        for(int v2 = 0; v2 < this.b.size(); ++v2) {
            v3 += g.f(1, ((rf.a)this.b.get(v2)));
        }
        int v4 = 0;
        for(int v1 = 0; v1 < this.c.size(); ++v1) {
            v4 += g.e(((int)(((Integer)this.c.get(v1)))));
        }
        int v5 = this.c.isEmpty() ? v3 + v4 : v3 + v4 + 1 + g.e(v4);
        this.d = v4;
        int v6 = this.a.size() + v5;
        this.f = v6;
        return v6;
    }

    @Override  // rf.a
    public final h b() {
        h h0 = new of.f();  // 初始化器: Lrf/h;-><init>()V
        h0.c = Collections.EMPTY_LIST;
        h0.d = Collections.EMPTY_LIST;
        return h0;
    }

    @Override  // rf.a
    public final h c() {
        h h0 = new of.f();  // 初始化器: Lrf/h;-><init>()V
        h0.c = Collections.EMPTY_LIST;
        h0.d = Collections.EMPTY_LIST;
        ((of.f)h0).e(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        for(int v1 = 0; v1 < this.b.size(); ++v1) {
            g0.F(1, ((rf.a)this.b.get(v1)));
        }
        if(this.c.size() > 0) {
            g0.M(42);
            g0.M(this.d);
        }
        for(int v = 0; v < this.c.size(); ++v) {
            g0.E(((int)(((Integer)this.c.get(v)))));
        }
        g0.I(this.a);
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        if(this.e == 1) {
            return true;
        }
        this.e = 1;
        return true;
    }
}

