package M;

import F.g;
import N0.O;
import N0.Z;
import N0.a0;
import N0.d;
import P0.f;
import ie.H;
import java.io.Serializable;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import r1.m;
import w0.u;
import w0.v;
import we.k;

public final class x extends r implements k {
    public final int f;
    public final int g;
    public final Object h;
    public final Object i;
    public final Object j;
    public final Serializable k;

    public x(v v0, u u0, u u1, Object object0, int v1, g g0, int v2) {
        this.f = v2;
        this.h = u0;
        this.i = u1;
        this.j = object0;
        this.g = v1;
        this.k = g0;
        super(1);
    }

    public x(a0[] arr_a0, y y0, int v, O o0, int[] arr_v) {
        this.f = 0;
        this.h = arr_a0;
        this.i = y0;
        this.g = v;
        this.j = o0;
        this.k = arr_v;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                a0[] arr_a0 = (a0[])this.h;
                y y0 = (y)this.i;
                O o0 = (O)this.j;
                int[] arr_v = (int[])this.k;
                int v = 0;
                for(int v1 = 0; v < arr_a0.length; ++v1) {
                    a0 a00 = arr_a0[v];
                    q.d(a00);
                    Object object1 = a00.q();
                    c c0 = null;
                    m0 m00 = object1 instanceof m0 ? ((m0)object1) : null;
                    m m0 = o0.getLayoutDirection();
                    if(m00 != null) {
                        c0 = m00.c;
                    }
                    Z.e(((Z)object0), a00, (c0 == null ? y0.b.a(0, this.g - a00.a, m0) : c0.e(this.g - a00.a, m0)), arr_v[v1]);
                    ++v;
                }
                return H.a;
            }
            case 1: {
                u u2 = (u)this.i;
                u u3 = ((w0.k)((Q0.u)f.w(u2)).getFocusOwner()).l;
                if(((u)this.h) != u3) {
                    return true;
                }
                boolean z1 = w0.f.C(u2, ((u)this.j), this.g, ((g)this.k));
                return z1 || !((d)object0).a() ? Boolean.valueOf(z1) : null;
            }
            default: {
                u u0 = (u)this.i;
                u u1 = ((w0.k)((Q0.u)f.w(u0)).getFocusOwner()).l;
                if(((u)this.h) != u1) {
                    return true;
                }
                boolean z = w0.f.B(this.g, ((g)this.k), u0, ((x0.c)this.j));
                return z || !((d)object0).a() ? Boolean.valueOf(z) : null;
            }
        }
    }
}

