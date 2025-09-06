package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public abstract class Y2 {
    public static final Unsafe a;
    public static final Class b;
    public static final X2 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final long g;
    public static final boolean h;

    static {
        Unsafe unsafe0 = Y2.j();
        Y2.a = unsafe0;
        Y2.b = d.a;
        Y2.f(Long.TYPE);
        Y2.f(Integer.TYPE);
        X2 x20 = null;
        if(unsafe0 != null) {
            x20 = new W2(unsafe0);  // 初始化器: Lcom/google/protobuf/X2;-><init>(Lsun/misc/Unsafe;)V
        }
        Y2.c = x20;
        boolean z = false;
        Y2.d = x20 == null ? false : x20.u();
        Y2.e = x20 == null ? false : x20.t();
        Y2.f = (long)Y2.c(byte[].class);
        Y2.c(boolean[].class);
        Y2.d(boolean[].class);
        Y2.c(int[].class);
        Y2.d(int[].class);
        Y2.c(long[].class);
        Y2.d(long[].class);
        Y2.c(float[].class);
        Y2.d(float[].class);
        Y2.c(double[].class);
        Y2.d(double[].class);
        Y2.c(Object[].class);
        Y2.d(Object[].class);
        Field field0 = Y2.e();
        Y2.g = field0 == null || x20 == null ? -1L : x20.l(field0);
        if(ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z = true;
        }
        Y2.h = z;
    }

    public static void a(Throwable throwable0) {
        Logger.getLogger("com.google.protobuf.Y2").log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + throwable0);
    }

    public static Object b(Class class0) {
        try {
            return Y2.a.allocateInstance(class0);
        }
        catch(InstantiationException instantiationException0) {
            throw new IllegalStateException(instantiationException0);
        }
    }

    public static int c(Class class0) {
        return -1;
    }

    public static void d(Class class0) {
    }

    public static Field e() {
        Field field0 = null;
        try {
            field0 = Buffer.class.getDeclaredField("address");
        }
        catch(Throwable unused_ex) {
        }
        return field0 == null || field0.getType() != Long.TYPE ? null : field0;
    }

    // 去混淆评级： 低(30)
    public static boolean f(Class class0) {
        return false;
    }

    public static byte g(byte[] arr_b, long v) {
        return Y2.c.f(Y2.f + v, arr_b);
    }

    public static byte h(long v, Object object0) {
        return (byte)(Y2.c.i(object0, -4L & v) >>> ((int)((~v & 3L) << 3)) & 0xFF);
    }

    public static byte i(long v, Object object0) {
        return (byte)(Y2.c.i(object0, -4L & v) >>> ((int)((v & 3L) << 3)) & 0xFF);
    }

    public static Unsafe j() {
        try {
            return (Unsafe)AccessController.doPrivileged(new U2());  // 初始化器: Ljava/lang/Object;-><init>()V
        }
        catch(Throwable unused_ex) {
            return null;
        }
    }

    public static void k(byte[] arr_b, long v, byte b) {
        Y2.c.n(arr_b, Y2.f + v, b);
    }

    public static void l(Object object0, long v, byte b) {
        int v1 = (~((int)v) & 3) << 3;
        Y2.n((0xFF & b) << v1 | Y2.c.i(object0, -4L & v) & ~(0xFF << v1), -4L & v, object0);
    }

    public static void m(Object object0, long v, byte b) {
        int v1 = (((int)v) & 3) << 3;
        Y2.n((0xFF & b) << v1 | Y2.c.i(object0, -4L & v) & ~(0xFF << v1), -4L & v, object0);
    }

    public static void n(int v, long v1, Object object0) {
        Y2.c.q(v, v1, object0);
    }

    public static void o(Object object0, long v, long v1) {
        Y2.c.r(object0, v, v1);
    }

    public static void p(Object object0, long v, Object object1) {
        Y2.c.s(object0, v, object1);
    }
}

