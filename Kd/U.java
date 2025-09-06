package kd;

import Gf.j;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import ie.H;
import java.util.List;
import jd.x2;
import kotlin.jvm.internal.r;
import we.a;
import we.k;
import we.p;

public final class u extends r implements p {
    public final List f;
    public final String g;
    public final String h;
    public final a i;
    public final k j;
    public final b0 k;

    public u(List list0, String s, String s1, a a0, k k0, b0 b00) {
        this.f = list0;
        this.g = s;
        this.h = s1;
        this.i = a0;
        this.j = k0;
        this.k = b00;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        int v = ((Number)object1).intValue();
        int v1 = ((Number)object3).intValue();
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((androidx.compose.foundation.lazy.a)object0)) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Object object4 = this.f.get(v);
            ((androidx.compose.runtime.p)(((l)object2))).a0(-456814190);
            k k0 = this.j;
            boolean z = ((androidx.compose.runtime.p)(((l)object2))).g(k0);
            boolean z1 = ((androidx.compose.runtime.p)(((l)object2))).i(((x2)object4));
            j j0 = ((androidx.compose.runtime.p)(((l)object2))).N();
            if(z || z1 || j0 == androidx.compose.runtime.k.a) {
                j0 = new j(this.k, k0, ((x2)object4));
                ((androidx.compose.runtime.p)(((l)object2))).l0(j0);
            }
            G.i(((x2)object4), this.g, this.h, this.i, j0, ((androidx.compose.runtime.p)(((l)object2))), 0);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

