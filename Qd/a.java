package qd;

import O.F;
import androidx.compose.runtime.l;
import ie.H;
import java.util.List;
import kc.s2;
import kotlinx.coroutines.flow.Flow;
import ob.z;
import r0.q;
import w8.A;
import w8.Q;
import w8.m;
import w8.w0;
import we.n;

public final class a implements n {
    public final int a;
    public final boolean b;
    public final long c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;

    public a(q q0, List list0, F f0, Integer integer0, long v, boolean z, int v1) {
        this.a = 0;
        super();
        this.d = q0;
        this.e = list0;
        this.f = f0;
        this.g = integer0;
        this.c = v;
        this.b = z;
    }

    public a(w0 w00, Flow flow0, z z0, s2 s20, boolean z1, long v, int v1, int v2) {
        this.a = v2;
        this.d = w00;
        this.e = flow0;
        this.f = z0;
        this.g = s20;
        this.b = z1;
        this.c = v;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                h.c(((q)this.d), ((List)this.e), ((F)this.f), ((Integer)this.g), this.c, this.b, ((l)object0), 1);
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                ((m)this.d).m(((Flow)this.e), ((z)this.f), ((s2)this.g), this.b, this.c, ((l)object0), 1);
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                ((w8.q)this.d).m(((Flow)this.e), ((z)this.f), ((s2)this.g), this.b, this.c, ((l)object0), 1);
                return H.a;
            }
            case 3: {
                ((Integer)object1).getClass();
                ((A)this.d).m(((Flow)this.e), ((z)this.f), ((s2)this.g), this.b, this.c, ((l)object0), 1);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                ((Q)this.d).m(((Flow)this.e), ((z)this.f), ((s2)this.g), this.b, this.c, ((l)object0), 1);
                return H.a;
            }
        }
    }
}

