package Ff;

import A1.g;
import Gf.i;
import Gf.j;
import Hf.x;
import If.f;
import If.l;
import Q1.c;
import Ue.a;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import je.u;
import je.w;
import kotlin.jvm.internal.q;
import qf.b;

public final class h extends r {
    public final f g;
    public final i h;
    public final i i;
    public final k j;

    public h(k k0, f f0) {
        q.g(f0, "kotlinTypeRefiner");
        this.j = k0;
        g g0 = k0.l;
        List list0 = k0.e.w;
        q.f(list0, "getFunctionList(...)");
        List list1 = k0.e.B;
        q.f(list1, "getPropertyList(...)");
        List list2 = k0.e.D;
        q.f(list2, "getTypeAliasList(...)");
        List list3 = k0.e.k;
        q.f(list3, "getNestedClassNameList(...)");
        nf.f f1 = (nf.f)k0.l.b;
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list3));
        for(Object object0: list3) {
            arrayList0.add(c.B(f1, ((Number)object0).intValue()));
        }
        super(g0, list0, list1, list2, new e(0, arrayList0));
        Df.i i0 = (Df.i)g0.a;
        this.g = f0;
        Ff.f f2 = new Ff.f(this, 0);
        i0.a.getClass();
        this.h = new i(i0.a, f2);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        Ff.f f3 = new Ff.f(this, 1);
        i0.a.getClass();
        this.i = new i(i0.a, f3);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    @Override  // Ff.r
    public final Collection b(qf.e e0, Ue.c c0) {
        q.g(e0, "name");
        this.s(e0, c0);
        return super.b(e0, c0);
    }

    @Override  // Ff.r
    public final Me.h c(qf.e e0, a a0) {
        q.g(e0, "name");
        q.g(a0, "location");
        this.s(e0, a0);
        d5.i i0 = this.j.r;
        if(i0 != null) {
            Me.h h0 = (Me.e)((j)i0.b).invoke(e0);
            return h0 == null ? super.c(e0, a0) : h0;
        }
        return super.c(e0, a0);
    }

    @Override  // Af.q
    public final Collection e(Af.f f0, we.k k0) {
        q.g(f0, "kindFilter");
        return (Collection)this.h.invoke();
    }

    @Override  // Ff.r
    public final Collection f(qf.e e0, a a0) {
        q.g(e0, "name");
        this.s(e0, a0);
        return super.f(e0, a0);
    }

    @Override  // Ff.r
    public final void h(ArrayList arrayList0, we.k k0) {
        ArrayList arrayList1;
        d5.i i0 = this.j.r;
        if(i0 == null) {
            arrayList1 = null;
        }
        else {
            Iterable iterable0 = ((LinkedHashMap)i0.a).keySet();
            arrayList1 = new ArrayList();
            for(Object object0: iterable0) {
                q.g(((qf.e)object0), "name");
                Me.e e0 = (Me.e)((j)i0.b).invoke(((qf.e)object0));
                if(e0 != null) {
                    arrayList1.add(e0);
                }
            }
        }
        if(arrayList1 == null) {
            arrayList1 = w.a;
        }
        arrayList0.addAll(arrayList1);
    }

    @Override  // Ff.r
    public final void j(ArrayList arrayList0, qf.e e0) {
        q.g(e0, "name");
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: ((Collection)this.i.invoke())) {
            arrayList1.addAll(((x)object0).E().f(e0, Ue.c.c));
        }
        arrayList0.addAll(((Df.i)this.b.a).n.c(e0, this.j));
        ArrayList arrayList2 = new ArrayList(arrayList0);
        tf.k k0 = ((l)((Df.i)this.b.a).q).d;
        Ff.g g0 = new Ff.g(arrayList0, 0);
        k0.h(e0, arrayList1, arrayList2, this.j, g0);
    }

    @Override  // Ff.r
    public final void k(ArrayList arrayList0, qf.e e0) {
        q.g(e0, "name");
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: ((Collection)this.i.invoke())) {
            arrayList1.addAll(((x)object0).E().b(e0, Ue.c.c));
        }
        ArrayList arrayList2 = new ArrayList(arrayList0);
        tf.k k0 = ((l)((Df.i)this.b.a).q).d;
        Ff.g g0 = new Ff.g(arrayList0, 0);
        k0.h(e0, arrayList1, arrayList2, this.j, g0);
    }

    @Override  // Ff.r
    public final b l(qf.e e0) {
        q.g(e0, "name");
        return this.j.h.d(e0);
    }

    @Override  // Ff.r
    public final Set n() {
        Iterable iterable0 = this.j.n.i();
        Set set0 = new LinkedHashSet();
        for(Object object0: iterable0) {
            Iterable iterable1 = ((x)object0).E().d();
            if(iterable1 == null) {
                return null;
            }
            u.U(set0, iterable1);
        }
        return set0;
    }

    @Override  // Ff.r
    public final Set o() {
        k k0 = this.j;
        Iterable iterable0 = k0.n.i();
        Set set0 = new LinkedHashSet();
        for(Object object0: iterable0) {
            u.U(set0, ((x)object0).E().a());
        }
        ((AbstractCollection)set0).addAll(((Df.i)this.b.a).n.d(k0));
        return set0;
    }

    @Override  // Ff.r
    public final Set p() {
        Iterable iterable0 = this.j.n.i();
        Set set0 = new LinkedHashSet();
        for(Object object0: iterable0) {
            u.U(set0, ((x)object0).E().g());
        }
        return set0;
    }

    @Override  // Ff.r
    public final boolean r(Ff.u u0) {
        return ((Df.i)this.b.a).o.b(this.j, u0);
    }

    public final void s(qf.e e0, a a0) {
        q.g(e0, "name");
        q.g(a0, "location");
        q.g(((Df.i)this.b.a).i, "<this>");
        q.g(this.j, "scopeOwner");
    }
}

