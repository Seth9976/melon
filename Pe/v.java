package Pe;

import Af.o;
import Me.E;
import com.google.firebase.b;
import java.util.ArrayList;
import java.util.List;
import je.p;
import je.q;
import qf.c;
import we.a;

public final class v implements a {
    public final int a;
    public final w b;

    public v(w w0, int v) {
        this.a = v;
        this.b = w0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                this.b.c.s1();
                return Me.w.i(((l)this.b.c.k.getValue()), this.b.d);
            }
            case 1: {
                this.b.c.s1();
                return Boolean.valueOf(Me.w.h(((l)this.b.c.k.getValue()), this.b.d));
            }
            default: {
                w w0 = this.b;
                De.w[] arr_w = w.h;
                boolean z = ((Boolean)P4.a.r(w0.f, arr_w[1])).booleanValue();
                c c0 = w0.d;
                A a0 = w0.c;
                if(z) {
                    return o.b;
                }
                Iterable iterable0 = (List)P4.a.r(w0.e, arr_w[0]);
                ArrayList arrayList0 = new ArrayList(q.Q(10, iterable0));
                for(Object object0: iterable0) {
                    arrayList0.add(((E)object0).E());
                }
                ArrayList arrayList1 = p.z0(new M(a0, c0), arrayList0);
                return b.v(("package view scope for " + c0 + " in " + a0.getName()), arrayList1);
            }
        }
    }
}

