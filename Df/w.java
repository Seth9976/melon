package df;

import Af.f;
import Gf.h;
import Gf.j;
import Gf.m;
import Gf.p;
import Nc.W0;
import Se.n;
import Se.x;
import Ue.c;
import cf.a;
import com.google.firebase.messaging.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import je.y;
import qf.e;
import we.k;

public final class w extends G {
    public final x n;
    public final q o;
    public final h p;
    public final j q;

    public w(u u0, x x0, q q0) {
        super(u0, null);
        this.n = x0;
        this.o = q0;
        p p0 = ((a)u0.a).a;
        W0 w00 = new W0(20, u0, this);
        ((m)p0).getClass();
        this.p = new h(((m)p0), w00);
        this.q = ((m)p0).c(new Ac.G(5, this, u0));
    }

    @Override  // df.C
    public final Collection b(e e0, c c0) {
        kotlin.jvm.internal.q.g(e0, "name");
        return je.w.a;
    }

    @Override  // Af.q
    public final Me.h c(e e0, Ue.a a0) {
        kotlin.jvm.internal.q.g(e0, "name");
        kotlin.jvm.internal.q.g(a0, "location");
        return this.v(e0, null);
    }

    @Override  // df.C
    public final Collection e(f f0, k k0) {
        kotlin.jvm.internal.q.g(f0, "kindFilter");
        if(!f0.a(f.l | f.e)) {
            return je.w.a;
        }
        Iterable iterable0 = (Iterable)this.d.invoke();
        Collection collection0 = new ArrayList();
        for(Object object0: iterable0) {
            Me.k k1 = (Me.k)object0;
            if(k1 instanceof Me.e) {
                e e0 = ((Me.e)k1).getName();
                kotlin.jvm.internal.q.f(e0, "getName(...)");
                if(((Boolean)k0.invoke(e0)).booleanValue()) {
                    ((ArrayList)collection0).add(object0);
                }
            }
        }
        return collection0;
    }

    @Override  // df.C
    public final Set h(f f0, k k0) {
        kotlin.jvm.internal.q.g(f0, "kindFilter");
        if(!f0.a(f.e)) {
            return y.a;
        }
        Set set0 = (Set)this.p.invoke();
        if(set0 != null) {
            Set set1 = new HashSet();
            for(Object object0: set0) {
                ((HashSet)set1).add(e.e(((String)object0)));
            }
            return set1;
        }
        this.n.getClass();
        return new LinkedHashSet();
    }

    @Override  // df.C
    public final Set i(f f0, Af.m m0) {
        kotlin.jvm.internal.q.g(f0, "kindFilter");
        return y.a;
    }

    @Override  // df.C
    public final df.c k() {
        return b.a;
    }

    @Override  // df.C
    public final void m(LinkedHashSet linkedHashSet0, e e0) {
        kotlin.jvm.internal.q.g(e0, "name");
    }

    @Override  // df.C
    public final Set o(f f0) {
        kotlin.jvm.internal.q.g(f0, "kindFilter");
        return y.a;
    }

    @Override  // df.C
    public final Me.k q() {
        return this.o;
    }

    public final Me.e v(e e0, n n0) {
        kotlin.jvm.internal.q.g(e0, "name");
        String s = e0.b();
        kotlin.jvm.internal.q.f(s, "asString(...)");
        if(s.length() > 0 && !e0.b) {
            Set set0 = (Set)this.p.invoke();
            if(n0 != null || set0 == null || set0.contains(e0.b())) {
                r r0 = new r(e0, n0);
                return (Me.e)this.q.invoke(r0);
            }
        }
        return null;
    }
}

