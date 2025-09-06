package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public abstract class q0 {
    public final Unsafe a;

    public q0(Unsafe unsafe0) {
        this.a = unsafe0;
    }

    public final int a(Class class0) {
        return this.a.arrayBaseOffset(class0);
    }

    public final int b(Class class0) {
        return this.a.arrayIndexScale(class0);
    }

    public abstract boolean c(long arg1, Object arg2);

    public abstract double d(long arg1, Object arg2);

    public abstract float e(long arg1, Object arg2);

    public final int f(Object object0, long v) {
        return this.a.getInt(object0, v);
    }

    public final long g(Object object0, long v) {
        return this.a.getLong(object0, v);
    }

    public final Object h(Object object0, long v) {
        return this.a.getObject(object0, v);
    }

    public final long i(Field field0) {
        return this.a.objectFieldOffset(field0);
    }

    public abstract void j(Object arg1, long arg2, boolean arg3);

    public abstract void k(Object arg1, long arg2, byte arg3);

    public abstract void l(Object arg1, long arg2, double arg3);

    public abstract void m(Object arg1, long arg2, float arg3);

    public final void n(int v, long v1, Object object0) {
        this.a.putInt(object0, v1, v);
    }

    public final void o(Object object0, long v, long v1) {
        this.a.putLong(object0, v, v1);
    }

    public final void p(Object object0, long v, Object object1) {
        this.a.putObject(object0, v, object1);
    }

    public boolean q() {
        Class class0 = Class.class;
        Class class1 = Object.class;
        Unsafe unsafe0 = this.a;
        if(unsafe0 == null) {
            return false;
        }
        try {
            Class class2 = unsafe0.getClass();
            class2.getMethod("objectFieldOffset", Field.class);
            class2.getMethod("arrayBaseOffset", class0);
            class2.getMethod("arrayIndexScale", class0);
            Class class3 = Long.TYPE;
            class2.getMethod("getInt", class1, class3);
            class2.getMethod("putInt", class1, class3, Integer.TYPE);
            class2.getMethod("getLong", class1, class3);
            class2.getMethod("putLong", class1, class3, class3);
            class2.getMethod("getObject", class1, class3);
            class2.getMethod("putObject", class1, class3, class1);
            return true;
        }
        catch(Throwable throwable0) {
            r0.a(throwable0);
            return false;
        }
    }

    public abstract boolean r();
}

