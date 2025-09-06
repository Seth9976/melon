package Pe;

import Af.f;
import Af.q;
import Me.z;
import P4.a;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import je.y;
import qf.c;
import qf.e;
import we.k;

public final class M extends q {
    public final z b;
    public final c c;

    public M(z z0, c c0) {
        kotlin.jvm.internal.q.g(z0, "moduleDescriptor");
        kotlin.jvm.internal.q.g(c0, "fqName");
        super();
        this.b = z0;
        this.c = c0;
    }

    @Override  // Af.q
    public final Set d() {
        return y.a;
    }

    @Override  // Af.q
    public final Collection e(f f0, k k0) {
        kotlin.jvm.internal.q.g(f0, "kindFilter");
        if(f0.a(f.h)) {
            c c0 = this.c;
            if(!c0.a.c() || !f0.a.contains(Af.c.a)) {
                z z0 = this.b;
                Collection collection0 = z0.l(c0, k0);
                Collection collection1 = new ArrayList(collection0.size());
                Iterator iterator0 = collection0.iterator();
                while(iterator0.hasNext()) {
                    w w0 = null;
                    Object object0 = iterator0.next();
                    e e0 = ((c)object0).a.f();
                    if(((Boolean)k0.invoke(e0)).booleanValue()) {
                        if(!e0.b) {
                            w w1 = (w)z0.K0(c0.a(e0));
                            if(!((Boolean)a.r(w1.f, w.h[1])).booleanValue()) {
                                w0 = w1;
                            }
                        }
                        Qf.k.a(((AbstractCollection)collection1), w0);
                    }
                }
                return collection1;
            }
        }
        return je.w.a;
    }

    @Override
    public final String toString() {
        return "subpackages of " + this.c + " from " + this.b;
    }
}

