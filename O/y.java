package O;

import De.I;
import H0.e;
import I.F0;
import I.X0;
import I.u0;
import P.s;
import P.t;
import Q.K;
import Q.j;
import androidx.compose.runtime.O0;
import java.util.Collection;
import java.util.List;
import je.p;
import ye.a;

public final class y implements F0 {
    public final int a;
    public final F0 b;
    public final X0 c;

    public y(F0 f00, X0 x00, int v) {
        this.a = v;
        this.c = x00;
        this.b = f00;
        super();
    }

    @Override  // I.F0
    public final float a(float f) {
        switch(this.a) {
            case 0: {
                return this.b.a(f);
            }
            case 1: {
                return this.b.a(f);
            }
            default: {
                return this.b.a(f);
            }
        }
    }

    public final int b(int v) {
        Integer integer0;
        Object object3;
        switch(this.a) {
            case 0: {
                u u0 = ((F)this.c).h();
                if(!((List)u0.k).isEmpty()) {
                    int v3 = this.c();
                    if(v <= this.e() && v3 <= v) {
                        Object object0 = u0.k;
                        int v4 = ((Collection)object0).size();
                        for(int v5 = 0; v5 < v4; ++v5) {
                            Object object1 = ((List)object0).get(v5);
                            if(((v)object1).a == v) {
                                return ((v)object1) == null ? 0 : ((v)object1).m;
                            }
                        }
                        return 0;
                    }
                    int v6 = I.d0(u0);
                    return (v - this.c()) * v6 - this.d();
                }
                return 0;
            }
            case 1: {
                P.F f0 = (P.F)this.c;
                s s0 = f0.g();
                boolean z = false;
                if(!((List)s0.l).isEmpty()) {
                    int v7 = this.c();
                    if(v <= this.e() && v7 <= v) {
                        Object object2 = s0.l;
                        int v8 = ((Collection)object2).size();
                        for(int v9 = 0; true; ++v9) {
                            object3 = null;
                            integer0 = null;
                            if(v9 >= v8) {
                                break;
                            }
                            Object object4 = ((List)object2).get(v9);
                            if(((t)object4).a == v) {
                                object3 = object4;
                                break;
                            }
                        }
                        if(s0.p == u0.a) {
                            if(((t)object3) != null) {
                                integer0 = (int)(((t)object3).p & 0xFFFFFFFFL);
                                return integer0 == null ? 0 : ((int)integer0);
                            }
                        }
                        else if(((t)object3) != null) {
                            integer0 = (int)(((t)object3).p >> 0x20);
                        }
                        return integer0 == null ? 0 : ((int)integer0);
                    }
                    int v10 = ((s)((O0)f0.e).getValue()).j;
                    int v11 = e.c0(s0);
                    int v12 = 1;
                    if(v < this.c()) {
                        z = true;
                    }
                    int v13 = this.c();
                    if(z) {
                        v12 = -1;
                    }
                    return ((v10 - 1) * v12 + (v - v13)) / v10 * v11 - this.d();
                }
                return 0;
            }
            default: {
                int v1 = ((K)this.c).j();
                int v2 = a.V(((float)(((K)this.c).n() * (v - v1))) - ((K)this.c).d.a() * ((float)((K)this.c).n()) + 0.0f);
                return (int)(P4.a.k(a.y(((K)this.c)) + ((long)v2), ((K)this.c).h, ((K)this.c).g) - a.y(((K)this.c)));
            }
        }
    }

    public final int c() {
        switch(this.a) {
            case 0: {
                return ((F)this.c).d.a();
            }
            case 1: {
                return ((P.F)this.c).d.a();
            }
            default: {
                return ((K)this.c).e;
            }
        }
    }

    public final int d() {
        switch(this.a) {
            case 0: {
                return ((F)this.c).d.b();
            }
            case 1: {
                return ((P.F)this.c).d.b();
            }
            default: {
                return ((K)this.c).f;
            }
        }
    }

    public final int e() {
        switch(this.a) {
            case 0: {
                v v0 = (v)p.t0(((List)((F)this.c).h().k));
                return v0 == null ? 0 : v0.a;
            }
            case 1: {
                t t0 = (t)p.t0(((List)((P.F)this.c).g().l));
                return t0 == null ? 0 : t0.a;
            }
            default: {
                return ((j)p.s0(((K)this.c).k().a)).a;
            }
        }
    }

    public final void f(int v, int v1) {
        switch(this.a) {
            case 0: {
                ((F)this.c).k(v, v1);
                return;
            }
            case 1: {
                ((P.F)this.c).j(v, v1);
                return;
            }
            default: {
                float f = ((float)v1) / ((float)((K)this.c).n());
                ((K)this.c).u(v, true, f);
            }
        }
    }
}

