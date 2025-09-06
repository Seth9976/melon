package jd;

import Ce.g;
import ie.H;
import je.u;
import kotlin.jvm.internal.q;
import we.k;

public final class w1 implements k {
    public final int a;
    public final F1 b;

    public w1(F1 f10, int v) {
        this.a = v;
        this.b = f10;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            F1 f10 = this.b;
            if(((Boolean)object0).booleanValue()) {
                Y1 y10 = (Y1)f10.getViewModel();
                y10.e.clear();
                g g0 = e.k.r(y10.d);
                u.U(y10.e, g0);
                y10.g();
                return H.a;
            }
            Y1 y11 = (Y1)f10.getViewModel();
            y11.e.clear();
            y11.g();
            return H.a;
        }
        q.g(((String)object0), "text");
        Y1 y12 = (Y1)this.b.getViewModel();
        y12.getClass();
        y12.f = (String)object0;
        return H.a;
    }
}

