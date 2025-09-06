package Cc;

import com.melon.ui.K4;
import ie.H;
import j5.l;
import java.io.Serializable;
import r0.e;
import r0.q;
import we.a;
import we.k;
import we.n;
import y0.t;
import zd.O;
import zd.Q;
import zd.v;

public final class n0 implements n {
    public final int a;
    public final Serializable b;
    public final int c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;
    public final Object h;

    public n0(String s, int v, String s1, String s2, String s3, q q0, a a0, int v1) {
        this.a = 1;
        super();
        this.b = s;
        this.c = v;
        this.d = s1;
        this.e = s2;
        this.g = s3;
        this.h = q0;
        this.f = a0;
    }

    public n0(String s, String s1, String s2, int v, a a0, a a1, a a2, int v1) {
        this.a = 0;
        super();
        this.b = s;
        this.d = s1;
        this.e = s2;
        this.c = v;
        this.f = a0;
        this.g = a1;
        this.h = a2;
    }

    public n0(String s, String s1, String s2, String s3, String s4, int v, k k0, int v1) {
        this.a = 2;
        super();
        this.b = s;
        this.d = s1;
        this.e = s2;
        this.f = s3;
        this.g = s4;
        this.c = v;
        this.h = k0;
    }

    public n0(q q0, l l0, String s, e e0, N0.k k0, t t0, int v) {
        this.a = 4;
        super();
        this.d = q0;
        this.e = l0;
        this.b = s;
        this.f = e0;
        this.g = k0;
        this.h = t0;
        this.c = v;
    }

    public n0(q q0, String s, String s1, String s2, int v, a a0, a a1, int v1) {
        this.a = 3;
        super();
        this.h = q0;
        this.b = s;
        this.d = s1;
        this.e = s2;
        this.c = v;
        this.f = a0;
        this.g = a1;
    }

    public n0(Q q0, O o0, K4 k40, k k0, k k1, int v, a a0, int v1) {
        this.a = 5;
        super();
        this.b = q0;
        this.d = o0;
        this.e = k40;
        this.g = k0;
        this.h = k1;
        this.c = v;
        this.f = a0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                q0.e(((String)this.b), ((String)this.d), ((String)this.e), this.c, ((a)this.f), ((a)this.g), ((a)this.h), ((androidx.compose.runtime.l)object0), 1);
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                e0.q(((String)this.b), this.c, ((String)this.d), ((String)this.e), ((String)this.g), ((q)this.h), ((a)this.f), ((androidx.compose.runtime.l)object0), 1);
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                w3.f(((String)this.b), ((String)this.d), ((String)this.e), ((String)this.f), ((String)this.g), this.c, ((k)this.h), ((androidx.compose.runtime.l)object0), 1);
                return H.a;
            }
            case 3: {
                ((Integer)object1).getClass();
                a.a.a(((q)this.h), ((String)this.b), ((String)this.d), ((String)this.e), this.c, ((a)this.f), ((a)this.g), ((androidx.compose.runtime.l)object0), 7);
                return H.a;
            }
            case 4: {
                ((Integer)object1).getClass();
                j5.n.c(((q)this.d), ((l)this.e), ((String)this.b), ((e)this.f), ((N0.k)this.g), ((t)this.h), ((androidx.compose.runtime.l)object0), (this.c | 1) & -920350135 | ((0x24924924 & (this.c | 1)) >> 1 | 306783378 & (this.c | 1)) | (306783378 & (this.c | 1)) << 1 & (0x24924924 & (this.c | 1)));
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                v.b(((Q)this.b), ((O)this.d), ((K4)this.e), ((k)this.g), ((k)this.h), this.c, ((a)this.f), ((androidx.compose.runtime.l)object0), 1);
                return H.a;
            }
        }
    }
}

