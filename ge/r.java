package Ge;

import Me.J;
import Me.c;
import Nc.K;
import Nc.L;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;

public final class r implements a {
    public final int a;
    public final int b;
    public final Object c;

    public r(Object object0, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            L l0 = new L(((K)this.c), this.b);
            ((K)this.c).e.invoke(l0);
            return H.a;
        }
        Object object0 = ((c)this.c).F().get(this.b);
        q.f(object0, "get(...)");
        return (J)object0;
    }
}

