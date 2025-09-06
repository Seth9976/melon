package cd;

import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.r;
import we.p;

public final class w0 extends r implements p {
    public final int f;
    public final Object g;

    public w0(List list0, int v) {
        this.f = v;
        this.g = list0;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        switch(this.f) {
            case 0: {
                int v3 = ((Number)object1).intValue();
                int v4 = ((Number)object3).intValue();
                int v5 = (v4 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v4 : v4;
                if((v4 & 0x30) == 0) {
                    v5 |= (((androidx.compose.runtime.p)(((l)object2))).e(v3) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v5 & 1, (v5 & 0x93) != 0x92)) {
                    q0 q00 = (q0)((List)this.g).get(v3);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0xCDD50769);
                    B0.d(q00, ((androidx.compose.runtime.p)(((l)object2))), 0);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 1: {
                int v6 = ((Number)object1).intValue();
                int v7 = ((Number)object3).intValue();
                int v8 = (v7 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v7 : v7;
                if((v7 & 0x30) == 0) {
                    v8 |= (((androidx.compose.runtime.p)(((l)object2))).e(v6) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v8 & 1, (v8 & 0x93) != 0x92)) {
                    P2 p20 = (P2)((List)this.g).get(v6);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0x607591AE);
                    Y2.a(p20, v6, ((androidx.compose.runtime.p)(((l)object2))), v8 & 0x70);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            default: {
                int v = ((Number)object1).intValue();
                int v1 = ((Number)object3).intValue();
                int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    String s = (String)((List)this.g).get(v);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0x630C1F1E);
                    ud.a.d(s, false, ((androidx.compose.runtime.p)(((l)object2))), 0x30);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
        }
    }
}

