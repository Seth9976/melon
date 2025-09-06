package M;

import I.u0;
import N0.O;
import N0.Z;
import N0.a0;
import U.J0;
import U.Q0;
import U.V;
import U.b0;
import androidx.collection.F;
import androidx.compose.runtime.E;
import ie.H;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import m0.d;
import p0.t;
import r1.m;
import we.k;

public final class o0 extends r implements k {
    public final int f;
    public final int g;
    public final Object h;
    public final Object i;
    public final Object j;

    public o0(Object object0, Object object1, Object object2, int v, int v1) {
        this.f = v1;
        this.h = object0;
        this.i = object1;
        this.j = object2;
        this.g = v;
        super(1);
    }

    public o0(a0[] arr_a0, p0 p00, int v, int[] arr_v) {
        this.f = 0;
        this.h = arr_a0;
        this.i = p00;
        this.g = v;
        this.j = arr_v;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                a0[] arr_a0 = (a0[])this.h;
                p0 p00 = (p0)this.i;
                int[] arr_v = (int[])this.j;
                int v2 = 0;
                for(int v3 = 0; v2 < arr_a0.length; ++v3) {
                    a0 a00 = arr_a0[v2];
                    q.d(a00);
                    Object object1 = a00.q();
                    c c0 = null;
                    m0 m00 = object1 instanceof m0 ? ((m0)object1) : null;
                    if(m00 != null) {
                        c0 = m00.c;
                    }
                    int v4 = c0 == null ? p00.b.a(0, this.g - a00.b) : c0.e(this.g - a00.b, m.a);
                    Z.e(((Z)object0), a00, arr_v[v3], v4);
                    ++v2;
                }
                return H.a;
            }
            case 1: {
                O o0 = (O)this.h;
                J0 j00 = (J0)((V)this.i).d.invoke();
                x0.c c1 = b0.l(o0, ((V)this.i).b, ((V)this.i).c, (j00 == null ? null : j00.a), o0.getLayoutDirection() == m.b, ((a0)this.j).a);
                ((V)this.i).a.b(u0.b, c1, this.g, ((a0)this.j).a);
                Z.g(((Z)object0), ((a0)this.j), Math.round(-((V)this.i).a.a()), 0);
                return H.a;
            }
            case 2: {
                J0 j01 = (J0)((Q0)this.i).d.invoke();
                x0.c c2 = b0.l(((O)this.h), ((Q0)this.i).b, ((Q0)this.i).c, (j01 == null ? null : j01.a), false, ((a0)this.j).a);
                ((Q0)this.i).a.b(u0.a, c2, this.g, ((a0)this.j).b);
                Z.g(((Z)object0), ((a0)this.j), 0, Math.round(-((Q0)this.i).a.a()));
                return H.a;
            }
            default: {
                if(object0 == ((E)this.h)) {
                    throw new IllegalStateException("A derived state calculation cannot read itself");
                }
                if(object0 instanceof t) {
                    int v = ((d)this.i).a;
                    int v1 = ((F)this.j).d(object0);
                    ((F)this.j).g(Math.min(v - this.g, (v1 < 0 ? 0x7FFFFFFF : ((F)this.j).c[v1])), object0);
                }
                return H.a;
            }
        }
    }
}

