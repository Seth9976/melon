package hf;

import Ac.G;
import Ac.q0;
import Hf.B;
import Hf.I;
import Hf.M;
import Hf.P;
import Hf.Y;
import Hf.a0;
import Hf.b0;
import Hf.x;
import If.l;
import If.m;
import Kf.i;
import Me.L;
import Me.S;
import Ne.a;
import Pe.J;
import Tf.v;
import U4.F;
import Ze.b;
import Ze.t;
import Ze.z;
import com.google.firebase.messaging.u;
import d5.f;
import df.j;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import je.n;
import je.p;
import je.w;
import we.k;

public final class c {
    public x a(H4.c c0, x x0, List list0, q q0, boolean z) {
        g g9;
        d d5;
        e e2;
        g g2;
        h h8;
        h h7;
        b b1;
        e e1;
        Ne.h h2;
        int v6;
        S s1;
        Ne.h h0;
        int v4;
        int v2;
        d d1;
        i i0;
        int v;
        a a0 = (a)c0.c;
        u u0 = (u)c0.d;
        boolean z1 = c0.a;
        kotlin.jvm.internal.q.g(x0, "<this>");
        ArrayList arrayList0 = c0.i(x0);
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            arrayList1.add(c0.i(((Kf.d)object0)));
        }
        if(z1 && (!(list0 instanceof Collection) || !list0.isEmpty())) {
            for(Object object1: list0) {
                kotlin.jvm.internal.q.g(((Kf.d)object1), "other");
                if(((l)((cf.a)u0.a).u).a(x0, ((x)(((Kf.d)object1))))) {
                    continue;
                }
                v = 1;
                goto label_20;
            }
        }
        v = arrayList0.size();
    label_20:
        d[] arr_d = new d[v];
        int v1 = 0;
        while(v1 < v) {
            hf.a a1 = (hf.a)arrayList0.get(v1);
            Ze.a a2 = (Ze.a)c0.e;
            Kf.d d0 = a1.a;
            S s0 = a1.c;
            m m0 = m.a;
            if(d0 == null) {
                if(s0 == null) {
                    i0 = null;
                }
                else {
                    b0 b00 = s0.y();
                    kotlin.jvm.internal.q.f(b00, "getVariance(...)");
                    i0 = f.m(b00);
                }
                if(i0 == i.b) {
                    d1 = d.e;
                    v2 = v;
                }
            }
            else {
                int v3 = s0 == null ? 1 : 0;
                w w0 = w.a;
                if(d0 == null) {
                    v4 = v3;
                    h0 = w0;
                }
                else {
                    v4 = v3;
                    h0 = ((x)d0).getAnnotations();
                }
                if(d0 == null) {
                    s1 = null;
                }
                else {
                    M m1 = m0.F(d0);
                    if(m1 != null) {
                        s1 = If.g.s(m1);
                    }
                }
                v2 = v;
                int v5 = a2 == Ze.a.f ? 1 : 0;
                if(v4 == 0) {
                    v6 = v5;
                }
                else {
                    v6 = v5;
                    if(v5 == 0) {
                        ((cf.a)u0.a).t.getClass();
                    }
                    if(a0 != null) {
                        Ne.h h1 = a0.getAnnotations();
                        if(h1 != null) {
                            w0 = h1;
                        }
                    }
                    h0 = p.x0(w0, h0);
                }
                ((cf.a)u0.a).q.getClass();
                e e0 = null;
                Iterator iterator2 = h0.iterator();
                while(true) {
                    if(!iterator2.hasNext()) {
                        h2 = h0;
                        break;
                    }
                    Object object2 = iterator2.next();
                    h2 = h0;
                    qf.c c1 = b.d(object2);
                    if(p.d0(Ze.w.n, c1)) {
                        e1 = e.a;
                        goto label_78;
                    }
                    else if(p.d0(Ze.w.o, c1)) {
                        e1 = e.b;
                    label_78:
                        if(e0 == null || e0 == e1) {
                            e0 = e1;
                        }
                        else {
                            e0 = null;
                            break;
                        }
                    }
                    h0 = h2;
                }
                b b0 = ((cf.a)u0.a).q;
                G g0 = new G(6, c0, a1);
                b0.getClass();
                h h3 = null;
                for(Object object3: h2) {
                    h h4 = b0.g(object3, ((Boolean)g0.invoke(object3)).booleanValue());
                    if(h4 == null) {
                        Object object4 = b0.i(object3);
                        if(object4 != null) {
                            z z2 = b0.h(object3);
                            if(z2 == null) {
                                z2 = ((t)b0.a.c).a;
                            }
                            if(z2 == z.b) {
                                b1 = b0;
                                h4 = null;
                                goto label_113;
                            }
                            else {
                                h h5 = b0.g(object4, ((Boolean)g0.invoke(object4)).booleanValue());
                                if(h5 != null) {
                                    b1 = b0;
                                    h4 = h.a(h5, null, z2 == z.c, 1);
                                    goto label_113;
                                }
                            }
                        }
                        b1 = b0;
                        h4 = null;
                    }
                    else {
                        b1 = b0;
                    }
                label_113:
                    if(h3 == null) {
                    label_123:
                        h3 = h4;
                    }
                    else {
                        boolean z3 = h3.b;
                        if(h4 != null && !h4.equals(h3)) {
                            boolean z4 = h4.b;
                            if(!z4 || z3) {
                                if(z4 || !z3) {
                                    h3 = null;
                                    break;
                                }
                                else {
                                    h3 = h4;
                                    goto label_124;
                                }
                                goto label_123;
                            }
                        }
                    }
                label_124:
                    b0 = b1;
                }
                if(h3 == null) {
                    if(v4 == 0 && v6 == 0) {
                        a2 = Ze.a.e;
                    }
                    Ze.m m2 = a1.b == null ? null : ((Ze.m)a1.b.a.get(a2));
                    h h6 = s1 == null ? null : H4.c.c(s1);
                    if(h6 == null) {
                        h7 = m2 == null ? null : m2.a;
                    }
                    else {
                        h7 = h.a(h6, g.c, false, 2);
                    }
                    boolean z5 = (h6 == null ? null : h6.a) == g.c || s1 != null && m2 != null && m2.c;
                    if(s0 == null) {
                        h8 = null;
                    }
                    else {
                        h8 = H4.c.c(s0);
                        if(h8 == null) {
                            h8 = null;
                        }
                        else if(h8.a == g.b) {
                            h8 = h.a(h8, g.a, false, 2);
                        }
                    }
                    if(h8 != null && (h7 == null || (!h8.b || h7.b) && (!h8.b && h7.b || h8.a.compareTo(h7.a) >= 0 && h8.a.compareTo(h7.a) > 0))) {
                        h7 = h8;
                    }
                    d1 = new d((h7 == null ? null : h7.a), e0, z5, h7 != null && h7.b);
                }
                else {
                    d1 = new d(h3.a, e0, h3.a == g.c && s1 != null, h3.b);
                }
            }
            boolean z6 = d1.d;
            ArrayList arrayList2 = new ArrayList();
            for(Object object5: arrayList1) {
                hf.a a3 = (hf.a)p.n0(v1, ((List)object5));
                if(a3 == null) {
                    d5 = null;
                }
                else {
                    Kf.d d2 = a3.a;
                    if(d2 != null) {
                        g g1 = H4.c.f(d2);
                        if(g1 == null) {
                            x x1 = Hf.c.g(((x)d2));
                            g2 = x1 == null ? null : H4.c.f(x1);
                        }
                        else {
                            g2 = g1;
                        }
                        qf.d d3 = H4.c.e(m0.k0(d2));
                        if(Le.d.k.containsKey(d3)) {
                            e2 = e.a;
                        }
                        else {
                            qf.d d4 = H4.c.e(m0.g(d2));
                            e2 = Le.d.j.containsKey(d4) ? e.b : null;
                        }
                        d5 = new d(g2, e2, m0.B(d2) || ((x)d2).I() instanceof hf.f, g2 != g1);
                    }
                }
                if(d5 != null) {
                    arrayList2.add(d5);
                }
            }
            boolean z7 = v1 == 0 && z1;
            boolean z8 = v1 == 0 && a0 instanceof Pe.S && ((Pe.S)a0).j != null;
            g g3 = d1.a;
            ArrayList arrayList3 = new ArrayList();
            for(Object object6: arrayList2) {
                d d6 = (d)object6;
                g g4 = d6.d ? null : d6.a;
                if(g4 != null) {
                    arrayList3.add(g4);
                }
            }
            Set set0 = p.T0(arrayList3);
            g g5 = z6 ? null : g3;
            g g6 = g5 == g.a ? g.a : ((g)df.d.I(set0, g.c, g.b, g5, z7));
            if(g6 == null) {
                ArrayList arrayList4 = new ArrayList();
                for(Object object7: arrayList2) {
                    g g7 = ((d)object7).a;
                    if(g7 != null) {
                        arrayList4.add(g7);
                    }
                }
                Set set1 = p.T0(arrayList4);
                g g8 = g.a;
                g9 = g3 == g8 ? g8 : ((g)df.d.I(set1, g.c, g.b, g3, z7));
            }
            else {
                g9 = g6;
            }
            ArrayList arrayList5 = new ArrayList();
            for(Object object8: arrayList2) {
                e e3 = ((d)object8).b;
                if(e3 != null) {
                    arrayList5.add(e3);
                }
            }
            boolean z9 = false;
            e e4 = (e)df.d.I(p.T0(arrayList5), e.b, e.a, d1.b, z7);
            g g10 = g9 == null || z || z8 && g9 == g.b ? null : g9;
            boolean z10 = g10 != null && g6 == null;
            if(g10 == g.c) {
                if(z6 == z10 && d1.c) {
                    z9 = true;
                }
                else if(!arrayList2.isEmpty()) {
                    for(Object object9: arrayList2) {
                        if(((d)object9).d == z10 && ((d)object9).c) {
                            z9 = true;
                            break;
                        }
                    }
                }
            }
            arr_d[v1] = new d(g10, e4, z9, z10);
            ++v1;
            v = v2;
        }
        G g11 = new G(7, q0, arr_d);
        boolean z11 = c0.b;
        return (x)c.d(x0.I(), g11, 0, z11).b;
    }

    public x b(Me.c c0, Me.b b0, boolean z, u u0, Ze.a a0, q q0, boolean z1, k k0) {
        H4.c c1 = new H4.c(b0, z, u0, a0, false);
        x x0 = (x)k0.invoke(c0);
        Collection collection0 = c0.f();
        kotlin.jvm.internal.q.f(collection0, "getOverriddenDescriptors(...)");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, collection0));
        for(Object object0: collection0) {
            kotlin.jvm.internal.q.d(((Me.c)object0));
            arrayList0.add(((x)k0.invoke(((Me.c)object0))));
        }
        return this.a(c1, x0, arrayList0, q0, z1);
    }

    public static O.a c(B b0, G g0, int v, hf.p p0, boolean z, boolean z1) {
        Ne.h h2;
        Hf.G g1;
        T3.e e0;
        M m0;
        Boolean boolean0;
        Me.h h1;
        hf.p p1 = hf.p.c;
        if(p0 == p1 && b0.r().isEmpty()) {
            return new O.a(null, 1, false);
        }
        Me.h h0 = b0.w().e();
        if(h0 == null) {
            return new O.a(null, 1, false);
        }
        d d0 = (d)g0.invoke(v);
        if(p0 == p1 || !(h0 instanceof Me.e)) {
            h1 = null;
        }
        else if(d0.b == e.a && p0 == hf.p.a) {
            qf.d d1 = tf.e.g(((Me.e)h0));
            HashMap hashMap0 = Le.d.j;
            if(hashMap0.containsKey(d1)) {
                qf.c c0 = (qf.c)hashMap0.get(tf.e.g(((Me.e)h0)));
                if(c0 == null) {
                    throw new IllegalArgumentException("Given class " + ((Me.e)h0) + " is not a mutable collection");
                }
                h1 = xf.d.e(((Me.e)h0)).j(c0);
            }
            else {
                goto label_17;
            }
        }
        else {
        label_17:
            if(d0.b != e.b || p0 != hf.p.b) {
                h1 = null;
            }
            else {
                qf.d d2 = tf.e.g(((Me.e)h0));
                h1 = Le.d.k.containsKey(d2) ? Le.e.a(((Me.e)h0)) : null;
            }
        }
        if(p0 == p1) {
            boolean0 = null;
        }
        else {
            switch((d0.a == null ? -1 : r.a[d0.a.ordinal()])) {
                case 1: {
                    boolean0 = Boolean.TRUE;
                    break;
                }
                case 2: {
                    boolean0 = Boolean.FALSE;
                    break;
                }
                default: {
                    boolean0 = null;
                }
            }
        }
        if(h1 == null) {
            m0 = b0.w();
        }
        else {
            m0 = h1.q();
            if(m0 == null) {
                m0 = b0.w();
            }
        }
        int v1 = v + 1;
        Iterable iterable0 = b0.r();
        List list0 = m0.getParameters();
        kotlin.jvm.internal.q.f(list0, "getParameters(...)");
        Iterator iterator0 = iterable0.iterator();
        Iterator iterator1 = list0.iterator();
        ArrayList arrayList0 = new ArrayList(Math.min(je.q.Q(10, iterable0), je.q.Q(10, list0)));
        while(iterator0.hasNext() && iterator1.hasNext()) {
            Object object0 = iterator0.next();
            Object object1 = iterator1.next();
            S s0 = (S)object1;
            P p2 = (P)object0;
            if(z1 && z) {
                e0 = new T3.e(null, 0);
            }
            else if(!p2.c()) {
                e0 = c.d(p2.b().I(), g0, v1, z1);
            }
            else if(((d)g0.invoke(v1)).a == g.a) {
                a0 a00 = p2.b().I();
                e0 = new T3.e(Hf.c.f(Hf.c.m(a00).V(false), Hf.c.E(a00).V(true)), 1);
            }
            else {
                e0 = new T3.e(null, 1);
            }
            v1 += e0.a;
            x x0 = (x)e0.b;
            if(x0 != null) {
                b0 b00 = p2.a();
                kotlin.jvm.internal.q.f(b00, "getProjectionKind(...)");
                g1 = F.o(x0, b00, s0);
            }
            else if(h1 == null || p2.c()) {
                g1 = h1 == null ? null : Y.j(s0);
            }
            else {
                x x1 = p2.b();
                kotlin.jvm.internal.q.f(x1, "getType(...)");
                b0 b01 = p2.a();
                kotlin.jvm.internal.q.f(b01, "getProjectionKind(...)");
                g1 = F.o(x1, b01, s0);
            }
            arrayList0.add(g1);
        }
        int v2 = v1 - v;
        if(h1 == null && boolean0 == null) {
            if(!arrayList0.isEmpty()) {
                for(Object object2: arrayList0) {
                    if(((P)object2) == null) {
                        continue;
                    }
                    goto label_91;
                }
            }
            return new O.a(null, v2, false);
        }
    label_91:
        ArrayList arrayList1 = n.g0(new Ne.h[]{b0.getAnnotations(), (h1 == null ? null : s.b), (boolean0 == null ? null : s.a)});
        switch(arrayList1.size()) {
            case 0: {
                throw new IllegalStateException("At least one Annotations object expected");
            }
            case 1: {
                h2 = (Ne.h)p.E0(arrayList1);
                break;
            }
            default: {
                h2 = new Ne.i(p.P0(arrayList1), 1);
                break;
            }
        }
        I i0 = Hf.c.C(h2);
        Iterable iterable1 = b0.r();
        Iterator iterator3 = arrayList0.iterator();
        Iterator iterator4 = iterable1.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(je.q.Q(10, arrayList0), je.q.Q(10, iterable1)));
        while(iterator3.hasNext() && iterator4.hasNext()) {
            Object object3 = iterator3.next();
            Object object4 = iterator4.next();
            P p3 = (P)object4;
            P p4 = (P)object3;
            if(p4 != null) {
                p3 = p4;
            }
            arrayList2.add(p3);
        }
        B b1 = Hf.c.u(i0, m0, arrayList2, (boolean0 == null ? b0.D() : boolean0.booleanValue()));
        if(d0.c) {
            b1 = new hf.f(b1);
        }
        return boolean0 == null || !d0.d ? new O.a(b1, v2, false) : new O.a(b1, v2, true);
    }

    public static T3.e d(a0 a00, G g0, int v, boolean z) {
        a0 a01 = null;
        if(Hf.c.k(a00)) {
            return new T3.e(null, 1);
        }
        if(a00 instanceof Hf.p) {
            B b0 = ((Hf.p)a00).c;
            a0 a02 = ((Hf.p)a00).b;
            O.a a0 = c.c(((Hf.p)a00).b, g0, v, hf.p.a, a00 instanceof ef.h, z);
            O.a a1 = c.c(((Hf.p)a00).c, g0, v, hf.p.b, a00 instanceof ef.h, z);
            B b1 = (B)a1.c;
            a0 a03 = (B)a0.c;
            if(a03 != null || b1 != null) {
                if(!a0.b && !a1.b) {
                    if(a00 instanceof ef.h) {
                        if(a03 != null) {
                            a02 = a03;
                        }
                        if(b1 != null) {
                            b0 = b1;
                        }
                        return new T3.e(new ef.h(((B)a02), b0), a0.a);
                    }
                    if(a03 != null) {
                        a02 = a03;
                    }
                    if(b1 != null) {
                        b0 = b1;
                    }
                    return new T3.e(Hf.c.f(((B)a02), b0), a0.a);
                }
                if(b1 == null) {
                    kotlin.jvm.internal.q.d(a03);
                }
                else {
                    if(a03 == null) {
                        a03 = b1;
                    }
                    a03 = Hf.c.f(((B)a03), b1);
                }
                a01 = Hf.c.G(a00, a03);
            }
            return new T3.e(a01, a0.a);
        }
        if(!(a00 instanceof B)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        O.a a2 = c.c(((B)a00), g0, v, hf.p.c, false, z);
        a0 a04 = (B)a2.c;
        if(a2.b) {
            a04 = Hf.c.G(a00, a04);
        }
        return new T3.e(a04, a2.a);
    }

    // This method was un-flattened
    public ArrayList e(u u0, Collection collection0) {
        Ze.g g0;
        ie.m m1;
        boolean z;
        hf.m m0;
        x x0;
        Me.c c1;
        Ne.h h1;
        hf.n n0 = hf.n.e;
        kotlin.jvm.internal.q.g(u0, "c");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, collection0));
        for(Object object0: collection0) {
            Me.c c0 = (Me.c)object0;
            if(c0 instanceof bf.a && (c0.getKind() != 2 || c0.a().f().size() != 1)) {
                Me.h h0 = Me.w.g(c0);
                if(h0 == null) {
                    h1 = ((Bf.a)c0).getAnnotations();
                }
                else {
                    j j0 = h0 instanceof j ? ((j)h0) : null;
                    List list0 = j0 == null ? null : ((List)j0.k.getValue());
                    if(list0 == null || list0.isEmpty()) {
                        h1 = ((Bf.a)c0).getAnnotations();
                    }
                    else {
                        ArrayList arrayList1 = new ArrayList(je.q.Q(10, list0));
                        for(Object object1: list0) {
                            arrayList1.add(new df.h(((Se.d)object1), u0, true));
                        }
                        ArrayList arrayList2 = p.x0(((Bf.a)c0).getAnnotations(), arrayList1);
                        h1 = arrayList2.isEmpty() ? Ne.g.a : new Ne.i(arrayList2, 0);
                    }
                }
                u u1 = f.n(u0, h1);
                if(c0 instanceof bf.g) {
                    J j1 = ((Pe.I)c0).M;
                    if(j1 != null && !j1.e) {
                        c1 = j1;
                    }
                }
                else {
                    c1 = c0;
                }
                if(c0.Q() == null) {
                    x0 = null;
                }
                else {
                    Me.u u2 = c1 instanceof Me.u ? ((Me.u)c1) : null;
                    Pe.S s0 = u2 == null ? null : ((Pe.S)u2.X(bf.f.b0));
                    x0 = this.b(((bf.a)c0), s0, false, (s0 == null ? u1 : f.n(u1, s0.getAnnotations())), Ze.a.c, null, false, hf.n.b);
                }
                bf.f f0 = c0 instanceof bf.f ? ((bf.f)c0) : null;
                if(f0 == null) {
                    m0 = null;
                }
                else {
                    Me.k k0 = f0.e();
                    kotlin.jvm.internal.q.e(k0, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    String s1 = d3.g.g0(((Me.e)k0), d5.n.q(f0, 3));
                    if(s1 == null) {
                        m0 = null;
                    }
                    else {
                        m0 = (hf.m)hf.l.d.get(s1);
                        if(m0 == null) {
                            m0 = null;
                        }
                        else {
                            String s2 = m0.c;
                            if(s2 != null && !v.r0(s2, "2.", false)) {
                                throw new IllegalStateException("Check failed.");
                            }
                            if(s2 != null) {
                                m0 = m0.d;
                            }
                        }
                    }
                }
                if(m0 != null) {
                    m0.b.size();
                    ((bf.f)c0).F().size();
                }
                J0.h h2 = ((cf.a)u0.a).v;
                kotlin.jvm.internal.q.g(h2, "javaTypeEnhancementState");
                if(((q0)h2.d).invoke(Ze.q.a) != z.d) {
                    ((cf.a)u1.a).t.getClass();
                }
                else if(c0 instanceof Me.u && kotlin.jvm.internal.q.b(c0.X(bf.f.c0), Boolean.TRUE)) {
                    z = true;
                    goto label_71;
                }
                z = false;
            label_71:
                List list1 = c1.F();
                kotlin.jvm.internal.q.f(list1, "getValueParameters(...)");
                ArrayList arrayList3 = new ArrayList(je.q.Q(10, list1));
                for(Object object2: list1) {
                    Pe.S s3 = (Pe.S)object2;
                    q q0 = m0 == null ? null : ((q)p.n0(s3.f, m0.b));
                    q0 q00 = new q0(s3, 26);
                    arrayList3.add(this.b(((bf.a)c0), s3, false, (s3 == null ? u1 : f.n(u1, s3.getAnnotations())), Ze.a.c, q0, z, q00));
                }
                L l0 = c0 instanceof L ? ((L)c0) : null;
                x x1 = this.b(c0, c1, true, u1, (l0 == null || !df.d.B(l0) ? Ze.a.b : Ze.a.d), (m0 == null ? null : m0.a), false, hf.n.c);
                x x2 = c0.getReturnType();
                kotlin.jvm.internal.q.d(x2);
                if(Y.c(x2, n0, null)) {
                    g0 = new Ze.g();  // 初始化器: Ljava/lang/Object;-><init>()V
                    m1 = new ie.m(wf.b.a, g0);
                }
                else {
                    Pe.u u3 = c0.Q();
                    if((u3 == null ? false : Y.c(u3.getType(), n0, null))) {
                        g0 = new Ze.g();  // 初始化器: Ljava/lang/Object;-><init>()V
                        m1 = new ie.m(wf.b.a, g0);
                    }
                    else {
                        m1 = null;
                        List list2 = c0.F();
                        kotlin.jvm.internal.q.f(list2, "getValueParameters(...)");
                        Iterable iterable0 = list2;
                        if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                            for(Object object3: iterable0) {
                                x x3 = ((Pe.S)object3).getType();
                                kotlin.jvm.internal.q.f(x3, "getType(...)");
                                if(Y.c(x3, n0, null)) {
                                    g0 = new Ze.g();  // 初始化器: Ljava/lang/Object;-><init>()V
                                    m1 = new ie.m(wf.b.a, g0);
                                    break;
                                }
                            }
                        }
                    }
                }
                boolean z1 = false;
                if(x0 != null || x1 != null) {
                label_117:
                    if(x0 == null) {
                        Pe.u u4 = c0.Q();
                        x0 = u4 == null ? null : u4.getType();
                    }
                    ArrayList arrayList4 = new ArrayList(je.q.Q(10, arrayList3));
                    int v = 0;
                    for(Object object5: arrayList3) {
                        if(v >= 0) {
                            x x4 = (x)object5;
                            if(x4 == null) {
                                x4 = ((Pe.S)c0.F().get(v)).getType();
                                kotlin.jvm.internal.q.f(x4, "getType(...)");
                            }
                            arrayList4.add(x4);
                            ++v;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                    if(x1 == null) {
                        x1 = c0.getReturnType();
                        kotlin.jvm.internal.q.d(x1);
                    }
                    c0 = ((bf.a)c0).x0(x0, arrayList4, x1, m1);
                }
                else {
                    if(!arrayList3.isEmpty()) {
                        for(Object object4: arrayList3) {
                            if(((x)object4) != null) {
                                z1 = true;
                                break;
                            }
                        }
                    }
                    if(z1 || m1 != null) {
                        goto label_117;
                    }
                }
            }
            arrayList0.add(c0);
        }
        return arrayList0;
    }
}

