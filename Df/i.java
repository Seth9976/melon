package df;

import Me.S;
import Me.w;
import Se.B;
import Se.n;
import cf.e;
import java.util.ArrayList;
import je.q;
import we.a;
import xf.d;

public final class i implements a {
    public final int a;
    public final j b;

    public i(j j0, int v) {
        this.a = v;
        this.b = j0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                j j0 = this.b;
                if(d.f(j0) != null) {
                    ((cf.a)j0.g.a).w.getClass();
                }
                return null;
            }
            case 1: {
                j j1 = this.b;
                n n0 = j1.h;
                ArrayList arrayList0 = n0.getTypeParameters();
                ArrayList arrayList1 = new ArrayList(q.Q(10, arrayList0));
                for(Object object0: arrayList0) {
                    B b0 = (B)object0;
                    S s0 = ((e)j1.j.b).c(b0);
                    if(s0 == null) {
                        throw new AssertionError("Parameter " + b0 + " surely belongs to class " + n0 + ", so it must be resolved");
                    }
                    arrayList1.add(s0);
                }
                return arrayList1;
            }
            default: {
                return w.c(this.b);
            }
        }
    }
}

