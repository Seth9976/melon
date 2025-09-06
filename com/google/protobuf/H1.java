package com.google.protobuf;

import Vd.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public final class h1 {
    public final Object a(Object object0, w w0, y1 y10, g1 g10, o1 o10, Object object1, T2 t20) {
        Object object2;
        ArrayList arrayList0;
        x1 x10 = y10.d;
        l2 l20 = y10.c;
        int v = x10.a;
        j3 j30 = x10.b;
        if(x10.c && x10.d) {
            switch(j30.ordinal()) {
                case 0: {
                    arrayList0 = new ArrayList();
                    w0.C(arrayList0);
                    break;
                }
                case 1: {
                    arrayList0 = new ArrayList();
                    w0.Q(arrayList0);
                    break;
                }
                case 2: {
                    arrayList0 = new ArrayList();
                    w0.W(arrayList0);
                    break;
                }
                case 3: {
                    arrayList0 = new ArrayList();
                    w0.s0(arrayList0);
                    break;
                }
                case 4: {
                    arrayList0 = new ArrayList();
                    w0.T(arrayList0);
                    break;
                }
                case 5: {
                    arrayList0 = new ArrayList();
                    w0.N(arrayList0);
                    break;
                }
                case 6: {
                    arrayList0 = new ArrayList();
                    w0.K(arrayList0);
                    break;
                }
                case 7: {
                    arrayList0 = new ArrayList();
                    w0.t(arrayList0);
                    break;
                }
                case 12: {
                    arrayList0 = new ArrayList();
                    w0.p0(arrayList0);
                    break;
                }
                case 13: {
                    ArrayList arrayList1 = new ArrayList();
                    w0.F(arrayList1);
                    object1 = F2.k(object0, v, arrayList1, null, object1, t20);
                    arrayList0 = arrayList1;
                    break;
                }
                case 14: {
                    arrayList0 = new ArrayList();
                    w0.a0(arrayList0);
                    break;
                }
                case 15: {
                    arrayList0 = new ArrayList();
                    w0.d0(arrayList0);
                    break;
                }
                case 16: {
                    arrayList0 = new ArrayList();
                    w0.g0(arrayList0);
                    break;
                }
                case 17: {
                    arrayList0 = new ArrayList();
                    w0.j0(arrayList0);
                    break;
                }
                default: {
                    throw new IllegalStateException("Type cannot be packed: " + x10.b);
                }
            }
            o10.o(x10, arrayList0);
            return object1;
        }
        if(j30 != j3.g) {
            switch(j30.ordinal()) {
                case 0: {
                    w0.v0(1);
                    object2 = ((t)w0.e).n();
                    break;
                }
                case 1: {
                    w0.v0(5);
                    object2 = ((t)w0.e).r();
                    break;
                }
                case 2: {
                    w0.v0(0);
                    object2 = ((t)w0.e).u();
                    break;
                }
                case 3: {
                    w0.v0(0);
                    object2 = ((t)w0.e).G();
                    break;
                }
                case 4: {
                    w0.v0(0);
                    object2 = ((t)w0.e).t();
                    break;
                }
                case 5: {
                    w0.v0(1);
                    object2 = ((t)w0.e).q();
                    break;
                }
                case 6: {
                    w0.v0(5);
                    object2 = ((t)w0.e).p();
                    break;
                }
                case 7: {
                    w0.v0(0);
                    object2 = Boolean.valueOf(((t)w0.e).l());
                    break;
                }
                case 8: {
                    w0.v0(2);
                    object2 = ((t)w0.e).C();
                    break;
                }
                case 9: {
                    if(!x10.c) {
                        Object object3 = o10.a.get(x10);
                        if(object3 instanceof A1) {
                            E2 e20 = B2.c.b(object3);
                            if(!((A1)object3).isMutable()) {
                                Object object4 = e20.d();
                                e20.a(object4, object3);
                                o10.o(x10, object4);
                                object3 = object4;
                            }
                            w0.v0(3);
                            w0.n(object3, e20, g10);
                            return object1;
                        }
                    }
                    Class class0 = l20.getClass();
                    w0.v0(3);
                    E2 e21 = B2.c.a(class0);
                    Object object5 = e21.d();
                    w0.n(object5, e21, g10);
                    e21.b(object5);
                    object2 = object5;
                    break;
                }
                case 10: {
                    if(!x10.c) {
                        Object object6 = o10.a.get(x10);
                        if(object6 instanceof A1) {
                            E2 e22 = B2.c.b(object6);
                            if(!((A1)object6).isMutable()) {
                                Object object7 = e22.d();
                                e22.a(object7, object6);
                                o10.o(x10, object7);
                                object6 = object7;
                            }
                            w0.v0(2);
                            w0.q(object6, e22, g10);
                            return object1;
                        }
                    }
                    object2 = w0.X(l20.getClass(), g10);
                    break;
                }
                case 11: {
                    object2 = w0.w();
                    break;
                }
                case 12: {
                    w0.v0(0);
                    object2 = ((t)w0.e).F();
                    break;
                }
                case 13: {
                    throw new IllegalStateException("Shouldn\'t reach here.");
                }
                case 14: {
                    w0.v0(5);
                    object2 = ((t)w0.e).y();
                    break;
                }
                case 15: {
                    w0.v0(1);
                    object2 = ((t)w0.e).z();
                    break;
                }
                case 16: {
                    w0.v0(0);
                    object2 = ((t)w0.e).A();
                    break;
                }
                case 17: {
                    w0.v0(0);
                    object2 = ((t)w0.e).B();
                    break;
                }
                default: {
                    object2 = null;
                    break;
                }
            }
            if(x10.c) {
                o10.a(x10, object2);
                return object1;
            }
            switch(x10.b.ordinal()) {
                case 9: 
                case 10: {
                    Object object8 = o10.a.get(x10);
                    if(object8 != null) {
                        k2 k20 = ((l2)object8).toBuilder();
                        if(!((t1)k20).a.getClass().isInstance(((l2)object2))) {
                            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
                        }
                        ((t1)k20).f(((A1)(((b)(((l2)object2))))));
                        object2 = ((t1)k20).B();
                        break;
                    }
                }
            }
            o10.o(x10, object2);
            return object1;
        }
        w0.v0(0);
        ((t)w0.e).t();
        throw null;
    }

    public final void b(e2 e20, Map.Entry map$Entry0) {
        x1 x10 = (x1)map$Entry0.getKey();
        j3 j30 = x10.b;
        boolean z = x10.d;
        int v = x10.a;
        if(x10.c) {
            switch(j30.ordinal()) {
                case 0: {
                    F2.q(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 1: {
                    F2.u(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 2: {
                    F2.x(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 3: {
                    F2.F(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 4: {
                    F2.w(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 5: {
                    F2.t(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 6: {
                    F2.s(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 7: {
                    F2.o(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 8: {
                    F2.D(v, ((List)map$Entry0.getValue()), e20);
                    return;
                }
                case 9: {
                    List list0 = (List)map$Entry0.getValue();
                    if(list0 == null || list0.isEmpty()) {
                        return;
                    }
                    List list1 = (List)map$Entry0.getValue();
                    Class class0 = list0.get(0).getClass();
                    F2.v(v, list1, e20, B2.c.a(class0));
                    return;
                }
                case 10: {
                    List list2 = (List)map$Entry0.getValue();
                    if(list2 == null || list2.isEmpty()) {
                        return;
                    }
                    List list3 = (List)map$Entry0.getValue();
                    Class class1 = list2.get(0).getClass();
                    F2.y(v, list3, e20, B2.c.a(class1));
                    return;
                }
                case 11: {
                    F2.p(v, ((List)map$Entry0.getValue()), e20);
                    return;
                }
                case 12: {
                    F2.E(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 13: {
                    F2.w(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 14: {
                    F2.z(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 15: {
                    F2.A(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 16: {
                    F2.B(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                case 17: {
                    F2.C(v, ((List)map$Entry0.getValue()), e20, z);
                    return;
                }
                default: {
                    return;
                }
            }
        }
        switch(j30.ordinal()) {
            case 0: {
                double f = (double)(((Double)map$Entry0.getValue()));
                ((x)e20.a).getClass();
                ((x)e20.a).Z(v, Double.doubleToRawLongBits(f));
                return;
            }
            case 1: {
                float f1 = (float)(((Float)map$Entry0.getValue()));
                ((x)e20.a).getClass();
                ((x)e20.a).X(v, Float.floatToRawIntBits(f1));
                return;
            }
            case 2: {
                long v1 = (long)(((Long)map$Entry0.getValue()));
                ((x)e20.a).m0(v, v1);
                return;
            }
            case 3: {
                long v2 = (long)(((Long)map$Entry0.getValue()));
                ((x)e20.a).m0(v, v2);
                return;
            }
            case 4: {
                int v3 = (int)(((Integer)map$Entry0.getValue()));
                ((x)e20.a).b0(v, v3);
                return;
            }
            case 5: {
                long v4 = (long)(((Long)map$Entry0.getValue()));
                ((x)e20.a).Z(v, v4);
                return;
            }
            case 6: {
                int v5 = (int)(((Integer)map$Entry0.getValue()));
                ((x)e20.a).X(v, v5);
                return;
            }
            case 7: {
                boolean z1 = ((Boolean)map$Entry0.getValue()).booleanValue();
                ((x)e20.a).T(v, z1);
                return;
            }
            case 8: {
                String s = (String)map$Entry0.getValue();
                ((x)e20.a).h0(v, s);
                return;
            }
            case 9: {
                Object object0 = map$Entry0.getValue();
                Class class2 = map$Entry0.getValue().getClass();
                e20.a(v, object0, B2.c.a(class2));
                return;
            }
            case 10: {
                Object object1 = map$Entry0.getValue();
                Class class3 = map$Entry0.getValue().getClass();
                E2 e21 = B2.c.a(class3);
                ((x)e20.a).d0(v, ((l2)object1), e21);
                return;
            }
            case 11: {
                o o0 = (o)map$Entry0.getValue();
                ((x)e20.a).V(v, o0);
                return;
            }
            case 12: {
                int v6 = (int)(((Integer)map$Entry0.getValue()));
                ((x)e20.a).k0(v, v6);
                return;
            }
            case 13: {
                int v7 = (int)(((Integer)map$Entry0.getValue()));
                ((x)e20.a).b0(v, v7);
                return;
            }
            case 14: {
                int v8 = (int)(((Integer)map$Entry0.getValue()));
                ((x)e20.a).X(v, v8);
                return;
            }
            case 15: {
                long v9 = (long)(((Long)map$Entry0.getValue()));
                ((x)e20.a).Z(v, v9);
                return;
            }
            case 16: {
                int v10 = (int)(((Integer)map$Entry0.getValue()));
                ((x)e20.a).k0(v, v10 >> 0x1F ^ v10 << 1);
                return;
            }
            case 17: {
                long v11 = (long)(((Long)map$Entry0.getValue()));
                ((x)e20.a).m0(v, v11 >> 0x3F ^ v11 << 1);
            }
        }
    }
}

