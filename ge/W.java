package Ge;

import Ac.k;
import De.d;
import E9.h;
import Hf.x;
import Je.i;
import Me.S;
import Me.f;
import Se.c;
import Tf.v;
import Ve.N;
import Ve.o;
import Ve.p;
import ie.j;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.q;
import qf.b;
import qf.e;
import we.a;

public final class w implements a {
    public final int a;
    public final y b;
    public final B c;

    public w(B b0, y y0) {
        this.a = 0;
        super();
        this.c = b0;
        this.b = y0;
    }

    public w(y y0, B b0, int v) {
        this.a = v;
        this.b = y0;
        this.c = b0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        Field field0;
        ArrayList arrayList3;
        Class[] arr_class;
        Boolean boolean0;
        int v = 0;
        ArrayList arrayList0 = null;
        B b0 = this.c;
        y y0 = this.b;
        switch(this.a) {
            case 0: {
                Class class0 = b0.b;
                ClassLoader classLoader0 = c.d(class0);
                N n0 = (N)((j)y0.c).getValue();
                if(n0 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for(Object object2: n0.l) {
                        q.g(((String)object2), "name");
                        Class class1 = A0.i(classLoader0, h.Z(((String)object2)), 0);
                        d d0 = class1 == null ? null : df.d.y(class1);
                        if(d0 != null) {
                            arrayList2.add(d0);
                        }
                    }
                    return arrayList2;
                }
                Method method0 = (Method)ye.a.J().a;
                if(method0 == null) {
                    boolean0 = null;
                }
                else {
                    Object object3 = method0.invoke(class0, null);
                    q.e(object3, "null cannot be cast to non-null type kotlin.Boolean");
                    boolean0 = (Boolean)object3;
                }
                if(q.b(boolean0, Boolean.TRUE)) {
                    Method method1 = (Method)ye.a.J().b;
                    if(method1 == null) {
                        arr_class = null;
                    }
                    else {
                        Object object4 = method1.invoke(class0, null);
                        q.e(object4, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
                        arr_class = (Class[])object4;
                    }
                    if(arr_class != null) {
                        arrayList0 = new ArrayList(arr_class.length);
                        while(v < arr_class.length) {
                            arrayList0.add(df.d.y(arr_class[v]));
                            ++v;
                        }
                    }
                    if(arrayList0 != null) {
                        return arrayList0;
                    }
                }
                return je.w.a;
            }
            case 1: {
                Class class2 = b0.b;
                N n1 = (N)((j)y0.c).getValue();
                if(n1 != null) {
                    String s = n1.b;
                    if(s != null) {
                        b b1 = h.Z(s);
                        ClassLoader classLoader1 = c.d(class2);
                        arrayList3 = new ArrayList();
                        for(Object object5: n1.i) {
                            Class class3 = A0.i(classLoader1, b1.d(e.e(((String)object5))), 0);
                            d d1 = class3 == null ? null : df.d.y(class3);
                            if(d1 != null) {
                                arrayList3.add(d1);
                            }
                        }
                        return arrayList3;
                    }
                    q.m("name");
                    throw null;
                }
                Class[] arr_class1 = class2.getDeclaredClasses();
                q.f(arr_class1, "getDeclaredClasses(...)");
                arrayList3 = new ArrayList();
                while(v < arr_class1.length) {
                    Class class4 = arr_class1[v];
                    q.d(class4);
                    arrayList3.add(df.d.y(class4));
                    ++v;
                }
                return arrayList3;
            }
            case 2: {
                Class class5 = b0.b;
                N n2 = (N)((j)y0.c).getValue();
                if(n2 != null && (o.a(n2) == p.b || o.a(n2) == p.c)) {
                    if(o.a(n2) == p.c) {
                        LinkedHashSet linkedHashSet0 = Je.d.a;
                        String s1 = n2.b;
                        if(s1 != null) {
                            if(je.p.d0(linkedHashSet0, h.Z(s1).e())) {
                                field0 = class5.getDeclaredField("INSTANCE");
                                arrayList0 = field0.get(null);
                                q.e(arrayList0, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
                                return arrayList0;
                            }
                            else {
                                Class class6 = class5.getEnclosingClass();
                                String s2 = n2.b;
                                if(s2 != null) {
                                    if(v.r0(s2, ".", false)) {
                                        throw new IllegalArgumentException(("Local class is not supported: " + s2).toString());
                                    }
                                    String s3 = Tf.o.Y0('/', s2, s2);
                                    field0 = class6.getDeclaredField(Tf.o.Y0('.', s3, s3));
                                    arrayList0 = field0.get(null);
                                    q.e(arrayList0, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
                                    return arrayList0;
                                }
                            }
                        }
                        q.m("name");
                        throw null;
                    }
                    else {
                        field0 = class5.getDeclaredField("INSTANCE");
                    }
                    arrayList0 = field0.get(null);
                    q.e(arrayList0, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.KClassImpl");
                }
                return arrayList0;
            }
            case 3: {
                List list0 = y0.a().h();
                q.f(list0, "getDeclaredTypeParameters(...)");
                ArrayList arrayList4 = new ArrayList(je.q.Q(10, list0));
                for(Object object6: list0) {
                    q.d(((S)object6));
                    arrayList4.add(new q0(b0, ((S)object6)));
                }
                return arrayList4;
            }
            default: {
                Collection collection0 = y0.a().q().f();
                q.f(collection0, "getSupertypes(...)");
                ArrayList arrayList1 = new ArrayList(collection0.size());
                for(Object object0: collection0) {
                    q.d(((x)object0));
                    arrayList1.add(new p0(((x)object0), new k(((x)object0), y0, b0, 8)));
                }
                Me.e e0 = y0.a();
                if(!i.b(e0, Je.o.a) && !i.b(e0, Je.o.b)) {
                    if(!arrayList1.isEmpty()) {
                        for(Object object1: arrayList1) {
                            f f0 = tf.e.c(((p0)object1).a).getKind();
                            q.f(f0, "getKind(...)");
                            if(f0 != f.b && f0 != f.e) {
                                return Qf.k.d(arrayList1);
                            }
                        }
                    }
                    arrayList1.add(new p0(xf.d.e(y0.a()).e(), () -> Object.class));
                }
                return Qf.k.d(arrayList1);
            }
        }
    }
}

