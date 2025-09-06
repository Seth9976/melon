package If;

import Af.g;
import Ff.e;
import Hf.P;
import Hf.x;
import Me.S;
import Me.h;
import U4.F;
import ie.j;
import ie.k;
import java.util.Collection;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import uf.b;
import we.a;

public final class i implements b {
    public final P a;
    public a b;
    public final i c;
    public final S d;
    public final Object e;

    public i(P p0, e e0, S s0, int v) {
        if((v & 2) != 0) {
            e0 = null;
        }
        if((v & 8) != 0) {
            s0 = null;
        }
        this(p0, e0, null, s0);
    }

    public i(P p0, a a0, i i0, S s0) {
        q.g(p0, "projection");
        super();
        this.a = p0;
        this.b = a0;
        this.c = i0;
        this.d = s0;
        g g0 = new g(this, 16);
        this.e = d3.g.P(k.b, g0);
    }

    @Override  // uf.b
    public final P a() {
        return this.a;
    }

    @Override  // Hf.M
    public final Je.i d() {
        x x0 = this.a.b();
        q.f(x0, "getType(...)");
        return F.u(x0);
    }

    @Override  // Hf.M
    public final h e() {
        return null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        Class class0 = object0 == null ? null : object0.getClass();
        if(!i.class.equals(class0)) {
            return false;
        }
        q.e(object0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        i i0 = this.c == null ? this : this.c;
        i i1 = ((i)object0).c;
        if(i1 != null) {
            object0 = i1;
        }
        return i0 == object0;
    }

    @Override  // Hf.M
    public final Collection f() {
        List list0 = (List)((j)this.e).getValue();
        return list0 == null ? w.a : list0;
    }

    @Override  // Hf.M
    public final boolean g() {
        return false;
    }

    @Override  // Hf.M
    public final List getParameters() {
        return w.a;
    }

    @Override
    public final int hashCode() {
        return this.c == null ? super.hashCode() : this.c.hashCode();
    }

    @Override
    public final String toString() {
        return "CapturedType(" + this.a + ')';
    }
}

