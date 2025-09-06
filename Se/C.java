package Se;

import De.d;
import Ge.e;
import Tf.v;
import e.k;
import ie.m;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import je.C;
import je.q;
import je.w;
import kotlin.jvm.internal.I;
import we.a;
import we.b;
import we.f;
import we.g;
import we.h;
import we.i;
import we.j;
import we.l;
import we.n;
import we.o;
import we.p;
import we.r;
import we.s;
import we.t;
import we.u;

public abstract class c {
    public static final List a;
    public static final Map b;
    public static final Map c;
    public static final Map d;

    static {
        d d0 = I.a.b(Boolean.TYPE);
        d d1 = I.a.b(Byte.TYPE);
        d d2 = I.a.b(Character.TYPE);
        d d3 = I.a.b(Double.TYPE);
        d d4 = I.a.b(Float.TYPE);
        d d5 = I.a.b(Integer.TYPE);
        d d6 = I.a.b(Long.TYPE);
        d d7 = I.a.b(Short.TYPE);
        d[] arr_d = new d[8];
        int v = 0;
        arr_d[0] = d0;
        arr_d[1] = d1;
        arr_d[2] = d2;
        arr_d[3] = d3;
        arr_d[4] = d4;
        arr_d[5] = d5;
        arr_d[6] = d6;
        arr_d[7] = d7;
        List list0 = k.A(arr_d);
        c.a = list0;
        ArrayList arrayList0 = new ArrayList(q.Q(10, list0));
        for(Object object0: list0) {
            arrayList0.add(new m(df.d.w(((d)object0)), df.d.x(((d)object0))));
        }
        c.b = C.Y(arrayList0);
        ArrayList arrayList1 = new ArrayList(q.Q(10, c.a));
        for(Object object1: c.a) {
            arrayList1.add(new m(df.d.x(((d)object1)), df.d.w(((d)object1))));
        }
        c.c = C.Y(arrayList1);
        Iterable iterable0 = k.A(new Class[]{a.class, we.k.class, n.class, o.class, p.class, we.q.class, r.class, s.class, t.class, u.class, b.class, we.c.class, e.class, we.d.class, we.e.class, f.class, g.class, h.class, i.class, j.class, l.class, we.m.class, e.class});
        ArrayList arrayList2 = new ArrayList(q.Q(10, iterable0));
        for(Object object2: iterable0) {
            if(v >= 0) {
                arrayList2.add(new m(((Class)object2), v));
                ++v;
                continue;
            }
            k.O();
            throw null;
        }
        c.d = C.Y(arrayList2);
    }

    public static final qf.b a(Class class0) {
        kotlin.jvm.internal.q.g(class0, "<this>");
        if(class0.isPrimitive()) {
            throw new IllegalArgumentException("Can\'t compute ClassId for primitive type: " + class0);
        }
        if(class0.isArray()) {
            throw new IllegalArgumentException("Can\'t compute ClassId for array type: " + class0);
        }
        if(class0.getEnclosingMethod() == null && class0.getEnclosingConstructor() == null && class0.getSimpleName().length() != 0) {
            Class class1 = class0.getDeclaringClass();
            if(class1 != null) {
                return c.a(class1).d(qf.e.e(class0.getSimpleName()));
            }
            qf.c c0 = new qf.c(class0.getName());
            return new qf.b(c0.b(), c0.a.f());
        }
        qf.c c1 = new qf.c(class0.getName());
        return new qf.b(c1.b(), d5.n.E(c1.a.f()), true);
    }

    public static final String b(Class class0) {
        kotlin.jvm.internal.q.g(class0, "<this>");
        if(class0.isPrimitive()) {
            switch(class0.getName()) {
                case "boolean": {
                    return "Z";
                }
                case "byte": {
                    return "B";
                }
                case "char": {
                    return "C";
                }
                case "double": {
                    return "D";
                }
                case "float": {
                    return "F";
                }
                case "int": {
                    return "I";
                }
                case "long": {
                    return "J";
                }
                case "short": {
                    return "S";
                }
                case "void": {
                    return "V";
                }
                default: {
                    throw new IllegalArgumentException("Unsupported primitive type: " + class0);
                }
            }
        }
        return class0.isArray() ? v.o0(class0.getName(), '.', '/') : "L" + v.o0(class0.getName(), '.', '/') + ';';
    }

    public static final List c(Type type0) {
        kotlin.jvm.internal.q.g(type0, "<this>");
        if(!(type0 instanceof ParameterizedType)) {
            return w.a;
        }
        if(((ParameterizedType)type0).getOwnerType() == null) {
            Type[] arr_type = ((ParameterizedType)type0).getActualTypeArguments();
            kotlin.jvm.internal.q.f(arr_type, "getActualTypeArguments(...)");
            return je.n.z0(arr_type);
        }
        return Sf.n.p0(new Sf.h(Sf.n.k0(type0, Se.b.b), Se.b.c, Sf.r.b));
    }

    public static final ClassLoader d(Class class0) {
        kotlin.jvm.internal.q.g(class0, "<this>");
        ClassLoader classLoader0 = class0.getClassLoader();
        if(classLoader0 == null) {
            classLoader0 = ClassLoader.getSystemClassLoader();
            kotlin.jvm.internal.q.f(classLoader0, "getSystemClassLoader(...)");
        }
        return classLoader0;
    }
}

