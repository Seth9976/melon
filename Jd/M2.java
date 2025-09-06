package jd;

import U4.x;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.r;
import r0.n;
import we.k;
import we.p;

public final class m2 extends r implements p {
    public final Object f;
    public final int g;
    public final int h;
    public final k i;
    public final Object j;

    public m2(List list0, int v, int v1, k k0, List list1) {
        this.f = list0;
        this.g = v;
        this.h = v1;
        this.i = k0;
        this.j = list1;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        int v = ((Number)object1).intValue();
        int v1 = ((Number)object3).intValue();
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            jd.a a0 = (jd.a)((List)this.f).get(v);
            ((androidx.compose.runtime.p)(((l)object2))).a0(-213820355);
            n n0 = n.a;
            int v3 = this.g;
            if(v == 0) {
                ((androidx.compose.runtime.p)(((l)object2))).a0(0xF3416BFA);
                x.z(n0, ((float)v3), ((androidx.compose.runtime.p)(((l)object2))), false);
            }
            else {
                ((androidx.compose.runtime.p)(((l)object2))).a0(0xF1FCA3CC);
                ((androidx.compose.runtime.p)(((l)object2))).p(false);
            }
            n2.f(v, a0.b, this.h == v, this.i, ((androidx.compose.runtime.p)(((l)object2))), (v2 & 0x7E) >> 3 & 14);
            if(v == ((List)this.j).size() - 1) {
                ((androidx.compose.runtime.p)(((l)object2))).a0(0xF346F63A);
                x.z(n0, ((float)v3), ((androidx.compose.runtime.p)(((l)object2))), false);
            }
            else {
                ((androidx.compose.runtime.p)(((l)object2))).a0(0xF1FCA3CC);
                ((androidx.compose.runtime.p)(((l)object2))).p(false);
            }
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

