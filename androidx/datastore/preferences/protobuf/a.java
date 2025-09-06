package androidx.datastore.preferences.protobuf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class A extends a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = 0x7FFFFFFF;
    private static final int MUTABLE_FLAG_MASK = 0x80000000;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = 0x7FFFFFFF;
    private static Map defaultInstanceMap;
    private int memoizedSerializedSize;
    protected l0 unknownFields;

    static {
        A.defaultInstanceMap = new ConcurrentHashMap();
    }

    public A() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = l0.f;
    }

    @Override  // androidx.datastore.preferences.protobuf.a
    public final int a(e0 e00) {
        int v2;
        int v;
        if(this.f()) {
            if(e00 == null) {
                b0.c.getClass();
                Class class0 = this.getClass();
                v = b0.c.a(class0).g(this);
            }
            else {
                v = e00.g(this);
            }
            if(v < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + v);
            }
            return v;
        }
        int v1 = this.memoizedSerializedSize;
        if((v1 & 0x7FFFFFFF) != 0x7FFFFFFF) {
            return v1 & 0x7FFFFFFF;
        }
        if(e00 == null) {
            b0.c.getClass();
            Class class1 = this.getClass();
            v2 = b0.c.a(class1).g(this);
        }
        else {
            v2 = e00.g(this);
        }
        this.j(v2);
        return v2;
    }

    public abstract Object b(int arg1);

    public static A c(Class class0) {
        A a0 = (A)A.defaultInstanceMap.get(class0);
        if(a0 == null) {
            try {
                Class.forName(class0.getName(), true, class0.getClassLoader());
            }
            catch(ClassNotFoundException classNotFoundException0) {
                throw new IllegalStateException("Class initialization cannot fail.", classNotFoundException0);
            }
            a0 = (A)A.defaultInstanceMap.get(class0);
        }
        if(a0 == null) {
            A a1 = (A)((A)r0.d(class0)).b(6);
            if(a1 == null) {
                throw new IllegalStateException();
            }
            A.defaultInstanceMap.put(class0, a1);
            return a1;
        }
        return a0;
    }

    public static Object d(Method method0, A a0, Object[] arr_object) {
        try {
            return method0.invoke(a0, arr_object);
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

    public static final boolean e(A a0, boolean z) {
        int v = (byte)(((Byte)a0.b(1)));
        if(v == 1) {
            return true;
        }
        if(v == 0) {
            return false;
        }
        b0.c.getClass();
        Class class0 = a0.getClass();
        boolean z1 = b0.c.a(class0).c(a0);
        if(z) {
            a0.b(2);
        }
        return z1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null || this.getClass() != object0.getClass()) {
            return false;
        }
        b0.c.getClass();
        Class class0 = this.getClass();
        return b0.c.a(class0).i(this, ((A)object0));
    }

    public final boolean f() {
        return (this.memoizedSerializedSize & 0x80000000) != 0;
    }

    public final void g() {
        this.memoizedSerializedSize &= 0x7FFFFFFF;
    }

    public final A h() {
        return (A)this.b(4);
    }

    @Override
    public final int hashCode() {
        if(this.f()) {
            b0.c.getClass();
            Class class0 = this.getClass();
            return b0.c.a(class0).h(this);
        }
        if(this.memoizedHashCode == 0) {
            b0.c.getClass();
            Class class1 = this.getClass();
            this.memoizedHashCode = b0.c.a(class1).h(this);
        }
        return this.memoizedHashCode;
    }

    public static void i(Class class0, A a0) {
        a0.g();
        A.defaultInstanceMap.put(class0, a0);
    }

    public final void j(int v) {
        if(v < 0) {
            throw new IllegalStateException("serialized size must be non-negative, was " + v);
        }
        this.memoizedSerializedSize = v & 0x7FFFFFFF | this.memoizedSerializedSize & 0x80000000;
    }

    public final void k(o o0) {
        b0.c.getClass();
        Class class0 = this.getClass();
        b0.c.a(class0).e(this, (o0.j == null ? new M(o0) : o0.j));
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("# ");
        stringBuilder0.append(super.toString());
        U.c(this, stringBuilder0, 0);
        return stringBuilder0.toString();
    }
}

