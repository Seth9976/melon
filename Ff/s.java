package Ff;

import Df.i;
import Me.E;
import Me.h;
import Pe.C;
import Pe.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import je.p;
import je.u;
import je.y;
import jf.g;
import kotlin.jvm.internal.q;
import lf.Z;
import lf.g0;
import nf.a;
import nf.f;
import qf.b;
import qf.c;
import qf.e;
import we.k;

public final class s extends r {
    public final E g;
    public final String h;
    public final c i;

    public s(E e0, lf.E e1, f f0, a a0, g g0, i i0, String s, we.a a1) {
        q.g(e1, "proto");
        q.g(f0, "nameResolver");
        q.g(a0, "metadataVersion");
        q.g(i0, "components");
        q.g(s, "debugName");
        Z z0 = e1.g;
        q.f(z0, "getTypeTable(...)");
        z z1 = new z(z0);
        g0 g00 = e1.h;
        q.f(g00, "getVersionRequirementTable(...)");
        A1.g g1 = i0.a(e0, f0, z1, e2.a.w(g00), a0, g0);
        List list0 = e1.d;
        q.f(list0, "getFunctionList(...)");
        List list1 = e1.e;
        q.f(list1, "getPropertyList(...)");
        List list2 = e1.f;
        q.f(list2, "getTypeAliasList(...)");
        super(g1, list0, list1, list2, a1);
        this.g = e0;
        this.h = s;
        this.i = ((C)e0).e;
    }

    @Override  // Ff.r
    public final h c(e e0, Ue.a a0) {
        q.g(e0, "name");
        q.g(a0, "location");
        d5.f.T(((i)this.b.a).i, a0, this.g, e0);
        return super.c(e0, a0);
    }

    @Override  // Af.q
    public final Collection e(Af.f f0, k k0) {
        q.g(f0, "kindFilter");
        Collection collection0 = this.i(f0, k0);
        Iterable iterable0 = ((i)this.b.a).k;
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            u.U(arrayList0, ((Oe.c)object0).c(this.i));
        }
        return p.A0(collection0, arrayList0);
    }

    @Override  // Ff.r
    public final void h(ArrayList arrayList0, k k0) {
    }

    @Override  // Ff.r
    public final b l(e e0) {
        q.g(e0, "name");
        return new b(this.i, e0);
    }

    @Override  // Ff.r
    public final Set n() {
        return y.a;
    }

    @Override  // Ff.r
    public final Set o() {
        return y.a;
    }

    @Override  // Ff.r
    public final Set p() {
        return y.a;
    }

    @Override  // Ff.r
    public final boolean q(e e0) {
        q.g(e0, "name");
        if(!super.q(e0)) {
            Iterable iterable0 = ((i)this.b.a).k;
            if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                for(Object object0: iterable0) {
                    if(((Oe.c)object0).b(this.i, e0)) {
                        return true;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public final String toString() {
        return this.h;
    }
}

