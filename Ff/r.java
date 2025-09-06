package Ff;

import A1.g;
import Af.f;
import Af.k;
import Af.q;
import De.t;
import De.w;
import Gf.h;
import Gf.i;
import Me.Q;
import Ue.c;
import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.z;
import qf.b;
import qf.e;

public abstract class r extends q {
    public final g b;
    public final Ff.q c;
    public final i d;
    public final h e;
    public static final w[] f;

    static {
        z z0 = new z(r.class, "classNames", "getClassNames$deserialization()Ljava/util/Set;", 0);
        t t0 = a.e(r.class, "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;", 0, I.a);
        r.f = new w[]{I.a.g(z0), t0};
    }

    public r(g g0, List list0, List list1, List list2, we.a a0) {
        kotlin.jvm.internal.q.g(g0, "c");
        kotlin.jvm.internal.q.g(list0, "functionList");
        kotlin.jvm.internal.q.g(list1, "propertyList");
        kotlin.jvm.internal.q.g(list2, "typeAliasList");
        super();
        this.b = g0;
        Df.i i0 = (Df.i)g0.a;
        i0.c.getClass();
        this.c = new Ff.q(this, list0, list1, list2);
        k k0 = new k(5, a0);
        i0.a.getClass();
        this.d = new i(i0.a, k0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        Af.g g1 = new Af.g(this, 5);
        i0.a.getClass();
        this.e = new h(i0.a, g1);
    }

    @Override  // Af.q
    public final Set a() {
        return (Set)P4.a.r(this.c.g, Ff.q.j[0]);
    }

    @Override  // Af.q
    public Collection b(e e0, c c0) {
        kotlin.jvm.internal.q.g(e0, "name");
        return this.c.b(e0, c0);
    }

    @Override  // Af.q
    public Me.h c(e e0, Ue.a a0) {
        kotlin.jvm.internal.q.g(e0, "name");
        kotlin.jvm.internal.q.g(a0, "location");
        if(this.q(e0)) {
            return ((Df.i)this.b.a).b(this.l(e0));
        }
        Ff.q q0 = this.c;
        if(q0.c.keySet().contains(e0)) {
            q0.getClass();
            return (Q)q0.f.invoke(e0);
        }
        return null;
    }

    @Override  // Af.q
    public final Set d() {
        w w0 = r.f[1];
        kotlin.jvm.internal.q.g(this.e, "<this>");
        kotlin.jvm.internal.q.g(w0, "p");
        return (Set)this.e.invoke();
    }

    @Override  // Af.q
    public Collection f(e e0, Ue.a a0) {
        kotlin.jvm.internal.q.g(e0, "name");
        return this.c.a(e0, a0);
    }

    @Override  // Af.q
    public final Set g() {
        return (Set)P4.a.r(this.c.h, Ff.q.j[1]);
    }

    public abstract void h(ArrayList arg1, we.k arg2);

    public final Collection i(f f0, we.k k0) {
        c c0 = c.d;
        kotlin.jvm.internal.q.g(f0, "kindFilter");
        ArrayList arrayList0 = new ArrayList(0);
        if(f0.a(f.f)) {
            this.h(arrayList0, k0);
        }
        Ff.q q0 = this.c;
        q0.getClass();
        tf.h h0 = tf.h.b;
        if(f0.a(f.j)) {
            Collection collection0 = (Set)P4.a.r(q0.h, Ff.q.j[1]);
            ArrayList arrayList1 = new ArrayList();
            for(Object object0: collection0) {
                e e0 = (e)object0;
                if(((Boolean)k0.invoke(e0)).booleanValue()) {
                    arrayList1.addAll(q0.b(e0, c0));
                }
            }
            je.t.S(arrayList1, h0);
            arrayList0.addAll(arrayList1);
        }
        if(f0.a(f.i)) {
            Collection collection1 = (Set)P4.a.r(q0.g, Ff.q.j[0]);
            ArrayList arrayList2 = new ArrayList();
            for(Object object1: collection1) {
                e e1 = (e)object1;
                if(((Boolean)k0.invoke(e1)).booleanValue()) {
                    arrayList2.addAll(q0.a(e1, c0));
                }
            }
            je.t.S(arrayList2, h0);
            arrayList0.addAll(arrayList2);
        }
        if(f0.a(f.l)) {
            for(Object object2: this.m()) {
                e e2 = (e)object2;
                if(((Boolean)k0.invoke(e2)).booleanValue()) {
                    Qf.k.a(arrayList0, ((Df.i)this.b.a).b(this.l(e2)));
                }
            }
        }
        if(f0.a(f.g)) {
            for(Object object3: q0.c.keySet()) {
                e e3 = (e)object3;
                if(((Boolean)k0.invoke(e3)).booleanValue()) {
                    q0.getClass();
                    kotlin.jvm.internal.q.g(e3, "name");
                    Qf.k.a(arrayList0, ((Q)q0.f.invoke(e3)));
                }
            }
        }
        return Qf.k.d(arrayList0);
    }

    public void j(ArrayList arrayList0, e e0) {
        kotlin.jvm.internal.q.g(e0, "name");
    }

    public void k(ArrayList arrayList0, e e0) {
        kotlin.jvm.internal.q.g(e0, "name");
    }

    public abstract b l(e arg1);

    public final Set m() {
        return (Set)P4.a.r(this.d, r.f[0]);
    }

    public abstract Set n();

    public abstract Set o();

    public abstract Set p();

    public boolean q(e e0) {
        kotlin.jvm.internal.q.g(e0, "name");
        return this.m().contains(e0);
    }

    public boolean r(u u0) {
        return true;
    }
}

