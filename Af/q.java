package Af;

import Me.h;
import Pe.L;
import Qf.b;
import Ue.a;
import Ue.c;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import je.w;
import qf.e;
import we.k;

public abstract class q implements p {
    @Override  // Af.p
    public Set a() {
        Iterable iterable0 = this.e(f.p, b.a);
        Set set0 = new LinkedHashSet();
        for(Object object0: iterable0) {
            if(object0 instanceof L) {
                e e0 = ((L)object0).getName();
                kotlin.jvm.internal.q.f(e0, "getName(...)");
                set0.add(e0);
            }
        }
        return set0;
    }

    @Override  // Af.p
    public Collection b(e e0, c c0) {
        kotlin.jvm.internal.q.g(e0, "name");
        return w.a;
    }

    @Override  // Af.r
    public h c(e e0, a a0) {
        kotlin.jvm.internal.q.g(e0, "name");
        kotlin.jvm.internal.q.g(a0, "location");
        return null;
    }

    @Override  // Af.p
    public Set d() {
        return null;
    }

    @Override  // Af.r
    public Collection e(f f0, k k0) {
        kotlin.jvm.internal.q.g(f0, "kindFilter");
        return w.a;
    }

    @Override  // Af.p
    public Collection f(e e0, a a0) {
        kotlin.jvm.internal.q.g(e0, "name");
        return w.a;
    }

    @Override  // Af.p
    public Set g() {
        Iterable iterable0 = this.e(f.q, b.a);
        Set set0 = new LinkedHashSet();
        for(Object object0: iterable0) {
            if(object0 instanceof L) {
                e e0 = ((L)object0).getName();
                kotlin.jvm.internal.q.f(e0, "getName(...)");
                set0.add(e0);
            }
        }
        return set0;
    }
}

