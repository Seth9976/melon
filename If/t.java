package If;

import Hf.B;
import Hf.I;
import Hf.M;
import Hf.a0;
import Hf.c;
import Hf.d;
import Hf.g;
import Hf.w;
import Hf.x;
import Jf.l;
import Qf.k;
import ea.b;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import je.p;
import je.u;
import kotlin.jvm.internal.q;
import we.n;

public final class t {
    public static final t a;

    static {
        t.a = new t();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static ArrayList a(AbstractCollection abstractCollection0, n n0) {
        ArrayList arrayList0 = new ArrayList(abstractCollection0);
        Iterator iterator0 = arrayList0.iterator();
        q.f(iterator0, "iterator(...)");
    label_3:
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            B b0 = (B)object0;
            if(!arrayList0.isEmpty()) {
                Iterator iterator1 = arrayList0.iterator();
                while(true) {
                    if(!iterator1.hasNext()) {
                        continue label_3;
                    }
                    Object object1 = iterator1.next();
                    B b1 = (B)object1;
                    if(b1 != b0) {
                        q.d(b1);
                        q.d(b0);
                        if(((Boolean)n0.invoke(b1, b0)).booleanValue()) {
                            break;
                        }
                    }
                }
                iterator0.remove();
            }
        }
        return arrayList0;
    }

    public final B b(ArrayList arrayList0) {
        B b5;
        arrayList0.size();
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            B b0 = (B)object0;
            if(b0.w() instanceof w) {
                Collection collection0 = b0.w().f();
                q.f(collection0, "getSupertypes(...)");
                ArrayList arrayList2 = new ArrayList(je.q.Q(10, collection0));
                for(Object object1: collection0) {
                    q.d(((x)object1));
                    B b1 = c.E(((x)object1));
                    if(b0.D()) {
                        b1 = b1.V(true);
                    }
                    arrayList2.add(b1);
                }
                arrayList1.addAll(arrayList2);
            }
            else {
                arrayList1.add(b0);
            }
        }
        s s0 = s.a;
        for(Object object2: arrayList1) {
            s0 = s0.a(((a0)object2));
        }
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        for(Object object3: arrayList1) {
            B b2 = (B)object3;
            if(s0 == s.d) {
                if(b2 instanceof h) {
                    q.g(((h)b2), "<this>");
                    b2 = new h(((h)b2).b, ((h)b2).c, ((h)b2).d, ((h)b2).e, ((h)b2).f, true);
                }
                q.g(b2, "<this>");
                B b3 = d.p(b2, false);
                if(b3 == null) {
                    B b4 = c.o(b2);
                    b2 = b4 == null ? b2.V(false) : b4;
                }
                else {
                    b2 = b3;
                }
            }
            linkedHashSet0.add(b2);
        }
        ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object4: arrayList0) {
            arrayList3.add(((B)object4).t());
        }
        Iterator iterator5 = arrayList3.iterator();
        if(!iterator5.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can\'t be reduced.");
        }
        I i0 = iterator5.next();
        while(true) {
            b5 = null;
            if(!iterator5.hasNext()) {
                break;
            }
            Object object5 = iterator5.next();
            I i1 = (I)object5;
            i0.getClass();
            b b6 = I.b;
            q.g(i1, "other");
            if(!i0.isEmpty() || !i1.isEmpty()) {
                ArrayList arrayList4 = new ArrayList();
                Collection collection1 = ((ConcurrentHashMap)b6.a).values();
                q.f(collection1, "<get-values>(...)");
                for(Object object6: collection1) {
                    int v = ((Number)object6).intValue();
                    g g0 = (g)i0.a.get(v);
                    g g1 = (g)i1.a.get(v);
                    if(g0 != null) {
                        if(!q.b(g1, g0)) {
                            g0 = null;
                        }
                        g1 = g0;
                    }
                    else if(g1 == null || !q.b(null, g1)) {
                        g1 = null;
                    }
                    k.a(arrayList4, g1);
                }
                i0 = b.g(arrayList4);
            }
        }
        if(linkedHashSet0.size() == 1) {
            return ((B)p.D0(linkedHashSet0)).W(i0);
        }
        ArrayList arrayList5 = t.a(linkedHashSet0, new Dc.s(2, this, t.class, "isStrictSupertype", "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z", 0, 1));
        arrayList5.isEmpty();
        if(!arrayList5.isEmpty()) {
            Iterator iterator7 = arrayList5.iterator();
            if(!iterator7.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can\'t be reduced.");
            }
            B b7 = iterator7.next();
            while(iterator7.hasNext()) {
                Object object7 = iterator7.next();
                B b8 = (B)object7;
                if(b7 != null && b8 != null) {
                    M m0 = b7.w();
                    M m1 = b8.w();
                    boolean z = m0 instanceof vf.p;
                    if(z && m1 instanceof vf.p) {
                        q.g(((vf.p)m0).a, "<this>");
                        q.g(((vf.p)m1).a, "other");
                        Set set0 = p.S0(((vf.p)m0).a);
                        u.U(set0, ((vf.p)m1).a);
                        vf.p p0 = new vf.p(set0);
                        I.b.getClass();
                        q.g(I.c, "attributes");
                        b7 = c.v(l.a(Jf.h.c, true, new String[]{"unknown integer literal type"}), I.c, p0, je.w.a, false);
                    }
                    else if(z) {
                        if(!((vf.p)m0).a.contains(b8)) {
                            b8 = null;
                        }
                        b7 = b8;
                    }
                    else if(!(m1 instanceof vf.p) || !((vf.p)m1).a.contains(b7)) {
                        b7 = null;
                    }
                }
                else {
                    b7 = null;
                }
            }
            b5 = b7;
        }
        if(b5 != null) {
            return b5.W(i0);
        }
        If.k.b.getClass();
        ArrayList arrayList6 = t.a(arrayList5, new Dc.s(2, j.b, If.l.class, "equalTypes", "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z", 0, 2));
        arrayList6.isEmpty();
        return arrayList6.size() >= 2 ? new w(linkedHashSet0).b().W(i0) : ((B)p.D0(arrayList6)).W(i0);
    }
}

