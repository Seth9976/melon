package Me;

import B3.q;
import Hf.B;
import Hf.M;
import Jf.l;
import Q0.W0;
import Sf.g;
import Sf.h;
import Sf.n;
import com.google.firebase.messaging.u;
import d5.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.p;
import qf.c;
import tf.e;

public abstract class w {
    public static final q a;

    static {
        w.a = new q("InvalidModuleNotifier", 2);
    }

    public static final m a(B b0, i i0, int v) {
        i i1 = null;
        if(i0 != null && !l.f(i0)) {
            int v1 = i0.h().size() + v;
            if(!i0.x()) {
                if(v1 != b0.r().size()) {
                    e.n(i0);
                }
                return new m(i0, b0.r().subList(v, b0.r().size()), null);
            }
            List list0 = b0.r().subList(v, v1);
            k k0 = i0.e();
            if(k0 instanceof i) {
                i1 = (i)k0;
            }
            return new m(i0, list0, w.a(b0, i1, v1));
        }
        return null;
    }

    public static final void b(H h0, c c0, ArrayList arrayList0) {
        kotlin.jvm.internal.q.g(h0, "<this>");
        kotlin.jvm.internal.q.g(c0, "fqName");
        h0.a(c0, arrayList0);
    }

    public static final List c(i i0) {
        List list2;
        List list0 = i0.h();
        kotlin.jvm.internal.q.f(list0, "getDeclaredTypeParameters(...)");
        if(!i0.x() && !(i0.e() instanceof b)) {
            return list0;
        }
        Object object0 = null;
        List list1 = n.p0(new h(new g(new W0(n.h0(n.k0(i0, xf.b.b), 1), 4), true, r.d), r.e, Sf.r.b));
        Iterator iterator0 = n.h0(n.k0(i0, xf.b.b), 1).iterator();
        while(true) {
            list2 = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object1 = iterator0.next();
            if(object1 instanceof Me.e) {
                object0 = object1;
                break;
            }
        }
        if(((Me.e)object0) != null) {
            M m0 = ((Me.e)object0).q();
            if(m0 != null) {
                list2 = m0.getParameters();
            }
        }
        if(list2 == null) {
            list2 = je.w.a;
        }
        if(list1.isEmpty() && list2.isEmpty()) {
            List list3 = i0.h();
            kotlin.jvm.internal.q.f(list3, "getDeclaredTypeParameters(...)");
            return list3;
        }
        ArrayList arrayList0 = p.A0(list1, list2);
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object2: arrayList0) {
            kotlin.jvm.internal.q.d(((S)object2));
            arrayList1.add(new d(((S)object2), i0, list0.size()));
        }
        return p.A0(list0, arrayList1);
    }

    public static final Me.e d(z z0, qf.b b0) {
        kotlin.jvm.internal.q.g(z0, "<this>");
        kotlin.jvm.internal.q.g(b0, "classId");
        Me.h h0 = w.e(z0, b0);
        return h0 instanceof Me.e ? ((Me.e)h0) : null;
    }

    public static final Me.h e(z z0, qf.b b0) {
        kotlin.jvm.internal.q.g(z0, "<this>");
        kotlin.jvm.internal.q.g(b0, "classId");
        if(z0.L0(tf.m.a) != null) {
            throw new ClassCastException();
        }
        I i0 = z0.K0(b0.a);
        b0.b.a.getClass();
        List list0 = qf.d.e(b0.b.a);
        qf.e e0 = (qf.e)p.k0(list0);
        Me.h h0 = ((Pe.w)i0).g.c(e0, Ue.c.g);
        if(h0 != null) {
            for(Object object0: list0.subList(1, list0.size())) {
                if(!(h0 instanceof Me.e)) {
                    return null;
                }
                Me.h h1 = ((Me.e)h0).Z().c(((qf.e)object0), Ue.c.g);
                h0 = h1 instanceof Me.e ? ((Me.e)h1) : null;
                if(h0 != null) {
                    continue;
                }
                return null;
            }
            return h0;
        }
        return null;
    }

    public static final Me.e f(z z0, qf.b b0, u u0) {
        kotlin.jvm.internal.q.g(z0, "<this>");
        kotlin.jvm.internal.q.g(b0, "classId");
        kotlin.jvm.internal.q.g(u0, "notFoundClasses");
        Me.e e0 = w.d(z0, b0);
        return e0 == null ? u0.j(b0, n.p0(n.n0(n.k0(b0, s.b), r.b))) : e0;
    }

    public static final Me.h g(k k0) {
        kotlin.jvm.internal.q.g(k0, "<this>");
        k k1 = k0.e();
        if(k1 == null || k0 instanceof E) {
            return null;
        }
        if(!(k1.e() instanceof E)) {
            return w.g(k1);
        }
        return k1 instanceof Me.h ? ((Me.h)k1) : null;
    }

    public static final boolean h(H h0, c c0) {
        kotlin.jvm.internal.q.g(h0, "<this>");
        kotlin.jvm.internal.q.g(c0, "fqName");
        return h0.b(c0);
    }

    public static final ArrayList i(H h0, c c0) {
        kotlin.jvm.internal.q.g(h0, "<this>");
        kotlin.jvm.internal.q.g(c0, "fqName");
        ArrayList arrayList0 = new ArrayList();
        w.b(h0, c0, arrayList0);
        return arrayList0;
    }

    public static final Me.e j(z z0, c c0) {
        Ue.c c1 = Ue.c.a;
        kotlin.jvm.internal.q.g(z0, "<this>");
        kotlin.jvm.internal.q.g(c0, "fqName");
        qf.d d0 = c0.a;
        if(!d0.c()) {
            Me.h h0 = ((Pe.w)z0.K0(c0.b())).g.c(d0.f(), c1);
            Me.e e0 = h0 instanceof Me.e ? ((Me.e)h0) : null;
            if(e0 != null) {
                return e0;
            }
            Me.e e1 = w.j(z0, c0.b());
            if(e1 != null) {
                Af.p p0 = e1.Z();
                if(p0 != null) {
                    Me.h h1 = p0.c(d0.f(), c1);
                    return h1 instanceof Me.e ? ((Me.e)h1) : null;
                }
            }
            return null;
        }
        return null;
    }
}

