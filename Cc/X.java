package Cc;

import Rc.K;
import Rc.O;
import androidx.compose.runtime.l;
import ie.H;
import r0.q;
import rd.a;
import we.n;

public final class x implements n {
    public final int a;
    public final Object b;
    public final boolean c;
    public final int d;

    public x(Object object0, boolean z, int v, int v1) {
        this.a = v1;
        this.b = object0;
        this.c = z;
        this.d = v;
        super();
    }

    public x(q q0, boolean z, int v, int v1) {
        this.a = 1;
        super();
        this.b = q0;
        this.c = z;
        this.d = v;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                e0.k(((q)this.b), this.c, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                a.k(((q)this.b), this.c, this.d, ((l)object0), 1);
                return H.a;
            }
            default: {
                ((Integer)object1).getClass();
                K.c(((O)this.b), this.c, ((l)object0), (this.d | 1) & -920350135 | ((0x24924924 & (this.d | 1)) >> 1 | 306783378 & (this.d | 1)) | (306783378 & (this.d | 1)) << 1 & (0x24924924 & (this.d | 1)));
                return H.a;
            }
        }
    }
}

