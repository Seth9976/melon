package Hf;

import Ac.q0;
import Af.p;
import Je.i;
import Kf.h;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.q;
import we.k;
import x1.a;

public final class w implements M, h {
    public x a;
    public final LinkedHashSet b;
    public final int c;

    public w(AbstractCollection abstractCollection0) {
        q.g(abstractCollection0, "typesToIntersect");
        super();
        abstractCollection0.isEmpty();
        LinkedHashSet linkedHashSet0 = new LinkedHashSet(abstractCollection0);
        this.b = linkedHashSet0;
        this.c = linkedHashSet0.hashCode();
    }

    public final B b() {
        I.b.getClass();
        p p0 = a.p("member scope for intersection type", this.b);
        q0 q00 = new q0(this, 5);
        return c.w(I.c, this, je.w.a, false, p0, q00);
    }

    public final String c(k k0) {
        q.g(k0, "getProperTypeRelatedToStringify");
        v v0 = new v(k0, 0);
        return je.p.q0(je.p.J0(this.b, v0), " & ", "{", "}", new t(0, k0), 24);
    }

    @Override  // Hf.M
    public final i d() {
        Object object0 = this.b.iterator().next();
        i i0 = ((x)object0).w().d();
        q.f(i0, "getBuiltIns(...)");
        return i0;
    }

    @Override  // Hf.M
    public final Me.h e() {
        return null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof w ? q.b(this.b, ((w)object0).b) : false;
    }

    @Override  // Hf.M
    public final Collection f() {
        return this.b;
    }

    @Override  // Hf.M
    public final boolean g() {
        return false;
    }

    @Override  // Hf.M
    public final List getParameters() {
        return je.w.a;
    }

    @Override
    public final int hashCode() {
        return this.c;
    }

    @Override
    public final String toString() {
        return this.c(u.b);
    }
}

