package df;

import Ac.G;
import Gf.i;
import Gf.j;
import Gf.m;
import Gf.p;
import Hf.P;
import Hf.W;
import Hf.a0;
import Hf.x;
import Me.N;
import Me.e;
import Me.h;
import Me.t;
import Me.y;
import Pe.J;
import Pe.K;
import Pe.L;
import Pe.S;
import Re.g;
import Se.n;
import Se.s;
import Se.z;
import Tf.v;
import Yc.D;
import Ze.E;
import Ze.f;
import androidx.media3.session.legacy.V;
import bf.b;
import cf.a;
import com.google.firebase.messaging.u;
import h7.u0;
import java.lang.annotation.Annotation;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import je.I;
import je.w;
import k8.Y;
import kotlin.jvm.internal.q;
import qf.c;
import qf.d;

public final class o extends C {
    public final e n;
    public final n o;
    public final boolean p;
    public final i q;
    public final i r;
    public final i s;
    public final i t;
    public final j u;
    public static final int v;

    public o(u u0, e e0, n n0, boolean z, o o0) {
        q.g(u0, "c");
        q.g(n0, "jClass");
        super(u0, o0);
        this.n = e0;
        this.o = n0;
        this.p = z;
        p p0 = ((a)u0.a).a;
        k k0 = new k(this, u0);
        ((m)p0).getClass();
        this.q = new i(((m)p0), k0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        l l0 = new l(this, 0);
        ((m)p0).getClass();
        this.r = new i(((m)p0), l0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        k k1 = new k(u0, this);
        ((m)p0).getClass();
        this.s = new i(((m)p0), k1);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        l l1 = new l(this, 1);
        ((m)p0).getClass();
        this.t = new i(((m)p0), l1);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        this.u = ((m)p0).c(new G(3, this, u0));
    }

    public static L A(L l0, Me.u u0, AbstractCollection abstractCollection0) {
        if(!abstractCollection0.isEmpty()) {
            for(Object object0: abstractCollection0) {
                L l1 = (L)object0;
                if(!l0.equals(l1) && l1.W == null && o.D(l1, u0)) {
                    Me.u u1 = l0.N0().h().build();
                    q.d(u1);
                    return (L)u1;
                }
                if(false) {
                    break;
                }
            }
        }
        return l0;
    }

    public static L B(L l0) {
        c c0;
        List list0 = l0.F();
        q.f(list0, "getValueParameters(...)");
        S s0 = (S)je.p.t0(list0);
        if(s0 != null) {
            h h0 = s0.getType().w().e();
            if(h0 == null) {
                c0 = null;
            }
            else {
                d d0 = xf.d.h(h0);
                if(!d0.d()) {
                    d0 = null;
                }
                c0 = d0 == null ? null : d0.g();
            }
            if(!q.b(c0, Je.p.g)) {
                s0 = null;
            }
            if(s0 != null) {
                t t0 = l0.N0();
                List list1 = l0.F();
                q.f(list1, "getValueParameters(...)");
                L l1 = (L)t0.a(je.p.g0(1, list1)).r(((P)s0.getType().r().get(0)).b()).build();
                if(l1 != null) {
                    l1.G = true;
                }
                return l1;
            }
        }
        return null;
    }

    public final boolean C(Me.L l0, we.k k0) {
        if(!df.d.B(l0)) {
            L l1 = this.G(l0, k0);
            L l2 = o.H(l0, k0);
            return l1 != null && (!l0.P() || l2 != null && l2.i() == l1.i());
        }
        return false;
    }

    public static boolean D(Me.u u0, Me.u u1) {
        int v = tf.k.c.n(u1, u0, true).b();
        Y.A(v, "getResult(...)");
        return v == 1 && !y5.a.y(u1, u0);
    }

    public static boolean E(L l0, L l1) {
        q.g(l0, "<this>");
        if(q.b(l0.getName().b(), "removeAt") && q.b(d5.n.r(l0), E.g.e)) {
            l1 = l1.F1();
        }
        q.d(l1);
        return o.D(l1, l0);
    }

    public static L F(Me.L l0, String s, we.k k0) {
        L l1;
        Iterator iterator0 = ((Iterable)k0.invoke(qf.e.e(s))).iterator();
        do {
            l1 = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            L l2 = (L)object0;
            if(l2.F().size() == 0 && (l2.g == null ? false : If.d.a.b(l2.g, l0.getType()))) {
                l1 = l2;
            }
        }
        while(l1 == null);
        return l1;
    }

    public final L G(Me.L l0, we.k k0) {
        J j0 = l0.getGetter();
        String s = null;
        J j1 = j0 == null ? null : ((J)B.a.D(j0));
        if(j1 != null) {
            Je.i.A(j1);
            Me.c c0 = xf.d.b(xf.d.k(j1), Ze.d.d);
            if(c0 != null) {
                c c1 = xf.d.g(c0);
                qf.e e0 = (qf.e)((Map)f.a).get(c1);
                if(e0 != null) {
                    s = e0.b();
                }
            }
        }
        if(s != null && !B.a.O(this.n, j1)) {
            return o.F(l0, s, k0);
        }
        String s1 = l0.getName().b();
        q.f(s1, "asString(...)");
        return o.F(l0, Ze.u.a(s1), k0);
    }

    public static L H(Me.L l0, we.k k0) {
        L l1;
        String s = l0.getName().b();
        q.f(s, "asString(...)");
        Iterator iterator0 = ((Iterable)k0.invoke(qf.e.e(Ze.u.b(s)))).iterator();
        do {
            l1 = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            L l2 = (L)object0;
            if(l2.F().size() == 1 && (l2.g != null && Je.i.E(l2.g, Je.o.d))) {
                List list0 = l2.F();
                q.f(list0, "getValueParameters(...)");
                x x0 = ((S)je.p.E0(list0)).getType();
                x x1 = l0.getType();
                if(If.d.a.a(x0, x1)) {
                    l1 = l2;
                }
            }
        }
        while(l1 == null);
        return l1;
    }

    public final LinkedHashSet I(qf.e e0) {
        Iterable iterable0 = this.z();
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        for(Object object0: iterable0) {
            je.u.U(linkedHashSet0, ((x)object0).E().f(e0, Ue.c.e));
        }
        return linkedHashSet0;
    }

    public final Set J(qf.e e0) {
        Iterable iterable0 = this.z();
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: iterable0) {
            Iterable iterable1 = ((x)object0).E().b(e0, Ue.c.e);
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, iterable1));
            for(Object object1: iterable1) {
                arrayList1.add(((Me.L)object1));
            }
            je.u.U(arrayList0, arrayList1);
        }
        return je.p.T0(arrayList0);
    }

    public static boolean K(L l0, Me.u u0) {
        String s = d5.n.q(l0, 2);
        Me.u u1 = u0.a();
        q.f(u1, "getOriginal(...)");
        return q.b(s, d5.n.q(u1, 2)) && !o.D(l0, u0);
    }

    public final boolean L(L l0) {
        List list0;
        qf.e e0 = l0.getName();
        q.f(e0, "getName(...)");
        String s = e0.b();
        q.f(s, "asString(...)");
        if(v.r0(s, "get", false) || v.r0(s, "is", false)) {
            qf.e e1 = ye.a.R(e0, "get", null, 12);
            if(e1 == null) {
                e1 = ye.a.R(e0, "is", null, 8);
            }
            list0 = e.k.B(e1);
        }
        else if(v.r0(s, "set", false)) {
            list0 = je.n.g0(new qf.e[]{ye.a.R(e0, "set", null, 4), ye.a.R(e0, "set", "is", 4)});
        }
        else {
            list0 = (List)f.b.get(e0);
            if(list0 == null) {
                list0 = w.a;
            }
        }
        if(!(list0 instanceof Collection) || !list0.isEmpty()) {
            for(Object object0: list0) {
                Iterable iterable0 = this.J(((qf.e)object0));
                if(iterable0 instanceof Collection && ((Collection)iterable0).isEmpty()) {
                    continue;
                }
                Iterator iterator1 = iterable0.iterator();
            label_23:
                if(!iterator1.hasNext()) {
                    continue;
                }
                Object object1 = iterator1.next();
                Me.L l1 = (Me.L)object1;
                if(!this.C(l1, new G(4, l0, this))) {
                    goto label_23;
                }
                if(l1.P()) {
                    return false;
                }
                String s1 = l0.getName().b();
                q.f(s1, "asString(...)");
                if(v.r0(s1, "set", false)) {
                    goto label_23;
                }
                return false;
            }
        }
        qf.e e2 = l0.getName();
        q.f(e2, "getName(...)");
        qf.e e3 = (qf.e)E.k.get(e2);
        if(e3 != null) {
            LinkedHashSet linkedHashSet0 = this.I(e3);
            ArrayList arrayList0 = new ArrayList();
            for(Object object2: linkedHashSet0) {
                q.g(((L)object2), "<this>");
                if(B.a.D(((L)object2)) != null) {
                    arrayList0.add(object2);
                }
            }
            if(!arrayList0.isEmpty()) {
                t t0 = l0.N0();
                t0.o(e3);
                t0.t();
                t0.l();
                Me.u u0 = t0.build();
                q.d(u0);
                if(!arrayList0.isEmpty()) {
                    for(Object object3: arrayList0) {
                        if(o.E(((L)object3), ((L)u0))) {
                            return false;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
            }
        }
        qf.e e4 = l0.getName();
        q.f(e4, "getName(...)");
        if(Ze.e.b(e4)) {
            qf.e e5 = l0.getName();
            q.f(e5, "getName(...)");
            LinkedHashSet linkedHashSet1 = this.I(e5);
            ArrayList arrayList1 = new ArrayList();
            for(Object object4: linkedHashSet1) {
                Me.u u1 = Ze.e.a(((L)object4));
                if(u1 != null) {
                    arrayList1.add(u1);
                }
            }
            if(!arrayList1.isEmpty()) {
                for(Object object5: arrayList1) {
                    if(o.K(l0, ((Me.u)object5))) {
                        return false;
                    }
                    if(false) {
                        break;
                    }
                }
            }
        }
        L l2 = o.B(l0);
        if(l2 != null) {
            qf.e e6 = l0.getName();
            q.f(e6, "getName(...)");
            LinkedHashSet linkedHashSet2 = this.I(e6);
            if(!linkedHashSet2.isEmpty()) {
                for(Object object6: linkedHashSet2) {
                    if(!((L)object6).isSuspend() || !o.D(l2, ((L)object6))) {
                        continue;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public final void M(qf.e e0, Ue.a a0) {
        q.g(e0, "name");
        q.g(a0, "location");
        q.g(((a)this.b.a).n, "<this>");
        q.g(this.n, "scopeOwner");
    }

    public final ArrayList N(qf.e e0) {
        Iterable iterable0 = ((df.c)this.e.invoke()).e(e0);
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            arrayList0.add(this.t(((Se.w)object0)));
        }
        return arrayList0;
    }

    public final ArrayList O(qf.e e0) {
        LinkedHashSet linkedHashSet0 = this.I(e0);
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: linkedHashSet0) {
            q.g(((L)object0), "<this>");
            if(B.a.D(((L)object0)) == null && Ze.e.a(((L)object0)) == null) {
                arrayList0.add(object0);
            }
        }
        return arrayList0;
    }

    @Override  // df.C
    public final Collection b(qf.e e0, Ue.c c0) {
        q.g(e0, "name");
        this.M(e0, c0);
        return super.b(e0, c0);
    }

    @Override  // Af.q
    public final h c(qf.e e0, Ue.a a0) {
        q.g(e0, "name");
        q.g(a0, "location");
        this.M(e0, a0);
        o o0 = (o)this.c;
        if(o0 != null) {
            j j0 = o0.u;
            if(j0 != null) {
                h h0 = (e)j0.invoke(e0);
                return h0 == null ? ((h)this.u.invoke(e0)) : h0;
            }
        }
        return (h)this.u.invoke(e0);
    }

    @Override  // df.C
    public final Collection f(qf.e e0, Ue.a a0) {
        q.g(e0, "name");
        this.M(e0, a0);
        return super.f(e0, a0);
    }

    @Override  // df.C
    public final Set h(Af.f f0, we.k k0) {
        q.g(f0, "kindFilter");
        return I.K(((Set)this.r.invoke()), ((Map)this.t.invoke()).keySet());
    }

    @Override  // df.C
    public final Set i(Af.f f0, Af.m m0) {
        q.g(f0, "kindFilter");
        e e0 = this.n;
        Collection collection0 = e0.q().f();
        q.f(collection0, "getSupertypes(...)");
        Set set0 = new LinkedHashSet();
        for(Object object0: collection0) {
            je.u.U(set0, ((x)object0).E().a());
        }
        ((AbstractCollection)set0).addAll(((df.c)this.e.invoke()).a());
        ((AbstractCollection)set0).addAll(((df.c)this.e.invoke()).b());
        ((AbstractCollection)set0).addAll(this.h(f0, m0));
        ((AbstractCollection)set0).addAll(((yf.a)((a)this.b.a).x).e(e0, this.b));
        return set0;
    }

    @Override  // df.C
    public final void j(ArrayList arrayList0, qf.e e0) {
        q.g(e0, "name");
        boolean z = this.o.g();
        e e1 = this.n;
        u u0 = this.b;
        if(z) {
            i i0 = this.e;
            if(((df.c)i0.invoke()).f(e0) != null) {
                if(!arrayList0.isEmpty()) {
                    for(Object object0: arrayList0) {
                        if(!((L)object0).F().isEmpty()) {
                            continue;
                        }
                        ((yf.a)((a)u0.a).x).b(e1, e0, arrayList0, u0);
                        return;
                    }
                }
                z z1 = ((df.c)i0.invoke()).f(e0);
                q.d(z1);
                cf.c c0 = u0.Q(u0, z1);
                a a0 = (a)u0.a;
                bf.f f0 = bf.f.I1(e1, c0, z1.c(), a0.j.b(z1), true);
                ef.a a1 = df.v.L(W.b, false, null, 6);
                x x0 = ((V)u0.d).C(z1.f(), a1);
                Pe.u u1 = this.p();
                y.a.getClass();
                f0.H1(null, u1, w.a, w.a, w.a, x0, y.d, Me.p.e, null);
                f0.Y = 1;
                a0.g.getClass();
                arrayList0.add(f0);
            }
        }
        ((yf.a)((a)u0.a).x).b(e1, e0, arrayList0, u0);
    }

    @Override  // df.C
    public final df.c k() {
        return new df.a(this.o, df.m.b);
    }

    @Override  // df.C
    public final void m(LinkedHashSet linkedHashSet0, qf.e e0) {
        q.g(e0, "name");
        LinkedHashSet linkedHashSet1 = this.I(e0);
        if(!E.j.contains(e0) && !Ze.e.b(e0)) {
            if(!linkedHashSet1.isEmpty()) {
                for(Object object0: linkedHashSet1) {
                    if(!((Me.u)object0).isSuspend()) {
                        continue;
                    }
                    goto label_18;
                }
            }
            ArrayList arrayList0 = new ArrayList();
            for(Object object1: linkedHashSet1) {
                if(this.L(((L)object1))) {
                    arrayList0.add(object1);
                }
            }
            this.w(linkedHashSet0, e0, arrayList0, false);
            return;
        }
    label_18:
        Qf.h h0 = Qf.k.e();
        LinkedHashSet linkedHashSet2 = V4.u.D(e0, linkedHashSet1, w.a, this.n, Df.l.a, ((If.l)((a)this.b.a).u).d);
        this.x(e0, linkedHashSet0, linkedHashSet2, linkedHashSet0, new D(1, this, o.class, "searchMethodsByNameWithoutBuiltinMagic", "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;", 0, 16));
        this.x(e0, linkedHashSet0, linkedHashSet2, h0, new D(1, this, o.class, "searchMethodsInSupertypesWithoutBuiltinMagic", "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;", 0, 17));
        ArrayList arrayList1 = new ArrayList();
        for(Object object2: linkedHashSet1) {
            if(this.L(((L)object2))) {
                arrayList1.add(object2);
            }
        }
        this.w(linkedHashSet0, e0, je.p.A0(arrayList1, h0), true);
    }

    @Override  // df.C
    public final void n(ArrayList arrayList0, qf.e e0) {
        q.g(e0, "name");
        u u0 = this.b;
        if(this.o.a.isAnnotation()) {
            Se.w w0 = (Se.w)je.p.F0(((df.c)this.e.invoke()).e(e0));
            if(w0 != null) {
                cf.c c0 = u0.Q(u0, w0);
                Me.o o0 = De.I.W(w0.e());
                qf.e e1 = w0.c();
                g g0 = ((a)u0.a).j.b(w0);
                bf.g g1 = bf.g.B1(this.n, c0, o0, false, e1, g0, false);
                J j0 = tf.m.f(g1, Ne.g.a);
                g1.x1(j0, null, null, null);
                q.g(u0, "<this>");
                Object object0 = u0.c;
                x x0 = C.l(w0, new u(((a)u0.a), new A1.k(u0, g1, w0, 0), ((ie.j)object0)));
                Pe.u u1 = this.p();
                g1.A1(x0, w.a, u1, null, w.a);
                j0.m = x0;
                arrayList0.add(g1);
            }
        }
        Set set0 = this.J(e0);
        if(set0.isEmpty()) {
            return;
        }
        Qf.h h0 = Qf.k.e();
        Qf.h h1 = Qf.k.e();
        this.y(set0, arrayList0, h0, new df.n(this, 0));
        this.y(I.I(set0, h0), h1, null, new df.n(this, 1));
        arrayList0.addAll(V4.u.D(e0, I.K(set0, h1), arrayList0, this.n, ((a)u0.a).f, ((If.l)((a)u0.a).u).d));
    }

    @Override  // df.C
    public final Set o(Af.f f0) {
        q.g(f0, "kindFilter");
        if(this.o.a.isAnnotation()) {
            return this.a();
        }
        Set set0 = new LinkedHashSet(((df.c)this.e.invoke()).c());
        Collection collection0 = this.n.q().f();
        q.f(collection0, "getSupertypes(...)");
        for(Object object0: collection0) {
            je.u.U(set0, ((x)object0).E().g());
        }
        return set0;
    }

    @Override  // df.C
    public final Pe.u p() {
        e e0 = this.n;
        if(e0 != null) {
            return e0.P0();
        }
        tf.e.a(0);
        throw null;
    }

    @Override  // df.C
    public final Me.k q() {
        return this.n;
    }

    // 去混淆评级： 低(20)
    @Override  // df.C
    public final boolean r(bf.f f0) {
        return this.o.a.isAnnotation() ? false : this.L(f0);
    }

    @Override  // df.C
    public final A s(Se.w w0, ArrayList arrayList0, x x0, List list0) {
        q.g(w0, "method");
        ((a)this.b.a).e.getClass();
        if(this.n == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter \'owner\' of kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1.resolvePropagatedSignature must not be null");
        }
        List list1 = Collections.EMPTY_LIST;
        if(list1 == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter \'signatureErrors\' of kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature.<init> must not be null");
        }
        return new A(x0, list0, arrayList0, list1);
    }

    @Override  // df.C
    public final String toString() {
        return "Lazy Java member scope for " + this.o.c();
    }

    public final void v(ArrayList arrayList0, b b0, int v, Se.w w0, x x0, x x1) {
        s s0;
        qf.e e0 = w0.c();
        a0 a00 = null;
        if(x0 != null) {
            a0 a01 = Hf.Y.g(x0, false);
            Object object0 = w0.a.getDefaultValue();
            if(object0 == null) {
                s0 = null;
            }
            else {
                Class class0 = object0.getClass();
                if(Enum.class.isAssignableFrom(class0)) {
                    s0 = new s(null, ((Enum)object0));
                }
                else if(object0 instanceof Annotation) {
                    s0 = new Se.f(null, ((Annotation)object0));
                }
                else if(object0 instanceof Object[]) {
                    s0 = new Se.g(null, ((Object[])object0));
                }
                else if(object0 instanceof Class) {
                    s0 = new Se.o(null, ((Class)object0));
                }
                else {
                    s0 = new Se.u(null, object0);
                }
            }
            if(x1 != null) {
                a00 = Hf.Y.g(x1, false);
            }
            g g0 = ((a)this.b.a).j.b(w0);
            arrayList0.add(new S(b0, null, v, Ne.g.a, e0, a01, s0 != null, false, false, a00, g0));
            return;
        }
        Hf.Y.a(2);
        throw null;
    }

    public final void w(LinkedHashSet linkedHashSet0, qf.e e0, ArrayList arrayList0, boolean z) {
        LinkedHashSet linkedHashSet1 = V4.u.D(e0, arrayList0, linkedHashSet0, this.n, ((a)this.b.a).f, ((If.l)((a)this.b.a).u).d);
        if(!z) {
            linkedHashSet0.addAll(linkedHashSet1);
            return;
        }
        ArrayList arrayList1 = je.p.A0(linkedHashSet0, linkedHashSet1);
        ArrayList arrayList2 = new ArrayList(je.q.Q(10, linkedHashSet1));
        for(Object object0: linkedHashSet1) {
            L l0 = (L)object0;
            L l1 = (L)B.a.E(l0);
            if(l1 != null) {
                l0 = o.A(l0, l1, arrayList1);
            }
            arrayList2.add(l0);
        }
        linkedHashSet0.addAll(arrayList2);
    }

    public final void x(qf.e e0, LinkedHashSet linkedHashSet0, LinkedHashSet linkedHashSet1, AbstractSet abstractSet0, we.k k0) {
        L l6;
        L l5;
        Iterator iterator0 = linkedHashSet1.iterator();
        while(iterator0.hasNext()) {
            L l0 = null;
            Object object0 = iterator0.next();
            L l1 = (L)object0;
            L l2 = (L)B.a.D(l1);
            L l3 = null;
            if(l2 != null) {
                String s = B.a.B(l2);
                q.d(s);
                for(Object object1: ((Collection)k0.invoke(qf.e.e(s)))) {
                    t t0 = ((L)object1).N0();
                    t0.o(e0);
                    t0.t();
                    t0.l();
                    Me.u u0 = t0.build();
                    q.d(u0);
                    L l4 = (L)u0;
                    if(o.E(l2, l4)) {
                        l0 = o.A(l4, l2, linkedHashSet0);
                        break;
                    }
                }
            }
            Qf.k.a(abstractSet0, l0);
            Me.u u1 = Ze.e.a(l1);
            if(u1 == null) {
                l6 = null;
            }
            else {
                qf.e e1 = ((Pe.m)u1).getName();
                q.f(e1, "getName(...)");
                for(Object object2: ((Iterable)k0.invoke(e1))) {
                    if(!o.K(((L)object2), u1)) {
                        continue;
                    }
                    goto label_33;
                }
                object2 = null;
            label_33:
                if(((L)object2) == null) {
                    l5 = null;
                }
                else {
                    t t1 = ((L)object2).N0();
                    List list0 = u1.F();
                    q.f(list0, "getValueParameters(...)");
                    ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
                    for(Object object3: list0) {
                        arrayList0.add(((S)object3).getType());
                    }
                    List list1 = ((L)object2).F();
                    q.f(list1, "getValueParameters(...)");
                    t1.a(x1.a.o(arrayList0, list1, u1));
                    t1.t();
                    t1.l();
                    t1.p();
                    l5 = (L)t1.build();
                }
                if(l5 != null) {
                    if(!this.L(l5)) {
                        l5 = null;
                    }
                    if(l5 != null) {
                        l6 = o.A(l5, u1, linkedHashSet0);
                    }
                }
            }
            Qf.k.a(abstractSet0, l6);
            if(l1.isSuspend()) {
                qf.e e2 = l1.getName();
                q.f(e2, "getName(...)");
                for(Object object4: ((Iterable)k0.invoke(e2))) {
                    L l7 = o.B(((L)object4));
                    if(l7 == null || !o.D(l7, l1)) {
                        l7 = null;
                    }
                    if(l7 != null) {
                        l3 = l7;
                        break;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            Qf.k.a(abstractSet0, l3);
        }
    }

    public final void y(Set set0, AbstractCollection abstractCollection0, Qf.h h0, we.k k0) {
        bf.d d0;
        K k1;
        L l2;
        for(Object object0: set0) {
            Me.L l0 = (Me.L)object0;
            if(this.C(l0, k0)) {
                L l1 = this.G(l0, k0);
                q.d(l1);
                if(l0.P()) {
                    l2 = o.H(l0, k0);
                    q.d(l2);
                }
                else {
                    l2 = null;
                }
                if(l2 != null) {
                    l2.i();
                    l1.i();
                }
                q.g(this.n, "ownerDescriptor");
                y y0 = l1.i();
                Me.o o0 = l1.getVisibility();
                qf.e e0 = l0.getName();
                N n0 = l1.getSource();
                bf.d d1 = new bf.d(this.n, Ne.g.a, y0, o0, l2 != null, e0, n0, null, 1, false, null);  // 初始化器: Lbf/g;-><init>(LMe/k;LNe/h;LMe/y;LMe/o;ZLqf/e;LMe/N;LMe/L;IZLie/m;)V
                x x0 = l1.g;
                q.d(x0);
                Pe.u u0 = this.p();
                d1.A1(x0, w.a, u0, null, w.a);
                J j0 = tf.m.l(d1, l1.getAnnotations(), false, l1.getSource());
                j0.l = l1;
                j0.w1(d1.getType());
                if(l2 == null) {
                    k1 = null;
                }
                else {
                    List list0 = l2.F();
                    q.f(list0, "getValueParameters(...)");
                    S s0 = (S)je.p.m0(list0);
                    if(s0 == null) {
                        throw new AssertionError("No parameter found for " + l2);
                    }
                    k1 = tf.m.m(d1, l2.getAnnotations(), s0.getAnnotations(), false, l2.getVisibility(), l2.getSource());
                    k1.l = l2;
                }
                d1.x1(j0, k1, null, null);
                d0 = d1;
            }
            else {
                d0 = null;
            }
            if(d0 != null) {
                abstractCollection0.add(d0);
                if(h0 == null) {
                    break;
                }
                h0.add(l0);
                return;
            }
            if(false) {
                break;
            }
        }
    }

    public final Collection z() {
        e e0 = this.n;
        if(this.p) {
            Collection collection0 = e0.q().f();
            q.f(collection0, "getSupertypes(...)");
            return collection0;
        }
        ((If.l)((a)this.b.a).u).getClass();
        q.g(e0, "classDescriptor");
        Collection collection1 = e0.q().f();
        q.f(collection1, "getSupertypes(...)");
        return collection1;
    }
}

