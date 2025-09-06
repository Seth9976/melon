package Cc;

import androidx.compose.runtime.l;
import ie.H;
import java.util.List;
import r0.q;
import rd.a;
import we.k;
import we.n;

public final class v3 implements n {
    public final int a;
    public final float b;
    public final int c;
    public final int d;
    public final Object e;
    public final Object f;

    public v3(List list0, int v, float f, k k0, int v1) {
        this.a = 0;
        super();
        this.e = list0;
        this.c = v;
        this.b = f;
        this.f = k0;
        this.d = v1;
    }

    public v3(q q0, Object object0, float f, int v, int v1, int v2) {
        this.a = v2;
        this.e = q0;
        this.f = object0;
        this.b = f;
        this.c = v;
        this.d = v1;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                w3.d(((List)this.e), this.c, this.b, ((k)this.f), ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                T3.a(((q)this.e), ((U3)this.f), this.b, ((l)object0), (this.c | 1) & -920350135 | ((0x24924924 & (this.c | 1)) >> 1 | 306783378 & (this.c | 1)) | (306783378 & (this.c | 1)) << 1 & (0x24924924 & (this.c | 1)), this.d);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                a.t(((q)this.e), ((String)this.f), this.b, ((l)object0), (this.c | 1) & -920350135 | ((0x24924924 & (this.c | 1)) >> 1 | 306783378 & (this.c | 1)) | (306783378 & (this.c | 1)) << 1 & (0x24924924 & (this.c | 1)), this.d);
                return H.a;
            }
        }
    }
}

