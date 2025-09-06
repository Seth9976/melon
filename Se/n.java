package Se;

import Ac.q0;
import B.a;
import Sf.g;
import Tf.o;
import com.google.firebase.messaging.u;
import gf.b;
import gf.c;
import gf.e;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import je.w;
import kotlin.jvm.internal.q;

public final class n extends r implements b, c, e {
    public final Class a;

    public n(Class class0) {
        q.g(class0, "klass");
        super();
        this.a = class0;
    }

    @Override  // gf.b
    public final d a(qf.c c0) {
        q.g(c0, "fqName");
        Class class0 = this.a;
        if(class0 != null) {
            Annotation[] arr_annotation = class0.getDeclaredAnnotations();
            return arr_annotation == null ? null : a.v(arr_annotation, c0);
        }
        return null;
    }

    public final Collection b() {
        Field[] arr_field = this.a.getDeclaredFields();
        q.f(arr_field, "getDeclaredFields(...)");
        return Sf.n.p0(Sf.n.n0(new g(je.n.O(arr_field), false, k.b), l.b));
    }

    public final qf.c c() {
        return Se.c.a(this.a).a();
    }

    public final Collection d() {
        Method[] arr_method = this.a.getDeclaredMethods();
        q.f(arr_method, "getDeclaredMethods(...)");
        return Sf.n.p0(Sf.n.n0(new g(je.n.O(arr_method), true, new q0(this, 14)), m.b));
    }

    public final qf.e e() {
        Class class0 = this.a;
        if(class0.isAnonymousClass()) {
            String s = class0.getName();
            return qf.e.e(o.Z0(s, ".", s));
        }
        return qf.e.e(class0.getSimpleName());
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof n && q.b(this.a, ((n)object0).a);
    }

    public final ArrayList f() {
        Class class0 = this.a;
        q.g(class0, "clazz");
        u u0 = ye.a.d;
        Object[] arr_object = null;
        if(u0 == null) {
            try {
                u0 = new u(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
            }
            catch(NoSuchMethodException unused_ex) {
                u0 = new u(null, null, null, null);
            }
            ye.a.d = u0;
        }
        Method method0 = (Method)u0.d;
        if(method0 != null) {
            arr_object = (Object[])method0.invoke(class0, null);
        }
        if(arr_object == null) {
            arr_object = new Object[0];
        }
        ArrayList arrayList0 = new ArrayList(arr_object.length);
        for(int v = 0; v < arr_object.length; ++v) {
            arrayList0.add(new z(arr_object[v]));
        }
        return arrayList0;
    }

    public final boolean g() {
        Class class0 = this.a;
        q.g(class0, "clazz");
        u u0 = ye.a.d;
        Boolean boolean0 = null;
        if(u0 == null) {
            try {
                u0 = new u(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
            }
            catch(NoSuchMethodException unused_ex) {
                u0 = new u(null, null, null, null);
            }
            ye.a.d = u0;
        }
        Method method0 = (Method)u0.c;
        if(method0 != null) {
            Object object0 = method0.invoke(class0, null);
            q.e(object0, "null cannot be cast to non-null type kotlin.Boolean");
            boolean0 = (Boolean)object0;
        }
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    @Override  // gf.b
    public final Collection getAnnotations() {
        Class class0 = this.a;
        if(class0 != null) {
            Annotation[] arr_annotation = class0.getDeclaredAnnotations();
            if(arr_annotation != null) {
                return a.y(arr_annotation);
            }
        }
        return w.a;
    }

    @Override  // gf.e
    public final ArrayList getTypeParameters() {
        TypeVariable[] arr_typeVariable = this.a.getTypeParameters();
        q.f(arr_typeVariable, "getTypeParameters(...)");
        ArrayList arrayList0 = new ArrayList(arr_typeVariable.length);
        for(int v = 0; v < arr_typeVariable.length; ++v) {
            arrayList0.add(new B(arr_typeVariable[v]));
        }
        return arrayList0;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    // 去混淆评级： 低(40)
    @Override
    public final String toString() {
        return "Se.n: " + this.a;
    }
}

