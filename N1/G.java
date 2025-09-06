package n1;

import De.d;
import java.util.ArrayList;
import java.util.Collection;
import je.p;
import kotlin.jvm.internal.q;
import q1.c;
import we.k;

public final class g extends i {
    public final d c;

    public g(d d0, k k0) {
        super(k0);
        this.c = d0;
    }

    @Override  // n1.i
    public final void a(Collection collection0) {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: collection0) {
            if(((c)object0).c != null) {
                arrayList0.add(object0);
            }
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object1: arrayList0) {
            Object object2 = g.c(((c)object1), this.c);
            if(object2 != null) {
                arrayList1.add(object2);
            }
        }
        Collection collection1 = p.T0(arrayList1);
        this.b.addAll(collection1);
    }

    @Override  // n1.i
    public final boolean b(c c0) {
        return c0.c != null && g.c(c0, this.c) != null;
    }

    public static Object c(c c0, d d0) {
        Object object0 = null;
        for(Object object1: ((Iterable)c0.f)) {
            if(q.b((object1 == null ? null : df.d.y(object1.getClass())), d0)) {
                object0 = object1;
                break;
            }
        }
        q.g(d0, "<this>");
        if(d0.k(object0)) {
            q.e(object0, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.safeCast");
            return object0;
        }
        return null;
    }
}

