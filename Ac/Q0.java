package Ac;

import B1.g;
import Df.i;
import Ff.r;
import Gf.j;
import Hf.B;
import Hf.M;
import Hf.P;
import Hf.V;
import Hf.Y;
import Hf.a0;
import Hf.x;
import Le.o;
import Me.E;
import Me.N;
import Me.O;
import Me.S;
import Me.e;
import Me.h;
import Me.l;
import Me.w;
import Pe.A;
import Pe.L;
import Pe.z;
import Se.C;
import Se.n;
import U4.F;
import W.p;
import Ze.s;
import Ze.y;
import android.animation.ObjectAnimator;
import androidx.compose.runtime.b1;
import com.google.firebase.messaging.u;
import com.iloen.melon.playback.Playable;
import d5.t;
import e1.m;
import ef.a;
import ef.f;
import ie.H;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import je.D;
import je.I;
import kotlin.jvm.internal.q;
import lf.Z;
import lf.g0;
import qf.b;
import qf.c;
import we.k;
import x1.d;

public final class q0 implements k {
    public final int a;
    public Object b;

    public q0() {
        this.a = 7;
        super();
    }

    public q0(e e0, f f0, B b0, a a0) {
        this.a = 24;
        super();
        this.b = e0;
    }

    public q0(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        Object object7;
        P p0;
        H h0 = H.a;
        x x0 = null;
        switch(this.a) {
            case 0: {
                ((u0)this.b).sendUserEvent(new A0(((Number)object0).intValue()));
                return h0;
            }
            case 1: {
                q.g(((d)object0), "$this$constrainAs");
                g g0 = ((d)object0).b;
                E9.g.v(((d)object0).e, ((d)object0).c.e, 0.0f, 6);
                E9.g.v(((d)object0).g, ((d)object0).c.g, 0.0f, 6);
                p.l(((d)object0).d, ((d)object0).c.d, 0.0f, 6);
                p.l(((d)object0).f, ((d)object0).c.f, 0.0f, 6);
                float f = ((Number)((b1)this.b).getValue()).floatValue();
                if(!Float.isNaN(f)) {
                    g0.getClass();
                    g0.A("hBias", new B1.e(f));
                }
                g0.getClass();
                g0.A("vBias", new B1.e(0.5f));
                return h0;
            }
            case 2: {
                Le.q q0 = (Le.q)this.b;
                q.g(((c)object0), "fqName");
                Ef.c c0 = q0.c(((c)object0));
                if(c0 != null) {
                    i i0 = q0.c;
                    if(i0 != null) {
                        c0.u1(i0);
                        return c0;
                    }
                    q.m("components");
                    throw null;
                }
                return null;
            }
            case 3: {
                Df.g g1 = (Df.g)this.b;
                q.g(((Df.f)object0), "key");
                b b0 = ((Df.f)object0).a;
                i i1 = g1.a;
                for(Object object1: i1.k) {
                    e e0 = ((Oe.c)object1).a(b0);
                    if(e0 != null) {
                        return e0;
                    }
                    if(false) {
                        break;
                    }
                }
                if(!Df.g.c.contains(b0)) {
                    Df.d d0 = ((Df.f)object0).b;
                    if(d0 == null) {
                        d0 = i1.d.f(b0);
                        if(d0 != null) {
                            goto label_49;
                        }
                    }
                    else {
                    label_49:
                        nf.f f1 = d0.a;
                        lf.k k0 = d0.b;
                        nf.a a0 = d0.c;
                        N n0 = d0.d;
                        b b1 = b0.e();
                        if(b1 == null) {
                            for(Object object2: w.i(i1.f, b0.a)) {
                                if(!(((E)object2) instanceof Ef.c)) {
                                    goto label_70;
                                }
                                qf.e e3 = b0.f();
                                ((Ef.c)(((E)object2))).getClass();
                                if(!((r)((Ef.c)(((E)object2))).E()).m().contains(e3)) {
                                    continue;
                                }
                                goto label_70;
                            }
                            object2 = null;
                        label_70:
                            if(((E)object2) != null) {
                                Z z0 = k0.b0;
                                q.f(z0, "getTypeTable(...)");
                                z z1 = new z(z0);
                                g0 g00 = k0.d0;
                                q.f(g00, "getVersionRequirementTable(...)");
                                return new Ff.k(i1.a(((E)object2), f1, z1, e2.a.w(g00), a0, null), k0, f1, a0, n0);
                            }
                        }
                        else {
                            e e1 = g1.a(b1, null);
                            Ff.k k1 = e1 instanceof Ff.k ? ((Ff.k)e1) : null;
                            if(k1 != null) {
                                qf.e e2 = b0.f();
                                if(k1.r().m().contains(e2)) {
                                    return new Ff.k(k1.l, k0, f1, a0, n0);
                                }
                            }
                        }
                    }
                }
                return null;
            }
            case 4: {
                Hf.f f2 = (Hf.f)this.b;
                q.g(((Hf.e)object0), "supertypes");
                O o0 = f2.h();
                Collection collection0 = ((Hf.e)object0).a;
                o0.getClass();
                q.g(collection0, "superTypes");
                if(collection0.isEmpty()) {
                    x x1 = f2.c();
                    List list0 = x1 == null ? null : e.k.z(x1);
                    if(list0 == null) {
                        list0 = je.w.a;
                    }
                    collection0 = list0;
                }
                if(collection0 instanceof List) {
                    x0 = (List)collection0;
                }
                if(x0 == null) {
                    x0 = je.p.P0(collection0);
                }
                List list1 = f2.k(((List)x0));
                q.g(list1, "<set-?>");
                ((Hf.e)object0).b = list1;
                return h0;
            }
            case 5: {
                Hf.w w0 = (Hf.w)this.b;
                q.g(((If.f)object0), "kotlinTypeRefiner");
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, w0.b));
                boolean z2 = false;
                for(Object object3: w0.b) {
                    arrayList0.add(((x)object3).H(((If.f)object0)));
                    z2 = true;
                }
                if(z2) {
                    x x2 = w0.a;
                    if(x2 != null) {
                        x0 = x2.H(((If.f)object0));
                    }
                    LinkedHashSet linkedHashSet0 = new LinkedHashSet(arrayList0);
                    linkedHashSet0.hashCode();
                    Hf.w w1 = new Hf.w(linkedHashSet0);
                    w1.a = x0;
                    x0 = w1;
                }
                if(x0 != null) {
                    w0 = x0;
                }
                return w0.b();
            }
            case 6: {
                ea.c c1 = (ea.c)this.b;
                S s0 = ((Hf.O)object0).a;
                a a1 = ((Hf.O)object0).b;
                Set set0 = a1.f;
                if(set0 != null && set0.contains(s0.a())) {
                    return c1.f(a1);
                }
                B b2 = s0.g();
                q.f(b2, "getDefaultType(...)");
                LinkedHashSet linkedHashSet1 = new LinkedHashSet();
                F.s(b2, b2, linkedHashSet1, set0);
                int v = D.N(je.q.Q(10, linkedHashSet1));
                if(v < 16) {
                    v = 16;
                }
                LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
                for(Object object4: linkedHashSet1) {
                    S s1 = (S)object4;
                    if(set0 == null || !set0.contains(s1)) {
                        Set set1 = a1.f;
                        Set set2 = set1 == null ? m.E(s0) : I.L(set1, s0);
                        p0 = ef.e.a(s1, a1, c1, c1.h(s1, a.a(a1, null, false, set2, null, 0x2F)));
                    }
                    else {
                        p0 = Y.k(s1, a1);
                    }
                    linkedHashMap0.put(s1.q(), p0);
                }
                V v1 = new V(new Hf.H(linkedHashMap0, 1));
                List list2 = s0.getUpperBounds();
                q.f(list2, "getUpperBounds(...)");
                ke.i i2 = c1.k(v1, list2, a1);
                if(!i2.a.isEmpty()) {
                    if(i2.size() != 1) {
                        throw new IllegalArgumentException("Should only be one computed upper bound if no need to intersect all bounds");
                    }
                    return (x)je.p.D0(i2);
                }
                return c1.f(a1);
            }
            case 7: {
                boolean z3 = ((Boolean)object0).booleanValue();
                J0.B b3 = (J0.B)this.b;
                if(b3 != null) {
                    b3.c = z3;
                }
                return h0;
            }
            case 8: {
                o o1 = (o)this.b;
                q.g(((ie.m)object0), "<destruct>");
                List list3 = e.k.z(Ne.e.a(o1.a.d, k8.Y.k("\'", ((String)((ie.m)object0).a), "()\' member of List is redundant in Kotlin and might be removed soon. Please use \'", ((String)((ie.m)object0).b), "()\' stdlib extension instead"), ((String)((ie.m)object0).b) + "()", "HIDDEN"));
                return list3.isEmpty() ? Ne.g.a : new Ne.i(list3, 0);
            }
            case 9: {
                Throwable throwable0 = (Throwable)object0;
                ((ObjectAnimator)this.b).cancel();
                return h0;
            }
            case 10: {
                Pe.a a2 = (Pe.a)this.b;
                ((If.f)object0).getClass();
                return (B)a2.b.b.invoke();
            }
            case 11: {
                Pe.f f3 = (Pe.f)this.b;
                q.d(((a0)object0));
                if(!Hf.c.k(((a0)object0))) {
                    h h2 = ((a0)object0).w().e();
                    return !(h2 instanceof S) || q.b(((S)h2).e(), f3) ? false : true;
                }
                return false;
            }
            case 12: {
                A a3 = (A)this.b;
                q.g(((c)object0), "fqName");
                ((Pe.E)a3.f).getClass();
                q.g(a3.c, "storageManager");
                return new Pe.w(a3, ((c)object0), a3.c);
            }
            case 13: {
                ((Qc.f)this.b).sendUserEvent(new Qc.p(((Number)object0).intValue()));
                return h0;
            }
            case 14: {
                n n1 = (n)this.b;
                if(!((Method)object0).isSynthetic()) {
                    if(n1.a.isEnum()) {
                        String s2 = ((Method)object0).getName();
                        if(q.b(s2, "values")) {
                            Class[] arr_class = ((Method)object0).getParameterTypes();
                            q.f(arr_class, "getParameterTypes(...)");
                            return arr_class.length == 0 ? false : true;
                        }
                        if(q.b(s2, "valueOf")) {
                            return Arrays.equals(((Method)object0).getParameterTypes(), new Class[]{String.class}) ? false : true;
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            }
            case 15: {
                L l0 = (L)this.b;
                q.g(((Me.c)object0), "it");
                String s3 = d5.n.r(l0);
                return Boolean.valueOf(Ze.E.i.containsKey(s3));
            }
            case 16: {
                ie.i i3 = (ie.i)this.b;
                q.g(((c)object0), "it");
                y.A.getClass();
                q.g(Ze.x.b, "configuredReportLevels");
                Ze.z z4 = (Ze.z)((j)Ze.x.b.a).invoke(((c)object0));
                if(z4 == null) {
                    Ze.q.c.getClass();
                    Ze.r r0 = (Ze.r)((j)Ze.q.c.a).invoke(((c)object0));
                    if(r0 == null) {
                        return Ze.z.b;
                    }
                    return r0.b == null || r0.b.c - i3.c > 0 ? r0.a : r0.c;
                }
                return z4;
            }
            case 17: {
                p p1 = (p)this.b;
                q.d(((c)object0));
                Object object5 = p1.b;
                LinkedHashMap linkedHashMap1 = new LinkedHashMap();
                for(Object object6: ((Map)object5).entrySet()) {
                    Map.Entry map$Entry0 = (Map.Entry)object6;
                    c c2 = (c)map$Entry0.getKey();
                    if(((c)object0).equals(c2)) {
                        linkedHashMap1.put(map$Entry0.getKey(), map$Entry0.getValue());
                    }
                    else {
                        q.g(c2, "packageName");
                        if(q.b((((c)object0).a.c() ? null : ((c)object0).b()), c2)) {
                            linkedHashMap1.put(map$Entry0.getKey(), map$Entry0.getValue());
                        }
                    }
                }
                if(linkedHashMap1.isEmpty()) {
                    linkedHashMap1 = null;
                }
                if(linkedHashMap1 != null) {
                    Iterator iterator5 = linkedHashMap1.entrySet().iterator();
                    if(iterator5.hasNext()) {
                        object7 = iterator5.next();
                        if(iterator5.hasNext()) {
                            int v2 = t.r(((c)((Map.Entry)object7).getKey()), ((c)object0)).a.a.length();
                            while(true) {
                                Object object8 = iterator5.next();
                                int v3 = t.r(((c)((Map.Entry)object8).getKey()), ((c)object0)).a.a.length();
                                if(v2 > v3) {
                                    object7 = object8;
                                    v2 = v3;
                                }
                                if(!iterator5.hasNext()) {
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        object7 = null;
                    }
                    if(((Map.Entry)object7) != null) {
                        return ((Map.Entry)object7).getValue();
                    }
                }
                return null;
            }
            case 18: {
                if(((Me.c)object0) == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter \'descriptor\' of kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1.invoke must not be null");
                }
                ((af.a)this.b).c.c(((Me.c)object0));
                return h0;
            }
            case 19: {
                cf.c c3 = (cf.c)this.b;
                q.g(((Se.d)object0), "annotation");
                return af.c.b(((Se.d)object0), c3.a, c3.c);
            }
            case 20: {
                A1.k k2 = (A1.k)this.b;
                q.g(((Se.B)object0), "typeParameter");
                LinkedHashMap linkedHashMap2 = (LinkedHashMap)k2.e;
                l l1 = (l)k2.d;
                Integer integer0 = (Integer)linkedHashMap2.get(((Se.B)object0));
                if(integer0 != null) {
                    u u0 = (u)k2.c;
                    q.g(u0, "<this>");
                    return new df.H(d5.f.n(new u(((cf.a)u0.a), k2, ((ie.j)u0.c)), l1.getAnnotations()), ((Se.B)object0), k2.b + integer0.intValue(), l1);
                }
                return null;
            }
            case 21: {
                df.a a4 = (df.a)this.b;
                q.g(((Se.w)object0), "m");
                if(((Boolean)a4.b.invoke(((Se.w)object0))).booleanValue()) {
                    Class class0 = ((Method)((Se.w)object0).b()).getDeclaringClass();
                    q.f(class0, "getDeclaringClass(...)");
                    if(class0.isInterface()) {
                        switch(((Se.w)object0).c().b()) {
                            case "equals": {
                                C c4 = (C)je.p.G0(((Se.w)object0).g());
                                Se.A a5 = c4 == null ? null : c4.a;
                                if(a5 instanceof Se.p) {
                                    x0 = (Se.p)a5;
                                }
                                if(x0 != null) {
                                    Se.r r1 = x0.b;
                                    if(r1 instanceof n) {
                                        c c5 = ((n)r1).c();
                                        return c5 == null || !q.b(c5.a.a, "java.lang.Object");
                                    }
                                }
                                return true;
                            }
                            case "hashCode": 
                            case "toString": {
                                return ((ArrayList)((Se.w)object0).g()).isEmpty() ? false : true;
                            }
                            default: {
                                return true;
                            }
                        }
                    }
                    return true;
                }
                return false;
            }
            case 22: {
                df.j j0 = (df.j)this.b;
                q.g(((If.f)object0), "it");
                return j0.i == null ? new df.o(j0.j, j0, j0.h, false, j0.w) : new df.o(j0.j, j0, j0.h, true, j0.w);
            }
            case 23: {
                qf.e e4 = (qf.e)this.b;
                q.g(((Af.p)object0), "it");
                return ((Af.p)object0).b(e4, Ue.c.e);
            }
            case 24: {
                e e5 = (e)this.b;
                q.g(((If.f)object0), "kotlinTypeRefiner");
                xf.d.f(e5);
                return null;
            }
            case 25: {
                H4.c c6 = (H4.c)this.b;
                q.g(((hf.a)object0), "it");
                s s4 = ((hf.a)object0).b;
                Kf.d d1 = ((hf.a)object0).a;
                if(c6.b && d1 != null) {
                    q.g(d1, "$receiver");
                    if(!(d1 instanceof x)) {
                        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
                        stringBuilder0.append(d1);
                        stringBuilder0.append(", ");
                        Class class1 = d1.getClass();
                        throw new IllegalArgumentException(H0.b.l(kotlin.jvm.internal.I.a, class1, stringBuilder0).toString());
                    }
                    else if(d1 instanceof ef.h) {
                        return null;
                    }
                }
                if(d1 != null) {
                    If.m m0 = If.m.a;
                    M m1 = m0.F(d1);
                    if(m1 != null) {
                        if(m1 instanceof M) {
                            List list4 = m1.getParameters();
                            q.f(list4, "getParameters(...)");
                            q.g(d1, "$receiver");
                            if(d1 instanceof x) {
                                Iterable iterable0 = ((x)d1).r();
                                Iterator iterator6 = list4.iterator();
                                Iterator iterator7 = iterable0.iterator();
                                ArrayList arrayList1 = new ArrayList(Math.min(je.q.Q(10, list4), je.q.Q(10, iterable0)));
                                while(iterator6.hasNext() && iterator7.hasNext()) {
                                    Object object9 = iterator6.next();
                                    Object object10 = iterator7.next();
                                    S s5 = (S)object9;
                                    a0 a00 = If.g.r(m0, ((P)object10));
                                    arrayList1.add((a00 == null ? new hf.a(null, s4, s5) : new hf.a(a00, ((cf.a)((u)c6.d).a).q.b(s4, a00.getAnnotations()), s5)));
                                }
                                return arrayList1;
                            }
                            StringBuilder stringBuilder1 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
                            stringBuilder1.append(d1);
                            stringBuilder1.append(", ");
                            Class class2 = d1.getClass();
                            throw new IllegalArgumentException(H0.b.l(kotlin.jvm.internal.I.a, class2, stringBuilder1).toString());
                        }
                        StringBuilder stringBuilder2 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
                        stringBuilder2.append(m1);
                        stringBuilder2.append(", ");
                        Class class3 = m1.getClass();
                        throw new IllegalArgumentException(H0.b.l(kotlin.jvm.internal.I.a, class3, stringBuilder2).toString());
                    }
                }
                return null;
            }
            case 26: {
                Pe.S s6 = (Pe.S)this.b;
                q.g(((Me.c)object0), "it");
                x x3 = ((Pe.S)((Me.c)object0).F().get(s6.f)).getType();
                q.f(x3, "getType(...)");
                return x3;
            }
            case 27: {
                E9.u u1 = (E9.u)this.b;
                q.g(((Re.c)object0), "kotlinClass");
                HashMap hashMap0 = new HashMap();
                HashMap hashMap1 = new HashMap();
                HashMap hashMap2 = new HashMap();
                p p2 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
                p2.a = u1;
                p2.b = hashMap0;
                Class class4 = ((Re.c)object0).a;
                q.g(class4, "klass");
                c2.Y y0 = q.j(class4.getDeclaredMethods());
                while(y0.hasNext()) {
                    Method method0 = (Method)y0.next();
                    qf.e e6 = qf.e.e(method0.getName());
                    StringBuilder stringBuilder3 = new StringBuilder("(");
                    c2.Y y1 = q.j(method0.getParameterTypes());
                    while(y1.hasNext()) {
                        Class class5 = (Class)y1.next();
                        q.d(class5);
                        stringBuilder3.append(Se.c.b(class5));
                    }
                    stringBuilder3.append(")");
                    Class class6 = method0.getReturnType();
                    q.f(class6, "getReturnType(...)");
                    stringBuilder3.append(Se.c.b(class6));
                    String s7 = stringBuilder3.toString();
                    q.f(s7, "toString(...)");
                    u u2 = p2.n(e6, s7);
                    c2.Y y2 = q.j(method0.getDeclaredAnnotations());
                    while(y2.hasNext()) {
                        Annotation annotation0 = (Annotation)y2.next();
                        q.d(annotation0);
                        F.Q(u2, annotation0);
                    }
                    Annotation[][] arr2_annotation = method0.getParameterAnnotations();
                    q.f(arr2_annotation, "getParameterAnnotations(...)");
                    Annotation[][] arr2_annotation1 = arr2_annotation;
                    for(int v4 = 0; v4 < arr2_annotation1.length; ++v4) {
                        c2.Y y3 = q.j(arr2_annotation1[v4]);
                        while(y3.hasNext()) {
                            Annotation annotation1 = (Annotation)y3.next();
                            Class class7 = df.d.v(df.d.s(annotation1));
                            H8.q q1 = u2.z(v4, Se.c.a(class7), new Re.a(annotation1));
                            if(q1 != null) {
                                F.R(q1, annotation1, class7);
                            }
                        }
                    }
                    u2.y();
                }
                c2.Y y4 = q.j(class4.getDeclaredConstructors());
                while(y4.hasNext()) {
                    Constructor constructor0 = (Constructor)y4.next();
                    qf.e e7 = qf.g.e;
                    q.d(constructor0);
                    StringBuilder stringBuilder4 = new StringBuilder("(");
                    c2.Y y5 = q.j(constructor0.getParameterTypes());
                    while(y5.hasNext()) {
                        Class class8 = (Class)y5.next();
                        q.d(class8);
                        stringBuilder4.append(Se.c.b(class8));
                    }
                    stringBuilder4.append(")V");
                    String s8 = stringBuilder4.toString();
                    q.f(s8, "toString(...)");
                    u u3 = p2.n(e7, s8);
                    c2.Y y6 = q.j(constructor0.getDeclaredAnnotations());
                    while(y6.hasNext()) {
                        Annotation annotation2 = (Annotation)y6.next();
                        q.d(annotation2);
                        F.Q(u3, annotation2);
                    }
                    Annotation[][] arr2_annotation2 = constructor0.getParameterAnnotations();
                    q.d(arr2_annotation2);
                    if(arr2_annotation2.length != 0) {
                        int v5 = constructor0.getParameterTypes().length - arr2_annotation2.length;
                        int v6 = arr2_annotation2.length;
                        for(int v7 = 0; v7 < v6; ++v7) {
                            c2.Y y7 = q.j(arr2_annotation2[v7]);
                            while(y7.hasNext()) {
                                Annotation annotation3 = (Annotation)y7.next();
                                Class class9 = df.d.v(df.d.s(annotation3));
                                H8.q q2 = u3.z(v7 + v5, Se.c.a(class9), new Re.a(annotation3));
                                if(q2 != null) {
                                    F.R(q2, annotation3, class9);
                                }
                            }
                        }
                    }
                    u3.y();
                }
                c2.Y y8 = q.j(class4.getDeclaredFields());
                while(y8.hasNext()) {
                    Field field0 = (Field)y8.next();
                    qf.e e8 = qf.e.e(field0.getName());
                    Class class10 = field0.getType();
                    q.f(class10, "getType(...)");
                    String s9 = Se.c.b(class10);
                    q.g(s9, "desc");
                    String s10 = e8.b();
                    q.f(s10, "asString(...)");
                    jf.p p3 = new jf.p(s10 + '#' + s9);
                    ArrayList arrayList2 = new ArrayList();
                    c2.Y y9 = q.j(field0.getDeclaredAnnotations());
                    while(y9.hasNext()) {
                        Annotation annotation4 = (Annotation)y9.next();
                        q.d(annotation4);
                        Class class11 = df.d.v(df.d.s(annotation4));
                        b b4 = Se.c.a(class11);
                        Re.a a6 = new Re.a(annotation4);
                        H8.q q3 = ((E9.u)p2.a).C(b4, a6, arrayList2);
                        if(q3 != null) {
                            F.R(q3, annotation4, class11);
                        }
                    }
                    if(!arrayList2.isEmpty()) {
                        ((HashMap)p2.b).put(p3, arrayList2);
                    }
                }
                return new jf.c(hashMap0, hashMap1, hashMap2);
            }
            case 28: {
                q.g(((Playable)object0), "it");
                return Boolean.valueOf(((HashSet)this.b).contains(""));
            }
            default: {
                Qf.h h1 = (Qf.h)this.b;
                q.d(object0);
                h1.add(object0);
                return h0;
            }
        }
    }
}

