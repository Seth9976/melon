package df;

import De.I;
import Hf.W;
import Hf.Y;
import Hf.x;
import Je.i;
import Me.L;
import Me.o;
import Re.g;
import Se.D;
import Se.h;
import Se.p;
import Se.t;
import Se.w;
import Se.y;
import androidx.media3.session.legacy.V;
import bf.f;
import cf.a;
import com.google.firebase.messaging.u;
import d5.n;
import h7.u0;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import qf.e;
import tf.m;
import we.k;
import xf.d;

public final class z implements k {
    public final int a;
    public final C b;

    public z(C c0, int v) {
        this.a = v;
        this.b = c0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        y y0;
        h h1;
        boolean z1;
        g g1;
        Me.k k1;
        a a1;
        C c0 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((e)object0), "name");
                C c1 = c0.c;
                if(c1 != null) {
                    return (Collection)c1.f.invoke(((e)object0));
                }
                ArrayList arrayList1 = new ArrayList();
                for(Object object1: ((c)c0.e.invoke()).e(((e)object0))) {
                    f f0 = c0.t(((w)object1));
                    if(c0.r(f0)) {
                        ((a)c0.b.a).g.getClass();
                        arrayList1.add(f0);
                    }
                }
                c0.j(arrayList1, ((e)object0));
                return arrayList1;
            }
            case 1: {
                q.g(((e)object0), "name");
                C c2 = c0.c;
                if(c2 != null) {
                    return (L)c2.g.invoke(((e)object0));
                }
                t t0 = ((c)c0.e.invoke()).d(((e)object0));
                if(t0 != null) {
                    Field field0 = t0.a;
                    if(!field0.isEnumConstant()) {
                        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        boolean z = Modifier.isFinal(((Field)t0.b()).getModifiers());
                        u u0 = c0.b;
                        cf.c c3 = u0.Q(u0, t0);
                        a a0 = (a)u0.a;
                        Me.k k0 = c0.q();
                        o o0 = I.W(t0.e());
                        e e0 = t0.c();
                        g g0 = a0.j.b(t0);
                        if(!Modifier.isFinal(((Field)t0.b()).getModifiers()) || !Modifier.isStatic(((Field)t0.b()).getModifiers())) {
                            a1 = a0;
                            k1 = k0;
                            g1 = g0;
                            z1 = false;
                        }
                        else {
                            a1 = a0;
                            k1 = k0;
                            g1 = g0;
                            z1 = true;
                        }
                        bf.g g2 = bf.g.B1(k1, c3, o0, !z, e0, g1, z1);
                        h0.a = g2;
                        g2.x1(null, null, null, null);
                        V v0 = (V)u0.d;
                        Type type0 = field0.getGenericType();
                        q.f(type0, "getGenericType(...)");
                        if(!(type0 instanceof Class) || !((Class)type0).isPrimitive()) {
                            if(type0 instanceof GenericArrayType || type0 instanceof Class && ((Class)type0).isArray()) {
                                h1 = new h(type0);
                            }
                            else if(type0 instanceof WildcardType) {
                                h1 = new D(((WildcardType)type0));
                            }
                            else {
                                h1 = new p(type0);
                            }
                            y0 = h1;
                        }
                        else {
                            y0 = new y(((Class)type0));
                        }
                        x x0 = v0.C(y0, v.L(W.b, false, null, 7));
                        if((i.G(x0) || i.H(x0)) && Modifier.isFinal(((Field)t0.b()).getModifiers())) {
                            Modifier.isStatic(((Field)t0.b()).getModifiers());
                        }
                        Pe.I i0 = (Pe.I)h0.a;
                        Pe.u u1 = c0.p();
                        i0.A1(x0, je.w.a, u1, null, je.w.a);
                        Me.k k2 = c0.q();
                        Me.e e1 = k2 instanceof Me.e ? ((Me.e)k2) : null;
                        if(e1 != null) {
                            h0.a = ((yf.a)a1.x).h(e1, ((Pe.I)h0.a), u0);
                        }
                        Object object2 = h0.a;
                        x x1 = ((Pe.I)object2).getType();
                        if(((Me.V)object2) != null) {
                            if(x1 != null) {
                                if(!((Me.V)object2).P() && !Hf.c.k(x1)) {
                                    if(Y.b(x1)) {
                                        ((Pe.I)h0.a).y1(null, new df.y(c0, t0, h0, 0));
                                    }
                                    else {
                                        i i1 = d.e(((Me.V)object2));
                                        if(i.G(x1) || (If.d.a.a(i1.v(), x1) || If.d.a.a(i1.k("Number").g(), x1) || If.d.a.a(i1.e(), x1) || Je.t.a(x1))) {
                                            ((Pe.I)h0.a).y1(null, new df.y(c0, t0, h0, 0));
                                        }
                                    }
                                }
                                L l0 = (L)h0.a;
                                a1.g.getClass();
                                if(l0 == null) {
                                    throw new IllegalArgumentException("Argument for @NotNull parameter \'descriptor\' of kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1.recordField must not be null");
                                }
                                return (L)h0.a;
                            }
                            tf.e.a(66);
                            throw null;
                        }
                        tf.e.a(65);
                        throw null;
                    }
                }
                return null;
            }
            case 2: {
                q.g(((e)object0), "name");
                LinkedHashSet linkedHashSet0 = new LinkedHashSet(((Collection)c0.f.invoke(((e)object0))));
                LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                for(Object object3: linkedHashSet0) {
                    String s = n.q(((Pe.L)object3), 2);
                    ArrayList arrayList2 = linkedHashMap0.get(s);
                    if(arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        linkedHashMap0.put(s, arrayList2);
                    }
                    arrayList2.add(object3);
                }
                for(Object object4: linkedHashMap0.values()) {
                    List list0 = (List)object4;
                    if(list0.size() != 1) {
                        Collection collection0 = m.o(list0, df.m.c);
                        linkedHashSet0.removeAll(list0);
                        linkedHashSet0.addAll(collection0);
                    }
                }
                c0.m(linkedHashSet0, ((e)object0));
                return je.p.P0(((a)c0.b.a).r.e(c0.b, linkedHashSet0));
            }
            default: {
                q.g(((e)object0), "name");
                ArrayList arrayList0 = new ArrayList();
                Qf.k.a(arrayList0, c0.g.invoke(((e)object0)));
                c0.n(arrayList0, ((e)object0));
                return tf.e.m(c0.q(), Me.f.e) ? je.p.P0(arrayList0) : je.p.P0(((a)c0.b.a).r.e(c0.b, arrayList0));
            }
        }
    }
}

