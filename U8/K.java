package U8;

import Cc.e;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.r;
import we.p;
import y8.i;

public final class k extends r implements p {
    public final List f;
    public final int g;
    public final b0 h;
    public final we.k i;
    public final we.k j;
    public final boolean k;

    public k(List list0, int v, b0 b00, we.k k0, we.k k1, boolean z) {
        this.f = list0;
        this.g = v;
        this.h = b00;
        this.i = k0;
        this.j = k1;
        this.k = z;
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
        boolean z = true;
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            i i0 = (i)this.f.get(v);
            ((androidx.compose.runtime.p)(((l)object2))).a0(1420075529);
            C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
            boolean z1 = i0.a() == this.g;
            c0.a = z1;
            if(z1) {
                this.h.setValue(v);
            }
            boolean z2 = c0.a;
            String s = i0.b();
            we.k k0 = this.i;
            h h0 = new h(this.h, v, c0, this.j, this.k);
            boolean z3 = ((androidx.compose.runtime.p)(((l)object2))).g(k0);
            if(((v2 & 0x70 ^ 0x30) <= 0x20 || !((androidx.compose.runtime.p)(((l)object2))).e(v)) && (v2 & 0x30) != 0x20) {
                z = false;
            }
            e e0 = ((androidx.compose.runtime.p)(((l)object2))).N();
            if(z3 || z || e0 == androidx.compose.runtime.k.a) {
                e0 = new e(k0, v, 1);
                ((androidx.compose.runtime.p)(((l)object2))).l0(e0);
            }
            U8.p.f(s, z2, h0, k0 != null, e0, ((androidx.compose.runtime.p)(((l)object2))), 0);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

