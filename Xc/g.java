package xc;

import M.i0;
import O.F;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import ie.H;
import kotlin.jvm.internal.q;
import we.p;

public final class g implements p {
    public final int a;
    public final k b;

    public g(k k0, int v) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        if(this.a != 0) {
            int v = (int)(((Integer)object3));
            q.g(((i0)object0), "contentPadding");
            q.g(((F)object1), "lazyListState");
            int v1 = (v & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((i0)object0)) ? 4 : 2) | v : v;
            if((v & 0x30) == 0) {
                v1 |= (((androidx.compose.runtime.p)(((l)object2))).g(((F)object1)) ? 0x20 : 16);
            }
            if(((androidx.compose.runtime.p)(((l)object2))).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
                this.b.m(((i0)object0), ((F)object1), ((androidx.compose.runtime.p)(((l)object2))), v1 & 0x7E);
                return H.a;
            }
            ((androidx.compose.runtime.p)(((l)object2))).T();
            return H.a;
        }
        int v2 = (int)(((Integer)object1));
        int v3 = (int)(((Integer)object3));
        q.g(((a)object0), "$this$items");
        if((v3 & 0x30) == 0) {
            v3 |= (((androidx.compose.runtime.p)(((l)object2))).e(v2) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v3 & 1, (v3 & 0x91) != 0x90)) {
            this.b.r(v2, ((androidx.compose.runtime.p)(((l)object2))), v3 >> 3 & 14);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

