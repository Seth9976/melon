package M;

import O.k;
import P.j;
import Q.B;
import Q.x;
import androidx.compose.foundation.lazy.layout.g;
import androidx.compose.runtime.l;
import ie.H;
import kotlin.jvm.internal.r;
import r0.q;
import we.n;

public final class m extends r implements n {
    public final int f;
    public final int g;
    public final Object h;

    public m(Object object0, int v, int v1) {
        this.f = v1;
        this.h = object0;
        this.g = v;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                ((Number)object1).intValue();
                p.a(((q)this.h), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)));
                return H.a;
            }
            case 1: {
                int v1 = ((Number)object1).intValue();
                if(((androidx.compose.runtime.p)(((l)object0))).Q(v1 & 1, (v1 & 3) != 2)) {
                    g g1 = ((k)this.h).b.b.l(this.g);
                    ((O.g)g1.c).c.invoke(((k)this.h).c, ((int)(this.g - g1.a)), ((androidx.compose.runtime.p)(((l)object0))), 0);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object0))).T();
                return H.a;
            }
            case 2: {
                int v2 = ((Number)object1).intValue();
                if(((androidx.compose.runtime.p)(((l)object0))).Q(v2 & 1, (v2 & 3) != 2)) {
                    g g2 = ((j)this.h).b.c.l(this.g);
                    ((P.g)g2.c).d.invoke(P.l.a, ((int)(this.g - g2.a)), ((androidx.compose.runtime.p)(((l)object0))), 6);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object0))).T();
                return H.a;
            }
            default: {
                int v = ((Number)object1).intValue();
                if(((androidx.compose.runtime.p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    g g0 = ((x)this.h).b.n().l(this.g);
                    ((Q.p)g0.c).b.invoke(B.a, ((int)(this.g - g0.a)), ((androidx.compose.runtime.p)(((l)object0))), 0);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object0))).T();
                return H.a;
            }
        }
    }
}

