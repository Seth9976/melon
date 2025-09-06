package Le;

import Je.o;
import Je.p;
import Ke.g;
import Ke.h;
import Ke.i;
import Ke.j;
import Tf.v;
import com.iloen.melon.utils.a;
import d5.t;
import e.k;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.q;
import qf.b;
import qf.c;
import qf.e;

public final class d {
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final b e;
    public static final c f;
    public static final b g;
    public static final HashMap h;
    public static final HashMap i;
    public static final HashMap j;
    public static final HashMap k;
    public static final HashMap l;
    public static final HashMap m;
    public static final List n;

    static {
        d.a = g.c.a + '.' + "Function";
        d.b = h.c.a + '.' + "KFunction";
        d.c = j.c.a + '.' + "SuspendFunction";
        d.d = i.c.a + '.' + "KSuspendFunction";
        b b0 = d3.g.i0(new c("kotlin.jvm.functions.FunctionN"));
        d.e = b0;
        d.f = b0.a();
        d.g = qf.h.w;
        d.d(Class.class);
        d.h = new HashMap();
        d.i = new HashMap();
        d.j = new HashMap();
        d.k = new HashMap();
        d.l = new HashMap();
        d.m = new HashMap();
        b b1 = d3.g.i0(o.B);
        c c0 = t.r(o.J, b1.a);
        b b2 = new b(b1.a, c0, false);
        Le.c c1 = new Le.c(d.d(Iterable.class), b1, b2);
        b b3 = d3.g.i0(o.A);
        c c2 = t.r(o.I, b3.a);
        b b4 = new b(b3.a, c2, false);
        Le.c c3 = new Le.c(d.d(Iterator.class), b3, b4);
        b b5 = d3.g.i0(o.C);
        c c4 = t.r(o.K, b5.a);
        b b6 = new b(b5.a, c4, false);
        Le.c c5 = new Le.c(d.d(Collection.class), b5, b6);
        b b7 = d3.g.i0(o.D);
        c c6 = t.r(o.L, b7.a);
        b b8 = new b(b7.a, c6, false);
        Le.c c7 = new Le.c(d.d(List.class), b7, b8);
        b b9 = d3.g.i0(o.F);
        c c8 = t.r(o.N, b9.a);
        b b10 = new b(b9.a, c8, false);
        Le.c c9 = new Le.c(d.d(Set.class), b9, b10);
        b b11 = d3.g.i0(o.E);
        c c10 = t.r(o.M, b11.a);
        b b12 = new b(b11.a, c10, false);
        Le.c c11 = new Le.c(d.d(ListIterator.class), b11, b12);
        b b13 = d3.g.i0(o.G);
        c c12 = t.r(o.O, b13.a);
        b b14 = new b(b13.a, c12, false);
        Le.c c13 = new Le.c(d.d(Map.class), b13, b14);
        b b15 = d3.g.i0(o.G).d(o.H.a.f());
        c c14 = t.r(o.P, b15.a);
        b b16 = new b(b15.a, c14, false);
        List list0 = k.A(new Le.c[]{c1, c3, c5, c7, c9, c11, c13, new Le.c(d.d(Map.Entry.class), b15, b16)});
        d.n = list0;
        d.c(Object.class, o.a);
        d.c(String.class, o.f);
        d.c(CharSequence.class, o.e);
        d.b(Throwable.class, o.k);
        d.c(Cloneable.class, o.c);
        d.c(Number.class, o.i);
        d.b(Comparable.class, o.l);
        d.c(Enum.class, o.j);
        d.b(Annotation.class, o.s);
        for(Object object0: list0) {
            d.a(((Le.c)object0).a, ((Le.c)object0).b);
            c c15 = ((Le.c)object0).c.a();
            d.i.put(c15.a, ((Le.c)object0).a);
            d.l.put(((Le.c)object0).c, ((Le.c)object0).b);
            d.m.put(((Le.c)object0).b, ((Le.c)object0).c);
            c c16 = ((Le.c)object0).b.a();
            c c17 = ((Le.c)object0).c.a();
            c c18 = ((Le.c)object0).c.a();
            d.j.put(c18.a, c16);
            d.k.put(c16.a, c17);
        }
        yf.c[] arr_c = yf.c.values();
        int v1 = 0;
        while(v1 < arr_c.length) {
            yf.c c19 = arr_c[v1];
            c c20 = c19.d;
            if(c20 != null) {
                b b17 = new b(c20.b(), c20.a.f());
                Je.k k0 = c19.d();
                q.f(k0, "getPrimitiveType(...)");
                c c21 = p.l.a(k0.a);
                d.a(b17, new b(c21.b(), c21.a.f()));
                ++v1;
                continue;
            }
            yf.c.a(15);
            throw null;
        }
        for(Object object1: Je.d.a) {
            c c22 = new c("kotlin.jvm.internal." + ((b)object1).f().b() + "CompanionObject");
            d.a(new b(c22.b(), c22.a.f()), ((b)object1).d(qf.g.b));
        }
        for(int v2 = 0; v2 < 23; ++v2) {
            c c23 = new c("kotlin.jvm.functions.Function" + v2);
            b b18 = new b(c23.b(), c23.a.f());
            e e0 = e.e(("Function" + v2));
            d.a(b18, new b(p.l, e0));
            c c24 = new c(a.k(v2, "kotlin.reflect.KFunction", new StringBuilder()));
            d.i.put(c24.a, d.g);
        }
        for(int v = 0; v < 22; ++v) {
            c c25 = new c(i.c.a + '.' + "KSuspendFunction" + v);
            d.i.put(c25.a, d.g);
        }
        c c26 = new c("kotlin.concurrent.atomics.AtomicInt");
        b b19 = d.d(AtomicInteger.class);
        d.i.put(c26.a, b19);
        c c27 = new c("kotlin.concurrent.atomics.AtomicLong");
        b b20 = d.d(AtomicLong.class);
        d.i.put(c27.a, b20);
        c c28 = new c("kotlin.concurrent.atomics.AtomicBoolean");
        b b21 = d.d(AtomicBoolean.class);
        d.i.put(c28.a, b21);
        c c29 = new c("kotlin.concurrent.atomics.AtomicReference");
        b b22 = d.d(AtomicReference.class);
        d.i.put(c29.a, b22);
        c c30 = new c("kotlin.concurrent.atomics.AtomicIntArray");
        b b23 = d.d(AtomicIntegerArray.class);
        d.i.put(c30.a, b23);
        c c31 = new c("kotlin.concurrent.atomics.AtomicLongArray");
        b b24 = d.d(AtomicLongArray.class);
        d.i.put(c31.a, b24);
        c c32 = new c("kotlin.concurrent.atomics.AtomicArray");
        b b25 = d.d(AtomicReferenceArray.class);
        d.i.put(c32.a, b25);
        c c33 = o.b.g();
        b b26 = d.d(Void.class);
        d.i.put(c33.a, b26);
    }

