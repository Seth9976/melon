package kotlin.jvm.internal;

import De.d;
import Ge.e;
import e.k;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import je.C;
import we.a;
import we.b;
import we.c;
import we.f;
import we.i;
import we.j;
import we.l;
import we.m;
import we.n;
import we.o;
import we.p;
import we.q;
import we.r;
import we.s;
import we.t;
import we.u;

public final class h implements d, g {
    public final Class a;
    public static final Map b;

    static {
        Iterable iterable0 = k.A(new Class[]{a.class, we.k.class, n.class, o.class, p.class, q.class, r.class, s.class, t.class, u.class, b.class, c.class, e.class, we.d.class, we.e.class, f.class, we.g.class, we.h.class, i.class, j.class, l.class, m.class, e.class});
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        int v = 0;
        for(Object object0: iterable0) {
            if(v >= 0) {
                arrayList0.add(new ie.m(((Class)object0), v));
                ++v;
                continue;
            }
            k.O();
            throw null;
        }
        h.b = C.Y(arrayList0);
    }

    public h(Class class0) {
        kotlin.jvm.internal.q.g(class0, "jClass");
        super();
        this.a = class0;
    }

    @Override  // kotlin.jvm.internal.g
    public final Class c() {
        return this.a;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof h && df.d.w(this).equals(df.d.w(((d)object0)));
    }

    @Override  // De.d
    public final int hashCode() {
        return df.d.w(this).hashCode();
    }

    @Override  // De.d
    public final boolean j() {
        throw new ve.a();
    }

    @Override  // De.d
    public final boolean k(Object object0) {
        Class class0 = this.a;
        kotlin.jvm.internal.q.g(class0, "jClass");
        kotlin.jvm.internal.q.e(h.b, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer integer0 = (Integer)h.b.get(class0);
        if(integer0 != null) {
            return N.g(integer0.intValue(), object0);
        }
        if(class0.isPrimitive()) {
            class0 = df.d.w(df.d.y(class0));
        }
        return class0.isInstance(object0);
    }

    @Override  // De.d
    public final String l() {
        Class class0 = this.a;
        kotlin.jvm.internal.q.g(class0, "jClass");
        String s = null;
        if(class0.isAnonymousClass() || class0.isLocalClass()) {
            return null;
        }
        if(class0.isArray()) {
            Class class1 = class0.getComponentType();
            if(class1.isPrimitive()) {
                String s1 = N.f(class1.getName());
                if(s1 != null) {
                    s = s1 + "Array";
                }
            }
            return s == null ? "kotlin.Array" : s;
        }
        String s2 = N.f(class0.getName());
        return s2 == null ? class0.getCanonicalName() : s2;
    }

    @Override  // De.d
    public final String m() {
        Class class0 = this.a;
        kotlin.jvm.internal.q.g(class0, "jClass");
        String s = null;
        if(class0.isAnonymousClass()) {
            return null;
        }
        if(class0.isLocalClass()) {
            String s1 = class0.getSimpleName();
            Method method0 = class0.getEnclosingMethod();
            if(method0 != null) {
                return Tf.o.X0(s1, method0.getName() + '$');
            }
            Constructor constructor0 = class0.getEnclosingConstructor();
            return constructor0 == null ? Tf.o.W0('$', s1, s1) : Tf.o.X0(s1, constructor0.getName() + '$');
        }
        if(class0.isArray()) {
            Class class1 = class0.getComponentType();
            if(class1.isPrimitive()) {
                String s2 = N.h(class1.getName());
                if(s2 != null) {
                    s = s2 + "Array";
                }
            }
            return s == null ? "Array" : s;
        }
        String s3 = N.h(class0.getName());
        return s3 == null ? class0.getSimpleName() : s3;
    }

    @Override
    public final String toString() {
        return this.a + " (Kotlin reflection is not available)";
    }
}

