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

public final class n extends j {
    public final d b;
    public int c;
    public int d;
    public List e;
    public List f;
    public List g;
    public List h;
    public byte i;
    public int j;
    public static final n k;
    public static final a l;

    static {
        n.l = new a(5);
        n n0 = new n();
        n.k = n0;
        n0.d = 6;
        n0.e = Collections.EMPTY_LIST;
        n0.f = Collections.EMPTY_LIST;
        n0.g = Collections.EMPTY_LIST;
        n0.h = Collections.EMPTY_LIST;
    }

    public n() {
        this.i = -1;
        this.j = -1;
        this.b = d.a;
    }

    public n(qb qb0, f f0) {
        this.i = -1;
        this.j = -1;
        this.d = 6;
        this.e = Collections.EMPTY_LIST;
        this.f = Collections.EMPTY_LIST;
        this.g = Collections.EMPTY_LIST;
        this.h = Collections.EMPTY_LIST;
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
                        label_16:
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
                                v |= 2;
                            }
                            this.e.add(qb0.j(b0.o, f0));
                            continue;
                        }
                        case 26: {
                            if((v & 16) != 16) {
                                this.h = new ArrayList();
                                v |= 16;
                            }
                            this.h.add(qb0.j(h.h, f0));
                            continue;
                        }
                        case 0xF8: {
                            if((v & 4) != 4) {
                                this.f = new ArrayList();
                                v |= 4;
                            }
                            this.f.add(qb0.n());
                            continue;
                        }
                        case 0xFA: {
                            int v2 = qb0.g(qb0.n());
                            if((v & 4) != 4 && qb0.e() > 0) {
                                this.f = new ArrayList();
                                v |= 4;
                            }
                            while(qb0.e() > 0) {
                                this.f.add(qb0.n());
                            }
                            qb0.f(v2);
                            continue;
                        }
                        case 0x102: {
                            if((v & 8) != 8) {
                                this.g = new ArrayList();
                                v |= 8;
                            }
                            break;
                        }
                        default: {
                            if(!this.l(qb0, g0, f0, v1)) {
                                goto label_16;
                            }
                            continue;
                        }
                    }
                    this.g.add(qb0.j(l.h, f0));
                    continue;
                }
                catch(p p0) {
                }
                catch(IOException iOException0) {
                    goto label_57;
                }
                p0.a = this;
                throw p0;
            label_57:
                p p1 = new p(iOException0.getMessage());
                p1.a = this;
                throw p1;
            }
            catch(Throwable throwable0) {
            }
            if((v & 2) == 2) {
                this.e = Collections.unmodifiableList(this.e);
            }
            if((v & 16) == 16) {
                this.h = Collections.unmodifiableList(this.h);
            }
            if((v & 4) == 4) {
                this.f = Collections.unmodifiableList(this.f);
            }
            if((v & 8) == 8) {
                this.g = Collections.unmodifiableList(this.g);
            }
            try {
                g0.k();
                goto label_73;
            }
            catch(IOException unused_ex) {
                goto label_73;
            }
            catch(Throwable throwable1) {
            }
            this.b = c0.m();
            throw throwable1;
        label_73:
            this.b = c0.m();
            this.k();
            throw throwable0;
        }
        if((v & 2) == 2) {
            this.e = Collections.unmodifiableList(this.e);
        }
        if((v & 16) == 16) {
            this.h = Collections.unmodifiableList(this.h);
        }
        if((v & 4) == 4) {
            this.f = Collections.unmodifiableList(this.f);
        }
        if((v & 8) == 8) {
            this.g = Collections.unmodifiableList(this.g);
        }
        try {
            g0.k();
            goto label_89;
        }
        catch(IOException unused_ex) {
            goto label_89;
        }
        catch(Throwable throwable2) {
        }
        this.b = c0.m();
        throw throwable2;
    label_89:
        this.b = c0.m();
        this.k();
    }

    public n(m m0) {
        super(m0);
        this.i = -1;
        this.j = -1;
        this.b = m0.a;
    }

    @Override  // rf.a
    public final int a() {
        int v1 = this.j;
        if(v1 != -1) {
            return v1;
        }
        int v2 = (this.c & 1) == 1 ? g.d(1, this.d) : 0;
        for(int v3 = 0; v3 < this.e.size(); ++v3) {
            v2 += g.f(2, ((rf.a)this.e.get(v3)));
        }
        for(int v4 = 0; v4 < this.h.size(); ++v4) {
            v2 += g.f(3, ((rf.a)this.h.get(v4)));
        }
        int v6 = 0;
        for(int v5 = 0; v5 < this.f.size(); ++v5) {
            v6 += g.e(((int)(((Integer)this.f.get(v5)))));
        }
        int v7 = this.f.size() * 2 + (v2 + v6);
        for(int v = 0; v < this.g.size(); ++v) {
            v7 += g.f(0x20, ((rf.a)this.g.get(v)));
        }
        int v8 = this.h();
        int v9 = this.b.size() + (v8 + v7);
        this.j = v9;
        return v9;
    }

    @Override  // rf.a
    public final rf.h b() {
        return m.f();
    }

    @Override  // rf.a
    public final rf.h c() {
        rf.h h0 = m.f();
        ((m)h0).g(this);
        return h0;
    }

    @Override  // rf.a
    public final void d(g g0) {
        this.a();
        v v0 = new v(this);
        if((this.c & 1) == 1) {
            g0.D(1, this.d);
        }
        for(int v2 = 0; v2 < this.e.size(); ++v2) {
            g0.F(2, ((rf.a)this.e.get(v2)));
        }
        for(int v3 = 0; v3 < this.h.size(); ++v3) {
            g0.F(3, ((rf.a)this.h.get(v3)));
        }
        for(int v4 = 0; v4 < this.f.size(); ++v4) {
            g0.D(0x1F, ((int)(((Integer)this.f.get(v4)))));
        }
        for(int v1 = 0; v1 < this.g.size(); ++v1) {
            g0.F(0x20, ((rf.a)this.g.get(v1)));
        }
        v0.V(19000, g0);
        g0.I(this.b);
    }

    @Override  // rf.t
    public final rf.a getDefaultInstanceForType() {
        return n.k;
    }

    @Override  // rf.t
    public final boolean isInitialized() {
        int v = this.i;
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        for(int v1 = 0; v1 < this.e.size(); ++v1) {
            if(!((b0)this.e.get(v1)).isInitialized()) {
                this.i = 0;
                return false;
            }
        }
        for(int v2 = 0; v2 < this.g.size(); ++v2) {
            if(!((l)this.g.get(v2)).isInitialized()) {
                this.i = 0;
                return false;
            }
        }
        for(int v3 = 0; v3 < this.h.size(); ++v3) {
            if(!((h)this.h.get(v3)).isInitialized()) {
                this.i = 0;
                return false;
            }
        }
        if(!this.g()) {
            this.i = 0;
            return false;
        }
        this.i = 1;
        return true;
    }
}