    public static void a(b b0, b b1) {
        c c0 = b0.a();
        d.h.put(c0.a, b1);
        c c1 = b1.a();
        d.i.put(c1.a, b0);
    }

    public static void b(Class class0, c c0) {
        b b0 = d.d(class0);
        q.g(c0, "topLevelFqName");
        d.a(b0, new b(c0.b(), c0.a.f()));
    }

    public static void c(Class class0, qf.d d0) {
        d.b(class0, d0.g());
    }

    public static b d(Class class0) {
        class0.isPrimitive();
        Class class1 = class0.getDeclaringClass();
        if(class1 == null) {
            String s = class0.getCanonicalName();
            q.f(s, "getCanonicalName(...)");
            c c0 = new c(s);
            return new b(c0.b(), c0.a.f());
        }
        return d.d(class1).d(e.e(class0.getSimpleName()));
    }

    public static boolean e(qf.d d0, String s) {
        String s1 = d0.a;
        if(v.r0(s1, s, false)) {
            String s2 = s1.substring(s.length());
            q.f(s2, "substring(...)");
            if(!Tf.o.U0(s2, '0')) {
                Integer integer0 = v.t0(s2);
                return integer0 != null && ((int)integer0) >= 23;
            }
        }
        return false;
    }

    // 去混淆评级： 低(30)
    public static b f(qf.d d0) {
        q.g(d0, "kotlinFqName");
        if(d.e(d0, "kotlin.Function") || d.e(d0, "kotlin.coroutines.SuspendFunction")) {
            return d.e;
        }
        return !d.e(d0, "kotlin.reflect.KFunction") && !d.e(d0, "kotlin.reflect.KSuspendFunction") ? ((b)d.i.get(d0)) : d.g;
    }
}

