package Ge;

import A7.d;
import Me.L;
import Me.k;
import Me.o;
import Pe.r;
import Tf.j;
import Tf.l;
import Ze.u;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import je.p;
import kotlin.jvm.internal.q;
import lf.I;
import pf.g;
import qf.e;
import we.a;

public final class g0 implements a {
    public final int a;
    public final m0 b;

    public g0(m0 m00, int v) {
        this.a = v;
        this.b = m00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        Class class0;
        l l0 = null;
        m0 m00 = this.b;
        boolean z = true;
        if(this.a != 0) {
            F f0 = m00.g;
            String s = m00.h;
            String s1 = m00.i;
            f0.getClass();
            q.g(s, "name");
            q.g(s1, "signature");
            F.a.getClass();
            Matcher matcher0 = F.a.a.matcher(s1);
            q.f(matcher0, "matcher(...)");
            if(matcher0.matches()) {
                l0 = new l(matcher0, s1);
            }
            if(l0 != null) {
                String s2 = (String)((j)l0.a()).get(1);
                L l1 = f0.o(Integer.parseInt(s2));
                if(l1 == null) {
                    StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("Local property #", s2, " not found in ");
                    stringBuilder0.append(f0.c());
                    throw new s0(stringBuilder0.toString());
                }
                return l1;
            }
            Iterable iterable0 = f0.r(e.e(s));
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: iterable0) {
                if(q.b(y0.b(((L)object0)).k(), s1)) {
                    arrayList0.add(object0);
                }
            }
            if(!arrayList0.isEmpty()) {
                if(arrayList0.size() != 1) {
                    LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                    for(Object object1: arrayList0) {
                        o o0 = ((L)object1).getVisibility();
                        ArrayList arrayList1 = linkedHashMap0.get(o0);
                        if(arrayList1 == null) {
                            arrayList1 = new ArrayList();
                            linkedHashMap0.put(o0, arrayList1);
                        }
                        arrayList1.add(object1);
                    }
                    TreeMap treeMap0 = new TreeMap(new f(2));
                    treeMap0.putAll(linkedHashMap0);
                    Collection collection0 = treeMap0.values();
                    q.f(collection0, "<get-values>(...)");
                    List list0 = (List)p.r0(collection0);
                    if(list0.size() == 1) {
                        return (L)p.k0(list0);
                    }
                    String s3 = p.q0(f0.r(e.e(s)), "\n", null, null, b.f, 30);
                    StringBuilder stringBuilder1 = d.o("Property \'", s, "\' (JVM signature: ", s1, ") not resolved in ");
                    stringBuilder1.append(f0);
                    stringBuilder1.append(':');
                    stringBuilder1.append((s3.length() == 0 ? " no members found" : "\n" + s3));
                    throw new s0(stringBuilder1.toString());
                }
                return (L)p.E0(arrayList0);
            }
            StringBuilder stringBuilder2 = d.o("Property \'", s, "\' (JVM signature: ", s1, ") not resolved in ");
            stringBuilder2.append(f0);
            throw new s0(stringBuilder2.toString());
        }
        L l2 = m00.t();
        F f1 = m00.g;
        B.a a0 = y0.b(l2);
        if(a0 instanceof n) {
            I i0 = ((n)a0).f;
            L l3 = ((n)a0).e;
            pf.d d0 = g.b(i0, ((n)a0).h, ((n)a0).i, true);
            if(d0 != null) {
                if(l3.getKind() == 2) {
                    z = false;
                }
                else {
                    k k0 = l3.e();
                    if(k0 == null) {
                        throw new IllegalArgumentException("Argument for @NotNull parameter \'companionObject\' of kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil.isClassCompanionObjectWithBackingFieldsInOuter must not be null");
                    }
                    if(tf.e.l(k0)) {
                        k k1 = k0.e();
                        if(!tf.e.m(k1, Me.f.a) && !tf.e.m(k1, Me.f.c)) {
                            goto label_79;
                        }
                        else if(tf.e.l(((Me.e)k0))) {
                            qf.b b0 = xf.d.f(((Me.e)k0));
                            qf.b b1 = b0 == null ? null : b0.e();
                            if(p.d0(Je.d.a, b1)) {
                                goto label_79;
                            }
                        }
                    }
                    else {
                    label_79:
                        if(tf.e.l(l3.e())) {
                            r r0 = l3.C0();
                            if(!(r0 == null || !r0.getAnnotations().c(u.a) ? l3.getAnnotations().c(u.a) : true)) {
                                z = false;
                            }
                        }
                        else {
                            z = false;
                        }
                    }
                }
                if(z || g.d(i0)) {
                    class0 = f1.c().getEnclosingClass();
                }
                else {
                    k k2 = l3.e();
                    class0 = k2 instanceof Me.e ? A0.k(((Me.e)k2)) : f1.c();
                }
                if(class0 != null) {
                    try {
                        return class0.getDeclaredField(d0.k);
                    }
                    catch(NoSuchFieldException unused_ex) {
                    }
                }
            }
        }
        else {
            if(a0 instanceof Ge.l) {
                return ((Ge.l)a0).e;
            }
            if(!(a0 instanceof m) && !(a0 instanceof Ge.o)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        return null;
    }
}

