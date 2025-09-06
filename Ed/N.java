package ed;

import androidx.compose.runtime.l;
import d9.h;
import ie.H;
import kc.s2;
import ob.z;
import r0.q;
import rd.x;
import ud.u;
import w8.w0;

public final class n implements we.n {
    public final int a;
    public final Object b;
    public final boolean c;
    public final int d;
    public final Object e;
    public final Object f;
    public final Object g;
    public final Object h;

    public n(a z$a0, String s, boolean z, we.a a0, we.a a1, we.a a2, int v) {
        this.a = 0;
        super();
        this.g = z$a0;
        this.b = s;
        this.c = z;
        this.e = a0;
        this.f = a1;
        this.h = a2;
        this.d = v;
    }

    public n(q q0, String s, String s1, boolean z, int v, we.a a0, we.a a1, int v1) {
        this.a = 1;
        super();
        this.g = q0;
        this.b = s;
        this.h = s1;
        this.c = z;
        this.d = v;
        this.e = a0;
        this.f = a1;
    }

    public n(q q0, String s, boolean z, String s1, String s2, h h0, int v) {
        this.a = 2;
        super();
        this.g = q0;
        this.b = s;
        this.c = z;
        this.e = s1;
        this.f = s2;
        this.h = h0;
        this.d = v;
    }

    public n(w0 w00, z z0, s2 s20, boolean z1, B2.n n0, B2.n n1, int v, int v1) {
        this.a = 3;
        super();
        this.g = w00;
        this.b = z0;
        this.e = s20;
        this.c = z1;
        this.f = n0;
        this.h = n1;
        this.d = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                ((a)this.g).F(((String)this.b), this.c, ((we.a)this.e), ((we.a)this.f), ((we.a)this.h), ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                x.i(((q)this.g), ((String)this.b), ((String)this.h), this.c, this.d, ((we.a)this.e), ((we.a)this.f), ((l)object0), 1);
                return H.a;
            }
            case 2: {
                ((Integer)object1).getClass();
                u.f(((q)this.g), ((String)this.b), this.c, ((String)this.e), ((String)this.f), ((h)this.h), ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                ((w0)this.g).k(((z)this.b), ((s2)this.e), this.c, ((B2.n)this.f), ((B2.n)this.h), ((l)object0), 1, this.d);
                return H.a;
            }
        }
    }
}

