package Pe;

import Me.H;
import Me.w;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import qf.c;
import we.k;

public final class l implements H {
    public final List a;
    public final String b;

    public l(List list0, String s) {
        q.g(s, "debugName");
        super();
        this.a = list0;
        this.b = s;
        list0.size();
        p.T0(list0).size();
    }

    @Override  // Me.H
    public final void a(c c0, ArrayList arrayList0) {
        q.g(c0, "fqName");
        for(Object object0: this.a) {
            w.b(((H)object0), c0, arrayList0);
        }
    }

    @Override  // Me.H
    public final boolean b(c c0) {
        q.g(c0, "fqName");
        Iterable iterable0 = this.a;
        if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
            return true;
        }
        for(Object object0: iterable0) {
            if(!w.h(((H)object0), c0)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override  // Me.H
    public final Collection l(c c0, k k0) {
        q.g(c0, "fqName");
        Collection collection0 = new HashSet();
        for(Object object0: this.a) {
            ((AbstractCollection)collection0).addAll(((H)object0).l(c0, k0));
        }
        return collection0;
    }

    @Override
    public final String toString() {
        return this.b;
    }
}

