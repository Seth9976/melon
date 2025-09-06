package Se;

import B.a;
import Me.a0;
import Me.d0;
import Me.g0;
import gf.b;
import gf.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import je.w;
import kotlin.jvm.internal.q;
import qf.e;
import qf.g;

public abstract class v extends r implements b, c {
    @Override  // gf.b
    public final d a(qf.c c0) {
        q.g(c0, "fqName");
        Member member0 = this.b();
        q.e(member0, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        Annotation[] arr_annotation = ((AnnotatedElement)member0).getDeclaredAnnotations();
        return arr_annotation == null ? null : a.v(arr_annotation, c0);
    }

    public abstract Member b();

    public final e c() {
        String s = this.b().getName();
        return s == null ? g.a : e.e(s);
    }

    public final ArrayList d(Type[] arr_type, Annotation[][] arr2_annotation, boolean z) {
        String s;
        y y0;
        h h0;
        ArrayList arrayList1;
        E9.g g1;
        Method method0;
        ArrayList arrayList0 = new ArrayList(arr_type.length);
        Se.a a0 = Se.a.a;
        Member member0 = this.b();
        q.g(member0, "member");
        E9.g g0 = Se.a.b;
        if(g0 == null) {
            synchronized(a0) {
                g0 = Se.a.b;
                if(g0 == null) {
                    Class class0 = member0.getClass();
                    try {
                        method0 = class0.getMethod("getParameters", null);
                    }
                    catch(NoSuchMethodException unused_ex) {
                        g1 = new E9.g(null, null);
                        goto label_16;
                    }
                    g1 = new E9.g(method0, Se.c.d(class0).loadClass("java.lang.reflect.Parameter").getMethod("getName", null));
                label_16:
                    Se.a.b = g1;
                    g0 = g1;
                }
            }
        }
        Method method1 = (Method)g0.a;
        if(method1 == null) {
            arrayList1 = null;
        }
        else {
            Method method2 = (Method)g0.b;
            if(method2 == null) {
                arrayList1 = null;
            }
            else {
                Object object0 = method1.invoke(member0, null);
                q.e(object0, "null cannot be cast to non-null type kotlin.Array<*>");
                arrayList1 = new ArrayList(((Object[])object0).length);
                for(int v1 = 0; v1 < ((Object[])object0).length; ++v1) {
                    Object object1 = method2.invoke(((Object[])object0)[v1], null);
                    q.e(object1, "null cannot be cast to non-null type kotlin.String");
                    arrayList1.add(((String)object1));
                }
            }
        }
        int v2 = arrayList1 == null ? 0 : arrayList1.size() - arr_type.length;
        for(int v3 = 0; v3 < arr_type.length; ++v3) {
            Type type0 = arr_type[v3];
            q.g(type0, "type");
            boolean z1 = type0 instanceof Class;
            if(!z1 || !((Class)type0).isPrimitive()) {
                if(type0 instanceof GenericArrayType || z1 && ((Class)type0).isArray()) {
                    h0 = new h(type0);
                }
                else if(type0 instanceof WildcardType) {
                    h0 = new D(((WildcardType)type0));
                }
                else {
                    h0 = new p(type0);
                }
                y0 = h0;
            }
            else {
                y0 = new y(((Class)type0));
            }
            if(arrayList1 == null) {
                s = null;
            }
            else {
                s = (String)je.p.n0(v3 + v2, arrayList1);
                if(s == null) {
                    throw new IllegalStateException(("No parameter with index " + v3 + '+' + v2 + " (name=" + this.c() + " type=" + y0 + ") in " + this).toString());
                }
            }
            arrayList0.add(new C(y0, arr2_annotation[v3], s, z && v3 == arr_type.length - 1));
        }
        return arrayList0;
    }

    public final g0 e() {
        int v = this.b().getModifiers();
        if(Modifier.isPublic(v)) {
            return d0.c;
        }
        if(Modifier.isPrivate(v)) {
            return a0.c;
        }
        if(Modifier.isProtected(v)) {
            return Modifier.isStatic(v) ? Qe.c.c : Qe.b.c;
        }
        return Qe.a.c;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof v && q.b(this.b(), ((v)object0).b());
    }

    @Override  // gf.b
    public final Collection getAnnotations() {
        Member member0 = this.b();
        q.e(member0, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        Annotation[] arr_annotation = ((AnnotatedElement)member0).getDeclaredAnnotations();
        return arr_annotation != null ? a.y(arr_annotation) : w.a;
    }

    @Override
    public final int hashCode() {
        return this.b().hashCode();
    }

    @Override
    public final String toString() {
        return this.getClass().getName() + ": " + this.b();
    }
}

