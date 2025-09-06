package n1;

import G.t0;
import ie.H;
import java.util.Set;
import je.n;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.r;
import o1.d;
import we.k;

public final class m extends r implements k {
    public final t0 f;
    public final q g;

    public m(t0 t00, q q0) {
        this.f = t00;
        this.g = q0;
        super(1);
    }

    public final void d() {
        t0 t00 = this.f;
        s s0 = null;
        if(b.c) {
            Object object0 = t00.c();
            if(object0 != null) {
                Object[] arr_object = object0.getClass().getEnumConstants();
                Set set0 = arr_object == null ? e1.m.E(object0) : n.A0(arr_object);
                if(t00.c == null) {
                    Class class0 = object0.getClass();
                    I.a.b(class0).m();
                }
                s0 = new b(t00, set0);
            }
        }
        q q0 = this.g;
        if(s0 != null) {
            d d0 = new d(s0);
            q0.e.put(s0, d0);
            return;
        }
        q0.a();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        this.d();
        return H.a;
    }
}

