package io.netty.util.internal.shaded.org.jctools.util;

import sun.misc.Unsafe;

public final class UnsafeRefArrayAccess {
    public static final long REF_ARRAY_BASE;
    public static final int REF_ELEMENT_SHIFT;

    static {
        Unsafe unsafe0 = UnsafeAccess.UNSAFE;
        Class class0 = Object[].class;
        int v = unsafe0.arrayIndexScale(class0);
        if(4 == v) {
            UnsafeRefArrayAccess.REF_ELEMENT_SHIFT = 2;
        }
        else if(8 == v) {
            UnsafeRefArrayAccess.REF_ELEMENT_SHIFT = 3;
        }
        else {
            throw new IllegalStateException("Unknown pointer size: " + v);
        }
        UnsafeRefArrayAccess.REF_ARRAY_BASE = (long)unsafe0.arrayBaseOffset(class0);
    }

    public static Object[] allocateRefArray(int v) {
        return new Object[v];
    }

    public static long calcCircularRefElementOffset(long v, long v1) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((v & v1) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }

    public static long calcRefElementOffset(long v) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + (v << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }

    public static Object lpRefElement(Object[] arr_object, long v) {
        return UnsafeAccess.UNSAFE.getObject(arr_object, v);
    }

    public static Object lvRefElement(Object[] arr_object, long v) {
        return UnsafeAccess.UNSAFE.getObjectVolatile(arr_object, v);
    }

    public static void soRefElement(Object[] arr_object, long v, Object object0) {
        UnsafeAccess.UNSAFE.putOrderedObject(arr_object, v, object0);
    }

    public static void spRefElement(Object[] arr_object, long v, Object object0) {
        UnsafeAccess.UNSAFE.putObject(arr_object, v, object0);
    }
}

