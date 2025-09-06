package df;

import Se.b;
import Se.t;
import Sf.g;
import Sf.n;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import je.D;
import je.I;
import je.p;
import kotlin.jvm.internal.q;
import we.a;

public final class l implements a {
    public final int a;
    public final o b;

    public l(o o0, int v) {
        this.a = v;
        this.b = o0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                Class[] arr_class = this.b.o.a.getDeclaredClasses();
                q.f(arr_class, "getDeclaredClasses(...)");
                return p.T0(n.p0(n.o0(new g(je.n.O(arr_class), false, b.d), b.e)));
            }
            case 1: {
                Iterable iterable0 = this.b.o.b();
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: iterable0) {
                    if(((t)object0).a.isEnumConstant()) {
                        arrayList0.add(object0);
                    }
                }
                int v = D.N(je.q.Q(10, arrayList0));
                if(v < 16) {
                    v = 16;
                }
                LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
                for(Object object1: arrayList0) {
                    linkedHashMap0.put(((t)object1).c(), object1);
                }
                return linkedHashMap0;
            }
            default: {
                return I.K(this.b.a(), this.b.g());
            }
        }
    }
}

