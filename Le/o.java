package Le;

import Ac.W;
import Ac.q0;
import Af.g;
import De.t;
import De.w;
import Ff.u;
import Gf.e;
import Gf.i;
import Gf.m;
import Hf.B;
import Hf.T;
import Hf.V;
import Hf.x;
import Me.f;
import Me.h;
import Me.y;
import Oe.b;
import Oe.d;
import Pe.A;
import Pe.L;
import Pe.S;
import Pe.s;
import b3.Z;
import com.iloen.melon.utils.a;
import d5.n;
import df.j;
import e.k;
import i.n.i.b.a.s.e.M3;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import je.p;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;
import qf.c;

public final class o implements b, d {
    public final A a;
    public final i b;
    public final B c;
    public final i d;
    public final e e;
    public final i f;
    public final e g;
    public static final w[] h;

    static {
        z z0 = new z(o.class, "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;", 0);
        t t0 = a.e(o.class, "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;", 0, I.a);
        t t1 = a.e(o.class, "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;", 0, I.a);
        o.h = new w[]{I.a.g(z0), t0, t1};
    }

    public o(A a0, m m0, g g0) {
        this.a = a0;
        this.b = new i(m0, g0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        Le.m m1 = new Le.m(a0, new c("java.io"), 0);
        List list0 = k.z(new Hf.z(m0, new Le.k(this, 1)));
        Pe.k k0 = new Pe.k(m1, qf.e.e("Serializable"), y.e, f.b, list0, m0);
        k0.r(Af.o.b, je.y.a, null);
        this.c = k0.g();
        this.d = new i(m0, new W(21, this, m0));  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        this.e = new e(m0, new ConcurrentHashMap(3, 1.0f, 2), new Gf.f(), 0);  // 初始化器: Ljava/lang/Object;-><init>()V
        this.f = new i(m0, new Le.k(this, 0));  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        this.g = m0.b(new q0(this, 8));
    }

    @Override  // Oe.b
    public final Collection a(Me.e e0) {
        if(e0.getKind() == f.a) {
            this.g().getClass();
            j j0 = this.f(e0);
            if(j0 != null) {
                Me.e e1 = Le.e.b(xf.d.g(j0), Le.b.f);
                if(e1 != null) {
                    V v0 = new V(Q1.c.r(e1, j0));
                    Iterable iterable0 = (List)j0.w.q.invoke();
                    ArrayList arrayList0 = new ArrayList();
                    Iterator iterator0 = iterable0.iterator();
                alab1:
                    while(true) {
                        qf.d d0 = null;
                        if(!iterator0.hasNext()) {
                            break;
                        }
                        Object object0 = iterator0.next();
                        Pe.i i0 = (Pe.i)object0;
                        Pe.t t0 = i0;
                        if(t0.getVisibility().a.b) {
                            Collection collection0 = e1.s();
                            q.f(collection0, "getConstructors(...)");
                            Iterable iterable1 = collection0;
                            if(!(iterable1 instanceof Collection) || !((Collection)iterable1).isEmpty()) {
                                for(Object object1: iterable1) {
                                    q.d(((Pe.i)object1));
                                    if(tf.k.j(((Pe.i)object1), i0.J1(v0)) == 1) {
                                        continue alab1;
                                    }
                                    if(false) {
                                        break;
                                    }
                                }
                            }
                            if(t0.F().size() == 1) {
                                List list0 = t0.F();
                                q.f(list0, "getValueParameters(...)");
                                h h0 = ((S)p.E0(list0)).getType().w().e();
                                if(h0 != null) {
                                    d0 = xf.d.h(h0);
                                }
                                if(!q.b(d0, xf.d.h(e0))) {
                                    goto label_33;
                                }
                            }
                            else {
                            label_33:
                                if(!Je.i.D(i0)) {
                                    String s = d3.g.g0(j0, n.q(i0, 3));
                                    if(!r.f.contains(s)) {
                                        arrayList0.add(object0);
                                    }
                                }
                            }
                        }
                    }
                    Collection collection1 = new ArrayList(je.q.Q(10, arrayList0));
                    for(Object object2: arrayList0) {
                        ((Pe.i)object2).getClass();
                        s s1 = ((Pe.i)object2).z1(V.b);
                        s1.b = e0;
                        s1.r(e0.g());
                        s1.o = true;
                        T t1 = v0.f();
                        if(t1 != null) {
                            s1.a = t1;
                            String s2 = d3.g.g0(j0, n.q(((Pe.i)object2), 3));
                            if(!r.g.contains(s2)) {
                                s1.e(((Ne.h)P4.a.r(this.f, o.h[2])));
                            }
                            Pe.t t2 = s1.N.w1(s1);
                            q.e(t2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                            ((ArrayList)collection1).add(((Pe.i)t2));
                            continue;
                        }
                        s.i(37);
                        throw null;
                    }
                    return collection1;
                }
            }
        }
        return je.w.a;
    }

    @Override  // Oe.d
    public final boolean b(Me.e e0, u u0) {
        q.g(e0, "classDescriptor");
        j j0 = this.f(e0);
        if(j0 != null && u0.getAnnotations().c(Oe.e.a)) {
            this.g().getClass();
            String s = n.q(u0, 3);
            df.o o0 = j0.r();
            qf.e e1 = u0.getName();
            q.f(e1, "getName(...)");
            Iterable iterable0 = o0.f(e1, Ue.c.a);
            if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                for(Object object0: iterable0) {
                    if(!q.b(n.q(((L)object0), 3), s)) {
                        continue;
                    }
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    // This method was un-flattened
    @Override  // Oe.b
    public final Collection c(qf.e e0, Me.e e1) {
        L l2;
        boolean z1;
        Object object1;
        Collection collection1;
        q.g(e0, "name");
        q.g(e1, "classDescriptor");
        w[] arr_w = o.h;
        Collection collection0 = je.w.a;
        if(e0.equals(Le.a.e) && e1 instanceof Ff.k && (Je.i.b(e1, Je.o.g) || Je.i.s(e1) != null)) {
            List list0 = ((Ff.k)e1).e.w;
            q.f(list0, "getFunctionList(...)");
            if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                for(Object object0: list0) {
                    if(Q1.c.B(((nf.f)((Ff.k)e1).l.b), ((lf.A)object0).f).equals(Le.a.e)) {
                        return collection0;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            Me.t t0 = ((L)p.D0(((B)P4.a.r(this.d, arr_w[1])).E().f(e0, Ue.c.a))).N0();
            t0.b(((Ff.k)e1));
            t0.k(Me.p.e);
            t0.r(((Ff.k)e1).g());
            t0.n(((Ff.k)e1).P0());
            Me.u u0 = t0.build();
            q.d(u0);
            return k.z(((L)u0));
        }
        this.g().getClass();
        j j0 = this.f(e1);
        if(j0 != null) {
            c c0 = xf.d.g(j0);
            Le.b b0 = Le.b.f;
            q.g(b0, "builtIns");
            Me.e e2 = Le.e.b(c0, b0);
            if(e2 == null) {
                collection1 = je.y.a;
            }
            else {
                qf.d d0 = xf.d.h(e2);
                c c1 = (c)Le.d.k.get(d0);
                collection1 = c1 == null ? e1.m.E(e2) : k.A(new Me.e[]{e2, b0.j(c1)});
            }
            if(!(collection1 instanceof List)) {
                Iterator iterator1 = collection1.iterator();
                if(iterator1.hasNext()) {
                    Object object2;
                    for(object2 = iterator1.next(); iterator1.hasNext(); object2 = iterator1.next()) {
                    }
                    object1 = object2;
                }
                else {
                    object1 = null;
                }
            }
            else if(!((List)collection1).isEmpty()) {
                object1 = Z.h(1, ((List)collection1));
            }
            else {
                object1 = null;
            }
            if(((Me.e)object1) != null) {
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, collection1));
                for(Object object3: collection1) {
                    arrayList0.add(xf.d.g(((Me.e)object3)));
                }
                Qf.h h0 = new Qf.h(0);
                h0.addAll(arrayList0);
                qf.d d1 = tf.e.g(e1);
                boolean z = Le.d.j.containsKey(d1);
                c c2 = xf.d.g(j0);
                W w0 = new W(22, j0, ((Me.e)object1));
                this.e.getClass();
                Gf.g g0 = new Gf.g(c2, w0);
                Object object4 = this.e.invoke(g0);
                if(object4 != null) {
                    Af.p p0 = ((Me.e)object4).d0();
                    q.f(p0, "getUnsubstitutedMemberScope(...)");
                    Iterable iterable0 = p0.f(e0, Ue.c.a);
                    ArrayList arrayList1 = new ArrayList();
                    Iterator iterator3 = iterable0.iterator();
                label_75:
                    while(iterator3.hasNext()) {
                        Object object5 = iterator3.next();
                        L l0 = (L)object5;
                        if(l0.getKind() == 1 && (l0.getVisibility().a.b && !Je.i.D(l0))) {
                            Iterable iterable1 = l0.f();
                            if(!(iterable1 instanceof Collection) || !((Collection)iterable1).isEmpty()) {
                                for(Object object6: iterable1) {
                                    Me.k k0 = ((Me.u)object6).e();
                                    q.f(k0, "getContainingDeclaration(...)");
                                    if(h0.contains(xf.d.g(k0))) {
                                        continue label_75;
                                    }
                                }
                            }
                            Me.k k1 = l0.e();
                            q.e(k1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                            String s = d3.g.g0(((Me.e)k1), n.q(l0, 3));
                            if((r.e.contains(s) ^ z) == 0) {
                                Collection collection2 = k.z(l0);
                                Le.f f0 = new Le.f(this);
                                Boolean boolean0 = Qf.k.h(collection2, Le.e.a, f0);
                                q.f(boolean0, "ifAny(...)");
                                z1 = boolean0.booleanValue();
                            }
                            else {
                                z1 = true;
                            }
                            if(!z1) {
                                arrayList1.add(object5);
                            }
                        }
                    }
                    collection0 = arrayList1;
                    goto label_106;
                }
                e.d(3);
                throw null;
            }
        }
    label_106:
        Collection collection3 = new ArrayList();
        for(Object object7: collection0) {
            L l1 = (L)object7;
            Me.k k2 = l1.e();
            q.e(k2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            Me.u u1 = l1.c(new V(Q1.c.r(((Me.e)k2), e1)));
            q.e(u1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            Me.t t1 = ((L)u1).N0();
            t1.b(e1);
            t1.n(e1.P0());
            t1.l();
            Me.k k3 = l1.e();
            q.e(k3, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            String s1 = n.q(l1, 3);
            H h1 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            Object object8 = Qf.k.f(k.z(((Me.e)k3)), new I7.c(this, 11), new Le.n(s1, h1, 0));
            q.f(object8, "dfs(...)");
            int v = ((l)object8).ordinal();
            switch(v) {
                case 0: {
                    if(e1.i() == y.b && e1.getKind() != f.c) {
                        l2 = null;
                        break;
                    }
                    else {
                        t1.d();
                        goto label_147;
                    }
                    goto label_136;
                }
                case 1: {
                label_147:
                    Me.u u2 = t1.build();
                    q.d(u2);
                    l2 = (L)u2;
                    break;
                }
                case 2: {
                label_136:
                    qf.e e3 = l1.getName();
                    boolean z2 = q.b(e3, Le.p.a);
                    e e4 = this.g;
                    if(z2) {
                        t1.e(((Ne.h)e4.invoke(new ie.m(l1.getName().b(), "first"))));
                    }
                    else {
                        if(!q.b(e3, Le.p.b)) {
                            throw new IllegalStateException(("Unexpected name: " + l1.getName()).toString());
                        }
                        t1.e(((Ne.h)e4.invoke(new ie.m(l1.getName().b(), "last"))));
                    }
                    goto label_147;
                }
                case 3: {
                    t1.e(((Ne.h)P4.a.r(this.f, arr_w[2])));
                    goto label_147;
                }
                default: {
                    if(v != 4) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    l2 = null;
                }
            }
            if(l2 != null) {
                ((ArrayList)collection3).add(l2);
            }
        }
        return collection3;
    }

    @Override  // Oe.b
    public final Collection d(Me.e e0) {
        q.g(e0, "classDescriptor");
        this.g().getClass();
        j j0 = this.f(e0);
        if(j0 != null) {
            Set set0 = j0.r().a();
            if(set0 != null) {
                return set0;
            }
        }
        return je.y.a;
    }

    @Override  // Oe.b
    public final Collection e(Me.e e0) {
        qf.d d0 = xf.d.h(e0);
        qf.d d1 = Je.o.g;
        boolean z = d0.equals(d1);
        boolean z1 = false;
        B b0 = this.c;
        if(!z) {
            HashMap hashMap0 = Je.o.g0;
            if(hashMap0.get(d0) == null) {
                if(d0.equals(d1) || hashMap0.get(d0) != null) {
                    z1 = true;
                    return z1 ? k.z(b0) : je.w.a;
                }
                else {
                    qf.b b1 = Le.d.f(d0);
                    if(b1 != null) {
                        try {
                            Class class0 = Class.forName(b1.a().a.a);
                            z1 = Serializable.class.isAssignableFrom(class0);
                            return z1 ? k.z(b0) : je.w.a;
                        }
                        catch(ClassNotFoundException unused_ex) {
                        }
                    }
                }
                return z1 ? k.z(b0) : je.w.a;
            }
        }
        return k.A(new x[]{((B)P4.a.r(this.d, o.h[1])), b0});
    }

    public final j f(Me.e e0) {
        if(e0 != null) {
            if(!Je.i.b(e0, Je.o.a) && Je.i.J(e0)) {
                qf.d d0 = xf.d.h(e0);
                if(d0.d()) {
                    qf.b b0 = Le.d.f(d0);
                    if(b0 != null) {
                        c c0 = b0.a();
                        if(c0 != null) {
                            Me.e e1 = Me.w.j(this.g().a, c0);
                            return e1 instanceof j ? ((j)e1) : null;
                        }
                    }
                }
            }
            return null;
        }
        Je.i.a(108);
        throw null;
    }

    public final Le.i g() {
        return (Le.i)P4.a.r(this.b, o.h[0]);
    }
}

