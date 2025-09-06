package M6;

import a.a;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

public final class o extends a {
    public static final Unsafe g;
    public static final long h;
    public static final long i;
    public static final long j;
    public static final long k;
    public static final long l;

    static {
        Unsafe unsafe0;
        Class class0;
        try {
            class0 = p.class;
            unsafe0 = Unsafe.getUnsafe();
        }
        catch(SecurityException unused_ex) {
            try {
                unsafe0 = (Unsafe)AccessController.doPrivileged(() -> {
                    Class class0 = Unsafe.class;
                    Field[] arr_field = class0.getDeclaredFields();
                    for(int v = 0; v < arr_field.length; ++v) {
                        Field field0 = arr_field[v];
                        field0.setAccessible(true);
                        Object object0 = field0.get(null);
                        if(class0.isInstance(object0)) {
                            return (Unsafe)class0.cast(object0);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                });
            }
            catch(PrivilegedActionException privilegedActionException0) {
                throw new RuntimeException("Could not initialize intrinsics", privilegedActionException0.getCause());
            }
        }
        try {
            o.i = unsafe0.objectFieldOffset(q.class.getDeclaredField("c"));
            o.h = unsafe0.objectFieldOffset(q.class.getDeclaredField("b"));
            o.j = unsafe0.objectFieldOffset(q.class.getDeclaredField("a"));
            o.k = unsafe0.objectFieldOffset(class0.getDeclaredField("a"));
            o.l = unsafe0.objectFieldOffset(class0.getDeclaredField("b"));
            o.g = unsafe0;
        }
        catch(NoSuchFieldException noSuchFieldException0) {
            throw new RuntimeException(noSuchFieldException0);
        }
    }

    @Override  // a.a
    public final void K(p p0, p p1) {
        o.g.putObject(p0, o.l, p1);
    }

    @Override  // a.a
    public final void L(p p0, Thread thread0) {
        o.g.putObject(p0, o.k, thread0);
    }

    // 检测为 Lambda 实现
    public static Unsafe Q() [...]

    @Override  // a.a
    public final boolean l(h h0, e e0, e e1) {
        return k.a(o.g, h0, o.h, e0, e1);
    }

    @Override  // a.a
    public final boolean m(h h0, Object object0, Object object1) {
        return l.a(o.g, h0, o.j, object0, object1);
    }

    @Override  // a.a
    public final boolean n(q q0, p p0, p p1) {
        return m.a(o.g, q0, o.i, p0, p1);
    }

    @Override  // a.a
    public final e t(h h0) {
        e e1;
        e e0 = e.d;
        do {
            e1 = h0.b;
        }
        while(e0 != e1 && !this.l(h0, e1, e0));
        return e1;
    }

    @Override  // a.a
    public final p u(h h0) {
        p p1;
        p p0 = p.c;
        do {
            p1 = h0.c;
        }
        while(p0 != p1 && !this.n(h0, p1, p0));
        return p1;
    }
}

