package ad;

import N0.M;
import P0.i;
import P0.j;
import P0.k;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import com.melon.ui.K4;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import r0.d;
import r0.n;
import r0.q;
import we.p;

public final class h extends r implements p {
    public final ArrayList f;
    public final int g;
    public final int h;
    public final int i;
    public final a j;

    public h(ArrayList arrayList0, int v, int v1, int v2, a j$a0) {
        this.f = arrayList0;
        this.g = v;
        this.h = v1;
        this.i = v2;
        this.j = j$a0;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        float f;
        int v = ((Number)object1).intValue();
        int v1 = ((Number)object3).intValue();
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((androidx.compose.foundation.lazy.a)object0)) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            K4 k40 = (K4)this.f.get(v);
            ((androidx.compose.runtime.p)(((l)object2))).a0(-1859307192);
            if(v == this.g) {
                f = 0.0f;
            }
            else {
                f = v == this.h ? 0.5f : ((float)(v == this.i ? 30 : 40));
            }
            q q0 = androidx.compose.foundation.layout.a.n(n.a, 0.0f, 0.0f, 0.0f, f, 7);
            M m0 = M.p.d(d.a, false);
            int v3 = ((androidx.compose.runtime.p)(((l)object2))).P;
            i0 i00 = ((androidx.compose.runtime.p)(((l)object2))).m();
            q q1 = r0.a.d(((androidx.compose.runtime.p)(((l)object2))), q0);
            k.y.getClass();
            i i0 = j.b;
            ((androidx.compose.runtime.p)(((l)object2))).e0();
            if(((androidx.compose.runtime.p)(((l)object2))).O) {
                ((androidx.compose.runtime.p)(((l)object2))).l(i0);
            }
            else {
                ((androidx.compose.runtime.p)(((l)object2))).o0();
            }
            w.x(((androidx.compose.runtime.p)(((l)object2))), m0, j.f);
            w.x(((androidx.compose.runtime.p)(((l)object2))), i00, j.e);
            P0.h h0 = j.g;
            if(((androidx.compose.runtime.p)(((l)object2))).O || !kotlin.jvm.internal.q.b(((androidx.compose.runtime.p)(((l)object2))).N(), v3)) {
                A7.d.q(v3, ((androidx.compose.runtime.p)(((l)object2))), v3, h0);
            }
            w.x(((androidx.compose.runtime.p)(((l)object2))), q1, j.d);
            this.j.p(k40, ((androidx.compose.runtime.p)(((l)object2))), 0);
            ((androidx.compose.runtime.p)(((l)object2))).p(true);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

