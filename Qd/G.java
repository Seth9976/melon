package qd;

import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.r;
import we.p;

public final class g extends r implements p {
    public final Object f;
    public final boolean g;

    public g(List list0, boolean z) {
        this.f = list0;
        this.g = z;
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
            Object object4 = ((List)this.f).get(v);
            ((androidx.compose.runtime.p)(((l)object2))).a0(0x18ED9C6B);
            h.b(((String)object4), false, this.g, ((androidx.compose.runtime.p)(((l)object2))), 0, 2);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

