package ud;

import Qc.e;
import Qc.f;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import we.n;

public final class r implements n {
    public final int a;
    public final Object b;

    public r(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((n)this.b).invoke(((Number)object1).intValue(), ((Number)object0).longValue());
                return H.a;
            }
            case 1: {
                ((n)this.b).invoke(((Number)object1).intValue(), ((Number)object0).longValue());
                return H.a;
            }
            default: {
                int v = ((Number)object1).intValue();
                f f0 = (f)this.b;
                if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    boolean z = ((p)(((l)object0))).i(f0);
                    e e0 = ((p)(((l)object0))).N();
                    if(z || e0 == k.a) {
                        e0 = new e(0, f0);
                        ((p)(((l)object0))).l0(e0);
                    }
                    f0.o(e0, ((p)(((l)object0))), 0);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
        }
    }
}

