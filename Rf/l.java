package rf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import k8.Y;

public final class l {
    public final a a;
    public final Object b;
    public final a c;
    public final k d;
    public final Method e;

    public l(a a0, Object object0, a a1, k k0, Class class0) {
        if(a0 == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if(k0.b == J.f && a1 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.a = a0;
        this.b = object0;
        this.c = a1;
        this.d = k0;
        if(n.class.isAssignableFrom(class0)) {
            try {
                this.e = class0.getMethod("valueOf", Integer.TYPE);
                return;
            }
            catch(NoSuchMethodException noSuchMethodException0) {
                String s = class0.getName();
                throw new RuntimeException(Y.l(new StringBuilder(s.length() + 52), "Generated message class \"", s, "\" missing method \"valueOf\"."), noSuchMethodException0);
            }
        }
        this.e = null;
    }

    public final Object a(Object object0) {
        if(this.d.b.a == K.i) {
            Object[] arr_object = {((Integer)object0)};
            try {
                return this.e.invoke(null, arr_object);
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw new RuntimeException("Couldn\'t use Java reflection to implement protocol message reflection.", illegalAccessException0);
            }
            catch(InvocationTargetException invocationTargetException0) {
                Throwable throwable0 = invocationTargetException0.getCause();
                if(throwable0 instanceof RuntimeException) {
                    throw (RuntimeException)throwable0;
                }
                if(throwable0 instanceof Error) {
                    throw (Error)throwable0;
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", throwable0);
            }
        }
        return object0;
    }

    public final Object b(Object object0) {
        return this.d.b.a == K.i ? ((n)object0).a() : object0;
    }
}

