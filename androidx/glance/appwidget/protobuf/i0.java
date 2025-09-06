package androidx.glance.appwidget.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public abstract class i0 {
    public static final Unsafe a;
    public static final Class b;
    public static final h0 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final boolean g;

    static {
        Unsafe unsafe0 = i0.i();
        i0.a = unsafe0;
        i0.b = c.a;
        i0.h(Long.TYPE);
        i0.h(Integer.TYPE);
        h0 h00 = null;
        if(unsafe0 != null) {
            h00 = new g0(unsafe0);  // 初始化器: Landroidx/glance/appwidget/protobuf/h0;-><init>(Lsun/misc/Unsafe;)V
        }
        i0.c = h00;
        boolean z = false;
        i0.d = h00 == null ? false : h00.r();
        i0.e = h00 == null ? false : h00.q();
        i0.f = (long)i0.e(byte[].class);
        i0.e(boolean[].class);
        i0.f(boolean[].class);
        i0.e(int[].class);
        i0.f(int[].class);
        i0.e(long[].class);
        i0.f(long[].class);
        i0.e(float[].class);
        i0.f(float[].class);
        i0.e(double[].class);
        i0.f(double[].class);
        i0.e(Object[].class);
        i0.f(Object[].class);
        Field field0 = i0.g();
        if(field0 != null && h00 != null) {
            h00.i(field0);
        }
        if(ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z = true;
        }
        i0.g = z;
    }

    public static void a(Throwable throwable0) {
        Logger.getLogger("androidx.glance.appwidget.protobuf.i0").log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + throwable0);
    }

    public static boolean b(long v, Object object0) {
        return ((byte)(i0.c.f(object0, -4L & v) >>> ((int)((~v & 3L) << 3)) & 0xFF)) != 0;
    }

    public static boolean c(long v, Object object0) {
        return ((byte)(i0.c.f(object0, -4L & v) >>> ((int)((v & 3L) << 3)) & 0xFF)) != 0;
    }

    public static Object d(Class class0) {
        try {
            return i0.a.allocateInstance(class0);
        }
        catch(InstantiationException instantiationException0) {
            throw new IllegalStateException(instantiationException0);
        }
    }

    // 去混淆评级： 低(20)
    public static int e(Class class0) {
        return i0.e ? i0.c.a(class0) : -1;
    }

    public static void f(Class class0) {
        if(i0.e) {
            i0.c.b(class0);
        }
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
            return (Unsafe)AccessController.doPrivileged(new e0());  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    public static void j(byte[] arr_b, long v, byte b) {
        i0.c.k(arr_b, i0.f + v, b);
    }

    public static void k(Object object0, long v, byte b) {
        int v1 = (~((int)v) & 3) << 3;
        i0.m((0xFF & b) << v1 | i0.c.f(object0, -4L & v) & ~(0xFF << v1), -4L & v, object0);
    }

    public static void l(Object object0, long v, byte b) {
        int v1 = (((int)v) & 3) << 3;
        i0.m((0xFF & b) << v1 | i0.c.f(object0, -4L & v) & ~(0xFF << v1), -4L & v, object0);
    }

    public static void m(int v, long v1, Object object0) {
        i0.c.n(v, v1, object0);
    }

    public static void n(Object object0, long v, long v1) {
        i0.c.o(object0, v, v1);
    }

    public static void o(Object object0, long v, Object object1) {
        i0.c.p(object0, v, object1);
    }
}

