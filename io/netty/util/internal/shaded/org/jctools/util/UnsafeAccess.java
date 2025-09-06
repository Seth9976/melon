package io.netty.util.internal.shaded.org.jctools.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class UnsafeAccess {
    public static final boolean SUPPORTS_GET_AND_ADD_LONG;
    public static final boolean SUPPORTS_GET_AND_SET_REF;
    public static final Unsafe UNSAFE;

    static {
        UnsafeAccess.UNSAFE = UnsafeAccess.getUnsafe();
        UnsafeAccess.SUPPORTS_GET_AND_SET_REF = UnsafeAccess.hasGetAndSetSupport();
        UnsafeAccess.SUPPORTS_GET_AND_ADD_LONG = UnsafeAccess.hasGetAndAddLongSupport();
    }

    public static long fieldOffset(Class class0, String s) {
        try {
            Field field0 = class0.getDeclaredField(s);
            return UnsafeAccess.UNSAFE.objectFieldOffset(field0);
        }
        catch(NoSuchFieldException noSuchFieldException0) {
            throw new RuntimeException(noSuchFieldException0);
        }
    }

    private static Unsafe getUnsafe() {
        try {
            Field field0 = Unsafe.class.getDeclaredField("theUnsafe");
            field0.setAccessible(true);
            return (Unsafe)field0.get(null);
        }
        catch(Exception unused_ex) {
            try {
                Constructor constructor0 = Unsafe.class.getDeclaredConstructor(null);
                constructor0.setAccessible(true);
                return (Unsafe)constructor0.newInstance(null);
            }
            catch(Exception exception0) {
                throw new RuntimeException(exception0);
            }
        }
    }

    private static boolean hasGetAndAddLongSupport() {
        try {
            Unsafe.class.getMethod("getAndAddLong", Object.class, Long.TYPE, Long.TYPE);
            return true;
        }
        catch(Exception unused_ex) {
            return false;
        }
    }

    private static boolean hasGetAndSetSupport() {
        try {
            Unsafe.class.getMethod("getAndSetObject", Object.class, Long.TYPE, Object.class);
            return true;
        }
        catch(Exception unused_ex) {
            return false;
        }
    }
}

