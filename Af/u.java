package Af;

import Hf.T;
import Hf.V;
import Me.P;
import Me.h;
import Me.l;
import Ue.a;
import Ue.c;
import d3.g;
import e1.G;
import ie.r;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.q;
import qf.e;
import we.k;

public final class u implements p {
    public final p b;
    public final V c;
    public HashMap d;
    public final r e;

    public u(p p0, V v0) {
        q.g(p0, "workerScope");
        q.g(v0, "givenSubstitutor");
        super();
        this.b = p0;
        g.Q(new Af.g(v0, 1));
        T t0 = v0.f();
        q.f(t0, "getSubstitution(...)");
        this.c = new V(G.O(t0));
        this.e = g.Q(new Af.g(this, 2));
    }

    @Override  // Af.p
    public final Set a() {
        return this.b.a();
    }

    @Override  // Af.p
    public final Collection b(e e0, c c0) {
        q.g(e0, "name");
        return this.i(this.b.b(e0, c0));
    }

    @Override  // Af.r
    public final h c(e e0, a a0) {
        q.g(e0, "name");
        q.g(a0, "location");
        h h0 = this.b.c(e0, a0);
        return h0 == null ? null : ((h)this.h(h0));
    }

    @Override  // Af.p
    public final Set d() {
        return this.b.d();
    }

    @Override  // Af.r
    public final Collection e(f f0, k k0) {
        q.g(f0, "kindFilter");
        return (Collection)this.e.getValue();
    }

    @Override  // Af.p
    public final Collection f(e e0, a a0) {
        q.g(e0, "name");
        return this.i(this.b.f(e0, a0));
    }

    @Override  // Af.p
    public final Set g() {
        return this.b.g();
    }

    public final Me.k h(Me.k k0) {
        V v0 = this.c;
        if(v0.a.e()) {
            return k0;
        }
        if(this.d == null) {
            this.d = new HashMap();
        }
        HashMap hashMap0 = this.d;
        q.d(hashMap0);
        l l0 = hashMap0.get(k0);
        if(l0 == null) {
            if(!(k0 instanceof P)) {
                throw new IllegalStateException(("Unknown descriptor in scope: " + k0).toString());
            }
            l0 = ((P)k0).c(v0);
            if(l0 == null) {
                throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + k0 + " substitution fails");
            }
            hashMap0.put(k0, l0);
            return l0;
        }
        return l0;
    }

    public final Collection i(Collection collection0) {
        if(this.c.a.e()) {
            return collection0;
        }
        if(collection0.isEmpty()) {
            return collection0;
        }
        int v = collection0.size();
        Collection collection1 = new LinkedHashSet((v < 3 ? 3 : v / 3 + v + 1));
        for(Object object0: collection0) {
            ((AbstractCollection)collection1).add(this.h(((Me.k)object0)));
        }
        return collection1;
    }
}

