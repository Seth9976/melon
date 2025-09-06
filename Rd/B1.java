package rd;

import androidx.lifecycle.f0;
import ie.H;
import kc.d3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import oc.Q;
import oc.w;
import od.b;
import pc.z0;
import we.a;

public final class b1 implements a {
    public final int a;
    public final K1 b;

    public b1(K1 k10, int v) {
        this.a = v;
        this.b = k10;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        K1 k10 = this.b;
        switch(this.a) {
            case 0: {
                return new n0.a(k10, 1);
            }
            case 1: {
                return new b(new b1(k10, 2));
            }
            case 2: {
                Object object0 = k10.q.getValue();
                D0 d00 = object0 instanceof D0 ? ((D0)object0) : null;
                return d00 != null ? d00.a : null;
            }
            case 3: {
                w w0 = ((d3)k10.c).k();
                Q q0 = w0 == null ? null : w0.getState();
                z0 z00 = q0 instanceof z0 ? ((z0)q0) : null;
                return z00 != null ? String.valueOf(z00.b + 1) : null;
            }
            default: {
                BuildersKt__Builders_commonKt.launch$default(f0.h(k10), null, null, new D1(k10, null), 3, null);
                return H.a;
            }
        }
    }
}

