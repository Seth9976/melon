package Se;

import gf.d;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.q;
import x9.c;
import y5.a;

public final class z extends v {
    public final Object a;

    public z(Object object0) {
        q.g(object0, "recordComponent");
        super();
        this.a = object0;
    }

    @Override  // Se.v
    public final Member b() {
        Object object0 = this.a;
        q.g(object0, "recordComponent");
        c c0 = a.e;
        Member member0 = null;
        if(c0 == null) {
            Class class0 = object0.getClass();
            try {
                c0 = new c(3, class0.getMethod("getType", null), class0.getMethod("getAccessor", null));
            }
            catch(NoSuchMethodException unused_ex) {
                c0 = new c(3, null, null);
            }
            a.e = c0;
        }
        Method method0 = (Method)c0.c;
        if(method0 != null) {
            Object object1 = method0.invoke(object0, null);
            q.e(object1, "null cannot be cast to non-null type java.lang.reflect.Method");
            member0 = (Method)object1;
        }
        if(member0 == null) {
            throw new NoSuchMethodError("Can\'t find `getAccessor` method");
        }
        return member0;
    }

    public final d f() {
        Object object0 = this.a;
        q.g(object0, "recordComponent");
        c c0 = a.e;
        Class class0 = null;
        if(c0 == null) {
            Class class1 = object0.getClass();
            try {
                c0 = new c(3, class1.getMethod("getType", null), class1.getMethod("getAccessor", null));
            }
            catch(NoSuchMethodException unused_ex) {
                c0 = new c(3, null, null);
            }
            a.e = c0;
        }
        Method method0 = (Method)c0.b;
        if(method0 != null) {
            Object object1 = method0.invoke(object0, null);
            q.e(object1, "null cannot be cast to non-null type java.lang.Class<*>");
            class0 = (Class)object1;
        }
        if(class0 == null) {
            throw new NoSuchMethodError("Can\'t find `getType` method");
        }
        return new p(class0);
    }
}

