package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public abstract class r0 {
    public static final Unsafe a;
    public static final Class b;
    public static final q0 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final boolean g;

    static {
        Unsafe unsafe0 = r0.i();
        r0.a = unsafe0;
        r0.b = c.a;
        r0.h(Long.TYPE);
        r0.h(Integer.TYPE);
        q0 q00 = null;
        if(unsafe0 != null) {
            q00 = new p0(unsafe0);  // 初始化器: Landroidx/datastore/preferences/protobuf/q0;-><init>(Lsun/misc/Unsafe;)V
        }
        r0.c = q00;
        boolean z = false;
        r0.d = q00 == null ? false : q00.r();
        r0.e = q00 == null ? false : q00.q();
        r0.f = (long)r0.e(byte[].class);
        r0.e(boolean[].class);
        r0.f(boolean[].class);
        r0.e(int[].class);
        r0.f(int[].class);
        r0.e(long[].class);
        r0.f(long[].class);
        r0.e(float[].class);
        r0.f(float[].class);
        r0.e(double[].class);
        r0.f(double[].class);
        r0.e(Object[].class);
        r0.f(Object[].class);
        Field field0 = r0.g();
        if(field0 != null && q00 != null) {
            q00.i(field0);
        }
        if(ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z = true;
        }
        r0.g = z;
    }

    public static void a(Throwable throwable0) {
        Logger.getLogger("androidx.datastore.preferences.protobuf.r0").log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + throwable0);
    }

    public static boolean b(long v, Object object0) {
        return ((byte)(r0.c.f(object0, -4L & v) >>> ((int)((~v & 3L) << 3)) & 0xFF)) != 0;
    }

    public static boolean c(long v, Object object0) {
        return ((byte)(r0.c.f(object0, -4L & v) >>> ((int)((v & 3L) << 3)) & 0xFF)) != 0;
    }

    public static Object d(Class class0) {
        try {
            return r0.a.allocateInstance(class0);
        }
        catch(InstantiationException instantiationException0) {
            throw new IllegalStateException(instantiationException0);
        }
    }

    public static int e(Class class0) {
        return -1;
    }

    public static void f(Class class0) {
    }

    public static Field g() {
        Field field0 = null;
        try {
            field0 = Buffer.class.getDeclaredField("address");
        }
        catch(Throwable unused_ex) {
        }
        return field0 == null || field0.getType() != Long.TYPE ? null : field0;
    }

    // 去混淆评级： 低(30)
    public static boolean h(Class class0) {
        return false;
    }

    public static Unsafe i() {
        try {
            return (Unsafe)AccessController.doPrivileged(new n0());  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    public static void j(byte[] arr_b, long v, byte b) {
        r0.c.k(arr_b, r0.f + v, b);
    }

    public static void k(Object object0, long v, byte b) {
        int v1 = (~((int)v) & 3) << 3;
        r0.m((0xFF & b) << v1 | r0.c.f(object0, -4L & v) & ~(0xFF << v1), -4L & v, object0);
    }

    public static void l(Object object0, long v, byte b) {
        int v1 = (((int)v) & 3) << 3;
        r0.m((0xFF & b) << v1 | r0.c.f(object0, -4L & v) & ~(0xFF << v1), -4L & v, object0);
    }

    public static void m(int v, long v1, Object object0) {
        r0.c.n(v, v1, object0);
    }

    public static void n(Object object0, long v, long v1) {
        r0.c.o(object0, v, v1);
    }

    public static void o(Object object0, long v, Object object1) {
        r0.c.p(object0, v, object1);
    }
}

