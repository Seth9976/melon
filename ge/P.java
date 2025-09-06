package Ge;

import De.I;
import De.n;
import De.o;
import Hf.x;
import Me.S;
import Me.c;
import Pe.u;
import e.k;
import ie.j;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.t;
import kotlin.coroutines.Continuation;
import tf.g;
import we.a;

public final class p implements a {
    public final int a;
    public final s b;

    public p(s s0, int v) {
        this.a = v;
        this.b = s0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        int v4;
        int v;
        Type type0 = null;
        s s0 = this.b;
        switch(this.a) {
            case 0: {
                return A0.d(s0.n());
            }
            case 1: {
                c c0 = s0.n();
                ArrayList arrayList0 = new ArrayList();
                if(s0.q()) {
                    v = 0;
                }
                else {
                    u u0 = A0.g(c0);
                    if(u0 == null) {
                        v = 0;
                    }
                    else {
                        q q0 = new q(u0, 0);
                        arrayList0.add(new W(s0, 0, n.a, q0));
                        v = 1;
                    }
                    u u1 = c0.Q();
                    if(u1 != null) {
                        q q1 = new q(u1, 1);
                        arrayList0.add(new W(s0, v, n.b, q1));
                        ++v;
                    }
                }
                int v1 = c0.F().size();
                int v2 = 0;
                while(v2 < v1) {
                    r r0 = new r(c0, v2, 0);
                    arrayList0.add(new W(s0, v, n.c, r0));
                    ++v2;
                    ++v;
                }
                if(s0.p() && c0 instanceof bf.a && arrayList0.size() > 1) {
                    t.S(arrayList0, new f(1));
                }
                arrayList0.trimToSize();
                return arrayList0;
            }
            case 2: {
                x x0 = s0.n().getReturnType();
                kotlin.jvm.internal.q.d(x0);
                return new p0(x0, new p(s0, 6));
            }
            case 3: {
                List list0 = s0.n().getTypeParameters();
                kotlin.jvm.internal.q.f(list0, "getTypeParameters(...)");
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, list0));
                for(Object object2: list0) {
                    kotlin.jvm.internal.q.d(((S)object2));
                    arrayList1.add(new q0(s0, ((S)object2)));
                }
                return arrayList1;
            }
            case 4: {
                List list1 = s0.getParameters();
                int v3 = s0.isSuspend() + list1.size();
                if(((Boolean)((j)s0.f).getValue()).booleanValue()) {
                    v4 = 0;
                    for(Object object3: list1) {
                        o o0 = (o)object3;
                        v4 += (((W)o0).c == n.c ? s0.o(o0) : 0);
                    }
                }
                else if(!(list1 instanceof Collection) || !list1.isEmpty()) {
                    v4 = 0;
                    for(Object object4: list1) {
                        if(((W)(((o)object4))).c == n.c) {
                            ++v4;
                            if(v4 < 0) {
                                k.N();
                                throw null;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                }
                else {
                    v4 = 0;
                }
                int v5 = (v4 + 0x1F) / 0x20;
                Object[] arr_object = new Object[v3 + v5 + 1];
                for(Object object5: list1) {
                    W w0 = (W)(((o)object5));
                    boolean z = w0.g();
                    int v6 = w0.b;
                    if(z) {
                        x x1 = w0.f().a;
                        if(x1 == null || !g.c(x1)) {
                            p0 p00 = w0.f();
                            u0 u00 = p00.b;
                            Type type1 = u00 == null ? null : ((Type)u00.invoke());
                            if(type1 == null) {
                                Type type2 = u00 == null ? null : ((Type)u00.invoke());
                                type1 = type2 == null ? I.s(p00, false) : type2;
                            }
                            arr_object[v6] = A0.e(type1);
                            continue;
                        }
                    }
                    if(w0.h()) {
                        arr_object[v6] = s.f(w0.f());
                    }
                }
                for(int v7 = 0; v7 < v5; ++v7) {
                    arr_object[v3 + v7] = 0;
                }
                return arr_object;
            }
            case 5: {
                Iterable iterable0 = s0.getParameters();
                if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                    for(Object object6: iterable0) {
                        if(A0.h(((W)(((o)object6))).f())) {
                            return true;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
                return false;
            }
            default: {
                if(s0.isSuspend()) {
                    Object object0 = je.p.t0(s0.g().a());
                    ParameterizedType parameterizedType0 = object0 instanceof ParameterizedType ? ((ParameterizedType)object0) : null;
                    if(kotlin.jvm.internal.q.b((parameterizedType0 == null ? null : parameterizedType0.getRawType()), Continuation.class)) {
                        Type[] arr_type = parameterizedType0.getActualTypeArguments();
                        kotlin.jvm.internal.q.f(arr_type, "getActualTypeArguments(...)");
                        Object object1 = je.n.u0(arr_type);
                        WildcardType wildcardType0 = object1 instanceof WildcardType ? ((WildcardType)object1) : null;
                        if(wildcardType0 != null) {
                            Type[] arr_type1 = wildcardType0.getLowerBounds();
                            if(arr_type1 != null) {
                                type0 = (Type)je.n.h0(arr_type1);
                            }
                        }
                    }
                }
                return type0 == null ? s0.g().getReturnType() : type0;
            }
        }
    }
}

