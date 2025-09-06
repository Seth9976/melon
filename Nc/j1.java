package Nc;

import V4.u;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import r0.n;
import we.p;

public final class j1 extends r implements p {
    public final int f;
    public final float g;
    public final Object h;

    public j1(List list0, float f, int v) {
        this.f = v;
        this.h = list0;
        this.g = f;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        if(this.f != 0) {
            int v = ((Number)object1).intValue();
            int v1 = ((Number)object3).intValue();
            int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
            if((v1 & 0x30) == 0) {
                v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
            }
            boolean z = true;
            if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                String s = (String)((List)this.h).get(v);
                ((androidx.compose.runtime.p)(((l)object2))).a0(0xE0301ECF);
                if(v != 0) {
                    z = false;
                }
                Rc.a.A(s, z, this.g, ((androidx.compose.runtime.p)(((l)object2))), 0);
                ((androidx.compose.runtime.p)(((l)object2))).p(false);
                return H.a;
            }
            ((androidx.compose.runtime.p)(((l)object2))).T();
            return H.a;
        }
        int v3 = ((Number)object1).intValue();
        int v4 = ((Number)object3).intValue();
        int v5 = (v4 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v4 : v4;
        if((v4 & 0x30) == 0) {
            v5 |= (((androidx.compose.runtime.p)(((l)object2))).e(v3) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v5 & 1, (v5 & 0x93) != 0x92)) {
            p1 p10 = (p1)((ArrayList)this.h).get(v3);
            ((androidx.compose.runtime.p)(((l)object2))).a0(-390747483);
            u.d(d.q(n.a, this.g), p10, ((androidx.compose.runtime.p)(((l)object2))), 0);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

