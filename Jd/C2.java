package jd;

import androidx.compose.runtime.l;
import ie.H;
import ie.f;
import java.util.List;
import r0.q;
import we.a;
import we.k;
import we.n;

public final class c2 implements n {
    public final int a;
    public final boolean b;
    public final int c;
    public final a d;
    public final int e;
    public final Object f;
    public final f g;
    public final f h;
    public final f i;
    public final Object j;

    public c2(q q0, boolean z, int v, a a0, a a1, a a2, a a3, a a4, int v1) {
        this.a = 2;
        super();
        this.f = q0;
        this.b = z;
        this.c = v;
        this.d = a0;
        this.g = a1;
        this.h = a2;
        this.i = a3;
        this.j = a4;
        this.e = v1;
    }

    public c2(boolean z, int v, a a0, a a1, a a2, a a3, a a4, a a5, int v1) {
        this.a = 1;
        super();
        this.b = z;
        this.c = v;
        this.d = a0;
        this.f = a1;
        this.g = a2;
        this.h = a3;
        this.i = a4;
        this.j = a5;
        this.e = v1;
    }

    public c2(boolean z, String s, int v, k k0, List list0, k k1, k k2, a a0, int v1) {
        this.a = 0;
        super();
        this.b = z;
        this.f = s;
        this.c = v;
        this.g = k0;
        this.j = list0;
        this.h = k1;
        this.i = k2;
        this.d = a0;
        this.e = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                n2.a(this.b, ((String)this.f), this.c, ((k)this.g), ((List)this.j), ((k)this.h), ((k)this.i), this.d, ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                rd.a.d(this.b, this.c, this.d, ((a)this.f), ((a)this.g), ((a)this.h), ((a)this.i), ((a)this.j), ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                rd.a.p(((q)this.f), this.b, this.c, this.d, ((a)this.g), ((a)this.h), ((a)this.i), ((a)this.j), ((l)object0), (this.e | 1) & -920350135 | ((0x24924924 & (this.e | 1)) >> 1 | 306783378 & (this.e | 1)) | (306783378 & (this.e | 1)) << 1 & (0x24924924 & (this.e | 1)));
                return H.a;
            }
        }
    }
}

