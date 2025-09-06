package n1;

import G.t0;
import e1.m;
import ie.H;
import java.util.Set;
import je.n;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.r;
import o1.d;
import we.k;

public final class p extends r implements k {
    public final t0 f;
    public final q g;

    public p(t0 t00, q q0) {
        this.f = t00;
        this.g = q0;
        super(1);
    }

    public final void d() {
        t t0;
        t0 t00 = this.f;
        Object object0 = t00.c();
        if(object0 == null) {
            t0 = null;
        }
        else {
            Object[] arr_object = object0.getClass().getEnumConstants();
            Set set0 = arr_object == null ? m.E(object0) : n.A0(arr_object);
            if(t00.c == null) {
                Class class0 = object0.getClass();
                I.a.b(class0).m();
            }
            t0 = new t(t00, set0);
        }
        q q0 = this.g;
        if(t0 != null) {
            d d0 = new d(t0);
            q0.a.put(t0, d0);
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

