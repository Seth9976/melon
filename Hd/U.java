package hd;

import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import we.k;
import we.p;

public final class u extends r implements p {
    public final ArrayList f;
    public final boolean g;
    public final k h;

    public u(ArrayList arrayList0, boolean z, k k0) {
        this.f = arrayList0;
        this.g = z;
        this.h = k0;
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
            Object object4 = this.f.get(v);
            ((androidx.compose.runtime.p)(((l)object2))).a0(0x5DD3975E);
            H.f(a.a(((a)object0)), ((ArrayList)object4), v, this.g, this.h, ((androidx.compose.runtime.p)(((l)object2))), (v2 & 0x7E) << 3 & 0x380);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return ie.H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return ie.H.a;
    }
}

