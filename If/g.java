package If;

import B3.q;
import H0.b;
import Hf.B;
import Hf.E;
import Hf.G;
import Hf.L;
import Hf.M;
import Hf.N;
import Hf.P;
import Hf.V;
import Hf.Y;
import Hf.a0;
import Hf.b0;
import Hf.c;
import Hf.l;
import Hf.w;
import Hf.x;
import Je.i;
import Je.o;
import Kf.d;
import Kf.f;
import Kf.h;
import Me.S;
import Me.T;
import Me.e;
import Me.k;
import Me.v;
import Me.y;
import U4.F;
import ie.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.I;
import vf.p;

public abstract class g {
    public static final q a;

    static {
        g.a = new q("KotlinTypeRefiner", 2);
    }

    public static boolean A(h h0) {
        kotlin.jvm.internal.q.g(h0, "$receiver");
        if(h0 instanceof M) {
            return ((M)h0).g();
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(h0);
        stringBuilder0.append(", ");
        Class class0 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean B(d d0) {
        kotlin.jvm.internal.q.g(d0, "$receiver");
        if(d0 instanceof x) {
            return c.k(((x)d0));
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(d0);
        stringBuilder0.append(", ");
        Class class0 = d0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean C(h h0) {
        kotlin.jvm.internal.q.g(h0, "$receiver");
        if(h0 instanceof M) {
            Me.h h1 = ((M)h0).e();
            T t0 = null;
            e e0 = h1 instanceof e ? ((e)h1) : null;
            if(e0 != null) {
                t0 = e0.a0();
            }
            return t0 instanceof v;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(h0);
        stringBuilder0.append(", ");
        Class class0 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean D(h h0) {
        kotlin.jvm.internal.q.g(h0, "$receiver");
        if(h0 instanceof M) {
            return h0 instanceof p;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(h0);
        stringBuilder0.append(", ");
        Class class0 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean E(h h0) {
        kotlin.jvm.internal.q.g(h0, "$receiver");
        if(h0 instanceof M) {
            return h0 instanceof w;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(h0);
        stringBuilder0.append(", ");
        Class class0 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean F(d d0) {
        kotlin.jvm.internal.q.g(d0, "$receiver");
        return d0 instanceof B && ((B)d0).D();
    }

    public static boolean G(h h0) {
        kotlin.jvm.internal.q.g(h0, "$receiver");
        if(h0 instanceof M) {
            return i.I(((M)h0), o.b);
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(h0);
        stringBuilder0.append(", ");
        Class class0 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean H(d d0) {
        kotlin.jvm.internal.q.g(d0, "$receiver");
        if(d0 instanceof x) {
            return Y.e(((x)d0));
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(d0);
        stringBuilder0.append(", ");
        Class class0 = d0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean I(f f0) {
        kotlin.jvm.internal.q.g(f0, "$receiver");
        if(f0 instanceof x) {
            return i.G(((x)f0));
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(f0);
        stringBuilder0.append(", ");
        Class class0 = f0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean J(Kf.c c0) {
        if(c0 instanceof If.h) {
            return ((If.h)c0).g;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(c0);
        stringBuilder0.append(", ");
        Class class0 = c0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean K(P p0) {
        kotlin.jvm.internal.q.g(p0, "$receiver");
        if(p0 instanceof P) {
            return p0.c();
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(p0);
        stringBuilder0.append(", ");
        Class class0 = p0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static void L(Kf.e e0) {
        kotlin.jvm.internal.q.g(e0, "$receiver");
        if(e0 instanceof B) {
            x x0 = (x)e0;
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(e0);
        stringBuilder0.append(", ");
        Class class0 = e0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static void M(Kf.e e0) {
        kotlin.jvm.internal.q.g(e0, "$receiver");
        if(e0 instanceof B) {
            x x0 = (x)e0;
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(e0);
        stringBuilder0.append(", ");
        Class class0 = e0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static B N(Hf.p p0) {
        if(p0 instanceof Hf.p) {
            return p0.b;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(p0);
        stringBuilder0.append(", ");
        Class class0 = p0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static a0 O(Kf.c c0) {
        if(c0 instanceof If.h) {
            return ((If.h)c0).d;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(c0);
        stringBuilder0.append(", ");
        Class class0 = c0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static a0 P(d d0) {
        if(d0 instanceof a0) {
            return c.n(((a0)d0), false);
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(d0);
        stringBuilder0.append(", ");
        Class class0 = d0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static int Q(h h0) {
        kotlin.jvm.internal.q.g(h0, "$receiver");
        if(h0 instanceof M) {
            return ((M)h0).getParameters().size();
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(h0);
        stringBuilder0.append(", ");
        Class class0 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static Collection R(If.b b0, Kf.e e0) {
        M m0 = b0.k(e0);
        if(m0 instanceof p) {
            return ((p)m0).a;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(e0);
        stringBuilder0.append(", ");
        Class class0 = e0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static P S(uf.b b0) {
        kotlin.jvm.internal.q.g(b0, "$receiver");
        if(b0 instanceof If.i) {
            return ((If.i)b0).a;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(b0);
        stringBuilder0.append(", ");
        Class class0 = b0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static a T(If.b b0, Kf.e e0) {
        if(e0 instanceof B) {
            M m0 = ((x)e0).w();
            List list0 = ((x)e0).r();
            return new a(b0, new V(N.b.g(m0, list0)));
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(e0);
        stringBuilder0.append(", ");
        Class class0 = e0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static Collection U(h h0) {
        kotlin.jvm.internal.q.g(h0, "$receiver");
        if(h0 instanceof M) {
            Collection collection0 = ((M)h0).f();
            kotlin.jvm.internal.q.f(collection0, "getSupertypes(...)");
            return collection0;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(h0);
        stringBuilder0.append(", ");
        Class class0 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static M V(Kf.e e0) {
        kotlin.jvm.internal.q.g(e0, "$receiver");
        if(e0 instanceof B) {
            return ((B)e0).w();
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(e0);
        stringBuilder0.append(", ");
        Class class0 = e0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static If.i W(Kf.c c0) {
        kotlin.jvm.internal.q.g(c0, "$receiver");
        if(c0 instanceof If.h) {
            return ((If.h)c0).c;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(c0);
        stringBuilder0.append(", ");
        Class class0 = c0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static B X(Hf.p p0) {
        if(p0 instanceof Hf.p) {
            return p0.c;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(p0);
        stringBuilder0.append(", ");
        Class class0 = p0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static B Y(Kf.e e0, boolean z) {
        kotlin.jvm.internal.q.g(e0, "$receiver");
        if(e0 instanceof B) {
            return ((B)e0).V(z);
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(e0);
        stringBuilder0.append(", ");
        Class class0 = e0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static d Z(If.b b0, d d0) {
        if(d0 instanceof Kf.e) {
            return b0.v(((Kf.e)d0));
        }
        if(!(d0 instanceof Hf.p)) {
            throw new IllegalStateException("sealed");
        }
        return b0.u(b0.v(b0.V(((Hf.p)d0))), b0.v(b0.o(((Hf.p)d0))));
    }

    public static void a(int v) {
        Object[] arr_object = new Object[3];
        switch(v) {
            case 1: 
            case 4: {
                arr_object[0] = "b";
                break;
            }
            case 2: 
            case 7: {
                arr_object[0] = "typeCheckingProcedure";
                break;
            }
            case 8: {
                arr_object[0] = "type";
                break;
            }
            case 9: {
                arr_object[0] = "typeProjection";
                break;
            }
            case 5: 
            case 10: {
                arr_object[0] = "subtype";
                break;
            }
            case 6: 
            case 11: {
                arr_object[0] = "supertype";
                break;
            }
            default: {
                arr_object[0] = "a";
            }
        }
        arr_object[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch(v) {
            case 3: 
            case 4: {
                arr_object[2] = "assertEqualTypeConstructors";
                break;
            }
            case 5: 
            case 6: 
            case 7: {
                arr_object[2] = "assertSubtype";
                break;
            }
            case 8: 
            case 9: {
                arr_object[2] = "capture";
                break;
            }
            case 10: 
            case 11: {
                arr_object[2] = "noCorrespondingSupertype";
                break;
            }
            default: {
                arr_object[2] = "assertEqualTypes";
            }
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", arr_object));
    }

    public static boolean b(h h0, h h1) {
        kotlin.jvm.internal.q.g(h0, "c1");
        kotlin.jvm.internal.q.g(h1, "c2");
        if(h0 instanceof M) {
            if(h1 instanceof M) {
                return h0.equals(h1);
            }
            StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
            stringBuilder0.append(h1);
            stringBuilder0.append(", ");
            Class class0 = h1.getClass();
            throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
        }
        StringBuilder stringBuilder1 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder1.append(h0);
        stringBuilder1.append(", ");
        Class class1 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class1, stringBuilder1).toString());
    }

    public static int c(d d0) {
        kotlin.jvm.internal.q.g(d0, "$receiver");
        if(d0 instanceof x) {
            return ((x)d0).r().size();
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(d0);
        stringBuilder0.append(", ");
        Class class0 = d0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static Kf.g d(Kf.e e0) {
        kotlin.jvm.internal.q.g(e0, "$receiver");
        if(e0 instanceof B) {
            return (Kf.g)e0;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(e0);
        stringBuilder0.append(", ");
        Class class0 = e0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static Kf.c e(If.b b0, f f0) {
        kotlin.jvm.internal.q.g(f0, "$receiver");
        if(f0 instanceof B) {
            if(f0 instanceof E) {
                return b0.D(((E)f0).b);
            }
            return f0 instanceof If.h ? ((If.h)f0) : null;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(f0);
        stringBuilder0.append(", ");
        Class class0 = f0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static l f(Kf.e e0) {
        kotlin.jvm.internal.q.g(e0, "$receiver");
        if(e0 instanceof B) {
            return e0 instanceof l ? ((l)e0) : null;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(e0);
        stringBuilder0.append(", ");
        Class class0 = e0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static Hf.p g(d d0) {
        kotlin.jvm.internal.q.g(d0, "$receiver");
        if(d0 instanceof x) {
            a0 a00 = ((x)d0).I();
            return a00 instanceof Hf.p ? ((Hf.p)a00) : null;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(d0);
        stringBuilder0.append(", ");
        Class class0 = d0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static B h(d d0) {
        kotlin.jvm.internal.q.g(d0, "$receiver");
        if(d0 instanceof x) {
            a0 a00 = ((x)d0).I();
            return a00 instanceof B ? ((B)a00) : null;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(d0);
        stringBuilder0.append(", ");
        Class class0 = d0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static G i(d d0) {
        kotlin.jvm.internal.q.g(d0, "$receiver");
        if(d0 instanceof x) {
            return F.j(((x)d0));
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(d0);
        stringBuilder0.append(", ");
        Class class0 = d0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static B j(Kf.e e0) {
        If.e e1;
        Kf.b b0 = Kf.b.a;
        if(e0 instanceof B) {
            if(((B)e0).r().size() == ((B)e0).w().getParameters().size()) {
                List list0 = ((B)e0).r();
                if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                    for(Object object0: list0) {
                        if(((P)object0).a() != b0.c) {
                            List list1 = ((B)e0).w().getParameters();
                            kotlin.jvm.internal.q.f(list1, "getParameters(...)");
                            ArrayList arrayList0 = je.p.W0(list0, list1);
                            List list2 = new ArrayList(je.q.Q(10, arrayList0));
                            for(Object object1: arrayList0) {
                                P p0 = (P)((m)object1).a;
                                S s0 = (S)((m)object1).b;
                                if(p0.a() != b0.c) {
                                    a0 a00 = p0.c() || p0.a() != b0.d ? null : p0.b().I();
                                    kotlin.jvm.internal.q.d(s0);
                                    p0 = F.j(new If.h(b0, new If.i(p0, null, s0, 6), a00, null, false, 56));
                                }
                                ((ArrayList)list2).add(p0);
                            }
                            M m0 = ((B)e0).w();
                            V v0 = new V(N.b.g(m0, list2));
                            int v1 = list0.size();
                            for(int v2 = 0; v2 < v1; ++v2) {
                                P p1 = (P)list0.get(v2);
                                P p2 = (P)((ArrayList)list2).get(v2);
                                if(p1.a() != b0.c) {
                                    List list3 = ((S)((B)e0).w().getParameters().get(v2)).getUpperBounds();
                                    kotlin.jvm.internal.q.f(list3, "getUpperBounds(...)");
                                    ArrayList arrayList1 = new ArrayList();
                                    Iterator iterator2 = list3.iterator();
                                    while(true) {
                                        boolean z = iterator2.hasNext();
                                        e1 = If.e.a;
                                        if(!z) {
                                            break;
                                        }
                                        Object object2 = iterator2.next();
                                        arrayList1.add(e1.H(v0.g(((x)object2), b0.c).I()));
                                    }
                                    if(!p1.c() && p1.a() == b0.e) {
                                        arrayList1.add(e1.H(p1.b().I()));
                                    }
                                    x x0 = p2.b();
                                    kotlin.jvm.internal.q.e(x0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                                    ((If.h)x0).c.getClass();
                                    ((If.h)x0).c.b = new Ff.e(2, arrayList1);
                                }
                            }
                            return list2 == null ? null : c.u(((B)e0).t(), ((B)e0).w(), list2, ((B)e0).D());
                        }
                        if(false) {
                            break;
                        }
                    }
                }
            }
            return null;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(e0);
        stringBuilder0.append(", ");
        Class class0 = e0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static Kf.b k(Kf.c c0) {
        kotlin.jvm.internal.q.g(c0, "$receiver");
        if(c0 instanceof If.h) {
            return ((If.h)c0).b;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(c0);
        stringBuilder0.append(", ");
        Class class0 = c0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static L l(boolean z, If.m m0, If.e e0, int v) {
        if((v & 4) != 0) {
            m0 = If.m.a;
        }
        if((v & 8) != 0) {
            e0 = If.e.a;
        }
        return new L(z, true, m0, e0, If.f.a);
    }

    public static a0 m(If.b b0, Kf.e e0, Kf.e e1) {
        kotlin.jvm.internal.q.g(e0, "lowerBound");
        kotlin.jvm.internal.q.g(e1, "upperBound");
        if(e0 instanceof B) {
            if(e1 instanceof B) {
                return c.f(((B)e0), ((B)e1));
            }
            StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
            stringBuilder0.append(b0);
            stringBuilder0.append(", ");
            Class class0 = b0.getClass();
            throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
        }
        StringBuilder stringBuilder1 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder1.append(b0);
        stringBuilder1.append(", ");
        Class class1 = b0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class1, stringBuilder1).toString());
    }

    public static final String n(M m0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        g.o(stringBuilder0, "type: " + m0);
        g.o(stringBuilder0, "hashCode: " + m0.hashCode());
        g.o(stringBuilder0, "javaClass: " + m0.getClass().getCanonicalName());
        for(k k0 = m0.e(); k0 != null; k0 = k0.e()) {
            g.o(stringBuilder0, "fqName: " + sf.g.c.w(k0));
            g.o(stringBuilder0, "javaClass: " + k0.getClass().getCanonicalName());
        }
        return stringBuilder0.toString();
    }

    public static final void o(StringBuilder stringBuilder0, String s) {
        kotlin.jvm.internal.q.g(s, "<this>");
        stringBuilder0.append(s);
        stringBuilder0.append('\n');
    }

    public static P p(d d0, int v) {
        kotlin.jvm.internal.q.g(d0, "$receiver");
        if(d0 instanceof x) {
            return (P)((x)d0).r().get(v);
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(d0);
        stringBuilder0.append(", ");
        Class class0 = d0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static S q(h h0, int v) {
        kotlin.jvm.internal.q.g(h0, "$receiver");
        if(h0 instanceof M) {
            Object object0 = ((M)h0).getParameters().get(v);
            kotlin.jvm.internal.q.f(object0, "get(...)");
            return (S)object0;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(h0);
        stringBuilder0.append(", ");
        Class class0 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static a0 r(If.b b0, P p0) {
        kotlin.jvm.internal.q.g(p0, "$receiver");
        if(b0.j0(p0)) {
            return null;
        }
        if(p0 instanceof P) {
            return p0.b().I();
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(p0);
        stringBuilder0.append(", ");
        Class class0 = p0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static S s(h h0) {
        kotlin.jvm.internal.q.g(h0, "$receiver");
        if(h0 instanceof M) {
            Me.h h1 = ((M)h0).e();
            return h1 instanceof S ? ((S)h1) : null;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(h0);
        stringBuilder0.append(", ");
        Class class0 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static Kf.i t(P p0) {
        kotlin.jvm.internal.q.g(p0, "$receiver");
        if(p0 instanceof P) {
            b0 b00 = p0.a();
            kotlin.jvm.internal.q.f(b00, "getProjectionKind(...)");
            return d5.f.m(b00);
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(p0);
        stringBuilder0.append(", ");
        Class class0 = p0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean u(d d0, qf.c c0) {
        kotlin.jvm.internal.q.g(d0, "$receiver");
        kotlin.jvm.internal.q.g(c0, "fqName");
        if(d0 instanceof x) {
            return ((x)d0).getAnnotations().c(c0);
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(d0);
        stringBuilder0.append(", ");
        Class class0 = d0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean v(S s0, h h0) {
        if((h0 == null ? true : h0 instanceof M)) {
            return F.H(s0, ((M)h0), 4);
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(s0);
        stringBuilder0.append(", ");
        Class class0 = s0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean w(Kf.e e0, Kf.e e1) {
        kotlin.jvm.internal.q.g(e0, "a");
        kotlin.jvm.internal.q.g(e1, "b");
        if(e0 instanceof B) {
            if(e1 instanceof B) {
                return ((B)e0).r() == ((B)e1).r();
            }
            StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
            stringBuilder0.append(e1);
            stringBuilder0.append(", ");
            Class class0 = e1.getClass();
            throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
        }
        StringBuilder stringBuilder1 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder1.append(e0);
        stringBuilder1.append(", ");
        Class class1 = e0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class1, stringBuilder1).toString());
    }

    public static boolean x(h h0) {
        kotlin.jvm.internal.q.g(h0, "$receiver");
        if(h0 instanceof M) {
            return i.I(((M)h0), o.a);
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(h0);
        stringBuilder0.append(", ");
        Class class0 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean y(h h0) {
        kotlin.jvm.internal.q.g(h0, "$receiver");
        if(h0 instanceof M) {
            return ((M)h0).e() instanceof e;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(h0);
        stringBuilder0.append(", ");
        Class class0 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }

    public static boolean z(h h0) {
        if(h0 instanceof M) {
            Me.h h1 = ((M)h0).e();
            e e0 = h1 instanceof e ? ((e)h1) : null;
            return e0 != null && e0.i() == y.b && e0.getKind() != Me.f.c && e0.getKind() != Me.f.d && e0.getKind() != Me.f.e;
        }
        StringBuilder stringBuilder0 = new StringBuilder("ClassicTypeSystemContext couldn\'t handle: ");
        stringBuilder0.append(h0);
        stringBuilder0.append(", ");
        Class class0 = h0.getClass();
        throw new IllegalArgumentException(b.l(I.a, class0, stringBuilder0).toString());
    }
}

