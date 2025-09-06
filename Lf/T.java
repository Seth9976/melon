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

public final class t extends m {
    public final d a;
    public int b;
    public r c;
    public List d;
    public y e;
    public s f;
    public byte g;
    public int h;
    public static final t i;
    public static final a j;

    static {
        t.j = new a(7);
        t t0 = new t();
        t.i = t0;
        t0.c = r.b;
        t0.d = Collections.EMPTY_LIST;
        t0.e = y.l;
        t0.f = s.b;
    }

    public t() {
        this.g = -1;
        this.h = -1;
        this.a = d.a;
    }

    public t(qb qb0, f f0) {
        this.g = -1;
        this.h = -1;
        r r0 = r.b;
        this.c = r0;
        this.d = Collections.EMPTY_LIST;
        this.e = y.l;
        s s0 = s.b;
        this.f = s0;
        c c0 = new c();
        g g0 = g.w(c0, 1);
        int v = 0;
        boolean z = false;
        while(!z) {
            try {
                r r1 = null;
                int v1 = qb0.q();
                if(v1 != 0) {
                    switch(v1) {
                        case 8: {
                            int v2 = qb0.n();
                            switch(v2) {
                                case 0: {
                                    r1 = r0;
                                    break;
                                }
                                case 1: {
                                    r1 = r.c;
                                    break;
                                }
                                case 2: {
                                    r1 = r.d;
                                }
                            }
                            if(r1 == null) {
                                g0.M(8);
                                g0.M(v2);
                            }
                            else {
                                this.b |= 1;
                                this.c = r1;
                            }
                            continue;
                        }
                        case 18: {
                            if((v & 2) != 2) {
                                this.d = new ArrayList();
                                v = 2;
                            }
                            this.d.add(qb0.j(y.m, f0));
                            continue;
                        }
                        case 26: {
                            if((this.b & 2) == 2) {
                                y y0 = this.e;
                                y0.getClass();
                                r1 = w.e();
                                ((w)r1).f(y0);
                            }
                            y y1 = (y)qb0.j(y.m, f0);
                            this.e = y1;
                            if(r1 != null) {
                                ((w)r1).f(y1);
                                this.e = ((w)r1).d();
                            }
                            this.b |= 2;
                            continue;
                        }
                        case 0x20: {
                            int v3 = qb0.n();
                            switch(v3) {
                                case 0: {
                                    r1 = s0;
                                    break;
                                }
                                case 1: {
                                    r1 = s.c;
                                    break;
                                }
                                case 2: {
                                    r1 = s.d;
                                }
                            }
                            if(r1 == null) {
                                g0.M(0x20);
                                g0.M(v3);
                            }
                            else {
                                this.b |= 4;
                                this.f = r1;
                            }
                            continue;
                        }
                        default: {
                            if(qb0.t(v1, g0)) {
                                continue;
                            }
                        }
                    }
                }
                try {
                    try {
                        z = true;
                        continue;
                    }
                    catch(p p0) {
                    }
                    catch(IOException iOException0) {
                        goto label_80;
                    }
                    p0.a = this;
                    throw p0;
                label_80:
                    p p1 = new p(iOException0.getMessage());
                    p1.a = this;
                    throw p1;
                }
                catch(Throwable throwable0) {
                }
            }
            catch(p p0) {
                p0.a = this;
                throw p0;
            }
            catch(IOException iOException0) {
                goto label_80;
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

    public t(q q0) {
        this.g = -1;
        this.h = -1;
        this.a = q0.a;
    }

    @Override  // rf.a
    public final int a() {
        int v1 = this.h;
        if(v1 != -1) {
            return v1;
        }
        int v2 = (this.b & 1) == 1 ? g.c(1, this.c.a) : 0;
        for(int v = 0; v < this.d.size(); ++v) {
            v2 += g.f(2, ((rf.a)this.d.get(v)));
        }
        if((this.b & 2) == 2) {
            v2 += g.f(3, this.e);
        }
        if((this.b & 4) == 4) {
            v2 += g.c(4, this.f.a);
        }
        int v3 = this.a.size() + v2;
        this.h = v3;
        return v3;
    }

    @Override  // rf.a
    public final h b() {
        return q.e();
    }

    @Override  // rf.a
    public final h c() {
        h h0 = q.e();
        ((q)h0).f(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        if((this.b & 1) == 1) {
            g0.C(1, this.c.a);
        }
        for(int v = 0; v < this.d.size(); ++v) {
            g0.F(2, ((rf.a)this.d.get(v)));
        }
        if((this.b & 2) == 2) {
            g0.F(3, this.e);
        }
        if((this.b & 4) == 4) {
            g0.C(4, this.f.a);
        }
        g0.I(this.a);
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        int v = this.g;
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        for(int v1 = 0; v1 < this.d.size(); ++v1) {
            if(!((y)this.d.get(v1)).isInitialized()) {
                this.g = 0;
                return false;
            }
        }
        if((this.b & 2) == 2 && !this.e.isInitialized()) {
            this.g = 0;
            return false;
        }
        this.g = 1;
        return true;
    }
}

